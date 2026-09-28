package com.google.android.gms.maps;

import android.app.Activity;
import android.os.RemoteException;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.dynamic.DeferredLifecycleHelper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamic.OnDelegateCreatedListener;
import com.google.android.gms.maps.internal.IMapFragmentDelegate;
import com.google.android.gms.maps.internal.zzcc;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import java.util.ArrayList;
import java.util.Iterator;

@VisibleForTesting
/* loaded from: classes4.dex */
final class zzaw extends DeferredLifecycleHelper {

    /* renamed from: e, reason: collision with root package name */
    public final SupportMapFragment f38617e;

    /* renamed from: f, reason: collision with root package name */
    public OnDelegateCreatedListener f38618f;

    /* renamed from: g, reason: collision with root package name */
    public Activity f38619g;

    /* renamed from: h, reason: collision with root package name */
    public final ArrayList f38620h = new ArrayList();

    public zzaw(SupportMapFragment supportMapFragment) {
        this.f38617e = supportMapFragment;
    }

    @Override // com.google.android.gms.dynamic.DeferredLifecycleHelper
    public final void a(OnDelegateCreatedListener onDelegateCreatedListener) {
        this.f38618f = onDelegateCreatedListener;
        n();
    }

    public final void n() {
        Activity activity = this.f38619g;
        if (activity == null || this.f38618f == null || this.f22295a != null) {
            return;
        }
        try {
            MapsInitializer.b(activity);
            IMapFragmentDelegate iMapFragmentDelegateM8 = zzcc.a(this.f38619g, null).m8(new ObjectWrapper(this.f38619g));
            if (iMapFragmentDelegateM8 == null) {
                return;
            }
            this.f38618f.a(new zzav(this.f38617e, iMapFragmentDelegateM8));
            ArrayList arrayList = this.f38620h;
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((zzav) this.f22295a).a((OnMapReadyCallback) it.next());
            }
            arrayList.clear();
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        } catch (GooglePlayServicesNotAvailableException unused) {
        }
    }
}
