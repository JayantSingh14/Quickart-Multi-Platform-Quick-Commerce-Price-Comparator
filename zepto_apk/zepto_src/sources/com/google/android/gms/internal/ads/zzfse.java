package com.google.android.gms.internal.ads;

import android.view.View;
import java.util.Collections;
import java.util.Iterator;

/* loaded from: classes4.dex */
public final class zzfse extends zzfsh {

    /* renamed from: d, reason: collision with root package name */
    public static final zzfse f31779d = new zzfse();

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.ads.zzfsh
    public final boolean a() {
        Iterator it = Collections.unmodifiableCollection(zzfsf.f31780c.f31782b).iterator();
        while (it.hasNext()) {
            View view = (View) ((zzfrl) it.next()).f31720c.get();
            if (view != null && view.hasWindowFocus()) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzfsh
    public final void b(boolean z) {
        Iterator it = Collections.unmodifiableCollection(zzfsf.f31780c.f31781a).iterator();
        while (it.hasNext()) {
            zzfsv zzfsvVar = ((zzfrl) it.next()).f31721d;
            if (zzfsvVar.f31811b.get() != 0) {
                zzfsm.f31796a.a(zzfsvVar.c(), "setState", true != z ? "backgrounded" : "foregrounded", zzfsvVar.f31810a);
            }
        }
    }
}
