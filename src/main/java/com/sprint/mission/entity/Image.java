package com.sprint.mission.entity;

import lombok.Data;

import java.io.Serializable;
import java.time.Instant;
import java.util.UUID;

@Data
public class Image implements Serializable {
    private UUID id;
    private String originalName;
    private String extension;
    private String path;
    private String size;
    private Instant createdAt;

}
