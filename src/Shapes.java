public class Shapes {

    public static void glider(Grid grid, int x, int y){
        grid.getGrid()[x][y].setLiving(true);
        grid.getGrid()[x + 1][y + 1].setLiving(true);
        grid.getGrid()[x - 1][y + 2].setLiving(true);
        grid.getGrid()[x][y + 2].setLiving(true);
        grid.getGrid()[x + 1][y + 2].setLiving(true);

        Panel.livingCells.add(grid.getGrid()[x][y]);
        Panel.livingCells.add(grid.getGrid()[x + 1][y + 1]);
        Panel.livingCells.add(grid.getGrid()[x - 1][y + 2]);
        Panel.livingCells.add(grid.getGrid()[x][y + 2]);
        Panel.livingCells.add(grid.getGrid()[x + 1][y + 2]);
    }

    public static void cross(Grid grid, int x, int y){
        grid.getGrid()[x][y].setLiving(true);
        grid.getGrid()[x][y + 1].setLiving(true);
        grid.getGrid()[x][y - 1].setLiving(true);
        grid.getGrid()[x + 1][y].setLiving(true);
        grid.getGrid()[x - 1][y].setLiving(true);

        Panel.livingCells.add(grid.getGrid()[x][y]);
        Panel.livingCells.add(grid.getGrid()[x][y + 1]);
        Panel.livingCells.add(grid.getGrid()[x][y - 1]);
        Panel.livingCells.add(grid.getGrid()[x + 1][y]);
        Panel.livingCells.add(grid.getGrid()[x - 1][y]);
    }
    public static void chaos(Grid grid, int x, int y){
        grid.getGrid()[x][y].setLiving(true);
        grid.getGrid()[x][y + 1].setLiving(true);
        grid.getGrid()[x][y - 1].setLiving(true);
        grid.getGrid()[x + 1][y + 1].setLiving(true);
        grid.getGrid()[x - 1][y].setLiving(true);

        Panel.livingCells.add(grid.getGrid()[x][y]);
        Panel.livingCells.add(grid.getGrid()[x][y + 1]);
        Panel.livingCells.add(grid.getGrid()[x][y - 1]);
        Panel.livingCells.add(grid.getGrid()[x + 1][y + 1]);
        Panel.livingCells.add(grid.getGrid()[x - 1][y]);
    }
}
