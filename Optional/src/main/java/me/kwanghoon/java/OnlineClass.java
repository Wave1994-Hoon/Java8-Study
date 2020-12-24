package me.kwanghoon.java;

import java.util.Optional;

public class OnlineClass {

    private Integer id;

    private String title;

    private boolean closed;

    private Progress progress;

    /* Optional 은 리턴 타입으로만 사용하는걸 권장함 */
    public Optional<Progress> getProgress() {
        return Optional.ofNullable(progress); // Optional.of() --> Not Null
    }

    public void setProgress(Progress progress) {
        this.progress = progress;
    }

    public OnlineClass(Integer id, String title, boolean closed) {
        this.id = id;
        this.title = title;
        this.closed = closed;
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public boolean isClosed() {
        return closed;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setClosed(boolean closed) {
        this.closed = closed;
    }
}
