package domino;

/**
 *
 * @author bandyjo
 */
public class CDominoes {

    int top;
    int bottom;

    public int sum() {
        return top + bottom;
    }

    public CDominoes(int topSide, int bottomSide) {
        top = topSide;
        bottom = bottomSide;
    }
    public void swap(){
        int sub = -1;
        sub = top;
        top = bottom;
        bottom = sub;
        
    }

    public int getBottom() {
        return bottom;
    }

    public int getTop() {
        return top;
    }

    public boolean isTwin() {
        return top == bottom;
    }
    @Override
    public String toString(){
        return  "["+top+", "  + bottom+"]";
    }
}
