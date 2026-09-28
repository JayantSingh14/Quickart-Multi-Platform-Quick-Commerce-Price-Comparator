package org.xbill.DNS;

import java.util.function.BiFunction;

/* loaded from: classes5.dex */
public final /* synthetic */ class f implements BiFunction {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f58000a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f58001b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f58002c;

    public /* synthetic */ f(int i2, Object obj, Object obj2) {
        this.f58000a = i2;
        this.f58001b = obj;
        this.f58002c = obj2;
    }

    @Override // java.util.function.BiFunction
    public final Object apply(Object obj, Object obj2) {
        switch (this.f58000a) {
            case 0:
                return ((DohResolver) this.f58001b).lambda$sendAsync11WithConcurrentRequestPermit$5((Message) this.f58002c, obj, (Throwable) obj2);
            default:
                Object obj3 = this.f58002c;
                return Resolver.lambda$sendAsync$0((ResolverListener) this.f58001b, obj3, (Message) obj, (Throwable) obj2);
        }
    }
}
