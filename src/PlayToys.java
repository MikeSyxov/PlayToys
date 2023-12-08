import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class PlayToys {
    private static ArrayList<Toy> toys = new ArrayList<>();
    private static PriorityQueue<Toy> prizes = new PriorityQueue<>();

    private static int idCounter = 0;

    public void addToy() {
        Scanner scan = new Scanner(System.in);
        String title;
        int frequency;
        while (true) {
            System.out.print("Введите название: ");
            title = scan.nextLine();
            if (title.isEmpty()) {
                System.out.println("Некорректный ввод. Повторите снова.");
                break;
            }
            System.out.print("Введите частоту выподения: ");
            String value = scan.nextLine();
            if (isDigit(value)) {
                frequency = Integer.parseInt(value);
                if (frequency <= 0) {
                    System.out.println("Некорректный ввод. Повторите снова.");
                } else {
                    Toy toy = new Toy(idCounter, title, frequency);
                    if (!toys.contains(toy) || toys.size() == 0) {
                        idCounter++;
                        toys.add(toy);
                        System.out.println("Была добавлена новая игрушка");
                    } else {
                        System.out.println("Эта игрушка уже есть в призовом фонде.");
                    }
                }
            } else {
                System.out.println("Некорректный ввод. Повторите снова.");
            }
            break;
        }
    }

    public void setFrequency() {
    
    }

    private static boolean isDigit(String s) throws NumberFormatException {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }



    public void PlayToys() {
    
    }

   
}