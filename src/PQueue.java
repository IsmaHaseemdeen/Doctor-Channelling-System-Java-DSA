
import java.util.Scanner;

class PQueue {
    private Node<Patient> head, tail;

    public void register(Scanner sc) {
        System.out.print("Patient ID: ");
        String id = sc.nextLine().trim();

        if (id.isEmpty() || search(id) != null) {
            System.out.println("Invalid or duplicate patient ID.");
            return;
        }

        System.out.print("Patient name: ");
        String name = sc.nextLine().trim();

        if (name.isEmpty()) {
            System.out.println("Patient name cannot be empty.");
            return;
        }

        System.out.print("Age: ");
        int age;

        try {
            age = Integer.parseInt(sc.nextLine().trim());
            if (age < 0 || age > 130) {
                throw new NumberFormatException();
            }
        } catch (NumberFormatException e) {
            System.out.println("Enter a valid age.");
            return;
        }

        System.out.print("City: ");
        String city = sc.nextLine().trim();

        System.out.print("Medical history (demo data only): ");
        String history = sc.nextLine().trim();

        Node<Patient> node = new Node<>(
            new Patient(id, name, age, city, history)
        );

        if (tail == null) {
            head = tail = node;
        } else {
            tail.next = node;
            tail = node;
        }

        System.out.println("Patient registered successfully.");
    }

    public Patient search(String id) {
        for (Node<Patient> node = head;
             node != null;
             node = node.next) {

            if (node.data.id.equalsIgnoreCase(id)) {
                return node.data;
            }
        }
        return null;
    }

    public void display() {
        if (head == null) {
            System.out.println("No patients registered.");
            return;
        }

        for (Node<Patient> node = head;
             node != null;
             node = node.next) {

            node.data.display();
        }
    }
}
