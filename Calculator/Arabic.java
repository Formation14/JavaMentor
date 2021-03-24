package Calculator;

import java.util.HashMap;
import java.util.Map;

public class Arabic {
    private Map<String, Integer> figures;

    public Arabic() {
        this.figures=new HashMap<>();
        fill();
    }

    public Map<String, Integer> getFigures() {
        return this.figures;
    }


    private void fill() {
        for (int i = 1; i <= 10 ; i++) {
            figures.put(String.valueOf(i),i);
        }
    }
}
