package org.visualg;

import org.netbeans.api.lexer.Language;
import org.netbeans.modules.csl.spi.DefaultLanguageConfig;
import org.netbeans.modules.csl.spi.LanguageRegistration;
import org.netbeans.modules.parsing.spi.Parser;
import org.visualg.lexer.ALGTokenId;
import org.visualg.parser.ALGParser;

@LanguageRegistration(mimeType = "text/x-alg")
public class ALGLanguage extends DefaultLanguageConfig {

    @Override
    public Language<ALGTokenId> getLexerLanguage() {
        return ALGTokenId.getLanguage();
    }

    @Override
    public String getDisplayName() {
        return "ALG";
    }
    
    @Override
    public Parser getParser() {
        return new ALGParser();
    }
}
