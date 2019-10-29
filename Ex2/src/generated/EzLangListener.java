package generated;// Generated from C:/dev/git/DA388A/Ex2/grammar\EzLang.g4 by ANTLR 4.7.2
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link EzLangParser}.
 */
public interface EzLangListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link EzLangParser#file}.
	 * @param ctx the parse tree
	 */
	void enterFile(EzLangParser.FileContext ctx);
	/**
	 * Exit a parse tree produced by {@link EzLangParser#file}.
	 * @param ctx the parse tree
	 */
	void exitFile(EzLangParser.FileContext ctx);
	/**
	 * Enter a parse tree produced by {@link EzLangParser#code}.
	 * @param ctx the parse tree
	 */
	void enterCode(EzLangParser.CodeContext ctx);
	/**
	 * Exit a parse tree produced by {@link EzLangParser#code}.
	 * @param ctx the parse tree
	 */
	void exitCode(EzLangParser.CodeContext ctx);
	/**
	 * Enter a parse tree produced by {@link EzLangParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(EzLangParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link EzLangParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(EzLangParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link EzLangParser#loop}.
	 * @param ctx the parse tree
	 */
	void enterLoop(EzLangParser.LoopContext ctx);
	/**
	 * Exit a parse tree produced by {@link EzLangParser#loop}.
	 * @param ctx the parse tree
	 */
	void exitLoop(EzLangParser.LoopContext ctx);
	/**
	 * Enter a parse tree produced by {@link EzLangParser#print}.
	 * @param ctx the parse tree
	 */
	void enterPrint(EzLangParser.PrintContext ctx);
	/**
	 * Exit a parse tree produced by {@link EzLangParser#print}.
	 * @param ctx the parse tree
	 */
	void exitPrint(EzLangParser.PrintContext ctx);
	/**
	 * Enter a parse tree produced by {@link EzLangParser#declare}.
	 * @param ctx the parse tree
	 */
	void enterDeclare(EzLangParser.DeclareContext ctx);
	/**
	 * Exit a parse tree produced by {@link EzLangParser#declare}.
	 * @param ctx the parse tree
	 */
	void exitDeclare(EzLangParser.DeclareContext ctx);
	/**
	 * Enter a parse tree produced by {@link EzLangParser#assign}.
	 * @param ctx the parse tree
	 */
	void enterAssign(EzLangParser.AssignContext ctx);
	/**
	 * Exit a parse tree produced by {@link EzLangParser#assign}.
	 * @param ctx the parse tree
	 */
	void exitAssign(EzLangParser.AssignContext ctx);
	/**
	 * Enter a parse tree produced by {@link EzLangParser#math}.
	 * @param ctx the parse tree
	 */
	void enterMath(EzLangParser.MathContext ctx);
	/**
	 * Exit a parse tree produced by {@link EzLangParser#math}.
	 * @param ctx the parse tree
	 */
	void exitMath(EzLangParser.MathContext ctx);
	/**
	 * Enter a parse tree produced by {@link EzLangParser#add}.
	 * @param ctx the parse tree
	 */
	void enterAdd(EzLangParser.AddContext ctx);
	/**
	 * Exit a parse tree produced by {@link EzLangParser#add}.
	 * @param ctx the parse tree
	 */
	void exitAdd(EzLangParser.AddContext ctx);
	/**
	 * Enter a parse tree produced by {@link EzLangParser#sub}.
	 * @param ctx the parse tree
	 */
	void enterSub(EzLangParser.SubContext ctx);
	/**
	 * Exit a parse tree produced by {@link EzLangParser#sub}.
	 * @param ctx the parse tree
	 */
	void exitSub(EzLangParser.SubContext ctx);
	/**
	 * Enter a parse tree produced by {@link EzLangParser#mul}.
	 * @param ctx the parse tree
	 */
	void enterMul(EzLangParser.MulContext ctx);
	/**
	 * Exit a parse tree produced by {@link EzLangParser#mul}.
	 * @param ctx the parse tree
	 */
	void exitMul(EzLangParser.MulContext ctx);
	/**
	 * Enter a parse tree produced by {@link EzLangParser#cond}.
	 * @param ctx the parse tree
	 */
	void enterCond(EzLangParser.CondContext ctx);
	/**
	 * Exit a parse tree produced by {@link EzLangParser#cond}.
	 * @param ctx the parse tree
	 */
	void exitCond(EzLangParser.CondContext ctx);
	/**
	 * Enter a parse tree produced by {@link EzLangParser#equ}.
	 * @param ctx the parse tree
	 */
	void enterEqu(EzLangParser.EquContext ctx);
	/**
	 * Exit a parse tree produced by {@link EzLangParser#equ}.
	 * @param ctx the parse tree
	 */
	void exitEqu(EzLangParser.EquContext ctx);
	/**
	 * Enter a parse tree produced by {@link EzLangParser#nequ}.
	 * @param ctx the parse tree
	 */
	void enterNequ(EzLangParser.NequContext ctx);
	/**
	 * Exit a parse tree produced by {@link EzLangParser#nequ}.
	 * @param ctx the parse tree
	 */
	void exitNequ(EzLangParser.NequContext ctx);
	/**
	 * Enter a parse tree produced by {@link EzLangParser#less}.
	 * @param ctx the parse tree
	 */
	void enterLess(EzLangParser.LessContext ctx);
	/**
	 * Exit a parse tree produced by {@link EzLangParser#less}.
	 * @param ctx the parse tree
	 */
	void exitLess(EzLangParser.LessContext ctx);
	/**
	 * Enter a parse tree produced by {@link EzLangParser#greater}.
	 * @param ctx the parse tree
	 */
	void enterGreater(EzLangParser.GreaterContext ctx);
	/**
	 * Exit a parse tree produced by {@link EzLangParser#greater}.
	 * @param ctx the parse tree
	 */
	void exitGreater(EzLangParser.GreaterContext ctx);
	/**
	 * Enter a parse tree produced by {@link EzLangParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterAtom(EzLangParser.AtomContext ctx);
	/**
	 * Exit a parse tree produced by {@link EzLangParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitAtom(EzLangParser.AtomContext ctx);
}