<%--
  Created by IntelliJ IDEA.
  User: nick
  Date: 19-6-2
  Time: 下午5:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
  pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Learning Project about SSM</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
</head>
<body>
    <div id="moods">
        <b>说说列表：</b><br>
        <c:forEach items="${moods}" var="mood">
            ----------------------------------
            <br>
            <b>用户:</b><span id="account">${mood.userName}</span><br>
            <b>说说:</b><span id="content">${mood.content}</span><br>
            <b>发表时间:</b><span id="publish_time">${mood.publishTime}</span><br>
            <b>点赞数量:</b><span id="praise_num">${mood.praiseNum}</span><br>
            <div style="margin-left: 350px;">
                <a id="praise" href="/springmvc/praise/${mood.id}/praiseRedis?userId=${mood.userId}">赞</a>
            </div>
        </c:forEach>
    </div>
</body>
<script></script>
</html>
