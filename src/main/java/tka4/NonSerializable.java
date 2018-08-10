package tka4;

/**
 * Created by bender on 08.07.2018.
 */
public class NonSerializable {
    private String myData="";

    public NonSerializable(String myData) {
        this.myData = myData;
    }

    public NonSerializable() {
    }

    public String getMyData() {
        return myData;
    }

    public void setMyData(String myData) {
        this.myData = myData;
    }
}
