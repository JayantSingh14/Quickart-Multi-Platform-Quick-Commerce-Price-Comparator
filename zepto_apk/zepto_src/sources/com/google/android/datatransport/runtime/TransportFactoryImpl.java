package com.google.android.datatransport.runtime;

import com.google.android.datatransport.Encoding;
import com.google.android.datatransport.Transformer;
import com.google.android.datatransport.Transport;
import com.google.android.datatransport.TransportFactory;
import java.util.Set;

/* loaded from: classes.dex */
final class TransportFactoryImpl implements TransportFactory {

    /* renamed from: a, reason: collision with root package name */
    public final Set f20751a;

    /* renamed from: b, reason: collision with root package name */
    public final TransportContext f20752b;

    /* renamed from: c, reason: collision with root package name */
    public final TransportRuntime f20753c;

    public TransportFactoryImpl(Set set, TransportContext transportContext, TransportRuntime transportRuntime) {
        this.f20751a = set;
        this.f20752b = transportContext;
        this.f20753c = transportRuntime;
    }

    @Override // com.google.android.datatransport.TransportFactory
    public final Transport a(String str, Encoding encoding, Transformer transformer) {
        Set set = this.f20751a;
        if (!set.contains(encoding)) {
            throw new IllegalArgumentException(String.format("%s is not supported byt this factory. Supported encodings are: %s.", encoding, set));
        }
        return new TransportImpl(this.f20752b, str, encoding, transformer, this.f20753c);
    }
}
