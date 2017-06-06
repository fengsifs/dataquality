package cn.edu.fudan.controller;

import cn.edu.fudan.model.RuleModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by FengSi on 2017/06/06 at 12:40.
 */
@Controller
public class RuleController {
    @RequestMapping(value = "/rule")
    public String rule(Model model) {
        String[] tables = new String[3];
        tables[0] = "表1";
        tables[1] = "表2";
        tables[2] = "表3";
        model.addAttribute("tables", tables);
        return "rule";
    }

    @RequestMapping(value = "/setRule", method = RequestMethod.GET)
    public String setRule(Model model) {
        model.addAttribute("rule", new RuleModel());
        return "rule";
    }
}
