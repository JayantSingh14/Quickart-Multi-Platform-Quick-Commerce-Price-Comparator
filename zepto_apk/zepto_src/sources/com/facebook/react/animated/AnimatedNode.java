package com.facebook.react.animated;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public abstract class AnimatedNode {

    /* renamed from: a, reason: collision with root package name */
    public ArrayList f18521a;

    /* renamed from: b, reason: collision with root package name */
    public int f18522b;

    /* renamed from: c, reason: collision with root package name */
    public int f18523c;

    /* renamed from: d, reason: collision with root package name */
    public int f18524d = -1;

    @Metadata
    public static final class Companion {
    }

    public void b(AnimatedNode parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
    }

    public void c(AnimatedNode parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
    }

    public abstract String d();

    public void e() {
    }
}
