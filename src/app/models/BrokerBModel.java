package app.models;

import app.utils.Rounder;

public class BrokerBModel implements AppBaseModel {

    @Override
    public String getBonus(double bonus) {
        return Rounder.roundValue(bonus);
    }

    @Override
    public double calcDealCost(int quantity, double price) {
        return quantity * price;
    }

    @Override
    public double calcBonus(double sales) {
        if (sales <= 40000) {
            return sales * 10 / 100;
        } else if (sales <= 70000) {
            return sales * 15 / 100;
        } else {
            return sales * 20 / 100;
        }
    }
}