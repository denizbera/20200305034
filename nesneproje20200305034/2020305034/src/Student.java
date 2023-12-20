class Student extends Person implements Attendee {

    Student(String name, String surname, int number, String phone, String mail) {

        super(name, surname, number, phone, mail);

    }

    @Override
    public void setMarkAttendee() {

        System.out.println(name + " " + surname + " (Student ID: " + number + ") attended the class.");

    }

}
