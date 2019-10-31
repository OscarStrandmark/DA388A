import generated.EzLangLexer;
import generated.EzLangParser;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.FileInputStream;
import java.io.IOException;

public class CompileEzLang {
    public static void main(String[] args) throws IOException {

        //Paths to the in- and output files. Change if necessary.
        String filepath_in = "C:\\dev\\git\\DA388A\\Ex2\\grammar\\TestProgram";
        String filepath_out = "C:\\dev\\git\\DA388A\\Ex2\\output\\output.txt";

        ANTLRInputStream input = new ANTLRInputStream(new FileInputStream(filepath_in));
        EzLangLexer lexer = new EzLangLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        EzLangParser parser = new EzLangParser(tokens);
        ParseTree tree = parser.file();
        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(new Compiler(filepath_out), tree);
    }
}
