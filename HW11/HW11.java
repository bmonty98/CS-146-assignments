public class HW11 {

    

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        if(color == image[sr][sc]){
            return image;
        }
        int rows = image.length;
        int columns = image[0].length;
        int sourcePixel = image[sr][sc];
        DFS(image,sr,sc,color,sourcePixel,rows,columns);
        return image;
     }
    
    public void DFS(int[][] image, int sr, int sc, int color, int sourcePixel, int rows, int columns){
        if( sr < 0 || sr >= rows || sc < 0 || sc >= columns){

            return;
        }

        else if( image[sr][sc] != sourcePixel){
            return;
        }

        image[sr][sc] = color;
        //check bottom
        DFS(image, sr + 1, sc, color, sourcePixel, rows, columns);
        // check right
        DFS(image,sr, sc + 1,color, sourcePixel, rows, columns);
        // check left
        DFS(image, sr, sc - 1, color, sourcePixel, rows, columns);    
        // check top
        DFS(image, sr - 1, sc, color, sourcePixel, rows, columns);
     }

     // a quick print 2D matrix printer to express our matrices in Java because Java is not as elit as python.
     public static void matrixPrinter(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
 
     
     public static void main(String[] args) {
       int[][] image = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
    int sr = 1; 
    int sc = 1;
    int color = 2;
    HW11 sample = new HW11();
    // should return [[2,2,2], [2,2,0], [2,0,1]]
    matrixPrinter(sample.floodFill(image, sr, sc, color));

    System.out.println("\n" + "\n" + "\n");
    int[][] image2 = {{0,0,0}, {0,0,0}};
    sr = 0;
    sc = 0;
    color = 0;
    // should return [[0,0,0],[0,0,0]]
    matrixPrinter(sample.floodFill(image2, sr, sc, color));
    System.out.println("\n");
     }    
}