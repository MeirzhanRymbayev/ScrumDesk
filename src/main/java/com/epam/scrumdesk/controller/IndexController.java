package com.epam.scrumdesk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Meirzhan_Rymbayev on 3/18/2016.
 */
@Controller
@RequestMapping(value = "/")
public class IndexController {
    @RequestMapping(method = RequestMethod.GET)
    public String getIndexPage() {
        return "ScrumDesk";
    }

}
