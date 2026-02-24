public class C {
    private String name;
    private int age;
    private int units;
    private String residence;

    public C(String name, int age, int units, String residence) {
        this.name = name;
        this.age = age;
        this.units = units;
        this.residence = residence;
    }

    public String getName() { return name; }
    public int getAge() { return age; }
    public int getUnits() { return units; }
    public String getResidence() { return residence; }

    public void setName(String name) { this.name = name; }
    public void setAge(int age) { this.age = age; }
    public void setUnits(int units) { this.units = units; }
    public void setResidence(String residence) { this.residence = residence; }

    public double calculateBill() {
        if (units <= 100) return units * 2;
        if (units <= 300) return 100 * 2 + (units - 100) * 3;
        return 100 * 2 + 200 * 3 + (units - 300) * 5;
    }
}