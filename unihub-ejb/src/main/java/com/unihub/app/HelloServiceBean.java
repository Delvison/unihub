package com.unihub.app;

import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebService;

@Stateless
@WebService
public class HelloServiceBean implements Hello {
    private String message = "Hello, ";

    @WebMethod
    public String sayHello(String name) {
        return message + name + ".";
    }
}
