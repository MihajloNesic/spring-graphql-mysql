package io.gitlab.mihajlonesic.springgraphqlmysql.exception;

public class LanguageException extends AbstractGraphqlException {
    public LanguageException(int errorCode, String errorMessage) {
        super(errorCode, errorMessage);
    }
}