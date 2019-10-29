import generated.EzLangLexer;
import generated.EzLangParser;
import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class RunEzLang {
    public static void main(String[] args) throws IOException {
        String infnam;
        if (args.length > 0) {
            infnam = args[0];
        } else {
            System.out.println("Vilken fil vill du köra?");
            Scanner scanner = new Scanner(System.in);
            infnam = scanner.nextLine();
        }
        ANTLRInputStream input = new ANTLRInputStream(new FileInputStream(infnam));
        EzLangLexer lexer = new EzLangLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        EzLangParser parser = new EzLangParser(tokens);
        ParseTree tree = parser.code();
        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(new Interpreter(infnam), tree);
    }
}
