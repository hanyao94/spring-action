package service;

import org.springframework.security.access.prepost.PreAuthorize;
import pojo.Spittle;

public class ExpressionSecuredSpittleService implements SpittleService {

    @PreAuthorize("(hasRole('ROLE_SPITTER') and #spittle.text.length() le 140) or hasRole('ROLE_PREMIUM')")
    public void addSpittle(Spittle spittle) {
        System.out.println("Method was called successfully");
    }

}
