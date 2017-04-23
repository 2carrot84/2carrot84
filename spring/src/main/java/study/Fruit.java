package study;

/**
 * Created by eguns on 2017. 4. 23..
 */
public class Fruit implements Comparable {
    private String name;
    private int price;

    public Fruit(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public int compareTo(Object o) {
        int comparePrice = ((Fruit)o).getPrice();
//        System.out.println(this.toString() + ", " + o.toString());
        // 오름차순
//        return this.price - comparePrice;
        // 내림차순
        return comparePrice - this.price;
    }

    @Override
    public String toString() {
        return this.name + ", " + this.price;
    }
}
