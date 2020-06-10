package cn.com.oa.pojo;

import java.util.List;

public class Organization {

    private String name;
    private String url;
    private List<?> contents;
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public List<?> getContents() {
        return contents;
    }
    public void setContents(List<?> contents) {
        this.contents = contents;
    }
    
       
}
