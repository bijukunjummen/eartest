package org.superbiz.rest.dao;

import org.superbiz.rest.model.Post;

import java.util.List;

public interface PostDAO {
    Post create(String title, String content, long userId);

    Post find(long id);

    List<Post> list(int first, int max);

    void delete(long id);
    Post update(long id, long userId, String title, String content);
}
