class HashTable{
    Node[] harr;
    int size=997;
    HashTable(){
        harr = new Node[size];
    }
    int hash(int x){
        return (x*x*x + 3*x*x + 1)%size;
    }
    void put(int k,int v){
        int index = hash(k);
        System.out.println(index);
        Node kv = new Node(k,v);
        harr[index] = kv;
    }
    int get(int k){
        int index = hash(k);
        return harr[index].value;
    }
    void remove(int k){
        if(contains(k)) harr[hash(k)] = null;
    }
    void print(){
        for(int i=0;i<size;i++){
            if(harr[i]!=null) System.out.print(harr[i].key+":"+harr[i].value+"  ");
        }
        System.out.println();
    }
    boolean contains(int k){
        if(harr[hash(k)]==null) return false;
        return true;
    }
}