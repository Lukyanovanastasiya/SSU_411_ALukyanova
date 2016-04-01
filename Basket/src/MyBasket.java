import java.io.*;
import java.util.*;
import java.util.Scanner;

import static java.lang.System.out;
import static java.nio.file.Files.exists;

public class MyBasket implements Basket {
    private static String fileName = "G:/Basket/1.txt";
    private static ArrayList<String> basket = new ArrayList<String>();

    public static void Write() {//считываем в массив
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File(fileName));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while (scanner.hasNext()) {//заполняем строками
            basket.add(scanner.nextLine());
        }
        scanner.close();
    }

    @Override
    public void addProduct(String product, int quantiti) {//добавить продукт (название, количество)
        boolean t = false;
        String s;
        for (int i = 0; i < basket.size(); i++) {
            if (basket.get(i).contains(product)) {
                updateProductQuantity(product, quantiti);
                t = true;
            }
        }
        if (t == false) {
            s = product + " - " + quantiti;
            basket.add(s);
        }
    }

    @Override
    public void removeProduct(String product) {// удалить продукт из корзины(название)
        for (int i = 0; i < basket.size(); i++) {
            if (basket.get(i).contains(product)) {
                basket.remove(i);
            }
        }
    }

    @Override
    public void updateProductQuantity(String product, int quantiti) {//обновить количество продукта
        String s;
        String sub;
        int kol;
        int pos;
        int length;
        for (int i = 0; i < basket.size(); i++) {
            if (basket.get(i).contains(product)) {
                length = basket.get(i).length();//длина строки
                pos = basket.get(i).indexOf(" - ");//находим разделитель
                sub = basket.get(i).substring(pos + 3, length);//считываем после разделителя подстроку
                kol = new Integer(sub);//переводим строковое обозначение в числовое
                s = product + " - " + (kol + quantiti);//обновляем количество продукта
                basket.set(i, s);
            }
        }
    }

    @Override
    public void clear() {//очистить
        basket.clear();
    }

    @Override
    public List<String> getProducts() {//получить продукты
        return basket;
    }

    @Override
    public int getProductQuantity(String product) {//получить количество определённого продукта
        String s;
        String sub;
        int kol;
        int pos;
        int length;
        for (int i = 0; i < basket.size(); i++) {
            if (basket.get(i).contains(product)) {
                length = basket.get(i).length();//длина строки
                pos = basket.get(i).indexOf(" - ");//находим разделитель
                sub = basket.get(i).substring(pos + 3, length);//считываем после разделителя подстроку
                kol = new Integer(sub);//переводим строковое обозначение в числовое
                System.out.println(kol);
            }
        }
        return 0;
    }
}