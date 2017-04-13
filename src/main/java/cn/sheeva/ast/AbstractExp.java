package cn.sheeva.ast;

/**
 * 表达式文法：<BR/>
 * 
 * Exp:BracketsExp|AndExp|OrExp|NotExp|WordExp  <BR/>
 * BracketsExp: '(' Exp ')' <BR/>
 * AndExp: Exp And Exp  <BR/>
 * OrExp: Exp Or Exp    <BR/>
 * NotExp: Not Exp  <BR/>
 * WordExp: string  <BR/>
 * 
 * @author sheeva
 *
 */
public abstract class AbstractExp {
    public abstract String toString();
}
