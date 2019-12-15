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