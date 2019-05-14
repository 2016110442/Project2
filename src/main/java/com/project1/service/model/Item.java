package com.project1.service.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Document(indexName = "resume",type = "docs",shards = 1,replicas = 0)
public class Item {
    /*
    * @Document 作用在类,标记实体类为文档对象，一般有两个属性
    *indexName:对应索引名称
    * type：对应在索引库中的类型
    * shards：分片数量，默认5
    * replicas：副本数量，默认1
    * */


    /*
    * @Id  作用在成员变量，标记一个字段作为id主键
    * @Field   作用在成员变量，标记为文档的字段，并指定字段映射属性：
    *  type：字段类型，取值是枚举：FieldType
    *  [Keyword,Double,Text,Long,Attachment,Auto,Date,Float,....]
    *   Keyword 字段用来索引结构化的数据, 例如邮箱地址, 主机名, 状态码, 压缩码或者标签.Keyword 字段只能被精确查询
    *   text类型不能用来排序和聚合。
    *  index：是否索引，布尔类型，默认是true
    *  store：是否存储，布尔类型，默认是false
    *  analyzer：分词器名称 这里的ik_max_word即使用ik分词器
    * */


    @Id
    private Integer resumeId;

    @Field(type = FieldType.Integer)
    private String edate; //标题

    @Field(type = FieldType.Text, analyzer = "ik_max_word")
    private String event; //标题

    public Item(Integer resumeId, String edate, String event) {
        this.resumeId = resumeId;
        this.edate = edate;
        this.event = event;
    }

    public Item() {

    }


    public Integer getResumeId() {
        return resumeId;
    }

    public void setResumeId(Integer resumeId) {
        this.resumeId = resumeId;
    }

    public String getEdate() {
        return edate;
    }

    public void setEdate(String edate) {
        this.edate = edate;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }
}
