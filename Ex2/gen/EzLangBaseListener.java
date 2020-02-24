// Generated from C:/dev/git/DA388A/Ex2/grammar\EzLang.g4 by ANTLR 4.7.2

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;

/**
 * This class provides an empty implementation of {@link EzLangListener},
 * which can be extended to create a listener which only needs to handle a subset
 * of the available methods.
 */
public class EzLangBaseListener implements EzLangListener {

	@Override public void enterFile(EzLangParser.FileContext ctx) { }

	@Override public void exitFile(EzLangParser.FileContext ctx) { }

	@Override public void enterCode(EzLangParser.CodeContext ctx) { }

	@Override public void exitCode(EzLangParser.CodeContext ctx) { }

	@Override public void enterStatement(EzLangParser.StatementContext ctx) { }

	@Override public void exitStatement(EzLangParser.StatementContext ctx) { }

	@Override public void enterLoop(EzLangParser.LoopContext ctx) { }

	@Override public void exitLoop(EzLangParser.LoopContext ctx) { }

	@Override public void enterPrint(EzLangParser.PrintContext ctx) { }

	@Override public void exitPrint(EzLangParser.PrintContext ctx) { }

	@Override public void enterAssign(EzLangParser.AssignContext ctx) { }

	@Override public void exitAssign(EzLangParser.AssignContext ctx) { }

	@Override public void enterMath(EzLangParser.MathContext ctx) { }

	@Override public void exitMath(EzLangParser.MathContext ctx) { }

	@Override public void enterAdd(EzLangParser.AddContext ctx) { }

	@Override public void exitAdd(EzLangParser.AddContext ctx) { }

	@Override public void enterSub(EzLangParser.SubContext ctx) { }

	@Override public void exitSub(EzLangParser.SubContext ctx) { }

	@Override public void enterMul(EzLangParser.MulContext ctx) { }

	@Override public void exitMul(EzLangParser.MulContext ctx) { }

	@Override public void enterCond(EzLangParser.CondContext ctx) { }

	@Override public void exitCond(EzLangParser.CondContext ctx) { }

	@Override public void enterEqu(EzLangParser.EquContext ctx) { }

	@Override public void exitEqu(EzLangParser.EquContext ctx) { }

	@Override public void enterNequ(EzLangParser.NequContext ctx) { }

	@Override public void exitNequ(EzLangParser.NequContext ctx) { }

	@Override public void enterLess(EzLangParser.LessContext ctx) { }

	@Override public void exitLess(EzLangParser.LessContext ctx) { }

	@Override public void enterGreater(EzLangParser.GreaterContext ctx) { }

	@Override public void exitGreater(EzLangParser.GreaterContext ctx) { }

	@Override public void enterAtom(EzLangParser.AtomContext ctx) { }

	@Override public void exitAtom(EzLangParser.AtomContext ctx) { }


	@Override public void enterEveryRule(ParserRuleContext ctx) { }

	@Override public void exitEveryRule(ParserRuleContext ctx) { }

	@Override public void visitTerminal(TerminalNode node) { }

	@Override public void visitErrorNode(ErrorNode node) { }
}