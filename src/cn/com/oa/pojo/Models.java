package cn.com.oa.pojo;

// 模块表
public class Models {
    private int modelId;  // 主键
    private String modelName;  // 模块名称
    private String modelUrl;  // 模块路径
    private String description;  // 模块描述
    private String parentId;  // 父模块Id
    
    public int getModelId() {
        return modelId;
    }
    public void setModelId(int modelId) {
        this.modelId = modelId;
    }
    public String getModelName() {
        return modelName;
    }
    public void setModelName(String modelName) {
        this.modelName = modelName;
    }
    public String getModelUrl() {
        return modelUrl;
    }
    public void setModelUrl(String modelUrl) {
        this.modelUrl = modelUrl;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getParentId() {
        return parentId;
    }
    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

}
