package app.models;

public interface AppBaseModel {
    String getBonus(double bonus);

    double calcDealCost(int quantity, double price);
    double calcBonus(double sales);
}
