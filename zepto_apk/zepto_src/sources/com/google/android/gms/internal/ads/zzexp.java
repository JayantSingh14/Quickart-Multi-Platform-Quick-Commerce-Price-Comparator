package com.google.android.gms.internal.ads;

import android.app.ActivityManager;
import android.os.Bundle;
import com.google.android.gms.common.util.PlatformVersion;
import java.util.concurrent.Callable;

/* loaded from: classes4.dex */
final /* synthetic */ class zzexp implements Callable {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ zzexp f30541a = new zzexp();

    @Override // java.util.concurrent.Callable
    public final Object call() {
        Bundle bundle = new Bundle();
        Runtime runtime = Runtime.getRuntime();
        bundle.putLong("runtime_free", runtime.freeMemory());
        bundle.putLong("runtime_max", runtime.maxMemory());
        bundle.putLong("runtime_total", runtime.totalMemory());
        com.google.android.gms.ads.internal.zzt zztVar = com.google.android.gms.ads.internal.zzt.C;
        bundle.putInt("web_view_count", zztVar.f21684h.f25941k.get());
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.xf)).booleanValue()) {
            ActivityManager.MemoryInfo memoryInfoJ = com.google.android.gms.ads.internal.util.client.zzf.j(zztVar.f21684h.f25935e);
            if (memoryInfoJ != null) {
                if (PlatformVersion.isAtLeastU()) {
                    bundle.putLong("a_ad_mem", memoryInfoJ.advertisedMem);
                }
                bundle.putLong("a_total", memoryInfoJ.totalMem);
                bundle.putLong("a_avai", memoryInfoJ.availMem);
                bundle.putLong("a_threshold", memoryInfoJ.threshold);
                bundle.putBoolean("a_is_low_mem", memoryInfoJ.lowMemory);
            }
            bundle.putLong("runtime_avai_processors", runtime.availableProcessors());
        }
        return new zzexr(bundle);
    }
}
