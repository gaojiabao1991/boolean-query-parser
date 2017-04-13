package cn.sheeva.parser;


import java.util.Arrays;

import cn.sheeva.ast.AbstractExp;
import cn.sheeva.ast.AndExp;
import cn.sheeva.ast.BracketsExp;
import cn.sheeva.ast.NotExp;
import cn.sheeva.ast.OrExp;
import cn.sheeva.ast.WordExp;
import cn.sheeva.constant.Sign;

/**
 * 表达式文法：
 *  Exp:BracketsExp|AndExp|OrExp|NotExp|WordExp
    BracketsExp: '(' Exp ')'
    AndExp: Exp And Exp
    OrExp: Exp Or Exp
    NotExp: Not Exp
    WordExp: string
 * @author sheeva
 *
 */

public class Parser {
    
    /**
     * 需要判断5种情况分别对应5种子表达式
     * 递归调用
     * @createTime：2017年4月13日 
     * @author: gaojiabao
     */
    public static AbstractExp getExp(String[] arr){
        if (arr.length==0) {
            throw new RuntimeException("illegal exp: len==0");
        }
        
        /**
         * case 2: WordExp
         */
        if (arr.length==1) {
            if (Sign.isSign(arr[0])) {
                throw new RuntimeException("illegal exp: len==1 but not WordExp: "+arr[0]);
            }
            return new WordExp(arr[0]);
        }
        
        
        /**
         * case 1: BracketsExp
         */
        if (arr[0].equals(Sign.LB.toString())&&arr[arr.length-1].equals(Sign.RB.toString())) {
            boolean ifBracketExp;
            int rBracket=0;
            //iterator subArr[1,arr.leng-1]
            for (int i = arr.length-2; i >=1; i--) {
                String e=arr[i];
                if (e.equals(Sign.RB.toString())) {
                    rBracket++;
                }else if (e.equals(Sign.LB.toString())) {
                    rBracket--;
                }
                if (rBracket<0) {
                    //case: ( 中国 AND 人民 ) OR ( 人民 AND 国旗 )
                    ifBracketExp=false;
                    break;
                }
            }
            ifBracketExp=rBracket==0;
            
            if (ifBracketExp) {
                return new BracketsExp(getExp(Arrays.copyOfRange(arr, 1, arr.length-1)));
            }
        }

        
        /**
         * case 3: NotExp
         */
        if (arr.length==2) {
            if (!arr[0].equals(Sign.NOT.toString())) {
                throw new RuntimeException("illegal exp: len==2 but not NotExp: "+Arrays.asList(arr));
            }
            return new NotExp(new WordExp(arr[1]));
        }
        
        /**
         * case 4 and case 5: AndExp/OrExp
         */
        int rBracket=0;
        for (int i = arr.length-1; i >=0; i--) {
            String expElementStr=arr[i];
            if (expElementStr.equals(Sign.RB.toString())) {
                rBracket++;
            }else if (expElementStr.equals(Sign.LB.toString())) {
                rBracket--;
            }else if (rBracket==0) {
                if (expElementStr.equals(Sign.AND.toString())) {
                    return new AndExp(getExp(Arrays.copyOfRange(arr, 0, i)), getExp(Arrays.copyOfRange(arr, i+1, arr.length)));
                }else if (expElementStr.equals(Sign.OR.toString())) {
                    return new OrExp(getExp(Arrays.copyOfRange(arr, 0, i)), getExp(Arrays.copyOfRange(arr, i+1, arr.length)));
                }
            }
            
                    
        }
        
        throw new RuntimeException("unknown type exp: "+Arrays.asList(arr));
    }
}
