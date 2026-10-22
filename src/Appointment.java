import java.util.Scanner;

public class Appointment {
    static int counter = 1; 
    String appointmentId;          
    Patient patient;
    Doctor doctor;
    String slot;

    public Appointment(Patient patient, Doctor doctor, String slot) {
        this.appointmentId = String.format("DCS%02d", counter++);
        this.patient = patient;
        this.doctor = doctor;
        this.slot = slot;
    }
}

class AQueue {
    Node<Appointment> head, tail;           
    Node<Appointment> waitHead, waitTail;   

    public void bookAppointment(PQueue pq, DQueue dq, Scanner sc) {
        System.out.print("Enter the Patient ID: ");
        String pid = sc.nextLine().trim();
        if (pid.isEmpty()) {
            System.out.println("Error: Patient ID cannot be empty, please fill it");
            return;
        }

        Patient patient = pq.search(pid);
        if (patient == null) {
            System.out.println("Error: Patient not found, please enter a valid ID");
            return;
        }

        System.out.print("Enter Doctor ID: ");
        String did = sc.nextLine().trim();
        if (did.isEmpty()) {
            System.out.println("Error: Doctor ID cannot be empty, please fill it");
            return;
        }

        Doctor doctor = dq.search(did);
        if (doctor == null) {
            System.out.println("Error: Doctor not found, please enter a valid ID");
            return;
        }

        if (doctor.hasAvailableSlot()) {
            String slot = doctor.assignSlot();
            Appointment app = new Appointment(patient, doctor, slot);
            Node<Appointment> newNode = new Node<>(app);

            if (tail == null) head = tail = newNode;
            else {
                tail.next = newNode;
                tail = newNode;
            }

            System.out.println("Appointment booked successfully!");
            System.out.println("Appointment ID: " + app.appointmentId +
                               " | Patient: " + patient.name +
                               " | Doctor: " + doctor.name +
                               " | Slot: " + slot);
        } else {
            Appointment waitingApp = new Appointment(patient, doctor, null);
            Node<Appointment> waitNode = new Node<>(waitingApp);

            if (waitTail == null) waitHead = waitTail = waitNode;
            else {
                waitTail.next = waitNode;
                waitTail = waitNode;
            }

            System.out.println("All slots are full. Patient is added to the waiting list.");
        }
    }

    public void cancelAppointment(Scanner sc) {
        System.out.print("Enter the Appointment ID to cancel the appointment: ");
        String appId = sc.nextLine().trim();
        if (appId.isEmpty()) {
            System.out.println("Error: Appointment ID cannot be empty, please fill it");
            return;
        }

        Node<Appointment> node = head;
        Node<Appointment> previous = null;

        while (node != null) {
            if (node.data.appointmentId.equalsIgnoreCase(appId)) {
                Doctor doc = node.data.doctor;
                String slot = node.data.slot;

                doc.freeSlot(slot);

                if (previous == null) head = node.next;
                else previous.next = node.next;

                if (node == tail) tail = previous;

                System.out.println("Appointment " + appId + " cancelled successfully.");

                assignFromWaitingList(doc, slot);
                return;
            }
            previous = node;
            node = node.next;
        }

        System.out.println("Error: No appointment found with the given ID.");
    }

    private void assignFromWaitingList(Doctor doctor, String freedSlot) {
        Node<Appointment> node = waitHead;
        Node<Appointment> previous = null;

        while (node != null) {
            if (node.data.doctor.id.equalsIgnoreCase(doctor.id)) {
                node.data.slot = freedSlot;
                int slotIndex = java.util.Arrays.asList(doctor.slots).indexOf(freedSlot);
                doctor.slotTaken[slotIndex] = true;

                Node<Appointment> newAppNode = new Node<>(node.data);
                if (tail == null) head = tail = newAppNode;
                else {
                    tail.next = newAppNode;
                    tail = newAppNode;
                }

                if (previous == null) waitHead = node.next;
                else previous.next = node.next;

                if (node == waitTail) waitTail = previous;

                System.out.println("Waiting patient assigned to freed slot:");
                System.out.println("Appointment ID: " + node.data.appointmentId +
                                   " | Patient: " + node.data.patient.name +
                                   " | Doctor: " + doctor.name +
                                   " | Slot: " + freedSlot);
                return;
            }
            previous = node;
            node = node.next;
        }
    }

    public void rescheduleAppointment(Scanner sc, PQueue pq, DQueue dq) {
        System.out.print("Enter Appointment ID to reschedule the appointment: ");
        String appId = sc.nextLine().trim();
        if (appId.isEmpty()) {
            System.out.println("Error: Appointment ID cannot be empty, please fill it");
            return;
        }

        Node<Appointment> node = head;
        Node<Appointment> previous = null;
        Appointment toReschedule = null;

        while (node != null) {
            if (node.data.appointmentId.equalsIgnoreCase(appId)) {
                toReschedule = node.data;

                if (previous == null) head = node.next;
                else previous.next = node.next;

                if (node == tail) tail = previous;
                break;
            }
            previous = node;
            node = node.next;
        }

        if (toReschedule == null) {
            System.out.println("Error: No appointment found with this ID.");
            return;
        }

        Doctor doc = toReschedule.doctor;
        doc.freeSlot(toReschedule.slot);

        Appointment waitApp = new Appointment(toReschedule.patient, doc, null);
        Node<Appointment> waitNode = new Node<>(waitApp);

        if (waitTail == null) waitHead = waitTail = waitNode;
        else {
            waitTail.next = waitNode;
            waitTail = waitNode;
        }

        System.out.println("Appointment " + appId + " cancelled and moved to waiting list for rescheduling.");
    }

    public void displayAppointments() {
        System.out.println("Scheduled Appointments:");
        Node<Appointment> node = head;

        if (node == null) {
            System.out.println("No appointments currently scheduled.");
            return;
        }

        while (node != null) {
            System.out.println("ID: " + node.data.appointmentId +
                               " | Patient: " + node.data.patient.name +
                               " | Doctor: " + node.data.doctor.name +
                               " | Slot: " + node.data.slot);
            node = node.next;
        }
    }
}
