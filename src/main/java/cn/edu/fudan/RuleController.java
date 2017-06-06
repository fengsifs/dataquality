package cn.edu.fudan;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by FengSi on 2017/06/06 at 12:40.
 */
@Controller
public class RuleController {
    @RequestMapping(value = "/rule")
    public String rule(Model model) {
        String[] tables = new String[2];
        tables[0] = "fdsf";
        tables[1] = "gfd";
        model.addAttribute("tables", tables);
        return "rule";
    }
}
