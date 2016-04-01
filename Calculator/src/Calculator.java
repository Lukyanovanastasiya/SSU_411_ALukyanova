import java.util.Objects;
import java.util.Scanner;
import java.lang.Math;

import static java.lang.Math.pow;
import static java.lang.System.*;

public class Calculator {

    public static void main(String[] args) {
        int i;
        int j;
        int p = 0;
        int p1;
        int m;
        int g;
        int length;
        String op;
        String s;
        String s1;
        String name;
        double l2;
        double l;
        double l1;
        String l3;
        int pos;
        String close = "Close";
        char add = '+';
        char min = '-';
        char mul = '*';
        char del = '/';
        char step = '^';
        char parl = '(';
        char parr = ')';
        int q = 0;
        int d = 0;
        int kAdd = 0;
        int kMin = 0;
        int kDel = 0;
        int kMul = 0;
        int kStep = 0;
        int kParl = 0;
        int kParr = 0;
        int a;
        int k;
        int length1;
        int a1;
        int Parl1;

        Scanner in = new Scanner(System.in);
        do {
            a = 0;
            out.println("Пожалуйста, введите выражение");
            p = 0;
            m = 0;
            s = in.nextLine();
            s = s + "#";
            String[] masPar = new String[40];
            String[] mas = new String[40];
            for (i = 0; i < 40; i++) {
                mas[i] = null;
            }
            kParl = 0;
            kParr = 0;
            length = s.length();
            s1 = new String(s.substring(0, length - 1));
            k = 0;
            if (s1.equals(close)) {
                exit(0);//принудительная остановка
            }
            // возвращает истинну если с потока ввода можно считать целое число
            if ((length > 2)) {
                for (j = 0; j < length; j++) {
                    if (k >= length) {
                        break;
                    }
                    while ((s.charAt(k) != '+') && (s.charAt(k) != '-') && (s.charAt(k) != '*') &&
                            (s.charAt(k) != '/') && (s.charAt(k) != '^') && (s.charAt(k) != '#') &&
                            (s.charAt(k) != '(') && (s.charAt(k) != ')')) {
                        k++;
                    }
                    if (s.charAt(k) == '#') {
                        length--;
                    }
                    if (p > k) {
                        k = p + 1;
                    }
                    op = s.substring(p, k);//считываем подстроку до символа
                    p = k + 1;
                    g = op.length();
                    pos = op.indexOf("+");
                    //вычленяем имя атрибута из подстроки
                    if (pos != -1) {
                        op = op.substring(pos + 1, g);
                    }
                    mas[m] = op;////записываем в массив
                    m++;
                    if (k < length) {
                        if (s.charAt(k) == add) {
                            mas[m] = "+";
                            kAdd++;
                            k++;
                        } else if (s.charAt(k) == min) {
                            mas[m] = "-";
                            kMin++;
                            k++;
                        } else if (s.charAt(k) == mul) {
                            mas[m] = "*";
                            kMul++;
                            k++;
                        } else if (s.charAt(k) == del) {
                            mas[m] = "/";
                            kDel++;
                            k++;
                        } else if (s.charAt(k) == step) {
                            mas[m] = "^";
                            kStep++;
                            k++;
                        } else if (s.charAt(k) == parl) {
                            mas[m] = "(";
                            kParl++;
                            k++;
                        } else if (s.charAt(k) == parr) {
                            mas[m] = ")";
                            kParr++;
                            k++;
                        }
                    }
                    m++;
                }
            } else {
                out.println("Вы не ввели выражение");
                length = 1;
            }
            q = 0;
            d = 0;
            length1 = 0;
            while (mas[q] != null) {
                length1++;
                q++;
            }
            q = 0;
            while (q <= length1 - 1) {
                if (mas[q].equals("")) {
                    d = q;
                    while (d <= length1 - 1) {
                        mas[d] = mas[d + 1];
                        d++;
                    }
                    mas[d - 1] = null;
                    d = 0;
                    length1--;
                }
                q++;
            }
            if (mas[length1] != null) {
                length1++;
            }

            if (kParl != kParr) {
                out.println("Некорректный ввод выражения");
                length = 1;
            }
            if (kParl != 0) {
                length = length1 - 1;
            } else {
                length = length1;
            }
            while (length != 1) {
                j = 0;

                for (int y = 0; y <= length; y++) {
                    if (mas[y] == null) {
                        length--;
                    }
                }

                while ((kParl != 0) && (kParr != 0)) {
                    a = 0;
                    a1 = 0;
                    while ((mas[j] != "(") && (mas[j] != null)) {//ищем для возведения в степень
                        j++;
                    }
                    j++;
                    Parl1 = j;
                    masPar[a] = mas[j];
                    a++;
                    while (mas[j] != ")") {
                        j++;
                        masPar[a] = mas[j];
                        a++;//количество элементов
                        a1++;
                    }
                    masPar[a] = null;
                    for (int h = Parl1; h <= length; h++) {
                        mas[h] = mas[h + 1];
                        a = h;
                    }
                    mas[a] = null;
                    g = 0;
                    while (masPar[g] != null) {
                        g++;
                    }
                    Parentheses.brackets(masPar, j - Parl1);
                    mas[Parl1 - 1] = masPar[0];

                    for (int h = Parl1; (h <= length); h++) {
                        mas[h] = mas[h + a1];
                    }
                    length = length - (a1);
                    kParl--;
                    kParr--;
                    j = 0;
                }

                j = 0;
                while ((mas[j] != "^") && (j <= length)) {//ищем для возведения в степень
                    j++;
                }
                while (mas[j] == "^") {
                    pos = mas[j - 1].indexOf(".0");
                    //вычленяем имя атрибута из подстроки
                    if (pos == -1) {
                        name = mas[j - 1];
                    } else {
                        name = mas[j - 1].substring(0, pos);
                    }
                    l1 = new Double(name);//преобразуем в число
                    pos = mas[j + 1].indexOf(".0");
                    //вычленяем имя атрибута из подстроки
                    if (pos == -1) {
                        name = mas[j + 1];
                    } else {
                        name = mas[j + 1].substring(0, pos);
                    }
                    l2 = new Double(name);//преобразуем в число
                    l = pow(l1, l2);
                    l3 = Double.toString(l);//преобразование числа в строку
                    mas[j - 1] = l3;
                    for (int h = j; h <= length; h++) {
                        mas[h] = mas[h + 2];
                    }
                    length = length - 2;
                    kStep--;
                    if (kStep > 0) {
                        while ((mas[j] != "^") && (j <= length)) {//ищем для *
                            j++;
                        }
                    }
                }
                j = 0;

                while ((mas[j] != "/") && (j < length)) {
                    j++;
                }
                while (mas[j] == "/") {
                    pos = mas[j - 1].indexOf(".0");
                    if (pos == -1) {
                        name = mas[j - 1];
                    } else {
                        name = mas[j - 1].substring(0, pos);
                    }
                    l1 = new Double(name);
                    pos = mas[j + 1].indexOf(".0");
                    if (pos == -1) {
                        name = mas[j + 1];
                    } else {
                        name = mas[j + 1].substring(0, pos);
                    }
                    l2 = new Double(name);//??????????? ? ?????
                    l = l1 / l2;
                    l3 = Double.toString(l);//?????????????? ????? ? ??????
                    mas[j - 1] = l3;
                    for (int h = j; h < length; h++) {
                        mas[h] = mas[h + 2];
                    }
                    length = length - 2;
                    kDel--;
                    if (kDel > 0) {
                        while ((mas[j] != "/") && (j <= length)) {//ищем для *
                            j++;
                        }
                    }
                }
                j = 0;

                while ((mas[j] != "*") && (j <= length)) {//ищем для *
                    j++;
                }
                while (mas[j] == "*") {
                    pos = mas[j - 1].indexOf(".0");
                    //вычленяем имя атрибута из подстроки
                    if (pos == -1) {
                        name = mas[j - 1];
                    } else {
                        name = mas[j - 1].substring(0, pos);
                    }
                    l1 = new Double(name);//преобразуем в число
                    pos = mas[j + 1].indexOf(".0");
                    //вычленяем имя атрибута из подстроки
                    if (pos == -1) {
                        name = mas[j + 1];
                    } else {
                        name = mas[j + 1].substring(0, pos);
                    }
                    l2 = new Double(name);//преобразуем в число
                    l = l1 * l2;
                    l3 = Double.toString(l);//преобразование числа в строку
                    mas[j - 1] = l3;
                    for (int h = j; h <= length; h++) {
                        mas[h] = mas[h + 2];
                    }
                    length = length - 2;
                    kMul--;
                    if (kMul > 0) {
                        while ((mas[j] != "*") && (j <= length)) {//ищем для *
                            j++;
                        }
                    }

                }
                j = 0;

                while ((mas[j] != "-") && (j <= length)) {
                    j++;
                }
                while (mas[j] == "-") {
                    pos = mas[j - 1].indexOf(".0");
                    if (pos == -1) {
                        name = mas[j - 1];
                    } else {
                        name = mas[j - 1].substring(0, pos);
                    }
                    l1 = new Double(name);//??????????? ? ?????
                    pos = mas[j + 1].indexOf(".0");
                    if (pos == -1) {
                        name = mas[j + 1];
                    } else {
                        name = mas[j + 1].substring(0, pos);
                    }
                    l2 = new Double(name);//??????????? ? ?????
                    l = l1 - l2;
                    l3 = Double.toString(l);//?????????????? ????? ? ??????
                    mas[j - 1] = l3;
                    for (int h = j; h < length; h++) {
                        mas[h] = mas[h + 2];
                    }
                    length = length - 2;
                    kMin--;
                    if (kMin > 0) {
                        while ((mas[j] != "-") && (j <= length)) {//ищем для *
                            j++;
                        }
                    }
                }
                j = 0;

                while ((mas[j] != "+") && (j <= length)) {//???? ??? ?????????? ? ???????
                    j++;
                }
                while (mas[j] == "+") {
                    pos = mas[j - 1].indexOf(".0");
                    //????????? ??? ???????? ?? ?????????
                    if (pos == -1) {
                        name = mas[j - 1];
                    } else {
                        name = mas[j - 1].substring(0, pos);
                    }
                    l1 = new Double(name);//??????????? ? ?????
                    pos = mas[j + 1].indexOf(".0");
                    //????????? ??? ???????? ?? ?????????
                    if (pos == -1) {
                        name = mas[j + 1];
                    } else {
                        name = mas[j + 1].substring(0, pos);
                    }
                    l2 = new Double(name);//??????????? ? ?????
                    l = l1 + l2;
                    l3 = Double.toString(l);//?????????????? ????? ? ??????
                    mas[j - 1] = l3;
                    for (int h = j; h <= length; h++) {
                        mas[h] = mas[h + 2];
                    }
                    length = length - 2;

                    kAdd--;
                    if (kAdd > 0) {
                        while ((mas[j] != "+") && (j <= length)) {//ищем для *
                            j++;
                        }
                    }
                }
                j = 0;
                length = 1;
            }
            out.println(mas[0]);
            out.println();
        } while (!s.equals(close));
    }
}


