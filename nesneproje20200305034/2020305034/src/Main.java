
import java.util.*;

public class Main {

    public static void MenuLoopFunction() {
        Scanner scanner = new Scanner(System.in);

        Student student1 = new Student("Will", "Smith", 123, "0555 444 33 22", "test@test.com");
        Student student2 = new Student("Bill", "Gates", 007,"0555 444 33 22", "test@test.com");
        Teacher teacher = new Teacher("Elon", "Musk", 10,"0555 444 33 22", "test@test.com");

        AttendanceSystem<Attendee> attendanceSystem = new AttendanceSystem<>();
        attendanceSystem.addAttendee(student1);
        attendanceSystem.addAttendee(student2);
        attendanceSystem.addAttendee(teacher);

        // Sonsuz Menu
        while (true) {
            System.out.println("\n--- Sinif Ici Yoklama Sistemi Loop Menu ---");
            System.out.println("1. Tüm Katılımcıları Listele");
            System.out.println("2.  Öğrenci Ekle");
            System.out.println("3.  Bilgilerin Güncelle");
            System.out.println("4. Geç Katılım Olustur");
            System.out.println("5. Yoklama listesini Bas");
            System.out.println("6. Çıkış");

            System.out.print("Seçiminizi yapın: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Boş satırı oku

            switch (choice) {
                case 1:
                    // Tüm katılımcıların yoklamasını alıp raporlama
                    attendanceSystem.markAllAttendance();
                    break;
                case 2:
                    // Yeni öğrenci ekleme
                    System.out.print("Yeni öğrencinin adını girin: ");
                    String newStudentName = scanner.nextLine();
                    System.out.print("Yeni öğrencinin soyadını girin: ");
                    String newStudentSurname = scanner.nextLine();
                    System.out.print("Yeni öğrencinin numarasını girin: ");
                    int newStudentNumber = scanner.nextInt();
                    System.out.print("Yeni öğrencinin Telefon Numarasini girin: ");
                    String phone = scanner.nextLine();
                    System.out.print("Yeni öğrencinin Mail adresini girin: ");
                    String mail = scanner.nextLine();
                    Student newStudent = new Student(newStudentName, newStudentSurname, newStudentNumber, phone, mail);
                    attendanceSystem.addAttendee(newStudent);
                    System.out.println(newStudentName + " " + newStudentSurname + " öğrencisi eklendi.");
                    break;
                case 3:
                    // Öğrenci bilgilerini güncelleme
                    System.out.print("Güncellenecek öğrencinin numarasını girin: ");
                    int updateStudentNumber = scanner.nextInt();
                    scanner.nextLine(); // Boş satırı oku
                    for (Attendee attendee : attendanceSystem.attendees) {
                        if (attendee instanceof Student && ((Student) attendee).number == updateStudentNumber) {
                            System.out.print("Yeni adı girin: ");
                            ((Student) attendee).name = scanner.nextLine();
                            System.out.print("Yeni soyadı girin: ");
                            ((Student) attendee).surname = scanner.nextLine();
                            System.out.println("Öğrenci bilgileri güncellendi.");
                            break;
                        }
                    }
                    break;
                case 4:
                    // Geç katılım ekleme
                    System.out.print("Geç katılım eklemek istediğiniz öğrencinin numarasını girin: ");
                    int lateStudentNumber = scanner.nextInt();
                    scanner.nextLine(); // Boş satırı oku
                    for (Attendee attendee : attendanceSystem.attendees) {
                        if (attendee instanceof Student && ((Student) attendee).number == lateStudentNumber) {
                            ((Student) attendee).setMarkAttendee(); // Geç katılımı işaretle
                            break;
                        }
                    }
                    break;
                case 5:
                    printStudentData();
                case 6:
                    // Çıkış
                    System.out.println("Programdan çıkılıyor...");
                    System.exit(0);
                default:
                    System.out.println("Geçersiz seçim, lütfen tekrar deneyin.");
            }
        }
    }

    public static <T> void checkSignIN(T userid, T password) {

        SingleLineLambdaInterface ErrorCred = () -> System.out.println("Wrong credentials!");
        // generic method implementation
        if(userid.equals("deniz") && password.equals("1234")){
            MenuLoopFunction();
        }else{
            ErrorCred.apply();
        }
    }
    // lambda function interface

    public static void printStudentData() {
        String[] names = {"John", "Alice", "Bob", "Eva", "Michael", "Sophia", "Daniel", "Olivia", "Liam", "Emma",
                "Mason", "Ava", "Noah", "Isabella", "William", "Sophie", "Alexander", "Oliver", "Chloe", "Lily"};

        String[] surnames = {"Doe", "Smith", "Johnson", "Williams", "Brown", "Davis", "Miller", "Jones", "Garcia", "Rodriguez",
                "Martinez", "Hernandez", "Lopez", "Torres", "Young", "Wright", "King", "Scott", "Green", "Baker"};

        int[] studentNumbers = {101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120};

        String[] phoneNumbers = {"555-1234", "555-5678", "555-9876", "555-4321", "555-8765", "555-2345", "555-6789", "555-3456", "555-7890", "555-4567",
                "555-8901", "555-5678", "555-9012", "555-6789", "555-0123", "555-7890", "555-3456", "555-8901", "555-4567", "555-9012"};

        String[] emails = {"john.doe@example.com", "alice.smith@example.com", "bob.johnson@example.com", "eva.williams@example.com", "michael.brown@example.com",
                "sophia.davis@example.com", "daniel.miller@example.com", "olivia.jones@example.com", "liam.garcia@example.com", "emma.rodriguez@example.com",
                "mason.martinez@example.com", "ava.hernandez@example.com", "noah.lopez@example.com", "isabella.torres@example.com", "william.young@example.com",
                "sophie.wright@example.com", "alexander.king@example.com", "oliver.scott@example.com", "chloe.green@example.com", "lily.baker@example.com"};

        System.out.println("---- Öğrenci Yoklama Listesi ----");
        for (int i = 0; i < 20; i++) {
            System.out.println("Ad: " + names[i]);
            System.out.println("Soyad: " + surnames[i]);
            System.out.println("Öğrenci Numarası: " + studentNumbers[i]);
            System.out.println("Telefon Numarası: " + phoneNumbers[i]);
            System.out.println("E-posta Adresi: " + emails[i]);
            System.out.println();
        }
    }

    public static void main(String[] args) {


        // lambda function implementation
        SingleLineLambdaInterface EnterPassPrint = () -> System.out.println("Please enter password");

        // lambda function implementation


        Scanner in = new Scanner(System.in);

        System.out.println("Kullanici Giris Ekrani");
        System.out.println("Lutfen UserID giriniz:");
        String userid = in.nextLine();

        EnterPassPrint.apply();
        String password = in.nextLine();

        checkSignIN(userid, password);


    }

}
