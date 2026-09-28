package com.google.android.gms.internal.base;

import android.graphics.drawable.Drawable;

/* loaded from: classes4.dex */
final class zaj extends Drawable.ConstantState {

    /* renamed from: a, reason: collision with root package name */
    public int f36455a;

    /* renamed from: b, reason: collision with root package name */
    public int f36456b;

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final int getChangingConfigurations() {
        return this.f36455a;
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final Drawable newDrawable() {
        return new zak(this);
    }
}
