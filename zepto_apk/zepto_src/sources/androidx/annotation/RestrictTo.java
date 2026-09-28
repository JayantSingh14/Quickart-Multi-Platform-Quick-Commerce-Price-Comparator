package androidx.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Metadata;
import kotlin.annotation.MustBeDocumented;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

@Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE, ElementType.METHOD, ElementType.CONSTRUCTOR, ElementType.FIELD, ElementType.PACKAGE})
@kotlin.annotation.Target
@Retention(RetentionPolicy.CLASS)
@kotlin.annotation.Retention
@MustBeDocumented
@Metadata
@Documented
/* loaded from: classes3.dex */
public @interface RestrictTo {

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata
    public static final class Scope {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Scope[] f239a;

        /* renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f240b;

        static {
            Scope[] scopeArr = {new Scope("LIBRARY", 0), new Scope("LIBRARY_GROUP", 1), new Scope("LIBRARY_GROUP_PREFIX", 2), new Scope("GROUP_ID", 3), new Scope("TESTS", 4), new Scope("SUBCLASSES", 5)};
            f239a = scopeArr;
            f240b = EnumEntriesKt.a(scopeArr);
        }

        public static Scope valueOf(String str) {
            return (Scope) Enum.valueOf(Scope.class, str);
        }

        public static Scope[] values() {
            return (Scope[]) f239a.clone();
        }
    }
}
