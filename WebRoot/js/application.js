(function ($) {
    var Application = function () {

    };
    window.mainUrl = "http://192.168.8.246:8080/wenet";
//    window.mainUrl = "http://192.168.30.26:8080";


    $(function () {
        

        $("#tab").append(" <ul class=\"am-navbar-nav am-cf am-avg-sm-4\">\n" +
            "\t\t          <li >\n" +
            "\t\t            <a href=\"index.html\" class=\"\">\n" +
            "\t\t                <span class=\"\"><img src=\"images/navs.png\"/></span>\n" +
            "\t\t                <span class=\"am-navbar-label\" >首页</span>\n" +
            "\t\t            </a>\n" +
            "\t\t          </li>\n" +
            "\t\t          <li>\n" +
            "\t\t            <a href=\"run_pool.jsp\" class=\"\">\n" +
            "\t\t                <span class=\"\"><img src=\"images/nav1.png\"/></span>\n" +
            "\t\t                <span class=\"am-navbar-label\">跑腿池</span>\n" +
            "\t\t            </a>\n" +
            "\t\t          </li>\n" +
            "\t\t          <li>\n" +
            "\t\t            <a href=\"we.html\" class=\"\">\n" +
            "\t\t                <span class=\"\"><img src=\"images/nav2.png\"/></span>\n" +
            "\t\t                <span class=\"am-navbar-label\">咨询</span>\n" +
            "\t\t            </a>\n" +
            "\t\t          </li>\n" +
            "\t\t          <li >\n" +
            "\t\t            <a href=\"member.jsp\" class=\"\">\n" +
            "\t\t                <span class=\"\"><img src=\"images/nav3.png\"/></span>\n" +
            "\t\t                <span class=\"am-navbar-label\">我的</span>\n" +
            "\t\t            </a>\n" +
            "\t\t          </li>\n" +
            "\t\t   \n" +
            "\t\t      </ul>");
        $("#tab1").append(" <ul class=\"am-navbar-nav am-cf am-avg-sm-4\">\n" +
            "\t\t          <li >\n" +
            "\t\t            <a href=\"index.html\" class=\"\">\n" +
            "\t\t                <span class=\"\"><img src=\"images/nav.png\"/></span>\n" +
            "\t\t                <span class=\"am-navbar-label\">首页</span>\n" +
            "\t\t            </a>\n" +
            "\t\t          </li>\n" +
            "\t\t          <li>\n" +
            "\t\t            <a href=\"run_pool.jsp\" class=\"\">\n" +
            "\t\t                <span class=\"\"><img src=\"images/nav1s.png\"/></span>\n" +
            "\t\t                <span class=\"am-navbar-label\">跑腿池</span>\n" +
            "\t\t            </a>\n" +
            "\t\t          </li>\n" +
            "\t\t          <li>\n" +
            "\t\t            <a href=\"we.html\" class=\"\">\n" +
            "\t\t                <span class=\"\"><img src=\"images/nav2.png\"/></span>\n" +
            "\t\t                <span class=\"am-navbar-label\">咨询</span>\n" +
            "\t\t            </a>\n" +
            "\t\t          </li>\n" +
            "\t\t          <li >\n" +
            "\t\t            <a href=\"member.jsp\" class=\"\">\n" +
            "\t\t                <span class=\"\"><img src=\"images/nav3.png\"/></span>\n" +
            "\t\t                <span class=\"am-navbar-label\">我的</span>\n" +
            "\t\t            </a>\n" +
            "\t\t          </li>\n" +
            "\t\t   \n" +
            "\t\t      </ul>");
        $("#tab2").append(" <ul class=\"am-navbar-nav am-cf am-avg-sm-4\">\n" +
            "\t\t          <li >\n" +
            "\t\t            <a href=\"index.html\" class=\"\">\n" +
            "\t\t                <span class=\"\"><img src=\"images/nav.png\"/></span>\n" +
            "\t\t                <span class=\"am-navbar-label\">首页</span>\n" +
            "\t\t            </a>\n" +
            "\t\t          </li>\n" +
            "\t\t          <li>\n" +
            "\t\t            <a href=\"run_pool.jsp\" class=\"\">\n" +
            "\t\t                <span class=\"\"><img src=\"images/nav1.png\"/></span>\n" +
            "\t\t                <span class=\"am-navbar-label\">跑腿池</span>\n" +
            "\t\t            </a>\n" +
            "\t\t          </li>\n" +
            "\t\t          <li>\n" +
            "\t\t            <a href=\"we.html\" class=\"\">\n" +
            "\t\t                <span class=\"\"><img src=\"images/nav2s.png\"/></span>\n" +
            "\t\t                <span class=\"am-navbar-label\">咨询</span>\n" +
            "\t\t            </a>\n" +
            "\t\t          </li>\n" +
            "\t\t          <li >\n" +
            "\t\t            <a href=\"member.jsp\" class=\"\">\n" +
            "\t\t                <span class=\"\"><img src=\"images/nav3.png\"/></span>\n" +
            "\t\t                <span class=\"am-navbar-label\">我的</span>\n" +
            "\t\t            </a>\n" +
            "\t\t          </li>\n" +
            "\t\t   \n" +
            "\t\t      </ul>");
        $("#tab3").append(" <ul class=\"am-navbar-nav am-cf am-avg-sm-4\">\n" +
            "\t\t          <li >\n" +
            "\t\t            <a href=\"index.html\" class=\"\">\n" +
            "\t\t                <span class=\"\"><img src=\"images/nav.png\"/></span>\n" +
            "\t\t                <span class=\"am-navbar-label\">首页</span>\n" +
            "\t\t            </a>\n" +
            "\t\t          </li>\n" +
            "\t\t          <li>\n" +
            "\t\t            <a href=\"run_pool.jsp\" class=\"\">\n" +
            "\t\t                <span class=\"\"><img src=\"images/nav1.png\"/></span>\n" +
            "\t\t                <span class=\"am-navbar-label\">跑腿池</span>\n" +
            "\t\t            </a>\n" +
            "\t\t          </li>\n" +
            "\t\t          <li>\n" +
            "\t\t            <a href=\"we.html\" class=\"\">\n" +
            "\t\t                <span class=\"\"><img src=\"images/nav2.png\"/></span>\n" +
            "\t\t                <span class=\"am-navbar-label\">咨询</span>\n" +
            "\t\t            </a>\n" +
            "\t\t          </li>\n" +
            "\t\t          <li >\n" +
            "\t\t            <a href=\"member.jsp\" class=\"\">\n" +
            "\t\t                <span class=\"\"><img src=\"images/nav3s.png\"/></span>\n" +
            "\t\t                <span class=\"am-navbar-label\">我的</span>\n" +
            "\t\t            </a>\n" +
            "\t\t          </li>\n" +
            "\t\t   \n" +
            "\t\t      </ul>");

    });


    $.application = $.application || new Application();


})(jQuery);