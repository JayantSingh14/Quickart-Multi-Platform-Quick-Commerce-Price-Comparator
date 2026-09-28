package androidx.media3.exoplayer.drm;

import androidx.media3.common.util.UnstableApi;
import androidx.media3.decoder.CryptoConfig;
import java.util.UUID;

@UnstableApi
/* loaded from: classes3.dex */
public final class FrameworkCryptoConfig implements CryptoConfig {

    /* renamed from: c, reason: collision with root package name */
    public static final boolean f6935c;

    /* renamed from: a, reason: collision with root package name */
    public final UUID f6936a;

    /* renamed from: b, reason: collision with root package name */
    public final byte[] f6937b;

    /* JADX WARN: Removed duplicated region for block: B:9:0x001e  */
    static {
        /*
            java.lang.String r0 = "Amazon"
            java.lang.String r1 = androidx.media3.common.util.Util.f5746c
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L1e
            java.lang.String r0 = androidx.media3.common.util.Util.f5747d
            java.lang.String r1 = "AFTM"
            boolean r1 = r1.equals(r0)
            if (r1 != 0) goto L1c
            java.lang.String r1 = "AFTB"
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L1e
        L1c:
            r0 = 1
            goto L1f
        L1e:
            r0 = 0
        L1f:
            androidx.media3.exoplayer.drm.FrameworkCryptoConfig.f6935c = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.drm.FrameworkCryptoConfig.<clinit>():void");
    }

    public FrameworkCryptoConfig(UUID uuid, byte[] bArr) {
        this.f6936a = uuid;
        this.f6937b = bArr;
    }
}
