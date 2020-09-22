package by.it.kulik.jd01_07;
class Vector extends Var {
    private double[] value;
    Vector(double[] value) {
        this.value = value;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        String delimiter = "";
        for (double element : value) {
            sb.append(delimiter).append(element);
            delimiter = ", ";
        }
        sb.append("}");
        return sb.toString();
    }
    Vector(Vector vector) {
        this.value = vector.value;
    }
    Vector(String strVector) {

    }
}

