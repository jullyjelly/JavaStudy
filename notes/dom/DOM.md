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