package com.wp.nz.entity;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import com.wp.nz.util.Strings;
import com.wp.nz.util.DateUtils;

@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public class AbstractEntity implements Serializable{

    private static final long serialVersionUID = 6653955509582889287L;

    @Id
    @Column(name="id", length=64)
    protected String id;			//主键 id
    @Column
    protected long cts;				//创建时间
    @Column(length=30)
    protected String ctsStr;		//时间戳,例如 2017-08-22 10:54:00
    @Column
    protected long updateTs ;		//更新时间,数据只要更新，就得维护改字段
    @Column
    protected Integer flag=0 ;  	//0表正常 1表删除
    @Column
    protected String delTs;  		//删除时间
    @Column
    protected int sort;				//排序
    @Column(length=500)
    protected String remark;    	//备注

    public AbstractEntity() {
        autoGenerateTime();
        setId();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String setId(){
        String _id = Strings.UUID();
        setId(_id);
        return _id;
    }

    public long getCts() {
        return cts;
    }

    public void setCts(long cts) {
        this.cts = cts;
    }

    public String getCtsStr() {
        return ctsStr;
    }

    public void setCtsStr(String ctsStr) {
        this.ctsStr = ctsStr;
    }

    public long getUpdateTs() {
        return updateTs;
    }

    public void setUpdateTs(long updateTs) {
        this.updateTs = updateTs;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public String getDelTs() {
        return delTs;
    }

    public void setDelTs(String delTs) {
        this.delTs = delTs;
    }

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * 自动生成指定时间
     * @param time
     */
    public void autoGenerateTime(long time) {
        setCts(time);
        setCtsStr(DateUtils.timeFormat(time));
        setUpdateTs(time);
    }
    /**
     * 自动生成时间
     * @param time
     */
    public void autoGenerateTime() {
        autoGenerateTime(System.currentTimeMillis());
    }

}

