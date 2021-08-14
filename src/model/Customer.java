package model;

import java.util.Objects;
import java.util.regex.Pattern;

public class Customer {

    private String firstName;
    private String lastName;
    private String email;

    public Customer(String email, String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;

        final String emailRegex = "^(.+)@(.+).(.+)$";
        final Pattern pattern = Pattern.compile(emailRegex);

            if (pattern.matcher(email).matches()) {

                this.email = email;

            } else {
                throw new IllegalArgumentException();
            }

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

        final String emailRegex = "^(.+)@(.+).(.+)$";
        final Pattern pattern = Pattern.compile(emailRegex);

        if (pattern.matcher(email).matches()) {

            this.email = email;

        } else {
            throw new IllegalArgumentException();
        }

    }

    @Override
    public String toString() {
        return  "***********************************" + "\n"
                + "First Name: " + firstName + "\n" +
                "Last Name: " + lastName + "\n" +
                "Email: " + email + "\n"
                ;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer)) return false;
        Customer customer = (Customer) o;
        return getFirstName().equals(customer.getFirstName()) && getLastName().equals(customer.getLastName()) && getEmail().equals(customer.getEmail());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFirstName(), getLastName(), getEmail());
    }
}
