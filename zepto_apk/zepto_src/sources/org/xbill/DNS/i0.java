package org.xbill.DNS;

import java.util.function.Supplier;
import org.xbill.DNS.Zone;

/* loaded from: classes5.dex */
public final /* synthetic */ class i0 implements Supplier {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f58026a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f58027b;

    public /* synthetic */ i0(Object obj, int i2) {
        this.f58026a = i2;
        this.f58027b = obj;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        switch (this.f58026a) {
            case 0:
                return ((Zone.ZoneIterator) this.f58027b).lambda$new$0();
            default:
                return ((Zone) this.f58027b).lambda$getNS$0();
        }
    }
}
