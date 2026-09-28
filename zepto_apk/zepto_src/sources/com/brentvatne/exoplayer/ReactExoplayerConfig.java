package com.brentvatne.exoplayer;

import androidx.media3.exoplayer.upstream.DefaultBandwidthMeter;
import androidx.media3.exoplayer.upstream.DefaultLoadErrorHandlingPolicy;
import kotlin.Metadata;

@Metadata
/* loaded from: classes.dex */
public interface ReactExoplayerConfig {
    void a(boolean z);

    DefaultLoadErrorHandlingPolicy b(int i2);

    DefaultBandwidthMeter c();

    void d(long j2);
}
