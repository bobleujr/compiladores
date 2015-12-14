package org.visualg.lexer;

import org.netbeans.spi.lexer.Lexer;
import org.netbeans.spi.lexer.LexerRestartInfo;
import org.visualg.jcclexer.JavaCharStream;
import org.visualg.jcclexer.JavaParserTokenManager;
import org.visualg.jcclexer.Token;

class ALGLexer implements Lexer<ALGTokenId> {

    private LexerRestartInfo<ALGTokenId> info;
    private JavaParserTokenManager javaParserTokenManager;

    ALGLexer(LexerRestartInfo<ALGTokenId> info) {
        this.info = info;
        JavaCharStream stream = new JavaCharStream(info.input());
        javaParserTokenManager = new JavaParserTokenManager(stream);
    }

    @Override
    public org.netbeans.api.lexer.Token<ALGTokenId> nextToken() {
        Token token = javaParserTokenManager.getNextToken();
        if (info.input().readLength() < 1) {
            return null;
        }
        return info.tokenFactory().createToken(ALGLanguageHierarchy.getToken(token.kind));
    }

    @Override
    public Object state() {
        return null;
    }

    @Override
    public void release() {
    }

}