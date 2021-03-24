package Calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Expression {

    private String expression;
    private String a;
    private String b;
    private String operation;
    private Roman romanFigures;
    private Arabic arabicFigures;
    private String[] variables;

    public Expression(String readLine) {
        this.expression = readLine.replaceAll("\\s+", "");
        this.variables = expression.split("[*/+-]");
        this.a = variables[0];
        this.b = variables[1];
        this.romanFigures = new Roman();
        this.arabicFigures = new Arabic();
        this.operation = findMathSymbol();
        checkExpression();
    }

    private String findMathSymbol() {
        String mathSymbol = "";
        String[] ex = expression.split("");
        Pattern pattern = Pattern.compile("[*/+-]");
        int count = 0;
        for (String s : ex) {
            Matcher matcher = pattern.matcher(s);
            while (matcher.find()) {
                mathSymbol=s;
                count++;
            }
        }
        if (count != 1) try {
            throw new ConditionException("Выражение записание не корректно, смотри условие задачи");
        } catch (ConditionException e) {
            e.printStackTrace();
        }
        return mathSymbol;
    }

    private void checkExpression() {
        System.out.println(arabicFigures.getFigures().get(a));
        System.out.println(arabicFigures.getFigures().get(b));
        try {
            if ((romanFigures.getFigures().containsKey(a) && arabicFigures.getFigures().containsKey(b)) ||
                    (arabicFigures.getFigures().containsKey(a) && romanFigures.getFigures().containsKey(b))) {
                throw new ConditionException("В выражении разные системы исчисления, смотри условие задачи");
            }
            if ((!arabicFigures.getFigures().containsKey(a) && arabicFigures.getFigures().get(a) > 10) ||
                    (!arabicFigures.getFigures().containsKey(a) && arabicFigures.getFigures().get(a) < 1) ||
                    (!arabicFigures.getFigures().containsKey(b) && arabicFigures.getFigures().get(b) > 10) ||
                    (!arabicFigures.getFigures().containsKey(b) && arabicFigures.getFigures().get(b) < 1) ||
                    (romanFigures.getFigures().containsKey(a) && romanFigures.getFigures().get(a) > 10) ||
                    (romanFigures.getFigures().containsKey(a) && romanFigures.getFigures().get(a) < 1) ||
                    (romanFigures.getFigures().containsKey(b) && romanFigures.getFigures().get(b) > 10) ||
                    (romanFigures.getFigures().containsKey(b) && romanFigures.getFigures().get(b) < 1)) {
                throw new ConditionException("Выражение не удовлетворяет условию");
            }
        } catch (ConditionException e) {
            e.printStackTrace();
        }
    }

    public String getA() {
        return a;
    }

    public String getB() {
        return b;
    }

    public String getOperation() {
        return operation;
    }
}
