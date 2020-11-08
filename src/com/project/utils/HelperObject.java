package com.project.utils;
public class HelperObject {
    public String[] items;

    public HelperObject(String... items) {
        this.items = items; // should probably make a defensive copy
    }

    public String get(int x) {
        return items[x];
    }
}