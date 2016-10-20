package sample;

import javafx.application.Platform;
import javafx.event.*;
import javafx.event.Event;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.control.*;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.util.Pair;
import java.util.HashMap;
import java.util.Optional;

public class Graph_Panel {

    Pane graphPane;
    HashMap<String,Ellipse> shapes;
    public Graph_Panel(Pane obj,HashMap<String,Ellipse> shapes){
        this.graphPane = obj;
        this.shapes = shapes;
    }

    /**
     * This method will take Node ID and Cost(optional) as input to create an ellipse(Node) on the screen.
     * @param x
     * @param y
     */
    void drawNode(double x, double y){
        Dialog<Pair<String, String>> dialog = new Dialog<>();
        dialog.setTitle("Node Information");

        // Set the buttons
        dialog.getDialogPane().getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);

        // Create the ID and Cost labels and fields.
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20, 150, 10, 10));

        TextField id = new TextField();
        id.setPromptText("Node ID");
        TextField cost= new TextField();
        cost.setPromptText("Cost");

        grid.add(new Label("Node ID:"), 0, 0);
        grid.add(id, 1, 0);
        grid.add(new Label("Cost:"), 0, 1);
        grid.add(cost, 1, 1);

        dialog.getDialogPane().setContent(grid);

        // Request focus on the ID field by default.
        Platform.runLater(() -> id.requestFocus());

        // Convert the result to a ID-Cost-pair when the login button is clicked.
        dialog.setResultConverter(dialogButton -> {
            if (dialogButton == ButtonType.OK) {
                return new Pair<>(id.getText(), cost.getText());
            }
            return null;
        });

        Optional<Pair<String, String>> result = dialog.showAndWait();

        // Create a node if user have provided node ID otherwise return after showing a ERROR
        result.ifPresent(idCost -> {
            if(idCost.getKey().length()==0){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setTitle("Sorry!");
                alert.setContentText("Node ID is required, Try again :)");
                alert.showAndWait();
                return;
            }

            // Below Code will add Node with label representing ID
            Ellipse ellipse = new Ellipse();
            ellipse.setCenterX(x);
            ellipse.setCenterY(y);
            ellipse.setRadiusX(35.0f);
            ellipse.setRadiusY(35.0f);
            ellipse.setFill(Color.web("0x65ACF3"));

            // Label on node representing ID
            Label lbl = new Label(idCost.getKey());
            lbl.setStyle("-fx-forground-color:#12090d;");
            lbl.setTranslateX(x-20);
            lbl.setTranslateY(y-6);

            // Add node and label to graph panel
            graphPane.getChildren().add(ellipse);
            graphPane.getChildren().addAll(lbl);
            shapes.put(idCost.getKey(),ellipse);
        });
    }


    void drawEdge(double x,double y,Ellipse node){

        EventHandler handler = (Event e)->{
            MouseEvent event = (MouseEvent)e;
            Group gr = new Group();
            Text text = new Text("1st Street");
            text.setFill(Color.web("fabbff"));
            Line line = new Line(x, y, event.getX(),event.getY());
            line.setStrokeWidth(1);
            line.setStroke(Color.web("000000"));
            gr.getChildren().addAll(line, text);
            graphPane.getChildren().add(gr);
            System.out.println("Mouse Drag Released: " + event.getX() + " , " + event.getY());
            e.consume();
            return;
        };
        graphPane.addEventHandler(MouseEvent.MOUSE_RELEASED, handler);
        //graphPane.setOnMouseReleased(handler);
        //graphPane.removeEventHandler(MouseEvent.MOUSE_RELEASED,handler);
    }
}



























