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
final class zzaz extends DeferredLifecycleHelper {

    /* renamed from: e, reason: collision with root package name */
    public final SupportStreetViewPanoramaFragment f38624e;

    /* renamed from: f, reason: collision with root package name */
    public OnDelegateCreatedListener f38625f;

    /* renamed from: g, reason: collision with root package name */
    public Activity f38626g;

    /* renamed from: h, reason: collision with root package name */
    public final ArrayList f38627h = new ArrayList();

    public zzaz(SupportStreetViewPanoramaFragment supportStreetViewPanoramaFragment) {
        this.f38624e = supportStreetViewPanoramaFragment;
    }

    @Override // com.google.android.gms.dynamic.DeferredLifecycleHelper
    public final void a(OnDelegateCreatedListener onDelegateCreatedListener) {
        this.f38625f = onDelegateCreatedListener;
        n();
    }

    public final void n() {
        Activity activity = this.f38626g;
        if (activity == null || this.f38625f == null || this.f22295a != null) {
            return;
        }
        try {
            MapsInitializer.b(activity);
            this.f38625f.a(new zzay(this.f38624e, zzcc.a(this.f38626g, null).Z6(new ObjectWrapper(this.f38626g))));
            ArrayList arrayList = this.f38627h;
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((zzay) this.f22295a).a((OnStreetViewPanoramaReadyCallback) it.next());
            }
            arrayList.clear();
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        } catch (GooglePlayServicesNotAvailableException unused) {
        }
    }
}
