package androidx.room;

import androidx.annotation.RequiresApi;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Metadata;

/* JADX WARN: Method from annotation default annotation not found: collate */
/* JADX WARN: Method from annotation default annotation not found: defaultValue */
/* JADX WARN: Method from annotation default annotation not found: index */
/* JADX WARN: Method from annotation default annotation not found: name */
/* JADX WARN: Method from annotation default annotation not found: typeAffinity */
@Target({ElementType.FIELD, ElementType.METHOD})
@Metadata
@kotlin.annotation.Target
@Retention(RetentionPolicy.CLASS)
@kotlin.annotation.Retention
/* loaded from: classes3.dex */
public @interface ColumnInfo {

    @Metadata
    @RequiresApi
    @Retention(RetentionPolicy.CLASS)
    @kotlin.annotation.Retention
    public @interface Collate {
    }

    @Metadata
    public static final class Companion {
    }

    @Metadata
    @Retention(RetentionPolicy.CLASS)
    @kotlin.annotation.Retention
    public @interface SQLiteTypeAffinity {
    }
}
