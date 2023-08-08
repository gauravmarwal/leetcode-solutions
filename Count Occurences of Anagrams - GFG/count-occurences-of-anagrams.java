//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String txt = br.readLine().trim();
            String pat = br.readLine().trim();

            int ans = new Solution().search(pat, txt);

            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

    int search(String pat, String txt) {
        int ans = 0;
        int start = 0;
        int end = 0;
        int size = txt.length();
        int k = pat.length();
        int count = 0;
        HashMap<Character, Integer> freq = new HashMap<>();
        
        for(int i = 0 ; i < k ; i++){
            freq.put(pat.charAt(i), freq.getOrDefault(pat.charAt(i), 0) + 1);
        }
        
        count = freq.size();
        
        while(end < size){
            if(freq.containsKey(txt.charAt(end))){
                freq.put(txt.charAt(end), freq.get(txt.charAt(end)) - 1);
                if(freq.get(txt.charAt(end)) == 0) count--;
            }
            
            if(end - start + 1 < k){
                end++;
            } else if(end - start + 1 == k){
                if(count == 0){
                    ans++;
                }
                
                
                if(freq.containsKey(txt.charAt(start)) && freq.get(txt.charAt(start)) == 0){
                    count++;
                }
                if(freq.containsKey(txt.charAt(start))){
                    freq.put(txt.charAt(start), freq.get(txt.charAt(start)) + 1);
                }
                
                start++;
                end++;
            }
        }
        
        return ans;
    }
}