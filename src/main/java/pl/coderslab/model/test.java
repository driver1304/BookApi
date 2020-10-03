package pl.coderslab.model;

public class test {
    public static void main(String[] args) {
        MemoryBookService mbs = new MemoryBookService();
        System.out.println(mbs.getById(2));
    }
}
