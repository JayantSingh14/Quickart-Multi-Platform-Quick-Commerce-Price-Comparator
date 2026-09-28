package com.brentvatne.common.api;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes3.dex */
public final class SideLoadedTextTrackList {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f15390a = new ArrayList();

    @Metadata
    public static final class Companion {
    }

    public final ArrayList a() {
        return this.f15390a;
    }

    public final boolean equals(Object obj) {
        if (obj == null || !(obj instanceof SideLoadedTextTrackList)) {
            return false;
        }
        return Intrinsics.b(this.f15390a, ((SideLoadedTextTrackList) obj).f15390a);
    }
}
