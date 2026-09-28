package com.google.android.gms.ads.internal.util;

import android.content.SharedPreferences;
import java.util.Iterator;
import java.util.Objects;

/* loaded from: classes4.dex */
final class zzbw implements SharedPreferences.OnSharedPreferenceChangeListener {

    /* renamed from: a, reason: collision with root package name */
    public final String f21548a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zzbz f21549b;

    public zzbw(zzbz zzbzVar, String str) {
        Objects.requireNonNull(zzbzVar);
        this.f21549b = zzbzVar;
        this.f21548a = str;
    }

    @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
    public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        zzbz zzbzVar = this.f21549b;
        synchronized (zzbzVar) {
            try {
                Iterator it = zzbzVar.f21552b.iterator();
                while (it.hasNext()) {
                    ((zzbx) it.next()).a(this.f21548a, str);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
