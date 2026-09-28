package com.google.android.gms.internal.auth;

import android.net.Uri;
import androidx.collection.ArrayMap;

/* loaded from: classes4.dex */
public final class zzcr {

    /* renamed from: a, reason: collision with root package name */
    public static final ArrayMap f36314a = new ArrayMap();

    public static synchronized Uri a() {
        ArrayMap arrayMap = f36314a;
        Uri uri = (Uri) arrayMap.get("com.google.android.gms.auth_account");
        if (uri != null) {
            return uri;
        }
        Uri uri2 = Uri.parse("content://com.google.android.gms.phenotype/".concat(String.valueOf(Uri.encode("com.google.android.gms.auth_account"))));
        arrayMap.put("com.google.android.gms.auth_account", uri2);
        return uri2;
    }
}
