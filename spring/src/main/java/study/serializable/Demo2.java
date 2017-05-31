package study.serializable;

import java.io.*;

/**
 * Created by eguns on 2017. 5. 31..
 */


class CC1 implements Serializable {
    int x;
    String str;
    CC2 c;

    public CC1(int x, String str) {
        this.x = x;
        this.str = str;
        c = new CC2();
    }

    @Override
    public String toString() {
        return "x : " + x + ", str : " + str;
    }
}

class CC2 implements Serializable {
}

public class Demo2 {
    public static void main(String[] args) {

        CC1 c1 = new CC1(1, "abc");
        CC1 c2 = new CC1(2, "def");
        CC1 c3 = new CC1(3, "ghi");

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

            System.out.println(((CC1)ois.readObject()).toString());
            System.out.println(((CC1)ois.readObject()).toString());
            System.out.println(((CC1)ois.readObject()).toString());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(fis != null) try{fis.close();}catch(IOException e){}
            if(ois != null) try{ois.close();}catch(IOException e){}
        }

    }
}
