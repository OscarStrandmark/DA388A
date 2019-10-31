import generated.EzLangBaseListener;
import generated.EzLangParser;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Stack;

public class Compiler extends EzLangBaseListener {

    private HashMap<String, Integer> varAddr = new HashMap<String, Integer>();
    private Stack<String> EntryLoopStack = new Stack<String>();
    private Stack<String> ExitLoopStack  = new Stack<String>();

    //Increment every time a new label is needed. Used to get unique labels
    // Ex. "Label" + labelCount; labelcount++;
    private int EnterLabelCount = 1;
    private int ExitLabelCount  = 1;

    private BufferedWriter writer;

    Compiler(String filename_out) {
        try {
            writer = new BufferedWriter(new FileWriter(filename_out));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Private method to help with writing to the file.
    private void write(String s){
        try {
            writer.write(s);
            writer.newLine();
            writer.flush();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override public void exitAtom(EzLangParser.AtomContext ctx) {
        if(ctx.INT() != null) {
            write("push " + ctx.INT());
        }
        else
        if(ctx.ID() != null ) {
            write("push " + ctx.ID());
        }
    }

    @Override public void exitAssign(EzLangParser.AssignContext ctx) {
        if(ctx.children.get(2) instanceof EzLangParser.MathContext) {
            //Pushed value is result of a math operation
            write("pop " + ctx.children.get(0));
        }
        else {
            write("push " + ctx.children.get(2));
            write("pop "  + ctx.children.get(0));
        }
    }

    @Override public void exitAdd(EzLangParser.AddContext ctx) {
        write("add");
    }

    @Override public void exitSub(EzLangParser.SubContext ctx) {
        write("sub");
    }
    @Override public void exitMul(EzLangParser.MulContext ctx) { }

    @Override public void enterLoop(EzLangParser.LoopContext ctx) {
        //Create new label and put on the loop-stack
        String label = "EnterLabel_" + EnterLabelCount;
        EnterLabelCount++;
        EntryLoopStack.push(label);
        //write label
        write("label " + label);
    }

    @Override public void exitLoop(EzLangParser.LoopContext ctx) {
        write("goto "  + EntryLoopStack.pop());
        write("label " + ExitLoopStack.pop());
    }

    @Override public void enterCode(EzLangParser.CodeContext ctx) {
        if(ctx.parent instanceof EzLangParser.LoopContext) {
            write("if-goto " + "ExitLabel_" + ExitLabelCount);
            ExitLoopStack.push("ExitLabel_" + ExitLabelCount);
            ExitLabelCount++;
        }
    }

    @Override public void exitGreater(EzLangParser.GreaterContext ctx) { write("gt"); }
    @Override public void exitLess(EzLangParser.LessContext ctx) { write("lt"); }
    @Override public void exitEqu(EzLangParser.EquContext ctx) { write("equ"); }
    @Override public void exitNequ(EzLangParser.NequContext ctx) { write("ne");}

    @Override public void exitPrint(EzLangParser.PrintContext ctx) {
        write("print " + ctx.children.get(1).getText());
    }
    //Every rule has been visited, close write-stream
    @Override public void exitFile(EzLangParser.FileContext ctx) {
       try {
           writer.flush();
           writer.close();
           System.out.println("Successfully wrote to output");
       } catch (Exception e){
           e.printStackTrace();
       }
    }

    //Below: all unused methods
    @Override public void enterAssign(EzLangParser.AssignContext ctx) { }
    @Override public void enterFile(EzLangParser.FileContext ctx) { }
    @Override public void exitCode(EzLangParser.CodeContext ctx) { }
    @Override public void enterStatement(EzLangParser.StatementContext ctx) { }
    @Override public void exitStatement(EzLangParser.StatementContext ctx) { }
    @Override public void enterPrint(EzLangParser.PrintContext ctx) { }
    @Override public void enterMath(EzLangParser.MathContext ctx) { }
    @Override public void exitMath(EzLangParser.MathContext ctx) { }
    @Override public void enterAdd(EzLangParser.AddContext ctx) { }
    @Override public void enterSub(EzLangParser.SubContext ctx) { }
    @Override public void enterMul(EzLangParser.MulContext ctx) { }
    @Override public void enterCond(EzLangParser.CondContext ctx) { }
    @Override public void exitCond(EzLangParser.CondContext ctx) { }
    @Override public void enterEqu(EzLangParser.EquContext ctx) { }
    @Override public void enterNequ(EzLangParser.NequContext ctx) { }
    @Override public void enterLess(EzLangParser.LessContext ctx) { }
    @Override public void enterGreater(EzLangParser.GreaterContext ctx) { }
    @Override public void enterAtom(EzLangParser.AtomContext ctx) { }
    @Override public void enterEveryRule(ParserRuleContext ctx) { }
    @Override public void exitEveryRule(ParserRuleContext ctx) { }
    @Override public void visitTerminal(TerminalNode node) { }
    @Override public void visitErrorNode(ErrorNode node) { }
}
