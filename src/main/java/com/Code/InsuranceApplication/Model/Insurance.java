public class Insurance {
    private Long id;
    private String name;
    private double premium;
    private String description;
    private int minAge;
    private int maxAge;
    private String targetGender; // "MALE", "FEMALE", "ANY"
    private double minIncome;

    public Insurance(Long id, String name, double premium, String description, int minAge, int maxAge, String targetGender, double minIncome) {
        this.id = id;
        this.name = name;
        this.premium = premium;
        this.description = description;
        this.minAge = minAge;
        this.maxAge = maxAge;
        this.targetGender = targetGender;
        this.minIncome = minIncome;
    }

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public double getPremium() { return premium; }
    public void setPremium(double premium) { this.premium = premium; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public int getMinAge() { return minAge; }
    public void setMinAge(int minAge) { this.minAge = minAge; }
    public int getMaxAge() { return maxAge; }
    public void setMaxAge(int maxAge) { this.maxAge = maxAge; }
    public String getTargetGender() { return targetGender; }
    public void setTargetGender(String targetGender) { this.targetGender = targetGender; }
    public double getMinIncome() { return minIncome; }
    public void setMinIncome(double minIncome) { this.minIncome = minIncome; }
}