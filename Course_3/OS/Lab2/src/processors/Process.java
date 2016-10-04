package processors;

/**
 * Created by sitora on 01.10.16.
 */
public class Process implements Comparable {

    private String name;
    private Integer length;

    private long recivedTime;

    public Process(int length, String name) {
        this.recivedTime = System.currentTimeMillis();
        this.length = length * 100;
        this.name = name;
    }

    public Process(int length, String name, boolean isLengthFormatted) {
        if (isLengthFormatted) {
            this.length = length;
            this.name = name;
        } else {
            this.length = length * 100;
            this.name = name;
        }
    }

    @Override
    public int compareTo(Object o) {
        return this.length.compareTo(((Process) o).length);
    }

    public String getName() {
        return name;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public long getRecivedTime() {
        return recivedTime;
    }

    public void setRecivedTime(long recivedTime) {
        this.recivedTime = recivedTime;
    }

}
