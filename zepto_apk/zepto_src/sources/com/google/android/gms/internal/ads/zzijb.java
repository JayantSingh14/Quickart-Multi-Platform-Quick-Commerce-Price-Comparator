package com.google.android.gms.internal.ads;

import com.google.android.gms.common.api.Api;
import java.util.LinkedHashMap;

/* loaded from: classes4.dex */
public class zzijb {

    /* renamed from: a, reason: collision with root package name */
    public final LinkedHashMap f34892a;

    public zzijb(int i2) {
        this.f34892a = new LinkedHashMap(i2 < 3 ? i2 + 1 : i2 < 1073741824 ? (int) ((i2 / 0.75f) + 1.0f) : Api.BaseClientBuilder.API_PRIORITY_OTHER);
    }

    public final void a(Object obj, zzijp zzijpVar) {
        if (zzijpVar == null) {
            throw new NullPointerException("provider");
        }
        this.f34892a.put(obj, zzijpVar);
    }

    public void b(String str, zzijp zzijpVar) {
        a(str, zzijpVar);
    }
}
