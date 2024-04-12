# I was not understanding why I was having issues with self for the longest time but I realized if I put my methods in
# a class it would fix the issue! I am learning more about python everyday!
class HW11:
    
    
    def floodFill(self, image, sr, sc, color):
        if color == image[sr][sc]:
            return image
        rows = len(image)
        columns = len(image[0])
        sourcePixel = image[sr][sc] 
        self.DFS(image, sr, sc, color, sourcePixel, rows, columns)
        return image

    # helper method for doing a depth first traversal of the image provided by flood fill which additionally keeps the size of matrix mxn matrix    
    def DFS(self, image, sr, sc, color, sourcePixel, rows, columns):
        if sr < 0 or sr >= rows or sc < 0 or sc >= columns:
            return
        
        elif image[sr][sc] != sourcePixel:
            return
        
        image[sr][sc] = color
        
            
            
        # check bottom
        self.DFS(image, sr + 1, sc, color, sourcePixel, rows, columns)
            # check right
        self.DFS(image,sr, sc + 1,color, sourcePixel, rows, columns)
            # check left
        self.DFS(image, sr, sc - 1, color, sourcePixel, rows, columns)    
            # check top
        self.DFS(image, sr - 1, sc, color, sourcePixel, rows, columns)
            
    
    
        
    

if __name__ == "__main__":
    image = [[1, 1, 1], [1, 1, 0], [1, 0, 1]]
    sr, sc, color = 1, 1, 2
    hw11 = HW11()
    # should return [[2,2,2], [2,2,0], [2,0,1]]
    print(hw11.floodFill(image, sr, sc, color))
    image = [[0,0,0],[0,0,0]] 
    sr = 0
    sc = 0
    color = 0
    # should return [[0,0,0],[0,0,0]]
    print(hw11.floodFill(image, sr, sc, color))
    

    