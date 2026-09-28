package com.zeptonow.horizon.utils;

import kotlin.Metadata;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.scheduling.DefaultIoScheduler;
import kotlinx.coroutines.scheduling.DefaultScheduler;

@Metadata
/* loaded from: classes.dex */
public final class AndroidDispatchersProvider implements DispatchersProvider {

    /* renamed from: a, reason: collision with root package name */
    public final DefaultScheduler f48227a;

    /* renamed from: b, reason: collision with root package name */
    public final DefaultIoScheduler f48228b;

    /* renamed from: c, reason: collision with root package name */
    public final DefaultIoScheduler f48229c;

    public AndroidDispatchersProvider() {
        DefaultScheduler defaultScheduler = Dispatchers.f54091a;
        DefaultIoScheduler defaultIoScheduler = DefaultIoScheduler.f55150b;
        this.f48227a = Dispatchers.f54091a;
        this.f48228b = defaultIoScheduler;
        this.f48229c = defaultIoScheduler;
    }
}
