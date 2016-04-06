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

  <link rel="stylesheet" href="${contextPath}/media/css/bootstrap.min.css?_v=${appVersion}" media="screen">
  <link rel="stylesheet" href="${contextPath}/media/css/clean-blog.min.css?_v=${appVersion}"/>
  <link rel="stylesheet" href="${contextPath}/media/css/summernote/summernote.css?_v=${appVersion}"/>
  <link rel="stylesheet" href="${contextPath}/media/css/summernote/summernote-bs3.css?_v=${appVersion}"/>
  <link rel="stylesheet" href="${contextPath}/media/css/main.css?_v=${appVersion}"/>

  <!-- Custom Fonts -->
  <link href="http://maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
  <link href='http://fonts.googleapis.com/css?family=Lora:400,700,400italic,700italic' rel='stylesheet' type='text/css'>
  <link href='http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800' rel='stylesheet' type='text/css'>

  <script language="javascript" type="text/javascript">
    var contextPath = '${contextPath}';
  </script>
</head>
<body ng-cloak>
<div ng-show="$root.showAjaxLoader" class="ajax-loader ng-cloak">
  <i class="fa fa-circle-o-notch fa-spin fa-3x"></i>
</div>

<!-- Navigation -->
<nav class="navbar navbar-default navbar-custom navbar-fixed-top">
  <div class="container-fluid">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header page-scroll">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" ui-sref="articles">Simple Blog</a>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav navbar-right">
        <li>
          <a ui-sref="articles">Posts</a>
        </li>
        <li>
          <a ui-sref="create">Create post</a>
        </li>
      </ul>
    </div>
    <!-- /.navbar-collapse -->
  </div>
  <!-- /.container -->
</nav>

<!-- Page Header -->
<!-- Set your background image for this header on the line below. -->
<header class="intro-header" style="background-image: url('media/images/home-bg.jpg')">
  <div class="container">
    <div class="row">
      <div class="col-lg-8 col-lg-offset-2 col-md-10 col-md-offset-1">
        <div class="site-heading">
          <h1>Simple Blog</h1>
          <%--<hr class="small">--%>
          <%--<span class="subheading">A Simple Blog</span>--%>
        </div>
      </div>
    </div>
  </div>
</header>

<!-- Main Content -->

<div ui-view></div>

<hr>
<!-- Footer -->
<footer>
  <div class="container">
    <div class="row">
      <div class="col-lg-8 col-lg-offset-2 col-md-10 col-md-offset-1">
        <ul class="list-inline text-center">
          <li>
            <a href="#">
                                <span class="fa-stack fa-lg">
                                    <i class="fa fa-circle fa-stack-2x"></i>
                                    <i class="fa fa-twitter fa-stack-1x fa-inverse"></i>
                                </span>
            </a>
          </li>
          <li>
            <a href="#">
                                <span class="fa-stack fa-lg">
                                    <i class="fa fa-circle fa-stack-2x"></i>
                                    <i class="fa fa-facebook fa-stack-1x fa-inverse"></i>
                                </span>
            </a>
          </li>
          <li>
            <a href="https://github.com/sedrakpc">
                                <span class="fa-stack fa-lg">
                                    <i class="fa fa-circle fa-stack-2x"></i>
                                    <i class="fa fa-github fa-stack-1x fa-inverse"></i>
                                </span>
            </a>
          </li>
        </ul>
        <p class="copyright text-muted">Copyright &copy; Sedrak Dalaloyan 2016</p>
      </div>
    </div>
  </div>
</footer>

<script src="${contextPath}/media/js/lib/jquery.min.js?_v=${appVersion}"></script>
<!--[if lt IE 9]>
<script src="http://cdnjs.cloudflare.com/ajax/libs/es5-shim/2.2.0/es5-shim.js"></script>
<script>
  document.createElement('ui-select');
  document.createElement('ui-select-match');
  document.createElement('ui-select-choices');
</script>
<![endif]-->

<script src="${contextPath}/media/js/lib/bootstrap.min.js?_v=${appVersion}"></script>
<script src="${contextPath}/media/js/lib/clean-blog.min.js?_v=${appVersion}"></script>
<script src="${contextPath}/media/js/lib/summernote.min.js?_v=${appVersion}"></script>

<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.3/angular.min.js"></script>
<script src="https://code.angularjs.org/1.5.3/angular-resource.min.js"></script>
<script src="https://code.angularjs.org/1.5.3/angular-animate.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/angular-ui-router/0.2.18/angular-ui-router.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/angular-ui-bootstrap/1.3.1/ui-bootstrap-tpls.min.js"></script>
<script src="${contextPath}/media/js/lib/angular-summernote.min.js?_v=${appVersion}"></script>
<script src="${contextPath}/media/js/app/app.js?_v=${appVersion}"></script>
<script src="${contextPath}/media/js/app/common/utils.js?_v=${appVersion}"></script>
<script src="${contextPath}/media/js/app/common/common-controller.js?_v=${appVersion}"></script>
<script src="${contextPath}/media/js/app/common/common-service.js?_v=${appVersion}"></script>
<script src="${contextPath}/media/js/app/common/directives.js?_v=${appVersion}"></script>
<script src="${contextPath}/media/js/app/common/filters.js?_v=${appVersion}"></script>


</body>
</html>
