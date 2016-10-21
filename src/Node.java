package sample;

import java.util.ArrayList;

public class Node {
    String parent;
    ArrayList<String> childs;
    int cost;

    public Node(String parent){
        this.parent = parent;
        this.childs = new ArrayList<String>();
    }

    public Node(String parent,int cost){
        this.parent = parent;
        this.childs = new ArrayList<String>();
        this.cost = cost;
    }

    public void addChild(String parent){
        childs.add(parent);
    }

    public ArrayList<String> getChilds(){return childs;}

    public String getParent(){return parent;}

    public int getCost(){return cost;}
}