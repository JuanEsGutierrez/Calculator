import java.util.Scanner;
public class Calculator{
	public static void main(String args[]){
		Scanner input = new Scanner(System.in);
		Scanner input2 = new Scanner(System.in);
		System.out.println("Choose between: \n1. Just an operation at a time \n2. Stacked operations");
		int option1 = input.nextInt();
		double num1;
		double num2;
    int option2;
    double memory[] = new double[10];
		switch(option1){
			case 1: do{
          String line1 = input2.nextLine();
					String operator = input2.nextLine();
					String line2 = input2.nextLine();
          num1 = Double.parseDouble(line1);
          if(line2.length() == 0)
            num2 = 0;
          else
            num2 = Double.parseDouble(line2);
					String result = operation(num1, num2, operator);
					System.out.println("|| \n" + result);
          System.out.println("Do you want to continue with another operation? \n1. Yes \n2. No");
          option2 = input.nextInt();
          }
          while(option2 == 1);
					break;
			case 2:	String line1 = input2.nextLine();
              String operator;
              do{
					      operator = input2.nextLine();
					      String line2 = input2.nextLine();
                num1 = Double.parseDouble(line1);
                if(line2.length() == 0)
                  num2 = 0;
                else
                  num2 = Double.parseDouble(line2);
					      String result = operation(num1, num2, operator);
					      System.out.println("|| \n" + result);
                line1 = result;
              }
              while(!operator.equals("#"));
              break;
			default:	System.out.println("Write a valid option");
		}
	}
	public static String operation(double num1, double num2, String operator){
    String result = "Aivonne";
    if(operator.equals("+"))
			result = Double.toString(num1 + num2);
		else if(operator.equals("-"))
			result = Double.toString(num1 - num2);
		else if(operator.equals("*"))
			result = Double.toString(num1 * num2);
    else if(operator.equals("/"))
			result = Double.toString(num1 / num2);
    else if(operator.equals("%") || operator.equals("mod"))
			result = Double.toString(num1 % num2);
    else if(operator.equals("root") && num1 == 2)
      result = Double.toString(squareRoot(num2));
    else if(operator.equals("power") || operator.equals("raised"))
      result = Double.toString(power(num1, num2));
    else if(operator.equals("!"))
      result = Integer.toString(factorial((int)num1));
    else if(operator.equals("sci"))
      result = scientific_Notation(num1);
    else if(operator.equals("rad"))
      result = Double.toString(toRads(num1));
    else if(operator.equals("deg"))
      result = Double.toString(toDegs(num1));
    else if(operator.equals("sin"))
      result = Double.toString(sine(num1));
    else if(operator.equals("cos"))
      result = Double.toString(cosine(num1));
    else if(operator.equals("tan"))
      result = Double.toString(tangent(num1));
    else if(operator.equals("log") && num1 == 10)
      result = Double.toString(base10_Log(num2));
    else if(operator.equals("log") && num1 != 10)
      result = Double.toString(basen_Log(num1, num2));
    else if(operator.equals("root") && num1 != 2)
      result = Double.toString(nthRoot(num1, num2));
		return result;
	}
  public static double squareRoot(double num2){
    double estimate;
    double sqrt = num2 / 2;
    do{
      estimate = sqrt;
      sqrt = (estimate + (num2 / estimate)) / 2;
    }
    while(estimate - sqrt != 0);
    return sqrt;
  }
  public static double power(double num1, double num2){
    double pow = 1;
    if(num2 == 0)
      pow = 1;
    else if(num2 < 0){
      num1 = 1 / num1;
      num2 = -num2;
      for(int i = 0; i < (int)num2; i++)
        pow *= num1;
    }
    else{
      for(int i = 0; i < (int)num2; i++)
        pow *= num1;
    }
    return pow;
  }
  public static int factorial(int num1){
    int fact = 1;
    for(int i = num1; i > 0; i--)
      fact *= i; 
    return fact;
  }
  public static String scientific_Notation(double num1){
    String sc = String.format("%6.6E", num1);
    return sc;
  }
  public static double toRads(double num1){
    double rads = Math.toRadians(num1);
    return rads;
  }
  public static double toDegs(double num1){
    double degs = Math.toDegrees(num1);
    return degs;
  }
  public static double sine(double num1){
    double sin = Math.sin(Math.toRadians(num1));
    return sin;
  }
  public static double cosine(double num1){
    double cos = Math.cos(Math.toRadians(num1));
    return cos;
  }
  public static double tangent(double num1){
    double tan = Math.tan(Math.toRadians(num1));
    return tan;
  }
  public static double base10_Log(double num2){
    double log10 = Math.log10(num2);
    return log10;
  }
  public static double basen_Log(double num1, double num2){
    double logn = Math.log(num2) / Math.log(num1);
    return logn;
  }
  public static double nthRoot(double num1, double num2){
    double estimate = num2 / num1;
    double difference = 2;
    double nrt = 0;
    while(difference > 0.001){
      nrt = ((num1 - 1.0) * estimate + num2 / Math.pow(estimate, num1 - 1)) / num1;
      difference = Math.abs(nrt - estimate);
      estimate = nrt;
    }
    return nrt;
  }
}