public abstract class Animals {
    private String name;
    private String abilities;

    public Animals(String name, String abilities){
        this.name = name;
        this.abilities = abilities;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAbilities() {
        return abilities;
    }

    public void setAbilities(String abilities) {
        this.abilities = abilities;
    }

    public abstract void showAbilities();

    public  abstract void addCommand(String command);

    @Override
    public String toString() {
        return "Animals{" +
                "name='" + name + '\'' +
                ", abilities='" + abilities + '\'' +
                '}';
    }
}
