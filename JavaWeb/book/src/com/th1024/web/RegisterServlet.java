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
 * @create 2021-03-23 21:47
 */
public class RegisterServlet extends HttpServlet {
    private UserService service = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1. 获取请求参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String code = req.getParameter("code");

        //2. 检查验证码是否正确--目前要求验证码为abcde
        if("abcde".equalsIgnoreCase(code)){
            //3. 检查用户名是否可用
            if(service.existsUsername(username)){
                System.out.println("用户名“" + username + "”已存在");
                //跳转至注册页面
                req.getRequestDispatcher("/pages/user/regist.html").forward(req,resp);
            }else{
                //用户名可用，调用UserService实现类的方法将数据保存至数据库
                service.registerUser(new User(null,username,password,email));
                //跳转至注册成功页面
                req.getRequestDispatcher("/pages/user/regist_success.html").forward(req,resp);
            }
        }else{
            System.out.println("验证码“" + code + "”错误");
            req.getRequestDispatcher("/pages/user/regist.html").forward(req,resp);
        }
    }
}
