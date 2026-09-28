package com.brentvatne.exoplayer;

import android.os.Binder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes3.dex */
public final class PlaybackServiceBinder extends Binder {

    /* renamed from: a, reason: collision with root package name */
    public final VideoPlaybackService f15557a;

    public PlaybackServiceBinder(VideoPlaybackService service) {
        Intrinsics.checkNotNullParameter(service, "service");
        this.f15557a = service;
    }

    public final VideoPlaybackService a() {
        return this.f15557a;
    }
}
