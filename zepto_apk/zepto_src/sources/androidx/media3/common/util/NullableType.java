package androidx.media3.common.util;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.annotation.Nonnull;
import javax.annotation.meta.TypeQualifierNickname;

@Target({ElementType.TYPE_USE})
@Nonnull
@TypeQualifierNickname
@Documented
@Retention(RetentionPolicy.CLASS)
@UnstableApi
/* loaded from: classes3.dex */
public @interface NullableType {
}
