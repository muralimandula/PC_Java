class Contact {
    private String name;
    String phoneNumber;
    Contact() {
    }
    Contact(String n, String p) {
        this.name = n;
        this.phoneNumber = p;
    }

    private String mytoString() {
        return this.name + " - " + this.phoneNumber;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String s) {
        this.name = s;
    }

    public String getMeToString() {
        return mytoString();
    }
}
class ObjectCreation {
    public static void main(String[] args) {
        Contact obj = new Contact();
        System.out.println(obj.getMeToString());
        obj.setName("Im changed");
        System.out.println(obj.getMeToString());
    }
}