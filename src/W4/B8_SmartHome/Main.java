package W4.B8_SmartHome;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class Device {
    protected String id;
    protected String name;
    protected boolean isOn;

    public Device(String id, String name) {
        this.id = id;
        this.name = name;
        this.isOn = false;
    }

    public void turnOn() {
        isOn = true;
        System.out.println(name + " turned on");
    }

    public void turnOff() {
        isOn = false;
        System.out.println(name + " turned off");
    }

    public String getName() {
        return name;
    }
}

interface Adjustable {
    void increaseLevel();
    void decreaseLevel();
    int getLevel();
}

interface WifiConnectable {
    void connectWifi();
}

class SmartLight extends Device implements Adjustable {
    private int brightness = 50;

    public SmartLight(String id, String name) {
        super(id, name);
    }

    @Override
    public void increaseLevel() {
        if (brightness < 100) brightness += 10;
    }

    @Override
    public void decreaseLevel() {
        if (brightness > 0) brightness -= 10;
    }

    @Override
    public int getLevel() {
        return brightness;
    }
}

class AirConditioner extends Device implements WifiConnectable {
    public AirConditioner(String id, String name) {
        super(id, name);
    }

    @Override
    public void connectWifi() {
        System.out.println(name + " connected to wifi");
    }
}

class SmartSpeaker extends Device implements Adjustable, WifiConnectable {
    private int volume = 30;

    public SmartSpeaker(String id, String name) {
        super(id, name);
    }

    @Override
    public void increaseLevel() {
        if (volume < 100) volume += 10;
    }

    @Override
    public void decreaseLevel() {
        if (volume > 0) volume -= 10;
    }

    @Override
    public int getLevel() {
        return volume;
    }

    @Override
    public void connectWifi() {
        System.out.println(name + " connected to wifi");
    }
}

class WindowCurtain extends Device {
    public WindowCurtain(String id, String name) {
        super(id, name);
    }
}

class Hub {
    private List<Device> devices = new ArrayList<>();

    public void addDevice(Device d) {
        devices.add(d);
    }

    public void turnOffAll() {
        System.out.println("Turn Off All Devices:");
        for (Device d : devices) {
            d.turnOff();
        }
    }

    public void setupWifi() {
        System.out.println("Setup Wifi:");
        for (Device d : devices) {
            if (d instanceof WifiConnectable) {
                ((WifiConnectable) d).connectWifi();
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Hub hub = new Hub();

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String id = sc.next();
            String name = sc.next();

            switch (type) {
                case "L":  hub.addDevice(new SmartLight(id, name));     break;
                case "AC": hub.addDevice(new AirConditioner(id, name)); break;
                case "S":  hub.addDevice(new SmartSpeaker(id, name));   break;
                case "C":  hub.addDevice(new WindowCurtain(id, name));  break;
            }
        }

        hub.turnOffAll();
        System.out.println();
        hub.setupWifi();
    }
}
