package org.checkerframework.common.value.qual;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.checkerframework.framework.qual.SubtypeOf;

/* JADX WARN: Method from annotation default annotation not found: from */
/* JADX WARN: Method from annotation default annotation not found: to */
@Target({ElementType.TYPE_PARAMETER, ElementType.TYPE_USE})
@Documented
@Retention(RetentionPolicy.RUNTIME)
@SubtypeOf
/* loaded from: classes5.dex */
public @interface ArrayLenRange {
}
