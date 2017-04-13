package cn.sheeva.ast;

import cn.sheeva.constant.Sign;

public class BracketsExp extends AbstractExp{
    AbstractExp v;
    
    public BracketsExp(AbstractExp v) {
        this.v=v;
    }

    @Override
    public String toString() {
        return Sign.LB.toString()+" "+v.toString()+" "+Sign.RB.toString();
    }
    
    
}
