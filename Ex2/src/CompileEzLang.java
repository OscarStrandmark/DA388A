import generated.EzLangLexer;
import generated.EzLangParser;
import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.*;
import java.util.Scanner;

public class CompileEzLang {
    public static void main(String[] args) throws IOException {
        String infnam;
        String outfnam = args[1];
        boolean traceOn = args.length < 3 || "traceOn".equalsIgnoreCase(args[2]);

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
        ParseTree tree = parser.file();
        ParseTreeWalker walker = new ParseTreeWalker();
        HackGen out = new HackGen(1024, 2048, 1025);
        walker.walk(new Compiler(infnam, out, traceOn), tree);
        Writer w = new OutputStreamWriter(new FileOutputStream(outfnam), "US-ASCII");
        out.outputCode(w);
        w.close();
    }
}
