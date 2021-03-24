package Calculator;

import java.util.Map;

public class Calculator {

    private Expression expression;
    private double result;
    private int a;
    private int b;
    private String variable;
    private Roman roman;
    private Arabic arabic;

    public void writeExpression(String s) {
       this.expression = new Expression(s);
       this.roman = new Roman();
       this.arabic = new Arabic();
       this.a = variableFirst();
       this.b = variableSecond();
       this.variable = expression.getOperation();
       this.result=  math();
    }

    private double math() {
        double result=0;
        switch (this.variable){
            case "/":
               result= (double) a / b;
                break;
            case "*":
                result = a * b;
                break;
            case "+":
                result = a + b;
                break;
            case "-":
                result = a - b;
                break;
        }
        return  result;
    }

    private int variableFirst() {
        int first = 0;
        if (roman.getFigures().containsKey(expression.getA())){
            for (Map.Entry<String, Integer> map: roman.getFigures().entrySet()){
                if (map.getKey().equals(expression.getA())){
                    first=map.getValue();
                }
            }
        }else if (arabic.getFigures().containsKey(expression.getA())) {
            for (Map.Entry<String, Integer> map : arabic.getFigures().entrySet()) {
                if (map.getKey().equals(expression.getA())) {
                    first = map.getValue();
                }
            }
        }
        return first;
    }

    private int variableSecond() {
        int second = 0;
        if (roman.getFigures().containsKey(expression.getB())){
            for (Map.Entry<String, Integer> map: roman.getFigures().entrySet()){
                if (map.getKey().equals(expression.getB())){
                    second=map.getValue();
                }
            }
        }else if (arabic.getFigures().containsKey(expression.getB())) {
            for (Map.Entry<String,Integer> map : arabic.getFigures().entrySet()) {
                if (map.getKey().equals(expression.getB())) {
                    second = map.getValue();
                }
            }
        }
        return second;
    }

    public void showResult() {
        if (roman.getFigures().containsKey(expression.getA())){
            System.out.printf("%s %s %s = %s",roman.getResult().get(a),variable,roman.getResult().get(b),roman.getResult().get((int)result));
        }else
            System.out.printf("%d %s %d = %.0f",a,variable,b,result);
    }

}
