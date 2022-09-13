package com.example.prakt2.models;

import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Collection;

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

    @OneToMany (mappedBy = "name", fetch = FetchType.EAGER)
    Collection<Worker> workers;

    public Collection<Worker> getStudents() {
        return workers;
    }

    public void setStudents(Collection<Worker> students) {
        this.workers = students;
    }

    public crinjolique getCringe() {
        return cringe;
    }

    public void setCringe(crinjolique cringe) {
        this.cringe = cringe;
    }

    @OneToOne(fetch = FetchType.EAGER)
    public crinjolique cringe;
    public flexik(String flexType, String flexTitle, String isFlexing, String flexSub, String abobaAmount, crinjolique cringe, Collection<Worker> students) {
        this.flexType = flexType;
        this.flexTitle = flexTitle;
        this.isFlexing = isFlexing;
        this.flexSub = flexSub;
        this.abobaAmount = abobaAmount;
        this.cringe = cringe;
        this.workers = students;
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
