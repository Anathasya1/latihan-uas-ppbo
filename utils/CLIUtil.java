package utils;

import java.util.Scanner;

public class CLIUtil {
    private static Scanner scanner;

  static {
    scanner = new Scanner(System.in);
  }

  public static int getInt() {
    int getValue = scanner.nextInt();
    scanner.nextLine();
    return getValue;
  }

  public static double getDouble() {
    return scanner.nextDouble();
  }

  public static String getString(){
    return scanner.nextLine();
  }
}
