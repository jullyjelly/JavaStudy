DOM
===
Document Object Model 文档对象模型  
作用：将标记型文档以及文档中的标签的所有内容都封装成对象  
浏览器内置了DOM技术的解析器，直接对标记型文档解析成对象，驻留在内存中并按照标签的乘次关系生成dom树，树中的所有对象都称之为节点，也就是对象，标签是节点中一种嘴馋被使用的内容，这就是dom解析技术的特点  
正因为dom的解析将文档和内容变成了对象，才有了动作操作的可能

dom树：树种的每一个部分称之为节点。每一个节点都是一个对象  
document  
html  
- head
    - title
    - link
    - mate
- body
    - table
        - tbody
        - tr
            - th
            - td
    - div
    - form
        - input
    - a

DHTML：多项技术综合体的简称，其中包含HTML，CSS，DOM，JavaScript四种技术（+xmlHTTPRequest=AJAX）  
- html：提供标签,用于封装数据，给数据加标记，它是最基础的部分  
- css：提供样式，用于对标签中的数据进行丰富的效果展现  
- dom：提供解析，将标记型文档以及文档中的内容都封装成了对象，在对象中定义了更多的属性和行为  
- javascript：提供了逻辑性较强的程序设计内容，可以对对象的操作进行控制，负责的是页面的动态行为

BOM：Browser Object Model浏览器对象模型。将浏览器以及浏览器中的一些内容封装成了对象 

eg：  
windows对象：代表浏览器中一个打开的窗口。（history，location，navigation，document等方法）
```html
<html>
    <head>
        <title>dom</title>
    </head>
    <body>
        <script type="text/javascript">
            function locationdemo(){
                alert(location.href);
                location.href="https://github.com/jullyjelly";
            }
        </script>
        <input type="button" value="演示地址" onclick="locationdemo()">
    </body>
</html>
```
获取document对象
---
通过window对象获取窗体中的document对象    
获取document对象的原因：标签偶在文档中，所以要获取标签首先要有document对象  
如何获取标签： 查阅DHTML手册的document对象的方法  
三个通用方法：
- getElementById 获取对 ID 标签属性为指定值的**第一个对象的引用**。 
- getElementsByName 根据 NAME 标签属性的值获取对象的**集合**(返回的值不唯一)。 
- getElementsByTagName 获取基于指定元素名称的对象**集合**。 

所有节点都具有的属性：节点名称，节点类型，节点值  
getElementById
```html
<html>
    <head>
        <title>domdocumment</title>
    </head>
    <body>
        <script type="text/javascript">
            function documentdemo(){
                //想要操作页面标签中的数据，必须先获取到该标签对象

                //通过id属性获取标签，返回该标签节点对象
                var divnode=document.getElementById("divid");
                //document.write(divnode);
                alert(divnode);
                //[object HTMLDivElement]
                alert(divnode.nodeName);//获取节点名称
                //DIV
                alert(divnode.innerHTML);//获取div中的文本
                //div区域

                divnode.innerHTML="new".fontcolor("red");

            }
        </script>

        <input type="button" value="show document object" onclick="documentdemo()">
        <div id="divid">div区域</div>
        <table>
            <tr>
                <td>table1</td>
                <td>table2</td>
            </tr>
            <tr>
                <td>table3</td>
                <td>table4</td>
            </tr>
        </table>
        <span>span区域</span>
        <input type="text" name="user"/>
        <a href="https://github.com/jullyjelly">jul's github</a>
    </body>
</html>
```
getElementsByName
```html
<script type="text/javascript">
    function documentdemo(){
        //想要操作页面标签中的数据，必须先获取到该标签对象

        //通过id属性获取标签，返回该标签节点对象
        var divnode=document.getElementById("divid");
        var nodes=document.getElementsByName("user");
        alert(nodes.length);//1
        alert(nodes);//[object NodeList]
        //获取集合中第一个节点的type
        alert(nodes[0].type);
        //获取文本框中输入的值
        alert(nodes[0].value);
        //将id="divid"中的文本添加到输入框中（nodes[0]是一个输入文本框）
        nodes[0].value=divnode.innerHTML;

    }
</script>
<input type="button" value="show document object" onclick="documentdemo()">
```
另一种常用的简便写法
```javascript
var node=document.getElementsByName("user")[0];
node.value="haha";
```
不是所有的标签都具有name属性，具有name属性的标签最多的体现在表单标签中 

