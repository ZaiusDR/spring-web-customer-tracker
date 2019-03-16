package info.esuarez.springwebcustomertracker.entity;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import static info.esuarez.springwebcustomertracker.validators.ValidationConstants.NOT_VALID_EMAIL;
import static info.esuarez.springwebcustomertracker.validators.ValidationConstants.REQUIRED_FIELD_MESSAGE;

@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @NotBlank(message = REQUIRED_FIELD_MESSAGE)
    @Column(name = "first_name")
    private String firstName;

    @NotBlank(message = REQUIRED_FIELD_MESSAGE)
    @Column(name = "last_name")
    private String lastName;

    @NotBlank(message = REQUIRED_FIELD_MESSAGE)
    @Email(message = NOT_VALID_EMAIL)
    @Column(name = "email")
    private String email;

    public Customer() {
    }

    public Customer(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
