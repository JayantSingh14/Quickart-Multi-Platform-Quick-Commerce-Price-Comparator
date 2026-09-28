package org.checkerframework.common.initializedfields.qual;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.checkerframework.framework.qual.SubtypeOf;
import org.checkerframework.framework.qual.TargetLocations;

@Target({ElementType.TYPE_USE, ElementType.TYPE_PARAMETER})
@TargetLocations
@Retention(RetentionPolicy.RUNTIME)
@SubtypeOf
/* loaded from: classes5.dex */
public @interface InitializedFieldsBottom {
}
