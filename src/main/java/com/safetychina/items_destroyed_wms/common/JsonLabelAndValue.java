package com.safetychina.items_destroyed_wms.common;

public class JsonLabelAndValue {
    private String label;
    private String value;

    public JsonLabelAndValue(String label, String value) {
        this.label = label;
        this.value = value;
    }

    @Override
    public String toString() {
        return "{" +
                "label='" + label + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
