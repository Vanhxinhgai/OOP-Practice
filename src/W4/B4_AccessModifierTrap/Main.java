package W4.B4_AccessModifierTrap;

interface IData {
    void show();   // Mặc định là public abstract
}

class DataManager implements IData {
    @Override
    public void show() {   // đã thêm public
        System.out.println("Show Data");
    }
}

public class Main {
    public static void main(String[] args) {
        IData d = new DataManager();
        d.show();
    }
}
