package com.lyb.demo.controller;
import com.github.pagehelper.PageHelper;
import com.lyb.demo.mapper.StudentMMapper;
import com.lyb.demo.model.StudentM;
import com.lyb.demo.model.TableSplitResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * student控制层
 */
@Controller
public class StudentController {
    @Autowired
    private StudentMMapper studentMapper;
    /**
     * 查找所有student
     * @return
     */
    @GetMapping(value = "/student/All")
    @ResponseBody
    public List<StudentM> selectAllStud(){
        return studentMapper.selectAllM();
    }

    /**
     * 根据id查找student
     * @param id
     * @return
     */
    @GetMapping(value = "/student/{id}")
    @ResponseBody
    public StudentM selectStudById(@PathVariable("id") String id) {
        return studentMapper.selectByid(id);
    }

    /**
     * 插入student
     * lyb
     * @param name
     * @param password
     * @param adress
     * @param school
     * @param eron
     * @return
     */
    @PostMapping(value = "/student/add")
    @ResponseBody
    public Boolean addStudent(@RequestParam("name")String name, @RequestParam("password") String password, @RequestParam("adress")String adress, @RequestParam("school")String school,
                              @RequestParam("eron")String eron){
        StudentM studentM=new StudentM();
        String maxid=studentMapper.findMaxId();
        Integer maxIdInt=Integer.parseInt(maxid);
        Integer k=maxIdInt+1;
        String MaxId=k.toString();
        studentM.setId(MaxId);
        studentM.setName(name);
        studentM.setAdress(adress);
        studentM.setPassword(password);
        studentM.setEron(eron);
        studentM.setSchool(school);
//        Integer i=studentMapper.insert(studentM);
//        System.out.print(i);
        if((studentMapper.insert(studentM))==1){
            System.out.print("插入成功");
            return true;
        }else {
            System.out.print("插入失败");
            return false;
        }


    }

    /**
     * 学生分页查找（后期改为两个参数，一个起始页，一个数据量）
     * 2019.1.26
     * linyongbin
     * @param pagenum
     * @return
     */
    @GetMapping(value = "/studentByPage/{id}")
    @ResponseBody
    public List<StudentM> getStuByPage(@PathVariable("id") int pagenum){
        PageHelper.startPage(pagenum,2);
        return studentMapper.selectAllM();
    }
    /**
     * 根据id删除学生
     */
    @GetMapping(value = "student/delete/{id}")
    @ResponseBody
    public String  deleteStudById(@PathVariable("id")String id){
        Boolean b=studentMapper.deleteStudById(id);
        if(b){
            return "删除成功";
        }
        else{
            return "删除失败";
        }
    }

    /**
     * 返回bootstrap-table所要求的格式
     * @param
     * @return
     */
  /*  @GetMapping(value = "/studentByPage1/{id}")
    @ResponseBody
    public TableSplitResult<List<StudentM>> getStuByPage1(@PathVariable("id") int pagenum){
        PageHelper.startPage(pagenum,10);
        List<StudentM> list=studentMapper.selectAllM();
        TableSplitResult<List<StudentM>> list1=new TableSplitResult<>();
        list1.setRows(list);
        list1.setPage(1);
        list1.setTotal(list.size());
        return list1;
    }*/

    /**
     * 还有点不足，就是用了两次查询，后续再改
     * lyb
     * 2019.1.28
     * @param offset
     * @param limit
     * @return
     */
    @GetMapping(value = "/student/page")
    @ResponseBody
    public TableSplitResult<List<StudentM>> getstudentByPage(@RequestParam("offset") int offset,@RequestParam("limit") int limit){
        List<StudentM> list0=studentMapper.selectAllM();
        int size=list0.size();
        int offset1=offset/limit+1;//注意，一定要加1
        PageHelper.startPage(offset1,limit);//offset是第几页，limit是页面大小
        List<StudentM> list=studentMapper.selectAllM();
        TableSplitResult<List<StudentM>> list1=new TableSplitResult<>();
        list1.setRows(list);
        list1.setPage(1);
        list1.setTotal(size);
        return list1;

    }

}
