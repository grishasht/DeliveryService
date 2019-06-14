package controller.command;

import model.service.RequestService;
import model.util.Constants;
import model.util.LogGenerator;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RemoveRequest implements Command {
    private Logger log = LogGenerator.getInstance();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter(Constants.REQ_ID);

        if (id != null) {
            RequestService.removeRequest(Integer.valueOf(id));
            log.info("Request " + id + " removed");
        } else {
            log.info("Error while removing request" + id);
            return "forward:/WEB-INF/errors/smth_wrong.jsp";
        }

        return "forward:/WEB-INF/user/my_requests.jsp";
    }
}
