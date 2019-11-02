<!DOCTYPE html>
<html lang="en">
<head>
    <#import "spring.ftl" as spring>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<a href="/index?lang=zh_CN">中文</a>
<a href="/index?lang=en_US">ENGLISH</a>


<form action="/changeSessionLanauage" method="post">
         <input name="lang" type="hidden" value="zh"  />
         
    <button>切换为中文</button>
       
</form>

      
<form action="/changeSessionLanauage" method="post">
             <input name="lang" type="hidden" value="en"/>
             
    <button>切换为英文</button>
          
</form>


<p> <@spring.message code="welcome"/><br/></p>
</body>
</html>