// Get the frequency of each character.
// Get the first character that has a frequency of one.

class Solution {
    public int firstUniqChar(String s) {
        int freq[] = new int[26];
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            if(freq[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }
}


class Solution {
    public int firstUniqChar(String s) {
//         if(s == null || "".equals(s))return -1;
        
//         Queue<Integer> queue = new LinkedList<>();
//         queue.add(0);

//         int[]chs = new int[26];
//         chs[s.charAt(queue.peek())-'a'] += 1;

//         for(int i = 1;i<s.length();i++){
//             chs[s.charAt(i)-'a'] += 1;

//             // if(queue.peek() == null){
//             //     if(chs[s.charAt(i)-'a'] == 1)queue.add(s.charAt(i));
//             // }else 

//             for(Integer element:queue){
//                 if(s.charAt(element) == s.charAt(i)){
//                     queue.remove(element);
//                     break;
//                 }
//             }
                
//             if(chs[s.charAt(i)-'a'] == 1)queue.add(i);
//         }
        
//         return queue.peek() != null? queue.peek():-1;
        
        int index = -1;
        for(char ch = 'a';ch<='z';ch++){
            int beginIndex = s.indexOf(ch);
            if(beginIndex!=-1&&beginIndex == s.lastIndexOf(ch)){
                if(index == -1) index = beginIndex;
                else if(beginIndex<index)index = beginIndex;
            }
        }
        return index;
    }
}
