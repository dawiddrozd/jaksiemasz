import com.google.common.base.Preconditions;

public class Person{

    private final String name;
    private final String surname;
    private final String email;

    Person (String name, String surname, String email) {

        Preconditions.checkArgument(surname.matches("[1-9]+[0-9]*"),"Wrong surname: " + surname);
        Preconditions.checkArgument(name.matches("[a-zA-Z]+"),"Wrong name: " + name);
        Preconditions.checkArgument(email.matches("^([_a-zA-Z0-9-]+(\\.[_a-zA-Z0-9-]+)*@[a-zA-Z0-9-]+" +
                "(\\.[a-zA-Z0-9-]+)*(\\.[a-zA-Z]{1,6}))?$"),"Wrong email: " + email);

        this.name = name;
        this.surname = surname;
        this.email=email;
    }

    @Override
    public String toString() {
        return name + " " + surname + " " + email;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }
}