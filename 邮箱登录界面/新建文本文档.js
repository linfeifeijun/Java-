function check()
{
var n=document.getElementById("user").value;
var m=document.getElementById("password").value;
if
(n=="tom"&&m=="123")
{
    window.open("http://mail.swpu.edu.cn/");
}
else if
(n.length==0||password.length==0)
{
    alert("请填写用户名与密码");
}
else
{
    alert("用户名或密码错误");
}
}