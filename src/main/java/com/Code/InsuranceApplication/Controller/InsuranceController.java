import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/insurances")
public class InsuranceController {
    @Autowired
    private InsuranceService insuranceService;
    @Autowired
    private UserService userService;
    @Autowired
    private PdfService pdfService;

    @GetMapping
    public ResponseEntity<List<Insurance>> getAllInsurances(@RequestParam Long userId) {
        User user = userService.getUserById(userId);
        if (user == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        List<Insurance> insurances = insuranceService.getAllInsurances(user);
        return ResponseEntity.ok(insurances);
    }

    @PostMapping("/{insuranceId}/purchase")
    public ResponseEntity<Purchase> purchaseInsurance(
            @PathVariable Long insuranceId,
            @RequestParam Long userId,
            @RequestParam double amount) {
        try {
            Purchase purchase = insuranceService.purchaseInsurance(userId, insuranceId, amount);
            return ResponseEntity.ok(purchase);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @GetMapping("/policy/{purchaseId}")
    public ResponseEntity<byte[]> downloadPolicy(@PathVariable Long purchaseId) {
        Purchase purchase = insuranceService.getPurchaseById(purchaseId);
        if (purchase == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        byte[] pdfBytes = pdfService.generatePolicyDocument(purchase);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDispositionFormData("attachment", "policy.pdf");
        return new ResponseEntity<>(pdfBytes, headers, HttpStatus.OK);
    }
}