package cn.com.oa.util;

public class PageBean {

    private int pageNow;//当前页  
    private int totalSize;//总条数  
    private int totalPage;//总页数  
    private int pageSize;//每页显示条数  
    public PageBean(int pageNow,int totalSize){  
        //构造方法  
        this.setPageNow(pageNow);  
        this.setTotalSize(totalSize);     
    }  
    
    public PageBean(int pageNow,int totalSize,int pageSize){//可动态改变每页条数  
        //构造方法  
        this.setPageNow(pageNow);  
        this.setTotalSize(totalSize);     
        this.pageSize=pageSize;  
    }  
    
    public void setPageNow(int pageNow) {//得到当前页  
        this.pageNow = pageNow;  
    }  
    public int getPageNow() {  
        return pageNow;  
    }  
    public void setTotalSize(int totalSize) {//总条数   
        this.totalSize = totalSize;  
    }  
    public int getTotalSize() {  
        return totalSize;  
    }  
    public void setPageSize(int pageSize) {//每页显示条数  
        this.pageSize = pageSize;  
    }  
    public int getPageSize() {  
        return pageSize;  
    }  
    public int getTotalPage() {//总页数 = 总条数/每页显示条数  
        totalPage=(totalSize-1)/pageSize+1;
        return totalPage;  
    }  
    public void setTotalPage(int totalPage) {  
        this.totalPage = totalPage;  
    }  
    public boolean isHasPre() {//是否有上一页   除第一页以外都有上一页  说明有首页的就有上一页  
        if(this.pageNow>1 && this.pageNow<=this.totalPage){  
            return true;  
        }  
        else{ 
            return false; 
        }
    }  
    public void setHasPre(boolean hasPre) {  
        
    }  
    public boolean isHasNext() {//是否有下一页   除最后一页以外都有下一页  说明有尾页的就有下一页  
        if(this.pageNow>0 && this.pageNow<this.totalPage){  
            return true;  
        }  
        else{ 
            return false;
        }
    }  
    public void setHasNext(boolean hasNext) {
        
    }  
    /*public boolean isHasFirst() {//是否有首页 除第一页以外都有首页  
        if(this.pageNow==1){//是第一页就没有首页  
            return false;
        }
        else{  
            return true; 
        }
    }  
    public void setHasFirst(boolean hasFirst) {  
    }  */
    /*public boolean isHasLast() {//是否有尾页  除最后一页以外都有尾页  
        if(pageNow==this.getTotalPage()){//最后一页  
            return false;     
        }
        else{ 
            return true;  
        }
    }  
    public void setHasLast(boolean hasLast) {  
    }  */
}
