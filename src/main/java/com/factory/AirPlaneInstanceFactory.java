package com.factory;

import com.bean.AirPlane;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 实例工厂
 *
 * @author qby
 * @date 2020/6/18 14:09
 */
public class AirPlaneInstanceFactory {
    Logger logger = LoggerFactory.getLogger(getClass());

    public AirPlane getAirplane(String jzName) {
        logger.info("实例工厂创建 ");
        AirPlane airPlane = new AirPlane();
        airPlane.setJzName(jzName);
        return airPlane;
    }
}
