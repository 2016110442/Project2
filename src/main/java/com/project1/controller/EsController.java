package com.project1.controller;

import com.project1.service.ItemRepository;
import com.project1.service.model.Item;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.web.bind.annotation.*;

@RestController
public class EsController {

    @Autowired
    private ItemRepository itemRepository;

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

    @PostMapping("/saveresume")
    @ResponseBody
    public void save(
            @RequestParam(name = "id") Long id,
            @RequestParam(name = "text") String text
    ){
        Item item = new Item();
        item.setId(id);
        item.setText(text);
        itemRepository.save(item);
    }

    @GetMapping("/getresume")
    @ResponseBody
    public Page<Item> getItemByString(@RequestParam(name = "string")String string){
        NativeSearchQueryBuilder builder = new NativeSearchQueryBuilder();
        builder.withQuery(
                QueryBuilders.fuzzyQuery("text",string)
        );
        Page<Item> page = this.itemRepository.search(builder.build());
        for(Item item:page){
            System.out.println(item.getText());
        }
        return page;
    }
}
