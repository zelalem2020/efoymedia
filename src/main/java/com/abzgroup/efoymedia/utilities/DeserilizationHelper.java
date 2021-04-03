package com.abzgroup.efoymedia.utilities;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.apache.commons.validator.GenericValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

@Component
public class DeserilizationHelper {

    @Autowired
    private SingleMapper singleMapper;

    public <T> T deserialize(JsonNode node, T newObject, Class<T> targetClass) throws IllegalAccessException {

        Field[] declaredFields = targetClass.getDeclaredFields();
        for (Field field : declaredFields) {


            field.setAccessible(true);
            JsonNode nodeValue = node.get(field.getName());

            boolean aNull = nodeValue == null || String.valueOf(nodeValue).equals("null") || StringUtils.trimToEmpty(String.valueOf(nodeValue)).isEmpty();
            String inp = (node.get(field.getName()) == null) ? "null" : node.get(field.getName()).asText();
            String defaults = String.valueOf(defaultValues(targetClass, field, newObject));

            //Long
            if (Long.class.equals(field.getType()) || long.class.equals(field.getType())) {
                long l = NumberUtils.toLong(inp, (defaults.equals("null")) ? 0L : NumberUtils.toLong(defaults));
                field.set(newObject, l);
            }
            //Integer
            else if (Integer.class.equals(field.getType()) || int.class.equals(field.getType())) {
                int i = NumberUtils.toInt(inp, (defaults.equals("null")) ? 0 : NumberUtils.toInt(defaults));
                field.set(newObject, i);
            }
            //Double
            else if (Double.class.equals(field.getType()) || double.class.equals(field.getType())) {
                double d = NumberUtils.toDouble(inp, (defaults.equals("null")) ? 0.0d : NumberUtils.toDouble(defaults));
                field.set(newObject, d);
            }
            //Float
            else if (Float.class.equals(field.getType()) || float.class.equals(field.getType())) {
                float f = NumberUtils.toFloat(inp, (defaults.equals("null")) ? 0.0f : NumberUtils.toFloat(defaults));
                field.set(newObject, f);
            }
            //Boolean
            else if (Boolean.class.equals(field.getType()) || boolean.class.equals(field.getType())) {
                boolean b = BooleanUtils.toBooleanDefaultIfNull(BooleanUtils.toBoolean(inp), (defaults.equals("null")) ? false : BooleanUtils.toBoolean(defaults));
                field.set(newObject, b);

            }
            //String
            else if (String.class.equals(field.getType())) {

                if (defaults.equals("null") && inp.equals("null")) {
                    field.set(newObject, "");
                } else if (inp.equals("null")) {
                    field.set(newObject, defaults);
                } else {
                    field.set(newObject, inp);
                }
            }
            //LocalDateTime
            else if (LocalDateTime.class.equals(field.getType())) {
                if (aNull) {
                    field.set(newObject, LocalDateTime.now());
                } else if (GenericValidator.isDate(node.get(field.getName()).toString(), "yyyy-MM-dd HH:mm:ss", true)) {
                    field.set(newObject, LocalDateTime.parse(node.get(field.getName()).toString()));
                } else {
                    field.set(newObject, LocalDateTime.now());
                }

            } else if (Collection.class.isAssignableFrom(field.getType())) {
                if (!aNull) {
                    try {
                        List<HashMap<String, Object>> stringHashMap = new ObjectMapper().readValue(node.get(field.getName()).toString(), new TypeReference<>() {
                        });
                        field.set(newObject, singleMapper.mapSingle(stringHashMap, field.getType()));
                    } catch (JsonProcessingException e) {

                        field.set(newObject, new ArrayList<>());
                    }
                } else {
                    field.set(newObject, new ArrayList<>());
                }
            } else {

                if (!aNull) {
                    try {
                        HashMap<String, Object> stringHashMap = new ObjectMapper().readValue(node.get(field.getName()).toString(), HashMap.class);
                        field.set(newObject, singleMapper.mapSingle(stringHashMap, field.getType()));
                    } catch (JsonProcessingException e) {
                        field.set(newObject, new Object());
                    }
                } else {
                    field.set(newObject, new Object());
                }
            }

        }
        return newObject;
    }

    private <T> Object defaultValues(Class<T> targetClass, Field field, Object newObject) {
        Method m = null;
        try {
            m = targetClass.getDeclaredMethod("get" + StringUtils.capitalize(field.getName()), null);
            m.setAccessible(true);
            Object o = m.invoke(newObject);
            return (o == null) ? null : o;
        } catch (NoSuchMethodException e) {
            return null;
        } catch (InvocationTargetException e) {
            return null;
        } catch (IllegalAccessException e) {
            return null;
        }
    }


}
