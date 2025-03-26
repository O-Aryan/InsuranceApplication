public class User {
    private Long id;
    private String name;
    private int age;
    private String gender; // "MALE", "FEMALE"
    private double income;

    public User(Long id, String name, int age, String gender, double income) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.income = income;
    }

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }
    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }
    public double getIncome() { return income; }
    public void setIncome(double income) { this.income = income; }
}