package com.mafei.laboratory.page.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author wutangsheng
 * @create 2021-03-09 15:39
 * @info
 */
@Controller
@RequestMapping("/apparatus")
public class ApparatusController {
    private final String prefix = "apparatus";

    @GetMapping("/info")
    public String info() {
        return prefix + "/info";
    }


    @GetMapping("/position")
    public String position(Model model) {
        return prefix + "/position";
    }

    @GetMapping("/repair")
    public String repair(Model model) {
        return prefix + "/repair";
    }

    @GetMapping("/use")
    public String use(Model model) {
        return prefix + "/use";
    }
}
