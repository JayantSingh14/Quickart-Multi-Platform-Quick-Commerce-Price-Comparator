package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.view.Window;
import android.widget.FrameLayout;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Set;
import java.util.concurrent.Callable;

/* loaded from: classes4.dex */
public final class zzexf implements zzezx {

    /* renamed from: a, reason: collision with root package name */
    public final zzgyw f30519a;

    /* renamed from: b, reason: collision with root package name */
    public final FrameLayout f30520b;

    /* renamed from: c, reason: collision with root package name */
    public final Context f30521c;

    /* renamed from: d, reason: collision with root package name */
    public final Set f30522d;

    public zzexf(zzgyw zzgywVar, FrameLayout frameLayout, Context context, Set set) {
        this.f30519a = zzgywVar;
        this.f30522d = set;
        this.f30520b = frameLayout;
        this.f30521c = context;
    }

    @Override // com.google.android.gms.internal.ads.zzezx
    public final ListenableFuture zza() {
        return ((zzgxi) this.f30519a).submit(new Callable() { // from class: com.google.android.gms.internal.ads.zzexe
            @Override // java.util.concurrent.Callable
            public final Object call() {
                FrameLayout frameLayout;
                zzexf zzexfVar = this.f30518a;
                zzexfVar.getClass();
                zzbgb zzbgbVar = zzbgk.C6;
                com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.f21150e;
                boolean zBooleanValue = ((Boolean) zzbdVar.f21153c.a(zzbgbVar)).booleanValue();
                Set set = zzexfVar.f30522d;
                if (zBooleanValue && (frameLayout = zzexfVar.f30520b) != null && set.contains("banner")) {
                    return new zzexg(Boolean.valueOf(frameLayout.isHardwareAccelerated()));
                }
                boolean zBooleanValue2 = ((Boolean) zzbdVar.f21153c.a(zzbgk.D6)).booleanValue();
                Boolean boolValueOf = null;
                if (zBooleanValue2 && set.contains("native")) {
                    Context context = zzexfVar.f30521c;
                    if (context instanceof Activity) {
                        Activity activity = (Activity) context;
                        Window window = activity.getWindow();
                        if (window == null || (window.getAttributes().flags & 16777216) == 0) {
                            try {
                                boolValueOf = Boolean.valueOf((activity.getPackageManager().getActivityInfo(activity.getComponentName(), 0).flags & 512) != 0);
                            } catch (PackageManager.NameNotFoundException unused) {
                            }
                        } else {
                            boolValueOf = Boolean.TRUE;
                        }
                        return new zzexg(boolValueOf);
                    }
                }
                return new zzexg(null);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzezx
    public final int zzb() {
        return 22;
    }
}
