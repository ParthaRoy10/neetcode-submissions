class Solution {
    class Node{
        String word;
        int step;

        Node(String word,int step){
            this.word = word;
            this.step = step;
        }
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList){
        if(!wordList.contains(endWord)){
            return 0;
        }

        Set<String> set = new HashSet<>();
        Deque<Node> que = new ArrayDeque<>();
        

        set.add(beginWord);
        for(String str:wordList){
            set.add(str);
        }

        que.offer(new Node(beginWord,1));

        while(!que.isEmpty()){
            Node curr = que.poll();
            String str = curr.word;
            if(str.equals(endWord)){
                return curr.step;
            }
            
            set.remove(str);

            for(int i=0;i<str.length();i++){
                StringBuffer pattern1 = new StringBuffer();
                pattern1.append(str.substring(0,i));
                pattern1.append("*");
                pattern1.append(str.substring(i+1,str.length()));

                for(String next:set){
                    StringBuffer pattern2 = new StringBuffer();
                    pattern2.append(next.substring(0,i));
                    pattern2.append("*");
                    pattern2.append(next.substring(i+1,next.length()));

                    if(pattern1.toString().equals(pattern2.toString())){
                        que.offer(new Node(next,curr.step+1));
                    }
                }
            }
            
        }
        return 0;

    }
}
