class Katak {
    private int posisi;
    private int skor;

    public Katak() {
        this.posisi = 0;
        this.skor = 100;
    }

    public int getPosisi() {
        return posisi;
    }

    public void setPosisi(int posisi) {
        this.posisi = posisi;
    }

    public int getSkor() {
        return skor;
    }

    public void setSkor(int skor) {
        this.skor = skor;
    }

    public void loncatDekat() {
        if (posisi < 299) {
            posisi += 1;
        }
    }

    public void loncatJauh() {
        if (posisi < 298) {
            posisi += 2;
        }
    }
}
