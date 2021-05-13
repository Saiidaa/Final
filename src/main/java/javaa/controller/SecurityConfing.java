package javaa.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

class SecurityConfig {

    public static final String ROLE_ADMIN = "ADMIN";
    public static final String ROLE_USER = "USER";

    private static final Map<String, List<String>> mapConf = new HashMap<String, List<String>>();
    static {
        init();
    }
    private static void init() {
        List<String> UseR = new ArrayList<String>();
        UseR.add("/userInfo");
        mapConf.put(ROLE_USER, UseR);


        List<String> AdmIN = new ArrayList<String>();
        AdmIN.add("/userInfo");
        AdmIN.add("/Contact");
        mapConf.put(ROLE_ADMIN, AdmIN);
    }

    public static Set<String> getRoles() {
        return mapConf.keySet();
    }

    public static List<String> getRole(String role) {
        return mapConf.get(role);
    }

}