package com.example.prakt2.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.*;

@Entity
public class flexik {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @NotEmpty(message = "Поле не должно содержать пустоту")
    String flexType, isFlexing, flexSub;
    @Min(message = "Колличество не может быть отрицательным", value = 0)
    @Max(message = "Колличество не может быть больше", value = 1000)
    @NotNull(message = "Не может быть пустым")
    String abobaAmount;
    @NotEmpty(message = "Поле не должно быть пустым")
    @Size(message = "Строка должна быть длиннее 2 символов и короче 31", min = 3, max = 30)
    String flexTitle;

    public flexik(String flexType, String flexTitle, String isFlexing, String flexSub, String abobaAmount) {
        this.flexType = flexType;
        this.flexTitle = flexTitle;
        this.isFlexing = isFlexing;
        this.flexSub = flexSub;
        this.abobaAmount = abobaAmount;
    }

    public flexik() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFlexType() {
        return flexType;
    }

    public void setFlexType(String flexType) {
        this.flexType = flexType;
    }

    public String getFlexTitle() {
        return flexTitle;
    }

    public void setFlexTitle(String flexTitle) {
        this.flexTitle = flexTitle;
    }

    public String getIsFlexing() {
        return isFlexing;
    }

    public void setIsFlexing(String isFlexing) {
        this.isFlexing = isFlexing;
    }

    public String getFlexSub() {
        return flexSub;
    }

    public void setFlexSub(String flexSub) {
        this.flexSub = flexSub;
    }

    public String getAbobaAmount() {
        return abobaAmount;
    }

    public void setAbobaAmount(String abobaAmount) {
        this.abobaAmount = abobaAmount;
    }
}
