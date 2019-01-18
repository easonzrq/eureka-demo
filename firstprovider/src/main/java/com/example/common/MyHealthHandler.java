package com.example.common;

import com.netflix.appinfo.HealthCheckHandler;
import com.netflix.appinfo.InstanceInfo;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Status;
import org.springframework.stereotype.Component;

/*
保持health状态同步给eureka
 */
@Component
public class MyHealthHandler implements HealthCheckHandler {
    @Autowired
    MyHealth myHealth;
    public InstanceInfo.InstanceStatus getStatus(InstanceInfo.InstanceStatus statusOld){
        Status status =myHealth.health().getStatus();
        if(!StringUtils.isEmpty(status.toString()) & status.equals(Status.UP)){
            return InstanceInfo.InstanceStatus.UP;
        }else{
            return InstanceInfo.InstanceStatus.DOWN;
        }
    }
}
