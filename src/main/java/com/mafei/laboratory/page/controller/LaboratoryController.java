package com.mafei.laboratory.page.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author wutangsheng
 * @create 2021-03-01 20:06
 * @info
 */
@Controller
@RequestMapping("/laboratory")
public class LaboratoryController {

    private final String prefix = "laboratory";

    @GetMapping("/info")
    public String info() {
        return prefix + "/info";
    }

    @GetMapping("/import")
    public String importData(Model model) {

        return prefix + "/import";
    }

    @GetMapping("/log")
    public String log() {
        return prefix + "/log";
    }

}
