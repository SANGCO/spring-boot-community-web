package io.sangco.web;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;

public class javaTest {

    @Test
    public void javaLangMathTest() {
        // 10으로 나누고 소수점 떨구고 거기에 다시 10을 곱하고 1을 더하면 startNumber가 나온다.
        // ex)15페이지 선택하면 14가 들어와서 10 나누고 floor() 테우면 1.0 거기에 10 곱하고 1 더하면 11
        assertThat(Math.floor(12/10), is(1.0));
        assertThat(Math.floor(12/10) * 10 + 1, is(11.0));
    }
}
