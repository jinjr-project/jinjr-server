package com.github.jinjr.jinjrserver.collaboration.domain.model;

import com.github.jinjr.jinjrserver.collaboration.domain.model.timetracker.TimeExpression;
import org.junit.Assert;
import org.junit.Test;

public class TimeExpressionTest {

    @Test
    public void shouldBe60SecondWhenOneMinute() {
        TimeExpression te = new TimeExpression("1m");
        Assert.assertEquals(Long.toString(60L), te.getSeconds().toString());
    }

    @Test
    public void shouldBeTwoHours() {
        TimeExpression te = new TimeExpression("1h60m");
        Assert.assertEquals(Long.toString(3600L * 2), te.getSeconds().toString());
    }
}
