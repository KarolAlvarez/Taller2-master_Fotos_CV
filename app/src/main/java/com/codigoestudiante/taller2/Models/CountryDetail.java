package com.codigoestudiante.taller2.Models;

/**
 * Created by software on 28/09/2017.
 */

public class CountryDetail {
    private String subregion;
    private String languages;
    private Integer area;

    public String getSubregion() {
        return subregion;
    }

    public void setSubregion(String subregion) {
        this.subregion = subregion;
    }

    public String getLanguages() {
        return languages;
    }

    public void setLanguages(String languages) {
        this.languages = languages;
    }

    public Integer getArea() {
        return area;
    }

    public void setArea(Integer area) {
        this.area = area;
    }
}
