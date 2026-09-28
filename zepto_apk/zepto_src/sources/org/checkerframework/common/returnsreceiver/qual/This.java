package org.checkerframework.common.returnsreceiver.qual;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.checkerframework.framework.qual.PolymorphicQualifier;
import org.checkerframework.framework.qual.TargetLocations;

@Target({ElementType.TYPE_USE, ElementType.TYPE_PARAMETER})
@TargetLocations
@Retention(RetentionPolicy.RUNTIME)
@PolymorphicQualifier
/* loaded from: classes5.dex */
public @interface This {
}
