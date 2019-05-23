package com.lyb.demo.controller;
import com.lyb.demo.mapper.ManageMapper;
import com.lyb.demo.mapper.MyFileMapper;
import com.lyb.demo.mapper.OrderMapper;
import com.lyb.demo.mapper.StudentMMapper;
import com.lyb.demo.model.Manage;
import com.lyb.demo.model.MyFile;
import com.lyb.demo.model.responseBo;
import com.lyb.demo.util.Dateutil;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Controller
public class textController {
    @Autowired
    private ManageMapper manageMapper;
    @Autowired
    private StudentMMapper studentMapper;
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private MyFileMapper fileMapper;
    @Autowired
//    @GetMapping(value = "/")
//    public String login(){
//        return "prosceniumIndex";
//    }
    @GetMapping(value = "/index")
    public String index(){
        return "prosceniumIndex";
    }
    @GetMapping(value = "/login1")
    public String login1(){
        return "welcome";
    }
    @GetMapping(value = "/manage/student")
    public String manageStudent1(){
        return "studentList";
    }
    @GetMapping(value = "/user")
    public String user(){
        return "user";
    }
    @GetMapping(value = "/dashboard")
    public String dashboard(){
        return "dashboard";
    }
    @GetMapping(value = "/maps")
    public String maps(){
        return "maps";
    }
    @GetMapping(value = "/upgrade")
    public String upgrade(){
        return "upgrade";
    }
    @GetMapping(value = "/typography")

    public String typography(){
        return "typography";
    }
    @GetMapping(value = "/template")
    public String template(){
        return "template";
    }
    @GetMapping(value = "/table")
    public String table(){
        return "table";
    }
    @GetMapping(value = "/notifications")
    public String notifications(){
        return "notifications";
    }
    @GetMapping(value = "/icons")
    public String icons(){
        return "icons";
    }
    @GetMapping(value = "/1")
    public String icons1(){
        return "thetext";
    }
    @GetMapping(value = "/test/ajax")
    public String ajax(){
        return "testAjax";
    }







    /**
     * 管理员登录
     * lyb
     * 未完善
     * @param username
     * @param password
     * @return
     */
    @PostMapping(value = "/login")
    @ResponseBody
    public responseBo login1(@RequestParam("userName") String username,@RequestParam("password") String password,HttpServletResponse response,HttpServletRequest request)throws Exception{
        responseBo res=new responseBo();
        Manage manage=manageMapper.selectByName(username);
        String password1=manageMapper.selectPassword(username);
        /*response.setContentType("text/html;charset=utf-8");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();*/
        if(password1.equals(password)){
            /*request.getSession().setAttribute("users",username);
            request.getSession().setMaxInactiveInterval(10);*/
            /*out.print("<script language=\"javascript\">alert('登录成功了');window.location.href='/notifications'</script>");*/
            if(manage.getStatus()==0){
                res.setMessage("账号被锁定，请联系管理员");
                res.setStatus("-1");
                return res;
            }
            res.setStatus("1");
            return res;

        }
        else/* out.print("<script language=\"javascript\">alert('账号密码错误');window.location.href='/loging'</script>");*/
        {
           res.setStatus("0");
           res.setMessage("账号密码错误");
           return res;
        }
    }
    /*@GetMapping(value = "/logout")
    public String logout(HttpServletRequest httpServletRequest){
        HttpSession session=httpServletRequest.getSession();
        if(session!=null){
            session.invalidate();
            return "loging";
        }
        else
            return "error";

    }*/

    @GetMapping(value = "/login2")
    public String login2(){
        return "flase";
    }
   @GetMapping(value = "/manage/All")
    @ResponseBody
    public List<Manage> selectAll(){
        return manageMapper.selectAll();
    }

    /**
     * 获取当前时间
     * 已测试
     * lyb
     * @return
     */
    @GetMapping(value = "/getNowDate")
    @ResponseBody
    public String getNowDate(HttpServletRequest request){
       /* Object o=request.getSession().getAttribute("users");
        if(o!=null){
            return Dateutil.getDate();
        }
        else{
            return "请登录";
        }*/

           return Dateutil.getDate();


    }

