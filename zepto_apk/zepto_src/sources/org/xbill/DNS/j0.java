package org.xbill.DNS;

import java.util.Map;
import java.util.function.Supplier;
import org.xbill.DNS.Zone;

/* loaded from: classes5.dex */
public final /* synthetic */ class j0 implements Supplier {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f58028a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f58029b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f58030c;

    public /* synthetic */ j0(int i2, Object obj, Object obj2) {
        this.f58028a = i2;
        this.f58029b = obj;
        this.f58030c = obj2;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        switch (this.f58028a) {
            case 0:
                return ((Zone.ZoneIterator) this.f58029b).lambda$next$1((Map.Entry) this.f58030c);
            default:
                return ((Zone) this.f58029b).lambda$toMasterFile$9((StringBuilder) this.f58030c);
        }
    }
}
