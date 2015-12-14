package org.visualg.lexer;

import java.util.*;
import org.netbeans.spi.lexer.LanguageHierarchy;
import org.netbeans.spi.lexer.Lexer;
import org.netbeans.spi.lexer.LexerRestartInfo;

public class ALGLanguageHierarchy extends LanguageHierarchy<ALGTokenId> {

    private static List<ALGTokenId> tokens;
    private static Map<Integer, ALGTokenId> idToToken;

    private static void init() {
        tokens = Arrays.asList(new ALGTokenId[]{
            new ALGTokenId("EOF", "whitespace", 0),
            new ALGTokenId("WHITESPACE", "whitespace", 1),
            new ALGTokenId("SINGLE_LINE_COMMENT", "comment", 4),
            new ALGTokenId("FORMAL_COMMENT", "comment", 5),
            new ALGTokenId("MULTI_LINE_COMMENT", "comment", 6),
            new ALGTokenId("ALEATORIO", "keyword", 8),
            new ALGTokenId("ALGORITMO", "keyword", 9),
            new ALGTokenId("ARQUIVO", "keyword", 10),
            new ALGTokenId("ASC", "keyword", 11),
            new ALGTokenId("ATE", "keyword", 12),
            new ALGTokenId("CARAC", "keyword", 13),
            new ALGTokenId("CARACPNUM", "keyword", 14),
            new ALGTokenId("CARACTERE", "keyword", 15),
            new ALGTokenId("CASO", "keyword", 16),
            new ALGTokenId("COMPR", "keyword", 17),
            new ALGTokenId("COPIA", "keyword", 18),
            new ALGTokenId("CRONOMETRO", "keyword", 19),
            new ALGTokenId("DEBUG", "keyword", 20),
            new ALGTokenId("E", "keyword", 21),
            new ALGTokenId("ECO", "keyword", 22),
            new ALGTokenId("ENQUANTO", "keyword", 23),
            new ALGTokenId("ENTAO", "keyword", 24),
            new ALGTokenId("ESCOLHA", "keyword", 25),
            new ALGTokenId("ESCREVA", "keyword", 26),
            new ALGTokenId("ESCREVAL", "keyword", 27),
            new ALGTokenId("FACA", "keyword", 28),
            new ALGTokenId("FALSO", "keyword", 29),
            new ALGTokenId("FIMALGORITMO", "keyword", 30),
            new ALGTokenId("FIMENQUANTO", "keyword", 31),
            new ALGTokenId("FIMESCOLHA", "keyword", 32),
            new ALGTokenId("FIMFUNCAO", "keyword", 33),
            new ALGTokenId("FIMPARA", "keyword", 34),
            new ALGTokenId("FIMPROCEDIMENT", "keyword", 35),
            new ALGTokenId("FIMREPITA", "keyword", 36),
            new ALGTokenId("FIMSE", "keyword", 37),
            new ALGTokenId("FUNCAO", "keyword", 38),
            new ALGTokenId("INICIO", "keyword", 39),
            new ALGTokenId("INT", "keyword", 40),
            new ALGTokenId("INTEIRO", "keyword", 41),
            new ALGTokenId("INTERROMPA", "keyword", 42),
            new ALGTokenId("LEIA", "keyword", 43),
            new ALGTokenId("LIMPATELA", "keyword", 44),
            new ALGTokenId("LOGICO", "keyword", 45),
            new ALGTokenId("MAIUSC", "keyword", 46),
            new ALGTokenId("MINUSC", "keyword", 47),
            new ALGTokenId("MOD", "keyword", 48),
            new ALGTokenId("NAO", "keyword", 49),
            new ALGTokenId("NUMPCARAC", "keyword", 50),
            new ALGTokenId("OU", "keyword", 51),
            new ALGTokenId("OUTROCASO", "keyword", 52),
            new ALGTokenId("PARA", "keyword", 53),
            new ALGTokenId("PASSO", "keyword", 54),
            new ALGTokenId("PAUSA", "keyword", 55),
            new ALGTokenId("POS", "keyword", 56),
            new ALGTokenId("REAL", "keyword", 57),
            new ALGTokenId("PROCEDIMENTO", "keyword", 58),
            new ALGTokenId("REPITA", "keyword", 59),
            new ALGTokenId("RETORNE", "keyword", 60),
            new ALGTokenId("SE", "keyword", 61),
            new ALGTokenId("SENAO", "keyword", 62),
            new ALGTokenId("TIMER", "keyword", 63),
            new ALGTokenId("VAR", "keyword", 64),
            new ALGTokenId("VETOR", "keyword", 65),
            new ALGTokenId("VERDADEIRO", "keyword", 66),
            new ALGTokenId("XOU", "keyword", 67),
            new ALGTokenId("INTEGER_LITERAL", "number", 68),
            new ALGTokenId("DECIMAL_LITERAL", "number", 69),
            new ALGTokenId("HEX_LITERAL", "number", 70),
            new ALGTokenId("OCTAL_LITERAL", "number", 71),
            new ALGTokenId("FLOATING_POINT_LITERAL", "number", 72),
            new ALGTokenId("DECIMAL_FLOATING_POINT_LITERAL", "number", 73),
            new ALGTokenId("DECIMAL_EXPONENT", "number", 74),
            new ALGTokenId("HEXADECIMAL_FLOATING_POINT_LITERAL", "number", 75),
            new ALGTokenId("HEXADECIMAL_EXPONENT", "number", 76),
            new ALGTokenId("CHARACTER_LITERAL", "literal", 77),
            new ALGTokenId("STRING_LITERAL", "string", 78),
            new ALGTokenId("IDENTIFIER", "literal", 79),
            new ALGTokenId("LETTER", "literal", 80),
            new ALGTokenId("PART_LETTER", "literal", 81),
            new ALGTokenId("LPAREN", "operator", 82),
            new ALGTokenId("RPAREN", "operator", 83),
            new ALGTokenId("LBRACE", "operator", 84),
            new ALGTokenId("RBRACE", "operator", 85),
            new ALGTokenId("LBRACKET", "operator", 86),
            new ALGTokenId("RBRACKET", "operator", 87),
            new ALGTokenId("SEMICOLON", "operator", 88),
            new ALGTokenId("COMMA", "operator", 89),
            new ALGTokenId("DOT", "operator", 90),
            new ALGTokenId("AT", "operator", 91),
            new ALGTokenId("ASSIGN", "operator", 92),
            new ALGTokenId("LT", "operator", 93),
            new ALGTokenId("BANG", "operator", 94),
            new ALGTokenId("TILDE", "operator", 95),
            new ALGTokenId("HOOK", "operator", 96),
            new ALGTokenId("COLON", "operator", 97),
            new ALGTokenId("EQ", "operator", 98),
            new ALGTokenId("LE", "operator", 99),
            new ALGTokenId("GE", "operator", 100),
            new ALGTokenId("NE", "operator", 101),
            new ALGTokenId("SC_OR", "operator", 102),
            new ALGTokenId("SC_AND", "operator", 103),
            new ALGTokenId("INCR", "operator", 104),
            new ALGTokenId("DECR", "operator", 105),
            new ALGTokenId("PLUS", "operator", 106),
            new ALGTokenId("MINUS", "operator", 107),
            new ALGTokenId("STAR", "operator", 108),
            new ALGTokenId("SLASH", "operator", 109),
            new ALGTokenId("BIT_AND", "operator", 110),
            new ALGTokenId("BIT_OR", "operator", 111),
            new ALGTokenId("XOR", "operator", 112),
            new ALGTokenId("REM", "operator", 113),
            new ALGTokenId("LSHIFT", "operator", 114),
            new ALGTokenId("PLUSASSIGN", "operator", 115),
            new ALGTokenId("MINUSASSIGN", "operator", 116),
            new ALGTokenId("STARASSIGN", "operator", 117),
            new ALGTokenId("SLASHASSIGN", "operator", 118),
            new ALGTokenId("ANDASSIGN", "operator", 119),
            new ALGTokenId("ORASSIGN", "operator", 120),
            new ALGTokenId("XORASSIGN", "operator", 121),
            new ALGTokenId("REMASSIGN", "operator", 122),
            new ALGTokenId("LSHIFTASSIGN", "operator", 123),
            new ALGTokenId("RSIGNEDSHIFTASSIGN", "operator", 124),
            new ALGTokenId("RUNSIGNEDSHIFTASSIGN", "operator", 125),
            new ALGTokenId("ELLIPSIS", "operator", 126),});

        idToToken = new HashMap<Integer, ALGTokenId>();
        for (ALGTokenId token : tokens) {
            idToToken.put(token.ordinal(), token);
        }
    }

    static synchronized ALGTokenId getToken(int id) {
        if (idToToken == null) {
            init();
        }
        return idToToken.get(id);
    }

    @Override
    protected synchronized Collection<ALGTokenId> createTokenIds() {
        if (tokens == null) {
            init();
        }
        return tokens;
    }

    @Override
    protected synchronized Lexer<ALGTokenId> createLexer(LexerRestartInfo<ALGTokenId> info) {
        return new ALGLexer(info);
    }

    @Override
    protected String mimeType() {
        return "text/x-alg";
    }

}
