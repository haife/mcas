package com.haife.mcas.mvp;


import androidx.annotation.Nullable;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;

import com.blankj.utilcode.util.StringUtils;
import com.haife.mcas.integration.IRepositoryManager;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Copyright © KaiWu Technology Company
 *
 * @author Haife
 * @job Android Development
 * @company KW | 开物科技
 * @time 2019/7/1
 * @desc 基类 Model
 */
public class BaseModel implements IModel, LifecycleObserver {
    protected IRepositoryManager mRepositoryManager;

    public BaseModel(IRepositoryManager repositoryManager) {
        this.mRepositoryManager = repositoryManager;
    }


    /**
     * 将Object对象里面的属性和值转化成Map对象
     *
     * @param obj
     * @param key
     * @return
     */
    public static HashMap<String,Object> encryptObjectToMap(@Nullable Object obj, String key) {
        if (obj != null) {
            try {
                HashMap<String, Object> map = new HashMap<>();
                Field[] declaredFields = obj.getClass().getDeclaredFields();
                for (Field field : declaredFields) {
                    field.setAccessible(true);
                    map.put(field.getName(), field.get(obj));
                }
                map.put("64", getMacData(map, key));
               return map;
            } catch (Exception ignored) {

            }
        }

        return null;
    }

    /**
     * @param map
     * @param beanClass
     * @return
     * @throws Exception
     */
    public static Object mapToObject(Map<String, Object> map, Class<?> beanClass) throws Exception {
        Object obj = beanClass.newInstance();

        Field[] fields = obj.getClass().getDeclaredFields();
        for (Field field : fields) {
            int mod = field.getModifiers();
            if (Modifier.isStatic(mod) || Modifier.isFinal(mod)) {
                continue;
            }

            field.setAccessible(true);
            field.set(obj, map.get(field.getName()));
        }

        return obj;
    }


    /**
     * 对请求的数据进行加密
     *
     * @param map 请求的map
     * @return json 字符串
     */
    public static String getMacData(HashMap<String, Object> map, String key) throws Exception {
        Map<String, Object> resultMap = sortMapByKey(map);
        String sign = "";
        for (Map.Entry<String, Object> entry : resultMap.entrySet()) {
            if (StringUtils.isEmpty(sign)) {
                sign = String.valueOf(entry.getValue());
            } else {
                sign += entry.getValue();
            }
        }
        if (!StringUtils.isEmpty(sign)) {
            sign += key;
        }
        return sign;
    }


    /***
     * 进行排序
     * @param map
     * @return
     */
    public static Map<String, Object> sortMapByKey(Map<String, Object> map) {
        if (map == null || map.isEmpty()) {
            return null;
        }

        Map<String, Object> sortMap = new TreeMap<String, Object>((lhs, rhs) -> {
            // 这里改为小写进行比较
            Integer l = Integer.parseInt(lhs);
            Integer r = Integer.parseInt(rhs);
            return l.compareTo(r);
        });
        sortMap.putAll(map);
        return sortMap;
    }


    /**
     * 在框架中 {@link BasePresenter#onDestroy()} 时会默认调用 {@link IModel#onDestroy()}
     */
    @Override
    public void onDestroy() {
        mRepositoryManager = null;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    void onDestroy(LifecycleOwner owner) {
        owner.getLifecycle().removeObserver(this);
    }
}
