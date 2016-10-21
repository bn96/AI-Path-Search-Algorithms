package sample;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Shape;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ResourceBundle;

public class Controller implements Initializable {


    @FXML
    Pane moniteredPane;

    Tree tree;

    //Managing nodes of tree
    HashMap<String, Node> nodes;

    //ArrayList contains objects ellipse representing nodes graphically
    HashMap<String,Ellipse> shapes;
    List<Shape> linesList = new ArrayList<>();

    // Classes used for drawing nodes and edges.
    Graph_Panel graphPanel;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.tree = new Tree();
        shapes = new HashMap<>();
        graphPanel = new Graph_Panel(moniteredPane,shapes);

        moniteredPane.setStyle("-fx-background-color:#D7D7D7;");
        listenForEvents(this.moniteredPane);


    }

    /**
     * This method listen for mouse events occurred over graph pane
     * @param obj Type Pane
     * @return obj Type Pane
     */
    Pane listenForEvents(Pane obj){
        //Double Click will draw a node on graph pane
        obj.setOnMouseClicked(e -> {
            if(e.getClickCount()==2){
                graphPanel.drawNode(e.getX(),e.getY());
            }
        });

        EventHandler handler = (Event e) ->{
            MouseEvent event = (MouseEvent) e;
            //check if user starts drag from a node
            shapes.forEach((key,value)->{
                if(value.contains(event.getX(),event.getY())){
                    graphPanel.drawEdge(event.getX(),event.getY(),value);
                    System.out.println("Reutrnaf");
                    event.consume();
                    return;
                }
            });

        };
        //Drag will draw a node on graph pane
        obj.setOnDragDetected(handler);
        obj.removeEventHandler(MouseDragEvent.DRAG_DETECTED, handler);

        return obj;
    }




//    void disableButons(int n) {
//        if (n == 1) addRoot.setDisable(true);
//        else if (n == 2) addNode.setDisable(true);
//        else if (n == 3) resetTree.setDisable(true);
//        else if (n == 4) addRoot.setDisable(false);
//        else if (n == 5) addNode.setDisable(false);
//        else if (n == 6) resetTree.setDisable(false);
//    }
//
//    public void addRoot() {
//        JDialog.setDefaultLookAndFeelDecorated(true);
//        String input = JOptionPane.showInputDialog(null, "Enter Root:", "Tree Root",
//                JOptionPane.QUESTION_MESSAGE);
//        this.nodes = tree.addNode(input);
//        display(input, null);
//        disableButons(1);
//        disableButons(5);
//        disableButons(6);
//        parent.requestFocus();
//    }
//
//    public void addNode() {
//        if (parent.getText().length() > 0 && child.getText().length() > 0) {
//            if (findParent(parent.getText().trim())) {
////                tree.addNode(child.getText().trim(), parent.getText());
//                nodes = tree.getNodes();
//            } else {
//                JOptionPane.showMessageDialog(null, "Error", "Invalid Parent Name!", JOptionPane.WARNING_MESSAGE);
//            }
//        } else {
//            JOptionPane.showMessageDialog(null, "Error", "Fields are missing!", JOptionPane.WARNING_MESSAGE);
//        }
//        display(tree.getRoot(), null);
//        child.requestFocus();
//    }
//
//    public void resetTree() {
//        tree = new Tree();
//        disableButons(2);
//        disableButons(3);
//        disableButons(4);
//    }
//
//    boolean findParent(String parent) {
//        if (nodes.get(parent) != null) {
//            return true;
//        } else return false;
//    }
//
//    void display(String parent, TreeItem<String> level) {
//        ArrayList<String> childs = nodes.get(parent).getChilds();
//        if (parent == tree.getRoot()) {
//            TreeItem<String> root = new TreeItem<>(parent);
//            level = root;
//            treeView.setRoot(root);
//            root.setExpanded(true);
//        } else {
//            TreeItem<String> node = new TreeItem<>(parent);
//            level.getChildren().add(node);
//            level = node;
//            node.setExpanded(true);
//        }
//        for (String child : childs) {
//            this.display(child, level);
//        }
//    }
//
//    public void dfs() {
//        list.setText("");
//        JDialog.setDefaultLookAndFeelDecorated(true);
//        String input = JOptionPane.showInputDialog(null, "Parent Node", "Enter Node:",
//                JOptionPane.QUESTION_MESSAGE);
//        Iterator<Node> depthIterator = tree.iterator(input, "DFS");
//        while (depthIterator.hasNext()) {
//            Node node = depthIterator.next();
//            list.appendText(node.getParent() + "\n");
//        }
//    }
//
//    public void bfs() {
//        list.setText("");
//        JDialog.setDefaultLookAndFeelDecorated(true);
//        String input = JOptionPane.showInputDialog(null, "Parent Node", "Enter Node:",
//                JOptionPane.QUESTION_MESSAGE);
//        Iterator<Node> depthIterator = tree.iterator(input, "BFS");
//        while (depthIterator.hasNext()) {
//            Node node = depthIterator.next();
//            list.appendText(node.getParent() + "\n");
//        }
//    }
}