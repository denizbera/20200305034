class Person {

    String name;

    String surname;

    int number;

    String phone;
    String mail;

    Person(String name, String surname, int number,String phone, String mail) {

        this.name = name;

        this.surname = surname;

        this.number = number;

        this.phone = phone;

        this.mail = mail;

    }

    private void markAttendance() {

        System.out.println("parent function to override");

    }

    void introduce() {

        System.out.println("Hello, my name is " + name + " " + surname + " (ID: " + number + ")");

    }

}
