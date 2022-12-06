package quickcalc;

public abstract class Calculator {
    
    private double ans;
    
    public abstract double calculate(String expression) throws Exception;
}
