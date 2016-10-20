package sample;

import java.util.HashMap;
import java.util.Iterator;

public class Tree {
    String root = null;
    HashMap<String,Node> nodes;

    public Tree(){
        nodes = new HashMap<String, Node>();
    }

    public HashMap<String,Node> getNodes(){return this.nodes;}

    public String getRoot(){return  root;}

    public HashMap<String,Node> addNode(String child){
        root = child;
        return addNode(child,0,null);
    }

    HashMap<String,Node> addNode(String child,int cost,String parent){
        Node obj = new Node(child,cost);
        nodes.put(child,obj);
        if (parent != null){
            nodes.get(parent).addChild(child);
        }
        return nodes;
    }

    public Iterator<Node> iterator(String parent,String searchType){
        if (searchType == "BFS"){
            return new BreadthFirstTreeIterator(nodes,parent);
        }else{
            return new DepthFirstTreeIterator(nodes,parent);
        }
    }
}


