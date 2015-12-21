/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.visualg.parser;

/**
 *
 * @author Paulo
 */
import java.io.Reader;
import java.io.StringReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.event.ChangeListener;
import org.netbeans.modules.parsing.api.Snapshot;
import org.netbeans.modules.parsing.api.Task;
import org.netbeans.modules.parsing.spi.Parser;
import org.netbeans.modules.parsing.spi.Parser.Result;
import org.netbeans.modules.parsing.spi.SourceModificationEvent;
import org.visualg.jccparser.JavaParser;


public class ALGParser extends Parser {

    private Snapshot snapshot;
    private JavaParser javaParser;

    @Override
    public void parse(Snapshot snapshot, Task task, SourceModificationEvent event) {
        this.snapshot = snapshot;
        Reader reader = new StringReader(snapshot.getText().toString());
        javaParser = new JavaParser(reader);
        try {
            javaParser.CompilationUnit();
        } catch (org.visualg.jccparser.ParseException ex) {
            Logger.getLogger(ALGParser.class.getName()).log(Level.WARNING, null, ex);
        }
    }

    @Override
    public Result getResult(Task task) {
        return new ALGParserResult(snapshot, javaParser);
    }

    @Override
    public void cancel() {
    }

    @Override
    public void addChangeListener(ChangeListener changeListener) {
    }

    @Override
    public void removeChangeListener(ChangeListener changeListener) {
    }

    public static class ALGParserResult extends Parser.Result {

        private JavaParser javaParser;
        private boolean valid = true;

        ALGParserResult(Snapshot snapshot, JavaParser javaParser) {
            super(snapshot);
            this.javaParser = javaParser;
        }

        public JavaParser getJavaParser() throws org.netbeans.modules.parsing.spi.ParseException {
            if (!valid) {
                throw new org.netbeans.modules.parsing.spi.ParseException();
            }
            return javaParser;
        }

        @Override
        protected void invalidate() {
            valid = false;
        }
    }

}
