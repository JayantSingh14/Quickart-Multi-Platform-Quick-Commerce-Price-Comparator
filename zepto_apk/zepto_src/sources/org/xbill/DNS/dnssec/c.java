package org.xbill.DNS.dnssec;

import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import org.xbill.DNS.Message;

/* loaded from: classes5.dex */
public final /* synthetic */ class c implements Function {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f57937a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ValidatingResolver f57938b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ SMessage f57939c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f57940d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Object f57941e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ Executor f57942f;

    public /* synthetic */ c(ValidatingResolver validatingResolver, SMessage sMessage, Message message, Nsec3ValidationState nsec3ValidationState, Executor executor, int i2) {
        this.f57937a = i2;
        this.f57938b = validatingResolver;
        this.f57939c = sMessage;
        this.f57940d = message;
        this.f57941e = nsec3ValidationState;
        this.f57942f = executor;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        switch (this.f57937a) {
            case 0:
                Void r5 = (Void) obj;
                return this.f57938b.lambda$processValidate$14(this.f57939c, (Message) this.f57940d, (Nsec3ValidationState) this.f57941e, this.f57942f, r5);
            case 1:
                Void r52 = (Void) obj;
                return this.f57938b.lambda$processValidate$15(this.f57939c, (Message) this.f57940d, (Nsec3ValidationState) this.f57941e, this.f57942f, r52);
            default:
                KeyEntry keyEntry = (KeyEntry) obj;
                return this.f57938b.lambda$validateNameErrorResponseRecursive$9((SRRset) this.f57940d, this.f57939c, (AtomicInteger) this.f57941e, this.f57942f, keyEntry);
        }
    }

    public /* synthetic */ c(ValidatingResolver validatingResolver, SRRset sRRset, SMessage sMessage, AtomicInteger atomicInteger, Executor executor) {
        this.f57937a = 2;
        this.f57938b = validatingResolver;
        this.f57940d = sRRset;
        this.f57939c = sMessage;
        this.f57941e = atomicInteger;
        this.f57942f = executor;
    }
}
