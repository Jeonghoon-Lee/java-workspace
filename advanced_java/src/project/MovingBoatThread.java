package project;

public class MovingBoatThread extends Thread {
    public static final int MIN_BOAT_SPEED = -30;
    public static final int MAX_BOAT_SPEED = 70;
    public static final int INIT_BOAT_SPEED = 10;

    private boolean moving;
    private boolean exitThread;

    private int boatSpeed;

    private Boat boat;

    public MovingBoatThread(Boat boat) {
        exitThread = false;
        moving = false;
        boatSpeed = INIT_BOAT_SPEED;

        this.boat = boat;
    }

    @Override
    public void run() {
        System.out.println("-- Created the moving boat thread.");
        moving = true;
        while (!exitThread) {
            if (boatSpeed != 0 && moving) {
                boat.setxPosition(moveBoat());
                boat.repaint();

                do_nothing(200 / Math.abs(boatSpeed));
            } else {
                do_nothing(100);
            }
        }
        System.out.println("-- Finished the moving boat thread.");
    }

    private int moveBoat() {
        int xPos = boat.getxPosition();

        if (boatSpeed > 0) {
            // move right
            xPos++;
            if (xPos >= boat.getParent().getSize().width) {
                xPos = xPos % boat.getParent().getSize().width;
                if (xPos == 0) {
                    xPos = -Boat.BOAT_WIDTH;
                }
            }
        } else {
            // move left
            xPos--;
            if ((xPos < 0) && (Math.abs(xPos) == Boat.BOAT_WIDTH)) {
                xPos = boat.getParent().getSize().width;
            }
        }

        return xPos;
    }

    public void do_nothing(int timeout) {
        try {
            Thread.sleep(timeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void setMovingBoat(boolean moving) {
        this.moving = moving;
    }

    public void setExitThread(boolean exitThread) {
        this.exitThread = exitThread;
    }

    public int getBoatSpeed() {
        return boatSpeed;
    }

    public void setBoatSpeed(int boatSpeed) {
        this.boatSpeed = boatSpeed;
    }
}
