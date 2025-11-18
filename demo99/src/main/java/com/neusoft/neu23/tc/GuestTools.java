package com.neusoft.neu23.tc;

import com.neusoft.neu23.entity.Guest;
import com.neusoft.neu23.service.GuestService;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GuestTools {
    @Autowired
    private GuestService guestService;

    @Tool(description = "将客户的信息保存到数据库，并返回序列号。但必须收集客户的姓名和手机号")
    public String saveCustomerInfo(
            @ToolParam(description = "客户的姓名，参数name代表客户的姓名") String name,
            @ToolParam(description = "客户的电话号码，参数phone代表客户的电话号码") String phone) {
          Integer gid = guestService.addGuest(new Guest(null, name, phone));
        return gid+"";
    }


    @Tool(description = "根据客户的姓查询所有客户的信息")
    public List<Guest> listByLastName(
            @ToolParam(description = "客户的姓，参数lastName代表客户的姓") String lastName
            ) {
        return  guestService.listByLastName(lastName) ;
    }
}
