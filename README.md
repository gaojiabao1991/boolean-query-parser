# boolean-query-parser
## 编写目的
用来解析boolean query, 将布尔查询字符串转化为抽象语法树AST.

## 设计思想
	将任意一个布尔表达式识别为5种布尔表达式中的一种，然后递归处理子表达式(如果有)。
	布尔表达式的文法：
    Exp:BracketsExp|AndExp|OrExp|NotExp|WordExp
    BracketsExp: '(' Exp ')'
    AndExp: Exp And Exp
    OrExp: Exp Or Exp
    NotExp: Not Exp
    WordExp: string


## 程序结构
### 抽象语法树AST(cn.sheeva.ast.*)
    AbstractExp  #抽象表达式，5种实际表达式的父类
    AndExp
    BracketsExp
    NotExp
    OrExp
    WordExp

### 表达式符号常量
    Sign
    
### 语法分析器
    Parser

## 测试
### 测试方式
	将表达式字符串构造成AST，再用AST生成表达式字符串，检测AST生成的字符串和原字符串是否相等。
### 测试用例
    中国 AND 人民
    中国 OR 人民
    NOT 人民
    中国 AND NOT 人民
    中国 OR 人民 AND 国旗
    中国 AND ( 人民 OR 国旗 )
    ( 中国 AND ( 人民 OR 国旗 ) )
    ( 中国 AND 人民 ) OR ( 人民 AND 国旗 )
    (A and B) or (C and D)
    A or (B and (C and D))
    A or not (B and (C and D))

