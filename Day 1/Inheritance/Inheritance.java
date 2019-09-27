class GrandFather {
    String documents = " Inti pathral";

    GrandFather() {

    }

    protected String getDocuments() {
        return this.documents;
    }
}

class Father extends GrandFather {

}

class Son extends Father {

}



class Inheritance {

    public static void main(String[] args) {
        GrandFather grandFather = new GrandFather();   //defaults contructor / common object

        Father father = new Father();

        Son son = new Son();
    }
}