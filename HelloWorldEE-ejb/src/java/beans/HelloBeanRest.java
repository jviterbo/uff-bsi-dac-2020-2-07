/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 *
 * @author viter
 */
@Path("hello")
public interface HelloBeanRest {
    
    @GET
    @Path("hour")
    public String getHour();

    @GET
    @Path("minutes")
    public String getMinutes();

    @GET
    @Path("shift")
    public String getShift();

    @GET
    @Path("day")
    public String getDay();

    @GET
    @Path("month")
    public String getMonth();

    @GET
    @Path("year")
    public String getYear();

    @GET
    @Path("weekday")
    public String getWeekDay();
    
}
