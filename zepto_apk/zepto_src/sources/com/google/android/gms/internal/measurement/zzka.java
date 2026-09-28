package com.google.android.gms.internal.measurement;

import android.net.Uri;
import androidx.collection.ArrayMap;

/* loaded from: classes.dex */
public final class zzka {

    /* renamed from: a, reason: collision with root package name */
    public static final ArrayMap f37024a = new ArrayMap();

    public static synchronized Uri a() {
        ArrayMap arrayMap = f37024a;
        Uri uri = (Uri) arrayMap.get("com.google.android.gms.measurement");
        if (uri != null) {
            return uri;
        }
        Uri uri2 = Uri.parse("content://com.google.android.gms.phenotype/".concat(String.valueOf(Uri.encode("com.google.android.gms.measurement"))));
        arrayMap.put("com.google.android.gms.measurement", uri2);
        return uri2;
    }
}
