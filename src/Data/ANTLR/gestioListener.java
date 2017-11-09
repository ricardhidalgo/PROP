package Data.ANTLR;// Generated from gestio.g4 by ANTLR 4.7
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link gestioParser}.
 */
public interface gestioListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link gestioParser#r}.
	 * @param ctx the parse tree
	 */
	void enterR(gestioParser.RContext ctx);
	/**
	 * Exit a parse tree produced by {@link gestioParser#r}.
	 * @param ctx the parse tree
	 */
	void exitR(gestioParser.RContext ctx);
}