package com.google.android.gms.internal.ads;

import java.util.Map;

/* loaded from: classes4.dex */
public final class zzcvm implements zzcvn {

    /* renamed from: a, reason: collision with root package name */
    public final Map f27238a;

    public zzcvm(Map map) {
        this.f27238a = map;
    }

    @Override // com.google.android.gms.internal.ads.zzcvn
    public final zzejg a(int i2, String str) {
        return (zzejg) this.f27238a.get(str);
    }
}
