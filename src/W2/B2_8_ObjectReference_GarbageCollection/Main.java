package W2.B2_8_ObjectReference_GarbageCollection;

public class Main {
    public static void main(String[] args) {
        Person p = new Person("An");
        p.setMe(p);

        System.out.println("p.getMe().getName()        : " + p.getMe().getName());
        System.out.println("p.getMe() == p ?           : " + (p.getMe() == p));
        System.out.println("p.getMe().getMe().getName(): " + p.getMe().getMe().getName());

        p = null;
        System.out.println("Sau p = null, p là: " + p);
    }
}
