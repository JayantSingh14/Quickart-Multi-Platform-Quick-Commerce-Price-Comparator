package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import androidx.media3.exoplayer.analytics.l;
import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.synchronization.SynchronizationException;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;
import java.util.Objects;
import org.xbill.DNS.Name;
import org.xbill.DNS.RRset;
import org.xbill.DNS.Record;
import org.xbill.DNS.Zone;

/* loaded from: classes3.dex */
public final /* synthetic */ class a implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f20901a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f20902b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f20903c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f20904d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Object f20905e;

    public /* synthetic */ a(int i2, int i3, Object obj, Object obj2, Object obj3) {
        this.f20901a = i3;
        this.f20903c = obj;
        this.f20904d = obj2;
        this.f20902b = i2;
        this.f20905e = obj3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f20901a) {
            case 0:
                TransportContext transportContext = (TransportContext) this.f20904d;
                int i2 = this.f20902b;
                Runnable runnable = (Runnable) this.f20905e;
                Uploader uploader = (Uploader) this.f20903c;
                SynchronizationGuard synchronizationGuard = uploader.f20880f;
                try {
                    try {
                        EventStore eventStore = uploader.f20877c;
                        Objects.requireNonNull(eventStore);
                        synchronizationGuard.b(new l(eventStore, 8));
                        NetworkInfo activeNetworkInfo = ((ConnectivityManager) uploader.f20875a.getSystemService("connectivity")).getActiveNetworkInfo();
                        if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
                            synchronizationGuard.b(new b(i2, uploader, transportContext));
                        } else {
                            uploader.a(transportContext, i2);
                        }
                    } catch (SynchronizationException unused) {
                        uploader.f20878d.a(transportContext, i2 + 1);
                    }
                    runnable.run();
                    return;
                } catch (Throwable th) {
                    runnable.run();
                    throw th;
                }
            case 1:
                ((Zone) this.f20903c).lambda$removeRecord$2((Name) this.f20904d, this.f20902b, (Record) this.f20905e);
                return;
            default:
                ((Zone) this.f20903c).lambda$addRRset$3((Name) this.f20904d, (RRset) this.f20905e, this.f20902b);
                return;
        }
    }

    public /* synthetic */ a(Zone zone, Name name, RRset rRset, int i2) {
        this.f20901a = 2;
        this.f20903c = zone;
        this.f20904d = name;
        this.f20905e = rRset;
        this.f20902b = i2;
    }
}
