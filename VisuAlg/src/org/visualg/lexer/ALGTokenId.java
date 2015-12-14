package org.visualg.lexer;


import org.netbeans.api.lexer.Language;
import org.netbeans.api.lexer.TokenId;

public class ALGTokenId implements TokenId {

    private final String name;
    private final String primaryCategory;
    private final int id;

    ALGTokenId(
            String name,
            String primaryCategory,
            int id) {
        this.name = name;
        this.primaryCategory = primaryCategory;
        this.id = id;
    }

    @Override
    public String primaryCategory() {
        return primaryCategory;
    }

    @Override
    public int ordinal() {
        return id;
    }

    @Override
    public String name() {
        return name;
    }
    
    public static Language<ALGTokenId> getLanguage() {
    return new ALGLanguageHierarchy().language();
}

}