package sample;

import java.util.*;

public class DepthFirstTreeIterator implements Iterator<Node> {
    private LinkedList<Node> resultList;

    public DepthFirstTreeIterator(HashMap<String, Node> tree, String identifier) {
        resultList = new LinkedList<Node>();
        if (tree.containsKey(identifier)) {
            this.traverse(tree, identifier);
        }
    }

    void traverse(HashMap<String,Node> tree,String identifier){
        resultList.add(tree.get(identifier));
        for(String child : tree.get(identifier).getChilds()){
            traverse(tree,child);
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