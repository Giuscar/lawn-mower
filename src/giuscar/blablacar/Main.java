package giuscar.blablacar;
import giuscar.blablacar.start.Lawn;

public class Main {

    public static void main(String[] args) {
        try {
            Lawn lawn = new Lawn("input.txt");
            lawn.runMowers();
        }catch(Exception e){
            System.out.println("Something went wrong");
            e.printStackTrace();
        }

    }
}
