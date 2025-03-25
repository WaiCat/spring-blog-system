package com.sprint.mission.entity;

import lombok.Data;

import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
public class Post implements Serializable {
    private final UUID id;
    private String title;
    private String content;
    private final String authorId;
    private List<String> tags = new ArrayList<>();
    private final Instant createdAt;
    private Instant updatedAt;


    public void updateTime() {
        this.updatedAt = Instant.now();
    }

    public void addTags(String tag) {
        this.tags.add(tag);
        updateTime();
    }

    public void removeTags(String tag) {
        this.tags.remove(tag);
        updateTime();
    }

}
