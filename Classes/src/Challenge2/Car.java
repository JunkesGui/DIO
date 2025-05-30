package Challenge2;

public class Car {
    private int speed = 0;
    private byte gear = 0;
    private boolean isOn = false;

    public Car() {
    }

    //TODO TURN ON; TURN OFF; ACCELERATE; BRAKE; TURN LEFT/RIGHT; CHECK SPEED; SHIFT GEAR

    void turnOnOff(){
        if (!getisOn()) {
            setOn(true);
            System.out.println("The car was turned on");
        }else if (getisOn() && speed == 0 && gear == 0){
            setOn(false);
            System.out.println("The car was turned off");
        } else {
            System.out.println("The car needs to be at 0 Km/h and on neutral gear to be turned off!");
        }
    }

    private int gearMaxSpeed(){
        this.gear = getGear();
        return switch (gear) {
            case 1 -> 20;
            case 2 -> 40;
            case 3 -> 60;
            case 4 -> 80;
            case 5 -> 100;
            case 6 -> 120;
            default -> 0;
        };
    }

    void accelerate(){
        if (gear >= 1){
            if (speed < gearMaxSpeed()){
                speed++;
                checkSpeed();
            }else {System.out.println("You have reached the maximum speed at this gear!");}
        }else {System.out.println("You cannot accelerate in the neutral gear!");}
    }

    void brake(){
        if (gear >= 1){
            if (speed > gearMaxSpeed()-19 || speed == 1){
                speed--;
                checkSpeed();
            }else {System.out.println("You have reached the minimum speed at this gear!");}
        }else {System.out.println("Your car is stationary.");}
    }

    void turn(String side){
        if (0 < speed && speed < 40){
            System.out.println("Turning "+ side);
        }else if (speed == 0){
            System.out.println("You cant turn with a stationary car!");
        } else {
            System.out.println("You are too fast to turn!");
        }
    }

    void checkSpeed(){
        System.out.println("Current speed: " + getSpeed() + " km/h");
    }

    void checkGear(){
        System.out.println("Current gear: " + getGear());
    }

    void upshiftGear(){
        if (getisOn() && gear <= 6){
            if (speed == gearMaxSpeed()){
                gear++;
                checkGear();
            }else {System.out.println("You are too slow to upshift the gear!");}
        } else {
            System.out.println("You cannot upshift the gear!");
        }
    }

    void downshiftGear(){
        if (getisOn() && gear > 0){
            if (speed <= gearMaxSpeed() - 19  && speed != 1 || speed == 0){
                gear--;
                checkGear();
            }else {System.out.println("You are too fast to downshift the gear!");}
        }else {System.out.println("You are already on neutral gear!");}
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public byte getGear() {
        return gear;
    }

    public void setGear(byte gear) {
        this.gear = gear;
    }

    public boolean getisOn() {
        return isOn;
    }

    public void setOn(boolean on) {
        isOn = on;
    }
}
