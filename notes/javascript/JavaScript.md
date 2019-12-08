JavaScript
===
javascript是**基于对象**和事件驱动的脚本语言，主要应用在客户端   
重在处理事件监听机制的时间处理部分   
特点：  
+ 交互性（信息的动态交互）
+ 安全性 （不允许直接访问本地硬盘）
+ 跨平台性（只要可以解释js的浏览器都可以执行，与平台无关）

和java区别：  
+ js基于对象，java面向对象
+ js只需解释就可以运行，java需要先编译成字节码文件再执行
+ **js是弱类型（不去刻意规定数据在内存中的大小），java是强类型（但凡用一个数据，这个数据在内存中必须有固定空间的开辟，每一种数据都有不同的类型和空间大小对应）**

html给数据加标记，用html处理后有基本的格式单数不美观，css加样式效果，javascript进一步解决动态效果  
+ hello.js

```javascript
alert("hello world");
```

```html
<html>

<head>
    <title>js</title>
</head>

<body>
    <!--如果在script标签中使用src属性，引入了js文件，内部封装代码就不执行了-->
    <script type="text/javascript" src="hello.js"></script>
    <script type="text/javascript">
        alert("hello javascript");
    </script>
</body>

</html>
```

script标签可以放在任何位置，如果脚本操作的是页面的局部区域，就放在局部区域的旁边，如果操作的是页面的很多区域，就放在head位置

任何一门程序设计语言都具备以下要素，但是表现形式不同：
- 注释
- 标识符：起名字  
关键字：赋予了特殊含义的单词
- 变量
- 语句
- 函数
- 数组

js的变量：`var x=3;` 

+ var x=3110/1000; x=3.11
+ var x=2.4+3.6; x=6而不是6.0
+ var x="12"+1; x=121; x="12"-1;x=11
+ && || 是逻辑运算符  & | 是位运算符
+ 支持三元运算符
+ typeof 返回一个操作表达式数据类型的字符串 `number` `String` `boolan`

语句：
+ if语句 `var x=3;` `if(x==4)`可以进行比较运算`if(x=4)`可以进行赋值运算，同时也可以进行判断，返回true（因为在js中，非0和非null都是true,默认值为1），可以通过`if(4==y)`来解决问题，因为if（4=y）不会进行判断而是会报错
+ switch语句，因为是弱类型，可以进行字符串选择
+ while    do...while    for

js定义在for里面的是全局变量


### 语句

`document.write()`打印  


```html
<html>

<head>
    <title>jslanguage</title>
</head>

<body>
    <script>
        for(var x=0;x<3;x++){
            alert("x="+x);
        }
        //写法一
        for(var a=1;a<=9;a++){
            for(var b=1;b<=a;b++){
                document.write(a+"*"+b+"="+a*b+"&nbsp;&nbsp;");
            }
            document.write("</br>");
        }
        //写法二
       document.write("<table>");
        for (var a = 1; a <= 9; a++) {
            document.write("<tr>");
            for (var b = 1; b <= a; b++) {
                document.write("<td>"+a + "*" + b + "=" + a * b+"</td>");
            }
            document.write("</tr>");
        }
        document.write("</table>");
    </script>
</body>

</html>
```

### 函数

格式：
```javascript
function 函数名（参数列表）{
    函数体；
    return 返回值；
}
```
演示：
```javascript
    function show(){
        alert("show run");
        return 4;
    }

    var num=show();
    document.write(num)
```

```javascript

```

```javascript

```