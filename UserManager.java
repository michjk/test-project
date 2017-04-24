import java.util.HashSet;
import org.json.*;
import java.util.*;

class UserManager
{
    public static String userUrl = "http://fg-69c8cbcd.herokuapp.com/user/";

    public UserManager() {
        
    }

    public ArrayList<String> getFriendsOfUser(String userId) {
        ArrayList<String> arrayList = new ArrayList<>();
        HashMap<String, String> hashMap = new HashMap<>();
        getFriendsOfUser(userId, hashMap);
        
        for(String name: hashMap.values()) {
            arrayList.add(name);
        }

        return arrayList;
    }

    private void getFriendsOfUser(String userId, HashMap<String, String> hashMap) {
        JSONObject jsonObjectRes = RestAPICaller.httpGetJSON(urlBuilderForFetchingUserData(userId));
        
        String name = "";
        JSONArray jsonArray = new JSONArray();
        try {
            name = jsonObjectRes.getString("name");
            jsonArray = jsonObjectRes.getJSONArray("friends");
        }
        catch(JSONException e) {
            System.out.println("Error: " + e.getMessage());
        }

        hashMap.put(userId, name);

        if(jsonArray!=null && jsonArray.length()>0){
            for (int i = 0; i < jsonArray.length(); i++) {
                try {
                    String friendId = jsonArray.getString(i);

                    if(!hashMap.containsKey(friendId)) {
                        getFriendsOfUser(friendId, hashMap);
                    }
                }
                catch(JSONException e) {
                    System.out.println("Error: " + e.getMessage());
                }
                
            }
        }
    }

    private String urlBuilderForFetchingUserData(String userId) {
        return userUrl + userId;
    }
}