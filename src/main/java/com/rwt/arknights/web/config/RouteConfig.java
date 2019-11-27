package com.rwt.arknights.web.config;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class RouteConfig {

    static Map<String, String> routeMap = new HashMap<>();
    static {
        routeMap.put("/", "/index");
    }
}
