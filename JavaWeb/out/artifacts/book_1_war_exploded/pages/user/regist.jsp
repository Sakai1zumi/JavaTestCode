<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>尚硅谷会员注册页面</title>
	<%--静态包含base标签、css样式、jQuery引用等--%>
	<%@ include file="/pages/common/head.jsp"%>
	<script type="text/javascript">
		//页面加载完成之后
		$(function () {
			//给注册绑定单击事件
			$("#sub_btn").click(function () {
				//验证用户名：必须由字母、数字、下划线组成，长度为5到12位
				//1. 获取用户名输入框的内容
				var usernameValue = $("#username").val();
				//2. 创建正则表达式对象
				var usernamePatt = /^\w{5,12}$/;
				//3. 使用test方法验证
				if(!usernamePatt.test(usernameValue)){
					$("span.errorMsg").text("用户名不合法！");
					return false;
				}

				//验证密码：必须由字母、数字、下划线组成，长度为5到12位
				//1. 获取用户名输入框的内容
				var passwordValue = $("#password").val();
				//2. 创建正则表达式对象
				var passwordPatt = /^\w{5,12}$/;
				//3. 使用test方法验证
				if(!passwordPatt.test(passwordValue)){
					$("span.errorMsg").text("密码不合法！");
					return false;
				}

				//验证确认密码：和上一步输入的密码相同
				var repwdValue = $("#repwd").val();
				if(repwdValue != passwordValue){
					$("span.errorMsg").text("密码输入不一致！");
					return false;
				}

				//验证邮箱：xxxxx@xxx.com
				//1. 获取邮箱输入框的内容
				var emailValue = $("#email").val();
				//2. 创建正则表达式对象
				var emailPatt = /^[a-z\d]+(\.[a-z\d]+)*@([\da-z](-[\da-z])?)+(\.{1,2}[a-z]+)+$/;
				if(!emailPatt.test(emailValue)){
					$("span.errorMsg").text("邮箱格式不合法！");
					return false;
				}

				//验证验证码：只需要验证用户已输入
				//1. 获取验证码输入框的内容
				var codeValue = $("#code").val();
				//2. 去除验证码前后空格
				codeValue = $.trim(codeValue);
				//3. 验证验证码
				if(codeValue == null || codeValue == ""){
					$("span.errorMsg").text("验证码不能为空！");
					return false;
				}

				//正确输入后去除错误信息
				$("span.errorMsg").text("");
			});
		});
	</script>
	<style type="text/css">
		.login_form{
			height:420px;
			margin-top: 25px;
		}

	</style>
</head>
<body>
		<div id="login_header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
		</div>
		
			<div class="login_banner">
			
				<div id="l_content">
					<span class="login_word">欢迎注册</span>
				</div>
				
				<div id="content">
					<div class="login_form">
						<div class="login_box">
							<div class="tit">
								<h1>注册尚硅谷会员</h1>
								<span class="errorMsg">
									${requestScope.msg}
								</span>
							</div>
							<div class="form">
								<form action="userServlet" method="post">
									<input type="hidden" name="action" value="register">
									<label>用户名称：</label>
									<input class="itxt" type="text" placeholder="请输入用户名" autocomplete="off" tabindex="1" name="username" id="username"
									value="${requestScope.username}"/>
									<br />
									<br />
									<label>用户密码：</label>
									<input class="itxt" type="password" placeholder="请输入密码" autocomplete="off" tabindex="1" name="password" id="password"
									value="${requestScope.password}"/>
									<br />
									<br />
									<label>确认密码：</label>
									<input class="itxt" type="password" placeholder="确认密码" autocomplete="off" tabindex="1" name="repwd" id="repwd"
									value="${requestScope.password}"/>
									<br />
									<br />
									<label>电子邮件：</label>
									<input class="itxt" type="text" placeholder="请输入邮箱地址" autocomplete="off" tabindex="1" name="email" id="email" \
									value="${requestScope.email}"/>
									<br />
									<br />
									<label>验证码：</label>
									<input class="itxt" type="text" style="width: 150px;" name="code" id="code"/>
									<img alt="" src="static/img/code.bmp" style="float: right; margin-right: 40px">
									<br />
									<br />
									<input type="submit" value="注册" id="sub_btn" />
									
								</form>
							</div>
							
						</div>
					</div>
				</div>
			</div>
		<%--静态包含页脚信息--%>
		<%@ include file="/pages/common/footer.jsp"%>
</body>
</html>