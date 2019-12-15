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
js可以传递超过函数定义的参数  
js中的函数内部内置了一个参数，用于储存参数数组，用于储存接收到的实际参数，数组名为arguments
```javascript
    function show(x,y){
        for(var x=0;x<arguments.length;x++){
            document.write(arguments[x]+",");
        }
    }
    show(2,3,5,6);
    结果：2,3,5,6
```
js中的函数在内存中其实是一个对象，函数名就是指向这个对象的引用
```javascript
function method(){
    return 10;
}
document.write("<pre>");
var z=method;//将method引用存储的对象的地址赋值给z,那么也指向了这个函数对象
document.write(z);
document.write("</pre>");
var z=method（）;//运行method方法，将运算完的结果返回并赋值给z
document.write(z);//直接打印，将z指向的对象转化为字符串，其实就是调用toString，函数对象的字符串表现形式就是函数的定义形式
document.write(z());

结果：
function method(){
            return 10;
        }
10
10
```

动态函数
---
使用js中已有的内置对象，用`Function`
```javascript
var getSum = new Function("x,y", "var sum=x+y;return sum;");
var sum = getSum(4, 5);
document.write(sum);
```
定义函数
```javascript
function getSum(x,y){
    var sum=x+y;
    return sum;
}
```

二者区别：动态函数的参数列表和函数体都是可以通过参数指定的

匿名函数
---
简化书写  
非匿名
```javascript
    function method(){
        alert("method run");
    }

    var use=method;
    use();
```
匿名
```javascript
var use=function method(){
    alert("method run");
}
use();
```

全局变量和局部变量
---
在script中创建的变量即使定义在语句中也是全局变量  
局部变量：定义在函数中的变量
```javascript
var m;
alert(m);//undefind

alert(n);//报错

function method(){
    var s=5;
}
alert(s);//报错

var a=6;
function get(){
    a=3;
}
get();
alert(a); //3

var b=5;
function get2(b) {
    b = 3;
}
get2(b);
alert(b);//5
```

数组
---
特点：
+ 是一个容器
+ 长度可变
+ 任何类型的数据都可以存储到数组中 ，集合中类型的一致性是由程序员主管控制的，**java中只有集合具备类似的功能，所有类型的数据都可以放到集合中**

数组有两种表示方式：
- `var arr=[];`生成一个长度为0的数组 
- `var arr=new Array(3)`生成一个长度为3的数组，若括号内不填就生成一个长度为0的数组  
- `var arr=new Array(3，9)`创建一个长度为2的数组，元素为3和9
```javascript
var arr=[4,5,2,3,6];
arr[2]=50;
arr[6]=100;
for( var i=0;i<arr.length;i++){
    document.write(arr[i]+",");
}

4,5,50,3,6,undefined,100,
```

获取数组最大值
```javascript
var arr=[3,5,6,8,1,2,6];
function getMax(arr){
    var max=arr[0];
    for( x=0;x<arr.length;x++){
        if(arr[x]>max){
            max=arr[x];
        }
    }
    return max;
}
document.write(getMax(arr));
```

prototype 属性，返回对象类型原型的引用。**继承在js中的体现**  
原型的使用：给已有的js中的类添加新的属性和行为（找到已有类的原型，并向其中添加新功能，使得该类在将来能够随时使用该功能）

```javascript
Array.prototype.getMax=function(){
    var max=this[0];
    for( x=0;x<this.length;x++){
        if(this[x]>max){
            max=this[x];
        }
    }
    return max;
};

arr=[23,45,1,6,7,45,3];
document.write(arr.getMax());
```
一般该方法不应放在html界面上，应该新建一个工具类.js文件，将新添加的方法放入工具文件中，然后通过`<script type="text/script" src="工具类.js></script>"`

Stringtool.js
```javascript
String.prototype.trim = function () {
    var start, end;
    start = 0;
    end = this.length - 1;
    while(start<end && this.charAt(start)==" "){
        start++;
    }
    while(start<end && this.charAt(end)==" "){
        end--;
    }
    return this.substring(start,end+1);
}
```

```javascript
<script type="text/javascript" src="Stringtool.js"></script>
var s="    sdfs    ";
document.write(s.trim());
```


自定义对象
---
```javascript
<html>

<head>
    <title>

        <head> </head>
    </title>
</head>

<body>
    <script type="text/javascript">
        //将js按照面向对象的方式进行开发

        //描述Person，暂时不定义内容，相当于面向对象中的构造器
        function Person(){
            alert("person run");
        }

        //通过描述建立对象，使用new关键字
        var p=new Person();

        //给定义对象动态添加属性和行为
        p.name="jian";
        p.age=23;
        p.show=function(){
            alert(this.name+"....."+this.age);
        };

        p.show();

        var p1=new Person;
        p1.show();//不可用，因为那些属性和行为只添加到了p对象中

    </script>
</body>

</html>
```
为了解决一次性只能给一个对象添加属性和行为的问题
```javascript
function Person(name,age){
            this.name=name;//将构造中直接将对象的应该具备的属性添加完，并赋值
            this.age=age;

            this.setName=function(name){
                this.name=name;
            };
            this.getName=function(){
                return this.name;
            };
            //覆盖
            this.toString=function(){
                return "Person[name="+name+",age="+age+"]";
            }
            
        }
        var p=new Person("jian",23);
        alert(p.getName()+"....."+p.age);
        alert(p);
        //不写toString时：[object Object]
        //加上toString时：Person[name=jian,age=23]
        p.show=function(){
            alert("p show");//此时若新建一个对象p1改方法不可被调用
        }
```
只有一个对象，如何完成对所有的对象创建新方法  
使用原型属性
```javascript
Person.prototype.show=function(){
    alert("show   "+this.name+"::"+this.age);
}
```
### js中两个特有语句
+ for(变量 in 对象) 遍历对象中的内容
```javascript
for(x in p){
    alert("x="+x);
    //若想获取值，这里不可以用p.x,用该方法和获取值必须有确定的属性或行为
    //只能用p[x]
};
```
两种获取值的方式：1.`p.name`  2.`p["name"]`



```javascript
 for(x in p){
    document.write("<pre>"+x+"="+p[x]+"</pre>"+"</br>");
};
运行结果：
name=jian

age=23

setName=function(name){
    this.name=name;
}

getName=function(){
    return this.name;
}

toString=function(){
    return "Person[name="+name+",age="+age+"]";
}
```
使用对象时的简便书写，如果对象名称很长，可以通过with语句简
```javascript
whih(p){
    age=30;
    name="haha";
    show();
}
