package calc;

import org.junit.Test;
import org.junit.Assert;

public class Tests {

    Calc calc = new Calc();

    @Test
    public void FirstTest() {
        String input = "2+3";
        String expected = "5.0";
        calc.setInput(input);
        String actual = calc.toString() + "";
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void MoreOperandsTest() {
        String input = "2+3*6-7";
        String expected = "13.0";
        calc.setInput(input);
        String actual = calc.toString() + "";
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void OneOperandTest() {
        String input = "2";
        String expected = "2.0";
        calc.setInput(input);
        String actual = calc.toString() + "";
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void NegativeOperandTest() {
        String input = "-2";
        String expected = "-2.0";
        calc.setInput(input);
        String actual = calc.toString() + "";
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void InputTest() {
        String input = "-2";
        String expected = "-2";
        calc.setInput(input);
        String actual = calc.getInput() + "";
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void SinTest() {
        String input = "sin(0)+1";
        String expected = "1.0";
        calc.setInput(input);
        String actual = calc.toString() + "";
        Assert.assertEquals(expected, actual);
    }
}
