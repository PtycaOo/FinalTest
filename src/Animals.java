public abstract class Animals {
    private String name;
    private String abilities;
    private String age;

    public Animals(String name, String abilities, String age){
        this.name = name;
        this.abilities = abilities;
        this.age = age;
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

}
