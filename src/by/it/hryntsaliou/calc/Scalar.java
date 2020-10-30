package by.it.hryntsaliou.calc;

import java.util.Arrays;

class Scalar extends Var {

    private final double value;

    public double getValue() {
        return value;
    }

    Scalar(double value) {
        this.value = value;
    }

    Scalar(Scalar scalar) {
        this.value = scalar.value;
    }

    Scalar(String strScalar) {
        this.value = Double.parseDouble(strScalar);
    }

    @Override
    public Var add(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double sum = this.value + ((Scalar) other).value;
            return new Scalar(sum);
        } else
        return other.add(this);
    }

    @Override
    public Var sub(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double sub = this.value - ((Scalar) other).value;
            return new Scalar(sub);
        } else
            return other.sub(this).mul(new Scalar(-1));
    }

    @Override
    public Var mul(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double mul = this.value * ((Scalar) other).value;
            return new Scalar(mul);
        } else
            return other.mul(this);
    }

    @Override
    public Var div(Var other) throws CalcException {
        if (other instanceof Scalar) {
            if(((Scalar)other).value == 0){
                throw new CalcException("Деление на ноль!");
            }
            double div = this.value / ((Scalar) other).value;
            return new Scalar(div);
        } else
            throw new CalcException("Операция деления  " + Arrays.toString(new double[]{value}) + " на " + other + " невозможна!");
    }

    @Override
    public String toString() {
        return Double.toString(value);
    }
}
