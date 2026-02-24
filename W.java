import java.util.*;
import java.io.*;

public class W {

    private HashMap<String, C> customers = new HashMap<>();

    public void add(String n, int a, int u, String r) {
        customers.put(n.toLowerCase(), new C(n, a, u, r));
    }

    public void remove(String n) {
        customers.remove(n.toLowerCase());
    }

    public C get(String n) {
        return customers.get(n.toLowerCase());
    }

    public void change(String n, String field, String value) {
        C c = get(n);
        if (c == null) return;

        switch (field.toLowerCase()) {
            case "name":
                customers.remove(n.toLowerCase());
                c.setName(value);
                customers.put(value.toLowerCase(), c);
                break;
            case "age":
                c.setAge(Integer.parseInt(value));
                break;
            case "units":
                c.setUnits(Integer.parseInt(value));
                break;
            case "residence":
                c.setResidence(value);
                break;
        }
    }

    public void printBill(C c) {
        if (c == null) {
            System.out.println("Customer not found");
            return;
        }

        double bill = c.calculateBill();

        System.out.println("==================================================");
        System.out.println("                 WATER BILL");
        System.out.println("==================================================");
        System.out.println("Name      : " + c.getName());
        System.out.println("Age       : " + c.getAge());
        System.out.println("Residence : " + c.getResidence());
        System.out.println("Units     : " + c.getUnits());
        System.out.println("Total ₹   : " + bill);
        System.out.println("==================================================");
    }

    public void list() {
        if (customers.isEmpty()) {
            System.out.println("No customers");
            return;
        }

        int i = 1;
        for (C c : customers.values()) {
            System.out.println(i++ + ". " + c.getName());
        }
    }

    public void sortByUnits() {
        List<C> list = new ArrayList<>(customers.values());
        list.sort(Comparator.comparingInt(C::getUnits));

        for (C c : list) {
            System.out.println(c.getName() + " - " + c.getUnits());
        }
    }

    public void search(String keyword) {
        boolean found = false;
        for (C c : customers.values()) {
            if (c.getName().toLowerCase().contains(keyword.toLowerCase())) {
                System.out.println(c.getName());
                found = true;
            }
        }
        if (!found) System.out.println("No match");
    }

    public void stats() {
        if (customers.isEmpty()) {
            System.out.println("No data");
            return;
        }

        double totalUnits = 0;
        double maxBill = 0;

        for (C c : customers.values()) {
            totalUnits += c.getUnits();
            maxBill = Math.max(maxBill, c.calculateBill());
        }

        System.out.println("Total customers: " + customers.size());
        System.out.println("Average units: " + (totalUnits / customers.size()));
        System.out.println("Highest bill: ₹" + maxBill);
    }
}