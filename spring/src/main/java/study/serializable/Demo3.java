package study.serializable;

import java.io.*;

/**
 * Created by eguns on 2017. 5. 31..
 */


class CCC1 implements Serializable {
    int x;
    transient String str;
    CCC2 c;

    public CCC1(int x, String str) {
        this.x = x;
        this.str = str;
        c = new CCC2();
    }

    @Override
    public String toString() {
        return "x : " + x + ", str : " + str;
    }
}

class CCC2 implements Serializable {
}

public class Demo3 {
    public static void main(String[] args) {

        CCC1 c1 = new CCC1(1, "abc");
        CCC1 c2 = new CCC1(2, "def");
        CCC1 c3 = new CCC1(3, "ghi");

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

            System.out.println(((CCC1)ois.readObject()).toString());
            System.out.println(((CCC1)ois.readObject()).toString());
            System.out.println(((CCC1)ois.readObject()).toString());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(fis != null) try{fis.close();}catch(IOException e){}
            if(ois != null) try{ois.close();}catch(IOException e){}
        }

    }
}
