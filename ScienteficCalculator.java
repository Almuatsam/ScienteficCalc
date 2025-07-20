import java.util.Scanner;

public class ScienteficCalculator {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            menu();
            System.out.print("Choice: ");
            int c = sc.hasNextInt() ? sc.nextInt() : -1;
            sc.nextLine();

            if (c == 0) break;

            try {
                switch (c) {
                    case 1, 2, 3, 4, 16, 17 -> {
                        double a = read(sc, "Enter first number: ");
                        double b = read(sc, "Enter second number: ");
                        double res = switch (c) {
                            case 1 -> a + b;
                            case 2 -> a - b;
                            case 3 -> a * b;
                            case 4 -> (b == 0) ? throwErr("Divide by zero") : a / b;
                            case 16 -> Math.min(a, b);
                            case 17 -> Math.max(a, b);
                            default -> 0;
                        };
                        print(res);
                    }
                    case 5 -> print(Math.sqrt(pos(read(sc, "Number: "))));
                    case 6 -> print(Math.pow(read(sc, "Base: "), read(sc, "Exponent: ")));
                    case 7 -> print(Math.sin(Math.toRadians(read(sc, "Degrees: "))));
                    case 8 -> print(Math.cos(Math.toRadians(read(sc, "Degrees: "))));
                    case 9 -> {
                        double deg = read(sc, "Degrees: ");
                        print((deg % 180 == 90) ? throwErr("Undefined tangent") : Math.tan(Math.toRadians(deg)));
                    }
                    case 10 -> print(Math.log(pos(read(sc, "Number: "))));
                    case 11 -> print(Math.log10(pos(read(sc, "Number: "))));
                    case 12 -> print(Math.abs(read(sc, "Number: ")));
                    case 13 -> System.out.println("Result: " + Math.round(read(sc, "Number: ")));
                    case 14 -> print(Math.ceil(read(sc, "Number: ")));
                    case 15 -> print(Math.floor(read(sc, "Number: ")));
                    default -> System.out.println("Invalid");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        sc.close();
    }

    static void menu() {
        System.out.println("""
                \nScientific Calculator
                1:Add 2:Subtract 3:Multiply 4:Divide
                5:√ 6:Power 7:Sin 8:Cos 9:Tan
                10:ln 11:log10 12:abs 13:round
                14:ceil 15:floor 16:min 17:max
                0:Exit""");
    }

    static double read(Scanner sc, String msg) {
        System.out.print(msg);
        while (!sc.hasNextDouble()) {
            System.out.print("Invalid. Try again: ");
            sc.nextLine();
        }
        return sc.nextDouble();
    }

    static double pos(double A) {
        if (A <= 0) throw new IllegalArgumentException("Must be positive");
        return A;
    }

    static double throwErr(String msg) {
        throw new IllegalArgumentException(msg);
    }

    static void print(double A) {
        System.out.println("Result: " + A);
    }
}
