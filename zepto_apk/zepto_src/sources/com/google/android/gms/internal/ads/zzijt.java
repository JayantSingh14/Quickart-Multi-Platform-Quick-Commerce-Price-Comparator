package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
public final class zzijt implements zzijp {

    /* renamed from: c, reason: collision with root package name */
    public static final Object f34906c = new Object();

    /* renamed from: a, reason: collision with root package name */
    public volatile zzijg f34907a;

    /* renamed from: b, reason: collision with root package name */
    public volatile Object f34908b;

    public static zzijp a(zzijg zzijgVar) {
        if ((zzijgVar instanceof zzijt) || (zzijgVar instanceof zzijf)) {
            return zzijgVar;
        }
        zzijt zzijtVar = new zzijt();
        zzijtVar.f34908b = f34906c;
        zzijtVar.f34907a = zzijgVar;
        return zzijtVar;
    }

    @Override // com.google.android.gms.internal.ads.zzijv
    public final Object zzb() {
        Object obj = this.f34908b;
        if (obj != f34906c) {
            return obj;
        }
        zzijg zzijgVar = this.f34907a;
        if (zzijgVar == null) {
            return this.f34908b;
        }
        Object objZzb = zzijgVar.zzb();
        this.f34908b = objZzb;
        this.f34907a = null;
        return objZzb;
    }
}
