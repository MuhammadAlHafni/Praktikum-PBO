class TasRansel extends Tas {
    private int kapasitas;

    public TasRansel(String kode, String nama, double harga, int kapasitas) {
        super(kode, nama, harga);
        this.kapasitas = kapasitas;
    }

    public int getKapasitas() {
        return kapasitas;
    }

    public void setKapasitas(int kapasitas) {
        this.kapasitas = kapasitas;
    }

    @Override
    void printDetails() {
        super.printDetails();
        System.out.println("Kapasitas Tas Ransel = " + kapasitas + " liter");
    }

    void printDetails(boolean detailed) {
        if (detailed) {
            printDetails();
        } else {
            super.printDetails();
        }
    }
}