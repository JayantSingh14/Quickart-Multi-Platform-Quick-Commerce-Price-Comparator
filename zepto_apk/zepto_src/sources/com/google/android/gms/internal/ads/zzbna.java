package com.google.android.gms.internal.ads;

import java.util.Map;

/* loaded from: classes4.dex */
final class zzbna implements zzbnn {
    @Override // com.google.android.gms.internal.ads.zzbnn
    public final void a(Object obj, Map map) {
        zzcir zzcirVar = (zzcir) obj;
        if (map.containsKey("start")) {
            zzcjc zzcjcVarE0 = zzcirVar.e0();
            synchronized (zzcjcVarE0.f26372d) {
            }
            zzcjcVarE0.D++;
            zzcjcVarE0.v0();
            return;
        }
        if (map.containsKey("stop")) {
            r3.D--;
            zzcirVar.e0().v0();
        } else if (map.containsKey("cancel")) {
            zzcjc zzcjcVarE02 = zzcirVar.e0();
            zzbfj zzbfjVar = zzcjcVarE02.f26370b;
            if (zzbfjVar != null) {
                zzbfjVar.b(10005);
            }
            zzcjcVarE02.C = true;
            zzcjcVarE02.n = 10004;
            zzcjcVarE02.o = "Page loaded delay cancel.";
            zzcjcVarE02.v0();
            zzcjcVarE02.f26369a.destroy();
        }
    }
}