    /**
     * 单文件上传
     * @param file
     * @return
     */
    @PostMapping(value = "/upload")
    @ResponseBody
    public String upload(MultipartFile file){

        String filename=file.getOriginalFilename();
//        String suffixname=filename.substring(filename.lastIndexOf("."));
//        filename= UUID.randomUUID()+suffixname;
        String filepath="C:/Users/86186/Desktop/testUploadFile/";
        String id=UUID.randomUUID().toString();
        MyFile thefile=new MyFile();
        thefile.setFilename(filename);
        thefile.setFilepath(filepath+filename);
        thefile.setId(id);

        try {
            file.transferTo(new File(filepath + filename));
            fileMapper.insert(thefile);
            return "上传成功";

        }catch(Exception e){
            e.printStackTrace();
            return "上传失败";
        }


    }

    /**
     * 下载文件接口
     * lyb
     * @param filename
     * @param request
     * @param response
     * @return
     */
    @GetMapping(value = "file/download/{filename}")
    @ResponseBody
    public String downloadFile(@PathVariable("filename")String filename, HttpServletRequest request, HttpServletResponse response) {
        String filepath = "C:/Users/86186/Desktop";
        File file = new File(filepath, filename);
        if (file.exists()) {
            response.setContentType("application/force-download");// 设置强制下载不打开
            response.addHeader("Content-Disposition", "attachment;fileName=" + filename);// 设置文件名
            byte[] buffer = new byte[1024];
            FileInputStream fis = null;
            BufferedInputStream bis = null;
            try {
                fis = new FileInputStream(file);
                bis = new BufferedInputStream(fis);
                OutputStream os = response.getOutputStream();
                int i = bis.read(buffer);
                while (i != -1) {
                    os.write(buffer, 0, i);
                    i = bis.read(buffer);
                }
                System.out.println("success");
                return "success";
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (bis != null) {
                    try {
                        bis.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (fis != null) {
                    try {
                        fis.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

        }
        return "failed";
    }
    /**
     * 获取session，将数据存进session中
     */
    @GetMapping(value="/session/test")
    @ResponseBody
    public void test(HttpServletRequest request,HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=utf-8");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        HttpSession session=request.getSession();
        session.setAttribute("session","linyongbin");
        session.setAttribute("session1","chengyu");
        out.print("<script language=\"javascript\">alert('登录成功了');window.location.href='/'</script>");
    }
    @GetMapping(value="/test/bool")
    @ResponseBody
    public boolean testbool(){
        Date date=new Date();
        if(date.getSeconds()>30){
            return true;
        }else
        {
            return false;
        }
    }
    /**
     * 向model中传值，前端进行访问
     */
    @ApiOperation(value="向model中传值，前端进行访问")
    @GetMapping(value = "/test/model")
    public String testModel(Model model){
        model.addAttribute("username","linyongbin");
        return "testAjax";
    }

    /**
     * 测试
     * 获得前端传过来的值，request中获取
     * @param httpServletRequest
     * @return
     */
    @ApiOperation(value = "获取前端传过来的参数")
    @GetMapping(value = "/test/request")
    @ResponseBody
    public String testRequest(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse){
        String name=httpServletRequest.getParameter("username");
        return name;
    }
    @GetMapping(value="/session/getUserName")
    @ResponseBody
    public String getUserNameBySession(HttpServletRequest request){
        HttpSession session=request.getSession();
//        String name=session.getAttribute("users").toString();
        return "name";
    }
    /**
     * 测试参数绑定
     * 测试成功
     */
    @PostMapping("test/parmeter")
    @ResponseBody
    public String testModel(Manage manage){
       try {
           System.out.println(manage.getId()+manage.getName());
           manageMapper.insertManage(manage);
           return "成功";
       }catch (Exception E){
           E.printStackTrace();
           return E.getMessage();
       }

    }

    /**
     * 测试使用ModelAndView进行视图返回
     * @return
     */
    @RequestMapping("/test/modelView/{id}")
    @ResponseBody
    public ModelAndView testModelView(@PathVariable("id") int id){
        ModelAndView modelAndView=new ModelAndView();
        if(id==1) {
            modelAndView.setViewName("index");
        }else{
            modelAndView.setViewName("/notifications");
        }
        return modelAndView;
    }



}
