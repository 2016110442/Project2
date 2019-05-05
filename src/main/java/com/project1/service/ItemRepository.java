package com.project1.service;

import com.project1.service.model.Item;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

    /*
    *Spring Data 的强大之处，就在于你不用写任何DAO处理，自动根据方法名或类的信息进行CRUD操作。
    * 只要你定义一个接口，然后继承Repository提供的一些子接口，就能具备各种基本的CRUD功能。
    * 需要定义接口，然后继承它就OK了。
    *
    * */

public interface ItemRepository extends ElasticsearchRepository<Item,Long> {
    /**
     * 根据价格区间查询
     */


}
