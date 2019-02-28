package br.com.ernanilima.jpdv.Model;

import java.sql.Date;
import java.sql.Time;

/**
 * Model de Abertura de caixa PDV
 *
 * @author Ernani Lima
 */
public class OpeningPDV {

    private int id;
    private int supervisorID;
    private double initialValue;
    private Date date;
    private Time hour;
    private boolean status;
    private CompanyBR mCompany;
    private User mUser;
    private PDV mPDV;

    // Construtor vazio
    public OpeningPDV() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSupervisorID() {
        return supervisorID;
    }

    public void setSupervisorID(int supervisorID) {
        this.supervisorID = supervisorID;
    }

    public double getInitialValue() {
        return initialValue;
    }

    public void setInitialValue(double initialValue) {
        this.initialValue = initialValue;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getHour() {
        return hour;
    }

    public void setHour(Time hour) {
        this.hour = hour;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public CompanyBR getmCompany() {
        return mCompany;
    }

    public void setmCompany(CompanyBR mCompany) {
        this.mCompany = mCompany;
    }

    public User getmUser() {
        return mUser;
    }

    public void setmUser(User mUser) {
        this.mUser = mUser;
    }

    public PDV getmPDV() {
        return mPDV;
    }

    public void setmPDV(PDV mPDV) {
        this.mPDV = mPDV;
    }
}
