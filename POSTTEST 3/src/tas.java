class Tas {
    private String kode;
    private String nama;
    private double harga;

    public Tas(String kode, String nama, double harga) {
        this.kode = kode;
        this.nama = nama;
        this.harga = harga;
    }

    public String getKode() {
        return kode;
    }

    public String getNama() {
        return nama;
    }

    public double getHarga() {
        return harga;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setHarga(double harga) {
        this.harga = harga;
    }

    protected void setKode(String kode) {
        this.kode = kode;
    }

    void printDetails() {
        System.out.println("Kode Tas = " + kode);
        System.out.println("Nama Tas = " + nama);
        System.out.println("Harga Tas = " + harga);
    }
}

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
}

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
}