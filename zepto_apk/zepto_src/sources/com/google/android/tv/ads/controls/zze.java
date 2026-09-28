package com.google.android.tv.ads.controls;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.bumptech.glide.request.target.CustomViewTarget;
import com.bumptech.glide.request.transition.Transition;
import com.google.android.gms.internal.atv_ads_framework.zzf;
import com.google.android.gms.internal.atv_ads_framework.zzm;
import com.google.android.gms.internal.atv_ads_framework.zzn;

/* loaded from: classes4.dex */
final class zze extends CustomViewTarget {

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ SideDrawerFragment f42214d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zze(SideDrawerFragment sideDrawerFragment, ImageView imageView) {
        super(imageView);
        this.f42214d = sideDrawerFragment;
    }

    @Override // com.bumptech.glide.request.target.CustomViewTarget
    public final void b(Drawable drawable) {
        this.f42214d.Z.setImageDrawable(drawable);
    }

    @Override // com.bumptech.glide.request.target.Target
    public final void d() {
        SideDrawerFragment sideDrawerFragment = this.f42214d;
        zzf zzfVarA = zzf.a(sideDrawerFragment.requireContext());
        zzm zzmVarK = zzn.k();
        zzmVarK.e();
        zzmVarK.g(2);
        zzmVarK.f(4);
        zzfVarA.b((zzn) zzmVarK.b());
        sideDrawerFragment.Y.setVisibility(8);
        sideDrawerFragment.B0.setVisibility(0);
        sideDrawerFragment.C0.requestFocus();
    }

    @Override // com.bumptech.glide.request.target.Target
    public final /* bridge */ /* synthetic */ void g(Object obj, Transition transition) {
        SideDrawerFragment sideDrawerFragment = this.f42214d;
        zzf zzfVarA = zzf.a(sideDrawerFragment.requireContext());
        zzm zzmVarK = zzn.k();
        zzmVarK.e();
        zzmVarK.g(2);
        zzfVarA.b((zzn) zzmVarK.b());
        sideDrawerFragment.Z.setImageDrawable((Drawable) obj);
    }
}
