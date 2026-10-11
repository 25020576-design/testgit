
import java.util.*;

abstract class SmartDevice {
    protected String id;
    protected String name;
    protected boolean isOn;

    public SmartDevice(String id, String name) {
        this.id = id;
        this.name = name;
        this.isOn = true;
    }

    public void turnOn() {
        isOn = true;
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
}

interface WifiConnectable {
    void connectWifi();
}

class Light extends SmartDevice implements Adjustable {
    private int brightness = 50;

    public Light(String id, String name) {
        super(id, name);
    }

    @Override
    public void increaseLevel() {
        if (brightness < 100) {
            brightness += 10;
        }
    }

    @Override
    public void decreaseLevel() {
        if (brightness > 0) {
            brightness -= 10;
        }
    }
}

class AirConditioner extends SmartDevice
        implements WifiConnectable {

    public AirConditioner(String id, String name) {
        super(id, name);
    }

    @Override
    public void connectWifi() {
        System.out.println(name + " connected to wifi");
    }
}

class SmartSpeaker extends SmartDevice
        implements Adjustable, WifiConnectable {

    private int volume = 50;

    public SmartSpeaker(String id, String name) {
        super(id, name);
    }

    @Override
    public void increaseLevel() {
        if (volume < 100) {
            volume += 10;
        }
    }

    @Override
    public void decreaseLevel() {
        if (volume > 0) {
            volume -= 10;
        }
    }

    @Override
    public void connectWifi() {
        System.out.println(name + " connected to wifi");
    }
}

class Curtain extends SmartDevice {
    public Curtain(String id, String name) {
        super(id, name);
    }
}

class Hub {
    private List<SmartDevice> devices = new ArrayList<>();

    public void addDevice(SmartDevice device) {
        devices.add(device);
    }

    public void turnOffAll() {
        System.out.println("Turn Off All Devices:");

        for (SmartDevice device : devices) {
            device.turnOff();
        }
    }

    public void setupWifi() {
        System.out.println("Setup Wifi:");

        for (SmartDevice device : devices) {
            if (device instanceof WifiConnectable) {
                WifiConnectable wifiDevice =
                    (WifiConnectable) device;

                wifiDevice.connectWifi();
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Hub hub = new Hub();

        int n = Integer.parseInt(sc.nextLine().trim());

        for (int i = 0; i < n; i++) {
            String[] data = sc.nextLine().trim().split("\\s+");

            String type = data[0];
            String id = data[1];
            String name = data[2];

            SmartDevice device;

            switch (type) {
                case "L":
                    device = new Light(id, name);
                    break;

                case "AC":
                    device = new AirConditioner(id, name);
                    break;

                case "S":
                    device = new SmartSpeaker(id, name);
                    break;

                case "C":
                    device = new Curtain(id, name);
                    break;

                default:
                    continue;
            }

            hub.addDevice(device);
        }

        hub.turnOffAll();
        hub.setupWifi();

        sc.close();
    }
}
