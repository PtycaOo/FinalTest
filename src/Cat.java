public class Cat extends Animals {
    public Cat(String name, String abilities, String age) {
        super(name, abilities,age);
    }

    @Override
    public void showAbilities() {
        System.out.println("Команды кошки: " + getAbilities());
    }

    @Override
    public void addCommand(String command) {
        String appCommand = getAbilities() + ", " + command;
            setAbilities(appCommand);
        System.out.println("Способность успешно добавленна");
    }
}
