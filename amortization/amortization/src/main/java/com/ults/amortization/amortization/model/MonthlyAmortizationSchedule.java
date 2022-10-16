package com.ults.amortization.amortization.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class MonthlyAmortizationSchedule {

    @DateTimeFormat(pattern = "MM/dd/yyyy")
    private Date startDate;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "loanAmount")
    private double loanAmount;
    @Column(name = "interestRate")
    private double interestRate;
    @Column(name = "durationInMonths")
    private int durationInMonths;

    private double futureValue;

    @Column(name = "paymentType")
    private int paymentType;

    private double monthlyPayment;

    // @OneToMany(mappedBy = "Payment")
    // private List<Payment> paymentList = new ArrayList<Payment>();

    public Date getStartDate() {
        return this.startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public double getloanAmount() {
        return this.loanAmount;
    }

    public void setloanAmount(double loanAmount) {
        this.loanAmount = loanAmount;
    }

    public double getInterestRate() {
        return this.interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public int getDurationInMonths() {
        return this.durationInMonths;
    }

    public void setDurationInMonths(int durationInMonths) {
        this.durationInMonths = durationInMonths;
    }

    public double getFutureValue() {
        return this.futureValue;
    }

    public void setFutureValue(double futureValue) {
        this.futureValue = futureValue;
    }

    public int getPaymentType() {
        return this.paymentType;
    }

    public void setPaymentType(int paymentType) {
        this.paymentType = paymentType;
    }

    public double getMonthlyPayment() {
        return this.monthlyPayment;
    }

    public void setMonthlyPayment(double monthlyPayment) {
        this.monthlyPayment = monthlyPayment;
    }

    // public List<Payment> getPaymentList() {
    // return this.paymentList;
    // }

    // public void setPaymentList(List<Payment> paymentList) {
    // this.paymentList = paymentList;
    // }

    // public void addAllPayments(List<Payment> paymentList) {
    // this.paymentList.addAll(paymentList);
    // }

    @Override
    public String toString() {
        return "[" + startDate + "," + loanAmount
                + "," + interestRate + "," + durationInMonths + "," + futureValue
                + "," + paymentType + "," + monthlyPayment + "]";
    }

}
