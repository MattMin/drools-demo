package com.mzy.droolsdemo.entity;

import java.util.Date;

public class Application {
    private Date dateApplied;

    private boolean valid;

    public Application(Date dateApplied, boolean valid) {
        this.dateApplied = dateApplied;
        this.valid = valid;
    }

    public Application() {
        this.dateApplied = new Date();
        this.valid = false;
    }

    public Date getDateApplied() {
        return dateApplied;
    }

    public void setDateApplied(Date dateApplied) {
        this.dateApplied = dateApplied;
    }

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }
}
