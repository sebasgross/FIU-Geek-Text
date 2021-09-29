import java.util.ArrayList;
import java.util.Scanner;

public class GenreType {

    private int temp = 0;
    private Boolean go = true;
    private Boolean cont = true;
    private String yesNo;
    private ArrayList<String> genre = new ArrayList<String>();
    private Scanner read = new Scanner(System.in);
    private String[] genreList = {"Non-Fiction", "Mystery", "Thriller", "Horror", "Historical",
            "Science Fiction", "Educational", "Fiction"};

    public GenreType() {

    }

    public ArrayList setGenre() {
        go = true;
        cont = true;

        while (go) {
            System.out.println("--------Select a genre number tag--------" +
                    "\n1 Non-Fiction 2 Mystery 3 Thriller 4 Horror" +
                    "\n5 Historical 6 Science Fiction 7 Educational 8 Fiction");

            while (go) {
                System.out.println("input a genre number");
                temp = read.nextInt() - 1;
                read.nextLine();

                genre.add(genreList[temp]);

                cont = true;

                while (cont) {
                    System.out.println("Can the book be apart of another genre?(Y/N)");
                    yesNo = read.nextLine();

                    if (!(yesNo.equals("Y") || yesNo.equals("N"))) {
                        System.out.println("not a valid input");
                        cont = true;

                    } else {

                        if (yesNo.equals("Y")) {
                            cont = false;

                        } else if (yesNo.equals("N")) {
                            cont = false;
                            go = false;

                        }

                    }

                }

            }

        }
        return genre;
    }
}