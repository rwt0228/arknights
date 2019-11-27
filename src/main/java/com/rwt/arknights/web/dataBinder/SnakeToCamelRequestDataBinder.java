package com.rwt.arknights.web.dataBinder;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.rwt.arknights.common.util.SnakeToCamelRequestParameterUtil;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.PropertyValue;
import org.springframework.web.servlet.mvc.method.annotation.ExtendedServletRequestDataBinder;

import javax.servlet.ServletRequest;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class SnakeToCamelRequestDataBinder extends ExtendedServletRequestDataBinder {

    public SnakeToCamelRequestDataBinder(Object target, String objectName) {
        super(target, objectName);
    }

    protected void addBindValues(MutablePropertyValues mpvs, ServletRequest request) {
        super.addBindValues(mpvs, request);

        //处理JsonProperty注释的对象
        Class<?> targetClass = getTarget().getClass();
        Field[] fields = targetClass.getDeclaredFields();
        for (Field field : fields) {    // 根据注解的值，将注解里面的值与属性名称进行绑定
            JsonProperty jsonPropertyAnnotation = field.getAnnotation(JsonProperty.class);
            if (jsonPropertyAnnotation != null && mpvs.contains(jsonPropertyAnnotation.value())) {
                if (!mpvs.contains(field.getName())) {
                    mpvs.add(field.getName(), mpvs.getPropertyValue(jsonPropertyAnnotation.value()).getValue());
                }
            }
        }

        List<PropertyValue> covertValues = new ArrayList<PropertyValue>();
        for (PropertyValue propertyValue : mpvs.getPropertyValueList()) {
            if(propertyValue.getName().contains("_")) {
                String camelName = SnakeToCamelRequestParameterUtil.convertSnakeToCamel(propertyValue.getName());
                if (!mpvs.contains(camelName)) {    //防止重复提交，如果已经手动录入value的话，就跳过
                    covertValues.add(new PropertyValue(camelName, propertyValue.getValue()));
                }
            }
        }
        mpvs.getPropertyValueList().addAll(covertValues);
    }
}