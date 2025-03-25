package com.sprint.mission.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.UUID;

@Data
public class PostImage implements Serializable {
    private UUID id;
    private UUID postId;
    private UUID imagedId;
}
