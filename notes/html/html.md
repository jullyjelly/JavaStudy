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

<a>
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
[显示效果](t1.html)


网页图像显示
----

<a>
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

<a>
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
<a>
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
[显示效果](table.html)

table的下一级是tbody，就算没写它也默认存在

超链接
----
<a>
```html
<html>
    <head>
        <title>超链接</title>
    </head>
    <body>
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
                    <td><a href="images/1.jpg"><image src="images/1.jpg" width="200" height="140"/></a></td>
                    <td><a href="images/2.jpg"><image src="images/2.jpg" width="200" height="140"/></a></td>
                    <td><a href="images/3.jpg"><image src="images/3.jpg" width="200" height="140"/></a></td>
                    <td><a href="images/4.jpg"><image src="images/4.jpg" width="200" height="140"/></a></td>
                </tr>
                <tr>
                    <td><a href="images/5.jpg"><image src="images/5.jpg" width="200" height="140"/></a></td>
                    <td><a href="images/6.jpg"><image src="images/6.jpg" width="200" height="140"/></a></td>
                    <td><a href="images/7.jpg"><image src="images/7.jpg" width="200" height="140"/></a></td>
                    <td><a href="images/8.jpg"><image src="images/8.jpg" width="200" height="140"/></a></td>
                 </tr>
                 <tr>
                    <td><a href="images/9.jpg"><image src="images/9.jpg" width="200" height="140"/></a></td>
                    <td><a href="images/10.jpg"><image src="images/10.jpg" width="200" height="140"/></a></td>
                    <td><a href="images/11.jpg"><image src="images/11.jpg" width="200" height="140"/></a></td>
                    <td><a href="images/12.jpg"><image src="images/12.jpg" width="200" height="140"/></a></td>
                </tr>
            </table>
    </body>
</html>
```