import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        String[] products = {"Хлеб", "Яблоки", "Молоко"};
        int[] prices = {100, 200, 300};
        int[] sumCount = new int[3];

        System.out.println("Список возможных товаров для покупки");
        for (int i = 1; i <= products.length; i++) {
            System.out.println(i + ". " + products[i-1] + " " + prices[i-1] + " руб/шт");
        }

        boolean basketEmpty = true;
        while (true) {
            System.out.println("Введите номер и количество товара или введите `end`");
            String inputString = scn.nextLine();
            if (inputString.equals("end")) {
                if (!basketEmpty) {
                    System.out.println("Ваша корзина:\n" +
                            "Наименование товара   Количество  Цена/за.ед  Общая стоимость");
                    int sum = 0;
                    for (int i = 0; i < products.length; i++) {
                        if (sumCount[i] > 0) {
                            System.out.println(products[i] + "           " + sumCount[i] + "          " +
                                    prices[i] + "           " + (sumCount[i] * prices[i]));
                            sum += sumCount[i] * prices[i];
                        }
                    }
                    System.out.println("Итого: " + sum);
                } else {
                    System.out.println("Ваша корзина пуста");
                }
                break;
            } else {
                basketEmpty = false;
                String[] temp = inputString.split(" ");
                int productNumber = Integer.parseInt(temp[0])-1;
                int productCount = Integer.parseInt(temp[1]);
                sumCount[productNumber] = sumCount[productNumber] + productCount;
            }
        }
    }
}
