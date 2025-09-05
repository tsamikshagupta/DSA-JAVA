import java.util.*;
class Solution {
    public static List<Integer> diffWaysToCompute(String expression) {
        List<Integer> result = new ArrayList<>();
        for(int i=0;i<expression.length();i++){
            char c = expression.charAt(i);
            if(c=='+'|| c=='-'|| c=='*'){
                String left = expression.substring(0,i);
                String right = expression.substring(i+1);

                List<Integer> leftres = diffWaysToCompute(left);
                List<Integer> rightres = diffWaysToCompute(right);

                for(int l:leftres){
                    for(int r:rightres){
                        if(c=='+'){
                            result.add(l+r);
                        }else if(c=='-'){
                            result.add(l-r);
                        }else if(c=='*'){
                            result.add(l*r);
                        }
                    }
                }
            }
        }
        if(result.isEmpty()){
            result.add(Integer.parseInt(expression));
        }
        Collections.sort(result);
        return result;
    }
    
}