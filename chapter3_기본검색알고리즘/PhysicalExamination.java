package chapter3_기본검색알고리즘;

class PhysicalExamination implements Comparable<PhysicalExamination> {

    private String name;
    private int height;
    private double vision;

    public PhysicalExamination(String name, int height, double vision) {
        this.name = name;
        this.height = height;
        this.vision = vision;
    }

    @Override
    public String toString() {
        return "PhysicalExamination{" +
                "name='" + name + '\'' +
                ", height=" + height +
                ", vision=" + vision +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public double getVision() {
        return vision;
    }

    public void setVision(double vision) {
        this.vision = vision;
    }

    @Override
    public int compareTo(PhysicalExamination o) {
        return this.height-o.height>0?1:(this.height-o.height<0?-1:0);
    }
}
