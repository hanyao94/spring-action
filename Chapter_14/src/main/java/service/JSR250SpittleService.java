package service;

import pojo.Spittle;

import javax.annotation.security.RolesAllowed;

public class JSR250SpittleService implements SpittleService {

    @RolesAllowed("ROLE_SPITTER")
    public void addSpittle(Spittle spittle) {
        System.out.println("Method was called successfully");
    }

}
