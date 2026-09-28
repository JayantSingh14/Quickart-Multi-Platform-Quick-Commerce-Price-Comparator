package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Predicate;

/* loaded from: classes4.dex */
final /* synthetic */ class zzbqs implements Predicate {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzbnn f25437a;

    public /* synthetic */ zzbqs(zzbnn zzbnnVar) {
        this.f25437a = zzbnnVar;
    }

    @Override // com.google.android.gms.common.util.Predicate
    public final /* synthetic */ boolean apply(Object obj) {
        zzbnn zzbnnVar = (zzbnn) obj;
        return (zzbnnVar instanceof zzbqn) && ((zzbqn) zzbnnVar).f25428a.equals(this.f25437a);
    }
}
