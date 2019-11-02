<!DOCTYPE HTML>
<html>
<head>
    <base href="<%=basePath%>">
    <title>客服交流</title>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <style>
        body {
            background: #7576C0;
            font-family: "楷体";
            color: #fff;
        }

        .box {
            width: 800px;
            height: 400px;
            margin: 0px auto;
            box-shadow: 2px 2px 5px 1px #000;
            background: #fff;
            padding-top: 1px;
        }

        .header {
            width: 100%;
            height: 25px;
            background: #50797E;
            text-shadow: 2px 2px 5px 1px #000;
            box-shadow: 2px 2px 5px 1px #000;
            margin-bottom: 5px;
        }

        .content {
            width: 100%;
            height: 400px;
            background: #fff;
            overflow: auto;
        }

        .content .result {
            width: 100%;
            color: #000;
        }

        .content .result .left {
            text-align: left;
            color: blue;
        }

        .content .result .right {
            text-align: right;
            color: green;
        }

        .send {
            width: 100%;
            height: 45px;
            background: #1D262F;
            margin-top: 5px;
            padding-top: 2px;
        }

        .send .message {
            height: 40px;
            font-size: 16px;
            font-family: "楷体";
            width: 735px;
            background: #000;
            color: #fff;
            border: 1px solid #000;
        }

        .send .btn {
            display: block;
            width: 50px;
            height: 40px;
            float: right;
            text-align: center;
            line-height: 40px;
            text-decoration: none;
            background: #fff;
            border-radius: 6px;
        }

        .send .btn:hover {
            background: #DOEOEA
        }
    </style>
    <script type="text/javascript" src="bootstrap/js/jquery.min.js"></script>
</head>
<script type="text/javascript">
    $(function () {
        $(".btn").click(function () {
            var result = $(".result");
            var message = $(".message").val();
            result.append("<div class='right'><img src='images/tou2.jpg' width=30;height=30;/>" + message + "</div>");
            $.ajax({
                type: "post",
                url: "/customer",
                data: {"message": message},
                success: function (msg) {
                    eval(msg);//eval将字符串作为java代码执行
                    var str = info.text;
                    if (info.url != undefined) {
                        str += "<a href='" + info.url + "' target='_blank'>" + info.url + "</a>";
                    }
                    if (info.list != undefined) {
                        for (var i = 0; i < info.list.length; i++) {
                            var tmp = info.list[i];
                            if (tmp.article != undefined) {
                                str += "<br><a href='" + tmp.detailurl + "' target='_blank'>" + tmp.article + "</a>";
                            } else if (tmp.trainnum != undefined) {
                                str += "<br><img src='" + tmp.icon + "' height=20 width=20/><a href='" + tmp.detailurl + "' target='_blank'>" + tmp.trainnum + "</a> :" + tmp.start + "-" + tmp.terminal + "发车时间:" + tmp.starttime + ";到站时间:" + tmp.endtime;
                            }
                        }
                    }

                    document.getElementById("bgmusic").play();
                    result.append("<div class='left'><img src='images/header.png' width=30;height=30;/>" + str + "</div>");
                }
            });
            $(".content").scrollTop($(".content")[0].scrollHeight);
            $(".message").val("");


        });
    });
    //键盘弹起事件 e代表even keyCode
    window.onkeyup = function (e) {
        if (e.keyCode == 13) {
            $(".btn").click();
        }
    }
</script>
<body>
<audio id="bgmusic" src="mp3/41.mp3"></audio>
<!-- 对话框 -->
<div class="box">
    <!-- 标题 -->
    <div class="header">
        与客户聊天中。。
    </div>
    <!-- 内容 -->
    <div class="content">
        <div class="result">
            <div class="left"><img src='/images/header.png' width=30;height=30;/>感谢与我聊天</div>
        </div>
    </div>
    <!-- 消息-->
    <div class="send">
        <input type="text" class="message" placeholder="请输入要咨询的内容"/>
        <a href="javascirpt:void(0)" class="btn">发送</a>
    </div>
</div>
</body>
</html>
