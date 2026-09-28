package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Date;
import java.util.Iterator;

/* loaded from: classes4.dex */
public final class zzfsd implements zzfsg {

    /* renamed from: e, reason: collision with root package name */
    public static final zzfsd f31774e = new zzfsd(new zzfsh());

    /* renamed from: a, reason: collision with root package name */
    public Date f31775a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f31776b;

    /* renamed from: c, reason: collision with root package name */
    public final zzfsh f31777c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f31778d;

    public zzfsd(zzfsh zzfshVar) {
        this.f31777c = zzfshVar;
    }

    @Override // com.google.android.gms.internal.ads.zzfsg
    public final void a(boolean z) {
        if (!this.f31778d && z) {
            Date date = new Date();
            Date date2 = this.f31775a;
            if (date2 == null || date.after(date2)) {
                this.f31775a = date;
                if (this.f31776b) {
                    Iterator it = Collections.unmodifiableCollection(zzfsf.f31780c.f31782b).iterator();
                    while (it.hasNext()) {
                        zzfsv zzfsvVar = ((zzfrl) it.next()).f31721d;
                        Date date3 = this.f31775a;
                        zzfsvVar.f(date3 != null ? (Date) date3.clone() : null);
                    }
                }
            }
        }
        this.f31778d = z;
    }
}
