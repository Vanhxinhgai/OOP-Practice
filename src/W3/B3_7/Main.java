package W3.B3_7;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String type = sc.next();
        int nights = sc.nextInt();
        Room room;
        if (type.equalsIgnoreCase("S")) {
            room = new StandardRoom();
        } else if (type.equalsIgnoreCase("V")) {
            room = new VipRoom();
        } else {
            System.out.println("Loại phòng không hợp lệ!");
            return;
        }
        if (nights <= 0) {
            System.out.println("Số đêm phải lớn hơn 0!");
            return;
        }
        System.out.println(room.calculateCost(nights));
    }
}
