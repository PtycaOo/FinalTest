public class Dog extends Animals {
    public Dog(String name, String abilities, String age) {
        super(name, abilities,age);
    }

    @Override
    public void showAbilities() {
        System.out.println("Команды собаки: " + getAbilities());
    }

    @Override
    public void addCommand(String command) {
        String appCommand = getAbilities() + ", " + command;
        setAbilities(appCommand);
        System.out.println("Способность успешно добавленна");
    }
}
