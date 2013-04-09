package com.unihub.app;

import javax.ejb.*;
import javax.annotation.Resource;
import java.util.ArrayList;
import javax.naming.*;
import javax.jws.WebMethod;
import javax.jws.WebService;

@Stateful
@Remote(ClearHistoryEJB.class)
@WebService
public class ClearHistorySession implements ClearHistoryEJB {

}