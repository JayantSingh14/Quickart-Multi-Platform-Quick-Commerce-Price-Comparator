package com.google.android.gms.internal.ads;

import java.util.Collections;

/* loaded from: classes4.dex */
public final class zzftu extends zzftq {
    @Override // com.google.android.gms.internal.ads.zzftr
    /* renamed from: a */
    public final void onPostExecute(String str) {
        b(str);
        super.onPostExecute(str);
    }

    public final void b(String str) {
        zzfsf zzfsfVar = zzfsf.f31780c;
        if (zzfsfVar != null) {
            for (zzfrl zzfrlVar : Collections.unmodifiableCollection(zzfsfVar.f31781a)) {
                if (this.f31851c.contains(zzfrlVar.f31724g)) {
                    zzfsv zzfsvVar = zzfrlVar.f31721d;
                    if (this.f31853e >= zzfsvVar.f31812c && zzfsvVar.f31813d != 3) {
                        zzfsvVar.f31813d = 3;
                        zzfsm.f31796a.a(zzfsvVar.c(), "setNativeViewHierarchy", str, zzfsvVar.f31810a);
                    }
                }
            }
        }
    }

    @Override // android.os.AsyncTask
    public final /* synthetic */ Object doInBackground(Object[] objArr) {
        return this.f31852d.toString();
    }

    @Override // com.google.android.gms.internal.ads.zzftr, android.os.AsyncTask
    public final /* synthetic */ void onPostExecute(Object obj) {
        String str = (String) obj;
        b(str);
        super.onPostExecute(str);
    }
}
