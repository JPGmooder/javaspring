package com.example.prakt2.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class crinjolique {

    @GeneratedValue
    @Id
    public Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIsCringe() {
        return isCringe;
    }

    public void setIsCringe(String isCringe) {
        this.isCringe = isCringe;
    }

    public String getCrinjeModifier() {
        return crinjeModifier;
    }

    public crinjolique(String isCringe, String crinjeModifier, String crinjeCount, String eshePole, String esheodnoPole) {
        this.isCringe = isCringe;
        this.crinjeModifier = crinjeModifier;
        this.crinjeCount = crinjeCount;
        this.eshePole = eshePole;
        this.esheodnoPole = esheodnoPole;
    }

    public crinjolique() {
    }

    public void setCrinjeModifier(String crinjeModifier) {
        this.crinjeModifier = crinjeModifier;
    }

    public String getCrinjeCount() {
        return crinjeCount;
    }

    public void setCrinjeCount(String crinjeCount) {
        this.crinjeCount = crinjeCount;
    }

    public String getEshePole() {
        return eshePole;
    }

    public void setEshePole(String eshePole) {
        this.eshePole = eshePole;
    }

    public String getEsheodnoPole() {
        return esheodnoPole;
    }

    public void setEsheodnoPole(String esheodnoPole) {
        this.esheodnoPole = esheodnoPole;
    }

    public String isCringe;
    public String crinjeModifier;
    public String crinjeCount;
    public String eshePole;
    public String esheodnoPole;


}
