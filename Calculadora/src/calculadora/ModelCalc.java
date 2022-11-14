package calculadora;

public class ModelCalc {
    private double resultado;
    private CalcOperation operation;
    
    public ModelCalc() {
        operation = CalcOperation.NONE;
        resultado = 0;
    }
    
    //Getters & Setters
    public void setResultado(double res) {
        resultado = res;
    }
    public double getResultado() {
        return resultado;
    }    
    public CalcOperation getOperation() {
        return operation;
    }    
    public void setOperation(CalcOperation op) {
        operation = op;
    }
    
    private double add(double num) {
        return resultado + num;
    }
    
    private double substract(double num) {
        return resultado - num;
    }
    
    private double multiply(double num) {
        return resultado * num;
    }
    
    private double divide(double num){
        if(num != 0)
            return resultado / num;
        else
            throw new NumberFormatException("Dividing by zero");
    }
    
    public void calculate(double num) {
        switch(operation) {
            case ADDITION -> {
                resultado = add(num);
            }
            case SUBSTRACTION -> {
                resultado = substract(num);
            }
            case MULTIPLICATION -> {
                resultado = multiply(num);
            }
            case DIVISION -> {
                resultado = divide(num);
            }
        }
    }
}
