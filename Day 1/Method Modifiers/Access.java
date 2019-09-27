class Helping {
    int a = 5;
    int b = 6;

    public void showAB () {
        System.out.println(a + " " + b + " are showing");
    }

    // public void helpShowAB() {

    //     System.out.println("I'm Helping showing");
    //     showAB();
    // }


}

class Access {
    public static void main(String[] args) {
        Helping helpObj = new Helping();

        helpObj.showAB();

        // helpObj.helpShowAB();
    }
}