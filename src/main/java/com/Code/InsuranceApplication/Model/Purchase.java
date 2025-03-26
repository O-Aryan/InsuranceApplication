public class Purchase {
    private Long id;
    private Long userId;
    private Long insuranceId;
    private String transactionId;
    private String purchaseDate;

    public Purchase(Long id, Long userId, Long insuranceId, String transactionId, String purchaseDate) {
        this.id = id;
        this.userId = userId;
        this.insuranceId = insuranceId;
        this.transactionId = transactionId;
        this.purchaseDate = purchaseDate;
    }

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }
    public Long getInsuranceId() { return insuranceId; }
    public void setInsuranceId(Long insuranceId) { this.insuranceId = insuranceId; }
    public String getTransactionId() { return transactionId; }
    public void setTransactionId(String transactionId) { this.transactionId = transactionId; }
    public String getPurchaseDate() { return purchaseDate; }
    public void setPurchaseDate(String purchaseDate) { this.purchaseDate = purchaseDate; }
}