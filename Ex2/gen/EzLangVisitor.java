// Generated from C:/dev/git/DA388A/Ex2/grammar\EzLang.g4 by ANTLR 4.7.2
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link EzLangParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface EzLangVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link EzLangParser#file}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFile(EzLangParser.FileContext ctx);
	/**
	 * Visit a parse tree produced by {@link EzLangParser#code}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCode(EzLangParser.CodeContext ctx);
	/**
	 * Visit a parse tree produced by {@link EzLangParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(EzLangParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link EzLangParser#loop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLoop(EzLangParser.LoopContext ctx);
	/**
	 * Visit a parse tree produced by {@link EzLangParser#print}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrint(EzLangParser.PrintContext ctx);
	/**
	 * Visit a parse tree produced by {@link EzLangParser#declare}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclare(EzLangParser.DeclareContext ctx);
	/**
	 * Visit a parse tree produced by {@link EzLangParser#assign}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssign(EzLangParser.AssignContext ctx);
	/**
	 * Visit a parse tree produced by {@link EzLangParser#math}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMath(EzLangParser.MathContext ctx);
	/**
	 * Visit a parse tree produced by {@link EzLangParser#add}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdd(EzLangParser.AddContext ctx);
	/**
	 * Visit a parse tree produced by {@link EzLangParser#mul}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMul(EzLangParser.MulContext ctx);
	/**
	 * Visit a parse tree produced by {@link EzLangParser#cond}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCond(EzLangParser.CondContext ctx);
	/**
	 * Visit a parse tree produced by {@link EzLangParser#equ}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqu(EzLangParser.EquContext ctx);
	/**
	 * Visit a parse tree produced by {@link EzLangParser#nequ}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNequ(EzLangParser.NequContext ctx);
	/**
	 * Visit a parse tree produced by {@link EzLangParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtom(EzLangParser.AtomContext ctx);
}