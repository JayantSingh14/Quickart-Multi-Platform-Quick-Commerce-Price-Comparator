package com.google.android.gms.internal.measurement;

import android.net.Uri;
import java.util.regex.Pattern;

/* loaded from: classes4.dex */
public final class zzjg {

    /* renamed from: a, reason: collision with root package name */
    public static final Uri f36986a = Uri.parse("content://com.google.android.gsf.gservices");

    /* renamed from: b, reason: collision with root package name */
    public static final Pattern f36987b;

    /* renamed from: c, reason: collision with root package name */
    public static final Pattern f36988c;

    static {
        Uri.parse("content://com.google.android.gsf.gservices/prefix");
        f36987b = Pattern.compile("^(1|true|t|on|yes|y)$", 2);
        f36988c = Pattern.compile("^(0|false|f|off|no|n)$", 2);
    }
}
