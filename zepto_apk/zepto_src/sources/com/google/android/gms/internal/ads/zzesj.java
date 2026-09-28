package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.core.graphics.Insets;
import com.google.android.gms.common.internal.Preconditions;
import com.swmansion.reanimated.layoutReanimation.Snapshot;
import java.util.ArrayList;

/* loaded from: classes4.dex */
public final class zzesj implements zzezv {

    /* renamed from: a, reason: collision with root package name */
    public final com.google.android.gms.ads.internal.client.zzr f30223a;

    /* renamed from: b, reason: collision with root package name */
    public final String f30224b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f30225c;

    /* renamed from: d, reason: collision with root package name */
    public final String f30226d;

    /* renamed from: e, reason: collision with root package name */
    public final float f30227e;

    /* renamed from: f, reason: collision with root package name */
    public final int f30228f;

    /* renamed from: g, reason: collision with root package name */
    public final int f30229g;

    /* renamed from: h, reason: collision with root package name */
    public final String f30230h;

    /* renamed from: i, reason: collision with root package name */
    public final int f30231i;

    /* renamed from: j, reason: collision with root package name */
    public final boolean f30232j;

    /* renamed from: k, reason: collision with root package name */
    public final Insets f30233k;

    /* renamed from: l, reason: collision with root package name */
    public final zzesg f30234l;

    public zzesj(com.google.android.gms.ads.internal.client.zzr zzrVar, String str, boolean z, String str2, float f2, int i2, int i3, String str3, int i4, boolean z2, Insets insets, zzesg zzesgVar) {
        Preconditions.checkNotNull(zzrVar, "the adSize must not be null");
        this.f30223a = zzrVar;
        this.f30224b = str;
        this.f30225c = z;
        this.f30226d = str2;
        this.f30227e = f2;
        this.f30228f = i2;
        this.f30229g = i3;
        this.f30230h = str3;
        this.f30231i = i4;
        this.f30232j = z2;
        this.f30233k = insets;
        this.f30234l = zzesgVar;
    }

    public final void a(Bundle bundle) {
        com.google.android.gms.ads.internal.client.zzr zzrVar = this.f30223a;
        int i2 = zzrVar.f21285e;
        zzfiz.b(bundle, "smart_w", "full", i2 == -1);
        int i3 = zzrVar.f21282b;
        zzfiz.b(bundle, "smart_h", "auto", i3 == -2);
        zzfiz.d(bundle, "ene", true, zzrVar.f21290j);
        zzfiz.b(bundle, "rafmt", "102", zzrVar.f21293m);
        zzfiz.b(bundle, "rafmt", "103", zzrVar.n);
        boolean z = zzrVar.o;
        zzfiz.b(bundle, "rafmt", "105", z);
        zzfiz.d(bundle, "inline_adaptive_slot", true, this.f30232j);
        zzfiz.d(bundle, "interscroller_slot", true, z);
        zzfiz.e("format", this.f30224b, bundle);
        zzfiz.b(bundle, "fluid", Snapshot.HEIGHT, this.f30225c);
        zzfiz.b(bundle, "sz", this.f30226d, !TextUtils.isEmpty(r5));
        bundle.putFloat("u_sd", this.f30227e);
        bundle.putInt("sw", this.f30228f);
        bundle.putInt("sh", this.f30229g);
        String str = this.f30230h;
        zzfiz.b(bundle, "sc", str, true ^ TextUtils.isEmpty(str));
        int i4 = this.f30231i;
        if (i4 != -1) {
            bundle.putInt("u_mso", i4);
        }
        Insets insets = this.f30233k;
        if (insets != null) {
            bundle.putInt("sam_t", insets.f2809b);
            bundle.putInt("sam_b", insets.f2811d);
            bundle.putInt("sam_l", insets.f2808a);
            bundle.putInt("sam_r", insets.f2810c);
        }
        zzesg zzesgVar = this.f30234l;
        if (zzesgVar != null) {
            bundle.putInt("rc_tl", zzesgVar.f30214a);
            bundle.putInt("rc_tr", zzesgVar.f30215b);
            bundle.putInt("rc_bl", zzesgVar.f30216c);
            bundle.putInt("rc_br", zzesgVar.f30217d);
        }
        ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
        com.google.android.gms.ads.internal.client.zzr[] zzrVarArr = zzrVar.f21287g;
        if (zzrVarArr == null) {
            Bundle bundle2 = new Bundle();
            bundle2.putInt(Snapshot.HEIGHT, i3);
            bundle2.putInt(Snapshot.WIDTH, i2);
            bundle2.putBoolean("is_fluid_height", zzrVar.f21289i);
            arrayList.add(bundle2);
        } else {
            for (com.google.android.gms.ads.internal.client.zzr zzrVar2 : zzrVarArr) {
                Bundle bundle3 = new Bundle();
                bundle3.putBoolean("is_fluid_height", zzrVar2.f21289i);
                bundle3.putInt(Snapshot.HEIGHT, zzrVar2.f21282b);
                bundle3.putInt(Snapshot.WIDTH, zzrVar2.f21285e);
                arrayList.add(bundle3);
            }
        }
        bundle.putParcelableArrayList("valid_ad_sizes", arrayList);
    }

    @Override // com.google.android.gms.internal.ads.zzezv
    public final /* synthetic */ void zza(Object obj) {
        a(((zzczm) obj).f27481a);
    }

    @Override // com.google.android.gms.internal.ads.zzezv
    public final /* synthetic */ void zzb(Object obj) {
        a(((zzczm) obj).f27482b);
    }
}
