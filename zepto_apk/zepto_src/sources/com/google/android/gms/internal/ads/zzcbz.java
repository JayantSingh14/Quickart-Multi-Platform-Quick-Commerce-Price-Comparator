package com.google.android.gms.internal.ads;

import android.content.SharedPreferences;
import java.util.Iterator;
import java.util.Objects;

/* loaded from: classes4.dex */
final class zzcbz implements SharedPreferences.OnSharedPreferenceChangeListener {

    /* renamed from: a, reason: collision with root package name */
    public final String f25873a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zzccc f25874b;

    public zzcbz(zzccc zzcccVar, String str) {
        Objects.requireNonNull(zzcccVar);
        this.f25874b = zzcccVar;
        this.f25873a = str;
    }

    @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
    public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        zzccc zzcccVar = this.f25874b;
        synchronized (zzcccVar) {
            try {
                Iterator it = zzcccVar.f25878b.iterator();
                while (it.hasNext()) {
                    ((zzcca) it.next()).a(this.f25873a, str);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
