package com.haife.mcas.di.scope;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;

import javax.inject.Scope;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Copyright © KaiWu Technology Company
 * @author Haife
 * @job Android Development
 * @company KW | 开物科技
 * @time 2019/7/1
 * @desc 自定义Activity注解 配合Dagger使用
 */


@Scope
@Documented
@Retention(RUNTIME)
public @interface ActivityScope {
}
