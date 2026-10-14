package W4.B5_GenericPair;

class Pair<K, V> {
    private K key;
    private V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public void setValue(V value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return key + " - " + value;
    }
}

public class Main {
    public static void main(String[] args) {
        Pair<String, Integer> age = new Pair<>("Tuổi", 20);
        Pair<String, String> studentId = new Pair<>("Mã SV", "SV001");
        Pair<Integer, Double> location = new Pair<>(105, 21.5);

        System.out.println(age);
        System.out.println(studentId);
        System.out.println(location);
    }
}
