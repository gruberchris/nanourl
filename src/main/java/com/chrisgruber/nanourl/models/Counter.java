package com.chrisgruber.nanourl.models;

import org.springframework.data.annotation.Id;

public class Counter {
    @Id
    public String id;
    public int sequenceValue;

    public Counter() {
    }

    public Counter(String id, int sequenceValue) {
        this.id = id;
        this.sequenceValue = sequenceValue;
    }

    public String get_id() {
        return this.id;
    }

    public void set_id(String id) {
        this.id = id;
    }

    public int get_sequenceValue() {
        return this.sequenceValue;
    }

    public void set_sequenceValue(int sequenceValue) {
        this.sequenceValue = sequenceValue;
    }
}
