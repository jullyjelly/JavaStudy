html
===
html是网页最基本的语言
+ 多数标签都有开始标签和结束标签，其中个别标签因为只有单一功能，或者没有要修饰的功能可以在标签内结束如\<br>
+ 标签中的属性可以对标签修饰的内容进行丰富的操作，通过对属性值得改变可增加更多的效果选择
+ 属性和属性之间用“=”连接
+ 格式：<标签名 属性名=‘属性值’>数据内容</标签名>  
<标签名 属性名=‘属性值’ />
+ 操作思想：为了操作数据，需要对数据进行不同的标签封装，通过标签中的属性对封装的数据进行操作。标签相当于一个容器操作容器中的数据就是在不断改变容器的属性值
```html
<html>
    <head>
        <title>网页的标题</title>
    </head>
    <body>
        首页显示的内容<br/>
        以下是首页<font size=5 color='red'>测试</font>
    </body>
</html>
```
`<br/>`行结束标识  
如今html一般只用来负责网页数据的标签封装，样式一般由css来完成  

常用方法
----  
可查阅参考手册[w3school](https://www.w3school.com.cn/html/index.asp)  

`dl`列表  
`dt`上层列表  
`dd`下层列表
```html
<html>
    <head>
        <title>网页的标题</title>
    </head>
    <body>
        <!--演示列表标签，用dl标签，
            列表内部有上层列表项dt和下层列表项dd，具备缩进的效果-->
        <dl>
           <dt>水果：</dt> 
           <dd>苹果</dd> 
            <dd>梨</dd>
            <dd>葡萄</dd> 
            <dd>橘子</dd>
        </dl>
        <!--项目符号列表(都具备缩进的效果)：
            有序<ol>(默认排序是1,2,3,4，可用type更改)
            无序<ul> type有circle，square,disc(默认)三种
            其中列表项也要单独封装用<li>-->
            <ol type='a'>
                <li>有序1</li>
                <li>有序2</li>
                <li>有序3</li>
            </ol>

            <ul type="circle">
                <li>无序1</li>
                <li>无序2</li> 
                <li>无序3</li>    
            </ul>

    </body>
</html>
```


网页图像显示
----

```html
<html>
    <head>
        <title>网页图像</title>
    </head>
    <body>
        <img src="images/sky.jpg" alt="beatiful sky" width="750" height="500"/> 
    </body>
</html>
```

网页表格显示
---
`tr`行  
`td`单元格  
`th` 单元格居中  


```html
<html>
    <head>
        <title>网页表格</title>
    </head>
    <body>
       <table border='1' bordercolor='blue' cellspacing='0' cellpadding='10' width='500'>
           <tr>
               <td>姓名</td>
               <th>年龄</th>
           </tr>
           <tr>
               <td>jian</td>
               <td>23</td>
           </tr>
       </table>
       <table>
           <tr>
               <th colspan='4'>壁纸合辑</th><!--合并单元格-->
           </tr>
           <!--三行四列加一行表头-->
           <tr>
               <td><image src="images/1.jpg" width="200" height="140"/></td>
               <td><image src="images/2.jpg" width="200" height="140"/></td>
               <td><image src="images/3.jpg" width="200" height="140"/></td>
               <td><image src="images/4.jpg" width="200" height="140"/></td>
           </tr>
           <tr>
                <td><image src="images/5.jpg" width="200" height="140"/></td>
                <td><image src="images/6.jpg" width="200" height="140"/></td>
                <td><image src="images/7.jpg" width="200" height="140"/></td>
                <td><image src="images/8.jpg" width="200" height="140"/></td>
            </tr>
            <tr>
                <td><image src="images/9.jpg" width="200" height="140"/></td>
                <td><image src="images/10.jpg" width="200" height="140"/></td>
                <td><image src="images/11.jpg" width="200" height="140"/></td>
                <td><image src="images/12.jpg" width="200" height="140"/></td>
                </tr>
       </table>
    </body>
</html>
```

table的下一级是tbody，就算没写它也默认存在

超链接
----
`<a>`可以获取超链接  
`href` 属性可以是url也可以是本地文件  
`target`指定在哪个窗口或者帧中打开  
`name`定位标记（网页过长时，定位标记比滑动滚条好用）  
使用定位标记时一定要在href的开始加入#标记
```html
<html>
    <head>
        <title>超链接</title>
    </head>
    <body>
        <a name="top">顶部位置</a>
        <!--这里只标识一个位置-->
        <a href="https://github.com/jullyjelly">jullyjelly的博客</a>
        <!--这里必须加http，才能通过http协议解析该网址，否则默认为文件地址-->
        <br/>
        <a href="mailto:abc@qq.com">联系我们</a>
        <!--可以启动右键发送系统-->
        <br/>
        <!--若href="thunder:\\....."则只能用迅雷下载（应用层协议）-->
        <table>
            <tr>
                <th colspan='4'>壁纸合辑</th>
            </tr>
            <tr>
                <td><a href="images/1.jpg"><image src="images/1.jpg" width="320" height="224"/></a></td>
                <td><a href="images/2.jpg"><image src="images/2.jpg" width="320" height="224"/></a></td>
                <td><a href="images/3.jpg"><image src="images/3.jpg" width="320" height="224"/></a></td>
                <td><a href="images/4.jpg"><image src="images/4.jpg" width="320" height="224"/></a></td>
            </tr>
            <tr>
                <td><a href="images/5.jpg"><image src="images/5.jpg" width="320" height="224"/></a></td>
                <td><a href="images/6.jpg"><image src="images/6.jpg" width="320" height="224"/></a></td>
                <td><a href="images/7.jpg"><image src="images/7.jpg" width="320" height="224"/></a></td>
                <td><a href="images/8.jpg"><image src="images/8.jpg" width="320" height="224"/></a></td>
            </tr>
            <tr>
                <td><a href="images/9.jpg"><image src="images/9.jpg" width="320" height="224"/></a></td>
                <td><a href="images/10.jpg"><image src="images/10.jpg" width="320" height="224"/></a></td>
                <td><a href="images/11.jpg"><image src="images/11.jpg" width="320" height="224"/></a></td>
                <td><a href="images/12.jpg"><image src="images/12.jpg" width="320" height="224"/></a></td>
            </tr>
        </table>
        <a href="#top">回到顶部位置</a>
        <!--必须加#，若不加会被识别成一个文件**********-->
    </body>
</html>
```
框架
---
+ 主框架

`name`给链接打开位置起名  
`noresize` 使框架不能拖动大小
```html
<html>
    <head>
        <title>网页框架</title>
    </head>
    <frameset rows="20%,*"">
        <!--上部子窗体-->
            <frame src="top.html">
            <!--下部子窗体-->
            <frameset cols="30%,*">
                    <frame src="underleft.html" noresize="noresize" >
                    <frame src="underright.html" name=right>   
            </frameset>
    </frameset>
</html>
```
+ 顶部框架
```html
<html>
    <head>
        <title>顶部框架</title>
    </head>
    <body>
        <h1><font size=3 color=blue>我的网站</font></h1>
    </body>
</html>
```
+ 左边框架

`target`确定链接打开位置
```html
<html>
    <head>
        <title>下部框架</title>
    </head>
    <body>
        <h4>网站索引</h4>
        <dl>
            <dt>新闻链接</dt>
            <dd><a href="t1.html" target="right">新闻1</a></dd>
            <dd><a href="table.html" target="right">新闻2</a></dd>
            <dd><a href="image.html" target="right">新闻3</a></dd>
        </dl>
        <dl>
            <dt>论坛链接</dt>
            <dd><a href="link.html" target="right">论坛1</a></dd>
            <dd><a href="t1.html" target="right">论坛2</a></dd>
            <dd><a href="table.html" target="right">论坛3</a></dd>
        </dl>
    </body>
</html>
```
+ 右边框架
```html
<html>
    <head>

    </head>
    <body>
        <h1>网站内容</h1>
    </body>
</html>
```
画中画
---
```html
<html>
    <head>
        <title>网页画中画</title>
    </head>
    <body>
        <iframe src="link.html" height=400 width=500>画中画标签</iframe>
        <!--文字只有在画中画不展示的时候才显示，若吧高和宽设为0并在里面加入一个恶意网站可能会在别人看不到的情况下就加载了恶意网站-->
    </body>
</html>
```
**\*表单**
----
最常用的标签，用于与服务器的交互  
`<input>`中添加value服务器就可以从这个键中拿到值  
input中是ratio时，加上checked可以默认选择该组件  
隐藏组件通常定义给服务器端提交的数据，而这些数据不需要显示在页面上  
图片组件具有提交功能，是一个漂亮的提交按钮
```html
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form>
		用户名称：<input name="usersname"/></br>
        输入密码：<input type="password" name="password" /></br>
        选择性别：<input type="radio" name="sex" value="nan">男
        <input type="radio" name="sex" value="nv" checked>女</br>
        <!--必须加value否则服务端无法读取数据，-->
        <!--将两个通过name放在一个组里，就能够保证每次只选一个了-->
        
        选择技术：<input type="checkbox" name="tech" value="java"/>JAVA
        <input type="checkbox" name="tech" value="html"/>HTML
        <input type="checkbox" name="tech" value="python"/>PYTHON
    </br>
        自定义按钮:<input type="button" value="弹窗" onclick="alert('弹出新窗口')"/>
    </br>
        隐藏组件：<input type="hidden" name="jian" value="20"/>
    </br>
        选择文件：<input type="file" name="file" />
    </br>
        图片组件：<input type="image" src="images/3.jpg"/ height="20" width="30">
    </br>
        选择国家：
        <select name="country">
            <option value="none">--选择国家--</option>
            <option value="cn" selected="selected">中国</option>
            <option value="usa">美国</option>
            <option value="jap">日本</option>
            <option value="kora">韩国</option>
        </select>
    </br>
        个人介绍：<textarea rows="5" cols="20"></textarea>
    </br>
        <input type="submit" value="提交"/>  <input type="reset"/>
        <!--提交按钮将表单中的所有组件数据提交到指定服务器端-->
    </br>
	</form>
</body>
</html>
```
想要将表单中的数据提交大服务器，每一个表单中都需要定义name和value属性，对于文本框这种值不确定瞪大用户输入的组件，value可以不定义

注册表
---
用java写一个服务器
```java
import java.net.*;
import java.io.*;
public class HtmlServer {
	public static void main(String[] args) throws Exception{
		ServerSocket ss = new ServerSocket(10005);
		Socket s = ss.accept();
		System.out.println(s.getInetAddress().getHostAddress());
		InputStream in = s.getInputStream();
		byte[] buf = new byte[1024];
		int len = in.read(buf);
		System.out.println(new String(buf,0,len));
		
		PrintWriter pw = new PrintWriter(s.getOutputStream(),true);
		pw.println("<font size=5 color=red>注册完成</font>");
		
		s.close();
		ss.close();
	}
}
```
 用html写一个注册表  
  
 `<form>`中action是提交地址method是提交方式
```html
<html>
<head>
<meta charset="UTF-8">
<title>注册表</title>
</head>
<body>
    <form action="http://10.108.86.246:10005" method="GET">
        <table border='1' bordercolor='blue' cellspacing='0' 
        cellpadding='15' width='600'>
            <tr>
                <th colspan="2">注册页面</th>
            </tr>
            <tr>
                <td>用户名(U):</td>
                <td><input type="text" name="usersname"/></td>
            </tr>
            <tr>
                <td>密码(P)：</td>
                <td><input type="password" name="pass"/></td>
            </tr>
            <tr>
                <td>确认密码：</td>
                <td><input type="password" name="assertpass"/></td>
            </tr>
            <tr>
                <td>性别</td>
                <td><input type="radio" name="sex"  value="nan"/> 男 
                    <input type="radio" name="sex"  value="nv" checked/> 女</td>
            </tr>
            <tr>
                <td>技术</td>
                <td>
                    <input type="checkbox" name="tech" value="java">JAVA  
                    <input type="checkbox" name="tech" value="html">HTML
                    <input type="checkbox" name="tech" value="css">CSS
                </td>
            </tr>
            <tr>
                <td>国家</td>
                <td>
                    <select name="country">
                        <option value="none">--选择国家--</option>
                        <option value="cn" selected>中国</option>
                        <option value="usa">美国</option>
                        <option value="en">英国</option>
                    </select>
                </td>
            </tr>
            <tr>
                <th colspan="2">
                    <input type="submit" value="提交">
                    <input type="reset" >
                </th>
            </tr>

        </table>
    </form>
</body>
</html>

```
运行结果： 
+ get
>运行完后表头  
http://10.108.86.246:10005/?usersname=zxc&pass=asas&assertpass=sdf&sex=nv&tech=java&country=cn  

>10.108.86.246
GET /?usersname=qw&pass=sd&assertpass=rew&sex=nv&tech=java&tech=html&tech=css&country=cn HTTP/1.1 
Accept: image/gif, image/jpeg, image/pjpeg, application/x-ms-application, application/xaml+xml, application/  x-ms-xbap,\*/*  
Accept-Language: zh-CN  
User-Agent: Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 10.0; WOW64; Trident/7.0; .NET4.0C; .NET4.0E; .NET   CLR 2.0.50727; .NET CLR 3.0.30729; .NET CLR 3.5.30729)  
Accept-Encoding: gzip, deflate  
Host: 10.108.86.246:10005  
Connection: Keep-Alive  
 
+ post  
>运行完后表头  
http://10.108.86.246:10005/

>10.108.86.246
POST / HTTP/1.1  
Accept: image/gif, image/jpeg, image/pjpeg, application/x-ms-application,application/xaml+xml, application/x-ms-xbap, \*/*  
Accept-Language: zh-CN    
User-Agent: Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 10.0; WOW64; Trident/7.0; .NET4.0C;   .NET4.0E; .NET CLR 2.0.50727; .NET CLR 3.0.30729; .NET CLR 3.5.30729)  
Content-Type: application/x-www-form-urlencoded  
Accept-Encoding: gzip, deflate  
Host: 10.108.86.246:10005  
Content-Length: 65  
Connection: Keep-Alive  
Cache-Control: no-cache  
>
>usersname=sdf&pass=fdg&assertpass=hfg&sex=nv&tech=java&country=cn

