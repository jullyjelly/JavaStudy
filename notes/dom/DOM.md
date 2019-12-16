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
### 案例：改变新闻字体，提供供用户选择字体大小的按钮

1. 用html，通过标签定义页面基本结构
2. 用css定义页面样式
3. 确定事件源和事件

```html

```
```html

```
```html

```
```html

```
```html

```
```html

```

