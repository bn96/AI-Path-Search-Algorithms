package sample;

import java.util.*;

class IterativeDeppeningSearch implements Iterator<Node> {
    private LinkedList<Node> resultList;
    int maxLevel = 3;
    public IterativeDeppeningSearch(HashMap<String, Node> tree, String identifier) {
        resultList = new LinkedList<Node>();

        if (tree.containsKey(identifier)) {
            this.traverse(tree, identifier,0);
        }
    }

    void traverse(HashMap<String,Node> tree,String identifier,int level){
        //Iteration level.. You can adjust according to your need.
        if (level == maxLevel)return;
        resultList.add(tree.get(identifier));
        for(String child : tree.get(identifier).getChilds()){
            traverse(tree,child,level+1);
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