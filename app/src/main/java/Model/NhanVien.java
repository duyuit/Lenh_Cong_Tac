package Model;

/**
 * Created by Hoi on 10/13/2017.
 */

public class NhanVien {
    String Ten;
    String Bac;

    public NhanVien(String ten, String bac, String donVi) {
        Ten = ten;
        Bac = bac;
        DonVi = donVi;
    }

    public String getTen() {
        return Ten;
    }

    public void setTen(String ten) {
        Ten = ten;
    }

    public String getBac() {
        return Bac;
    }

    public void setBac(String bac) {
        Bac = bac;
    }

    public String getDonVi() {
        return DonVi;
    }

    public void setDonVi(String donVi) {
        DonVi = donVi;
    }

    String DonVi;
}
