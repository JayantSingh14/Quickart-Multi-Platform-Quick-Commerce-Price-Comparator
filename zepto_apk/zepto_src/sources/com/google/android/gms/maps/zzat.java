package com.google.android.gms.maps;

import android.content.Context;
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
final class zzat extends DeferredLifecycleHelper {

    /* renamed from: e, reason: collision with root package name */
    public final StreetViewPanoramaView f38610e;

    /* renamed from: f, reason: collision with root package name */
    public final Context f38611f;

    /* renamed from: g, reason: collision with root package name */
    public OnDelegateCreatedListener f38612g;

    /* renamed from: h, reason: collision with root package name */
    public final ArrayList f38613h = new ArrayList();

    public zzat(StreetViewPanoramaView streetViewPanoramaView, Context context) {
        this.f38610e = streetViewPanoramaView;
        this.f38611f = context;
    }

    @Override // com.google.android.gms.dynamic.DeferredLifecycleHelper
    public final void a(OnDelegateCreatedListener onDelegateCreatedListener) {
        this.f38612g = onDelegateCreatedListener;
        Context context = this.f38611f;
        if (this.f22295a == null) {
            try {
                MapsInitializer.b(context);
                this.f38612g.a(new zzas(this.f38610e, zzcc.a(context, null).F7(new ObjectWrapper(context))));
                ArrayList arrayList = this.f38613h;
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((zzas) this.f22295a).a((OnStreetViewPanoramaReadyCallback) it.next());
                }
                arrayList.clear();
            } catch (RemoteException e2) {
                throw new RuntimeRemoteException(e2);
            } catch (GooglePlayServicesNotAvailableException unused) {
            }
        }
    }
}
