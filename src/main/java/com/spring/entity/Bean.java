package com.spring.entity;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

import javax.annotation.PostConstruct;


public class Bean implements BeanFactoryPostProcessor, BeanPostProcessor, BeanNameAware, BeanFactoryAware, InitializingBean, DisposableBean, ApplicationContextAware, ApplicationListener<ContextRefreshedEvent> {

    private String id;


    public Bean() {
        System.out.println("1执行构造方法");
    }


    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("4执行setBeanFactory方法");
    }

    @Override
    public void setBeanName(String s) {
        System.out.println("3执行setBeanName方法");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("6执行afterPropertiesSet方法");
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        System.out.println("7执行postProcessBeanFactory方法");
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("执行postProcessBeforeInitialization方法" + beanName);
        return null;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("执行postProcessAfterInitialization方法" + beanName);
        return null;
    }

    public void setId(String id) {
        System.out.println("2执行setId方法");
        this.id = id;
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("最后执行destroy方法");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("5setApplicationContext");
    }

    @PostConstruct
    public void init() {
        System.err.println("PostConstruct");
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        System.out.println("ContextRefreshedEvent");
    }
}
