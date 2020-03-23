package io.gitlab.mihajlonesic.springgraphqlmysql.exception;

public class ProjectException extends AbstractGraphqlException {
    public ProjectException(int errorCode, String errorMessage) {
        super(errorCode, errorMessage);
    }
}