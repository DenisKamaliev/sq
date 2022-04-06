import java.util.Scanner;
import java.util.*;
import java.io.*;

public class SquareEquation {
    public static void solution(double a, double b, double c){
        System.out.println("Ваше уравнение: y = " + a + "x^2 + " + b + "x + " + c);
        Double d = b*b - 4 * a * c;
        if(a!=0) {

            if (d < 0) {
                System.out.println("Дискриминант меньше нуля, вещественных корней не существует!");
            }
            if (d == 0) {

                double x1 = (-b + Math.sqrt(d)) / (2 * a);
                System.out.println("Уравнение имеет один корень: " + x1);
            }
            if (d > 0) {
                System.out.println("Уравнение имеет два корня: ");
                double x1 = (-b + Math.sqrt(d)) / (2 * a);
                double x2 = (-b - Math.sqrt(d)) / (2 * a);
                System.out.println("x1 = " + x1 + ", x2 = " + x2);

            }
        }
        else if (a==0&&b!=0){
            double x1 = c/b;
            System.out.println("Уравнение имеет один корень: " + x1);
        }
        else if(a==0&&b==0){
            System.out.println("Решений нет");
        }

    }
    public static void solutionByFile (String path) throws FileNotFoundException {
        File file = new File(path);
        Scanner scan = null;
        try {
            scan = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            System.exit(0);
        }
        while (scan.hasNextDouble()){
            double a = scan.nextDouble();
            double b = scan.nextDouble();
            double c = scan.nextDouble();
            SquareEquation.solution(a,b,c);
        }
    }



    public static void main(String[] args) throws FileNotFoundException {
        int key;
        Scanner in = new Scanner(System.in);
        do {
            System.out.println("1 - ввести коэфициенты вручную");
            System.out.println("2 - ввести коэфициенты из файла");
            System.out.println("3 - завершить работу программы");
            do {
                key = in.nextInt();
                if(key != 1 && key != 2 && key!=3)
                {
                System.out.println("Некорректное значение, повторите попытку ввода");
                }
            }while(key!= 1&& key!= 2 && key!=3);
            if(key == 1) {
                do {
                    System.out.println("Введите коэфициенты a,b,c в уравнение 'y = ax^2 + bx + c'");
                    Double a = in.nextDouble();
                    Double b = in.nextDouble();
                    Double c = in.nextDouble();
                    SquareEquation.solution(a,b,c);
                    System.out.println("Чтобы решить ещё одно уравнение введите '1', чтобы вернуться в меню введите '4'");
                    do {
                        key = in.nextInt();
                        if(key != 1 && key != 4)
                        {
                            System.out.println("Некорректное значение, повторите попытку ввода");
                        }
                    }while(key!= 1&& key!= 4);

                }while(key == 1);
            }
            if(key == 2 ){
                System.out.println("Введите полный путь до файла, учтите, что дробные числа нужно писать через запятую!");
                Scanner console = new Scanner(System.in);
                String path = console.nextLine();
                SquareEquation.solutionByFile(path);


            }

        }while(key != 3);
    }
}