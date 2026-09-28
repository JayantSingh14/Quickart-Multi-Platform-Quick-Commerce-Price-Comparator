package kotlin;

import com.amazon.android.apay.commonlibrary.interfaces.external.MerchantConstants;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Method from annotation default annotation not found: level */
/* JADX WARN: Method from annotation default annotation not found: message */
@Target({ElementType.ANNOTATION_TYPE})
@SinceKotlin
@Metadata
@kotlin.annotation.Target
@Retention(RetentionPolicy.CLASS)
@kotlin.annotation.Retention
/* loaded from: classes3.dex */
public @interface RequiresOptIn {

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata
    public static final class Level {

        /* renamed from: a, reason: collision with root package name */
        public static final Level f53535a;

        /* renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ Level[] f53536b;

        /* renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f53537c;

        static {
            Level level = new Level("WARNING", 0);
            Level level2 = new Level(MerchantConstants.ERROR, 1);
            f53535a = level2;
            Level[] levelArr = {level, level2};
            f53536b = levelArr;
            f53537c = EnumEntriesKt.a(levelArr);
        }

        public static Level valueOf(String str) {
            return (Level) Enum.valueOf(Level.class, str);
        }

        public static Level[] values() {
            return (Level[]) f53536b.clone();
        }
    }
}
