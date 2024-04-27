public abstract class Animals {
    private String name;
    private String perk;

    public Animals(String name, String perk){
        this.name = name;
        this.perk = perk;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPerk() {
        return perk;
    }

    public void setPerk(String perk) {
        this.perk = perk;
    }
}