getElementsByTagName

获取所有的div
```html
var nodes=document.getElementsByTagName("div");
for(var x=0;x<nodes.length;x++){
    alert(nodes[x].innerHTML);
}
```
获取表格中的div：  
1. 获取表格对象
2. 通过表格获取其中的div  

获取局部节点
```html
<script type="text/javascript">
function documentdemo(){
    var tablenode=document.getElementById("tableid");
    var tablediv=tablenode.getElementsByTagName("div");
    for(x=0;x<tablediv.length;x++){
        alert(tablediv[x].innerHTML);
    }

}
</script>
```
按照节点层次关系获取节点：
- 父节点：唯一
- 子节点：不唯一，数组
- 兄弟节点：不同浏览器解析不同，不常用
```javascript
function getNodeByLevel(){
    //获取表格节点
    var tableNode=document.getElementById("tableid");
    //获取表格节点的父节点
    var node1=tableNode.parentNode;
    alert(node1);
    alert(node1.nodeName);

    //获取表格节点的子节点
    var node2=tableNode.childNodes;
    alert(node2.length);
    for(var i=0;i<node2.length;i++){
        alert(node2[i].nodeName);//#text//TBODY
    }

    var node3=tableNode.childNodes[1].childNodes;
    alert(node3.length);
    for(i=0;i<node3.length;i++){
        alert(node3[i].nodeName);//TR//#text//TR//#text
    }
    //获取表格节点的兄弟节点
    var bro1=tableNode.nextSibling.nextSibling;
    alert(bro1.nodeName);
    //tableNode.nextSibling获取的是#text

    var bro2=tableNode.previousSibling.previousSibling;
    alert(bro2.nodeName);
    
}

```
## 案例：改变新闻字体，提供供用户选择字体大小的按钮

1. 用html，通过标签定义页面基本结构
2. 用css定义页面样式
3. 确定事件源和事件
    - 事件源：超链接
    - 事件：点击事件  
    注意：超链接本身带有默认事件，现在该超链接不需要默认事件处理，要取消。`href="javascript:void(0)"`  
    没有了默认效果后，需要在事件源注册指定的事件
4. 定义处理方式的具体内容
    - 在处理方式中 ，必须要明确被处理的节点，获取该节点和对象，并调用其属性和行为，完成处理

