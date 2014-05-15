package calc;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 * Created by Alexander on 15.05.14.
 */
@Path("/rest")
public class CalcService {

    @GET
    @Path("/calculate")
    @Produces("text/plain")
    public String calculate(){
        return "Service executed";
    }
}
