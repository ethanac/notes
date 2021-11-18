public class SolutionLRUCache {
    int capacity;
    LinkedList<Integer> list;
    Map<Integer, Integer> map;

    /*
    * @param capacity: An integer
    */public LRUCache(int capacity) {
        // do intialization if necessary
        this.capacity = capacity;
        list = new LinkedList<>();
        map = new HashMap<>();
    }

    /*
     * @param key: An integer
     * @return: An integer
     */
    public int get(int key) {
        // write your code here
        if(!map.containsKey(key)) return -1;

        list.remove(Integer.valueOf(key));
        list.addFirst(key);

        return map.get(key);
    }

    /*
     * @param key: An integer
     * @param value: An integer
     * @return: nothing
     */
    public void set(int key, int value) {
        // write your code here
        if(list.size() == capacity && !map.containsKey(key)) {
            Integer keyToRemove = list.getLast();
            map.remove(keyToRemove);
            list.removeLast();
            // System.out.println("Removed: " + nextToRemove);
        }
        if(!map.containsKey(key)) {
            list.addFirst(key);
        } else{
            list.remove(Integer.valueOf(key));
            list.addFirst(key);
        }
        map.put(key, value);
    }
}
