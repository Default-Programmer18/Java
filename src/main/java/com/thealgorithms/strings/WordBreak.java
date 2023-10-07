class Solution {
    boolean ans = false;
    int[] dp ;
   int solve(String s , List<String> wordDict , int index )
    {
         
        if(index == s.length()){
        
                ans = true;
                return 1;
            }
            
        if(dp[index] != -1)
            return dp[index];
       
        for(int i = index; i < s.length() ;i++)
        {
            if(wordDict.contains(s.substring(index , i+1)))
            {
              if (solve(s , wordDict,i+1)!= 0)
                return dp[index]=1;
                
            }
        }  
       

      
        return dp[index] = 0;
    }
    public boolean wordBreak(String s, List<String> wordDict) {
       
     dp = new int[s.length()+1];
        Arrays.fill(dp , -1);
     
       int res =  solve(s , wordDict ,0 );
        if(res == 1)
            return true;
        return false;
        
    }
}
