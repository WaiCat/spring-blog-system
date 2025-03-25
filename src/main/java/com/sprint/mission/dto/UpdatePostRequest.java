package com.sprint.mission.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
public class UpdatePostRequest {
    private UUID id;
    private String title;
    private String content;
    private List<String> tags;
}
