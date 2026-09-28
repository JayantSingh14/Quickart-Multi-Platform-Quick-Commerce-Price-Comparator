package com.google.android.gms.internal.auth;

import android.net.Uri;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Pattern;

/* loaded from: classes4.dex */
public final class zzcb {

    /* renamed from: a, reason: collision with root package name */
    public static final AtomicBoolean f36313a;

    static {
        Uri.parse("content://com.google.android.gsf.gservices");
        Uri.parse("content://com.google.android.gsf.gservices/prefix");
        Pattern.compile("^(1|true|t|on|yes|y)$", 2);
        Pattern.compile("^(0|false|f|off|no|n)$", 2);
        f36313a = new AtomicBoolean();
        new HashMap(16, 1.0f);
        new HashMap(16, 1.0f);
        new HashMap(16, 1.0f);
        new HashMap(16, 1.0f);
    }
}
