package theory;

import java.io.*;

/**
 * @author Heshan Karunaratne
 */
public class TransientDemo {
    public static void main(String[] args) {

        try {
            MyClass obj = new MyClass(42, 100);
            FileOutputStream fileOut = new FileOutputStream("myclass.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(obj);
            out.close();
            fileOut.close();
            System.out.println("Serialized data is saved in myclass.ser");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            FileInputStream fileIn = new FileInputStream("myclass.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            MyClass deserializedObj = (MyClass) in.readObject();
            in.close();
            fileIn.close();

            System.out.println("Regular Field: " + deserializedObj.getRegularField());
            System.out.println("Transient Field: " + deserializedObj.getTransientField());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}


class MyClass implements Serializable {
    private int regularField;
    private transient int transientField;

    public MyClass(int regularField, int transientField) {
        this.regularField = regularField;
        this.transientField = transientField;
    }

    public int getRegularField() {
        return regularField;
    }

    public int getTransientField() {
        return transientField;
    }
}