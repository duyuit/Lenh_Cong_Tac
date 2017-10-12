package Model;

import java.io.Serializable;

/**
 * Created by Billy on 10/11/2017.
 */

public class Command_Collapse  implements Serializable{
    String id,direct,locate,context;
    String giamsat,dvyeucau,dkantoan,tungay,denngay,tbthinghiem,phuongtien,sdtlaixe,gioracong,thihanhlenh;

    public String getGiamsat() {
        return giamsat;
    }

    public void setGiamsat(String giamsat) {
        this.giamsat = giamsat;
    }

    public String getDvyeucauucau() {
        return dvyeucau;
    }

    public void setDvyrucau(String dvyeucau) {
        this.dvyeucau = dvyeucau;
    }

    public String getDkantoan() {
        return dkantoan;
    }

    public void setDkantoan(String dkantoan) {
        this.dkantoan = dkantoan;
    }

    public String getTungay() {
        return tungay;
    }

    public void setTungay(String tungay) {
        this.tungay = tungay;
    }

    public String getDenngay() {
        return denngay;
    }

    public void setDenngay(String denngay) {
        this.denngay = denngay;
    }

    public String getTbthinghiem() {
        return tbthinghiem;
    }

    public void setTbthinghiem(String tbthinghiem) {
        this.tbthinghiem = tbthinghiem;
    }

    public String getPhuongtien() {
        return phuongtien;
    }

    public void setPhuongtien(String phuongtien) {
        this.phuongtien = phuongtien;
    }

    public String getSdtlaixe() {
        return sdtlaixe;
    }

    public void setSdtlaixe(String sdtlaixe) {
        this.sdtlaixe = sdtlaixe;
    }

    public String getGioracong() {
        return gioracong;
    }

    public void setGioracong(String gioracong) {
        this.gioracong = gioracong;
    }

    public String getThihanhlenh() {
        return thihanhlenh;
    }

    public void setThihanhlenh(String thihanhlenh) {
        this.thihanhlenh = thihanhlenh;
    }

    public Command_Collapse(String id, String direct, String locate, String context, String giamsat, String dvyeucau, String dkantoan, String tungay, String denngay, String tbthinghiem, String phuongtien, String sdtlaixe, String gioracong, String thihanhlenh) {

        this.id = id;
        this.direct = direct;
        this.locate = locate;
        this.context = context;
        this.giamsat = giamsat;
        this.dvyeucau = dvyeucau;
        this.dkantoan = dkantoan;
        this.tungay = tungay;
        this.denngay = denngay;
        this.tbthinghiem = tbthinghiem;
        this.phuongtien = phuongtien;
        this.sdtlaixe = sdtlaixe;
        this.gioracong = gioracong;
        this.thihanhlenh = thihanhlenh;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDirect() {
        return direct;
    }

    public void setDirect(String direct) {
        this.direct = direct;
    }

    public String getLocate() {
        return locate;
    }

    public void setLocate(String locate) {
        this.locate = locate;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public Command_Collapse(String id, String direct, String locate, String context) {

        this.id = id;
        this.direct = direct;
        this.locate = locate;
        this.context = context;
    }
}
