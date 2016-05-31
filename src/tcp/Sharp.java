package tcp;

/**
 * Created by chico on 30/05/16.
 */
public class Sharp {
    private boolean active;

    public Sharp() {
        active = false;
    }

    public boolean isActive() {
        return active;
    }

    public void setInactive() {
        active = false;
    }

    public void setActive() {
        active = true;
    }
}