```html
<html>
    <head>
        <title>news</title>
        <meta charset="UTF-8">
        <style>
            #textid{
                border:dotted cornflowerblue 4px;
                width:900px;
                padding:20px;
            }
           /* 对新闻区域中超链接的未访问状态和访问后的状态设置相同的样式 */
            #newsid a:link,#newsid a:visited{
                color:darkgrey;
                text-decoration-line: none;

            }
            #newsid a:hover{
                color:darkred;
                font-size: 25px;
            }
        </style>
        <script>
            function changefont(size,color){
                var textnode=document.getElementById("textid");
                textnode.style.fontSize=size;
                textnode.style.color=color;
            }
        </script>
    </head>
    <body>
        <div id="newsid">
            <h1>新闻标题</h1>
            <a href="javascript:void(0)" onclick="changefont('24px','green')">大字体</a>  
            <a href="javascript:void(0)" onclick="changefont('20px','yellow')">中字体</a>  
            <a href="javascript:void(0)" onclick="changefont('16px','blue')">小字体</a>
            <hr>
            <div id="textid">
                    研究的主要框架如下：
                    第1章是引言
                    该章节主要介绍本文的研究背景、研究内容、研究目的、研究方法、技术路线和研究意义及创新点。
                    第2章是文献综述
                    2.1选址理论
                    2.2竞争选址理论
                      2.2.1静态竞争
                      静态竞争是指竞争对手已经存在市场中，新进入的竞争者即将进入市场，并且知道竞争对手的信息，
                      新进入的竞争者进入市场后竞争对手并不采取相应的行动。
                      2.2.2有预见的竞争
                      带预见的竞是指潜在的竞争者尚未进入市场，但在新设施建成后将很快出现，因此领导者希望以一种
                      定性的方式来定位设施，以便在追随者找到设施后最大程度的获取所占领的市场份额。竞争双方的决
                      策可以视为Stacklberg游戏
                    
                
            </div>
        </div>
    </body>
</html>
```
该方法仍存在一些问题，添加新样式会比较麻烦，样式和代码耦合性较强
```html
<html>
    <head>
        <title>news</title>
        <meta charset="UTF-8">
        <style>
            #textid{
                border:dotted cornflowerblue 4px;
                width:900px;
                padding:20px;
            }
           /* 对新闻区域中超链接的未访问状态和访问后的状态设置相同的样式 */
            #newsid a:link,#newsid a:visited{
                color:darkgrey;
                text-decoration-line: none;

            }
            #newsid a:hover{
                color:darkred;
                font-size: 25px;
            }

            .maxsize{
                font-size: 26px;
            }
            .normsize{
                font-size: 20px;
            }
            .minsize{
                font-size: 14px;
            }
            /*也可以将以上部分存入一个style文件中然后@import url("style.css");*/
        </style>
        <script>
            function changefont(size){
                var textnode=document.getElementById("textid");
                textnode.className=size;
            }
            
        </script>
    </head>
    <body>
        <div id="newsid">
            <h1>新闻标题</h1>
            <a href="javascript:void(0)" onclick="changefont('maxsize')">大字体</a>  
            <a href="javascript:void(0)" onclick="changefont('normsize')">中字体</a>  
            <a href="javascript:void(0)" onclick="changefont('minsize')">小字体</a>
            <hr>
            <div id="textid" class="maxsize">
                    .......
            </div>
        </div>
    </body>
</html>
```
## 案例：表单校验
1. 明确事件源和事件
    - 事件源：表单中的组件
    - 事件：失去焦点后就立刻校验
2. 提示信息的展示方式
    - 不要弹出信息，而是在组件的旁边显示文字或者图片，需要定义一个显示区域
