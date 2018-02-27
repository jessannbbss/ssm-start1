package com.seecen.entity;



import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by jessann on 2018/1/19.
 */
@Component
public class Page<T>  {
    private  int currentPage=1;//当前页
    private  int pageSize = 20;//每页显示数量
    private int total;//总记录数
    //开始 0-2 2-4 4-6
   public int getStart(){
        return (currentPage-1)*pageSize;
    }
    //结束
    public   int getEnd(){
        return currentPage*pageSize;
    }
    //数据集合
    private List list;
    //存储对象
    private T condition;



    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;

    }

    public T getCondition() {
        return condition;
    }

    public void setCondition(T condition) {
        this.condition = condition;
    }

    //总页数
    public int getPageTotal(){
        return (int)Math.ceil(total*1.0/pageSize);
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }


}
