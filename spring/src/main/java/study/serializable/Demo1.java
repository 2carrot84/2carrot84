package study.serializable;

import java.io.*;

/**
 * Created by eguns on 2017. 5. 31..
 */


class C1 implements Serializable {
    int x;
    String str;
    C2 c;

    public C1(int x, String str) {
        this.x = x;
        this.str = str;
        c = new C2();
    }

    @Override
    public String toString() {
        return "x : " + x + ", str : " + str;
    }
}

class C2 {
}

public class Demo1 {
    public static void main(String[] args) {

        C1 c1 = new C1(1, "abc");
        C1 c2 = new C1(2, "def");
        C1 c3 = new C1(3, "ghi");

        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        try {
            fos = new FileOutputStream("test.dat");
            oos = new ObjectOutputStream(fos);

            oos.writeObject(c1);
            oos.writeObject(c2);
            oos.writeObject(c3);

        }
        catch (IOException e) {

        }
        finally {
            if(fos != null) try{fos.close();}catch(IOException e){}
            if(oos != null) try{oos.close();}catch(IOException e){}
        }

        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            fis = new FileInputStream("test.dat");
            ois = new ObjectInputStream(fis);

            System.out.println(((C1)ois.readObject()).toString());
            System.out.println(((C1)ois.readObject()).toString());
            System.out.println(((C1)ois.readObject()).toString());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(fis != null) try{fis.close();}catch(IOException e){}
            if(ois != null) try{ois.close();}catch(IOException e){}
        }

    }
}
