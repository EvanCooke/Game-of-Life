public class Cell {
    int x;
    int y;
    boolean living;



    Cell(int x, int y, boolean living){
        this.x = x;
        this.y = y;
        this.living = living;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setLiving(boolean living) {
        this.living = living;
    }

    public boolean getLiving(){
        return living;
    }

}
