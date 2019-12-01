package pl.konmarek.firstspringexample;

import org.junit.Assert;
import org.junit.Test;

public class StringReverseTest {

    @Test
    public void reverse() {
        Assert.assertEquals("4321", StringReverse.reverse("1234", ""));
    }

    @Test
    public void reverseWithForbidden(){
        Assert.assertEquals("4321", StringReverse.reverse("1324", "23"));
    }
}