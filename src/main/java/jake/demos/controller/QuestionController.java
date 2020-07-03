package jake.demos.controller;

import jake.demos.http.response.BaseResponse;
import jake.demos.http.vo.Question;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.time.LocalDateTime;

/**
 * Created by Jake.lin on 2020/06/23
 */
@Controller
@RequestMapping("/questions")
public class QuestionController {

    /**
     * 指定题目信息
     */
    @GetMapping("/{id}")
    public ResponseEntity<Question> getQuestion(@PathVariable Integer id) {
        BaseResponse<Question> response = new BaseResponse<>();
        Question question = new Question();
        question.setText("描述一下");
        question.setTitle("spring中bean的生命周期");
        question.setCreateTime(LocalDateTime.now());
        question.setId(id);
        response.setRecord(question);
        return response.ok();
    }

    /**
     * 删除题目
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Question> removeQuestion(@PathVariable Integer id) {
        return new BaseResponse<Question>().ok();
    }

    /**
     * 查询 多条件
     */
    @GetMapping("")
    public ResponseEntity<Question> listQuestion(@RequestParam(required = false) String title,
                                                 @RequestParam(required = false) Integer id) {
        return new BaseResponse<Question>().ok();
    }

}
