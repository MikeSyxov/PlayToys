import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Random;
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
            System.out.print("Введите частоту выподения где 1(10%) а 3(30%) шанс: ");
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
        Scanner scan = new Scanner(System.in);
        System.out.print("Введите ID игрушки: ");
        String value = scan.nextLine();
        if (isDigit(value)) {
            int selectedId = Integer.parseInt(value);
            if (selectedId >= 0 && selectedId < toys.size()) {
                System.out.println("Toy " + toys.get(selectedId).getToyTitle() +
                        " частота выйгрыша " + toys.get(selectedId).getToyVictoryFrequency());
                System.out.print("Введите новую частоту выподения: ");
                value = scan.nextLine();
                if (isDigit(value)) {
                    int newFrequency = Integer.parseInt(value);
                    toys.get(selectedId).setToyVictoryFrequency(newFrequency);
                    System.out.println("Частота изменина.");
                } else {
                    System.out.println("Некорректный ввод. Повторите снова.");
                }
            } else {
                System.out.println("В призовом фонде нет игрушки с таким ID.");
            }
        } else {
            System.out.println("Некорректный ввод. Повторите снова.");
        }

    }

    private static boolean isDigit(String s) throws NumberFormatException {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public Toy getPrize() {
        if (prizes.size() == 0) {
            Random rnd = new Random();
            for (Toy toy : toys) {
                for (int i = 0; i < toy.getToyVictoryFrequency(); i++) {
                    Toy temp = new Toy(toy.getToyId(), toy.getToyTitle(), rnd.nextInt(1, 10));
                    prizes.add(temp);
                }
            }
        }
        return prizes.poll();
    }

    public void playToys() {
        if (toys.size() >= 2) {
            Toy prize = getPrize();
            System.out.println("Приз: " + prize.getToyTitle());
            saveResult(prize.getInfo());
        } else {
            System.out.println("Вы должны добавить в призовой фонд как минимум две игрушки.");
        }
    }

    private void saveResult(String text) {
        File file = new File("Result.txt");
        try {
            file.createNewFile();
        } catch (Exception ignored) {
            throw new RuntimeException();
        }
        try (FileWriter fw = new FileWriter("Result.txt", true)) {
            fw.write(text + "\n");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

}