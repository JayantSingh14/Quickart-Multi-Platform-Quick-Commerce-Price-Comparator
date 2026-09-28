package com.google.j2objc.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.LOCAL_VARIABLE})
@Retention(RetentionPolicy.SOURCE)
/* loaded from: classes4.dex */
public @interface LoopTranslation {

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static final class LoopStyle {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ LoopStyle[] f45499a = {new LoopStyle("JAVA_ITERATOR", 0), new LoopStyle("FAST_ENUMERATION", 1)};

        /* JADX INFO: Fake field, exist only in values array */
        LoopStyle EF5;

        public static LoopStyle valueOf(String str) {
            return (LoopStyle) Enum.valueOf(LoopStyle.class, str);
        }

        public static LoopStyle[] values() {
            return (LoopStyle[]) f45499a.clone();
        }
    }
}
