package io.gitlab.mihajlonesic.springgraphqlmysql.entity;

public enum EnumLanguageType {
    PROGRAMMING(1L),
    DATA(2L),
    MARKUP(3L);

    private Long id;

    EnumLanguageType(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
