package calc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ConvertConstants {
    private String[] constants = { "pi", "e" };
    private Map<String, Double> constantMap = new HashMap<String, Double>();
    private ArrayList<String> userInpList;

    public ConvertConstants(ArrayList<String> userInpList) {
        this.userInpList = userInpList;

        constantMap.put("pi", Math.PI);
        constantMap.put("e", Math.E);
    }

    public ArrayList<String> convert() {
        for (String constant : constants) {
            for (int i = 0; i < userInpList.size(); i++) {
                if (userInpList.get(i).equals(constant)) {
                    userInpList.set(i, constantMap.get(constant) + "");
                } else if (userInpList.get(i).equals("-" + constant)) {
                    // Deals with negative constants
                    userInpList.set(i, "-" + constantMap.get(constant));
                }
            }
        }

        return userInpList;
    }
}