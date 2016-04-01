import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.*;
import java.util.*;
import java.util.Scanner;

import static java.lang.System.out;
import static java.nio.file.Files.exists;

public class Main {
    //Delimiter used in CSV file
    private static final String COMMA_DELIMITER = ";";
    private static List<String> company = new ArrayList<>();
    private static List<String> newresultcompany = new ArrayList<>();
    private static List<String> transfer = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        String s, transfer_company = null;
        String c;
        String c1;
        int sum;
        int j = 0;
        int y;
        String sub, sub1, Company_account;
        int kol, kol1;
        int pos, pos1, posre;
        int length;
        boolean tran = false;
        String csvFilename = "G:/Company/file/1.csv";
        //считывание с csv файла
        CSVReader csvReader = new CSVReader(new FileReader(csvFilename), ';');
        String[] row = null;
        List content = csvReader.readAll();

        for (Object object : content) {
            row = (String[]) object;
            if (j == 0) {
                s = row[0] + " # " + row[1] + " #  " + row[2];//три столбца
                System.out.println(s);
            } else {
                s = row[0] + " # " + row[1] + " ; " + row[2];
                System.out.println(s);
                company.add(s);//добавляем в список
            }
            j++;
        }

        csvReader.close();

        System.out.println("\nRead CSV file:");
        File directory = new File("G:/Company/file");
        for (File file : directory.listFiles()) {
            if (file.getName().matches("^Transaction+[1-100].+csv$")) {
                String dir = "G:/Company/file/" + file.getName();
                CSVReader csvReaders = new CSVReader(new FileReader(dir), ';');
                List contents = csvReaders.readAll();
                Scanner scanner = new Scanner(new FileInputStream(file));
                scanner.useDelimiter(";");
                j = 0;
                row = null;
                for (Object object : contents) {
                    row = (String[]) object;
                    if (j == 0) {
                        s = row[0] + " " + row[1] + "  " + row[2] + " " + row[3] + " " + row[4];//5 столбцов
                        System.out.println(s);
                    } else {
                        s = row[0] + " " + row[1] + " " + row[2] + " " + row[3] + " " + row[4];
                        System.out.println(s);
                        s = row[0] + " 1# " + row[1] + " 2# " + row[2] + " 3# " + row[3] + " 4# " + row[4];
                        transfer.add(s);//добавляем в список
                    }
                    j++;
                }
            }
        }

        List<String[]> data = new ArrayList<String[]>();
        System.out.println();
        System.out.println("Переходы по транзакциям");

        for (int i1 = 0; i1 < transfer.size(); i1++) {
            y = 0;
            length = transfer.get(i1).length();//длина строки
            pos = transfer.get(i1).indexOf(" 1# ");//находим разделитель
            c = transfer.get(i1).substring(0, pos);
            posre = transfer.get(i1).indexOf(" 2# ");//находим разделитель
            pos1 = transfer.get(i1).indexOf(" 3# ");//находим разделитель
            c1 = transfer.get(i1).substring(posre + 4, pos1);
            pos = transfer.get(i1).indexOf(" 4# ");//находим разделитель
            sum = new Integer(transfer.get(i1).substring(pos + 4, length));//считываем после разделителя подстроку
            for (int i = 0; i < company.size(); i++) {
                if (company.get(i).contains(c)) {//ищем фирму, которая переводит деньги
                    posre = company.get(i).indexOf(" # ");//находим разделитель
                    s = company.get(i).substring(0, posre);
                    if (s.equals(c)) {
                        length = company.get(i).length();//длина строки
                        pos = company.get(i).indexOf(" ; ");//находим разделитель
                        posre = company.get(i).indexOf(" # ");//находим разделитель
                        Company_account = company.get(i).substring(posre + 3, pos);
                        sub = company.get(i).substring(pos + 3, length);//считываем после разделителя подстроку
                        kol = new Integer(sub);//переводим строковое обозначение в числовое
                        transfer_company = c + " # " + Company_account + " # ";
                        if (kol >= sum) {//если перевод возможен
                            kol1 = kol - sum;
                            s = c + " # " + Company_account + " ; " + kol1;
                            company.set(i, s);//замена
                            System.out.println(s);
                            for (int k = 0; k < company.size(); k++) {
                                if (company.get(k).contains(c1)) {//находим фирму которой переводим деньги
                                    posre = company.get(k).indexOf(" # ");//находим разделитель
                                    s = company.get(k).substring(0, posre);
                                    if (s.equals(c1)) {
                                        length = company.get(k).length();//длина строки
                                        posre = company.get(k).indexOf(" # ");//находим разделитель
                                        pos = company.get(k).indexOf(" ; ");//находим разделитель
                                        sub1 = company.get(k).substring(pos + 3, length);//считываем после разделителя подстроку
                                        Company_account = company.get(k).substring(posre + 3, pos);
                                        kol = new Integer(sub1);//переводим строковое обозначение в числовое
                                        kol1 = kol + sum;//новый бюджет фирмы
                                        s = c1 + " # " + Company_account + " ; " + kol1;//заменяем сумму после получения перевода
                                        company.set(k, s);
                                        System.out.println(s);
                                    }
                                }
                            }
                        } else {
                            System.out.println("Бюджет компании меньше перевода.");
                            System.out.println("Не выполнен перевод " + c + " -> " + c1 + " " + sum);
                            tran = true;
                        }
                    }

                }
            }
        }
        System.out.println();
        System.out.println();
        for (int k = 0; k < company.size(); k++) {//выводим новые значения
            System.out.println(company.get(k));
        }

        if (tran == false) {
            System.out.println(transfer_company);
            transfer.add(transfer_company);
        }

        //запись в файл
        String csv = "G:/Company/file/result.csv";
        CSVWriter writer = new CSVWriter(new FileWriter(csv));
        writer.writeNext(new String[]{"Name", "Account", "Buget"});
        for (int k = 0; k < company.size(); k++) {
            length = company.get(k).length();//длина строки
            pos = company.get(k).indexOf(" ; ");//находим разделитель
            sub1 = company.get(k).substring(pos + 3, length);//считываем после разделителя подстроку
            posre = company.get(k).indexOf(" # ");//находим разделитель
            c1 = company.get(k).substring(0, posre);
            Company_account = company.get(k).substring(posre + 3, pos);
            writer.writeNext(new String[]{c1, Company_account, sub1});
        }
        writer.close();
    }
}
