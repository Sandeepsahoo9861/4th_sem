package important;

class Parent {
    public void show() {
        System.out.println("I am Parent method");
    }
}

class Child extends Parent {
    public void callParentMethod() {
        // ✅ Calling parent method without creating a Parent object
        show(); // This is actually this.show()
    }
}

public class concept {
    public static void main(String[] args) {
        Child c = new Child();         // ✅ Create a Child object
        c.callParentMethod();          // ✅ Calls method from Parent through inheritance
    }
}
//c is a Child object
//
//But since Child inherits Parent, c also contains show()
//
//So we can call show() inside Child methods — without needing a separate Parent object
//
