package com.jsu.goods;

import org.springframework.web.servlet.view.AbstractUrlBasedView;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

public class MyInternalResourceViewResolver extends InternalResourceViewResolver {
    @Override
    protected AbstractUrlBasedView buildView(String viewName) throws Exception {
        System.out.println("MyInternalResourceViewResolver.buildView: " + viewName);
        return super.buildView(viewName);
    }

    @Override
    protected AbstractUrlBasedView instantiateView() {
        System.out.println("MyInternalResourceViewResolver.instantiateView");
        return super.instantiateView();
    }
}
