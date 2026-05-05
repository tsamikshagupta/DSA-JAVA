class RandomizedSet {
    List<Integer> l;
    Map<Integer, Integer> m;
    Random r;

    public RandomizedSet() {
        l = new ArrayList<>();
        m = new HashMap<>();
        r = new Random();
    }
    
    public boolean insert(int v) {
        if (m.containsKey(v)) return false;
        l.add(v);
        m.put(v, l.size() - 1);
        return true;
    }
    
    public boolean remove(int v) {
        if (!m.containsKey(v)) return false;
        int i = m.get(v);
        int last = l.get(l.size() - 1);
        l.set(i, last);
        m.put(last, i);
        l.remove(l.size() - 1);
        m.remove(v);
        return true;
    }
    
    public int getRandom() {
        return l.get(r.nextInt(l.size()));
    }
}