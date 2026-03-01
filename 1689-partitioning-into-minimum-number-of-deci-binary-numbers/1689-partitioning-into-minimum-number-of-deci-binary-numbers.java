class Solution {
    public int minPartitions(String n) {
        char[] arr = n.toCharArray();
        int count = 0;
        while(true){
            boolean arezero = true;
            for(int i = 0 ; i < arr.length ; i++){
                if(arr[i] > '0'){
                    arr[i]--;
                    arezero = false;

                }
            }
            if(arezero) break;
            count++;
        }
        return count;
        
    }
}