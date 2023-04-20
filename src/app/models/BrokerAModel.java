package app.models;

import app.utils.Rounder;

public abstract class BrokerAModel implements AppBaseModel {

    private final static double RATE_INSURANCE = 2.5;

    @Override
    public String getBonus(double bonus) {
        return Rounder.roundValue(bonus);
    }

    @Override
    public double calcDealCost(int quantity, double price) {
        return quantity * price + (quantity * price) * RATE_INSURANCE / 100;
    }

    @Override
    public double calcBonus(double sales) {
        if (sales <= 50000) {
            return sales * 10 / 100;
        } else {
            return sales * 20 / 100;
        }
    }

    public abstract double calcBonus();
}