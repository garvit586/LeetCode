class Solution {
    public int[][] merge(int[][] a) {
        ArrayList<int[]> result=new ArrayList<int[]>();
        int  i;
        Arrays.sort(a, (a1,b1) -> Integer.compare(a1[0],b1[0]));
         
        for(i=0;i+1<a.length;i++){
            if(a[i][1]>=a[i+1][0]){
                a[i+1][0]=a[i][0];
                a[i+1][1]=a[i+1][1]>a[i][1]?a[i+1][1]:a[i][1];
            }
            else{
			result.add(a[i]);
			}
        }
		

        result.add(a[i]);

		
        return result.toArray(new int [result.size()][]);
    }
}