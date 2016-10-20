package sample;

import javafx.application.Application;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("BFS_DFS");
        primaryStage.setScene(new Scene(root, 927, 595));
        primaryStage.show();
    }


    public static void main(String[] args){
        launch(args);
//        Tree obj = new Tree();
//        obj.addNode("1");
//        obj.addNode("2",3,"1");
//        obj.addNode("3",5,"1");
//        obj.addNode("4",2,"1");
//        obj.addNode("5",6,"2");
//        obj.addNode("6",3,"2");
//        obj.addNode("9",9,"5");
//        obj.addNode("10",5,"5");
//        obj.addNode("7",8,"4");
//        obj.addNode("8",10,"4");
//        obj.addNode("11",12,"7");
//        obj.addNode("12",11,"7");
//        A_StartSearch itr = new A_StartSearch(obj.getNodes(),"1");
//       BreadthFirstTreeIterator itr =  new BreadthFirstTreeIterator(obj.getNodes(),"1");
//        System.out.println("Iterator Result: ");
//        itr.getList().forEach(item->{
//            System.out.println(item.getParent());
//        });
//        DepthFirstTreeIterator itr = new DepthFirstTreeIterator(obj.getNodes(),"1");
//
//        while(itr.hasNext())System.out.println(itr.next().getParent());
//        while(itr.hasNext())System.out.println(itr.next());

    }

}
