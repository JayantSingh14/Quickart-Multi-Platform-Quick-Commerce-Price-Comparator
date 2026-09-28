package com.facebook.react.views.text;

import android.text.Spannable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes.dex */
public final class ReactTextUpdate {

    /* renamed from: a, reason: collision with root package name */
    public final Spannable f20099a;

    /* renamed from: b, reason: collision with root package name */
    public final int f20100b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f20101c;

    /* renamed from: d, reason: collision with root package name */
    public final float f20102d;

    /* renamed from: e, reason: collision with root package name */
    public final float f20103e;

    /* renamed from: f, reason: collision with root package name */
    public final float f20104f;

    /* renamed from: g, reason: collision with root package name */
    public final float f20105g;

    /* renamed from: h, reason: collision with root package name */
    public final int f20106h;

    /* renamed from: i, reason: collision with root package name */
    public final int f20107i;

    /* renamed from: j, reason: collision with root package name */
    public final int f20108j;

    @Metadata
    public static final class Companion {
    }

    public ReactTextUpdate(Spannable text, int i2, boolean z, float f2, float f3, float f4, float f5, int i3, int i4, int i5) {
        Intrinsics.checkNotNullParameter(text, "text");
        this.f20099a = text;
        this.f20100b = i2;
        this.f20101c = z;
        this.f20102d = f2;
        this.f20103e = f3;
        this.f20104f = f4;
        this.f20105g = f5;
        this.f20106h = i3;
        this.f20107i = i4;
        this.f20108j = i5;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ReactTextUpdate(Spannable text, int i2, int i3, int i4, int i5) {
        this(text, i2, false, -1.0f, -1.0f, -1.0f, -1.0f, i3, i4, i5);
        Intrinsics.checkNotNullParameter(text, "text");
    }
}
