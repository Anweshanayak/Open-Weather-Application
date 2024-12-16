package com.anwesha.chicagoillinois;

import java.io.Serializable;

public class Hourly implements Serializable {
    public String datetimeEpoch;
    public String temp;
    public String conditions;
    public String icon;

    public Hourly(String datetimeEpoch, String temp, String conditions, String icon) {
        this.datetimeEpoch = datetimeEpoch;
        this.temp = temp;
        this.conditions = conditions;
        this.icon = icon;
    }

    public String getDatetimeEpoch() {
        return datetimeEpoch;
    }

    public void setDatetimeEpoch(String datetimeEpoch) {
        this.datetimeEpoch = datetimeEpoch;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public String getConditions() {
        return conditions;
    }

    public void setConditions(String conditions) {
        this.conditions = conditions;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
      //  67139c666ba6db4ba5c1eb8879aa9022;

    }
}
