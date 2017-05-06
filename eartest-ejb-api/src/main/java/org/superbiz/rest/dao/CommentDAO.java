package org.superbiz.rest.dao;

import org.superbiz.rest.model.Comment;

import java.util.List;

public interface CommentDAO {
    List<Comment> list(long postId) ;

    Comment create(String author, String content, long postId);

    void delete(long id);

    Comment update(long id, String author, String content) ;
}
