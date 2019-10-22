class Player implements Comparable<Player>{
    private String name;
    private String level;
    private int score;

    Player() {}

    Player(final String n) {
        this.name = n;
        this.level = "NA";
        this.score = 0;
    }

    // Used to sort players by score
    public int compareTo(Player player) 
    { 
        return player.getScore() - this.getScore(); 
    }

    //toString for Player Object
    public String toString() {
        return this.name + "\t" + this.level +"\t" + this.score;
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


    public int getScore() {
        return this.score;
    }

    public void setScore(int score) {
        this.score = score;
    }

}