```html
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
</head>

<body>
    <script type="text/javascript">
        function checkUser(){
            var usernode=document.getElementsByName("user")[0];
            var username=usernode.value;
            // alert(username);
            var spanpde=document.getElementById("userspan");
            if(username=="abc"){
                spanpde.innerHTML="√".fontcolor("green");
            }
            else{
                spanpde.innerHTML="×".fontcolor("red");
            }
        }
    </script>
    <form action="">
        用户名：<input type="text" name="user" onblur="checkUser()">
        <span id="userspan"></span></br>
    </form>
</body>

</html>
```
用户名只能是4个字母
```javascript
var regex=new RegExp("[a-zA-Z]{4}");
//var regex=new RegExp("\\b[a-zA-Z]{4}\\b");
//var regex=new RegExp("^[a-zA-Z]{4}$");
if(regex.test(username)){
    spanpde.innerHTML="√".fontcolor("green");
}
else{
    spanpde.innerHTML="×".fontcolor("red");
}
```
校验表单，使得用户名输入错误时无法提交  
提交按钮上默认有提交事件，将form组件中的name和value都提交到服务器端  
在表单中，若是`onsubmit="return false"`则不默认提交
```html
<html>

<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
</head>

<body>
    <script type="text/javascript">
        function checkUser(){
            var flag=false;
            var usernode=document.getElementsByName("user")[0];
            var username=usernode.value;
            var spanpde=document.getElementById("userspan");
            //对用户名进行正则表达式判断
            var regex=new RegExp("\\b[a-zA-Z]{4}\\b");
            if(regex.test(username)){
                spanpde.innerHTML="√".fontcolor("green");
                flag=true;
            }
            else{
                spanpde.innerHTML="×".fontcolor("red");
                flag=false;
            }
            
            return flag;
        }
        
    </script>
    <form onsubmit="return checkUser()">//************
        用户名：<input type="text" name="user" onblur="checkUser()">
        <span id="userspan"></span></br>
        <input type="submit" value="提交">
    </form>
</body>

</html>
```
自定义提交
```html
<script type="text/javascript">
function myCheckForm(){
    var formnode=document.getElementById("formid");//获取表单对象
    if(checkUser()){
        formnode.submit();
    }
}
</script>
<form id="formid" onsubmit="return checkUser()">
        用户名：<input type="text" name="user" onblur="checkUser()">
        <span id="userspan"></span></br>
        <input type="submit" value="提交">
    </form>
    <hr>
    <input type="button" value="自定义提交" onclick="myCheckForm()"/>
```
完整代码
```html
<html>

<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
</head>

<body>
    <script type="text/javascript">
        function checkUser(){
            var flag=false;
            var usernode=document.getElementsByName("user")[0];
            var username=usernode.value;
            var spanpde=document.getElementById("userspan");
            //对用户名进行正则表达式判断
            var regex=new RegExp("\\b[a-zA-Z]{4}\\b");
            if(regex.test(username)){
                spanpde.innerHTML="√".fontcolor("green");
                flag=true;
            }
            else{
                spanpde.innerHTML="×".fontcolor("red");
                flag=false;
            }
            
            return flag;
        }
        function myCheckForm(){
            var formnode=document.getElementById("formid");
            if(checkUser()&&checkpsw()){
                formnode.submit();
            }
        }

        function checkpsw(){
            var fpsw=false;
            var pswnode=document.getElementsByName("psw")[0];
            var pswvalue=pswnode.value;
            var pswspannode=document.getElementById("pswspan");
            
            var pswregex=new RegExp("^[A-Z][a-zA-Z0-9,\\.]{3,16}");
            if(pswregex.test(pswvalue)){
                pswspannode.innerHTML="√".fontcolor("green");
                fpsw=true;
            }
            else{
                pswspannode.innerHTML="×".fontcolor("red");
                fpsw=false;
            }
            return fpsw;
        }
        function checkForm(){
            if(checkUser()&&checkpsw()){
                return true;
            }
            else{
                return false;
            }
        }
        
    </script>
    <form id="formid" onsubmit="return checkForm()">
        用户名称：<input type="text" name="user" onblur="checkUser()">
        <span id="userspan"></span></br>
        输入密码：<input type="password" name="psw" onblur="checkpsw()">
        <span id="pswspan" ></span></br>
        <input type="submit" value="提交">
    </form>
    <hr>
    <input type="button" value="自定义提交" onclick="myCheckForm()"/>
</body>

</html>
```
以上部分的`checkUser()`和`checkpsw()`代码大量重复，为了提高代码复用性，写一个check函数
```html
<script type="text/javascript">

    function check(name,spanid,regex){
        var flag=false;
        var node=document.getElementsByName(name)[0];
        var value=node.value;

        var spannode=document.getElementById(spanid);
        if(regex.test(value)){
            spannode.innerHTML="√".fontcolor("green");
            flag=true;
        }
        else{
            spannode.innerHTML="×".fontcolor("red");
            flag=false;
        }
        return flag;
    }
    function checkUser(){
        check("user","userspan",new RegExp("\\b[a-zA-Z]{4}\\b"));
    }
    
    function checkpsw(){
        check("psw","pswspan",new RegExp("^[A-Z][a-zA-Z0-9,\\.]{3,16}"));
    }   
</script>
```

