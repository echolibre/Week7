package com.example.echolin.week7.beans;

/**
 * Created by echolin on 2017/5/22.
 */

public class Configs {
    //根地址
    public static final String HOST = "app.vmoiver.com";
    //首页轮播图
    public static final String MAIN_PAGER = "/apiv3/index/"/*+getBanner*/;
    //首页最新电影列表
    public static final String MAIN_MOVIE = "/apiv3/post/"/*+getPostByTab*/;
    //电影列表详情
    public static final String MOVIE_DETAILS = "apiv2.vmovier.com/api/post/view";
    //电影列表详情web
    public static final String MOVIE_DETAILS_WEB = "app.vmoiver.com/postid?qingapp=app_new";
    //频道列表
    public static final String MAIN_CHANNEL = "/apiv3/cate/"/*+getList*/;
    //频道详情
    public static final String CHANNEL_DETAILS = "/apiv3/post/"/*+getPostInCate*/;
    //频道热门和专辑
    public static final String CHANNEL_HOTE = "/apiv3/post/"/*+getPostByTab*/;
    //系列
    public static final String SERIES = "/apiv3/series/"/*+getList*/;
    //系列详情页面
    public static final String SERIES_DETAILS = "/apiv3/series/view";
    //幕后顶部导航
    public static final String BACKSTAGE_NAVIGATION = "/apiv3/backstage/"/*+getCate*/;
    //幕后内容
    public static final String BACKSTAGE_CONTENT = "/apiv3/backstage/"/*+getPostByCate*/;
    //幕后内容详情
    public static final String BACKSTAGE_CONTENT_DETAILS = "/apiv3/post/view";
    //幕后内容详情WEB
    public static final String BACKSTAGE_CONTENT_DETAILS_WEB = "app.vmoiver.com/postid?qingapp=app_new";
}
