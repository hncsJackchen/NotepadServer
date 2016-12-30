<!DOCTYPE html>
<html>
<body>
      <font color = "#0000ff">一、网站简介</font><br/>
      Author:${author}<br/>
      Description:${description}<br/><br/>

      <font color = "#0000ff">二、网站链接<br/></font>
      <a href="http://www.jianshu.com/p/23bea93e34c7">1.使用Spring Boot开发WEB页面</a><br/><br/><br/>

      <font color = "#0000ff">三、注册</font>
      <form action="http://${ip}:8080/user/register" method="get">
        账号: <input type="text" name="userName" /><br/><br/>
        密码: <input type="text" name="password" />&nbsp;&nbsp;<input type="submit" value="注册" />
      </form>
      <br/>

      <font color = "#0000ff">四、登录</font>
      <form action="http://${ip}:8080/user/login" method="get">
        账号: <input type="text" name="userName" /><br/><br/>
        密码: <input type="text" name="password" />&nbsp;&nbsp;<input type="submit" value="登录" />
      </form>


</body>
</html>