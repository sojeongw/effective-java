package item01;

public class Foo {
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

    public static void main(String[] args) {
        // 생성자로 만들 때는 이게 뭘 뜻하는지 확실히 알 수 없다.
        // 매번 새로운 객체를 리턴 받는다.
        Foo foo = new Foo("keesun");

        // 이름을 주면 좀 더 알기 쉽다.
        Foo foo1 = Foo.withName("keesun");
    }
}
