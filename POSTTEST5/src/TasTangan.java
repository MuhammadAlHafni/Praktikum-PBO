final class TasTangan extends Tas {
    private boolean taliPanjang;

    public TasTangan(final String kode, final String nama, final double harga, final boolean taliPanjang) {
        super(kode, nama, harga);
        this.taliPanjang = taliPanjang;
    }

    public boolean isTaliPanjang() {
        return taliPanjang;
    }

    public void setTaliPanjang(final boolean taliPanjang) {
        this.taliPanjang = taliPanjang;
    }

    @Override
    void printDetails() {
        System.out.println("Kode Tas = " + getKode());
        System.out.println("Nama Tas = " + getNama());
        System.out.println("Harga Tas = " + getHarga());
        if (taliPanjang) {
            System.out.println("Tas Tangan dengan Tali Panjang");
        } else {
            System.out.println("Tas Tangan tanpa Tali Panjang");
        }
    }

    @Override
void printDetails(final boolean detailed) {
    if (detailed) {
        printDetails();
    } else {
        System.out.println("Kode Tas = " + getKode());
        System.out.println("Nama Tas = " + getNama());
        System.out.println("Harga Tas = " + getHarga());
    }
}

}