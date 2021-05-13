package javaa.controller;

import java.util.HashMap;
import java.util.Map;

public class DB {
    private static final Map<String, User> mapUsers = new HashMap<String, User>();
    static {
        init();
    }
    private static void init() {
        User user = new User("Mit", "Miit","ajhffk", "45155", User.GENDER_MALE,"Html", "Russia");
        User adm = new User("Saida", "Lua", "ghgt", "454554", User.GENDER_FEMALE, "Java", "Italy");
        mapUsers.put(user.getName(), user);
        mapUsers.put(adm.getName(), adm);
    }

    public static User findUser(String Name, String password) {
        User us = mapUsers.get(Name);
        if (us != null && us.getPassword().equals(password)) {
            return us;  }
        return null;
    }
}
