package com.wzz.qq.DTO.ProxyPinReportDTO;
import lombok.Data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;
import java.util.Map;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProxyPinReportDTO {
    private String startedDateTime;
    private Long time;
    private RequestDTO request;
    private ResponseDTO response;
    private Map<String, Object> timings; // timings 结构通常较多变，可用 Map 接收

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class RequestDTO {
        private String method;
        private String url;
        private String httpVersion;
        private List<NameValuePair> cookies;
        private List<NameValuePair> headers;
        private List<NameValuePair> queryString;
        private Long headersSize;
        private Long bodySize;
        private PostDataDTO postData;
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class ResponseDTO {
        private Integer status;
        private String statusText;
        private String httpVersion;
        private List<NameValuePair> cookies;
        private List<NameValuePair> headers;
        private ContentDTO content;
        private String redirectURL;
        private Long headersSize;
        private Long bodySize;
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class PostDataDTO {
        private String mimeType;
        private String text;
        private List<Map<String, Object>> params;
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class ContentDTO {
        private Long size;
        private String mimeType;
        private String text;
    }

    @Data
    public static class NameValuePair {
        private String name;
        private String value;
    }
}