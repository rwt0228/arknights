<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- Start Main Menu Area -->
<div class="main-header-area header-sticky">
    <div class="container">
        <div class="getfund-nav-container breakpoint-off">
            <!-- getfund Menu -->
            <nav class="getfund-navbar justify-content-between" id="listingNav">

                <!-- Logo -->
                <a class="nav-brand" href="/"><img src="/images/logo-header.png" alt="logo"></a>

                <!-- Navbar Toggler -->
                <div class="getfund-navbar-toggler"><span class="navbarToggler"><span></span><span></span><span></span></span>
                </div>

                <!-- Menu -->
                <div class="getfund-menu">

                    <!-- close btn -->
                    <div class="getfundcloseIcon">
                        <div class="cross-wrap"><span class="top"></span><span class="bottom"></span></div>
                    </div>

                    <!-- Nav Start -->
                    <div class="getfundnav">
                        <ul id="responsive">
                            <li><a class="current sf-with-ul" href="/">主页</a>
                                <ul class="dropdown">
                                    <li><a href="index.html">Home 1</a></li>
                                    <li><a href="index-2.html">Home 2</a></li>
                                    <li><a href="index-3.html">Home 3</a></li>
                                    <li><a href="index-4.html">Home 4 - Map</a></li>
                                </ul>
                            </li>
                            <li><a class="sf-with-ul" href="#">Listings</a>
                                <ul class="dropdown">
                                    <li><a class="sf-with-ul" href="#">List Layout</a>
                                        <ul class="dropdown">
                                            <li><a href="listings-list-with-sidebar.html">With Sidebar</a></li>
                                            <li><a href="listings-list-full-width.html">Full Width</a></li>
                                            <li><a href="listings-list-full-width-with-map.html">Full Width + Map</a>
                                            </li>
                                        </ul>
                                    </li>
                                    <li><a class="sf-with-ul" href="#">Grid Layout</a>
                                        <ul class="dropdown">
                                            <li><a href="listings-grid-with-sidebar-1.html">With Sidebar 1</a></li>
                                            <li><a href="listings-grid-full-width.html">Full Width</a></li>
                                            <li><a href="listings-grid-full-width-with-map.html">Full Width + Map</a>
                                            </li>
                                        </ul>
                                    </li>
                                    <li><a class="sf-with-ul" href="#">Half Screen Map</a>
                                        <ul class="dropdown">
                                            <li><a href="listings-half-screen-map-list.html">List Layout</a></li>
                                            <li><a href="listings-half-screen-map-grid-1.html">Grid Layout 1</a></li>
                                        </ul>
                                    </li>
                                    <li><a class="sf-with-ul" href="#">Single Listings</a>
                                        <ul class="dropdown">
                                            <li><a href="listings-single-page.html">Single Listing 1</a></li>
                                            <li><a href="listings-single-page-2.html">Single Listing 2</a></li>
                                            <li><a href="listings-single-page-3.html">Single Listing 3</a></li>
                                        </ul>
                                    </li>
                                </ul>
                            </li>
                            <li><a class="sf-with-ul" href="#">Pages</a>
                                <ul class="dropdown">
                                    <li><a href="pages-faq.html">FAQ</a></li>
                                    <li><a href="pages-testimonials.html">Testimonials</a></li>
                                    <li><a href="pages-blog.html">Blog</a></li>
                                    <li><a href="pages-blog-details.html">Blog details</a></li>
                                    <li><a href="pages-contact.html">Contact</a></li>
                                </ul>
                            </li>
                            <li><a class="sf-with-ul" href="#0">Extra</a>
                                <ul class="dropdown">
                                    <li><a href="404.html">404 page</a></li>
                                    <li><a href="pricing-tables.html">Pricing tables</a></li>
                                    <li><a href="login.html">Login</a></li>
                                    <li><a href="register.html">Register</a></li>
                                    <li><a href="coming-soon.html">Coming Soon</a></li>
                                </ul>
                            </li>
                            <li><a class="sf-with-ul" href="#0">Admin</a>
                                <ul class="dropdown">

                                    <li><a href="add-listings.html">Add Listing</a></li>
                                    <li><a href="edit-listings.html">Edit Listing</a></li>
                                    <li><a href="booking-list.html">Booking List</a></li>

                                    <li><a href="listings.html">My Listings</a></li>
                                    <li><a href="profile.html">My Profile</a></li>
                                    <li><a href="oders.html">My Orders</a></li>
                                </ul>
                            </li>
                            <li><a class="sf-with-ul" href="/about">关于我们</a>
                                <ul class="dropdown">
                                    <li><a href="/about">联系我们</a></li>
                                </ul>
                            </li>
                            <c:if test="${ sessionScope.login_role.roleId eq 1 }">
                                <li><a class="sf-with-ul" href="/back">后台管理</a>
                                    <ul class="dropdown">
                                        <li><a href="/back/uploader">UP主管理</a></li>
                                        <li><a href="/back/video">视频管理</a></li>
                                    </ul>
                                </li>
                            </c:if>
                            <li style="width: 100px"></li>
                            <c:if test="${ empty sessionScope.login_user.account }">
                            <li class="right-side">
                                <ul>
                                    <li><a href="/passport/login" class="btn btn-primary">登录 </a></li>
                                    <li><a href="/passport/register" class="btn btn-primary">注册 </a></li>
                                </ul>
                            </li>
                            </c:if>
                            <c:if test="${ not empty sessionScope.login_user.account }">
                            <li><a class="sf-with-ul" href="#0">欢迎您，${ sessionScope.login_user.account}</a>
                                <ul class="dropdown">
                                    <li><a href="/user/profile">个人中心</a></li>
                                    <li><a href="/passport/login">切换账号</a></li>
                                    <li><a href="/passport/logout">注销</a></li>
                                </ul>
                            </li>
                            </c:if>
                        </ul>
                    </div>
                    <!-- Nav End -->

                </div>
            </nav>
        </div>
    </div>
</div>
<!-- End Main Menu Area -->