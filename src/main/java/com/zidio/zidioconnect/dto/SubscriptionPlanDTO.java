package com.zidio.zidioconnect.dto;

import com.zidio.zidioconnect.enums.PlanType;

public class SubscriptionPlanDTO {

    private Long id;
    private String name;
    private String description;
    private Double price;
    private Integer durationInDays;
    private PlanType planType;
    private Boolean isActive;

    public SubscriptionPlanDTO() {}

    public SubscriptionPlanDTO(Long id, String name, String description, Double price,
                               Integer durationInDays, PlanType planType, Boolean isActive) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.durationInDays = durationInDays;
        this.planType = planType;
        this.isActive = isActive;
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getDurationInDays() {
        return durationInDays;
    }

    public void setDurationInDays(Integer durationInDays) {
        this.durationInDays = durationInDays;
    }

    public PlanType getPlanType() {
        return planType;
    }

    public void setPlanType(PlanType planType) {
        this.planType = planType;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean active) {
        isActive = active;
    }
}