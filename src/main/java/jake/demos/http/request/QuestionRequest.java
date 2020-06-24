package jake.demos.http.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDateTime;

/**
 * Created by Jake.lin on 2020/06/23
 */
public class QuestionRequest {
    private Integer id;
    private String title;
    private String text;
    @JsonProperty("commit_time")
    private LocalDateTime commitTime;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LocalDateTime getCommitTime() {
        return commitTime;
    }

    public void setCommitTime(LocalDateTime commitTime) {
        this.commitTime = commitTime;
    }
}
