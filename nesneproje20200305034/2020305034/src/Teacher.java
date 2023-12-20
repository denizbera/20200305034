class Teacher extends Person implements Attendee {

    Teacher(String name, String surname, int number, String phone, String mail) {

        super(name, surname, number, phone, mail);

    }

    @Override
    public void setMarkAttendee() {
        System.out.println(name + " " + surname + " (Teacher ID: " + number + ") marked attendance.");

    }

    void teach() {

        System.out.println(name + " " + surname + " is teaching.");

    }

}
