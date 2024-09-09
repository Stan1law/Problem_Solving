public class week5 {
    public static void main(String[] args) {
        double r = 1.1, area, area2;
        area = getArea(r);
        System.out.println("area 1 is " + area);
        area2 = getArea(2.2);
        System.out.println("area 2 is " + area2);
        System.out.println("area 3 is " + getArea(3.3));
    }

    public static double getArea(double radius) {
        return radius * radius * Math.PI;
    }

    public static int max(int number1, int number2) {
        if (number1 > number2) {
            return number1;
        } else {
            return number2;
        }
    }
}
