CSS
===
css是层叠样式表，用来定义网页的现实效果，可以解决html代码对样式定义的重复，它将网页内容和显示样式进行分离，提高显示功能。  
div+css区块  
html中的标签`<font>` `<table>` `<dl>` `<a>`等是具有特殊含义的标签  
css中定义了一些没有特殊含义只为封装区域的标签  
>`<div>`:封装区域后有换行  
 `<span>`：没有换行   
`<p>`:段落的前后还有空行

 标签可以分为两类： \[通过有无换行来区分\] 
 > 块级标签（元素）:div,dl,table  
 >  行内标签:span,a,input,selsct

 css和html的结合：html编写页面，css给页面加载样式  
 结合方式有四种 

 一、style属性方式
 ---
 ```html
 <html>

<head>
    <title>div</title>
</head>

<body>
    <div style="color: darksalmon; background-color:black;
     width: 800; font-size: 20px;">div区域</div>
    <!--可以通过加背景色或者边框来查看封装的范围-->
</body>

</html>
 ```

 二、style标签方式
 ---
 为了提高重复样式的复用性，将重复的代码抽取出来，**多标签样式相同时使用**  
 通过`<style>`标签封装样式代码,否则div代码对html来说只是普通的代码而已   
 `<style>`标签一般定义在`<head>`标签中优先加载
 ```html
 <html>

<head>
    <title>div</title>
    <style type="text/css">
        div {
            color: #fff000;
            background-color: cadetblue;
            font-size: 24px;
        }
    </style>
</head>

<body>
    <div >div区域</div>
    <div>div区域</div>
    <div style="color: darksalmon; background-color:black;
    width: 800; font-size: 20px;">div区域</div>
    <div>div区域</div>
</body>

</html>
 ```
 在使用了第二种方式后可以使用第一种方式的实现样式的层叠覆盖

 当多页面样式相同时，将样式抽取到一个样式文件中  
 可以建一个style文件夹，里面放入各种样式的配置，然后将配置通过`@import url("文件位置")`导入即可  
 + div.css
```css
div {
    color: #faea0a;
    background-color: cadetblue;
    font-size: 24px;
}
```

 ```html
 <html>

<head>
    <title>div</title>
    <style type="text/css">
       @import url("style/div.css")
    </style>
</head>

<body>
    <div >div区域</div>
    <div>div区域</div>
    <div>div区域</div>
    <div>div区域</div>
</body>

</html>
 ```

 但是这个方法也存在相应的问题，因为每添加一个新样式就要import一个，而原则上尽量不要对网页做更改，因此，可将这些样式再次提取到一个文件中

 三、将html文件和css文件分离
 ---

 + 1.css
 ```css
 @import url("div.css");
@import url("span.css");
```
+ span.css
```css
span{
    color: rgb(217, 166, 240);
    background-color: limegreen;
    font-size: 28px;
}
```


```html
<html>

<head>
    <title>div</title>
    <style type="text/css">
      @import url("style/1.css");
    </style>
</head>

<body>
    <div >div区域</div>
    <div>div区域</div>
    <div>div区域</div>
    <div>div区域</div>

    <span>span区域</span>
    <span>span区域</span>
    <span>span区域</span>
    <span>span区域</span>
</body>

</html>
```
四、用html标签引入一个外部文件
---

在头部加入link标签，即可导入一个样式文件
```html
<head>
    <link rel="stylesheet" href="style/1.css"/>
    <title>div</title>
    
</head>
```

应用
----
```html
<html>

<head>
    <title>示例</title>
    <style type="text/css">
        ul {
            list-style-image: url("1.jpg");
            list-style-type: square;
        }

        table {
            border-collapse: collapse;
            border: solid 2px cornflowerblue;
            <!--外边框实线-->
        }

        td {
            border: dotted 2px cornflowerblue;
            <!--内边框虚线-->
        }

        input {
            border-style: none;
            border-bottom: solid black 1px;
            <!--只保留下边框线-->
        }
    </style>
</head>

<body>
    <ul>
        <li>无序</li>
        <li>无序</li>
        <li>无序</li>
        <li>无序</li>
    </ul>

    <table>
        <tr>
            <td>表格1</td>
            <td>表格2</td>
        </tr>
        <tr>
            <td>表格3</td>
            <td>表格4</td>
        </tr>
    </table>
    <hr>

</body>
姓名:<input type="name" />

</html>
```

样式优先级：由上到下，由外到内，优先级由低到高（相同样式后加载的比先加载的优先级高）

