package com.facebook.react.bridge;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;

@Retention(RetentionPolicy.RUNTIME)
@Metadata
@kotlin.annotation.Retention
/* loaded from: classes.dex */
public @interface ReactMethod {
    boolean isBlockingSynchronousMethod() default false;
}
