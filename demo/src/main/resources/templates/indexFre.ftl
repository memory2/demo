<!DOCTYPE html>
<html lang="en">
<head>
    <#import "spring.ftl" as spring>
    <#assign arg = ["AAA","张三"]>
    <title><@spring.messageArgs "title" ,arg /></title>
    <meta charset="UTF-8">
</head>
<body>
<br/>
<a class="changeLang" href="javascript:void(0);">english</a><br/>
<a class="changeLang" href="javascript:void(0);">中文</a><br/>
<@spring.message code="test.user"/><br/>
</body>
<script src="/bootstrap/js/jquery.min.js"></script>
<script>
    $(".changeLang").on("click", function () {
        switch ($(this).text()) {
            case "中文": {
                window.location.href = "indexFre?_lang=zh_CN";
                break;
            }
            case "english": {
                window.location.href = "indexFre?_lang=en_US";
                break;
            }
        }
    })
</script>
</html>