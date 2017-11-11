import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static java.lang.Double.valueOf;

/**
 * Created by Andrzej on 2017-09-09.
 */
public class MathOps {
    public double calculate(String equation) {
        List<String> equationList = new LinkedList<>(Arrays.asList(equation.split(" ")));

        while (equationList.size() > 1) {
            for (int i = 0; i < equationList.size(); i++) {
                double temp = 0;
                if (equationList.get(i).equals("*")) {
                    temp = valueOf(equationList.get(i - 1)) * valueOf(equationList.get(i + 1));
                    this.remove(i, equationList);
                    equationList.add(i - 1, Double.toString(temp));

                } else if (equationList.get(i).equals("/")) {
                    temp = valueOf(equationList.get(i - 1)) / valueOf(equationList.get(i + 1));
                    this.remove(i, equationList);
                    equationList.add(i - 1, Double.toString(temp));

                } else if (equationList.get(i).equals("mod")) {
                    temp = valueOf(equationList.get(i - 1)) % valueOf(equationList.get(i + 1));
                    this.remove(i, equationList);
                    equationList.add(i - 1, Double.toString(temp));

                }
            }

            for (int i = 0; i < equationList.size(); i++) {
                double temp = 0;
                if (equationList.get(i).equals("+")) {
                    temp = valueOf(equationList.get(i - 1)) + valueOf(equationList.get(i + 1));
                    this.remove(i, equationList);
                    equationList.add(i - 1, Double.toString(temp));

                } else if (equationList.get(i).equals("-")) {
                    temp = valueOf(equationList.get(i - 1)) - valueOf(equationList.get(i + 1));
                    this.remove(i, equationList);
                    equationList.add(i - 1, Double.toString(temp));

                }
            }
        }
        return valueOf(equationList.get(0));
    }

    public void remove (int index, List<String> list) {
        list.remove(index);
        list.remove(index);
        list.remove(index - 1);
    }
}
