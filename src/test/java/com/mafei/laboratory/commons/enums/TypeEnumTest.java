package com.mafei.laboratory.commons.enums;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author wutangsheng
 * @create 2021-03-11 17:10
 * @info
 */
@SpringBootTest
class TypeEnumTest {
    @Test
    void test() {
        for (TypeEnum type : TypeEnum.values()) {
            System.out.println(type);
        }
    }

}