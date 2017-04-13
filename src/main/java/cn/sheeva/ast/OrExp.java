package cn.sheeva.ast;

import cn.sheeva.constant.Sign;

public class OrExp extends AbstractExp {
    AbstractExp l;
    AbstractExp r;
    
    public OrExp(AbstractExp l,AbstractExp r) {
        this.l=l;
        this.r=r;
    }

    @Override
    public String toString() {
        return l.toString()+" "+Sign.OR.toString()+" "+r.toString();
    }
}
