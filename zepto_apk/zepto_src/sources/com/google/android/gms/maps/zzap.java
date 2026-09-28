package com.google.android.gms.maps;

import android.app.Activity;
import android.os.RemoteException;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.dynamic.DeferredLifecycleHelper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamic.OnDelegateCreatedListener;
import com.google.android.gms.maps.internal.zzcc;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import java.util.ArrayList;
import java.util.Iterator;

@VisibleForTesting
/* loaded from: classes4.dex */
final class zzap extends DeferredLifecycleHelper {

    /* renamed from: e, reason: collision with root package name */
    public final StreetViewPanoramaFragment f38602e;

    /* renamed from: f, reason: collision with root package name */
    public OnDelegateCreatedListener f38603f;

    /* renamed from: g, reason: collision with root package name */
    public Activity f38604g;

    /* renamed from: h, reason: collision with root package name */
    public final ArrayList f38605h = new ArrayList();

    public zzap(StreetViewPanoramaFragment streetViewPanoramaFragment) {
        this.f38602e = streetViewPanoramaFragment;
    }

    @Override // com.google.android.gms.dynamic.DeferredLifecycleHelper
    public final void a(OnDelegateCreatedListener onDelegateCreatedListener) {
        this.f38603f = onDelegateCreatedListener;
        n();
    }

    public final void n() {
        Activity activity = this.f38604g;
        if (activity == null || this.f38603f == null || this.f22295a != null) {
            return;
        }
        try {
            MapsInitializer.b(activity);
            this.f38603f.a(new zzao(this.f38602e, zzcc.a(this.f38604g, null).Z6(new ObjectWrapper(this.f38604g))));
            ArrayList arrayList = this.f38605h;
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((zzao) this.f22295a).a((OnStreetViewPanoramaReadyCallback) it.next());
            }
            arrayList.clear();
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        } catch (GooglePlayServicesNotAvailableException unused) {
        }
    }
}
