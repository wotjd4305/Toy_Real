package model.dto;

public class apt_riseRate {
    String idapt;
    String bun;
    String rank;
    String location;
    String name;
    String ascent;
    String riseRate;
    String before_date;
    String now_date;

    public apt_riseRate(String bun, String rank, String location, String name, String ascent, String riseRate, String before_date, String now_date) {
        this.bun = bun;
        this.rank = rank;
        this.location = location;
        this.name = name;
        this.ascent = ascent;
        this.riseRate = riseRate;
        this.before_date = before_date;
        this.now_date = now_date;
    }

    public String getBun() {
        return bun;
    }

    public String getBefore_date() {
        return before_date;
    }

    public String getNow_date() {
        return now_date;
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

    public String getName() {
        return name;
    }

    public String getAscent() {
        return ascent;
    }

    public String getRiseRate() {
        return riseRate;
    }

}
