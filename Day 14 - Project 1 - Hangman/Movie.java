class Movie {
    private String name;
    private String level;
    private String info;
    private String cast;

    Movie() {
    }

    Movie(final String n, final String l, final String i, final String c) {
        this.name = n;
        this.level = l;
        this.info = i;
        this.cast = c;
    }

    public String toString() {
        return this.name + " - " + this.level; //"\n"+ this.info + "\n" + this.cast + "\n";
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLevel() {
        return this.level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getInfo() {
        return this.info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getCast() {
        return this.cast;
    }

    public void setCast(String cast) {
        this.cast = cast;
    }

}