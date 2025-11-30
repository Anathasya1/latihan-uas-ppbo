package utils;

import java.util.Scanner;

public class CLIUtil {
    private static Scanner scanner;

  static {
    scanner = new Scanner(System.in);
  }

  public static int getInt() {
    return scanner.nextInt();
  }

  public static double getDouble() {
    return scanner.nextDouble();
  }

  public static String getString(){
    return scanner.nextLine();
  }
}
