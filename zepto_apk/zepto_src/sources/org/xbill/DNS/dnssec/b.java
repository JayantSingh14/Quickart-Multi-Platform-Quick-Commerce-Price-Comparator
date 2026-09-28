package org.xbill.DNS.dnssec;

import java.io.Serializable;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import org.xbill.DNS.Message;
import org.xbill.DNS.Name;

/* loaded from: classes5.dex */
public final /* synthetic */ class b implements Function {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f57930a = 1;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ValidatingResolver f57931b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ SMessage f57932c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Nsec3ValidationState f57933d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Executor f57934e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ Serializable f57935f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ Object f57936g;

    public /* synthetic */ b(ValidatingResolver validatingResolver, SMessage sMessage, Name name, Nsec3ValidationState nsec3ValidationState, Message message, Executor executor) {
        this.f57931b = validatingResolver;
        this.f57932c = sMessage;
        this.f57935f = name;
        this.f57933d = nsec3ValidationState;
        this.f57936g = message;
        this.f57934e = executor;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        switch (this.f57930a) {
            case 0:
                KeyEntry keyEntry = (KeyEntry) obj;
                return this.f57931b.lambda$validateNodataResponseRecursive$5((SRRset) this.f57935f, this.f57932c, (AtomicInteger) this.f57936g, this.f57933d, this.f57934e, keyEntry);
            default:
                Void r7 = (Void) obj;
                return this.f57931b.lambda$validateNameErrorResponse$7(this.f57932c, (Name) this.f57935f, this.f57933d, (Message) this.f57936g, this.f57934e, r7);
        }
    }

    public /* synthetic */ b(ValidatingResolver validatingResolver, SRRset sRRset, SMessage sMessage, AtomicInteger atomicInteger, Nsec3ValidationState nsec3ValidationState, Executor executor) {
        this.f57931b = validatingResolver;
        this.f57935f = sRRset;
        this.f57932c = sMessage;
        this.f57936g = atomicInteger;
        this.f57933d = nsec3ValidationState;
        this.f57934e = executor;
    }
}
