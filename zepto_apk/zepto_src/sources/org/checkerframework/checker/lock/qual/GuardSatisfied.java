package org.checkerframework.checker.lock.qual;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.checkerframework.framework.qual.SubtypeOf;
import org.checkerframework.framework.qual.TargetLocations;

/* JADX WARN: Method from annotation default annotation not found: value */
@Target({ElementType.TYPE_USE})
@TargetLocations
@Documented
@Retention(RetentionPolicy.RUNTIME)
@SubtypeOf
/* loaded from: classes5.dex */
public @interface GuardSatisfied {
}
