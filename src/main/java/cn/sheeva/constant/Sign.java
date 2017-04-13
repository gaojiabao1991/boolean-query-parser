package cn.sheeva.constant;

public enum Sign{
    AND("AND"),
    OR("OR"),
    NOT("NOT"),
    LB("("),
    RB(")");
    
    private String sign;
    
    private Sign(String sign) {
        this.sign=sign;
    }

    public static boolean isSign(String expStr){
        for (Sign sign : Sign.values()) {
            if (sign.toString().equals(expStr)) {
                return true;
            }
        }
        return false;
    }
    
    @Override
    public String toString() {
        return sign;
    }
    
}