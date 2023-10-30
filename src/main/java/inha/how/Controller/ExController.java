package inha.how.Controller;
import inha.how.Config.BaseResponse;
import inha.how.Domain.dto.Excercise.ExRes;
import inha.how.Service.ExService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/ex")
@RequiredArgsConstructor
@RestController
public class ExController {

    private final ExService exService;

    /*
    @GetMapping("")
    public BaseResponse<ExRes> ExDetails(@RequestParam Long tagId){
        ExRes exRes = exService.findEx(tagId);
        return new BaseResponse<>(exRes);
    }

     */


}
