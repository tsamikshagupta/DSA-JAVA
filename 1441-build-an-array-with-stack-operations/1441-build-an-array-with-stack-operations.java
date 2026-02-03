class Solution {
    public List<String> buildArray(int[] target, int n) {
        List<String> list = new ArrayList<>();
        int j = 0;
        for(int i = 1 ; i <= n ; i++){
            list.add("Push");
            if(j < target.length  && i==target[j]){
                j++;
            }else{
                list.add("Pop");
            }
            if(j == target.length){
                break;
            }

 
        }
        return list;
        
    }
}