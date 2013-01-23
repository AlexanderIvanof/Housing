<%@page contentType="text/html" pageEncoding="UTF-8" isErrorPage="true"%>
<!DOCTYPE HTML>
<html>
    <head>
        <title>Новости</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>

    <body TEXT="#000000" LINK="#0000EE"
          VLINK="#551A8B" ALINK="#FF0000">

        <center>
            <table BORDER=5">
                <tr><th class="TITLE">
                        Последние новости</table>
        </center>
        <p>

            <b>Самые популярные новости:</b>
        <ol>
            <li><jsp:include page="news/Item1.html" flush="true"/>
            <li><jsp:include page="news/Item2.html" flush="true"/>
            <li><jsp:include page="news/Item3.html" flush="true"/>
            <li><jsp:include page="news/Item4.html" flush="true"/>
        </ol>
    </body>
</html> 