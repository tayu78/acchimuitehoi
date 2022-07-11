package util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AhOption {
    private String right;
    private String left;
    private String up;
    private String down;
    
    

    public AhOption(String rightSymbol, String leftSymbol, String upSymbol, String downSymbol) {
        right = "right " + rightSymbol;
        left = "left " + leftSymbol;
        up = "up " + upSymbol;
        down =  "down " +  downSymbol;
    }


    public String getRight() {
        return right;
    }
    public String getLeft() {
        return left;
    }
    public String getUp() {
        return up;
    }
    public String getDown() {
        return down;
    }

    public List<String> getOps() {
        return new ArrayList<>(Arrays.asList(up,right,down,left));
    }
}
