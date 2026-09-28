package com.brentvatne.common.api;

import android.net.Uri;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes3.dex */
public final class SideLoadedTextTrack {

    /* renamed from: a, reason: collision with root package name */
    public String f15386a;

    /* renamed from: b, reason: collision with root package name */
    public String f15387b;

    /* renamed from: c, reason: collision with root package name */
    public Uri f15388c;

    /* renamed from: d, reason: collision with root package name */
    public String f15389d;

    @Metadata
    public static final class Companion {
    }

    public SideLoadedTextTrack() {
        Uri EMPTY = Uri.EMPTY;
        Intrinsics.checkNotNullExpressionValue(EMPTY, "EMPTY");
        this.f15388c = EMPTY;
    }

    public final String a() {
        return this.f15386a;
    }

    public final String b() {
        return this.f15387b;
    }

    public final String c() {
        return this.f15389d;
    }

    public final Uri d() {
        return this.f15388c;
    }
}
