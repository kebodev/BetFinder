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
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.GZIPInputStream;
import javax.ejb.Stateless;
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
public class BetFinderEJB {

    private static final Logger LOG = Logger.getLogger(BetFinderEJB.class.getName());
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

                        BigInteger maxEventDate = BigInteger.valueOf(0);

                        for (E eventInstance : eventList) {

                            if (eventInstance.getDT().compareTo(maxEventDate) == 1) {
                                maxEventDate = eventInstance.getDT();
                                
                            }

                            List<M> marketList = eventInstance.getM();

                            for (M marketInstance : marketList) {

                                if (marketInstance.getK().equals("1x2")
                                        || marketInstance.getK().equals("1x2_H1")
                                        || marketInstance.getK().equals("1x2_H2")
                                        || marketInstance.getK().equals("EH_H1")
                                        || marketInstance.getK().equals("EH_H2")
                                        || marketInstance.getK().equals("FTS_3W_H1")
                                        || marketInstance.getK().equals("FTS_3W_H2")
                                        || marketInstance.getK().equals("FTS_3W")
                                        || marketInstance.getK().equals("EH")) {

                                    List<B> bookMakerList = marketInstance.getB();

                                    float maxHome = 0;
                                    float maxDraw = 0;
                                    float maxAway = 0;
                                    int homeBookMakerId = 0;
                                    int drawBookMakerId = 0;
                                    int awayBookMakerId = 0;

                                    for (B bookmakerInstance : bookMakerList) {

                                        List<O> OddsList = bookmakerInstance.getO();

                                        System.out.println("OddsList size: " + OddsList.size() );
                                        
                                        for (O oddsInstance : OddsList) {
                                            
                                          
                                            

                                            if (oddsInstance.getN().equals("1")) {
                                                //Home
                                                if (oddsInstance.getV() > maxHome) {
                                                    maxHome = oddsInstance.getV().intValue();
                                                    homeBookMakerId = bookmakerInstance.getI();
                                                }
                                            }
                                            if (oddsInstance.getN().equals("X")) {
                                                //Home
                                                if (oddsInstance.getV() > maxDraw) {
                                                    maxDraw = oddsInstance.getV().intValue();
                                                    drawBookMakerId = bookmakerInstance.getI();
                                                }

                                            }
                                            if (oddsInstance.getN().equals("2")) {
                                                //Home
                                                if (oddsInstance.getV() > maxAway) {
                                                    maxAway = oddsInstance.getV().intValue();
                                                    awayBookMakerId = bookmakerInstance.getI();;
                                                }
                                            }

                                        }
                                    }

                                    float homeCounter = (1 / maxHome) * 100;
                                    //System.out.println("homeCounter: " + homeCounter);
                                    float drawCounter = (1 / maxDraw) * 100;
                                    //System.out.println("drawCounter: " + drawCounter);
                                    float awayCounter = (1 / maxAway) * 100;
                                    //System.out.println("awayCounter: " + awayCounter);

                                    float successFactor = (homeCounter + drawCounter + awayCounter);
                                    int sumBetAmount = 100000;

                                    if (successFactor < 100) {

                                        
                                        
                                        System.out.println("------------------------");
                                        System.out.println("Bingo! :) ");
                                        System.out.println("File date: " + date.toString());
                                        System.out.println("Sport: " + sportInstance.getN());
                                        System.out.println("Regio: " + regionInstance.getN());
                                        System.out.println("Liga: " + ligaInstance.getN());
                                        System.out.println("Esemény: " + eventInstance.getT1() + " vs. " + eventInstance.getT2());
                                        System.out.println("Fogadás neve: " + marketInstance.getK());
                                        System.out.println("Fogadás neve H: " + marketInstance.getH());
                                        System.out.println("Fogadás neve I: " + marketInstance.getI());

                                        float betHome = sumBetAmount * (homeCounter / successFactor);
                                        float betDraw = sumBetAmount * (drawCounter / successFactor);
                                        float betAway = sumBetAmount * (awayCounter / successFactor);
                                        System.out.println("********");
                                        System.out.println("Összes tét: " + sumBetAmount);
                                        System.out.println("oddsHome: " + maxHome + " bookmaker: " + homeBookMakerId + " Ennyivel kell fogadni: " + betHome);
                                        System.out.println("oddsDraw: " + maxDraw + " bookmaker: " + drawBookMakerId + " Ennyivel kell fogadni: " + betDraw);
                                        System.out.println("oddsAway: " + maxAway + " bookmaker: " + awayBookMakerId + " Ennyivel kell fogadni: " + betAway);
                                        System.out.println("Nyeremény összege: " + ((maxHome * betHome) - sumBetAmount));
                                        System.out.println("********");

                                   }

                                }
                                Date dateEventMax = new Date((long) maxEventDate.intValue() * 1000);
                                    //System.out.println("Max date: " + dateEventMax.toString() + " sport name: " + sportInstance.getN() + "Market: " + marketInstance.getK());
                            }

                        }
                        
                        

                    }
                }

            }

        } catch (Exception ex) {
            Logger.getLogger(BetFinderEJB.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
