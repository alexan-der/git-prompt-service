package promptService.api.rest;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import promptService.api.exception.ApiError;

import javax.servlet.http.HttpServletRequest;

@Controller
public class CustomErrorController implements ErrorController {

    @RequestMapping("/error")
    @ResponseBody
    public ApiError handleError(HttpServletRequest request) {
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        Exception exception = (Exception) request.getAttribute("javax.servlet.error.exception");

        return new ApiError(statusCode, exception!=null?exception.getMessage():"");
    }

//    @RequestMapping("*")
//    @ResponseBody
//    public ApiError getFallback() {
//        return new ApiError(404, "No API function found.");
//    }

    @Override
    public String getErrorPath() {
        return "/error";
    }
}
