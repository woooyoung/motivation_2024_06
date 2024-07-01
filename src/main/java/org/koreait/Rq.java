package org.koreait;

import java.util.HashMap;
import java.util.Map;

public class Rq {
    private String actionMethod;
    private Map<String, String> params;

    //Rq == Request
    public Rq(String cmd) {
        // parsing
        String[] cmdBits = cmd.split("\\?", 2);

        actionMethod = cmdBits[0];

        params = new HashMap<>();

        String[] paramBits;

        try {
            paramBits = cmdBits[1].split("&");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("명령어 확인해");
            return;
        }

        for (String paramStr : paramBits) {
            String[] paramStrBits = paramStr.split("=", 2);
            String key = paramStrBits[0];
            String value = paramStrBits[1];
            params.put(key, value);
        }
    }

    public String getActionMethod() {
        return actionMethod;
    }

    public String getParams(String paramName) {
        return params.get(paramName);
    }

}