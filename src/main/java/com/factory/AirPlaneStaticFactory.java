package com.factory;

import com.bean.AirPlane;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 静态工厂
 *
 * @author qby
 * @date 2020/6/18 14:09
 */
public class AirPlaneStaticFactory {
    private static Logger logger = LoggerFactory.getLogger(AirPlaneStaticFactory.class);

    public static AirPlane getAirplane(String jzName) {
        logger.info("静态工厂创建 ");
        AirPlane airPlane = new AirPlane();
        airPlane.setJzName(jzName);
        return airPlane;
    }
}
