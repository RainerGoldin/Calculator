import java.util.Scanner;

public class SafePassword {
    static final Scanner input = new Scanner(System.in);
  static int tries = 1;

  static void weak(String reason){
    System.out.print("Password is too weak\nReason: "+reason+"\nPress enter to continue...");
    input.nextLine();
    tries++;
  }

  static boolean containsSymbol(String password){
    String symbols = "`~!@#$%^&*()_-+={}[]|:;'<,>.?/";

    for(char i: password.toCharArray()){
      if(symbols.contains(String.valueOf(i))){
        return true;
      }
    }

    return false;
  }

  static boolean containsNumber(String password){
    String symbols = "1234567890";

    for(char i: password.toCharArray()){
      if(symbols.contains(String.valueOf(i))){
        return true;
      }
    }

    return false;
  }

  public static void main(String[] args){
    final String cls = "\033[H\033[2J";

    System.out.println(cls);
    System.out.print("Hello there, welcome to the Safe Password.\nThis program will help you make your safe password.\nPress enter to start...");
    input.nextLine();

    while(true){
      System.out.println(cls);
      System.out.print("Enter your password: ");
      String password = input.nextLine();

      if(password.equals("")){
        weak("password can't be empty.");
      } else if(password.length() < 6){
        weak("password must be at least 6 characters.");
      } else if(!containsNumber(password)){
        weak("password must contain at least 1 numeric.");
      } else if(password.toLowerCase().equals(password)){
        weak("password must contain at least 1 capital case.");
      } else if(password.toUpperCase().equals(password)){
        weak("password can't be all upper case.");
      } else if(!containsSymbol(password)){
        weak("password must contain at least 1 symbol.");
      } else{
        System.out.println("Congratulations, you've created your own safe password.\nThe password is: "+password+"\nIt took you "+tries+" tries to make this password.");
        break;
      }
    }  
  }
}
