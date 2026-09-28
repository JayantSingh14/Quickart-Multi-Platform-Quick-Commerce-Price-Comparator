package com.brentvatne.exoplayer;

import androidx.media3.datasource.HttpDataSource;
import androidx.media3.exoplayer.drm.DrmSessionManager;
import com.brentvatne.common.api.DRMProps;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes3.dex */
public final class DRMManager implements DRMManagerSpec {

    /* renamed from: a, reason: collision with root package name */
    public final HttpDataSource.Factory f15521a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f15522b;

    public DRMManager(HttpDataSource.Factory dataSourceFactory) {
        Intrinsics.checkNotNullParameter(dataSourceFactory, "dataSourceFactory");
        this.f15521a = dataSourceFactory;
    }

    public final DrmSessionManager a(UUID uuid, DRMProps drmProps) {
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        Intrinsics.checkNotNullParameter(drmProps, "drmProps");
        return b(uuid, drmProps, 0);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0047 A[Catch: Exception -> 0x0034, UnsupportedDrmException -> 0x0036, TryCatch #3 {UnsupportedDrmException -> 0x0036, Exception -> 0x0034, blocks: (B:6:0x0010, B:8:0x0026, B:16:0x003e, B:18:0x0047, B:19:0x0050, B:25:0x0080, B:26:0x0085, B:27:0x0086, B:28:0x008c), top: B:39:0x0010 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final androidx.media3.exoplayer.drm.DrmSessionManager b(java.util.UUID r18, com.brentvatne.common.api.DRMProps r19, int r20) throws androidx.media3.exoplayer.drm.UnsupportedDrmException {
        /*
            r17 = this;
            r1 = r17
            r2 = r18
            r3 = r19
            r4 = r20
            int r0 = androidx.media3.common.util.Util.f5744a
            r5 = 18
            if (r0 >= r5) goto L10
            r0 = 0
            return r0
        L10:
            androidx.media3.exoplayer.drm.HttpMediaDrmCallback r9 = new androidx.media3.exoplayer.drm.HttpMediaDrmCallback     // Catch: java.lang.Exception -> L34 androidx.media3.exoplayer.drm.UnsupportedDrmException -> L36
            java.lang.String r0 = r3.f15383b     // Catch: java.lang.Exception -> L34 androidx.media3.exoplayer.drm.UnsupportedDrmException -> L36
            androidx.media3.datasource.HttpDataSource$Factory r6 = r1.f15521a     // Catch: java.lang.Exception -> L34 androidx.media3.exoplayer.drm.UnsupportedDrmException -> L36
            r7 = 0
            r9.<init>(r0, r7, r6)     // Catch: java.lang.Exception -> L34 androidx.media3.exoplayer.drm.UnsupportedDrmException -> L36
            java.lang.String[] r0 = r3.f15384c     // Catch: java.lang.Exception -> L34 androidx.media3.exoplayer.drm.UnsupportedDrmException -> L36
            int r6 = r0.length     // Catch: java.lang.Exception -> L34 androidx.media3.exoplayer.drm.UnsupportedDrmException -> L36
            int r6 = r6 + (-1)
            r8 = 2
            int r6 = kotlin.internal.ProgressionUtilKt.a(r7, r6, r8)     // Catch: java.lang.Exception -> L34 androidx.media3.exoplayer.drm.UnsupportedDrmException -> L36
            if (r6 < 0) goto L39
        L26:
            r10 = r0[r7]     // Catch: java.lang.Exception -> L34 androidx.media3.exoplayer.drm.UnsupportedDrmException -> L36
            int r11 = r7 + 1
            r11 = r0[r11]     // Catch: java.lang.Exception -> L34 androidx.media3.exoplayer.drm.UnsupportedDrmException -> L36
            r9.d(r10, r11)     // Catch: java.lang.Exception -> L34 androidx.media3.exoplayer.drm.UnsupportedDrmException -> L36
            if (r7 == r6) goto L39
            int r7 = r7 + 2
            goto L26
        L34:
            r0 = move-exception
            goto L8d
        L36:
            r0 = move-exception
            r6 = 1
            goto La1
        L39:
            androidx.media3.exoplayer.drm.FrameworkMediaDrm r0 = new androidx.media3.exoplayer.drm.FrameworkMediaDrm     // Catch: java.lang.Exception -> L7c android.media.UnsupportedSchemeException -> L7e
            r0.<init>(r2)     // Catch: java.lang.Exception -> L7c android.media.UnsupportedSchemeException -> L7e
            java.lang.String r6 = "newInstance(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r6)     // Catch: java.lang.Exception -> L34 androidx.media3.exoplayer.drm.UnsupportedDrmException -> L36
            boolean r6 = r1.f15522b     // Catch: java.lang.Exception -> L34 androidx.media3.exoplayer.drm.UnsupportedDrmException -> L36
            if (r6 == 0) goto L50
            java.lang.String r6 = "securityLevel"
            java.lang.String r7 = "L3"
            android.media.MediaDrm r8 = r0.f6940b     // Catch: java.lang.Exception -> L34 androidx.media3.exoplayer.drm.UnsupportedDrmException -> L36
            r8.setPropertyString(r6, r7)     // Catch: java.lang.Exception -> L34 androidx.media3.exoplayer.drm.UnsupportedDrmException -> L36
        L50:
            androidx.media3.exoplayer.drm.DefaultDrmSessionManager$Builder r6 = new androidx.media3.exoplayer.drm.DefaultDrmSessionManager$Builder     // Catch: java.lang.Exception -> L34 androidx.media3.exoplayer.drm.UnsupportedDrmException -> L36
            r6.<init>()     // Catch: java.lang.Exception -> L34 androidx.media3.exoplayer.drm.UnsupportedDrmException -> L36
            java.util.HashMap r10 = r6.f6903a     // Catch: java.lang.Exception -> L34 androidx.media3.exoplayer.drm.UnsupportedDrmException -> L36
            com.brentvatne.exoplayer.a r7 = new com.brentvatne.exoplayer.a     // Catch: java.lang.Exception -> L34 androidx.media3.exoplayer.drm.UnsupportedDrmException -> L36
            r8 = 1
            r7.<init>(r0, r8)     // Catch: java.lang.Exception -> L34 androidx.media3.exoplayer.drm.UnsupportedDrmException -> L36
            r6.f6904b = r2     // Catch: java.lang.Exception -> L34 androidx.media3.exoplayer.drm.UnsupportedDrmException -> L36
            r6.f6905c = r7     // Catch: java.lang.Exception -> L34 androidx.media3.exoplayer.drm.UnsupportedDrmException -> L36
            r10.clear()     // Catch: java.lang.Exception -> L34 androidx.media3.exoplayer.drm.UnsupportedDrmException -> L36
            boolean r11 = r3.f15385d     // Catch: java.lang.Exception -> L34 androidx.media3.exoplayer.drm.UnsupportedDrmException -> L36
            r6.f6906d = r11     // Catch: java.lang.Exception -> L34 androidx.media3.exoplayer.drm.UnsupportedDrmException -> L36
            androidx.media3.exoplayer.drm.DefaultDrmSessionManager r0 = new androidx.media3.exoplayer.drm.DefaultDrmSessionManager     // Catch: java.lang.Exception -> L34 androidx.media3.exoplayer.drm.UnsupportedDrmException -> L36
            java.util.UUID r7 = r6.f6904b     // Catch: java.lang.Exception -> L34 androidx.media3.exoplayer.drm.UnsupportedDrmException -> L36
            androidx.media3.exoplayer.drm.ExoMediaDrm$Provider r8 = r6.f6905c     // Catch: java.lang.Exception -> L34 androidx.media3.exoplayer.drm.UnsupportedDrmException -> L36
            int[] r12 = r6.f6907e     // Catch: java.lang.Exception -> L34 androidx.media3.exoplayer.drm.UnsupportedDrmException -> L36
            boolean r13 = r6.f6908f     // Catch: java.lang.Exception -> L34 androidx.media3.exoplayer.drm.UnsupportedDrmException -> L36
            androidx.media3.exoplayer.upstream.DefaultLoadErrorHandlingPolicy r14 = r6.f6909g     // Catch: java.lang.Exception -> L34 androidx.media3.exoplayer.drm.UnsupportedDrmException -> L36
            long r5 = r6.f6910h     // Catch: java.lang.Exception -> L34 androidx.media3.exoplayer.drm.UnsupportedDrmException -> L36
            r15 = r5
            r6 = r0
            r6.<init>(r7, r8, r9, r10, r11, r12, r13, r14, r15)     // Catch: java.lang.Exception -> L34 androidx.media3.exoplayer.drm.UnsupportedDrmException -> L36
            return r6
        L7c:
            r0 = move-exception
            goto L80
        L7e:
            r0 = move-exception
            goto L86
        L80:
            androidx.media3.exoplayer.drm.UnsupportedDrmException r5 = new androidx.media3.exoplayer.drm.UnsupportedDrmException     // Catch: java.lang.Exception -> L34 androidx.media3.exoplayer.drm.UnsupportedDrmException -> L36
            r5.<init>(r8, r0)     // Catch: java.lang.Exception -> L34 androidx.media3.exoplayer.drm.UnsupportedDrmException -> L36
            throw r5     // Catch: java.lang.Exception -> L34 androidx.media3.exoplayer.drm.UnsupportedDrmException -> L36
        L86:
            androidx.media3.exoplayer.drm.UnsupportedDrmException r5 = new androidx.media3.exoplayer.drm.UnsupportedDrmException     // Catch: java.lang.Exception -> L34 androidx.media3.exoplayer.drm.UnsupportedDrmException -> L36
            r6 = 1
            r5.<init>(r6, r0)     // Catch: java.lang.Exception -> L34 androidx.media3.exoplayer.drm.UnsupportedDrmException -> L36
            throw r5     // Catch: java.lang.Exception -> L34 androidx.media3.exoplayer.drm.UnsupportedDrmException -> L36
        L8d:
            r5 = 3
            if (r4 >= r5) goto L9a
            r6 = 1
            r1.f15522b = r6
            int r0 = r4 + 1
            androidx.media3.exoplayer.drm.DrmSessionManager r0 = r1.b(r2, r3, r0)
            return r0
        L9a:
            r6 = 1
            androidx.media3.exoplayer.drm.UnsupportedDrmException r2 = new androidx.media3.exoplayer.drm.UnsupportedDrmException
            r2.<init>(r6, r0)
            throw r2
        La1:
            r1.f15522b = r6
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.brentvatne.exoplayer.DRMManager.b(java.util.UUID, com.brentvatne.common.api.DRMProps, int):androidx.media3.exoplayer.drm.DrmSessionManager");
    }
}
