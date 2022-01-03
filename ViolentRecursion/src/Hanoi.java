public class Hanoi {
    public void hanoi1(int n) {
        moveLeftToRight(n);
    }

    private void moveLeftToRight(int n) {
        if (n == 1) {
            System.out.println("move " + n + " from left to right!");
            return;
        }

        moveLeftToMid(n - 1);
        System.out.println("move " + n + " from left to right!");
        moveMidToRight(n - 1);
    }


    private void moveLeftToMid(int n) {
        if (n == 1) {
            System.out.println("move " + n + " from left to mid!");
            return;
        }

        moveLeftToRight(n - 1);
        System.out.println("move " + n + " from left to mid!");
        moveRightToMid(n - 1);
    }

    private void moveRightToMid(int n) {
        if (n == 1) {
            System.out.println("move " + n + " from right to mid!");
            return;
        }

        moveRightToLeft(n - 1);
        System.out.println("move " + n + " from right to mid!");
        moveLeftToMid(n - 1);
    }

    private void moveRightToLeft(int n) {
        if (n == 1) {
            System.out.println("move " + n + " from right to left!");
            return;
        }

        moveRightToMid(n - 1);
        System.out.println("move " + n + " from right to left!");
        moveMidToLeft(n - 1);
    }

    private void moveMidToRight(int n) {
        if (n == 1) {
            System.out.println("move " + n + " from mid to right!");
            return;
        }

        moveMidToLeft(n - 1);
        System.out.println("move " + n + " from mid to right!");
        moveLeftToRight(n - 1);
    }

    private void moveMidToLeft(int n) {
        if (n == 1) {
            System.out.println("move " + n + " from mid to left!");
            return;
        }

        moveMidToRight(n - 1);
        System.out.println("move " + n + " from mid to left!");
        moveRightToLeft(n - 1);
    }

    public void hanoi2(int n) {
        process(n, "left", "right", "mid");
    }

    public void process(int n, String left, String right, String mid) {
        if (n == 1) {
            System.out.println("move " + n + " from " + left + " to " + right + "!");
            return;
        }

        process(n - 1, left, mid, right);
        System.out.println("move " + n + " from " + left + " to " + right + "!");
        process(n - 1, mid,right, left);
    }
}
