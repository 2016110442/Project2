package com.project1.controller;

import com.project1.controller.viewobject.SetResuem;
import com.project1.dao.UserresumeDOMapper;
import com.project1.dataobject.UserresumeDO;
import com.project1.response.CommonReturnType;

import com.project1.service.ItemRepository;
import com.project1.service.model.Item;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@Controller("resume")
@RequestMapping("/resume")
public class EsController extends BaseController{

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private UserresumeDOMapper userresumeDOMapper;

    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;

    @GetMapping("/create")
    @ResponseBody
    public void contextLoads(){
        //org.springframework.data.elasticsearch.core
        elasticsearchTemplate.createIndex(Item.class);
        // 创建索引，会根据Item类的@Document注解信息来创建
        elasticsearchTemplate.putMapping(Item.class);
    }

//    @PostMapping("/saveresume")

    @RequestMapping(value = "/insertresume",method = {RequestMethod.POST})
    @ResponseBody

    public CommonReturnType save(@RequestBody SetResuem setResuem
                     ){

        for (UserresumeDO userresumeDO:setResuem.getResumeVOS()){
            userresumeDOMapper.insertSelective(userresumeDO);
            Item item = new Item();
            item.setResumeId(userresumeDO.getId());
            item.setEdate(userresumeDO.getEdate());
            item.setEvent(userresumeDO.getEvent());
            itemRepository.save(item);
        }
        return CommonReturnType.create(null);
    }

    @RequestMapping(value = "/deleteresume",method = {RequestMethod.POST},consumes = {CONTENT_TYPE_FORMED})
    @ResponseBody
    public CommonReturnType deleteresume(@RequestParam(name = "id") Integer id
    ){
        userresumeDOMapper.deleteByid(id);
        return CommonReturnType.create(null);
    }

//    @GetMapping("/getresume")
    @RequestMapping(value = "/selectresume",method = {RequestMethod.GET})
    @ResponseBody
    public CommonReturnType selectresume(@RequestParam(name = "str")String str){
        NativeSearchQueryBuilder builder = new NativeSearchQueryBuilder();
        builder.withQuery(
                QueryBuilders.fuzzyQuery("event",str)
        );
        Page<Item> page = this.itemRepository.search(builder.build());
        Set<Item> items = new HashSet<>();
//        for (Item item:page){
//            items.add(item);
//        }
        return CommonReturnType.create(page.getContent());
    }
}
