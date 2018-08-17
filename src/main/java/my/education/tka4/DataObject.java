package my.education.tka4;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Arrays;

/**
 * Created by bender on 08.07.2018.
 */
public class DataObject extends NonSerializable implements Serializable {
    private int i = 33;
    private String s = "Serjio";
    transient private String[] def = {"wewe", "asas"};
    private CustomObject customObject;

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
        out.writeObject(getMyData());
        out.flush();
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        setMyData((String) in.readObject());
    }

    public DataObject(String myData, int i, String s, String[] def, CustomObject customObject) {
        super(myData);
        this.i = i;
        this.s = s;
        this.def = def;
        this.customObject = customObject;
    }

    public DataObject() {
        setMyData("adfja;jflajflajfljfl;ajflajfldajfladfja;jflajflajfljfl;ajflajfldajfladfja;jflajflajfljfl;ajflajfldajfladfja;jflajflajfljfl;ajflajfldajfladfja;jflajflajfljfl;ajflajfldajfladfja;jflajflajfljfl;ajflajfldajfladfja;jflajflajfljfl;ajflajfldajfladfja;jflajflajfljfl;ajflajfldajfladfja;jflajflajfljfl;ajflajfldajfladfja;jflajflajfljfl;ajflajfldajfladfja;jflajflajfljfl;ajflajfldajfladfja;jflajflajfljfl;ajflajfldajfladfja;jflajflajfljfl;ajflajfldajfladfja;jflajflajfljfl;ajflajfldajfladfja;jflajflajfljfl;ajflajfldajfladfja;jflajflajfljfl;ajflajfldajfl");
    }

    @Override
    public String toString() {
        return "DataObject{" +
                "i=" + i +
                ", s='" + s + '\'' +
                ", def=" + Arrays.toString(def) +
                ", customObject=" + customObject +
                ", myData=" + getMyData() +
                '}';
    }
}
