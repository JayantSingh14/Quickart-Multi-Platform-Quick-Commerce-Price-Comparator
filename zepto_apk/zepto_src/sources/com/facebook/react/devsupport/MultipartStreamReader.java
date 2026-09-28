package com.facebook.react.devsupport;

import coil3.network.internal.UtilsKt;
import com.facebook.react.devsupport.BundleDownloader;
import com.facebook.react.devsupport.DevSupportManagerBase;
import java.util.HashMap;
import okio.Buffer;
import okio.BufferedSource;

/* loaded from: classes3.dex */
class MultipartStreamReader {

    /* renamed from: a, reason: collision with root package name */
    public final BufferedSource f18860a;

    /* renamed from: b, reason: collision with root package name */
    public long f18861b;

    public interface ChunkListener {
    }

    public MultipartStreamReader(String str, BufferedSource bufferedSource) {
        this.f18860a = bufferedSource;
    }

    public static HashMap b(Buffer buffer) {
        HashMap map = new HashMap();
        for (String str : buffer.A1().split("\r\n")) {
            int iIndexOf = str.indexOf(":");
            if (iIndexOf != -1) {
                map.put(str.substring(0, iIndexOf).trim(), str.substring(iIndexOf + 1).trim());
            }
        }
        return map;
    }

    public final void a(HashMap map, long j2, boolean z, ChunkListener chunkListener) {
        if (map != null) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (jCurrentTimeMillis - this.f18861b > 16 || z) {
                this.f18861b = jCurrentTimeMillis;
                long j3 = map.get("Content-Length") != null ? Long.parseLong((String) map.get("Content-Length")) : 0L;
                BundleDownloader.AnonymousClass2 anonymousClass2 = (BundleDownloader.AnonymousClass2) chunkListener;
                if ("application/javascript".equals(map.get(UtilsKt.CONTENT_TYPE))) {
                    ((DevSupportManagerBase.AnonymousClass7) anonymousClass2.f18771e).b("Downloading", Integer.valueOf((int) (j2 / 1024)), Integer.valueOf((int) (j3 / 1024)));
                }
            }
        }
    }
}
