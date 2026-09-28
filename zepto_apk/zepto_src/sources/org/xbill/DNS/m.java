package org.xbill.DNS;

import java.util.concurrent.Executor;
import java.util.function.BiFunction;
import org.xbill.DNS.ExtendedResolver;

/* loaded from: classes5.dex */
public final /* synthetic */ class m implements BiFunction {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f58046a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ExtendedResolver.Resolution f58047b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Executor f58048c;

    public /* synthetic */ m(ExtendedResolver.Resolution resolution, Executor executor, int i2) {
        this.f58046a = i2;
        this.f58047b = resolution;
        this.f58048c = executor;
    }

    @Override // java.util.function.BiFunction
    public final Object apply(Object obj, Object obj2) {
        Message message = (Message) obj;
        Throwable th = (Throwable) obj2;
        switch (this.f58046a) {
            case 0:
                return this.f58047b.lambda$startAsync$2(this.f58048c, message, th);
            default:
                return this.f58047b.lambda$handle$3(this.f58048c, message, th);
        }
    }
}
