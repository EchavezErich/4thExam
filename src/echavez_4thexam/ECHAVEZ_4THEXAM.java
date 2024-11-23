
package echavez_4thexam;
import java.util.Scanner;

public class ECHAVEZ_4THEXAM {

   
    public static void main(String[] args) {
       Scanner scn = new Scanner(System.in);
       BeeFriends bee = new BeeFriends(20);
       
       while(true){
           System.out.println("\nMenu");
           System.out.println("1. Add User");
           System.out.println("2. Add Friend");
           System.out.println("3. Get Friend Recommendation");
           System.out.println("4. Exit");
           System.out.println("5. Choose an Option");
           int choice = scn.nextInt();
           scn.nextLine();
           
           
           switch(choice){
               case 1:
                   System.out.println("Enter User Name: ");
                   String user = scn.nextLine();
                   bee.addUser(user);
                   break;
                   
               case 2:
                   System.out.println("Enter first user name: ");
                    String user1 = scn.nextLine();
                   System.out.println("");
                    String user2 = scn.nextLine();
                    bee.addingFriend(user1, user2);
                    break;
                    
                    
               case 3:
                   System.out.println("Enter User Name For Recommendation: ");
                   String userForRecommendation = scn.nextLine();
                   String [] recommendations = bee.getFriendRecommendations(userForRecommendation);
                   if(recommendations.length == 0){
                       System.out.println("No Recommendations Available");
                   }else{
                       System.out.println("Friend Recommendation: ");
                       for(String recommendation: recommendations){
                           System.out.println(recommendation);
                       }
                   }
                 break; 
                 
               case 4:
                   System.out.println("Exiting Program");
                   scn.close();
                   return;
                   
               default:
                   System.out.println("Invalid Choice. Please Try Again ");
           }
       }
       
    }
    
}
