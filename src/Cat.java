public class Cat extends Animals {
    public Cat(String name, String abilities) {
        super(name, abilities);
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
