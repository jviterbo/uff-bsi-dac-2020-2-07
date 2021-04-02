/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.ejb.Stateless;

/**
 *
 * @author viter
 */
@Stateless
public class HelloBean implements HelloBeanLocal {

    public HelloBean() {

    }

    Date now;
    SimpleDateFormat sdf;

    @Override
    public String getHour() {

        now = new Date();
        sdf = new SimpleDateFormat("HH");
        String agora = sdf.format(now);
        return agora;
    }

    @Override
    public String getMinutes() {
        
        now = new Date();
        sdf = new SimpleDateFormat("mm");
        String agora = sdf.format(now);
        return agora;
    }

    @Override
    public String getShift() {

        now = new Date();
        sdf = new SimpleDateFormat("HH");
        String agora = sdf.format(now);
        
        switch(agora){
            case "00":
            case "01":
            case "02":
            case "03":
                return "madrugada";
            case "04":
            case "05":
            case "06":
            case "07":
            case "08":
            case "09":
            case "10":
            case "11":
                return "manhã";
            case "12":
            case "13":
            case "14":
            case "15":
            case "16":
            case "17":
                return "tarde";
            case "18":
            case "19":
            case "20":
            case "21":
            case "22":
            case "23":
                return "noite";
        }
        return "noite";
    }

    @Override
    public String getDay() {

        now = new Date();
        sdf = new SimpleDateFormat("dd");
        String agora = sdf.format(now);
        return agora;
    }

    @Override
    public String getMonth() {

        now = new Date();
        sdf = new SimpleDateFormat("MMMMM");
        String agora = sdf.format(now);
        return agora;
    }

    @Override
    public String getYear() {

        now = new Date();
        sdf = new SimpleDateFormat("yyyy");
        String agora = sdf.format(now);
        return agora;
    }

    @Override
    public String getWeekDay() {

        now = new Date();
        sdf = new SimpleDateFormat("EEEEEEEE");
        String agora = sdf.format(now);
        return agora;
    }

}
