import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class InsuranceService {
    private List<Insurance> insurances = new ArrayList<>();
    private List<Purchase> purchases = new ArrayList<>();
    private PaymentService paymentService;

    @Autowired
    public InsuranceService(PaymentService paymentService) {
        this.paymentService = paymentService;
        // Sample insurances
        insurances.add(new Insurance(1L, "Health Plus", 500.0, "Comprehensive health coverage", 18, 60, "ANY", 30000));
        insurances.add(new Insurance(2L, "Life Secure", 300.0, "Life insurance plan", 25, 70, "MALE", 40000));
    }

    public List<Insurance> getAllInsurances(User user) {
        return insurances.stream()
                .filter(i -> user.getAge() >= i.getMinAge() && user.getAge() <= i.getMaxAge())
                .filter(i -> i.getTargetGender().equals("ANY") || i.getTargetGender().equals(user.getGender()))
                .filter(i -> user.getIncome() >= i.getMinIncome())
                .collect(Collectors.toList());
    }

    public Purchase purchaseInsurance(Long userId, Long insuranceId, double amount) {
        Insurance insurance = insurances.stream()
                .filter(i -> i.getId().equals(insuranceId))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Insurance not found"));

        String transactionId = paymentService.processPayment(amount);

        Purchase purchase = new Purchase(
                (long) (purchases.size() + 1),
                userId,
                insuranceId,
                transactionId,
                LocalDateTime.now().toString()
        );
        purchases.add(purchase);
        return purchase;
    }

    public Purchase getPurchaseById(Long purchaseId) {
        return purchases.stream()
                .filter(p -> p.getId().equals(purchaseId))
                .findFirst()
                .orElse(null);
    }
}