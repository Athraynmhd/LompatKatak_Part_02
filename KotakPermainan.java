import java.util.ArrayList;
import java.util.Collections;

class KotakPermainan {

    private Kotak[] boardGame;
    private int jumKotak;
    private int jumlahKoin;
    private int jumlahMonster;
    private int[] acakKoin;
    private int[] acakMonster;

    public KotakPermainan(int j, int jk, int jm) {
        this.jumKotak = j;
        this.jumlahKoin = jk;
        this.jumlahMonster = jm;
        this.boardGame = new Kotak[jumKotak];
        this.acakKoin = new int[jumlahKoin];
        this.acakMonster = new int[jumlahMonster];
        generateAcak();
        inisialisasiKotak();
    }

    private void generateAcak() {
        ArrayList<Integer> koinList = new ArrayList<Integer>();
        ArrayList<Integer> monsterList = new ArrayList<Integer>();

        for (int i = 0; i < jumKotak; i++) {
            koinList.add(i);
            monsterList.add(i);
        }

        Collections.shuffle(koinList);
        Collections.shuffle(monsterList);

        for (int i = 0; i < jumlahKoin; i++) {
            acakKoin[i] = koinList.get(i);
        }

        for (int i = 0; i < jumlahMonster; i++) {
            acakMonster[i] = monsterList.get(i);
        }
    }

    private void inisialisasiKotak() {
        for (int i = 0; i < jumKotak; i++) {
            boardGame[i] = new Kotak();
        }

        for (int i = 0; i < jumlahKoin; i++) {
            Koin koin = new Koin();
            boardGame[acakKoin[i]].addKoin(koin);
        }

        for (int i = 0; i < jumlahMonster; i++) {
            Monster monster = new Monster();
            boardGame[acakMonster[i]].addMonster(monster);
        }
    }

    public int contain(int posisi) {
    if (posisi < jumKotak) {
        int skor = 0;
        Kotak kotak = boardGame[posisi];

        if (kotak.isThereKoin()) {
            skor += 20; // Menambah 20 poin jika bertemu koin
        }

        if (kotak.isThereMonster()) {
            skor -= 10; // Mengurangkan 10 poin jika bertemu monster
        }

        return skor;
    }
    return 0;
}

}
