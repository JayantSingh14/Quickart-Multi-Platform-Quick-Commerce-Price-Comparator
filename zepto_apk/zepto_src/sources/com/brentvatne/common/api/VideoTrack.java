package com.brentvatne.common.api;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes3.dex */
public final class VideoTrack {

    /* renamed from: a, reason: collision with root package name */
    public int f15422a;

    /* renamed from: b, reason: collision with root package name */
    public int f15423b;

    /* renamed from: c, reason: collision with root package name */
    public int f15424c;

    /* renamed from: d, reason: collision with root package name */
    public String f15425d = "";

    /* renamed from: e, reason: collision with root package name */
    public int f15426e = -1;

    /* renamed from: f, reason: collision with root package name */
    public String f15427f = "";

    /* renamed from: g, reason: collision with root package name */
    public int f15428g;

    public final void a(int i2) {
        this.f15424c = i2;
    }

    public final void b(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.f15425d = str;
    }

    public final void c(int i2) {
        this.f15423b = i2;
    }

    public final void d(int i2) {
        this.f15426e = i2;
    }

    public final void e(int i2) {
        this.f15428g = i2;
    }

    public final void f(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.f15427f = str;
    }

    public final void g(int i2) {
        this.f15422a = i2;
    }
}
