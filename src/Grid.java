public class Grid {
    public Cell[][] grid;

    Grid(){
        grid = new Cell[(Panel.SCREEN_WIDTH / Panel.UNIT_SIZE)][(Panel.SCREEN_HEIGHT / Panel.UNIT_SIZE)];

        for(int y = 0; y < grid.length; y++){
            for(int x = 0; x < grid[0].length; x++){
                grid[x][y] = new Cell(x, y, false);
            }
        }
    }

    public Cell[][] getGrid(){
        return grid;
    }
}
