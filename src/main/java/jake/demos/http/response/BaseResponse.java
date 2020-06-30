package jake.demos.http.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.pagehelper.PageInfo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.Collection;

/**
 * Created by Jake.lin on 2020/06/23
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BaseResponse<T> {
    private T record;
    private Collection<T> records;
    @JsonProperty("records_paging")
    private PageInfo<T> recordsPaging;
    @JsonProperty("total_records")
    private Integer totalRecords;
    private String message;
    @JsonProperty("status_code")
    private Integer statusCode = HttpStatus.OK.value();

    public ResponseEntity<T> ok() {
        return new ResponseEntity(this, HttpStatus.OK);
    }

    public ResponseEntity<T> failed(String message, HttpStatus httpStatus) {
        this.message = message;
        this.statusCode = httpStatus.value();
        return new ResponseEntity(this, httpStatus);
    }

    public T getRecord() {
        return record;
    }

    public void setRecord(T record) {
        this.record = record;
    }

    public Collection<T> getRecords() {
        return records;
    }

    public void setRecords(Collection<T> records) {
        this.records = records;
    }

    public Integer getTotalRecords() {
        return totalRecords;
    }

    public void setTotalRecords(Integer totalRecords) {
        this.totalRecords = totalRecords;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public PageInfo<T> getRecordsPaging() {
        return recordsPaging;
    }

    public void setRecordsPaging(PageInfo<T> recordsPaging) {
        this.recordsPaging = recordsPaging;
    }
}
