package my.education.webapplication.jdbc.dataset;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by bender on 11.08.2018.
 */
@Entity
@Table(name = "addresses", schema = "otus")
public class AddressDataSet extends DataSet {
    @Column(name = "street")
    private String street;

    public AddressDataSet() {
    }

    public AddressDataSet(String street) {
        this.street = street;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

}