标签格式：  
>选择器名称{属性名：属性值；属性名：属性值}  
属性与属性之间分号分开  
属性与属性值之间冒号连接  
如果一个属性有多个值得花相互之间用空格隔开  


选择器
---
选择器就是制定css要作痛的标签，那个标签的名称就是选择器  
标签的表示方式有三种：
>1. html标签名称选择器，使用的是html的标签名
>2. class选择器，使用标签中的class属性
>3. id选择器

+ 类选择器
```html
<html>

<head>
    <title>div</title>
    <style type="text/css">
        div.one{
        background-color: cadetblue;
        color: coral;
        }
        div.two{
        background-color: rgb(236, 104, 170);
        color:cyan;
        }
    </style>
    
</head>

<body>
    <div class="one">div区域</div>
    <div class="two">div区域</div>
    <div class="one">div区域</div>
    <div class="two">div区域</div>

</body>

</html>
```

还可以跨标签使用
```html
<html>

<head>
    <title>div</title>
    <style type="text/css">
        .one{
        background-color: cadetblue;
        color: coral;
        }
        .two{
        background-color: rgb(236, 104, 170);
        color:cyan;
        }
    </style>
    
</head>

<body>
    <div class="one">div区域</div>
    <div class="two">div区域</div>
    <div class="one">div区域</div>
    <div class="two">div区域</div>

    <span class="one">span区域</span>
    <span class="two">span区域</span>
    <span class="one">span区域</span>
    <span class="two">span区域</span>
</body>

</html>
```

id选择器：

id一定要保证唯一性，通常用来标识页面中特定的区域
```html
<html>

<head>
    <title>div</title>
    <style type="text/css">
        #oneid{
            background-color: rgb(236, 104, 170);
            color:cyan; 
        }
        #twoid{
            background-color: cadetblue;
            color: coral;
        }
    </style>
    
</head>

<body>
    <div class="one" id="oneid">div区域</div>
    <div class="two" id="twoid">div区域</div>
    <div class="one" id="oneid">div区域</div>
    <div class="two" id="twoid">div区域</div>

    <span class="one" id="oneid">span区域</span>
    <span class="two" id="twoid">span区域</span>
    <span class="one" id="oneid">span区域</span>
    <span class="two" id="twoid">span区域</span>
</body>

</html>
```
扩展选择器
---
+ 关联选择器：标签是可以嵌套的，要让相同标签中的不同标签显示不同的样式，就可以用此选择器`div b{}`标签名 `.one b` id`#oneid b`class 都可以
+ 组合选择器：对多个不同选择器进行相同样式设置时就用此选择器`#oneid,span.one,p.two{}`之间用逗号隔开
+ 伪元素选择器：在html中预定义好一些选择器，称为伪元素。格式： `标签名：伪元素 类名`或者`标签名：类名 伪元素


关联选择器
```html
    /*只设置div区域中的b标签*/
    div b{
        color=cyan; 
    }
    <!--若定义b会将所有的b标签中的文字改变格式-->
    <div class="one" id="oneid">div<b>区域</b></div>
```

组合选择器
```html
    #oneid,span.one,p.two{
        color=cyan; 
    }

    <div class="one" id="oneid">div区域</div>
    <div class="two" id="twoid">div区域</div>

    <span class="one" >span区域</span>
    <span class="two" >span区域</span>

    <p class="two">p段落</p>
```
伪元素选择器:  
- ：link(访问前)  
- ：active（点击）
- ：hover（悬停）
- ：visited（访问后）
- ：focus（焦点）

**放置顺序L-V-H-A**
```html
<style>
a:link{
    color:rgb(238, 61, 61);
    text-decoration-line:none;
    background-color: rgb(236, 104, 170);
}
a:visited{
    background-color: rgb(15, 179, 129);
    text-decoration: line-through;
}
a:hover{
    color:rgb(52, 89, 209);
    text-decoration-line:blink;
    background-color: rgb(214, 65, 65);
}
a:active{
    font-size: 30px;
}
</style>

<a href="https://github.com/jullyjelly" target="_blank">一个链接</a>
```
图文混排
---
```html
<html>

<head>
    <title>图文并排</title>
    <style type="text/css">
    #imgtext{
        border: dotted 3px coral;
        width:220px;
        height:180px;
        padding:20px;
    }
    #divimg{
        float: left;
    }


    </style>
</head>

<body>
    <div id="imgtext">
        <div id="divimg">
            <a href="1.jpg" target="_blank"><image src="1.jpg" height="100px" width="150px"/></a>
        </div>
        <div id="imagesc">美丽滴天空啊啊啊
            啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊</div>
    </div>
</body>

</html>
```