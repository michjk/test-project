import java.util.*;
import java.lang.*;


class Main {
    public static void main(String[] args) {
        String userId = inputUserId();
        UserManager userManager = new UserManager();
        ArrayList<String> arrayList = userManager.getFriendsOfUser(userId);
        outputName(arrayList);
    }

    private static String inputUserId() {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Please input a user id: ");
        String userId = sc.nextLine();

        return userId;
    }

    private static void outputName(ArrayList<String> arrayList) {
        System.out.println("List of name: ");
        for(String s: arrayList)
            System.out.println(s);
    }
}