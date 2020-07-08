

### 介绍
MvpFM 目前采用的是 单工程 + 多 Module 的结构, 这里只展示基本规范。(开发人员必须严格按照规范进行开发)目前架构一共分为三层, 从低到高依次是基础层, 业务层和宿主层, 三层都集中在一个工程中。考虑技术

#### 代码规范

一个良好的代码规范，能够在项目当中发挥举足轻重的作用；它不仅能使你们的开发更加高效，而且还会减少BUG产生的几率，增强代码可维护性及稳定性

>[下载 Alibaba android开发手册](https://edu.aliyun.com/course/813?utm_content=g_1000029585)

项目必须严格按照阿里巴巴android开发手册中的各项规则，包括命名规则，资源存放规则。代码编写规范。


#### 宿主层

宿主层位于最上层, 主要作用是作为一个 App 壳, 将需要的模块组装成一个完整的 App, 这一层可以管理整个 App 的生命周期(比如 Application的初始化和各种组件以及三方库的初始化)

#### 业务层
业务层位于中层, 里面主要是根据业务需求和应用场景拆分过后的业务模块, 每个模块之间互不依赖, 但又可以相互交互, 比如一个商城 App 由 搜索, 订单, 购物车, 支付 等业务模块组成
> <font color = red> Tips: 每个业务模块都可以拥有自己独有的 SDK 依赖和自己独有的 UI 资源 (如果是其他业务模块都可以通用的 SDK 依赖 和 UI 资源 就可以将它们抽离到 基础 SDK</font>

 #### 业务模块拆分
  写业务之前先不要急着动手敲码, 应该先根据初期的产品需求到后期的运营规划结合起来清晰的梳理一下业务在未来可能会发生的发展, 确定业务之间的边界, 以及可能会发生的变化, 最后再确定下来真正需要拆分出来的业务模块再进行拆分

## 基础第三方库
1. [ <font color = red>`Mvp` 是 Google 官方出品的 `Mvp` 架构项目，含有多个不同的架构分支(此为 Dagger 分支).</font>](https://github.com/googlesamples/android-architecture/tree/todo-mvp-dagger/)
2. [<font color = red>`Dagger2` 是 Google 根据 Square 的 Dagger1 出品的依赖注入框架，通过 Apt 编译时生成代码，性能优于使用运行时反射技术的依赖注入框架.</font>](https://github.com/google/dagger)
3. [<font color = red>`RxJava` 提供优雅的响应式 API 解决异步请求以及事件处理.</font>](https://github.com/ReactiveX/RxJava)
4. [`RxAndroid` 为 Android 提供响应式 API.](https://github.com/ReactiveX/RxAndroid)
5. [`Rxlifecycle` `RxJava`使用中生命周期的解除订阅存在问题，这个框架通过绑定 Activity 和 Fragment 的生命周期完美解决该问题.](https://github.com/trello/RxLifecycle)
6. [`RxCache` 是使用注解，为 `Retrofit` 加入二级缓存 (内存，磁盘) 的缓存库.](https://github.com/VictorAlbertos/RxCache)
7. [`RxPermissions` 用于处理 Android 运行时权限的响应式库.](https://github.com/tbruyelle/RxPermissions)
8. [<font color = red>`Retrofit` 是 Square 出品的网络请求库，极大的减少了 Http 请求的代码和步骤.</font>](https://github.com/square/retrofit)
9. [<font color = red>`Okhttp` 同样 Square 出品，不多介绍，做 Android 的都应该知道.</font>](https://github.com/square/okhttp)
10. [`Gson` 是 Google 官方的 Json Convert 框架.](https://github.com/google/gson)
11. [`Butterknife` 是 JakeWharton 大神出品的 View 注入框架.](https://github.com/JakeWharton/butterknife)
12. [`AndroidEventBus` 是一个轻量级的 EventBus，该库没有引入到 `Mcas`，所以框架使用者可自由选择EventBus.](https://github.com/hehonghui/AndroidEventBus)
13. [`Timber` Log 框架容器，内部代码极少，但是思想非常不错.](https://github.com/JakeWharton/timber)
14. [`Glide` 是本框架默认封装到扩展库 `mcas-http-imageloader` 中的图片加载库，](https://github.com/bumptech/glide)
15. [ <font color = red>`QMUI Andrdoi` 是腾讯 官方出品的致力于提高项目 UI 开发效率的解决方案.项目中的很多UI 组件会用到,需要熟悉官方文档的功能。</font>](https://qmuiteam.com/android/)
16. [<font color = red>`BaseRecyclerViewAdapterHelper` 功能强大的RecycleView适配器。官方文档可以在简书里面找到</font>](https://github.com/CymChad/BaseRecyclerViewAdapterHelper)
17. [<font color = red>`ARouter` Alibaba 帮助Android App 进行组件化改造的路由框架</font>](https://github.com/alibaba/ARouter)
18. [<font color = red>`Fragmentation`为"单Activity ＋ 多Fragment","多模块Activity + 多Fragment"架构而生，简化开发，轻松解决动画、嵌套、事务相关等问题。</font>](https://github.com/YoKeyword/Fragmentation/blob/master/README_CN.md)
> 红色部分需要了解 

### 如何集成

#### 导入module

- 远程依赖

```
  implementation 'com.github.haife:mcas:version'
```


> 本框架提供一个含有大量第三方库的 config.gradle 文件 (里面的所有第三方库并不会全部被引入到项目中, 只是作为变量方便项目中多个位置进行引用, 特别适用于多 Module 的项目), 用于第三方库的版本管理, 将 config.gradle 复制进根目录, 并在项目的顶级 build.gradle 中引用它

- project.gradle

```
apply from: "config.gradle" //这里表示引用config.gradle文件
buildscript {
    ext.kotlin_version = '1.3.10'
    repositories {
        google()
        jcenter()

    }
    dependencies {
        classpath 'com.android.tools.build:gradle:3.4.1'
        classpath "org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlin_version"
    }
}

allprojects {
    repositories {
        google()
        jcenter()
        maven { url 'https://jitpack.io' }
    }
}

task clean(type: Delete) {
    delete rootProject.buildDir
}

```
#### 使用 config.gradle

>因为在顶级 build.gradle 中引用了 config.gradle, 所以在整个项目的所有 build.gradle 中都可以使用 rootProject来引用 config.gradle 中声明的内容

```
apply plugin: 'com.android.application'
apply plugin: 'kotlin-android'
apply plugin: 'kotlin-android-extensions'
apply plugin: 'kotlin-kapt'


dependencies {
    implementation fileTree(dir: 'libs', include: ['*.jar'])
    //kotlin
    implementation "org.jetbrains.kotlin:kotlin-stdlib-jdk7:$kotlin_version"
    //androidx
    implementation rootProject.ext.dependencies["appcompat"]
    implementation rootProject.ext.dependencies["constraint-layout"]
    //view
    implementation rootProject.ext.dependencies["recycleview"]
    //glide
    implementation rootProject.ext.dependencies["glide"]
    kapt rootProject.ext.dependencies["glide-compiler"]
    //dagger
    kapt rootProject.ext.dependencies["dagger2-compiler"]
    //如果你使用了Butterknife 插件,要添加下面，很多人因为没加这个而报控件无法找到
    implementation rootProject.ext.dependencies["butterknife"]
    kapt rootProject.ext.dependencies["butterknife-compiler"]
    //test
    testImplementation rootProject.ext.dependencies["junit"]
    implementation project(path: ':mcas')
}

```


注意：当前Demo使用的是AndroidX，不在使用support下面的包，为防止框架使用异常。请将上面内容复制到app.gradle中。另外如果工程不使用Kotlin开发，请将 **kapt** 替换成 **annotationProcessor** 并删除下方代码

```
apply plugin: 'kotlin-android'
apply plugin: 'kotlin-android-extensions'
apply plugin: 'kotlin-kapt'
```

> 建议统一使用 config.gradle 来管理一些项目的基本信息, 这样有多个 module 也可以直接使用同一个值


```
android {
    compileSdkVersion rootProject.ext.android["compileSdkVersion"]
    buildToolsVersion rootProject.ext.android["buildToolsVersion"]

    compileOptions {
        targetCompatibility JavaVersion.VERSION_1_8
        sourceCompatibility JavaVersion.VERSION_1_8
    }

    defaultConfig {
        applicationId "com.kaiwukj.android.mvpfw"
        minSdkVersion rootProject.ext.android["minSdkVersion"]
        targetSdkVersion rootProject.ext.android["targetSdkVersion"]
        versionCode rootProject.ext.android["versionCode"]
        versionName rootProject.ext.android["versionName"]
        testInstrumentationRunner "androidx.test.runner.AndroidJUnitRunner"
    }
}
```

#### 使用 Lambda
> 本框架默认使用 Lambda, 如您不想使用 Lambda 或使用 AndroidStudio v3.0 (兼容 Java8, 默认支持 Lambda, 但需手动指定 targetCompatibility), 请移除相关代码


#### 配置 AndroidManifest


```
    uses-permission android:name="android.permission.INTERNET"/>
    <uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE"/>
    <uses-permission android:name="android.permission.READ_EXTERNAL_STORAGE"/>
    <uses-permission android:name="android.permission.ACCESS_NETWORK_STATE"/>
    <uses-permission android:name="android.permission.ACCESS_WIFI_STATE"/>
    <uses-permission android:name="android.permission.CHANGE_WIFI_STATE"/>
    <uses-permission android:name="android.permission.READ_PHONE_STATE"/>
```


#### 指定Application

> 本框架想要正常运行需要使用框架提供的 BaseApplication, 当然您也可以自定义一个 Application 继承于它, 也可以不用继承, 直接将 BaseApplication 的代码复制到您自定义的 Application 中 (里面只有几行代码), 但是我并不推荐您使用后面的两种方式, 因为本框架已经向开发者提供了 ConfigModule#injectAppLifecycle 方法, 可以在运行时动态的向 BaseApplication 的任意生命周期中插入任意代码, 这样即使您不需要自定义 Application, 也可以做到初始化自己的业务


```
<application
         android:name="com.kaiwukj.android.mcas.base.BaseApplication"
</application>
```
####  配置框架自定义属性

>本框架使用和 Glide v3.0 相同的方式来配置自定义属性, 需要在 AndroidManifest 中声明它

```
 <!-- Mcas 配置 -->
        <meta-data
            android:name="com.kaiwukj.android.mvpfw.app.GlobalConfiguration"
            android:value="ConfigModule"/>
```

#### 混淆

> 由于本框架依赖大量三方库, 所以已经在 mcas Module 下的 proguard-rules.pro 中提供了本框架所依赖三方库的所有规则, 如果想使用它, 请复制它替换 demo Module 中的 proguard-rules.pro (Demo 并不能直接使用这个 proguard-rules.pro 进行混淆), 混淆前务必注意将 Java Bean, 自定义组件 等必需的规则添加进 proguard-rules.pro

### 快速开始开发工作

####  ConfigModule
>ConfigModule 用来给框架配置各种自定义属性和功能, 配合 GlobalConfigModule 使用, 功能非常强大

- 详情请查看类 `com.kaiwukj.android.mvpfw.app.GlobalConfiguration`

#### AppComponent
> Application 的生命周期和 App 是一致的, 所以适合提供一些单例对象, 本框架使用 Dagger2 管理, 使用 AppComponent 来提供全局所有的单例对象, 现在在 App 的任何地方, 都可通过 BaseApplication (可自定义 Application, 实现 App 接口即可) 的 getAppComponent() (非静态) 方法 (快捷方法 McasUtils.obtainAppComponentFromContext(context)), 拿到 AppComponent 里面声明的所有单例对象

```
@Singleton
@Component(modules = {AppModule.class, ClientModule.class, GlobalConfigModule.class})
public interface AppComponent {
    Application Application();

    //用于管理网络请求层,以及数据缓存层
    IRepositoryManager repositoryManager();

    //Rxjava错误处理管理类
    RxErrorHandler rxErrorHandler();

    OkHttpClient okHttpClient();

    //图片管理器,用于加载图片的管理类,默认使用glide,使用策略模式,可替换框架
    ImageLoader imageLoader();

    //gson
    Gson gson();

    //缓存文件根目录(RxCache和Glide的的缓存都已经作为子文件夹在这个目录里),应该将所有缓存放到这个根目录里,便于管理和清理,可在GlobeConfigModule里配置
    File cacheFile();

    //用于管理所有activity
    AppManager appManager();

    void inject(AppDelegate delegate);
}

```

#### RepositoryManager
> RepositoryManager 用来管理网络请求层以及数据缓存层

- 自行定义 Retrofit Service, 如下, 熟练 Retrofit 请忽略

```
public interface CommonService {
    String HEADER_API_VERSION = "Accept: application/vnd.github.v3+json";
    @Headers({HEADER_API_VERSION})
    @GET("/users")
    Observable<List<User>> getUsers(@Query("since") int lastIdQueried, @Query("per_page") int perPage);
}
```

- 自行定义 RxCache Provider, 如下, 熟练 RxCache 请忽略,数据是否缓存需要自己判断

```
public interface CommonCache {
    @LifeCache(duration = 2, timeUnit = TimeUnit.MINUTES)
    Observable<Reply<List<User>>> getUsers(Observable<List<User>> oUsers, DynamicKey idLastUserQueried, EvictProvider evictProvider);

}
```

- 在 Model 中通过 RepositoryManager.obtainRetrofitService() 或 RepositoryManager.obtainCacheService() 使用这些服务


```
  @Override
    public Observable<List<User>> getUsers(int lastIdQueried, boolean update) {
        //使用rxcache缓存,上拉刷新则不读取缓存,加载更多读取缓存
        return Observable.just(mRepositoryManager
                .obtainRetrofitService(UserService.class)
                .getUsers(lastIdQueried, USERS_PER_PAGE))
                .flatMap((Function<Observable<List<User>>, ObservableSource<List<User>>>) observable -> mRepositoryManager.obtainCacheService(CommonCache.class)
                        .getUsers(observable
                                , new DynamicKey(lastIdQueried)
                                , new EvictDynamicKey(update))
                        .map(listReply -> listReply.getData()));

    }
```
### MVP 相关
> 定义业务逻辑 MVP, 继承 MVP 中各自的基类即可, 这里可以稍微粗力度的定义 MVP 类, 即无需每个页面 (Activity 和 Fragment) 都定义不同的 MVP 类, 可以按照相同的业务逻辑使用一组 MVP 类 

#### Contract
> 这里根据 Google 官方的 MVP 架构,可以在 Contract 中定义 MVP 类的接口, 便于管理, 本框架无需定义 Presenter 接口, 所以在 Contract 中只定义 View 和 Model 的接口


```
public interface UserContract {
	//对于经常在日常开发中使用到的关于 UI 的方法可以定义到 IView 中, 如显示隐藏进度条, 和显示文字消息
    interface View extends IView {
        void setAdapter(DefaultAdapter adapter);
        void startLoadMore();
        void endLoadMore();
    }
	//Model 层定义接口, 外部只需关心 Model 返回的数据, 无需关心内部细节, 即是否使用缓存
    interface Model extends IModel{
        Observable<List<User>> getUsers(int lastIdQueried, boolean update);
    }
}
```

#### View
>一般让 Activity 或 Fragment 实现 Contract 中定义的 View 接口, 供 Presenter 调用对应方法响应 UI, BaseActivity 默认注入 Presenter, 如想使用 Presenter, 必须将范型指定为 Presenter 的实现类 (虽然框架只可以指定一个范型, 但是可以自行生成并持有多个 Presenter, 达到复用的目的, 如何复用 Presenter?), 还需要实现 setupActivityComponent 来提供 Presenter 需要的 Component 和 Module (如这个页面逻辑简单, 并不需要 Presenter, 那就不要指定范型, 也不要实现 setupActivityComponent 方法)


> 
```
public class UserActivity extends BaseActivity<UserPresenter> implements UserContract.View {

    @Override
    protected void setupActivityComponent(AppComponent appComponent) {
        DaggerUserComponent
                .builder()
                .appComponent(appComponent)
                .userModule(new UserModule(this))
                .build()
                .inject(this);

    }

    @Override
    public int initView(Bundle savedInstanceState) {
        return R.layout.activity_user;
    }

    @Override
    protected void initData() {

    }
}
```

因为 Java 只能单继承, 所以如果要用到需要继承特定的三方库, 那你就需要自己自定义 继承于这个特定的BaseActivity, 然后再按照BaseActivity 的格式, 将代码复制过去, 记住一定要实现IActivity

>  Model
> Model 必须实现 Contract 的 Model 接口, 并且继承 BaseModel, 然后通过 IRepositoryManager 拿到需要的 Service 和 Cache, 为 Presenter 提供需要的数据 (是否使用缓存请自行选择)

```java
@ActivityScope
public class UserModel extends BaseModel implements UserContract.Model{
    
     @Inject
    public UserModel(IRepositoryManager repositoryManager) {
        super(repositoryManager);
    }
    
    @Override
    public Observable<List<User>> getUsers(int lastIdQueried, boolean update) {
    	return mRepositoryManager.obtainRetrofitService(UserService.class)
    						 .getUsers();
    }
}
```

#### Presenter


>Presenter 在 MVP 中的大部分作用是实现业务逻辑代码, 从 Model 层获取数据, 在调用 View 层显示数据, 首先必须实现 BasePresenter, 并指定 View 和 Model 的范型, 注意一定要指定 Contract 中定义的接口, Presenter 需要的 View 和 Model, 都使用 Dagger2 来注入已达到解藕


```
@ActivityScope
public class UserPresenter extends BasePresenter<UserContract.Model, UserContract.View> {

    @Inject
    public UserPresenter(UserContract.Model model, UserContract.View rootView) {
        super(model, rootView);
    }
    //这里定义业务方法, 响应用户的交互
    public void requestUsers(final boolean pullToRefresh) {
    ｝
}
```

#### MVP Module
>这里的 Module 可以提供当前业务逻辑所对应的 View 和 Model 接口 (Contract 中定义的接口) 的实现类, Model 需要 AppComponent 中提供的 RepositoryManager 来实现网络请求和数据缓存, 所以需要通过 Component 依赖 AppComponent 来拿到这个对象

```java
@Module
public class UserModule {
    private UserContract.View view;

    //构建UserModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
    public UserModule(UserContract.View view) {
        this.view = view;
    }
   
    @ActivityScope
    @Provides
    UserContract.View provideUserView(){
        return this.view;
    }

    @ActivityScope
    @Provides
    UserContract.Model provideUserModel(UserModel model){
        return model;
    }
}
```
#### MVP Component

>这里需要注意的是此 Component 必须依赖 AppComponent, 这样才能提供 Model 需要的 RepositoryManager, 提供 inject() 方法就能将 Module 及 AppComponent 中提供的对象注入到对应的类中, inject() 方法中的参数不能是接口, 怎么注入?


```
@ActivityScope
@Component(modules = UserModule.class, dependencies = AppComponent.class)
public interface UserComponent {
    void inject(UserActivity activity);
}
```

##### Dagger Scope (自定义注解)

>在上面的代码中 ActivityScope 大量的出现在 Module 和 Component 中, Dagger2 使用 Scope 限制每个 Module 中提供的对象的生命周期, Dagger2 默认只提供一个 @Singleton Scope 即单例, 本框架默认只提供 @ActvityScope 和 @FragmentScope, 如有其他需求请自行实现, 在 Module 和 Component 中定义相同的 Scope 后, Module 中提供的对象的生命周期会和 Component 的生命周期进行绑定 (即在 Component 的生命周期内, 如需多次使用到 Moudle 中提供的对象, Dagger 只会调用一次带有 @Provide 注解的方法, 得到此对象)


## 功能使用
>lobalConfigModule 使用建造者模式将 App 的全局配置信息封装进 Module (使用 Dagger 注入到需要配置信息的地方), 可以配置 CacheFile、Interceptor 等, 甚至于 Retrofit、Okhttp、RxCache 都可以自定义配置, 因为使用的是建造者模式, 所以如您有其他配置信息需要使用 Dagger 注入, 直接就可以添加进 Builder, 并且不会影响到其他地方

- GlobalConfigModule 需依赖于 ConfigModule 使用
- 了解详情请自行查看代码

#### 全局捕捉 Http 请求和响应
> 在 全局配置类 中通过 GlobalConfigModule.Builder.globalHttpHandler() 方法传入 GlobalHttpHandler


```java
package com.kaiwukj.android.mvpfw.app;

import android.content.Context;
import android.text.TextUtils;

import com.kaiwukj.android.mcas.http.GlobalHttpHandler;
import com.kaiwukj.android.mcas.http.log.RequestInterceptor;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * 展示 {@link GlobalHttpHandler} 的用法
 */
public class GlobalHttpHandlerImpl implements GlobalHttpHandler {
    private Context context;

    public GlobalHttpHandlerImpl(Context context) {
        this.context = context;
    }

    /**
     * 这里可以先客户端一步拿到每一次 Http 请求的结果, 可以先解析成 Json, 再做一些操作, 如检测到 token 过期后
     * 重新请求 token, 并重新执行请求
     *
     * @param httpResult 服务器返回的结果 (已被框架自动转换为字符串)
     * @param chain      {@link okhttp3.Interceptor.Chain}
     * @param response   {@link Response}
     * @return {@link Response}
     */
    @NonNull
    @Override
    public Response onHttpResultResponse(@Nullable String httpResult, @NonNull Interceptor.Chain chain, @NonNull Response response) {
        if (!TextUtils.isEmpty(httpResult) && RequestInterceptor.isJson(response.body().contentType())) {

        }

        /* 这里如果发现 token 过期, 可以先请求最新的 token, 然后在拿新的 token 放入 Request 里去重新请求
        注意在这个回调之前已经调用过 proceed(), 所以这里必须自己去建立网络请求, 如使用 Okhttp 使用新的 Request 去请求
        create a new request and modify it accordingly using the new token
        Request newRequest = chain.request().newBuilder().header("token", newToken)
                             .build();

        retry the request

        response.body().close();
        如果使用 Okhttp 将新的请求, 请求成功后, 再将 Okhttp 返回的 Response return 出去即可
        如果不需要返回新的结果, 则直接把参数 response 返回出去即可*/
        return response;
    }

    /**
     * 这里可以在请求服务器之前拿到 {@link Request}, 做一些操作比如给 {@link Request} 统一添加 token 或者 header 以及参数加密等操作
     *
     * @param chain   {@link okhttp3.Interceptor.Chain}
     * @param request {@link Request}
     * @return {@link Request}
     */
    @NonNull
    @Override
    public Request onHttpRequestBefore(@NonNull Interceptor.Chain chain, @NonNull Request request) {
        /* 如果需要在请求服务器之前做一些操作, 则重新构建一个做过操作的 Request 并 return, 如增加 Header、Params 等请求信息, 不做操作则直接返回参数 request
        return chain.request().newBuilder().header("token", tokenId)
                              .build(); */
        return request;
    }
}

```


#### 全局错误处理及发生错误时重新执行
> 如果需要使用 Rxjava 的全局错误处理, 需要在 全局配置类 中通过 GlobalConfigModule.Builder.responseErroListener() 方法传入 ResponseErroListener, 并在 Rxjava 每次订阅调用 subscribe() 方法时, 传入 ErrorHandleSubscriber 实例, ErrorHandleSubscriber 实例的创建需要传入 AppComponent 中提供的 RxErrorHandler, ErrorHandleSubscriber 已经默认实现了 OnError 方法, 如想自定义可以重写 OnError 方法

```java
public class GlobalConfiguration implements ConfigModule {
    @Override
    public void applyOptions(Context context, GlobalConfigModule.Builder builder) {
        builder.responseErrorListener((context1, e) -> {
                    /* 用来提供处理所有错误的监听, RxJava 订阅时必须传入 ErrorHandleSubscriber 实例, 此监听才生效 */
                    Timber.w("Error" + e.getMessage());
                });
    }
}

```

- 在present的网络请求中或者Rxjava中

```
Observable
.just(1)
.subscribe(new ErrorHandleSubscriber<Integer>(mErrorHandler) {
     @Override
     public void onNext(Integer Integer) {
 
     }
});
```

####  ImageLoader 如何扩展以及切换图片请求框架

> 本框架默认使用 Glide 实现图片加载功能, 使用 ImageLoader 为业务层提供统一的图片请求接口, ImageLoader 使用策略模式和建造者模式, 可以动态切换图片请求框架 (比如说切换成 Picasso), 并且加载图片时传入的参数也可以随意扩展 ( loadImage() 方法在需要扩展参数时, 调用端也不需要改动, 全部通过 Builder 扩展, 比如您想让内部的图片加载框架, 清除缓存您只需要定义个 boolean 字段, 内部的图片加载框架根据这个字段 if|else 做不同的操作, 其他操作同理, 当需要切换图片请求框架或图片请求框架升级后变更了 Api 时, 这里可以将影响范围降到最低, 所以封装 ImageLoader 是为了屏蔽这个风险)

- 本框架默认提供了 GlideImageLoaderStrategy 和 ImageConfigImpl 简单实现了图片加载逻辑 ,通过 GlobalConfigModule.Builder#imageLoaderStrategy(new GlideImageLoaderStrategy); 完成注册), 方便快速使用, 但开发中难免会遇到复杂的使用场景, 所以本框架推荐即使不切换图片请求框架继续使用 Glide, 也请按照下面的方法, 自行实现图片加载策略。

- 使用 ImageLoader 必须传入一个实现了 BaseImageLoaderStrategy 接口的图片加载实现类从而实现动态切换, 所以首先要实现BaseImageLoaderStrategy, 实现时必须指定一个继承自 ImageConfig 的实现类, 使用建造者模式, 可以储存一些信息, 比如 URL、ImageView、Placeholder 等, 可以不断的扩展, 供图片加载框架使用

> 以下代码仅仅提供测试使用

- PicassoImageLoaderStrategy
```
public class PicassoImageLoaderStrategy implements BaseImageLoaderStrategy<PicassoImageConfig> {
	 @Override
    public void loadImage(Context ctx, PicassoImageConfig config) {
                        Picasso.with(ctx)
    			.load(config.getUrl())
    			.into(config.getImageView());
    ｝
}
```

- PicassoImageConfig


```
public class PicassoImageConfig extends ImageConfig {

    private PicassoImageConfig(Buidler builder) {
        this.url = builder.url;
        this.imageView = builder.imageView;
        this.placeholder = builder.placeholder;
        this.errorPic = builder.errorPic;
    }

    public static Buidler builder() {
        return new Buidler();
    }


    public static final class Buidler {
        private String url;
        private ImageView imageView;
        private int placeholder;
        protected int errorPic;

        private Buidler() {
        }

        public Buidler url(String url) {
            this.url = url;
            return this;
        }

        public Buidler placeholder(int placeholder) {
            this.placeholder = placeholder;
            return this;
        }

        public Buidler errorPic(int errorPic){
            this.errorPic = errorPic;
            return this;
        }

        public Buidler imagerView(ImageView imageView) {
            this.imageView = imageView;
            return this;
        }

        public PicassoImageConfig build() {
            if (url == null) throw new IllegalStateException("url is required");
            if (imageView == null) throw new IllegalStateException("imageview is required");
            return new PicassoImageConfig(this);
        }
    }
}
```

- 在 App 刚刚启动初始化时, 通过 GlobalConfigModule 传入上面扩展的 PicassoImageLoaderStrategy, 也可以在 App 运行期间通过 AppComponent 拿到 ImageLoader 对象后, 调用 setLoadImgStrategy(new PicassoImageLoaderStrategy) 替换之前的实现 (默认使用 Glide)

```java
//方法一: 通过GlobalConfigModule传入
public class GlobalConfiguration implements ConfigModule {
    @Override
    public void applyOptions(Context context, GlobalConfigModule.Builder builder) {
        builder.imageLoaderStrategy(new PicassoImageLoaderStrategy);
    }
}

//方法二: 拿到 AppComponent 中的 ImageLoader, 通过方法传入
    ArmsUtils.obtainAppComponentFromContext(context)
	.imageLoader()
	.setLoadImgStrategy(new PicassoImageLoaderStrategy());


//使用方法:
ArmsUtils.obtainAppComponentFromContext(context)
	.imageLoader()
	.loadImage(mApplication, PicassoImageConfig
                .builder()
                .url(data.getUrl())
                .imagerView(mAvater)
                .build());
```

#### 内存泄漏检测
原理就不表述了，还是基于java内存管理和引用类型这些。不清楚请自行百度。内存泄漏最终可能会导致OOM，进而发生崩溃。特别是在手机运行内存较小的设备上。这里只提供一种检测方案： [LeakCanary](https://square.github.io/leakcanary/)

#####  常见场景
- 单例
- handle
- 非静态内部类/匿名内部类

> 建议
- 在Activity/Fragment销毁时回收对象工作。比如handle任务，Rxjava的解除订阅，Adapter置空等
- RecycleView的优化，[具体可参考这篇文章](https://www.jianshu.com/p/bd432a3527d6)
- 网络、文件等流需要关闭
- 手动注册广播时，调用unregisterReceiver()
- Service 任务完成后需要关闭服务
- EventBus 等观察者模式的框架记住手动解除注册


#### 屏幕适配

>[字节跳动屏幕适配方案](https://mp.weixin.qq.com/s/d9QCoBP6kV9VSWvVldVVwA)


#### Ui

作为通用框架，框架不提供与 UI 有关的任何第三方库,请使用自己熟悉的Ui框架，提升开发效率。

#### 工具类 AndroidUtilCode
框架中没有集成，因为项目比较大，实际开发中很多Utils用不到，请开发者按需求自行集成
[AndroidUtilCode](https://github.com/Blankj/AndroidUtilCode)



## 结尾
如果在使用中有任何问题或者建议，欢迎提出讨论。本框架不强制要求使用。如果自己有能满足业务需求并且能熟练使用的框架。




