package tcp;

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
