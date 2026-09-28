package kotlinx.serialization;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Metadata;
import kotlin.annotation.MustBeDocumented;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Method from annotation default annotation not found: mode */
@Target({})
@kotlin.annotation.Target
@Retention(RetentionPolicy.RUNTIME)
@MustBeDocumented
@Metadata
@ExperimentalSerializationApi
@Documented
/* loaded from: classes3.dex */
public @interface EncodeDefault {

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata
    @ExperimentalSerializationApi
    public static final class Mode {

        /* renamed from: a, reason: collision with root package name */
        public static final Mode f55690a;

        /* renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ Mode[] f55691b;

        /* renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f55692c;

        static {
            Mode mode = new Mode("ALWAYS", 0);
            f55690a = mode;
            Mode[] modeArr = {mode, new Mode("NEVER", 1)};
            f55691b = modeArr;
            f55692c = EnumEntriesKt.a(modeArr);
        }

        public static Mode valueOf(String str) {
            return (Mode) Enum.valueOf(Mode.class, str);
        }

        public static Mode[] values() {
            return (Mode[]) f55691b.clone();
        }
    }
}
