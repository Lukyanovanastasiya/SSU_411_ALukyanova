import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.System.out;

import java.lang.String;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int i = 0;
        int number = 0;
        int update;
        String c;
        String s;
        MyBasket.Write();
        Basket m = new MyBasket();
        do {
            out.println("1 - Получить список продуктов");
            out.println("2 - Получить количество определённого продукта");
            out.println("3 - Добавить продукт в корзину");
            out.println("4 - Обновить количество продукта");
            out.println("5 - Удалить продукт из корзины");
            out.println("6 - Очистить корзину");
            out.println("7 - Выход");
            out.println();
            out.println("Введите номер, результат работы которого хотите получить ");
            try {
                number = Integer.parseInt(in.next());
            } catch (NumberFormatException ex) {
                number = 0;
                System.out.println("Введено не число");
            }
            number--;
            switch (number) {
                case -1://Получить список продуктов
                    break;
                case 0://Получить список продуктов
                    System.out.println(m.getProducts());
                    break;
                case 1://Получить количество определённого продукта в магазине
                    c = in.nextLine();//считываем одну строку целиком
                    out.println("Введите наименование продукта ");
                    try {
                        c = in.nextLine();//считываем одну строку целиком
                    } catch (NumberFormatException ex) {
                        c = "";
                        System.out.println("Ничего не введено");
                    }
                    m.getProductQuantity(c);
                    break;
                case 2://Добавить продукт в корзину
                    c = in.nextLine();//считываем одну строку целиком
                    out.println("Введите наименование продукта ");
                    try {
                        c = in.nextLine();//считываем одну строку целиком
                    } catch (NumberFormatException ex) {
                        c = "";
                        System.out.println("Ничего не введено");
                        System.exit(0);
                    }
                    out.println("Введите количество продукта ");
                    try {
                        update = in.nextInt();
                    } catch (NumberFormatException ex) {
                        update = 0;
                        System.out.println("Ничего не введено");
                        System.exit(0);
                    }
                    m.addProduct(c, update);//добавляем в корзину пользователя товар
                    break;
                case 3://Обновить количество продукта
                    c = in.nextLine();//считываем одну строку целиком
                    out.println("Введите наименование продукта ");
                    try {
                        c = in.nextLine();//считываем одну строку целиком
                    } catch (NumberFormatException ex) {
                        c = "";
                        System.out.println("Ничего не введено");
                        System.exit(0);
                    }
                    out.println("Введите количество продукта ");
                    try {
                        update = in.nextInt();
                    } catch (NumberFormatException ex) {
                        update = 0;
                        System.out.println("Ничего не введено");
                        System.exit(0);
                    }
                    m.updateProductQuantity(c, update);//обновляем количество продукта
                    break;
                case 4://Удалить продукт из корзины
                    c = in.nextLine();//считываем одну строку целиком
                    out.println("Введите наименование продукта ");
                    try {
                        c = in.nextLine();//считываем одну строку целиком
                    } catch (NumberFormatException ex) {
                        c = "";
                        System.out.println("Ничего не введено");
                        System.exit(0);
                    }
                    m.removeProduct(c);
                    break;
                case 5://Очистить корзину
                    m.clear();
                    break;
                case 6://Выход
                    System.exit(0);
                    break;
            }
            System.out.println();
        } while (number != -2);
    }
}
