class Solution {
    public List partitionLabels(String s) {
        List l=new ArrayList();
        if(s.length()==0) return l;
        int last[]=new int[26];// to store last occurence of every character
        for(int i=0;i<s.length();i++)
        {
            last[s.charAt(i)-'a']=i;
        }
        int end=0,start=0;// to store end and start of each partition
        for(int i=0;i<s.length();i++)
        {
            end=Math.max(end,last[s.charAt(i)-'a']);
            if(end==i)
            {
                l.add(end-start+1);
                start=end+1;
            }
        }
        return l;
    }
}