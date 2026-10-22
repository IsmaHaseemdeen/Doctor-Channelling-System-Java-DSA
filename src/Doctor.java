import java.util.Scanner;

public class Doctor {
    String id, name, specialization;
    String[] slots = new String[5];          
    boolean[] slotTaken = new boolean[5];   
    double fee;
    Doctor next;  
	
    public Doctor(String id, String name, String specialization, String[] slots, double fee) {
        this.id = id;
        this.name = name;
        this.specialization = specialization;
        this.slots = slots;
        this.fee = fee;
        this.slotTaken = new boolean[slots.length]; 
        this.next = null;
    }

    public void display() {
        System.out.println("Doctor ID: " + id + ", Name: " + name + ", Specialization: " + specialization + ", Fee: Rs. " + fee);
        System.out.print("Available Slots: ");
        for (int i = 0; i < slots.length; i++) {
            if (!slotTaken[i]) {
                System.out.print(slots[i] + " ");
            }
        }
        System.out.println();
    }

    public boolean hasAvailableSlot() {
        for (boolean taken : slotTaken) {
            if (!taken) return true;
        }
        return false;
    }
	
    public String assignSlot() {
        for (int i = 0; i < slots.length; i++) {
            if (!slotTaken[i]) {
                slotTaken[i] = true;
                return slots[i];
            }
        }
        return null; 
    }

    public void freeSlot(String slot) {
        for (int i = 0; i < slots.length; i++) {
            if (slots[i].equals(slot)) {
                slotTaken[i] = false;
                break;
            }
        }
    }
}

class DQueue {
    private Doctor head, tail;

    public void register(Scanner sc) {
        System.out.print("Enter the Doctor ID: ");
        String id = sc.nextLine().trim();
        if (id.isEmpty()) {
            System.out.println("Error: Doctor ID cannot be empty, please fill it");
            return;
        }
        if (search(id) != null) {
            System.out.println("Error: Doctor ID already exists. Please use a unique ID.");
            return;
        }

        System.out.print("Enter the Doctor Name: ");
        String name = sc.nextLine().trim();
        if (name.isEmpty()) {
            System.out.println("Error: Doctor name cannot be empty, please fill it");
            return;
        }

        System.out.print("Enter the Specialization: ");
        String specialization = sc.nextLine().trim();
        if (specialization.isEmpty()) {
            System.out.println("Error: Specialization cannot be empty, please fill it");
            return;
        }

        String[] slots = {"No1:09am", "No2:9.30am", "No3:10am", "No4:10.30am", "No5:11am"}; 

        System.out.print("Enter the Consultation Fee: ");
        double fee;
        try {
            String feeInput = sc.nextLine().trim();
            if (feeInput.isEmpty()) {
                System.out.println("Error: Fee cannot be empty, please fill it");
                return;
            }
            fee = Double.parseDouble(feeInput);
            if (fee < 0) {
                System.out.println("Error: Fee must be a positive value, please correct it");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("Error: Fee must be a valid number, please correct it");
            return;
        }

        Doctor newDoctor = new Doctor(id, name, specialization, slots, fee);

        if (tail == null) {
            head = tail = newDoctor;  
        } else {
            tail.next = newDoctor;    
            tail = newDoctor;
        }

        System.out.println("Doctor registered successfully!!");
    }

    public Doctor search(String id) {
        Doctor node = head;
        while (node != null) {
            if (node.id.equalsIgnoreCase(id)) {
                return node;
            }
            node = node.next;
        }
        return null;
    }

    public void display() {
        if (head == null) {
            System.out.println("No doctors registered yet.");
            return;
        }

        Doctor node = head;
        while (node != null) {
            node.display();
            node = node.next;
        }
    }
}