完整代码：
```html
<html>

<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
</head>

<body>
    <script type="text/javascript">

        function check(name,spanid,regex){
            var flag=false;
            var node=document.getElementsByName(name)[0];
            var value=node.value;

            var spannode=document.getElementById(spanid);
            if(regex.test(value)){
                spannode.innerHTML="√".fontcolor("green");
                flag=true;
            }
            else{
                spannode.innerHTML="×".fontcolor("red");
                flag=false;
            }
            
            return flag;
        }
        function checkUser(){
            return check("user","userspan",new RegExp("\\b[a-zA-Z]{4}\\b"));
        }
        
        
        function checkpsw(){
            return check("psw","pswspan",new RegExp("[a-zA-Z0-9]{3,16}"));
        }
        
        function checkasp(){
            var flag=false;
            var node1=document.getElementsByName("psw")[0];
            var value1=node1.value;

            var node2=document.getElementsByName("assertpsw")[0];
            var value2=node2.value;

            var spannode=document.getElementById("asspan");
            if(value1==value2){
                spannode.innerHTML="√".fontcolor("green");
                flag=true;
            }
            else{
                spannode.innerHTML="×".fontcolor("red");
                flag=false;
            }
            return flag;
        }
        function checkmail(){
            return check("mail","mailspan",new RegExp("^\\w+@\\w+.\\w+$"));
        }
        function checkSex(){
            var flag=false;
            var radionodes=document.getElementsByName("sex");
            for(var x=0;x<radionodes.length;x++){
                if(radionodes[x].checked){
                    flag= true;
                }
            }
            var sexspan=document.getElementById("sexspan");
            if(!flag){
                sexspan.innerHTML="必须选择性别才可以提交".fontcolor("red");
            }
            return flag;
            
        }
        function checkcountry(){
            var falg=false;
            var selectnode=document.getElementsByName("country")[0];
            var optnodes=selectnode.options;
            //获取下拉菜单中选择的国家
            //alert(optnodes[selectnode.selectedIndex].innerHTML);
            //下拉菜单的值不是none就可以提交
            var val=optnodes[selectnode.selectedIndex].value;
            if(val!="none"){
                flag=true;
            }
            else{
                flag=false;
                var counspannode=document.getElementById("countryspan");
                counspannode.innerHTML="请选择国家".fontcolor("red");
            }
            return flag;
        }

        function myCheckForm(){
            var formnode=document.getElementById("formid");
            if(checkUser()&&checkpsw()&&checkasp()&&checkmail()&&checkSex()&&checkcountry()){
                // if(checkcountry()){
                formnode.submit();
            }
        }

        function checkForm(){
            if(checkUser()&&checkpsw()&&checkasp()&&checkmail()&&checkSex()&&checkcountry()){
                // if(checkSex()){
                return true;
            }
            else{
                return false;
            }
        }
        
    </script>
    <form id="formid" onsubmit="return checkForm()">
        用户名称：<input type="text" name="user" onblur="checkUser()">
        <span id="userspan"></span></br>
        输入密码：<input type="password" name="psw" onblur="checkpsw()">
        <span id="pswspan" ></span></br>
        确认密码：<input type="password" name="assertpsw" onblur="checkasp()">
        <span id="asspan" ></span></br>
        电子邮件：<input type="text" name="mail" onblur="checkmail()">
        <span id="mailspan" ></span></br>
        选择性别：<input type="radio" name="sex" value="man">男  
        <input type="radio" name="sex" value="woman">女
        <span id="sexspan" ></span></br>
        选择国家：
        <select name="country" onchange="checkcountry()">
            <option value="none">--选择国家--</option>
            <option value="cn">中国</option>
            <option value="usa">美国</option>
            <option value="en">英国</option>
        </select>
        <span id="countryspan" ></span></br></br>
        <input type="submit" value="提交">
    </form>
    <hr>
    <input type="button" value="自定义提交" onclick="myCheckForm()"/>
</body>

</html>
```
```html

```

