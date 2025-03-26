import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import org.springframework.stereotype.Service;
import java.io.ByteArrayOutputStream;

@Service
public class PdfService {
    public byte[] generatePolicyDocument(Purchase purchase) {
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            PdfWriter writer = new PdfWriter(baos);
            PdfDocument pdf = new PdfDocument(writer);
            Document document = new Document(pdf);

            document.add(new Paragraph("Policy Document"));
            document.add(new Paragraph("Transaction ID: " + purchase.getTransactionId()));
            document.add(new Paragraph("Insurance ID: " + purchase.getInsuranceId()));
            document.add(new Paragraph("Purchase Date: " + purchase.getPurchaseDate()));

            document.close();
            return baos.toByteArray();
        } catch (Exception e) {
            throw new RuntimeException("Error generating PDF", e);
        }
    }
}