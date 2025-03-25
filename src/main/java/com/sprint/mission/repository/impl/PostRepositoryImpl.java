package com.sprint.mission.repository.impl;

import com.sprint.mission.dto.PostInfoDto;
import com.sprint.mission.dto.UpdatePostRequest;
import com.sprint.mission.entity.Post;
import com.sprint.mission.repository.FileStorageManager;
import com.sprint.mission.repository.PostRepository;
import com.sprint.mission.repository.UserRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository
public class PostRepositoryImpl implements PostRepository {

    private final FileStorageManager fileStorageManager;
    private final Map<UUID, Post> posts;
    private final String fileName = "posts.src";
    private final UserRepository userRepository;

    public PostRepositoryImpl(FileStorageManager fileStorageManager, UserRepository userRepository) {
        this.fileStorageManager = fileStorageManager;
        this.userRepository = userRepository;
        this.posts = fileStorageManager.loadFile(fileName);
    }

    private void save() {
        fileStorageManager.saveFile(fileName, posts);
    }

    @Override
    public void addPost(Post post) {
        posts.put(post.getId(), post);
        save();
    }

    @Override
    public List<PostInfoDto> getAllPosts() {
        return posts.values().stream()
                .map(post -> {
                    String nickname = userRepository.getUserInfo(post.getAuthorId()).getNickname();
                    return PostInfoDto.toDto(post, nickname);
                })
                .collect(Collectors.toList());
    }

    @Override
    public Post getPostById(UUID postId) {
        return posts.get(postId);
    }

    @Override
    public void updatePost(UpdatePostRequest updatePostRequest) {
        Post post = posts.get(updatePostRequest.getId());

        if (updatePostRequest.getTitle() != null) post.setTitle(updatePostRequest.getTitle());
        if (updatePostRequest.getContent() != null) post.setContent(updatePostRequest.getContent());
        if (updatePostRequest.getTags() != null) post.setTags(updatePostRequest.getTags());

        post.updateTime();
        posts.put(post.getId(), post);
        save();
    }

    @Override
    public void deletePost(UUID postId) {
        posts.remove(postId);
        save();
    }
}
