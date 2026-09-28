package org.xbill.DNS.dnssec;

import java.util.function.Function;
import org.xbill.DNS.Message;

/* loaded from: classes5.dex */
public final /* synthetic */ class f implements Function {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f57952a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f57953b;

    public /* synthetic */ f(Object obj, int i2) {
        this.f57952a = i2;
        this.f57953b = obj;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        switch (this.f57952a) {
            case 0:
                return ValidatingResolver.lambda$prepareFindKey$11((FindKeyState) this.f57953b, (Void) obj);
            case 1:
                return ((ValidatingResolver) this.f57953b).lambda$sendAsync$17((SMessage) obj);
            default:
                return ValidatingResolver.lambda$sendRequest$10((Message) this.f57953b, (Message) obj);
        }
    }
}
