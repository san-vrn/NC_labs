package com.application.d_injector;


import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;

import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Configuration(packages = {"com.application.repository.sorting.boubleSorter", "com.application.contracts.utils.validator.checkers.contractCheckers", "com.application.contracts.utils.validator.checkers.personCheckers"})
public class Injector {
     static List<Object> classesPack = new ArrayList<>();

    public Injector(Object o) {
        classesPack.clear();
        Configuration configuration = this.getClass().getAnnotation(Configuration.class);
        for (String URL : configuration.packages()) {
            classesPack.addAll(getAllClassesFrom(URL));
        }
        inject(o);
    }

    private static <T>T inject(T object){

        int tempIndicator = 0;
        for (Field field : object.getClass().getDeclaredFields()) {
            if(field.isAnnotationPresent(Autoinjectable.class) && !field.getType().isAssignableFrom(List.class)) {
                Object tempObjectForInject = null;
                for (Object tempObject: classesPack) {
                    if(field.getType().isAssignableFrom(tempObject.getClass())){
                        tempIndicator++;
                        tempObjectForInject = tempObject;
                    }
                }
                try {
                    if(tempIndicator>1) throw new Exception("В пакете найдено более одного класса соответствующего типа");
                    if(tempIndicator<=0) throw new Exception("В пакете не найдено классов для внедрения зависимости");
                    if(tempIndicator==1) {
                        field.setAccessible(true);
                        field.set(object, tempObjectForInject);
                        System.out.println("инжектим " + tempObjectForInject);
                    }
                }
                catch (Exception e) {
                    tempObjectForInject = null;
                    e.printStackTrace();
                }
            }
            else if (field.isAnnotationPresent(Autoinjectable.class) && field.getType().isAssignableFrom(List.class)) {
                try {
                    field.setAccessible(true);
                    field.set(object, classesPack);
                }
                catch (IllegalAccessException e){
                    e.printStackTrace();
                }

            }
            tempIndicator = 0;
        }
        return object;
    }

    private static List<Object> getAllClassesFrom(String packageName) {
        return new Reflections(packageName, new SubTypesScanner(false))
                .getAllTypes()
                .stream()
                .map(name -> {
                    try {
                        return Class.forName(name).getConstructor().newInstance();
                    } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
                        return null;
                    }
                })
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }
}









