import java.util.Scanner;

// https://youtu.be/5Aq6IkqQEIA?si=BoWC2OMrf32iRu4y

public class MainLompatKatak {
    private boolean play;
    private Scanner s;
    private Katak katak;
    private Pemain pemain;
    private KotakPermainan kotakPermainan;
    private int tingkatKesulitan; // 1 untuk mudah, 2 untuk sedang, 3 untuk sulit

    public MainLompatKatak() {
        play = true;
        s = new Scanner(System.in);
        katak = new Katak();
        System.out.print("Masukkan nama pemain: ");
        String playerName = s.nextLine();
        pemain = new Pemain(playerName);
        kotakPermainan = new KotakPermainan(300, 60, 30);

        // Pilih tingkat kesulitan
        System.out.println("Pilih tingkat kesulitan:");
        System.out.println("1. Mudah");
        System.out.println("2. Sedang");
        System.out.println("3. Sulit");
        System.out.print("Masukkan pilihan tingkat kesulitan: ");
        tingkatKesulitan = s.nextInt();
    }

    public void mainkan() {
        while (play) {
            System.out.println("Posisi katak di kotak : [" + katak.getPosisi() + "]");
            System.out.println("Poin " + pemain.getNama() + " saat ini: " + pemain.getNilai());

            if (katak.getPosisi() == 298) {
                System.out.println("1 lompatan maju terakhir");
            }

            System.out.println("+-------------------------+");
            System.out.println("|  Tentukan langkah anda  |");
            System.out.println("+-------------------------+");
            System.out.println("== MAJU ==");

            if (katak.getPosisi() <= 297) {
                System.out.println("1. Maju 1 langkah");
                System.out.println("2. Maju 2 langkah");
            } else {
                System.out.println("Anda Hanya Memiliki satu opsi\n");
                System.out.println("1. Maju 1 langkah");
            }

            System.out.println("\n== MUNDUR ==");
            System.out.println("3. Mundur 1 langkah");
            System.out.println("4. Mundur 2 langkah");

            System.out.print("Masukkan pilihan : ");
            int pilihan = s.nextInt();

            if (pilihan == 1) {
                if (katak.getPosisi() < 299) {
                    katak.loncatDekat();
                } else {
                    System.out.println("Anda Hanya Memiliki satu opsi\n");
                    System.out.println("1. Maju 1 langkah");
                }
            } else if (pilihan == 2) {
                if (katak.getPosisi() < 298) {
                    katak.loncatJauh();
                }
            } else if (pilihan == 3) {
                if (katak.getPosisi() > 0) {
                    katak.setPosisi(katak.getPosisi() - 1);
                }
            } else if (pilihan == 4) {
                if (katak.getPosisi() > 1) {
                    katak.setPosisi(katak.getPosisi() - 2);
                }
            }

            if (katak.getPosisi() < 0) {
                katak.setPosisi(0);
            }

            int skorChange = kotakPermainan.contain(katak.getPosisi());

            if (skorChange > 0) {
                System.out.println("Anda menemukan koin, poin bertambah 20");
            } else if (skorChange < 0) {
                System.out.println("Anda bertemu monster, poin berkurang 10");
            }

            pemain.setNilai(pemain.getNilai() + skorChange);

            if (pemain.getNilai() <= 0) {
                System.out.println("Game Over. Skor " + pemain.getNama() + " habis.");
                play = false;
            } else if (katak.getPosisi() >= 299) {
                System.out.println("Selamat, " + pemain.getNama() + " menang!");
                play = false;
                evaluasiPoin(pemain.getNilai());
            }
        }
    }

    public void evaluasiPoin(int totalPoin) {
        if (totalPoin > 1000) {
            System.out.println("Poin " + pemain.getNama() + " sangat bagus!");
        } else if (totalPoin >= 500 && totalPoin <= 1000) {
            System.out.println("Poin " + pemain.getNama() + " bagus!");
        } else {
            System.out.println("Poin " + pemain.getNama() + " buruk!");
        }
    }

    public static void main(String[] args) {
        MainLompatKatak game = new MainLompatKatak();
        game.mainkan();
    }
}
