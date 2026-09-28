package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.util.Collections;
import java.util.Map;

/* loaded from: classes4.dex */
public final class zzhe {

    /* renamed from: a, reason: collision with root package name */
    public Uri f33634a;

    /* renamed from: b, reason: collision with root package name */
    public Map f33635b;

    /* renamed from: c, reason: collision with root package name */
    public long f33636c;

    /* renamed from: d, reason: collision with root package name */
    public final long f33637d;

    /* renamed from: e, reason: collision with root package name */
    public int f33638e;

    public /* synthetic */ zzhe(zzhf zzhfVar) {
        this.f33634a = zzhfVar.f33691a;
        this.f33635b = zzhfVar.f33692b;
        this.f33636c = zzhfVar.f33693c;
        this.f33637d = zzhfVar.f33694d;
        this.f33638e = zzhfVar.f33695e;
    }

    public final zzhf a() {
        zzgqa.h(this.f33634a, "The uri must be set.");
        return new zzhf(this.f33634a, this.f33635b, this.f33636c, this.f33637d, this.f33638e);
    }

    public zzhe() {
        this.f33635b = Collections.EMPTY_MAP;
        this.f33637d = -1L;
    }
}
