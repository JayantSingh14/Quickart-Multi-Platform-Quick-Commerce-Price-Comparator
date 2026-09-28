package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes4.dex */
public final class zzcgg {

    /* renamed from: a, reason: collision with root package name */
    public long f26165a;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v14, types: [com.google.android.gms.internal.ads.zziix] */
    /* JADX WARN: Type inference failed for: r9v7, types: [com.google.android.gms.internal.ads.zziix] */
    public final long a(ByteBuffer byteBuffer) {
        zzasy zzasyVar;
        zzasx zzasxVar;
        long j2 = this.f26165a;
        if (j2 > 0) {
            return j2;
        }
        try {
            ByteBuffer byteBufferDuplicate = byteBuffer.duplicate();
            byteBufferDuplicate.flip();
            zzast zzastVar = new zzast(new zzcgf(byteBufferDuplicate), zzcgk.f26167c);
            zziis zziisVar = zzastVar.f34854b;
            ArrayList zziixVar = zzastVar.f34858f;
            if (zziisVar != null && zzastVar.f34855c != zziir.f34852g) {
                zziixVar = new zziix(zziixVar, zzastVar);
            }
            Iterator it = zziixVar.iterator();
            while (true) {
                zzasyVar = null;
                if (!it.hasNext()) {
                    zzasxVar = null;
                    break;
                }
                zzasv zzasvVar = (zzasv) it.next();
                if (zzasvVar instanceof zzasx) {
                    zzasxVar = (zzasx) zzasvVar;
                    break;
                }
            }
            zziis zziisVar2 = zzasxVar.f34854b;
            ArrayList zziixVar2 = zzasxVar.f34858f;
            if (zziisVar2 != null && zzasxVar.f34855c != zziir.f34852g) {
                zziixVar2 = new zziix(zziixVar2, zzasxVar);
            }
            Iterator it2 = zziixVar2.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                zzasv zzasvVar2 = (zzasv) it2.next();
                if (zzasvVar2 instanceof zzasy) {
                    zzasyVar = (zzasy) zzasvVar2;
                    break;
                }
            }
            long j3 = (zzasyVar.f24289m * 1000) / zzasyVar.f24288l;
            this.f26165a = j3;
            return j3;
        } catch (IOException | RuntimeException unused) {
            return 0L;
        }
    }
}
