/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kebo.session.ejb;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.GZIPInputStream;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import kebo.entity.Tipbet;
import kebo.json.bind.B;
import kebo.json.bind.BettingBaseJSON;
import kebo.json.bind.C;
import kebo.json.bind.E;
import kebo.json.bind.L;
import kebo.json.bind.M;
import kebo.json.bind.O;
import kebo.json.bind.S;
import org.codehaus.jackson.map.ObjectMapper;

/**
 *
 * @author gabor_dev
 */
@Stateless
public class BetFinderCombinateEJB {

    private static final Logger LOG = Logger.getLogger(BetFinderEJB.class.getName());
    @PersistenceContext(unitName = "BetFinderPU")
    private EntityManager em;
    String inputJsonFile = "/Users/gabor_dev/NetBeansProjects/BetFinder-master/BetFinder-master/bets.json";
    
    

    public void downloadZip() {

        try {
            String urlToDownload = "http://services.eoddsmaker.net/demo/feeds/V2.0/markets.ashx?l=1&u=kuli.gabor.get&p=kuli.gabor.get&frm=json";

            URL url;

            url = new URL(urlToDownload);
            InputStream in = url.openStream();

            GZIPInputStream gzis = new GZIPInputStream(in);
            FileOutputStream fos = new FileOutputStream(new File(inputJsonFile));

            int len;
            byte[] buffer = new byte[1024];
            while ((len = gzis.read(buffer)) > 0) {
                fos.write(buffer, 0, len);
            }

            gzis.close();
            fos.close();

        } catch (MalformedURLException ex) {
            Logger.getLogger(BetFinderEJB.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(BetFinderEJB.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            LOG.warning(ex.getMessage());
        }
    }

    public void startFindOdds() {
        LOG.info("invoked...");

        downloadZip();

        ObjectMapper mapper = new ObjectMapper();
        try {
            BettingBaseJSON jsonBet = mapper.readValue(new File(inputJsonFile), BettingBaseJSON.class);

            List<S> sportList = jsonBet.getS();

            Date date = new Date((long) jsonBet.getD() * 1000);

            for (S sportInstance : sportList) {

                LOG.info("sportInstance.getN: " + sportInstance.getN());
                System.out.println("File date: " + date.toString());

                List<C> regionList = sportInstance.getC();

                for (C regionInstance : regionList) {

                    List<L> ligaList = regionInstance.getL();

                    for (L ligaInstance : ligaList) {

                        List<E> eventList = ligaInstance.getE();

                        for (E eventInstance : eventList) {

                            List<M> marketList = eventInstance.getM();

                          
                             LinkedHashMap<String, Float> oddsMap = new LinkedHashMap<String, Float>();
                            for (M marketInstance : marketList) {

                                //Belépett az összes piacra..
                                List<B> bookMakerList = marketInstance.getB();
                                //leszedi az osszes bookmakert

                                for (B bookmakerInstance : bookMakerList) {

                                    //elkezdi nezni a bookmakereket
                                    List<O> OddsList = bookmakerInstance.getO();

                                   
                                    

                                    for (O oddsInstance : OddsList) {

                                     
                                        Tipbet tipLine = new Tipbet();
                                        tipLine.setEventId(BigInteger.valueOf(eventInstance.getI()));
                                        tipLine.setPlayerTeams(eventInstance.getT1() + " vs. " + eventInstance.getT2());
                                        tipLine.setEventId(eventInstance.getDT());
                                        tipLine.setMarketTypeId(BigInteger.valueOf(marketInstance.getI()));
                                        tipLine.setMarketIndicate(marketInstance.getH());
                                        tipLine.setOddsValue(BigDecimal.valueOf(oddsInstance.getV().floatValue()));
                                        tipLine.setWhoWon(oddsInstance.getN());
                                        tipLine.setBookmakerId(BigInteger.valueOf(bookmakerInstance.getI()));
                                        
                                        em.persist(tipLine);
                                        em.flush();
                                        
                                        System.out.println("Kész: " + eventInstance.getI());
                                        
                                        /*
                                        System.out.println("---------------");
                                        System.out.println("OddsList size: " + OddsList.size());
                                        System.out.println("esemeny ID: " + eventInstance.getI());
                                        System.out.println("esemeny neve: " + eventInstance.getT1() + " vs. " + eventInstance.getT2());
                                        System.out.println("esemeny SC: " + eventInstance.getSC());
                                        System.out.println("esemeny SCE: " + eventInstance.getSCE());
                                        System.out.println("esemeny getA: " + eventInstance.getA());
                                        System.out.println("esemeny getPR: " + eventInstance.getPR());
                                        System.out.println("esemeny getDT: " + eventInstance.getDT());
                                        System.out.println("esemeny getISH: " + eventInstance.getISH());
                                        System.out.println("esemeny getMN: " + eventInstance.getMN());

                                        System.out.println();

                                        System.out.println("bookmaker id: " + bookmakerInstance.getI());
                                        System.out.println("bookmaker btdt: " + bookmakerInstance.getBTDT());
                                        System.out.println("piac getH: " + marketInstance.getH());
                                        System.out.println("piac getK: " + marketInstance.getK());
                                        System.out.println("piac getI: " + marketInstance.getI());
                                        System.out.println("odds neve: " + oddsInstance.getN());
                                        
                                        System.out.println("odds értéke: " + oddsInstance.getV());
                                        System.out.println("÷÷÷÷÷÷÷÷÷÷÷÷÷÷÷÷");
                                                */
                                    }
                                }

                                //System.out.println("**************************");
                               // System.out.println("max érték: " + maxValue + " ezen a piacon: " + marketInstance.getK() + " esemeny neve: " + eventInstance.getT1() + " vs. " + eventInstance.getT2());
                                //System.out.println("**************************");
                                
                            }

                        }

                    }
                }

            }

        } catch (Exception ex) {
            Logger.getLogger(BetFinderEJB.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void persist(Object object) {
        em.persist(object);
    }
}
