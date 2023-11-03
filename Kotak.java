class Kotak {
    private Koin coin;
    private Monster monsta;

    public Kotak() {
        this.coin = null;
        this.monsta = null;
    }

    public void addKoin(Koin c) {
        this.coin = c;
    }

    public void addMonster(Monster m) {
        this.monsta = m;
    }

    public Koin getKoin() {
        return coin;
    }

    public Monster getMonster() {
        return monsta;
    }

    public boolean isThereKoin() {
        return coin != null;
    }

    public boolean isThereMonster() {
        return monsta != null;
    }
}
