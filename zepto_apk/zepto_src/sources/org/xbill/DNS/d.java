package org.xbill.DNS;

import java.util.concurrent.Executor;
import java.util.function.BiFunction;
import org.xbill.DNS.AsyncSemaphore;

/* loaded from: classes5.dex */
public final /* synthetic */ class d implements BiFunction {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f57922a = 1;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ DohResolver f57923b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Message f57924c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ long f57925d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Object f57926e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ Object f57927f;

    public /* synthetic */ d(DohResolver dohResolver, Message message, String str, byte[] bArr, long j2) {
        this.f57923b = dohResolver;
        this.f57924c = message;
        this.f57926e = str;
        this.f57927f = bArr;
        this.f57925d = j2;
    }

    @Override // java.util.function.BiFunction
    public final Object apply(Object obj, Object obj2) {
        switch (this.f57922a) {
            case 0:
                DohResolver dohResolver = this.f57923b;
                long j2 = this.f57925d;
                Object obj3 = this.f57927f;
                return dohResolver.lambda$sendAsync11$2(this.f57924c, (Executor) this.f57926e, j2, obj3, (AsyncSemaphore.Permit) obj, (Throwable) obj2);
            default:
                DohResolver dohResolver2 = this.f57923b;
                byte[] bArr = (byte[]) this.f57927f;
                long j3 = this.f57925d;
                return dohResolver2.lambda$sendAsync8$1(this.f57924c, (String) this.f57926e, bArr, j3, (AsyncSemaphore.Permit) obj, (Throwable) obj2);
        }
    }

    public /* synthetic */ d(DohResolver dohResolver, Message message, Executor executor, long j2, Object obj) {
        this.f57923b = dohResolver;
        this.f57924c = message;
        this.f57926e = executor;
        this.f57925d = j2;
        this.f57927f = obj;
    }
}
