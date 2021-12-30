package lat1.shibaaazmi.kalkulator_uas;

public class Hitung {

    private int angka1;
    private int angka2;
    private int hasil ;
    private String simbol;

    public Hitung(int angka1, int angka2, int hasil, String simbol) {
        this.angka1 = angka1;
        this.angka2 = angka2;
        this.hasil = hasil;
        this.simbol = simbol;
    }

    public int getAngka1() {
        return angka1;
    }

    public void setAngka1(int angka1) {
        this.angka1 = angka1;
    }

    public int getAngka2() {
        return angka2;
    }

    public void setAngka2(int angka2) {
        this.angka2 = angka2;
    }

    public int getHasil() {
        return hasil;
    }

    public void setHasil(int hasil) {
        this.hasil = hasil;
    }

    public String getSimbol() {
        return simbol;
    }

    public void setSimbol(String simbol) {
        this.simbol = simbol;
    }

}
