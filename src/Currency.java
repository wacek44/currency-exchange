public class Currency {

    String name;
    double value;

    private double targetAmount;


    Currency(String name, double value){ //konstruktor waluty
        if(value <= 0){
            throw new IllegalArgumentException("Enter the correct value");
        }
        this.name = name;
        this.value = value;
    }

    public double convertTo(double amount, Currency targetCurrency){ //metoda, przelicznik walut
        if(amount <= 0){
            throw new IllegalArgumentException("Enter the correct amount");
        }
            targetAmount = amount * (targetCurrency.value / this.value);
            return targetAmount;
    }
}
