package org.xbill.DNS.dnssec;

import java.util.concurrent.Executor;
import java.util.function.Function;
import org.xbill.DNS.Message;

/* loaded from: classes5.dex */
public final /* synthetic */ class d implements Function {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f57943a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ValidatingResolver f57944b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Message f57945c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f57946d;

    public /* synthetic */ d(ValidatingResolver validatingResolver, Message message, Object obj, int i2) {
        this.f57943a = i2;
        this.f57944b = validatingResolver;
        this.f57945c = message;
        this.f57946d = obj;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        switch (this.f57943a) {
            case 0:
                return this.f57944b.lambda$processValidate$16(this.f57945c, (SMessage) this.f57946d, (Void) obj);
            default:
                return this.f57944b.lambda$sendAsync$18(this.f57945c, (Executor) this.f57946d, (SMessage) obj);
        }
    }
}
