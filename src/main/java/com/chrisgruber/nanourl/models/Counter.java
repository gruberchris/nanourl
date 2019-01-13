package com.chrisgruber.nanourl.models;

import org.springframework.data.annotation.Id;

public class Counter {
    @Id
    private String id;
    private int sequenceValue;

    public Counter() {
    }

    public Counter(String id, int sequenceValue) {
        this.id = id;
        this.sequenceValue = sequenceValue;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getSequenceValue() {
        return sequenceValue;
    }

    public void setSequenceValue(int sequenceValue) {
        this.sequenceValue = sequenceValue;
    }
}
