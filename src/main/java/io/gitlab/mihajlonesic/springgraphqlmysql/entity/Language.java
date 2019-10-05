package io.gitlab.mihajlonesic.springgraphqlmysql.entity;

import javax.persistence.*;

@Table
@Entity
public class Language {

    @Id
    private Long id;
    private String name;
    private String code;
    private String color;

    @ManyToOne
    @JoinColumn(name = "language_type_id", referencedColumnName = "id")
    private LanguageType languageType;

    public Language() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public EnumLanguageType getLanguageType() {
        if (languageType != null)
            return EnumLanguageType.valueOf(languageType.getType());
        return null;
    }

    public void setLanguageType(EnumLanguageType languageType) {
        LanguageType temp = new LanguageType();
        temp.setId(languageType.getId());
        temp.setType(languageType.name());
        this.languageType = temp;
    }
}
