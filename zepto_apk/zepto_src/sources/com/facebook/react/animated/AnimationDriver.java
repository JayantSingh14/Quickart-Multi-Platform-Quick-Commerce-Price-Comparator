package com.facebook.react.animated;

import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReadableMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes.dex */
public abstract class AnimationDriver {

    /* renamed from: a, reason: collision with root package name */
    public boolean f18525a;

    /* renamed from: b, reason: collision with root package name */
    public ValueAnimatedNode f18526b;

    /* renamed from: c, reason: collision with root package name */
    public Callback f18527c;

    /* renamed from: d, reason: collision with root package name */
    public int f18528d;

    public void a(ReadableMap config) {
        Intrinsics.checkNotNullParameter(config, "config");
    }

    public abstract void b(long j2);
}
