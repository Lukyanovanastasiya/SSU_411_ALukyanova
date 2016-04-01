import java.util.Objects;
import java.util.Scanner;
import java.lang.Math;

import static java.lang.Math.pow;
import static java.lang.System.*;

public class Parentheses {

    public static void brackets(String mas[], int length) {
        while (length != 1) {
            int j = 0;
            int i = 0;
            double l2;
            double l;
            double l1;
            String name;
            String l3;
            int pos;

            while ((mas[j] != "^") && (j < length)) {//ищем для возведения в степень
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
                for (int h = j; h < length; h++) {
                    mas[h] = mas[h + 2];
                }
                length = length - 2;
                for (i = 0; i < length; i++) {
                    out.print(mas[i]);
                    out.print(", ");
                }
                while ((mas[j] != "^") && (j < length)) {//ищем для *
                    j++;
                }
                out.println();
            }
            out.println();
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
                l2 = new Double(name);
                l = l1 / l2;
                l3 = Double.toString(l);
                mas[j - 1] = l3;
                for (int h = j; h < length; h++) {
                    mas[h] = mas[h + 2];
                }
                length = length - 2;
                for (i = 0; i < length; i++) {
                    out.print(mas[i]);
                    out.print(", ");
                }
                while ((mas[j] != "/") && (j < length)) {//ищем для *
                    j++;
                }
                out.println();
            }
            out.println();
            j = 0;

            while ((mas[j] != "*") && (j < length)) {//ищем для *
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
                for (int h = j; h < length; h++) {
                    mas[h] = mas[h + 2];
                }
                length = length - 2;
                for (i = 0; i < length; i++) {
                    out.print(mas[i]);
                    out.print(", ");
                }
                while ((mas[j] != "*") && (j < length)) {//ищем для *
                    j++;
                }
                out.println();
            }
            out.println();
            j = 0;

            while ((mas[j] != "-") && (j < length)) {
                j++;
            }
            while (mas[j] == "-") {
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
                l2 = new Double(name);
                l = l1 - l2;
                l3 = Double.toString(l);
                mas[j - 1] = l3;
                for (int h = j; h < length; h++) {
                    mas[h] = mas[h + 2];
                }
                length = length - 2;
                for (i = 0; i < length; i++) {
                    out.print(mas[i]);
                    out.print(", ");
                }
                while ((mas[j] != "-") && (j < length)) {//ищем для *
                    j++;
                }
                out.println();
            }
            j = 0;

            while ((mas[j] != "+") && (j < length)) {
                j++;
            }
            while (mas[j] == "+") {
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
                l2 = new Double(name);
                l = l1 + l2;
                l3 = Double.toString(l);
                mas[j - 1] = l3;
                for (int h = j; h < length; h++) {
                    mas[h] = mas[h + 2];
                }
                length = length - 2;
                for (i = 0; i < length; i++) {
                    out.print(mas[i]);
                    out.print(", ");
                }
                while ((mas[j] != "+") && (j < length)) {//ищем для *
                    j++;
                }
                out.println();
            }
            out.println();
            j = 0;
            length = 1;
        }
    }
}
