// { Driver Code Starts
import java.util.*;
import java.io.*;
class Node
{
    int data; 
    Node left, right;
    Node(int key)
    {
        data = key;
        left = right = null;
    }
}

class GFG
{
    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            Node root = null;
            int inorder[] = new int[n];
            int preorder[] = new int[n];
            for(int i = 0; i < n; i++)
              inorder[i] = sc.nextInt();
              
            for(int i = 0; i < n; i++)
              preorder[i] = sc.nextInt();
              
            Solution ob = new Solution();
            root = ob.buildTree(inorder, preorder, n);
            postOrdrer(root);
            System.out.println();
        }
    }
    
    public static void postOrdrer(Node root)
    {
        if(root == null)
          return;
          
        postOrdrer(root.left);
        postOrdrer(root.right);
        System.out.print(root.data + " ");
    }
}// } Driver Code Ends


class Solution
{
    public static Node buildTreeHelper(int[] in, int[] pre, int inS, int inE,int preS, int preE){
        if(inS > inE){
            return null;
        }
        Node root = new Node(pre[preS]);
        int rootIndex = -1;
        for(int i=inS;i<=inE;i++){
            if(in[i] == pre[preS]){
                rootIndex = i;
                break;
            }
        }
        if(rootIndex == -1){
            return null;
        }
        int leftInS = inS;
        int leftInE = rootIndex-1;
        int leftPreS = preS+1;
        int leftPreE = leftInE-leftInS+leftPreS;
        int rightInS = rootIndex+1;
        int rightInE = inE;
        int rightPreS = leftPreE+1;
        int rightPreE = preE;
        root.left = buildTreeHelper(in,pre,leftInS,leftInE,leftPreS,leftPreE);
        root.right = buildTreeHelper(in,pre,rightInS,rightInE,rightPreS,rightPreE);
        return root;
    }
    public static Node buildTree(int inorder[], int preorder[], int n)
    {
        return buildTreeHelper(inorder,preorder,0,inorder.length-1,0,preorder.length-1);

    }
}
