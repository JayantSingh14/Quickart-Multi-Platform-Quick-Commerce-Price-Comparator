package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Message;

/* loaded from: classes4.dex */
public final class zzfa {

    /* renamed from: a, reason: collision with root package name */
    public final zzbb f30705a;

    /* renamed from: b, reason: collision with root package name */
    public final zzaz f30706b;

    /* renamed from: c, reason: collision with root package name */
    public final zzeu f30707c;

    /* renamed from: d, reason: collision with root package name */
    public final zzbd f30708d = new zzbd();

    /* renamed from: e, reason: collision with root package name */
    public final zzdx f30709e;

    /* renamed from: f, reason: collision with root package name */
    public final zzev f30710f;

    /* renamed from: g, reason: collision with root package name */
    public final zzex f30711g;

    /* renamed from: h, reason: collision with root package name */
    public final zzey f30712h;

    /* renamed from: i, reason: collision with root package name */
    public final zzez f30713i;

    public zzfa(zzbb zzbbVar, zzeu zzeuVar, zzfc zzfcVar, int i2, int i3, int i4, int i5) {
        this.f30705a = zzbbVar;
        this.f30707c = zzeuVar;
        zzkp zzkpVar = (zzkp) zzbbVar;
        this.f30709e = zzfcVar.a(zzkpVar.s, new Handler.Callback() { // from class: com.google.android.gms.internal.ads.zzew
            @Override // android.os.Handler.Callback
            public final /* synthetic */ boolean handleMessage(Message message) {
                zzfa zzfaVar = this.f30452a;
                zzfaVar.getClass();
                int i6 = message.what;
                if (i6 == 1) {
                    zzfaVar.f30710f.a();
                    return true;
                }
                if (i6 == 2) {
                    zzfaVar.f30711g.a();
                    return true;
                }
                if (i6 == 3) {
                    zzfaVar.f30712h.a();
                    return true;
                }
                if (i6 != 4) {
                    return false;
                }
                zzfaVar.f30713i.a();
                return true;
            }
        });
        this.f30710f = new zzev(this, i2);
        this.f30711g = new zzex(this, i3);
        this.f30712h = new zzey(this, i4);
        this.f30713i = new zzez(this, i5);
        zzet zzetVar = new zzet(this);
        this.f30706b = zzetVar;
        zzkpVar.f35046m.a(zzetVar);
    }
}
