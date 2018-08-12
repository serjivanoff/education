package jdbc.dataset;

import javax.persistence.*;

/**
 * Created by bender on 11.08.2018.
 */
@Entity
@Table(name = "phones", schema = "otus")
public class PhoneDataSet extends DataSet {
    @Column(name = "phone")
    private String phone;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserDataSet user;

    public PhoneDataSet() {
    }

    public PhoneDataSet(String phone) {
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public UserDataSet getUser() {
        return user;
    }

    public void setUser(UserDataSet user) {
        this.user = user;
    }
}
