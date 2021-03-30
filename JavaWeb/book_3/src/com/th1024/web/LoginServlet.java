package com.th1024.web;

import com.th1024.pojo.User;
import com.th1024.service.UserService;
import com.th1024.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author TuHong
 * @create 2021-03-23 22:37
 */
public class LoginServlet extends HttpServlet {
    private UserService service = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1. 获取请求参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        //2. 调用UserService实现类的方法处理登陆业务
        User loginUser = service.login(new User(null,username, password,null));
        if(loginUser == null){
            //如果等于null，登陆失败，跳转回登陆界面
            //把错误信息和回显的表单项信息，保存到request域中
            req.setAttribute("msg","用户名或密码错误");
            req.setAttribute("username",username);
            //跳转回登陆页面
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req,resp);
        }else{
            //不等于null为登陆成功，跳转至登录成功页面
            req.getRequestDispatcher("/pages/user/login_success.jsp").forward(req,resp);
        }
    }
}
