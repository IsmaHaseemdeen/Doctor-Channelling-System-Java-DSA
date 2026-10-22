import java.util.Scanner;

public class DoctorChannellingSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PQueue patientQueue = new PQueue();
        DQueue doctorQueue = new DQueue();
        AQueue appointmentQueue = new AQueue();

        String option = "";

        System.out.println("******* Doctor Channelling System *******");

        while (!option.equals("10")) {
            System.out.println("======= Menu =======");
            System.out.println("1. Register a Patient");
            System.out.println("2. Display active Patients list");
            System.out.println("3. Register a Doctor");
            System.out.println("4. Display active Doctors list");
            System.out.println("5. Search for a Doctor");
            System.out.println("6. Make an Appointment");
            System.out.println("7. Cancel an Appointment (by Appointment ID)");
            System.out.println("8. Request to Reschedule an Appointment (by Appointment ID)");
            System.out.println("9. Display current Appointments");
            System.out.println("10. Exit");
            System.out.print("Enter your choice from 1-10: ");

            option = sc.nextLine().trim();

            if (option.equals("1")) {
                patientQueue.register(sc);
            } 
            else if (option.equals("2")) {
                patientQueue.display();
            } 
            else if (option.equals("3")) {
                doctorQueue.register(sc);
            } 
            else if (option.equals("4")) {
                doctorQueue.display();
            } 
            else if (option.equals("5")) {
                System.out.print("Enter the Doctor ID to search for the Doctor: ");
                String docId = sc.nextLine().trim();
                Doctor foundDoc = doctorQueue.search(docId);
                if (foundDoc != null)
                    foundDoc.display();
                else
                    System.out.println("Doctor not found, please enter a valid ID");
            } 
            else if (option.equals("6")) {
                appointmentQueue.bookAppointment(patientQueue, doctorQueue, sc);
            } 
            else if (option.equals("7")) {
                appointmentQueue.cancelAppointment(sc);
            } 
            else if (option.equals("8")) {
                appointmentQueue.rescheduleAppointment(sc, patientQueue, doctorQueue);
            } 
            else if (option.equals("9")) {
                appointmentQueue.displayAppointments();
            } 
            else if (option.equals("10")) {
                System.out.println("Exiting the system. Thank you!");
            } 
            else {
                System.out.println("Invalid choice, Please enter a number between 1 and 10.");
            }
        }

        sc.close();
    }
}
