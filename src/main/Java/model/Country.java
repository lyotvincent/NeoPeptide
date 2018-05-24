package model;

public class Country {
    private String country_id;

    private String country_name;

    private Long visitcount;

    private Long downloadcount;

    public Country(String country_id, String country_name, Long visitcount, Long downloadcount) {
        this.country_id = country_id;
        this.country_name = country_name;
        this.visitcount = visitcount;
        this.downloadcount = downloadcount;
    }

    public Country() {
        super();
    }

    public String getcountry_id() {
        return country_id;
    }

    public void setcountry_id(String country_id) {
        this.country_id = country_id == null ? null : country_id.trim();
    }

    public String getcountry_name() {
        return country_name;
    }

    public void setcountry_name(String country_name) {
        this.country_name = country_name == null ? null : country_name.trim();
    }

    public Long getVisitcount() {
        return visitcount;
    }

    public void setVisitcount(Long visitcount) {
        this.visitcount = visitcount;
    }

    public Long getDownloadcount() {
        return downloadcount;
    }

    public void setDownloadcount(Long downloadcount) {
        this.downloadcount = downloadcount;
    }
}