package com.mafei.laboratory.page.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author wutangsheng
 * @create 2021-03-10 0:41
 * @info
 */
@Controller
@RequestMapping("/borrow")
public class BorrowController {
    private final String prefix = "borrow";

    @GetMapping("/apparatus")
    public String borrowApparatus() {
        return prefix + "/apparatus";
    }

    @GetMapping("/laboratory")
    public String borrowLog() {
        return prefix + "/laboratory";
    }

}
