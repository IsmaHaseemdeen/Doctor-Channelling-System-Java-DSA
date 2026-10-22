class Patient {
    String id, name, city, history;
    int age;

    public Patient(String id, String name, int age, String city, String history) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.city = city;
        this.history = history;
    }

    public void display() {
        System.out.println(name + " | Age: " + age + " | ID: " + id + " | City: " + city + " | History: " + history);
    }
}

public class BubbleSortPatients {

    public static void bubbleSort(Patient[] patients) {
        int n = patients.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (patients[j].age > patients[j + 1].age) {
                    Patient temp = patients[j];
                    patients[j] = patients[j + 1];
                    patients[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        Patient[] patients = {
            new Patient("P001", "Ali", 45, "Kandy", "Asthma"),
            new Patient("P002", "Nisha", 30, "Colombo", "Diabetes"),
            new Patient("P003", "Saman", 55, "Galle", "Heart issue"),
            new Patient("P004", "Rekha", 25, "Jaffna", "Migraine")
        };

        System.out.println("Before Bubble Sort:");
        for (Patient p : patients) p.display();

        bubbleSort(patients);

        System.out.println("\nAfter Bubble Sort (by Age):");
        for (Patient p : patients) p.display();
    }
}
