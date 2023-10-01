package hello.springstart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {
    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data", "hello!!");
        return "hello"; // templates에 있는 hello 파일을 의미
        // 'resources:templates/'+{ViewName}+'.html'
        // spring-boot-devtools 라이브러리 추가하면
        // html 파일 컴파일 시 서버 재시작 없이 뷰파일 변경 가능

        // 빌드하는거.. clean build 하면 빌드 파일 지우고 다시 생성함
        // clean이 빌드 파일 지우는거
    }
}
