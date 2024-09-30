class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int rowBegin=0,rowEnd=matrix.length-1;
        int colBegin=0,colEnd=matrix[0].length-1;
        int dir=0;
        ArrayList<Integer> result= new ArrayList<>();
        while(rowBegin<=rowEnd && colBegin <= colEnd) {
            if(dir==0) {
                for(int i=colBegin;i<=colEnd;i++) {
                    result.add(matrix[rowBegin][i]);
                }
                rowBegin++;
                dir++;
            }
            else if(dir==1) {
                for(int i=rowBegin;i<=rowEnd;i++) {
                    result.add(matrix[i][colEnd]);
                }
                colEnd--;
                dir++;
            }
            else if(dir==3) {
                for(int i=colEnd;i>=colBegin;i--) {
                    result.add(matrix[rowEnd][i]);
                }
                rowEnd--;
                dir++;
            }
            else{
                for(int i=rowEnd;i>=rowBegin;i--) {
                    result.add(matrix[i][colBegin]);
                }
                colBegin++;
                dir++;
            }
            dir = (dir+1)%4;
        }
        return result;
    }
}