import generated.EzLangBaseListener;
import org.antlr.runtime.Token;

import java.util.HashMap;

public class Compiler extends EzLangBaseListener {
    private final String infnam;
    private final boolean traceOn;

    private final HackGen out;
    private final HashMap<String, Integer> varAddr = new HashMap<String, Integer>();

    Compiler(String infnam, HackGen out, boolean traceOn) {
        this.infnam = infnam;
        this.out = out;
        this.traceOn = traceOn;
    }

    private void tracePrint(String message) {
        if (traceOn) {
            System.out.println("At operation "+out.currentCodeAddress()+": "+message);
        }
    }

    private int getVarAddr(Token tok) {
        String name = tok.getText();
        Integer a = varAddr.get(name);
        if (a == null) {
            error(tok.getLine(), "undefined " + name);
            return 0;
        } else {
            return a;
        }
    }

    private void error(int line, String msg) {
        System.err.println(infnam + ":" + line + ": " + msg);
    }
}
