package com.google.android.datatransport.runtime;

import android.content.Context;
import androidx.fragment.app.e;
import androidx.lifecycle.a;
import com.google.android.datatransport.Encoding;
import com.google.android.datatransport.TransportFactory;
import com.google.android.datatransport.cct.CCTDestination;
import com.google.android.datatransport.runtime.AutoValue_TransportContext;
import com.google.android.datatransport.runtime.DaggerTransportRuntimeComponent;
import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.scheduling.Scheduler;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.Uploader;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkInitializer;
import com.google.android.datatransport.runtime.time.Clock;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.Set;
import javax.inject.Singleton;

@Singleton
/* loaded from: classes.dex */
public class TransportRuntime implements TransportInternal {

    /* renamed from: e, reason: collision with root package name */
    public static volatile TransportRuntimeComponent f20759e;

    /* renamed from: a, reason: collision with root package name */
    public final Clock f20760a;

    /* renamed from: b, reason: collision with root package name */
    public final Clock f20761b;

    /* renamed from: c, reason: collision with root package name */
    public final Scheduler f20762c;

    /* renamed from: d, reason: collision with root package name */
    public final Uploader f20763d;

    public TransportRuntime(Clock clock, Clock clock2, Scheduler scheduler, Uploader uploader, WorkInitializer workInitializer) {
        this.f20760a = clock;
        this.f20761b = clock2;
        this.f20762c = scheduler;
        this.f20763d = uploader;
        workInitializer.getClass();
        workInitializer.f20893a.execute(new a(workInitializer, 5));
    }

    public static TransportRuntime a() {
        TransportRuntimeComponent transportRuntimeComponent = f20759e;
        if (transportRuntimeComponent != null) {
            return transportRuntimeComponent.b();
        }
        throw new IllegalStateException("Not initialized!");
    }

    public static void b(Context context) {
        if (f20759e == null) {
            synchronized (TransportRuntime.class) {
                try {
                    if (f20759e == null) {
                        DaggerTransportRuntimeComponent.Builder builder = new DaggerTransportRuntimeComponent.Builder();
                        context.getClass();
                        builder.f20733a = context;
                        f20759e = builder.a();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public final TransportFactory c(CCTDestination cCTDestination) {
        byte[] bytes;
        Set setUnmodifiableSet = cCTDestination != null ? Collections.unmodifiableSet(cCTDestination.a()) : Collections.singleton(new Encoding("proto"));
        TransportContext.Builder builderA = TransportContext.a();
        cCTDestination.getClass();
        ((AutoValue_TransportContext.Builder) builderA).f20730a = "cct";
        String str = cCTDestination.f20522a;
        String str2 = cCTDestination.f20523b;
        if (str2 == null && str == null) {
            bytes = null;
        } else {
            if (str2 == null) {
                str2 = "";
            }
            bytes = e.p("1$", str, "\\", str2).getBytes(Charset.forName("UTF-8"));
        }
        ((AutoValue_TransportContext.Builder) builderA).f20731b = bytes;
        return new TransportFactoryImpl(setUnmodifiableSet, builderA.a(), this);
    }
}
