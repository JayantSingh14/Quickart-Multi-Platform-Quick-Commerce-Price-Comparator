package androidx.room;

import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Metadata;

@Target({ElementType.TYPE})
@Metadata
@kotlin.annotation.Target
@Repeatable(Entries.class)
@Retention(RetentionPolicy.CLASS)
@kotlin.annotation.Retention
/* loaded from: classes3.dex */
public @interface DeleteTable {

    @Target({ElementType.TYPE})
    @Metadata
    @kotlin.annotation.Target
    @Retention(RetentionPolicy.CLASS)
    @kotlin.annotation.Retention
    public @interface Entries {
    }
}
