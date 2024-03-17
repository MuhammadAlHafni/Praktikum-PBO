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

    @Override
    public String toString() {
        return "\nKode Tas = " + kode + "\nNama Tas = " + nama + "\nHarga Tas = " + harga ;
    }
}