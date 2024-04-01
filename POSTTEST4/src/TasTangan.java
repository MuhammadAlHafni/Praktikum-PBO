class TasTangan extends Tas {
    private boolean taliPanjang;

    public TasTangan(String kode, String nama, double harga, boolean taliPanjang) {
        super(kode, nama, harga);
        this.taliPanjang = taliPanjang;
    }

    public boolean isTaliPanjang() {
        return taliPanjang;
    }

    public void setTaliPanjang(boolean taliPanjang) {
        this.taliPanjang = taliPanjang;
    }

    @Override
    void printDetails() {
        super.printDetails();
        if (taliPanjang) {
            System.out.println("Tas Tangan dengan Tali Panjang");
        } else {
            System.out.println("Tas Tangan tanpa Tali Panjang");
        }
    }

    void printDetails(boolean detailed) {
        if (detailed) {
            printDetails();
        } else {
            super.printDetails();
        }
    }
}