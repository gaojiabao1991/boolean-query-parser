package cn.sheeva.ast;

import cn.sheeva.constant.Sign;

public class NotExp extends AbstractExp {
    AbstractExp v;
    
    public NotExp(AbstractExp v) {
        this.v=v;
    }

    @Override
    public String toString() {
        return Sign.NOT.toString()+" "+v.toString();
    }
}
