/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kebo.managedbeans;

import java.io.Serializable;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import kebo.session.ejb.BetFinderCombinateEJB;
import kebo.session.ejb.BetFinderEJB;

/**
 *
 * @author gabor_dev
 */
@ManagedBean
@SessionScoped
public class ControllerBean implements Serializable {
    @EJB
    private BetFinderCombinateEJB betFinderCombinateEJB;
    @EJB
    private BetFinderEJB betFinderEJB;
    
    
    private static final Logger LOG = Logger.getLogger(ControllerBean.class.getName());
    
    

    public ControllerBean() {
    }
    
    public void startFindOdds() {
        LOG.info("invoked...");
        betFinderCombinateEJB.startFindOdds();
        
        //betFinderEJB.startFindOdds();
    }
    
    
}
