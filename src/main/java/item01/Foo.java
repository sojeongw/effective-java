package item01;

import java.util.EnumSet;

import static item01.Foo.Color.*;

public class Foo {

    private static final Foo GOOD_NIGHT = new Foo();

    String name;
    String address;

    public Foo() {
    }

    // 생성자로 객체를 생성하게 되면 그냥 그 클래스 이름 그대로 만들게 된다.
    public Foo(String name) {
        this.name = name;
    }

    /* String name 이라는 시그니처가 똑같은 생성자가 있기 때문에 만들 수 없다.
    public Foo(String address) {
        this.address = address;
    }*/

    // 정적 팩토리 매서드를 쓰면 이렇게 이름을 부여할 수 있다.
    public static Foo withName(String name) {
        return new Foo(name);
    }

    // 정적 팩토리 메서드는 시그니처가 같아도 이름을 바꿔서 만들 수 있다.
    public static Foo withAddress(String address) {
        Foo foo = new Foo();
        foo.address = address;
        return foo;
    }

    public static Foo getFoo() {
        return GOOD_NIGHT;
    }

    public static Foo getFoo(boolean flag) {
        Foo foo = new Foo();

        /* 가정
        * 텍스트 파일에서 Foo의 구현체의 FQCN(Full Qualified Class Name)을 읽어온다.
        * FQCN에 해당하는 인스턴스를 생성한다.
        * foo 변수가 해당 인스턴스를 가리키도록 수정한다.
        * 즉, 텍스트 파일에 뭐가 적혀있냐에 따라 다른 객체를 반환하게 된다.
        * getFoo() 메서드를 만들고 나서 나중에 Foo 타입의 다른 클래스를 만들어 얼마든지 교체할 수 있다.
        */
        foo = new MyFoo();
        return foo;
    }

    public static void main(String[] args) {
        // 생성자로 만들 때는 이게 뭘 뜻하는지 확실히 알 수 없다.
        // 매번 새로운 객체를 리턴 받는다.
        Foo foo = new Foo("keesun");

        // 이름을 주면 좀 더 알기 쉽다.
        Foo foo1 = Foo.withName("keesun");

        // 매번 새로운 객체를 받지 않고 동일한 GOOD_NIGHT 인스턴스를 받게 된다.
        Foo foo2 = Foo.getFoo();

        // 매개 변수를 어떻게 넘기냐에 따라 리턴하는 객체가 Foo거나 BarFoo가 된다.
        Foo foo3 = Foo.getFoo(false);

        // Color 이넘에 대한 set을 만든다.
        EnumSet<Color> colors = EnumSet.allOf(Color.class);

        // enum의 개수에 따라 RegularEnumSet 또는 JumboEnumSet이 된다.
        // 어차피 감춰져 있는 구현이라 몰라도 됨 ㅎㅎ
        EnumSet<Color> blueAndWhite = EnumSet.of(BLUE, WHITE);
    }

    enum Color {
        RED, BLUE, WHITE
    }

    // private static method가 필요한 이유는 private 메서드가 필요한 이유와 같다.
    // static에서는 static만 호출하고 사용할 수 있고 private한게 필요하면 private static을 만드는 것이다.
    public static void doSomething() {
        게임을하고잔다();
    }

    public static void doSomethingTomorrow() {
        게임을하고잔다();
    }

    private static void 게임을하고잔다() {
    }
}