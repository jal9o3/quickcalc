
package quickcalc;

import javax.script.ScriptEngineManager;
import javax.script.ScriptEngine;
import javax.script.ScriptException;

public class QuickCalc extends Calculator {
    @Override
    public double calculate(String expression) throws ScriptException {
        ScriptEngineManager mgr = new ScriptEngineManager();
        ScriptEngine engine = mgr.getEngineByName("JavaScript");
        Object result = engine.eval(expression);
        if (result instanceof Double) {
            return (double)(Double)result;
        }
        else if (result instanceof Integer) {
            return (double)(Integer)result;
        }
        else {
            return (double)result;
        }
    }
}
