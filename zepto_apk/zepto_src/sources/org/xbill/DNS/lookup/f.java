package org.xbill.DNS.lookup;

import java.util.function.Consumer;
import org.xbill.DNS.Cache;
import org.xbill.DNS.Message;
import org.xbill.DNS.lookup.LookupSession;

/* loaded from: classes5.dex */
public final /* synthetic */ class f implements Consumer {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f58044a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f58045b;

    public /* synthetic */ f(Object obj, int i2) {
        this.f58044a = i2;
        this.f58045b = obj;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        switch (this.f58044a) {
            case 0:
                ((Cache) obj).addMessage((Message) this.f58045b);
                break;
            default:
                ((LookupSession.LookupSessionBuilder) this.f58045b).cache((Cache) obj);
                break;
        }
    }
}
