import java.util.Objects;
import java.util.Scanner;
import java.lang.Math;

import static java.lang.Math.pow;
import static java.lang.System.*;


public class Calculator {

    public static void main(String[] args) {
        int i;
        int p = 0;
        int p1;
        int m;
        String op;
        String s;
        String s1;
        String close = "Close";
        char add = '+';
        char min = '-';
        char mul = '*';
        char del = '/';
        char step = '^';
        char parl = '(';
        char parr = ')';
        int kAdd = 0;
        int kMin = 0;
        int kDel = 0;
        int kMul = 0;
        int kStep = 0;
        int kParl = 0;
        int kParr = 0;

        Scanner in = new Scanner(System.in);
        do {

            int a = 0;
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
            int length = s.length();
            s1 = new String(s.substring(0, length - 1));
            int k = 0;
            if (s1.equals(close)) {
                exit(0);//принудительная остановка
            }
            // возвращает истинну если с потока ввода можно считать целое число
            if ((length > 2)) {
                for (int j = 0; j < length; j++) {
                    //p1=j;
                    if (k >= length) {
                        break;
                    }
                    while ((s.charAt(k) != '+') && (s.charAt(k) != '-') && (s.charAt(k) != '*') &&
                            (s.charAt(k) != '/') && (s.charAt(k) != '^') && (s.charAt(k) != '#') &&
                            (s.charAt(k) != '(') && (s.charAt(k) != ')')) {//) {
                        //out.println(s.charAt(k));
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
                    int g = op.length();
                    int pos = op.indexOf("+");
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
                //exit(0);//принудительная остановка
            }
            int q = 0;
            int d = 0;
            while (q <= length) {
                if (mas[q].equals("")) {
                    d = q;
                    while (d <= length+1) {
                        mas[d] = mas[d + 1];
                        d++;
                    }
                    mas[d-1]=null;
                    d = 0;
                    length--;
                }
                q++;
            }
            if(mas[length+1]!=null){
                length++;
            }

            if (kParl != kParr) {
                out.println("Некорректный ввод выражения");
                length = 1;
            }
            //}
            while (length != 1) {
                int j = 0;

                for (int y = 0; y < length; y++) {
                    if (mas[y] == null) {
                        length--;
                    }
                }

                while ((kParl != 0) && (kParr != 0)){
                    a=0;
                    int a1=0;
                    while ((mas[j] != "(")&&(mas[j] != null)){//ищем для возведения в степень
                        j++;
                    }
                    j++;
                    int Parl1 = j;
                    masPar[a] = mas[j];
                    a++;
                    while (mas[j] != ")") {
                        j++;
                        masPar[a] = mas[j];
                        a++;//количество элементов
                        a1++;
                    }
                    masPar[a] = null;
                    for (int h = a; h < length+1; h++) {
                        mas[h] = mas[h + 1];
                        //h++;
                        a=h;
                    }
                    mas[a]=null;
                    int g = 0;
                    while (masPar[g]!=null){
                        g++;
                    }
                    //g = g+1;//количество элементов массива
                    Parentheses.brackets(masPar, j - Parl1);
                    mas[Parl1-1] = masPar[0];

                    for (int h = Parl1; (h < length) && (g < 20); h++) {
                        mas[h] = mas[g];
                        g++;
                        //h++;
                    }
                    length = length - (a1-1);
                    kParl--;
                    kParr--;
                    j = 0;
                }

                j = 0;
                while ((mas[j] != "^") && (j < length)) {//ищем для возведения в степень
                    j++;
                }
                while (mas[j] == "^") {
                    String name;
                    int pos = mas[j - 1].indexOf(".0");
                    //вычленяем имя атрибута из подстроки
                    if (pos == -1) {
                        name = mas[j - 1];
                    } else {
                        name = mas[j - 1].substring(0, pos);
                    }
                    double l1 = new Double(name);//преобразуем в число
                    pos = mas[j + 1].indexOf(".0");
                    //вычленяем имя атрибута из подстроки
                    if (pos == -1) {
                        name = mas[j + 1];
                    } else {
                        name = mas[j + 1].substring(0, pos);
                    }
                    double l2 = new Double(name);//преобразуем в число
                    double l = pow(l1, l2);
                    String l3 = Double.toString(l);//преобразование числа в строку
                    mas[j - 1] = l3;
                    for (int h = j; h < length; h++) {
                        mas[h] = mas[h + 2];
                        //h++;
                    }
                    length = length - 2;
                    for (i = 0; i < length; i++) {
                        out.print(mas[i]);
                        out.print(", ");
                    }
                    kStep--;
                    if (kStep > 0) {
                        while ((mas[j] != "^") && (j < length)) {//ищем для *
                            j++;
                        }
                    }
                    out.println();
                }
                out.println();
                j = 0;


                while ((mas[j] != "/") && (j < length)) {
                    j++;
                }
                while (mas[j] == "/") {
                    String name;
                    int pos = mas[j - 1].indexOf(".0");
                    if (pos == -1) {
                        name = mas[j - 1];
                    } else {
                        name = mas[j - 1].substring(0, pos);
                    }
                    double l1 = new Double(name);//??????????? ? ?????
                    pos = mas[j + 1].indexOf(".0");
                    //????????? ??? ???????? ?? ?????????
                    if (pos == -1) {
                        name = mas[j + 1];
                    } else {
                        name = mas[j + 1].substring(0, pos);
                    }
                    double l2 = new Double(name);//??????????? ? ?????
                    double l = l1 / l2;
                    String l3 = Double.toString(l);//?????????????? ????? ? ??????
                    mas[j - 1] = l3;
                    for (int h = j; h < length; h++) {
                        mas[h] = mas[h + 2];
                    }
                    length = length - 2;
                    for (i = 0; i < length; i++) {
                        out.print(mas[i]);
                        out.print(", ");
                    }
                    kDel--;
                    if (kDel > 0) {
                        while ((mas[j] != "/") && (j < length)) {//ищем для *
                            j++;
                        }
                    }
                    out.println();
                }
                out.println();
                j = 0;

                while ((mas[j] != "*") && (j < length)) {//ищем для *
                    j++;
                }
                while (mas[j] == "*") {
                    String name;
                    int pos = mas[j - 1].indexOf(".0");
                    //вычленяем имя атрибута из подстроки
                    if (pos == -1) {
                        name = mas[j - 1];
                    } else {
                        name = mas[j - 1].substring(0, pos);
                    }
                    double l1 = new Double(name);//преобразуем в число
                    pos = mas[j + 1].indexOf(".0");
                    //вычленяем имя атрибута из подстроки
                    if (pos == -1) {
                        name = mas[j + 1];
                    } else {
                        name = mas[j + 1].substring(0, pos);
                    }
                    double l2 = new Double(name);//преобразуем в число
                    double l = l1 * l2;
                    String l3 = Double.toString(l);//преобразование числа в строку
                    mas[j - 1] = l3;
                    for (int h = j; h < length; h++) {
                        mas[h] = mas[h + 2];
                        //h++;
                    }
                    length = length - 2;
                    for (i = 0; i < length; i++) {
                        out.print(mas[i]);
                        out.print(", ");
                    }
                    kMul--;
                    if (kMul > 0) {
                        while ((mas[j] != "*") && (j < length)) {//ищем для *
                            j++;
                        }
                    }
                    out.println();
                }
                out.println();
                j = 0;

                while ((mas[j] != "-") && (j < length)) {//???? ??? ?????????? ? ???????
                    j++;
                }
                while (mas[j] == "-") {
                    String name;
                    int pos = mas[j - 1].indexOf(".0");
                    //????????? ??? ???????? ?? ?????????
                    if (pos == -1) {
                        name = mas[j - 1];
                    } else {
                        name = mas[j - 1].substring(0, pos);
                    }
                    double l1 = new Double(name);//??????????? ? ?????
                    pos = mas[j + 1].indexOf(".0");
                    //????????? ??? ???????? ?? ?????????
                    if (pos == -1) {
                        name = mas[j + 1];
                    } else {
                        name = mas[j + 1].substring(0, pos);
                    }
                    double l2 = new Double(name);//??????????? ? ?????
                    double l = l1 - l2;
                    String l3 = Double.toString(l);//?????????????? ????? ? ??????
                    mas[j - 1] = l3;
                    for (int h = j; h < length; h++) {
                        mas[h] = mas[h + 2];
                        //h++;
                    }
                    length = length - 2;
                    for (i = 0; i < length; i++) {
                        out.print(mas[i]);
                        out.print(", ");
                    }
                    kMin--;
                    if (kMin > 0) {
                        while ((mas[j] != "-") && (j < length)) {//ищем для *
                            j++;
                        }
                    }
                    out.println();
                }
                j=0;

                while ((mas[j] != "+") && (j < length)) {//???? ??? ?????????? ? ???????
                    j++;
                }
                while (mas[j] == "+") {
                    String name;
                    int pos = mas[j - 1].indexOf(".0");
                    //????????? ??? ???????? ?? ?????????
                    if (pos == -1) {
                        name = mas[j - 1];
                    } else {
                        name = mas[j - 1].substring(0, pos);
                    }
                    double l1 = new Double(name);//??????????? ? ?????
                    pos = mas[j + 1].indexOf(".0");
                    //????????? ??? ???????? ?? ?????????
                    if (pos == -1) {
                        name = mas[j + 1];
                    } else {
                        name = mas[j + 1].substring(0, pos);
                    }
                    double l2 = new Double(name);//??????????? ? ?????
                    double l = l1 + l2;
                    String l3 = Double.toString(l);//?????????????? ????? ? ??????
                    mas[j - 1] = l3;
                    for (int h = j; h < length; h++) {
                        mas[h] = mas[h + 2];
                        //h++;
                    }
                    length = length - 2;
                    for (i = 0; i < length; i++) {
                        out.print(mas[i]);
                        out.print(", ");
                    }
                    kAdd--;
                    if (kAdd > 0) {
                        while ((mas[j] != "+") && (j < length)) {//ищем для *
                            j++;
                        }
                    }
                    out.println();
                }
                out.println();
                j = 0;
                length = 1;
            }
        } while (!s.equals(close));
    }
}

