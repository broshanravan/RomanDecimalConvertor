package com.roman.decimal;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ApplicationTest {
    Application application = new Application();

    @Test
    public void test() {
        Application.main(new String[] {});
    }
}
