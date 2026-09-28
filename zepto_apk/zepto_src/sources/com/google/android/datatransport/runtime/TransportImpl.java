package com.google.android.datatransport.runtime;

import androidx.media3.exoplayer.analytics.p;
import com.google.android.datatransport.Encoding;
import com.google.android.datatransport.Event;
import com.google.android.datatransport.Transformer;
import com.google.android.datatransport.Transport;
import com.google.android.datatransport.TransportScheduleCallback;
import com.google.android.datatransport.runtime.EventInternal;
import com.google.android.datatransport.runtime.SendRequest;

/* loaded from: classes.dex */
final class TransportImpl<T> implements Transport<T> {

    /* renamed from: a, reason: collision with root package name */
    public final TransportContext f20754a;

    /* renamed from: b, reason: collision with root package name */
    public final String f20755b;

    /* renamed from: c, reason: collision with root package name */
    public final Encoding f20756c;

    /* renamed from: d, reason: collision with root package name */
    public final Transformer f20757d;

    /* renamed from: e, reason: collision with root package name */
    public final TransportRuntime f20758e;

    public TransportImpl(TransportContext transportContext, String str, Encoding encoding, Transformer transformer, TransportRuntime transportRuntime) {
        this.f20754a = transportContext;
        this.f20755b = str;
        this.f20756c = encoding;
        this.f20757d = transformer;
        this.f20758e = transportRuntime;
    }

    @Override // com.google.android.datatransport.Transport
    public final void a(Event event, TransportScheduleCallback transportScheduleCallback) {
        SendRequest.Builder builderA = SendRequest.a();
        builderA.e(this.f20754a);
        builderA.c(event);
        builderA.f(this.f20755b);
        builderA.d(this.f20757d);
        builderA.b(this.f20756c);
        AutoValue_SendRequest autoValue_SendRequestA = builderA.a();
        TransportRuntime transportRuntime = this.f20758e;
        TransportContext transportContextE = autoValue_SendRequestA.f().e(autoValue_SendRequestA.c().d());
        EventInternal.Builder builderA2 = EventInternal.a();
        builderA2.f(transportRuntime.f20760a.a());
        builderA2.l(transportRuntime.f20761b.a());
        builderA2.k(autoValue_SendRequestA.g());
        builderA2.e(new EncodedPayload(autoValue_SendRequestA.b(), autoValue_SendRequestA.d()));
        builderA2.d(autoValue_SendRequestA.c().a());
        if (autoValue_SendRequestA.c().e() != null && autoValue_SendRequestA.c().e().a() != null) {
            builderA2.i(autoValue_SendRequestA.c().e().a());
        }
        if (autoValue_SendRequestA.c().b() != null) {
            autoValue_SendRequestA.c().b().getClass();
        }
        transportRuntime.f20762c.a(transportContextE, builderA2.b(), transportScheduleCallback);
    }

    @Override // com.google.android.datatransport.Transport
    public final void b(Event event) {
        a(event, new p(26));
    }
}
