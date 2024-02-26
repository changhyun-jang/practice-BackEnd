package OOP.core.encapsulation;

public class Rectangle {
    private int left;
    private int top;
    private int right;
    private int bottom;

    public Rectangle(int left, int top, int right, int bottom) {
        this.left = left;
        this.top = top;
        this.right = right;
        this.bottom = bottom;
    }

    public int getLeft() {
        return left;
    }

    public int getTop() {
        return top;
    }

    public int getRight() {
        return right;
    }

    public int getBottom() {
        return bottom;
    }

    //rectangle 클래스가 스스로 자신의 높이와 너비를 늘릴 수 있는 메소드를 가짐
    //책임을 가짐
    public void enlarge(int multiple) {
        right *= multiple;
        bottom *= multiple;
    }
}
