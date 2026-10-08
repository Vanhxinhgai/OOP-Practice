package W2.B2_8_ObjectReference_GarbageCollection;

public class Person {
    private String name;
    private Person me;      // tham chiếu tới một Person khác (hoặc chính nó)

    public Person(String name) {
        this.name = name;
    }

    public void setMe(Person other) {
        this.me = other;
    }

    public Person getMe() {
        return me;
    }

    public String getName() {
        return name;
    }
}
