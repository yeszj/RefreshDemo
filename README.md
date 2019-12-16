# 效果展示

![image](https://github.com/yeszj/RefreshDemo/blob/master/refresh.gif)


# RefreshDemo
刷新框架的二次封装使用

不知道大家在工作中有没有遇到这种情况，在你项目中使用的刷新框架由于作者不维护了或者存在问题或者产品经理说这种刷新效果不好看，需要更换刷新框架，如果
我们在项目初期没有对刷新框架进行二次封装，我相信在更换框架时你会崩溃的，要是有几十上百个页面,想想都可怕。所以我使用代理的方式对框架进行了二次封装，
只需一行代码接口切换框架，大大节省了开发时间。
大家可以把module_refresh这个module下载下来导入到项目当中。

# 如何使用呢？
1.在你的Application中初始化

public class MyApplication extends Application {

    static {
        //如果需要切换框架，只需在实现一个IrefreshProcessor代理类即可
        RefreshManager.init(new SmartRefreshProcessor());
    }
    
    @Override
    public void onCreate() {
        super.onCreate();
    }
}

2.在activity或者fragment中使用

private void initRefresh() {

        RefreshManager.getInstance().initRefresh(this, footView, true, refreshLayout, new IRefreshCallBack() {
            @Override
            public void onRefresh() {
                //刷新
                pageNum = 1;
                getData();
            }
            
            @Override
            public void onLoadMore() {
                //加载更多
                pageNum++;
                getData();
            }
        });
        beginRefreshing();
        
        
 # 需要注意的地方？
 1.因为在切换框架时，布局文件中引用的刷新view都需要全部切换，所以自己写个MyRefreshLayout类继承框架中的刷新view，在布局文件中我们可以使用自定义的
 MyRefreshLayout来代替框架中的刷新view，这样如果后期切换刷新框架，我们只需要把MyRefreshLayout的继承关系改一下就可以了，布局文件中一行代码都不需要
 改，无形之中节省了大量的工作量。
 
 2.在activity的基类中定义刷新的几个方法，开始刷新，结束刷新，加载更多结束等，因为每个框架的这几个方法名可能都不一样，所以在基类中进行封装，后期切换时，只需要更改基类中的几个方法即可。
 
 具体使用方法请大家参考代码中的实例