get和post区别：  
>1. get将提交的数据显示在地址栏，post不显示  
>2. get提交，敏感信息不安全，提交敏感信息相对安全  
>3. get提交，数据存储到地址栏，存储的体积有限，而post可以提交大体积数据信息   
>4. 提交信息的http封装形式不同，get将提交信息封装到请求行，post将提交信息封装到请求体   

**一般建议使用post**
****

进一步的问题1：如果表单加入了增强型的校验，只有在所有选项都符合规则的情况下才可以提交，这时服务端收到数据后是否还需要校验。  
> 需要，因为客户端有可能避开校验传递错误的数据到服务器，为了安全性必须校验  

和服务器交互的三种方式：
>1. 地址输入 get    
在地址栏直接输入http://10.108.86.246:10005/?usersname=sdf&pass=rt&assertpass=kjg&sex=nv&tech=java&country=cn也可以注册成功
>2. 超链接 get 
  `<a href = "http://10.108.86.246:10005/?usersname=sdf&pass=rt&assertpass=kjg&sex=nv&tech=java&country=cn">暴力注册</a>`在body中加入一个暴力注册的超链接点击超链接即可注册
>3. 表单 get post

进一步的问题2：如果服务端收到数据后校验，表单还需要校验吗。
> 需要，为了减轻服务端的压力，客户端需要校验，同时为了增强用户的体验效果

头标签
---
投标前都放在<head></head>头部分之间，包括title base meta link  
下面的代码表示三秒以后跳转到新的界面
```html
<html>
    <head>
        <meta http-equiv="refresh" content="3;https://github.com/jullyjelly">
        <!--content="1"每秒刷新一次-->
    </head>
    <body>
        hello
    </body>
</html>
```
其他常用的：
`<b>`
`<i>`
`<u>`
`<sub>`
`<sup>`
`<pre>`
`<marquee>`
 
 XML可对数据进行描述，而html只能对结构进行描述
