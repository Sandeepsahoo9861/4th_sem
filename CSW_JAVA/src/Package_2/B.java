package Package_2;

   public class B {//defult class(B) can access by class Y()package_1 can able to acess but Acess class can't access(package3) defult class
    public int a = 700; //if we make the data member protected then also Y class able to acess

    void display() { 
        System.out.println(a);
    }
}
