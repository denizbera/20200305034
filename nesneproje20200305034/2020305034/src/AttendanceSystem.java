import java.util.ArrayList;
import java.util.List;

class AttendanceSystem<T extends Attendee> {

    List<T> attendees;

    AttendanceSystem() {

        this.attendees = new ArrayList<>();

    }

    void addAttendee(T attendee) {

        attendees.add(attendee);

    }

    void markAllAttendance() {

        for (T attendee : attendees) {

            attendee.setMarkAttendee();

        }

    }

}