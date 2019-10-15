package com.ujiuye.test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class App2 {
    public static void main(String[] args) {
        String[] names={"徐杰","倪博海","何文康","刘成华","吴文凯"};
        List<String> name = Arrays.asList(names);
        Collections.shuffle(name);
        System.out.println(name.get(0));
    }
}
