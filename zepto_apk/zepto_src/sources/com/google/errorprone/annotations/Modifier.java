package com.google.errorprone.annotations;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes4.dex */
public final class Modifier {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Modifier[] f43481a = {new Modifier("PUBLIC", 0), new Modifier("PROTECTED", 1), new Modifier("PRIVATE", 2), new Modifier("ABSTRACT", 3), new Modifier("DEFAULT", 4), new Modifier("STATIC", 5), new Modifier("FINAL", 6), new Modifier("TRANSIENT", 7), new Modifier("VOLATILE", 8), new Modifier("SYNCHRONIZED", 9), new Modifier("NATIVE", 10), new Modifier("STRICTFP", 11)};

    /* JADX INFO: Fake field, exist only in values array */
    Modifier EF5;

    public static Modifier valueOf(String str) {
        return (Modifier) Enum.valueOf(Modifier.class, str);
    }

    public static Modifier[] values() {
        return (Modifier[]) f43481a.clone();
    }
}
