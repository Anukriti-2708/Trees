class Tree
{
	public static int getSize(Node root)
	{
	   
	    if(root == null){
       return 0;
   }
   if(root.left ==null && root.right == null){
       return 1;
   }
   int i = getSize(root.left);
   int j = getSize(root.right);
   return 1+i+j;
	    

    }
}
