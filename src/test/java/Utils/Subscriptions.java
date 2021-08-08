package Utils;

public class Subscriptions {

    private String protocolType=null;
    private int sessionAmount=0;

    public Subscriptions(String protocolType, int sessionAmount){
        this.protocolType=protocolType;
        this.sessionAmount=sessionAmount;
    }

    public String getProtocolType(){
        return protocolType;
    }

    public int getSessionAmount(){
        return sessionAmount;
    }
}
