<!DOCTYPE html>
<html>
<body>
      <font color = "#0000ff">一、网站简介</font><br/>
      &nbsp;Author:${author}<br/>
      &nbsp;Description:${description}<br/><br/>

      <font color = "#0000ff">二、网站链接<br/></font>
      &nbsp;1.<a href="http://www.jianshu.com/p/23bea93e34c7">使用Spring Boot开发WEB页面</a><br/>
      &nbsp;2.<a href="http://${ip}:${port}/api-docs">查看接口测试页</a><br/>
      &nbsp;3.<a href="http://${ip}:${port}/swagger/index.html">接口文档</a><br/><br/><br/>

      <font color = "#0000ff">三、注册</font>
      <form action="http://${ip}:${port}/user/register" method="get">
        &nbsp;账号: <input type="text" name="userName" /><br/><br/>
        &nbsp;密码: <input type="text" name="password" />&nbsp;&nbsp;<input type="submit" value="注册" />
      </form>
      <br/>

      <font color = "#0000ff">四、登录</font>
      <form action="http://${ip}:${port}/user/login" method="get">
        &nbsp;账号: <input type="text" name="userName" /><br/><br/>
        &nbsp;密码: <input type="text" name="password" />&nbsp;&nbsp;<input type="submit" value="登录" />
      </form>

</body>
</html>