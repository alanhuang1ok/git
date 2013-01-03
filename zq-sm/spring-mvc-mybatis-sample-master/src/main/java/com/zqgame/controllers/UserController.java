/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zqgame.controllers;

import com.zqgame.base.BaseController;
import com.zqgame.common.page.Page;
import com.zqgame.common.page.PageRequest;
import com.zqgame.models.UserInfo;
import com.zqgame.service.UserService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author alan
 */
@Controller
@RequestMapping("/account")
public class UserController extends BaseController {

    protected static final String DEFAULT_SORT_COLUMNS = null;
    private static final Logger LOG = LoggerFactory.getLogger(UserController.class);
    private final String LIST_ACTION = "redirect:/account/index";
    @Autowired
    private UserService service;

    /**
     * http://localhost:8080/sm-template/account/get/1
     *
     * @param id
     * @param model
     * @return
     */
    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    public String get(@PathVariable int id, Model model) {
        System.out.println("##ID:" + id);
        service.getModel(id);
        return "userinfo/show";
    }

    @RequestMapping(value = "/getAllList", method = RequestMethod.GET)
    public String getAllList(Model model) {
        System.out.println("[ Into  getAllList ]");
        List<UserInfo> allList = service.getAllList();
        model.addAttribute("userInfos", allList);
        return "userinfo/list";
    }

    @RequestMapping(value = "/new")
    public String newUserInfo(Model model) {
        model.addAttribute(new UserInfo());
        return "userinfo/new";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String createUserInfo(UserInfo userinfo, Model model) {
        //errors=errors;  当类型转换错误的时候 错误信息在errors中 , Errors errors
        boolean createUserInfo = service.createUserInfo(userinfo);
        return LIST_ACTION;
    }

    /**
     * 参数获取
     *
     * @param name
     * @return
     */
    @RequestMapping(value = "/createByAjax", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, String> createUser(@RequestParam(value = "name", required = true) String name) {
        LOG.info("新增  " + name);
        Map<String, String> map = new HashMap<String, String>(1);
        map.put("success", "true");
        return map;

    }

    /**
     * 列表
     */
    @RequestMapping(value = "/index")
    public ModelAndView index(HttpServletRequest request, HttpServletResponse response) {

        PageRequest<Map> pageRequest = newPageRequest(request, DEFAULT_SORT_COLUMNS);
        //pageRequest.getFilters(); //add custom filters
        LOG.info("----------index------------");
        Page page = this.service.findByPageRequest(pageRequest);
        ModelAndView result = toModelAndView(page, pageRequest);
        result.setViewName("userinfo/index");
        return result;
    }

    /**
     * 批量删除
     */
    @RequestMapping(value = "/batchDelete")
    public ModelAndView batchDelete(Integer[] items) {
        LOG.info("----------batchDelete------------");
        for (int i = 0; i < items.length; i++) {
            service.removeById(items[i]);
        }
        return new ModelAndView(LIST_ACTION);
    }

    /**
     * 删除
     */
    @RequestMapping(value = "/{id}/delete" )
    public ModelAndView delete(@PathVariable Integer id) {
        service.removeById(id);
        return new ModelAndView(LIST_ACTION);
    }
}
