package entities;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

/**
 * Created by Tom Veniat on 24/03/15.
 */
@Entity
@Table(name="USERS")
@Access(AccessType.PROPERTY)
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public abstract class User {

    protected String email;
    protected String firstName;
    protected String lastName;

    public User() {
        this.email = "";
        this.firstName = "";
        this.lastName = "";
    }

    public User(String email, String firstname, String lastname) {
        this.email = email;
        this.firstName = firstname;
        this.lastName = lastname;
    }

    @Override
    public int hashCode() {
        int result = getEmail() != null ? getEmail().hashCode() : 0;
        result = 31 * result + (getFirstName() != null ? getFirstName().hashCode() : 0);
        result = 31 * result + (getLastName() != null ? getLastName().hashCode() : 0);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (!getEmail().equals(user.getEmail())) return false;
        if (!getFirstName().equals(user.getFirstName())) return false;
        if (!getLastName().equals(user.getLastName())) return false;

        return true;
    }

    @Id
    @Column(name="USER_EMAIL")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    @Override
    public String toString() {
        return "User : "+getFirstName()+" "+getLastName()+" : "+getEmail()+".";
    }
}
