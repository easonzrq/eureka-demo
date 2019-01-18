package com.example.common;

import com.example.controller.CommonController;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.boot.actuate.health.Status;
import org.springframework.stereotype.Component;

@Component
public class MyHealth implements HealthIndicator {
    //修改服务实例的状态
    public Health health(){
        if(CommonController.dbVisit){
            return new Health.Builder(Status.UP).build();
        }else{
            return new Health.Builder(Status.DOWN).build();
        }
    }
}
