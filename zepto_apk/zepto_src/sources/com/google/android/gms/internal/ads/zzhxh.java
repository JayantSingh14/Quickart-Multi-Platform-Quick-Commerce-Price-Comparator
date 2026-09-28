package com.google.android.gms.internal.ads;

import org.apache.commons.lang3.StringUtils;

/* loaded from: classes4.dex */
public final class zzhxh {

    /* renamed from: d, reason: collision with root package name */
    public static final zzhxh f34464d = new zzhxh("", "", false);

    /* renamed from: a, reason: collision with root package name */
    public final String f34465a;

    /* renamed from: b, reason: collision with root package name */
    public final String f34466b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f34467c;

    static {
        new zzhxh(StringUtils.LF, "  ", true);
    }

    public zzhxh(String str, String str2, boolean z) {
        if (!str.matches("[\r\n]*")) {
            throw new IllegalArgumentException("Only combinations of \\n and \\r are allowed in newline.");
        }
        if (!str2.matches("[ \t]*")) {
            throw new IllegalArgumentException("Only combinations of spaces and tabs are allowed in indent.");
        }
        this.f34465a = str;
        this.f34466b = str2;
        this.f34467c = z;
    }
}
