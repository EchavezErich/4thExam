
package echavez_4thexam;


public class BeeFriends {
    private String [] users;
    private String [][] friends;
    private int userCount;
    private int maxUsers;
    
    public BeeFriends(int maxUsers){
        
        this.maxUsers = maxUsers;
        this.users = new String[maxUsers];
        this.friends = new String [maxUsers][maxUsers];
        this.userCount = 0;
    }
    
    public void addUser(String user) {
        if (userCount < maxUsers) {
            users[userCount++] = user;
            System.out.println(user + " has been added.");
        } else {
            System.out.println("Cannot add more users. Limit reached!");
        }
    }
    
    public void addingFriend(String user1, String user2){
        int index1 = getUserIndex(user1);
        int index2 = getUserIndex(user2);
        
        if(index1 != -1 && index2 != -1){
            addFriend(index1, user2);
            addFriend(index2, user1);
            System.out.println("Social Relationship added between" + user1 + "and" + user2);
            
        }else{
            System.out.println("One or both users not found");
        }
    }
    public String[] getFriendRecommendations(String user){
        int userIndex = getUserIndex(user);
        if (userIndex == -1){
            System.out.println("User not found");
            return new String[0];
        }
        
        String[] directFriends = friends[userIndex];
        boolean[] isDirectFriend = new boolean [maxUsers];
        for(String friend : directFriends){
            if(friend != null){
                int friendIndex = getUserIndex(friend);
                isDirectFriend[friendIndex] = true;
                
            }
        }
        int[] mutualFriendCounts = new int[maxUsers];
        for(String friend : directFriends){
            if(friend != null){
                int friendIndex = getUserIndex(friend);
                for(String potentialFriend : friends[friendIndex]){
                    if(potentialFriend != null){
                     int potentialFriendIndex = getUserIndex(potentialFriend);
                     if(!potentialFriend.equals(user)&& !isDirectFriend[potentialFriendIndex]){
                         mutualFriendCounts[potentialFriendIndex]++;
                       }
                    }
                  }
                }
        }
        String[] recommendations = new String[maxUsers];
        int recommendationCount = 0;
        
        for(int i =0; i< maxUsers; i++){
            if(mutualFriendCounts[i]> 0){
                recommendations[recommendationCount++] = users[i];
            }
        }
         String[] finalRecommendations = new String[recommendationCount];
        System.arraycopy(recommendations, 0, finalRecommendations, 0, recommendationCount);
        return finalRecommendations;
    }
        private void addFriend(int userIndex, String friend){
            for(int i = 0; i < userCount; i++){
                if(friends[userIndex][i]== null){
                    friends [userIndex][i]= friend;
                    break;
                }
            }
        }
        private int getUserIndex(String user){
            for (int i = 0; i < userCount; i++) {
                if(users[i].equals(user)){
                    return i;
                }
               
            }
            return 1;
        }
}
