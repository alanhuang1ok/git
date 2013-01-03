/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zqgame.base;

import com.zqgame.common.page.Page;
import com.zqgame.common.page.PageRequest;
import com.zqgame.util.PageRequestFactory;
import javax.servlet.http.HttpServletRequest;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author alan
 */
public class BaseController {

   
    public PageRequest newPageRequest(HttpServletRequest request, String defaultSortColumns) {
        return PageRequestFactory.newPageRequest(request, defaultSortColumns);
    }

    public ModelAndView toModelAndView(Page page, PageRequest pageRequest) {
        return toModelAndView("", page, pageRequest);
    }

    public ModelAndView toModelAndView(String tableId, Page page, PageRequest pageRequest) {
        ModelAndView model = new ModelAndView();
        saveIntoModelAndView(tableId, page, pageRequest, model);
        return model;
    }

    /**
     * 用于一个页面有多个extremeTable是使用
     *
     * @param tableId 等于extremeTable的tableId属性
     */
    public void saveIntoModelAndView(String tableId, Page page, PageRequest pageRequest, ModelAndView model) {
        Assert.notNull(tableId, "tableId must be not null");
        Assert.notNull(page, "page must be not null");

        model.addObject(tableId + "page", page);
        model.addObject(tableId + "totalRows", new Integer(page.getTotalCount()));
        model.addObject(tableId + "pageRequest", pageRequest);
    }
}
