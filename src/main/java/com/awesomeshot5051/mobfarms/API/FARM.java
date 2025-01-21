package com.awesomeshot5051.mobfarms.API;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME) // Available at runtime
@Target(ElementType.TYPE)           // For classes
public @interface FARM {
}
