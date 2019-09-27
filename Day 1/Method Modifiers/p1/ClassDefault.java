package p1;

public class ClassDefault {

    static{
        System.out.println("Im a static block.");
    }

    public void Imdefault() {
        System.out.println();
        System.out.println("I'm a 'Imdefault()', a default method from package, p1");
        System.out.println();
    }

    static{
        System.out.println("Im a static block 2.");
    }
}
