package com.facebook.imagepipeline.core;

import com.facebook.common.internal.ImmutableMap;
import com.facebook.imagepipeline.cache.BufferedDiskCache;
import kotlin.Metadata;

@Metadata
/* loaded from: classes3.dex */
public interface DiskCachesStore {
    BufferedDiskCache a();

    BufferedDiskCache b();

    ImmutableMap c();
}
