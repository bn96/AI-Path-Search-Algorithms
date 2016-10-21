package sample;

import java.util.*;

public class A_StarSearch implements Iterator<Node> {
    private LinkedList<Node>resultList;
    private LinkedList<Node> queue;
    String goal;
    private HashMap<String,Integer> heuristic;
    public A_StarSearch(HashMap<String, Node> tree, String identifier,String goal,HashMap<String,Integer> heuristic) {
        resultList = new LinkedList<Node>();
        queue = new LinkedList<>();
        this.goal = goal;
        this.heuristic = heuristic;
        if (tree.containsKey(identifier)) {
            this.traverse(tree, identifier);
        }
    }

    void traverse(HashMap<String, Node> tree, String identifier) {
        queue.add(tree.get(identifier));
        Node node = null;
        while (!queue.isEmpty()) {
            node = queue.poll();
            System.out.println("3- Pooled Object: "+node.getParent()+" Cost: "+ node.getCost());
            resultList.add(node);
            if(node.getParent()==goal){
                System.out.println("Goal Found");
                return;
            }

            node.getChilds().forEach(item -> {
                queue.add(tree.get(item));
            });
            System.out.println("1- Before Sort:\n");
            display();
            sortTheQueue();
            System.out.println("2- After Sort:\n");
            display();
        }
    }
    void sortTheQueue(){
        Node temp;
        for(int i = 0 ; i < queue.size() ; i++){
            System.out.print("Print");
            for(int j = i ; j < queue.size(); j++){
                if((queue.get(i).getCost()+heuristic.get(queue.get(i).getParent()))
                        > queue.get(j).getCost()+(+heuristic.get(queue.get(i).getParent()))){
                    temp = queue.get(i);
                    queue.add(i,queue.get(j));
                    queue.add(j,temp);
                    queue.remove(j);
                    queue.remove(j+1);
                }
            }
        }
    }

    void display(){
        queue.forEach(e->{
            System.out.println("Queue Status: "+e.getParent()+" Cost: "+e.getCost());
        });
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