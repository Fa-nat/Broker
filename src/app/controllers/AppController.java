package app.controllers;

import app.entities.Broker;
import app.entities.Product;
import app.models.BrokerAModel;
import app.models.BrokerBModel;
import app.utils.Constants;
import app.utils.Rounder;
import app.utils.Validator;
import app.views.AppView;

public class AppController {

    AppView view = new AppView();
    private String brokerName;
    private String brokerPhone;
    private String brokerEmail;
    private String productName;
    private int productQuota;
    private double productPrice;
    private String dealCost;
    private String bonus;
    private String[] outData;

    public void getBonusA() {
        getBrokerData();
        getProductData();
        view.closeScanner();

        if (Validator.isDataVal(productQuota, productPrice)) {
            BrokerAModel model = new BrokerAModel() {
                @Override
                public double calcBonus() {
                    return 0;
                }
            };
            dealCost = Rounder.roundValue(
                    model.calcDealCost(productQuota, productPrice));
            bonus = model.getBonus(model.calcBonus(
                    model.calcDealCost(productQuota, productPrice)));
            outData = new String[]{brokerName, brokerPhone, brokerEmail, productName,
                    dealCost, bonus};
            view.getOutput(formOutput(outData));
        } else {
            view.getOutput(Constants.SMTH_WRONG_MSG);
        }
    }

    public void getBonusB(String Constants) {
        getBrokerData();
        getProductData();
        view.closeScanner();

        if (Validator.isDataValid(productQuota, productPrice)) {
            BrokerBModel model = new BrokerBModel();
            dealCost = Rounder.roundValue(
                    model.calcDealCost(productQuota, productPrice));
            bonus = model.getBonus(model.calcBonus(
                    model.calcDealCost(productQuota, productPrice)));
            outData = new String[]{brokerName, brokerPhone, brokerEmail, productName,
                    dealCost, bonus};
            view.getOutput(formOutput(outData));
        } else {
            view.getOutput(Constants);
        }
    }

    private void getBrokerData() {
        Broker broker = view.getBrokerData();
        brokerName = broker.getName();
        brokerPhone = broker.getPhone();
        brokerEmail = broker.getEmail();
    }

    private void getProductData() {
        Product product = view.getProductData();
        productName = product.getName();
        productQuota = product.getQuota();
        productPrice = product.getPrice();
    }

    private String formOutput(String[] data) {
        return "\nBroker: " + data[0] + ", " + data[5] + ", " + data[2] +
                "\nProduct: " + data[3] + ", deal cost is USD " + data[4] +
                "\nBonus is USD " + data[5];
    }
}
