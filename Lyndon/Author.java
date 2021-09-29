import java.util.ArrayList;
import java.util.Scanner;

public class Author {

    private Boolean go;
    private Boolean cont;
    private String yesNo, name;
    private ArrayList<String> author = new ArrayList<String>();
    private Scanner read = new Scanner(System.in);


    public ArrayList addAuthors() {

        go = true;
        cont = true;

        while (go) {
            System.out.println("input the author's name");
            name = read.nextLine();
            author.add(name);

            cont = true;

            while (cont){
                System.out.println("Is there another author?(Y/N)");
                yesNo = read.nextLine();

                if(!(yesNo.equals("Y")||yesNo.equals("N"))){
                    System.out.println("not a valid input");
                    cont = true;

                }else{

                    if (yesNo.equals("Y")){
                        cont = false;
                    }
                    else if (yesNo.equals("N")){
                        cont =false;
                        go = false;
                    }

                }

            }

        }
        return author;
    }

}
