import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class test {
    static class Sudoku{
        char[][] Board;

        /*
        Sudoku(){
            Board=new char[9][9];
            for(int i=0;i<9;i++){
                for(int j=0;j<9;j++){
                    Board[i][j]= (char)((i+j)%9+49);
                }
            }
        }
        non-Constructor is NOT completed.
        */

        Sudoku(String filename) throws Exception {
            File file=new File(filename);
            BufferedReader BR=new BufferedReader(new FileReader(file));
            Board = new char[9][9];
            String line=BR.readLine();
            String nums;
            boolean END=false;
            int i=0,j=0;
            do{
                // Assume all blank are filled, valid file_input should only contain [1-9],
                // space" " and end_signal"#"
                nums=line.replace(" ","");
                while (j<9 && !END){ // Warning, but i didn't find error case:
                    char temp=nums.charAt(j);
                    if(temp=='#') {
                        END=true;
                        break;
                    }
                    try{
                        if(isValid(temp)){
                            Board[i][j]=temp;
                        }else{
                            throw new Exception("At line"+(i+1)+" has invalid value:"+temp);
                            // Throw out the Invalid value position
                        }
                    }finally {
                        j++;
                    }
                }
                j=0;
                i++;
                line=BR.readLine();
                if(i==9)    // If input 9 line value, end loop:
                    break;
            }while(!END);    // When meet End Signal, OR i=9, End the loop
            System.out.println("Load Completed.");
            BR.close();
        }

        public boolean isValid(char ch){
            return ch == '0' || ch == '1' || ch == '2' || ch == '3' || ch == '4' || ch == '5' || ch == '6' || ch == '7' || ch == '8' || ch == '9' || ch == ' ';
        }

        public String printGame(){
            String game="";
            for(int i=0;i<9;i++){
                if((i%3==0)){
                    game=game.concat("----------------------\n");
                }
                for(int j=0;j<9;j++){
                    if((j%3==0)){
                        game=game.concat("|");
                    }
                    if(Board[i][j]==0){
                        game=game.concat("   ");
                    }else{
                        game=game.concat(" "+ Board[i][j]);
                    }
                }
                game=game.concat(" |\n");
            }
            return game;
        }

        public boolean checkRow(int index){
            for(int cur=0;cur<9;cur++) {
                for (int i = cur+1; i < 9; i++) {
                    if (Board[index][i] == Board[index][cur]) {
                        return false;
                    }
                }
            }
            return true;
        }

        public boolean checkCol(int index){
            for(int cur=0;cur<9;cur++) {
                for (int i = cur+1; i < 9; i++) {
                    if (Board[i][index] == Board[cur][index]) {
                        return false;
                    }
                }
            }
            return true;
        }

        public boolean checkWin() {
            // check missing
            for(int i=0;i<9;i++){
                for(int j=0;j<9;j++){
                    if(Board[i][j]==' '||Board[i][j]=='0'){
                        return false;
                    }
                }
            }
            // check row and col:
            for(int i=0;i<9;i++){
                if(!checkCol(i)){
                    return false;
                }
                if(!checkRow(i)){
                    return false;
                }
            }
            // 9_Cube check, which I think is not necessary
            return true;
        }
    }

    public static void main(String[] args) throws IOException {
        String name="Sudoku.txt";
        Sudoku game= null;
        try {
            game = new Sudoku(name);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (game != null) {
            game.printGame();
            if(game.checkWin()){
                System.out.println("You WIN!");
            }else {
                System.out.println("NOT YET");
            }
        }
    }
}
