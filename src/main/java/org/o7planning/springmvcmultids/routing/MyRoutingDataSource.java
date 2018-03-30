package org.o7planning.springmvcmultids.routing;
 
import javax.servlet.http.HttpServletRequest;
 
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
 
// This is a DataSource.
public class MyRoutingDataSource extends AbstractRoutingDataSource {
 
    @Override
    protected Object determineCurrentLookupKey() {
 
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
 
        // See more: DataSourceInterceptor
        String keyDS = (String) request.getAttribute("keyDS");
 
        System.out.println("KeyDS=" + keyDS);
 
        if (keyDS == null) {
            keyDS = "PUBLISHER_DS";
        }
 
        return keyDS;
    }
 
}