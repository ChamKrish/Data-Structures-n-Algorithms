class HashTest{
    public static void main(String args[]){
        HashTable h = new HashTable();
        System.out.println(h.hash(500));
        System.out.println(h.hash(501));
        System.out.println(h.hash(502));
        h.put(10,100);
        h.put(5,25);
        h.put(7,49);
        if(h.contains(10)) 
            System.out.println(h.get(10));
        if(h.contains(50))
            System.out.println(h.get(50));
        h.print();
        h.remove(10);
        h.print();
    }
}