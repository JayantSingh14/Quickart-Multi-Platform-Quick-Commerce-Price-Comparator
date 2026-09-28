package com.google.android.gms.ads.internal.overlay;

import android.content.Context;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.internal.ads.zzcir;

@VisibleForTesting
/* loaded from: classes4.dex */
public final class zzj {

    /* renamed from: a, reason: collision with root package name */
    public final int f21353a;

    /* renamed from: b, reason: collision with root package name */
    public final ViewGroup.LayoutParams f21354b;

    /* renamed from: c, reason: collision with root package name */
    public final ViewGroup f21355c;

    /* renamed from: d, reason: collision with root package name */
    public final Context f21356d;

    public zzj(zzcir zzcirVar) throws zzh {
        this.f21354b = zzcirVar.getLayoutParams();
        ViewParent parent = zzcirVar.getParent();
        this.f21356d = zzcirVar.O();
        if (!(parent instanceof ViewGroup)) {
            throw new zzh("Could not get the parent of the WebView for an overlay.");
        }
        ViewGroup viewGroup = (ViewGroup) parent;
        this.f21355c = viewGroup;
        this.f21353a = viewGroup.indexOfChild(zzcirVar.x());
        viewGroup.removeView(zzcirVar.x());
        zzcirVar.g0(true);
    }
}
