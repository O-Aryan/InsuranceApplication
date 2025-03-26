import org.springframework.stereotype.Service;
import java.util.UUID;

@Service
public class PaymentService {
    public String processPayment(double amount) {
        // Simulate payment gateway
        return UUID.randomUUID().toString();
    }
}