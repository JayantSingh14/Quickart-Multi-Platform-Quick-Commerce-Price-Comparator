package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
public final class zzfri {

    /* renamed from: a, reason: collision with root package name */
    public final zzfru f31702a;

    /* renamed from: b, reason: collision with root package name */
    public final zzfru f31703b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f31704c;

    /* renamed from: d, reason: collision with root package name */
    public final zzfrm f31705d;

    /* renamed from: e, reason: collision with root package name */
    public final zzfrp f31706e;

    public zzfri(zzfrm zzfrmVar, zzfrp zzfrpVar, zzfru zzfruVar, zzfru zzfruVar2, boolean z) {
        this.f31705d = zzfrmVar;
        this.f31706e = zzfrpVar;
        this.f31702a = zzfruVar;
        this.f31703b = zzfruVar2;
        this.f31704c = z;
    }

    public static zzfri a(zzfrm zzfrmVar, zzfrp zzfrpVar, zzfru zzfruVar, zzfru zzfruVar2, boolean z) {
        if (zzfruVar == zzfru.NONE) {
            throw new IllegalArgumentException("Impression owner is none");
        }
        zzfrm zzfrmVar2 = zzfrm.DEFINED_BY_JAVASCRIPT;
        zzfru zzfruVar3 = zzfru.NATIVE;
        if (zzfrmVar == zzfrmVar2 && zzfruVar == zzfruVar3) {
            throw new IllegalArgumentException("ImpressionType/CreativeType can only be defined as DEFINED_BY_JAVASCRIPT if Impression Owner is JavaScript");
        }
        if (zzfrpVar == zzfrp.DEFINED_BY_JAVASCRIPT && zzfruVar == zzfruVar3) {
            throw new IllegalArgumentException("ImpressionType/CreativeType can only be defined as DEFINED_BY_JAVASCRIPT if Impression Owner is JavaScript");
        }
        return new zzfri(zzfrmVar, zzfrpVar, zzfruVar, zzfruVar2, z);
    }
}
