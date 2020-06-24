package jake.demos.controller;

import jake.demos.http.vo.Topic;
import jake.demos.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Jake.lin on 2020/06/24
 */
@Controller
@RequestMapping("/topic")
public class TopicController {
    @Autowired
    private TopicService forumService;

    /**
     * 查询所有帖子
     */
    @GetMapping("")
    public ResponseEntity<Topic> listTopic() {
        return forumService.listTopic().ok();
    }
}
