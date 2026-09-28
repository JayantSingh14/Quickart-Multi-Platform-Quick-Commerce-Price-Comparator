package com.brentvatne.exoplayer;

import androidx.media3.common.MediaItem;
import androidx.media3.datasource.DataSource;
import androidx.media3.exoplayer.drm.DrmSessionManager;
import com.brentvatne.common.api.Source;
import com.brentvatne.react.RNVPlugin;
import kotlin.Metadata;

@Metadata
/* loaded from: classes3.dex */
public interface RNVExoplayerPlugin extends RNVPlugin {

    @Metadata
    public static final class DefaultImpls {
    }

    DataSource.Factory a(Source source, DataSource.Factory factory);

    DrmSessionManager c(Source source, DrmSessionManager drmSessionManager);

    MediaItem.Builder e(Source source, MediaItem.Builder builder);

    boolean f(Source source);
}
