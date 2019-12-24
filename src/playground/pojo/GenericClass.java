package playground.pojo;

public class GenericClass {
    private String a;
    private String b;

    public GenericClass(String a, String b){
        this.a = a;
        this.b = b;
    }

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }

    @Override
    public String toString() {
        return "GenericClass{" +
                "a='" + a + '\'' +
                ", b='" + b + '\'' +
                '}';
    }
}
