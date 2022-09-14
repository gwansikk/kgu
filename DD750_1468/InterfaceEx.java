interface PhoneInterface {
    final int TIMEOUT = 10000;

    void sendCall();
    void receiveCall();

    default void printLogo() {
        System.out.println("** Phone **");
    }
}

interface MobilePhoneInterface extends PhoneInterface {
    void sendSMS();
    void receiveSMS();
}

interface MP3Interface {
    public void play();
    public void stop();
}

class PDA {
    public int calculate(int x, int y) {
        return x + y;
    }
}

class SamsungPhone extends PDA implements MobilePhoneInterface, MP3Interface {
    public void sendCall(){
        System.out.println("전화를 걸고 있습니다.");
    }   

    public void receiveCall(){
        System.out.println("전화가 왔습니다.");
    }

    public void sendSMS(){
        System.out.println("문자를 보냅니다.");
    }
    
    public void receiveSMS(){
        System.out.println("문자가 도착했습니다.");
    }

    public void play() {
        System.out.println("음악을 재생합니다.");
    }

    public void stop(){
        System.out.println("음악을 정지합니다");
    }

    // 추가로 작성한 메서드
    public void schedule(){
        System.out.println("일정 관리합니다.");
    }
}

public class InterfaceEx {
    public static void main(String[] args) {
        SamsungPhone sp = new SamsungPhone();

        sp.printLogo();
        sp.sendCall();
        sp.play();
        System.out.println("3과 5를 더하면 " + sp.calculate(3, 5));
        sp.schedule();
    }
}
