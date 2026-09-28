package com.facebook.infer.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.annotation.Nonnull;
import javax.annotation.meta.TypeQualifierDefault;
import kotlin.annotations.jvm.UnderMigration;

/* JADX WARN: Method from annotation default annotation not found: trustOnly */
@Target({ElementType.TYPE})
@TypeQualifierDefault
@Nonnull
@UnderMigration
@Retention(RetentionPolicy.CLASS)
/* loaded from: classes3.dex */
public @interface Nullsafe {

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static final class Mode {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Mode[] f18398a = {new Mode("LOCAL", 0), new Mode("STRICT", 1)};

        /* JADX INFO: Fake field, exist only in values array */
        Mode EF5;

        public static Mode valueOf(String str) {
            return (Mode) Enum.valueOf(Mode.class, str);
        }

        public static Mode[] values() {
            return (Mode[]) f18398a.clone();
        }
    }

    /* JADX WARN: Method from annotation default annotation not found: trustAll */
    public @interface TrustList {
    }
}
