package com.portfolio.punteri.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Proyectos {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idPro;
    private String TituloPro;
    private String descPro;
    private String imgPro;

    private String urlPro;

    public Proyectos() {
    }

    public Proyectos(Long idPro, String TituloPro, String descPro, String imgPro, String urlPro) {
        this.idPro = idPro;
        this.TituloPro = TituloPro;
        this.descPro = descPro;
        this.imgPro = imgPro;
        this.urlPro = urlPro;
    }

    public Long getIdPro() {
        return idPro;
    }

    public void setIdPro(Long idPro) {
        this.idPro = idPro;
    }

    public String getTituloPro() {
        return TituloPro;
    }

    public void setTituloPro(String tituloPro) {
        TituloPro = tituloPro;
    }

    public String getDescPro() {
        return descPro;
    }

    public void setDescPro(String descPro) {
        this.descPro = descPro;
    }

    public String getImgPro() {
        return imgPro;
    }

    public void setImgPro(String imgPro) {
        this.imgPro = imgPro;
    }

    public String getUrlPro() {
        return urlPro;
    }

    public void setUrlPro(String urlPro) {
        this.urlPro = urlPro;}
}
