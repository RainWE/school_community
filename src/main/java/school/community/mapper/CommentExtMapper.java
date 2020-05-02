package school.community.mapper;


import school.community.model.Comment;

public interface CommentExtMapper {
    int incCommentCount(Comment comment);
}