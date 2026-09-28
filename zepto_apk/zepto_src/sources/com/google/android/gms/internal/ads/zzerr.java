package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.concurrent.Callable;

/* loaded from: classes4.dex */
public final class zzerr implements zzezx {

    /* renamed from: a, reason: collision with root package name */
    public final zzgyw f30176a;

    /* renamed from: b, reason: collision with root package name */
    public final Context f30177b;

    /* renamed from: c, reason: collision with root package name */
    public final zzfik f30178c;

    /* renamed from: d, reason: collision with root package name */
    public final ViewGroup f30179d;

    public zzerr(zzgyw zzgywVar, Context context, zzfik zzfikVar, FrameLayout frameLayout) {
        this.f30176a = zzgywVar;
        this.f30177b = context;
        this.f30178c = zzfikVar;
        this.f30179d = frameLayout;
    }

    @Override // com.google.android.gms.internal.ads.zzezx
    public final ListenableFuture zza() {
        zzbgk.a(this.f30177b);
        return ((zzgxi) this.f30176a).submit(new Callable() { // from class: com.google.android.gms.internal.ads.zzerq
            @Override // java.util.concurrent.Callable
            public final /* synthetic */ Object call() {
                zzerr zzerrVar = this.f30175a;
                zzerrVar.getClass();
                ArrayList arrayList = new ArrayList();
                View view = zzerrVar.f30179d;
                while (view != null) {
                    Object parent = view.getParent();
                    if (parent == null) {
                        break;
                    }
                    int iIndexOfChild = parent instanceof ViewGroup ? ((ViewGroup) parent).indexOfChild(view) : -1;
                    Bundle bundle = new Bundle();
                    bundle.putString("type", parent.getClass().getName());
                    bundle.putInt("index_of_child", iIndexOfChild);
                    arrayList.add(bundle);
                    if (!(parent instanceof View)) {
                        break;
                    }
                    view = (View) parent;
                }
                return new zzers(zzerrVar.f30177b, zzerrVar.f30178c.f31218f, arrayList);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzezx
    public final int zzb() {
        return 3;
    }
}
