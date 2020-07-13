package model.dto;

public class apt_charterRate {
    String idapt;
    String bun;
    String rank;
    String location;
    String name;
    String apt_charterRate;
    String gap;
    String salePrice;
    String charter;


    public String getBun() {
        return bun;
    }

    public String getSalePrice() {
        return salePrice;
    }

    public String getName() {
        return name;
    }

    public String getIdapt() {
        return idapt;
    }

    public String getRank() {
        return rank;
    }

    public String getLocation() {
        return location;
    }

    public String getApt_charterRate() {
        return apt_charterRate;
    }

    public String getGap() {
        return gap;
    }

    public String getCharter() {
        return charter;
    }


    public apt_charterRate(String bun, String rank, String location, String name, String apt_charterRate, String gap, String salePrice, String charter) {

        this.bun = bun;
        this.rank = rank;
        this.location = location;
        this.name = name;
        this.apt_charterRate = apt_charterRate;
        this.gap = gap;
        this.salePrice = salePrice;
        this.charter = charter;
    }

}
