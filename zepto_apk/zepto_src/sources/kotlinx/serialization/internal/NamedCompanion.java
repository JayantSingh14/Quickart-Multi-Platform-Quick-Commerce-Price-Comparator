package kotlinx.serialization.internal;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Metadata;
import kotlinx.serialization.InternalSerializationApi;

@Target({ElementType.TYPE})
@Metadata
@InternalSerializationApi
@kotlin.annotation.Target
@Retention(RetentionPolicy.RUNTIME)
@kotlin.annotation.Retention
/* loaded from: classes3.dex */
public @interface NamedCompanion {
}
