public class Shapes {

    public static void glider(Grid grid, int x, int y){
        grid.getGrid()[x][y].setLiving(true); // 6,5
        grid.getGrid()[x + 1][y + 1].setLiving(true); // 7,6
        grid.getGrid()[x - 1][y + 2].setLiving(true); // 5,7
        grid.getGrid()[x][y + 2].setLiving(true); // 6,7
        grid.getGrid()[x + 1][y + 2].setLiving(true); // 7,7

        Panel.livingCells.add(grid.getGrid()[x][y]);
        Panel.livingCells.add(grid.getGrid()[x + 1][y + 1]);
        Panel.livingCells.add(grid.getGrid()[x - 1][y + 2]);
        Panel.livingCells.add(grid.getGrid()[x][y + 2]);
        Panel.livingCells.add(grid.getGrid()[x + 1][y + 2]);
    }
}
