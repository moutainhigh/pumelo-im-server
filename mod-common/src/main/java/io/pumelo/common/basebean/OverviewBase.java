package io.pumelo.common.basebean;

public class OverviewBase {
    private int current;
    private int rise;


    public OverviewBase() {
    }

    public OverviewBase(int current, int rise) {
        this.current = current;
        this.rise = rise;
    }

    public int getCurrent() {
        return current;
    }

    public void setCurrent(int current) {
        this.current = current;
    }

    public int getRise() {
        return rise;
    }

    public void setRise(int rise) {
        this.rise = rise;
    }
}
