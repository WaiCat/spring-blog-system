package com.sprint.mission.dto;

import com.sprint.mission.entity.Post;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@Builder
public class PostInfoDto {
    private UUID id;
    private String title;
    private String content;
    private String authorId;
    private String authorNickname;
    private Instant publishDate;
    private List<String> tags;

    public static PostInfoDto toDto(Post post, String authorNickname) {
        return PostInfoDto.builder()
                .id(post.getId())
                .title(post.getTitle())
                .content(post.getContent())
                .authorId(post.getAuthorId())
                .authorNickname(authorNickname)
                .publishDate(post.getCreatedAt())
                .tags(post.getTags())
                .build();
    }

}
