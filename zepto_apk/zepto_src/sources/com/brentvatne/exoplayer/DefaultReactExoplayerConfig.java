package com.brentvatne.exoplayer;

import androidx.media3.exoplayer.upstream.DefaultBandwidthMeter;
import androidx.media3.exoplayer.upstream.DefaultLoadErrorHandlingPolicy;
import com.facebook.react.bridge.ReactApplicationContext;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes.dex */
public final class DefaultReactExoplayerConfig implements ReactExoplayerConfig {

    /* renamed from: a, reason: collision with root package name */
    public final ReactApplicationContext f15526a;

    /* renamed from: b, reason: collision with root package name */
    public Long f15527b;

    /* renamed from: c, reason: collision with root package name */
    public DefaultBandwidthMeter f15528c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f15529d;

    public DefaultReactExoplayerConfig(ReactApplicationContext context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.f15526a = context;
        this.f15527b = null;
        this.f15528c = e(null);
    }

    @Override // com.brentvatne.exoplayer.ReactExoplayerConfig
    public final void a(boolean z) {
        this.f15529d = z;
    }

    @Override // com.brentvatne.exoplayer.ReactExoplayerConfig
    public final DefaultLoadErrorHandlingPolicy b(int i2) {
        return this.f15529d ? new ReactExoplayerLoadErrorHandlingPolicy(i2) : new DefaultLoadErrorHandlingPolicy(i2);
    }

    @Override // com.brentvatne.exoplayer.ReactExoplayerConfig
    public final DefaultBandwidthMeter c() {
        return this.f15528c;
    }

    @Override // com.brentvatne.exoplayer.ReactExoplayerConfig
    public final void d(long j2) {
        Long l2 = this.f15527b;
        if (l2 != null && l2.longValue() == j2) {
            return;
        }
        this.f15527b = Long.valueOf(j2);
        this.f15528c = e(Long.valueOf(j2));
    }

    public final DefaultBandwidthMeter e(Long l2) {
        DefaultBandwidthMeter.Builder builder = new DefaultBandwidthMeter.Builder(this.f15526a);
        long jLongValue = l2 != null ? l2.longValue() : 1000000L;
        HashMap map = builder.f8151b;
        for (Integer num : map.keySet()) {
            num.getClass();
            map.put(num, Long.valueOf(jLongValue));
        }
        DefaultBandwidthMeter defaultBandwidthMeter = new DefaultBandwidthMeter(builder.f8150a, builder.f8151b, builder.f8152c, builder.f8153d, builder.f8154e);
        Intrinsics.checkNotNullExpressionValue(defaultBandwidthMeter, "build(...)");
        return defaultBandwidthMeter;
    }
}
