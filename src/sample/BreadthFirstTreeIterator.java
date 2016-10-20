package sample;

import java.util.*;

public class BreadthFirstTreeIterator implements Iterator<Node> {
    private LinkedList<Node>resultList;
    private Queue<Node> queue;

    public BreadthFirstTreeIterator(HashMap<String, Node> tree, String identifier) {
        resultList = new LinkedList<Node>();
        queue = new LinkedList<>();
        if (tree.containsKey(identifier)) {
            this.traverse(tree, identifier);
        }
    }

    public void traverse(HashMap<String, Node> tree, String identifier){
        queue.add(tree.get(identifier));
        Node node = null;
        while(!queue.isEmpty()){
            node = queue.poll();
            resultList.add(node);
            node.getChilds().forEach(item->{
                queue.add(tree.get(item));
            });
        }
    }


    @Override
    public boolean hasNext() {
        return !resultList.isEmpty();
    }

    @Override
    public Node next() {
        return resultList.poll();
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}