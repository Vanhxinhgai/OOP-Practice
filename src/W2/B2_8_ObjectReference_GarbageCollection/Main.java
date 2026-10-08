package W2.B2_8_ObjectReference_GarbageCollection;

public class Main {
    public static void main(String[] args) {
        // 1. Tạo đối tượng Person, gán cho biến p
        Person p = new Person("An");

        // 2. Cho me trỏ tới chính đối tượng mà p đang trỏ
        p.setMe(p);

        // 3. Truy cập getName() thông qua tham chiếu me
        System.out.println("p.getMe().getName()        : " + p.getMe().getName());
        System.out.println("p.getMe() == p ?           : " + (p.getMe() == p));
        System.out.println("p.getMe().getMe().getName(): " + p.getMe().getMe().getName());

        // 4. Cắt tham chiếu từ stack
        p = null;
        System.out.println("Sau p = null, p là: " + p);

        // p.getName();   // nếu bỏ comment -> NullPointerException khi chạy
    }
}
