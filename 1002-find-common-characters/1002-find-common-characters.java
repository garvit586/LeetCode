class Solution {
public List commonChars(String[] words) {
List ans = new ArrayList<>();

 String temp= words[0];
    for(int i=0;i<temp.length();i++){
        int flag=0;
        for(int j=1;j<words.length;j++){
            
            if(!words[j].contains(String.valueOf(temp.charAt(i)))){
                flag=1;
                break;
            }else{
                words[j]=words[j].replaceFirst(String.valueOf(temp.charAt(i)), "*");
            }
        }
        if(flag==0){
            ans.add(String.valueOf(temp.charAt(i)));
        }
        
    }
    return ans;
    
}
}