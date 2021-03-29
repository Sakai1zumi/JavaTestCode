package com.th1024.web;

import com.th1024.pojo.User;
import com.th1024.service.UserService;
import com.th1024.service.impl.UserServiceImpl;
import com.th1024.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author TuHong
 * @create 2021-03-26 16:07
 */
public class UserServlet extends BaseServlet {

    private UserService userService = new UserServiceImpl();

    /**
     * 处理登录业务的方法
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1. 获取请求参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        //2. 调用UserService实现类的方法处理登陆业务
        User loginUser = userService.login(new User(null,username, password,null));
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

    /**
     * 处理注册业务的方法
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void register(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1. 获取请求参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String code = req.getParameter("code");

        User user = WebUtils.copyParamToBean(req.getParameterMap(), new User());

        //2. 检查验证码是否正确--目前要求验证码为abcde
        if("abcde".equalsIgnoreCase(code)){
            //3. 检查用户名是否可用
            if(userService.existsUsername(username)){
                System.out.println("用户名“" + username + "”已存在");
                //将回显的信息，保存到request域中
                req.setAttribute("msg","用户名已存在");
                req.setAttribute("username",username);
                req.setAttribute("password",password);
                req.setAttribute("email",email);
                //跳转至注册页面
                req.getRequestDispatcher("/pages/user/regist.jsp").forward(req,resp);
            }else{
                //用户名可用，调用UserService实现类的方法将数据保存至数据库
                userService.registerUser(user);
                //跳转至注册成功页面
                req.getRequestDispatcher("/pages/user/regist_success.jsp").forward(req,resp);
            }
        }else{
            System.out.println("验证码“" + code + "”错误");
            //将回显的信息，保存到request域中
            req.setAttribute("msg","验证码错误");
            req.setAttribute("username",username);
            req.setAttribute("password",password);
            req.setAttribute("email",email);
            req.getRequestDispatcher("/pages/user/regist.jsp").forward(req,resp);
        }
    }


}
