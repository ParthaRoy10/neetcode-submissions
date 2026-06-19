class TimeMap {

    private static class Pair{
        int timestamp;
        String value;
        public Pair(int timestamp,String value){
            this.timestamp = timestamp;
            this.value = value;
        }
    }

    Map<String, List<Pair>> mapp;

    public TimeMap() {
        mapp = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        mapp.computeIfAbsent(key, k -> new ArrayList<>()).add(new Pair(timestamp,value));

    }
    
    public String get(String key, int timestamp) {
        if (!mapp.containsKey(key)){
            return "";
        }
        List<Pair> pair = mapp.get(key);

        int left = 0;
        int right = pair.size()-1;

        String ans = "";

        while (left <= right){
            int mid = left + (right - left)/2;

            if(pair.get(mid).timestamp <= timestamp){
                ans = pair.get(mid).value;
                left = mid + 1;
            }else{
                right = mid-1;
            }

        }
        return ans;
    }
}
