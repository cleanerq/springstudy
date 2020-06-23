package com.base;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * 泛型转化为真实类型
 * ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0]
 * @author qby
 * @date 2020/6/23 11:17
 */
public class GenericDAO<T> {
    private static Logger logger = LoggerFactory.getLogger(GenericDAO.class);

    private Class<T> entityClass;

    protected GenericDAO() {
        // 获取子类类型，获取到父类类型
        ParameterizedType parameterizedType = (ParameterizedType) getClass().getGenericSuperclass();
        logger.info("获取到的父类的类型:{}", parameterizedType.getActualTypeArguments());

        Type trueType = parameterizedType.getActualTypeArguments()[0];
        // 超类里的entityClass就是子类那里的
        // public class OptionManager extends GenericDAO<MSGC_OPTION>
        // 里面的MSGC_OPTION所对应的class对象了
        this.entityClass = (Class<T>) trueType;

        logger.info("真实类型:{}", this.entityClass);
    }
}
