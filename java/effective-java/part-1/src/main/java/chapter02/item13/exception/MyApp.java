package chapter02.item13.exception;

public class MyApp {

    /**
     *
     * @param name
     * @throws MyException
     */
    // unChecked Exception 을 쓰면 exception 을 따로 처리할 필요가 없는데 왜 굳이나 checked Exception 쓰는 걸까?
    // -> checked Exception 을 던지는것 자체가 프로그래밍 인터페이스의 일부
    // 해당 인터페이스를 사용하는 클라이언트에게 정보를 제공하고 복구를 시도할 수 있게끔 해줌

    // 그러면 unChecked Exception 은 왜쓰지...? 보다는 왜 예외처리를 강제하지 않을까?
    // -> 이건 복구가 안된다고 생각해서 클라이언트가 아무것도 할 수 있는게 없다고 생각해서
    // 그래서 clone은 사실 unChecked Exception 이였어야 헸다!
    public void hello(String name) throws MyException {
        if (name.equals("푸틴")) {
            throw new MyException();
        }

        System.out.println("hello");
    }

    public static void main(String[] args) {
        MyApp myApp = new MyApp();
        try {
            myApp.hello("푸틴");
        } catch (MyException e) {
            e.printStackTrace();
        }
    }
}
