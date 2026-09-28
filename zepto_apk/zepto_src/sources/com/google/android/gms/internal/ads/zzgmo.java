package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: classes4.dex */
public final class zzgmo implements zzglz {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f32926a = new ArrayList();

    @Override // com.google.android.gms.internal.ads.zzglz
    public final synchronized void a(HashMap map, Context context, View view) {
        ArrayList arrayList = this.f32926a;
        map.put("vst", new ArrayList(arrayList));
        arrayList.clear();
    }

    @Override // com.google.android.gms.internal.ads.zzglz
    public final void b(HashMap map) {
    }

    @Override // com.google.android.gms.internal.ads.zzglz
    public final void c(HashMap map) {
    }
}
