class TasRansel extends Tas {
    private int kapasitas;

    public TasRansel(final String kode, final String nama, final double harga, final int kapasitas) {
        super(kode, nama, harga);
        this.kapasitas = kapasitas;
    }

    public int getKapasitas() {
        return kapasitas;
    }

    public void setKapasitas(final int kapasitas) {
        this.kapasitas = kapasitas;
    }

    @Override
    final void printDetails() {
        System.out.println("Kode Tas = " + getKode());
        System.out.println("Nama Tas = " + getNama());
        System.out.println("Harga Tas = " + getHarga());
        System.out.println("Kapasitas Tas Ransel = " + kapasitas + " liter");
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
