package hello.springstart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model) {
        model.addAttribute("name", name);
        return "hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody
    public String helloString(@RequestParam("name") String name) {
        return "hello " + name;
    }

    @GetMapping("hello-api")
    @ResponseBody
    // 객체 반환, @ResponseBody 하면 거의 무조건 json 형식으로 넘어감
    // 객체를 반환한다는게 api 방법의 핵심?인 것 같네요
    public Hello helloApi(@RequestParam("name") String name) {
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }
    static class Hello {
        private String name;

        // alt + Fn + Insert = generate(for getter & setter)
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
