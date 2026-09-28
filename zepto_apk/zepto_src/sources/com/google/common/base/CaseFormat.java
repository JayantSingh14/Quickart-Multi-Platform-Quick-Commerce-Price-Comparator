package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.CharMatcher;
import java.io.Serializable;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@GwtCompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes4.dex */
public abstract class CaseFormat {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CaseFormat[] f42235a;

    /* JADX INFO: Fake field, exist only in values array */
    CaseFormat EF5;

    /* renamed from: com.google.common.base.CaseFormat$1, reason: invalid class name */
    public enum AnonymousClass1 extends CaseFormat {
    }

    /* renamed from: com.google.common.base.CaseFormat$2, reason: invalid class name */
    public enum AnonymousClass2 extends CaseFormat {
    }

    /* renamed from: com.google.common.base.CaseFormat$3, reason: invalid class name */
    public enum AnonymousClass3 extends CaseFormat {
    }

    /* renamed from: com.google.common.base.CaseFormat$4, reason: invalid class name */
    public enum AnonymousClass4 extends CaseFormat {
    }

    /* renamed from: com.google.common.base.CaseFormat$5, reason: invalid class name */
    public enum AnonymousClass5 extends CaseFormat {
    }

    public static final class StringConverter extends Converter<String, String> implements Serializable {
        @Override // com.google.common.base.Converter
        public final Object b(Object obj) {
            throw null;
        }

        @Override // com.google.common.base.Function
        public final boolean equals(Object obj) {
            if (!(obj instanceof StringConverter)) {
                return false;
            }
            ((StringConverter) obj).getClass();
            throw null;
        }

        public final int hashCode() {
            throw null;
        }

        public final String toString() {
            return "null.converterTo(null)";
        }
    }

    static {
        AnonymousClass1 anonymousClass1 = new AnonymousClass1("LOWER_HYPHEN", 0);
        AnonymousClass2 anonymousClass2 = new AnonymousClass2("LOWER_UNDERSCORE", 1);
        new CharMatcher.InRange('A', 'Z');
        AnonymousClass3 anonymousClass3 = new AnonymousClass3("LOWER_CAMEL", 2);
        new CharMatcher.InRange('A', 'Z');
        f42235a = new CaseFormat[]{anonymousClass1, anonymousClass2, anonymousClass3, new AnonymousClass4("UPPER_CAMEL", 3), new AnonymousClass5("UPPER_UNDERSCORE", 4)};
    }

    public static CaseFormat valueOf(String str) {
        return (CaseFormat) Enum.valueOf(CaseFormat.class, str);
    }

    public static CaseFormat[] values() {
        return (CaseFormat[]) f42235a.clone();
    }
}
