package com.google.android.gms.internal.ads;

import android.util.Log;

/* loaded from: classes4.dex */
public final class zziit extends zziiy {

    /* renamed from: a, reason: collision with root package name */
    public final String f34859a;

    public zziit(String str) {
        this.f34859a = str;
    }

    @Override // com.google.android.gms.internal.ads.zziiy
    public final void a(String str) {
        String str2 = this.f34859a;
        StringBuilder sb = new StringBuilder(androidx.fragment.app.e.g(androidx.fragment.app.e.g(1, str2), str));
        sb.append(str2);
        sb.append(":");
        sb.append(str);
        Log.d("isoparser", sb.toString());
    }
}
