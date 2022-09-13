package com.example.prakt2.models;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class crinjolique {

    @OneToOne(fetch = FetchType.EAGER)
    public flexik flex;

    public flexik getFlex() {
        return flex;
    }

    public void setFlex(flexik flex) {
        this.flex = flex;
    }

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

    public crinjolique(String isCringe, String crinjeModifier, String crinjeCount, String eshePole, String esheodnoPole, flexik flex) {
        this.isCringe = isCringe;
        this.crinjeModifier = crinjeModifier;
        this.crinjeCount = crinjeCount;
        this.eshePole = eshePole;
        this.esheodnoPole = esheodnoPole;
        this.flex = flex;
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
    @NotEmpty(message = "Поле не должно быть пустым")
    @Size(message = "Строка должна быть длиннее 4 символов и короче 16", min = 5, max = 15)
    public String isCringe;
    @NotEmpty(message = "Поле не должно быть пустым")
    public String crinjeModifier;
    @NotEmpty(message = "Поле не должно быть пустым")

    public String crinjeCount;
    @NotEmpty(message = "Поле не должно быть пустым")

    public String eshePole;
    @NotEmpty(message = "Поле не должно быть пустым")

    public String esheodnoPole;


}
