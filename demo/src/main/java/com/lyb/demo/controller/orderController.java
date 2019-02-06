package com.lyb.demo.controller;

import com.github.pagehelper.PageHelper;
import com.lyb.demo.mapper.OrderMapper;
import com.lyb.demo.mapper.RoomMapper;
import com.lyb.demo.model.Order;
import com.lyb.demo.model.TableSplitResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;


/**
 * 订单控制层
 * lyb
 */
@Controller
public class orderController {
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private RoomMapper roomMapper;

    /**
     * 获取所有订单
     * 2019.2.1
     * lyb
     * @return
     */
    @GetMapping(value = "/order/all")
    @ResponseBody
    public List<Order> allOrder(){
        return orderMapper.selectAll();
    }
    /**
     * 修改订单状态，设置订单为已付款
     * 2019.2.1
     * lyb
     */
    @GetMapping(value = "/order/update/pay/{id}")
    @ResponseBody
    public int updatePayById(@PathVariable("id") String id){
        return orderMapper.updatePay(id);
    }
    /**
     * 后台增加订单
     * 暂时去掉
     * 2019.2.3
     */
    @PostMapping(value = "/order/add")
    @ResponseBody
    public String  addOrder(@RequestParam("username") String name, @RequestParam("inttime")String inttime, @RequestParam("outtime")String outtime,@RequestParam("roomtype") String roomtype
    ,@RequestParam("monney") int monney,@RequestParam("roomNum") String roomNum){
        Order order=new Order();
        String maxId = orderMapper.findMaxId();
        Integer maxid=Integer.parseInt(maxId)+1;
        order.setId(maxid.toString());
        order.setUsername(name);
        order.setIntime(inttime);
        order.setOuttime(outtime);
        order.setRoomnum(roomNum);
        order.setRoomtype(roomtype);
        order.setMonney(monney);
        order.setPayif(1);
        roomMapper.updateRoomStatus(roomNum);
        if(orderMapper.insert(order)==1){
            return "1";
        }else
        {
            return "0";
        }
    }

    /**
     * 订单分页
     * lyb
     * @param offset
     * @param limit
     * @return
     */
    @GetMapping(value = "/order/page")
    @ResponseBody
    public TableSplitResult<List<Order>> getorderByPage(@RequestParam("offset") int offset, @RequestParam("limit") int limit){
        List<Order> list0=orderMapper.selectAll();
        int size=list0.size();
        int offset2=offset/limit+1;//注意，一定要加1
        PageHelper.startPage(offset2,limit);//offset是第几页，limit是页面大小
        List<Order> list=orderMapper.selectAll();
        TableSplitResult<List<Order>> list1=new TableSplitResult<>();
        list1.setRows(list);
        list1.setPage(1);
        list1.setTotal(size);
        return list1;

    }

    /**
     * 前台客户预定房间
     * @param name
     * @param intTime
     * @param outTime
     * @param roomtype
     * @return
     */
    @PostMapping(value = "/orderFront/add")
    @ResponseBody
    public int addOrderByfront(@RequestParam("username") String name, @RequestParam("inttime")String intTime, @RequestParam("outtime")String outTime,@RequestParam("roomtype") String roomtype
            ){
        Order order=new Order();
        String maxId = orderMapper.findMaxId();
        Integer maxid=Integer.parseInt(maxId)+1;
        order.setId(maxid.toString());
        order.setUsername(name);
        order.setIntime(intTime);
        order.setOuttime(outTime);
        order.setRoomtype(roomtype);
        order.setRoomnum("0");
        order.setMonney(0);
        order.setPayif(0);
        if(orderMapper.insert(order)==1){

            return 1;
        }
        else
        {
            return 0;
        }
    }
    /**
     * 订单删除
     */
    @GetMapping(value = "/order/delete/{id}")
    @ResponseBody
    public int deleteOrderById(@PathVariable("id") String id){
        return orderMapper.deleteOrderById(id);
    }


}
