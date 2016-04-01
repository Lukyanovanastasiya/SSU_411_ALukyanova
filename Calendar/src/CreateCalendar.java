import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

import static java.lang.System.out;

import java.lang.String;

public class CreateCalendar {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int year1;
        int year2;
        int year3;
        int days;
        int h;
        int year;//сколько лет
        int day;//сколько дней в этом промежутке
        int kol;
        int mount;
        String mounts;
        out.println("Год для первого задания: ");
        try {
            year3 = Integer.parseInt(in.next());
        } catch (NumberFormatException ex) {
            year3 = 0;
            System.out.println("Введено не число");
            System.exit(0);
        }
        String monthString = null;
        days = 1;//с какого дня начинаем считать
        out.println("Месяца с пятницей тринадцатого");
        Calendar c3 = new GregorianCalendar(year3, Calendar.JANUARY, 1);//календарь год, месяц, день

        while (c3.get(Calendar.YEAR) == year3) {
            c3.add(Calendar.DAY_OF_YEAR, 1); //увеличиваем дату на 1 день
            if ((c3.get(Calendar.DATE) == 13) && (c3.get(Calendar.DAY_OF_WEEK) == Calendar.FRIDAY)) {
                //перечислить все месяца с пятницей 13
                out.print("Месяц ");
                h = c3.get(Calendar.MONTH);
                switch (h) {
                    case 0:
                        monthString = "Январь";
                        break;
                    case 1:
                        monthString = "Февраль";
                        break;
                    case 2:
                        monthString = "Март";
                        break;
                    case 3:
                        monthString = "Апрель";
                        break;
                    case 4:
                        monthString = "Май";
                        break;
                    case 5:
                        monthString = "Июнь";
                        break;
                    case 6:
                        monthString = "Июль";
                        break;
                    case 7:
                        monthString = "Август";
                        break;
                    case 8:
                        monthString = "Сентябрь";
                        break;
                    case 9:
                        monthString = "Октябрь";
                        break;
                    case 10:
                        monthString = "Ноябрь";
                        break;
                    case 11:
                        monthString = "Декабрь";
                        break;
                }
                out.print(monthString);
                out.println();
            }
        }
        out.println();

        out.println("Для второго задания");
        out.println("Первый год диапазона (число): ");
        try {
            year1 = Integer.parseInt(in.next());
        } catch (NumberFormatException ex) {
            year1 = 0;
            System.out.println("Введено не число");
            System.exit(0);
        }
        out.println("Второй год диапазона (число): ");
        try {
            year2 = Integer.parseInt(in.next());
        } catch (NumberFormatException ex) {
            year2 = 0;
            System.out.println("Введено не число");
            System.exit(0);
        }
        year = year2 - year1 + 1;//сколько лет
        day = year * 365;//сколько дней в этом промежутке
        kol = 0;
        out.println("Месяц (вводится название месяца на русском языке): ");
        mounts = in.next();//считываем строку
        mount = 0;
        switch (mounts) {
            case "Январь":
                mount = 0;
                break;
            case "Февраль":
                mount = 1;
                break;
            case "Март":
                mount = 2;
                break;
            case "Апрель":
                mount = 3;
                break;
            case "Май":
                mount = 4;
                break;
            case "Июнь":
                mount = 5;
                break;
            case "Июль":
                mount = 6;
                break;
            case "Август":
                mount = 7;
                break;
            case "Сентябрь":
                mount = 8;
                break;
            case "Октябрь":
                mount = 9;
                break;
            case "Ноябрь":
                mount = 10;
                break;
            case "Декабрь":
                mount = 11;
                break;
        }
        days = 1;
        Calendar c1 = new GregorianCalendar(year1, mount, days);//календарь на 25.11.2013 год, месяц, день
        Calendar c2 = new GregorianCalendar(year1, mount, days);//календарь на 25.11.2013 год, месяц, день
        out.println("Все года, в которых есть пятница 13, из указанного диапазона: ");
        for (int i = 0; i < day; i++) {
            days++;
            c2.add(Calendar.DAY_OF_YEAR, 1); //увеличиваем дату на 1 день
            if ((c2.get(Calendar.DATE) == 13) && (c2.get(Calendar.DAY_OF_WEEK) == Calendar.FRIDAY) && (c2.get(Calendar.MONTH) == c1.get(Calendar.MONTH))) {
                out.print("Год: ");
                out.println(c2.get(Calendar.YEAR));
            }
        }
    }
}