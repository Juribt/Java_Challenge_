package ru.yuri.soap;

import net.webservicex.GeoIP;
import net.webservicex.GeoIPService;
import org.testng.annotations.Test;


import static org.testng.Assert.assertEquals;

/**
 * Created by bilovyur on 29.04.2017.
 */
public class GeoIPServiceTests {

@Test
    public void testMyIp(){
    GeoIP  geoIP = new GeoIPService().getGeoIPServiceSoap12().getGeoIP("91.216.66.117");
    assertEquals(geoIP.getCountryCode(),"RUS");
    }

    @Test
    public void testMyIp_Fault(){
        GeoIP  geoIP = new GeoIPService().getGeoIPServiceSoap12().getGeoIP("91.216.66.xxx");
        assertEquals(geoIP.getCountryCode(),"RUS");
    }

}
