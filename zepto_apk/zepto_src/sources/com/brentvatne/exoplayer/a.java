package com.brentvatne.exoplayer;

import androidx.media3.common.MediaItem;
import androidx.media3.exoplayer.drm.DrmSessionManager;
import androidx.media3.exoplayer.drm.DrmSessionManagerProvider;
import androidx.media3.exoplayer.drm.ExoMediaDrm;
import androidx.media3.exoplayer.drm.FrameworkMediaDrm;
import androidx.media3.exoplayer.upstream.CmcdConfiguration;
import com.brentvatne.common.toolbox.DebugLog;
import java.net.CookieManager;
import java.util.UUID;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes3.dex */
public final /* synthetic */ class a implements CmcdConfiguration.Factory, ExoMediaDrm.Provider, DrmSessionManagerProvider {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f15601a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f15602b;

    public /* synthetic */ a(Object obj, int i2) {
        this.f15601a = i2;
        this.f15602b = obj;
    }

    @Override // androidx.media3.exoplayer.drm.DrmSessionManagerProvider
    public DrmSessionManager a(MediaItem mediaItem) {
        CookieManager cookieManager = ReactExoplayerView.j1;
        return (DrmSessionManager) this.f15602b;
    }

    @Override // androidx.media3.exoplayer.upstream.CmcdConfiguration.Factory
    public CmcdConfiguration b(MediaItem mediaItem) {
        switch (this.f15601a) {
            case 0:
                CMCDConfig cMCDConfig = (CMCDConfig) this.f15602b;
                cMCDConfig.getClass();
                String string = UUID.randomUUID().toString();
                String str = mediaItem.f5257a;
                CMCDConfig$createCmcdConfiguration$1 cMCDConfig$createCmcdConfiguration$1 = new CMCDConfig$createCmcdConfiguration$1(cMCDConfig);
                int i2 = cMCDConfig.f15519a.f15367e;
                int i3 = 0;
                if (i2 != 0) {
                    if (i2 != 1) {
                        DebugLog.b("CMCDConfig", "Unsupported mode: " + i2 + ", fallback on MODE_REQUEST_HEADER");
                    } else {
                        i3 = 1;
                    }
                }
                return new CmcdConfiguration(string, str, cMCDConfig$createCmcdConfiguration$1, i3);
            default:
                return ((CmcdConfiguration.Factory) this.f15602b).b(mediaItem);
        }
    }

    @Override // androidx.media3.exoplayer.drm.ExoMediaDrm.Provider
    public ExoMediaDrm h(UUID it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return (FrameworkMediaDrm) this.f15602b;
    }
}
