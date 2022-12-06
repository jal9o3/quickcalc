package quickcalc;

import javax.script.ScriptEngineManager;
import javax.script.ScriptEngine;
import javax.script.ScriptException;

public class QuickCalc extends Calculator {

    private double ans;

    QuickCalc() {
        this.ans = 0;
    }

    public double getAns() {
        return ans;
    }

    @Override
    public double calculate(String expression) throws ScriptException {
        ScriptEngineManager mgr = new ScriptEngineManager();
        ScriptEngine engine = mgr.getEngineByName("JavaScript");
        Object result = engine.eval(expression);
        if (result instanceof Double) {
            ans = (double) (Double) result;
            return ans;
        } else if (result instanceof Integer) {
            ans = (double) (Integer) result;
            return ans;
        } else {
            ans = (double) result;
            return ans;
        }
    }
}
