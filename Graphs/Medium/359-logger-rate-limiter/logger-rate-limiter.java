class Logger {
    Integer start;
    HashMap<String, Integer> map;
    public Logger() {
        map = new HashMap<>();
    }
    
    public boolean shouldPrintMessage(int timestamp, String message) {
        if(map.containsKey(message)){
            int lastSeen = map.get(message);
            if(timestamp < lastSeen + 10) {
                return false;
            } else {
                map.put(message, timestamp);
                return true;
            }
        } else {
            map.put(message, timestamp);
            return true;
        }
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */