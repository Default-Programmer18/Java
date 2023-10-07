class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        int slide = words.length * words[0].length();
        List<Integer> list = new ArrayList<>();
        int index = 0 ;
        boolean flag = true;
        if(s.length() < slide)
            return list;
        HashMap<String , Integer> hmap = new HashMap<>();
        for(String word : words){
            hmap.put(word,hmap.getOrDefault(word , 0)+1);
        }
     
        HashMap<String , Integer> hmap2 = hmap;
        for(int i = 0 ; i < s.length() - slide + 1 ; i++)
        {
            index++;
            flag = true;
            hmap2 = new HashMap<>(hmap);
            for(int j = 0 ; j < slide ; j += words[0].length())
            {
                String newWord = s.substring(i+j , i+j+words[0].length());
                hmap2.put(newWord , hmap2.getOrDefault( newWord, 0)-1);
            
            }
            for(String key : hmap.keySet())
            {
                 
                 if(!hmap2.containsKey(key))
                    flag = false;
                if(hmap2.get(key) != 0)
                    flag = false;
            }
            
            if(flag){
                
                list.add(i);
            }
             
                
        }
  
        return list;       
    }
}
