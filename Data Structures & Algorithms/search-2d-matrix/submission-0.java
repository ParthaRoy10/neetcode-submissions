class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        //Calculate the no of rows and columns
        int m=matrix.length-1;          //Rows
        int n=matrix[0].length-1;       //Columns

        int rowT=0;
        int rowB=m;


        while(rowT<=rowB ){
            int midR=rowT+(rowB-rowT)/2;
            if(matrix[midR][0]<=target && matrix[midR][n]>=target){
                    int colL=0;
                    int colR=n;
                while(colL<=colR){
                    int midC=colL+(colR-colL)/2;
                    if(matrix[midR][midC]==target){
                        return true;
                    }else if(matrix[midR][midC]<target){
                        colL=midC+1;
                    }else{
                        colR=midC-1;
                    }

                }
                return false;
            }else if(matrix[midR][0]>target){
                rowB=midR-1;
            }else{
                rowT=midR+1;
            }

        }
        return false;
    }
}
