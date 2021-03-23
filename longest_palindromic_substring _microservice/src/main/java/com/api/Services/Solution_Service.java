package com.api.Services;

import org.springframework.stereotype.Service;

@Service
public class Solution_Service {
    public String longestPalindromicSubstring(String str) {

        // time: O(n^2) space:O(1)
        int[] curLongest=new int[]{0,1};
        for (int i = 0; i < str.length(); i++) {
            int[] odd=substringIndex(i-1,i+1,str);
            int[] even=substringIndex(i,i+1,str);
            int[] curLength=odd[1]-odd[0]>even[1]-even[0]?odd:even;
            curLongest=curLongest[1]-curLongest[0]>curLength[1]-curLength[0]?curLongest:curLength;
        }

        return str.substring(curLongest[0],curLongest[1]);
    }

    public int[] substringIndex(int x,int y,String str){

        while (x>=0&&y<str.length()){
            if (str.charAt(x)!=str.charAt(y)){
                break;
            }
            x--;
            y++;
        }
        return new int[]{++x,y};

    }
}
