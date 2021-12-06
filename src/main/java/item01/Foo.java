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
        return flag ? new Foo() : new BarFoo();
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

    static class BarFoo extends Foo {

    }

    enum Color {
        RED, BLUE, WHITE
    }
}