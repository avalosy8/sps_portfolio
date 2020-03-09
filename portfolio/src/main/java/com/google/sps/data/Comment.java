package com.google.sps.data;

/** A comment on the main portfolio page */
public final class Comment {
    private final long id;
    private final String name;
    private final String text;
    private final long timestamp;
    private final double score;

    public Comment(long id, String name, String text, long timestamp, double score) {
        this.id = id;
        this.name = name;
        this.text = text;
        this.timestamp = timestamp;
        this.score = score;
    }
}