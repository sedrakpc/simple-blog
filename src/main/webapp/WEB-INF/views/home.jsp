<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html ng-app="blog">
<head>
  <meta charset="utf-8">
  <title>Home page</title>
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <!-- Favicon -->
  <link rel="shortcut icon" href="${contextPath}/media/images/favicon.ico">

  <%--<link rel="stylesheet" href="${contextPath}/media/css/inspinia/bootstrap.css?_v=${appVersion}" media="screen">--%>

  <script language="javascript" type="text/javascript">
    var contextPath = '${contextPath}';
  </script>
</head>
<body ng-cloak>
Hello world!
<div ng-show="$root.showAjaxLoader" class="ajax-loader ng-cloak">
  <i class="fa fa-circle-o-notch fa-spin fa-3x"></i>
</div>

<script src="${contextPath}/media/js/lib/inspinia/jquery-2.1.1.js?_v=${appVersion}"></script>
<!--[if lt IE 9]>
<script src="http://cdnjs.cloudflare.com/ajax/libs/es5-shim/2.2.0/es5-shim.js"></script>
<script>
  document.createElement('ui-select');
  document.createElement('ui-select-match');
  document.createElement('ui-select-choices');
</script>
<![endif]-->

</body>
</html>
