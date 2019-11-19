<!DOCTYPE html>
<html lang="en">
<head>
    <#import "spring.ftl" as spring>
    <meta charset="UTF-8">
    <title>中英文切换</title>
</head>
<body>

<form action="/changeSessionLanauage" method="post">
    <input name="lang" type="hidden" value="zh"  />     
    <button>切换为中文</button>
</form>

<form action="/changeSessionLanauage" method="post">
     <input name="lang" type="hidden" value="en"/>
     <button>切换为英文</button> 
</form>


<p><@spring.message code="welcome"/><br/></p>
<p><@spring.message code="index.homepage"/></p>
</body>
</html>