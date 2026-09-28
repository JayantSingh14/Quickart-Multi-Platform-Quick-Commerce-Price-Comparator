package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import java.util.concurrent.ScheduledExecutorService;

/* loaded from: classes4.dex */
public final class zzctb implements zzijg {

    /* renamed from: a, reason: collision with root package name */
    public final zzijf f27096a;

    /* renamed from: b, reason: collision with root package name */
    public final zzijf f27097b;

    /* renamed from: c, reason: collision with root package name */
    public final zzijf f27098c;

    public zzctb(zzijf zzijfVar, zzijf zzijfVar2, zzijf zzijfVar3) {
        this.f27096a = zzijfVar;
        this.f27097b = zzijfVar2;
        this.f27098c = zzijfVar3;
    }

    @Override // com.google.android.gms.internal.ads.zzijv
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final zzddl zzb() {
        return new zzddl((ScheduledExecutorService) this.f27096a.zzb(), (Clock) this.f27097b.zzb(), (zzdxe) this.f27098c.zzb());
    }
}
