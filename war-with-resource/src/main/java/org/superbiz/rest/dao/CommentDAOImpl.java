package org.superbiz.rest.dao;

import org.superbiz.rest.model.Comment;
import org.superbiz.rest.model.Post;

import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Singleton;
import javax.inject.Inject;
import java.util.Collections;
import java.util.List;

@Singleton(name = "CommentDAO")
@Lock(LockType.READ)
public class CommentDAOImpl implements CommentDAO {

    @Inject
    private CommonDao commonDao;

    public List<Comment> list(long postId) {
        Post post = commonDao.find(Post.class, postId);
        if (post == null) {
            throw new IllegalArgumentException("post with id " + postId + " not found");
        }
        return Collections.unmodifiableList(post.getComments());
    }

    public Comment create(String author, String content, long postId) {
        Post post = commonDao.find(Post.class, postId);
        if (post == null) {
            throw new IllegalArgumentException("post with id " + postId + " not found");
        }

        Comment comment = new Comment();
        comment.setAuthor(author);
        comment.setContent(content);
        commonDao.create(comment);
        comment.setPost(post);
        return comment;
    }

    public void delete(long id) {
        commonDao.delete(Comment.class, id);
    }

    public Comment update(long id, String author, String content) {
        Comment comment = commonDao.find(Comment.class, id);
        if (comment == null) {
            throw new IllegalArgumentException("comment with id " + id + " not found");
        }

        comment.setAuthor(author);
        comment.setContent(content);
        return commonDao.update(comment);
    }
}
