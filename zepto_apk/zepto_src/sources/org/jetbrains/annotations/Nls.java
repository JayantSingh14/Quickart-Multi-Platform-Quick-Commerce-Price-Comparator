package org.jetbrains.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX WARN: Method from annotation default annotation not found: capitalization */
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE, ElementType.TYPE_USE, ElementType.TYPE, ElementType.PACKAGE})
@Documented
@Retention(RetentionPolicy.CLASS)
/* loaded from: classes5.dex */
public @interface Nls {

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static final class Capitalization {

        /* renamed from: a, reason: collision with root package name */
        public static final Capitalization f57461a;

        /* renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ Capitalization[] f57462b;

        static {
            Capitalization capitalization = new Capitalization("NotSpecified", 0);
            f57461a = capitalization;
            f57462b = new Capitalization[]{capitalization, new Capitalization("Title", 1), new Capitalization("Sentence", 2)};
        }

        public static Capitalization valueOf(String str) {
            return (Capitalization) Enum.valueOf(Capitalization.class, str);
        }

        public static Capitalization[] values() {
            return (Capitalization[]) f57462b.clone();
        }
    }
}
