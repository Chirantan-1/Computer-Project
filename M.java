import java.util.*;

public class M {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        W w = new W();

        boolean running = true;

        while (running) {
            System.out.println("\nadd remove print change list sort search stats save exit");
            String cmd = s.nextLine().toLowerCase();

            try {

                switch (cmd) {

                case "add":
                    System.out.print("Name: ");
                    String name = s.nextLine();

                    System.out.print("Age: ");
                    int age = Integer.parseInt(s.nextLine());

                    System.out.print("Units: ");
                    int units = Integer.parseInt(s.nextLine());

                    System.out.print("Residence: ");
                    String residence = s.nextLine();

                    w.add(name, age, units, residence);
                    break;

                case "remove":
                    System.out.print("Name: ");
                    w.remove(s.nextLine());
                    break;

                case "print":
                    System.out.print("Name: ");
                    w.printBill(w.get(s.nextLine()));
                    break;

                case "change":
                    System.out.print("Name: ");
                    String changeName = s.nextLine();
                    System.out.print("Field (name/age/units/residence): ");
                    String field = s.nextLine();

                    System.out.print("New value: ");
                    String value = s.nextLine();

                    w.change(changeName, field, value);
                    break;

                case "list":
                    w.list();
                    break;

                case "sort":
                    w.sortByUnits();
                    break;

                case "search":
                    System.out.print("Keyword: ");
                    w.search(s.nextLine());
                    break;

                case "stats":
                    w.stats();
                    break;

                case "exit":
                    running = false;
                    break;

                default:
                    System.out.println("Invalid command");
                }

            } catch (Exception e) {
                System.out.println("Error occurred");
            }
        }

        s.close();
    }
}