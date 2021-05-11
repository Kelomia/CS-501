/*
  CS501 Assignment-7
    14.1/14.2
 */

public class DisplayImage {
    public void start(Stage primaryStage) throws exception{
        GridPane gridPane = new GridPane();
        int flagCount=0;
        for(int i=0;i<2;i++){
            for(int j=0;j<2;j++){
                gridPane.add(new ImageView(new Image("image/flag"+flagCount+".gif")),i,j);
                flagCount++;
            }
        }
        Scene scene=new Scene(gridPane, 1000,500);
        primaryStage.setTitle("Flags");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args){
        Application.launch(args);
    }
}
