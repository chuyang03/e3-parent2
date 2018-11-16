package cn.e3mall.controller;

import cn.e3mall.pojo.EasyUITreeNode;
import cn.e3mall.service.ItemCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ItemCatController {
    @Autowired
    private ItemCatService itemCatService;

    @RequestMapping("/item/cat/list")
    @ResponseBody
    public List<EasyUITreeNode> getItemCatList(
            //如果方法内参数名不是"id"，那么需要使用@RequestParam来指定名字为id，还可以设置默认值为0
            @RequestParam(name = "id",defaultValue = "0")long parentId){

        //调用服务查询节点列表
        List<EasyUITreeNode> itemCatList = itemCatService.getItemCatList(parentId);

        return itemCatList;
    }
}
