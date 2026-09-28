package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.HashSet;

/* loaded from: classes4.dex */
public final class zzfjs implements zzdan {

    /* renamed from: a, reason: collision with root package name */
    public final HashSet f31280a = new HashSet();

    /* renamed from: b, reason: collision with root package name */
    public final Context f31281b;

    /* renamed from: c, reason: collision with root package name */
    public final zzcdf f31282c;

    public zzfjs(Context context, zzcdf zzcdfVar) {
        this.f31281b = context;
        this.f31282c = zzcdfVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:75:0x00cc A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.os.Bundle a() {
        /*
            Method dump skipped, instructions count: 430
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfjs.a():android.os.Bundle");
    }

    @Override // com.google.android.gms.internal.ads.zzdan
    public final synchronized void m0(com.google.android.gms.ads.internal.client.zze zzeVar) {
        if (zzeVar.f21161a != 3) {
            zzcdf zzcdfVar = this.f31282c;
            HashSet hashSet = this.f31280a;
            synchronized (zzcdfVar.f25962a) {
                zzcdfVar.f25966e.addAll(hashSet);
            }
        }
    }
}
