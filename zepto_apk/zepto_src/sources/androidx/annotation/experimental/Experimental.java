package androidx.annotation.experimental;

import com.amazon.android.apay.commonlibrary.interfaces.external.MerchantConstants;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Deprecated;
import kotlin.Metadata;

/* JADX WARN: Method from annotation default annotation not found: level */
@Target({ElementType.ANNOTATION_TYPE})
@Metadata
@Deprecated
@kotlin.annotation.Target
@Retention(RetentionPolicy.CLASS)
@kotlin.annotation.Retention
/* loaded from: classes3.dex */
public @interface Experimental {

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata
    public static final class Level {

        /* renamed from: a, reason: collision with root package name */
        public static final Level f241a;

        /* renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ Level[] f242b;

        /* JADX INFO: Fake field, exist only in values array */
        Level EF0;

        static {
            Level level = new Level("WARNING", 0);
            Level level2 = new Level(MerchantConstants.ERROR, 1);
            f241a = level2;
            f242b = new Level[]{level, level2};
        }

        public static Level valueOf(String str) {
            return (Level) Enum.valueOf(Level.class, str);
        }

        public static Level[] values() {
            return (Level[]) f242b.clone();
        }
    }
}
