import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static String shop;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ArrayList<String> list = new ArrayList<>();

        while (true) {
            mainMenu(scanner);
            if (shop.equalsIgnoreCase("end")) {
                break;
            } else {
                switch (shop) {
                    case ("1"): {
                        itemToBuy(scanner, list);
                        break;
                    }
                    case ("2"): {
                        show(list);
                        break;
                    }
                    case ("3"): {
                        deleteItem(scanner, list);
                        show(list);
                        break;
                    }
                    case ("4"): {
                        findItem(scanner, list);
                        break;
                    }

                }
            }
        }
    }

    private static void mainMenu(Scanner scanner) {
        System.out.println("Введите номер операции или end для завершения:");
        System.out.println("1.Добавить");
        System.out.println("2.Показать");
        System.out.println("3.Удалить");
        System.out.println("4.Найти");
        shop = scanner.nextLine();
    }

    private static void itemToBuy(Scanner scanner, ArrayList<String> list) {
        System.out.println("Введите продукт покупки:");
        shop = scanner.nextLine();
        list.add(shop);
        System.out.println("Итого в списке покупок: " + list.size());
    }

    public static void show(ArrayList<String> list) {
        for (String i : list) {
            System.out.println(list.indexOf(i) + 1 + ". " + i);
        }
    }

    private static void deleteItem(Scanner scanner, ArrayList<String> list) {
        System.out.println("Какой пункт покупок хотите удалить? Введите номер или название");
        show(list);
        shop = scanner.nextLine();
        try {
            list.remove(Integer.parseInt(shop) - 1);
        } catch (NumberFormatException e) {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).equalsIgnoreCase(shop)) {
                    list.remove(i);
                    System.out.println("Номер покупки удален!");
                }
            }
        }
    }

    private static void findItem(Scanner scanner, ArrayList<String> list) {
        System.out.println("Какую покупку найти? Введите номер или название");
        shop = scanner.nextLine();
        try {
            System.out.println("Пункт покупки найден! \n" + shop + ". " + list.get(Integer.parseInt(shop) - 1));
        } catch (NumberFormatException e) {
            String lowerCase;
            String scanLow = shop.toLowerCase();
            for (int i = 0; i < list.size(); i++) {
                lowerCase = list.get(i).toLowerCase();
                if (lowerCase.contains(scanLow)) {
                    System.out.println((list.indexOf(list.get(i)) + 1) + ". " + list.get(i));
                }
            }
        }
    }

}
