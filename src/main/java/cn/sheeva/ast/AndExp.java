package cn.sheeva.ast;

import cn.sheeva.constant.Sign;

public class AndExp extends AbstractExp {
    AbstractExp l;
    AbstractExp r;
    
    public AndExp(AbstractExp l,AbstractExp r) {
        this.l=l;
        this.r=r;
    }

    @Override
    public String toString() {
        return l.toString()+" "+Sign.AND.toString()+" "+r.toString();
    }
}
