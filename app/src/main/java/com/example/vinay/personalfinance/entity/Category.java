package com.example.vinay.personalfinance.entity;

/**
 * Created by Vinay on 25-01-2016.
 */
public class Category {



    private int id;
    private String categoryName;
    private float spentAmt;

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public float getSpentAmt() {
        return spentAmt;
    }

    public void setSpentAmt(float spentAmt) {
        this.spentAmt = spentAmt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


}


