package newpackage;

public class TestTV {
    public static void main(String[] args) {
        TV tv1 = new TV();
        tv1.turnOn();
        tv1.setChannel(30);
        tv1.setVolume(3);
        
        TV tv2 = new TV();
        tv2.turnOn();
        tv2.channelUp();
        tv2.channelUp();
        tv2.volumeUp();
        
        System.out.println("tv1 channel is " + tv1.channel
        + " and volume is " + tv1.volumeLevel);
        
        System.out.println("tv2 channel is " + tv2.channel
        + " and volume is " + tv2.volumeLevel);
        
        tv1.turnOff(); 
        
        System.out.println("tv1 is on: " + tv1.on);
    }
}
