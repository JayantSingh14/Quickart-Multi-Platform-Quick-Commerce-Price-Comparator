package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.swmansion.reanimated.layoutReanimation.Snapshot;
import java.util.Map;

/* loaded from: classes4.dex */
final class zzcjo implements zzbnn {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzcju f26413a;

    public zzcjo(zzcju zzcjuVar) {
        this.f26413a = zzcjuVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbnn
    public final /* synthetic */ void a(Object obj, Map map) throws NumberFormatException {
        if (map != null) {
            String str = (String) map.get(Snapshot.HEIGHT);
            if (TextUtils.isEmpty(str)) {
                return;
            }
            try {
                int i2 = Integer.parseInt(str);
                zzcju zzcjuVar = this.f26413a;
                synchronized (zzcjuVar) {
                    try {
                        if (zzcjuVar.H != i2) {
                            zzcjuVar.H = i2;
                            zzcjuVar.requestLayout();
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            } catch (Exception e2) {
                int i3 = com.google.android.gms.ads.internal.util.zze.f21576b;
                com.google.android.gms.ads.internal.util.client.zzo.g("Exception occurred while getting webview content height", e2);
            }
        }
    }
}
