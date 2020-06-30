package jake.demos.http.request;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Jake.lin on 2020/06/30
 */
public class BaseSearchRequest {
    @JsonProperty("page_index")
    private Integer pageIndex = 1;
    @JsonProperty("page_size")
    private Integer pageSize = 10;

    public Integer getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(Integer pageIndex) {
        this.pageIndex = pageIndex;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
