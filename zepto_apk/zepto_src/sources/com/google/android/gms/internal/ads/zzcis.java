package com.google.android.gms.internal.ads;

import android.view.View;
import java.util.Objects;

/* loaded from: classes4.dex */
final class zzcis implements View.OnAttachStateChangeListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzcbk f26343a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zzcjc f26344b;

    public zzcis(zzcjc zzcjcVar, zzcbk zzcbkVar) {
        this.f26343a = zzcbkVar;
        Objects.requireNonNull(zzcjcVar);
        this.f26344b = zzcjcVar;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
        this.f26344b.F(view, this.f26343a, 10);
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
    }
}
