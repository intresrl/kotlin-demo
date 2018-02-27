package it.intre.reloadedCamp.java;

import java.util.List;
import java.util.Map;

public interface Checkout {
    int pay(List<String> items, Map<String, Map.Entry<Integer, Integer>> offers);
}
