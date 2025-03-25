package com.sprint.mission.repository;

import com.sprint.mission.dto.PostInfoDto;
import com.sprint.mission.dto.UpdatePostRequest;
import com.sprint.mission.entity.Post;

import java.util.List;
import java.util.UUID;

public interface PostRepository {
    void addPost(Post post);

    List<PostInfoDto> getAllPosts();

    Post getPostById(UUID postId);

    void updatePost(UpdatePostRequest updatePostRequest);

    void deletePost(UUID postId);

}
