package com.google.android.gms.internal.ads;

import java.util.Locale;
import java.util.regex.Pattern;

/* loaded from: classes4.dex */
final class zzamq {

    /* renamed from: a, reason: collision with root package name */
    public static final Pattern f23627a = Pattern.compile("\\{([^}]*)\\}");

    /* renamed from: b, reason: collision with root package name */
    public static final Pattern f23628b;

    /* renamed from: c, reason: collision with root package name */
    public static final Pattern f23629c;

    /* renamed from: d, reason: collision with root package name */
    public static final Pattern f23630d;

    static {
        String str = zzfj.f31254a;
        Locale locale = Locale.US;
        f23628b = Pattern.compile(String.format(locale, "\\\\pos\\((%1$s),(%1$s)\\)", "\\s*\\d+(?:\\.\\d+)?\\s*"));
        f23629c = Pattern.compile(String.format(locale, "\\\\move\\(%1$s,%1$s,(%1$s),(%1$s)(?:,%1$s,%1$s)?\\)", "\\s*\\d+(?:\\.\\d+)?\\s*"));
        f23630d = Pattern.compile("\\\\an(\\d+)");
    }
}
