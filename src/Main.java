import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PlayToys run = new PlayToys();
        Scanner scan = new Scanner(System.in);
        while (true) {
            System.out.print("""
                    Меню функций:
                    1 - Добавьте новую игрушку в призовой фонд
                    2 - Измените частоту выпадения игрушки
                    3 - Провести розыгрыш с сохранением результата
                    4 - Выход
                    >\s""");
            var selection = scan.next();
            switch (selection) {
                case "1" -> run.addToy();
                case "2" -> run.setFrequency();
                case "3" -> run.playToys();
                case "4" -> {
                    System.out.println("Выход произведен");
                    System.exit(4);
                }
                default -> System.out.println("Некорректный выбор. Попробуйте снова.");
            }
        }
    }
}
