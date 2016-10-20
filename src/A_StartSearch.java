package sample;

import java.util.*;

public class A_StartSearch implements Iterator<Node> {
    //    private LinkedList<Node> list;
    private Queue<Node> queue;

    private PriorityQueue<Node> prq;


    public A_StartSearch(HashMap<String, Node> tree, String identifier) {
//        list = new LinkedList<Node>();
        queue = new LinkedList<>();
        prq = new PriorityQueue<>();

        if (tree.containsKey(identifier)) {
            this.traverse(tree, identifier);
        }
    }



    public void traverse(HashMap<String, Node> tree, String identifier){
        queue.add(tree.get(identifier));
        Node node = null;
        while(!queue.isEmpty()){
            node = queue.poll();
            prq.add(node);
            node.getChilds().forEach(item->{
                queue.add(tree.get(item));
            });
        }
    }

    void evaluationFunction(int gn){

    }


    @Override
    public boolean hasNext() {
        return !prq.isEmpty();
    }

    @Override
    public Node next() {
        return prq.poll();
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}