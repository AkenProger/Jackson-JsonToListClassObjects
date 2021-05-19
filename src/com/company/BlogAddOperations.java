package com.company;

public class BlogAddOperations {
    Status status;
    int sentCount;
    String type;
    boolean deleted;
    String _id;
    String user;
    String text;
    String source;
    String updatedAt;
    String createdAt;
    boolean used;

    public BlogAddOperations(Status status, int sentCount, String type, boolean deleted, String _id, String user, String text, String source, String updatedAt, String createdAt, boolean used) {
        this.status = status;
        this.sentCount = sentCount;
        this.type = type;
        this.deleted = deleted;
        this._id = _id;
        this.user = user;
        this.text = text;
        this.source = source;
        this.updatedAt = updatedAt;
        this.createdAt = createdAt;
        this.used = used;
    }
}
