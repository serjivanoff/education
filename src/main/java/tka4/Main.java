package tka4;

import java.io.*;

/**
 * Created by bender on 08.07.2018.
 */
public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        DataObject dataObject = new DataObject();
        File file = new File("store.bin");

        FileOutputStream fos = new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(dataObject);
        oos.flush();
        oos.close();

        FileInputStream fis = new FileInputStream(file);
        ObjectInputStream ois = new ObjectInputStream(fis);
        DataObject serialized = (DataObject) ois.readObject();
        System.out.println(serialized);
        fis.close();
    }
}
