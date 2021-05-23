import java.io.*;

public class Sudoku {
    int[][] cell;
    boolean win=false;

    Sudoku(){
        cell=new int[9][9];
    }
    Sudoku(File input){
        cell=new int[9][9];
        try {
            Reader fill=new InputStreamReader(new FileInputStream(input));
            int temp;
            while((temp=fill.read())!=-1){
                if(((char)temp!='\r')){
                    for(int i=0;i<9;i++){
                        for(int j=0;j<9;j++){
                            cell[i][j]=temp;
                        }
                    }
                }
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    void printGame(){

    }
    public static void main(String[] args){
        File file=new File("Sudoku.txt");
        Sudoku game=new Sudoku(file);

    }
}
