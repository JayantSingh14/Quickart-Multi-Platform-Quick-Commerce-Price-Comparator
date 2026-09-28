package com.brentvatne.exoplayer;

import androidx.media3.common.MediaItem;
import androidx.media3.common.MediaMetadata;
import com.brentvatne.common.api.BufferConfig;
import com.brentvatne.common.api.Source;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes3.dex */
public final class ConfigurationUtils {
    public static final MediaMetadata a(Source.Metadata metadata) {
        if (metadata == null) {
            return null;
        }
        MediaMetadata.Builder builder = new MediaMetadata.Builder();
        builder.f5392a = metadata.f15404a;
        builder.f5397f = metadata.f15405b;
        builder.f5398g = metadata.f15406c;
        builder.f5393b = metadata.f15407d;
        builder.f5404m = metadata.f15408e;
        return new MediaMetadata(builder);
    }

    public static final MediaItem.LiveConfiguration.Builder b(BufferConfig bufferConfig) {
        Intrinsics.checkNotNullParameter(bufferConfig, "bufferConfig");
        MediaItem.LiveConfiguration.Builder builder = new MediaItem.LiveConfiguration.Builder();
        BufferConfig.Live live = bufferConfig.f15352k;
        long j2 = live.f15355c;
        if (j2 >= 0) {
            builder.f5331c = j2;
        }
        float f2 = live.f15353a;
        if (f2 >= 0.0f) {
            builder.f5333e = f2;
        }
        long j3 = live.f15357e;
        if (j3 >= 0) {
            builder.f5329a = j3;
        }
        long j4 = live.f15356d;
        if (j4 >= 0) {
            builder.f5330b = j4;
        }
        float f3 = live.f15354b;
        if (f3 >= 0.0f) {
            builder.f5332d = f3;
        }
        return builder;
    }
}
