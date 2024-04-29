public abstract class Animals {
    private String name;
    private String age;
    private String abilities;


    public Animals(String name, String age, String abilities){
        this.name = name;
        this.age = age;
        this.abilities = abilities;

    }

    public String getName() {
        return name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
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
