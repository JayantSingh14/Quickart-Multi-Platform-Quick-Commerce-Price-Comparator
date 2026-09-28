package org.xbill.DNS;

import java.util.function.Supplier;

/* loaded from: classes5.dex */
public final /* synthetic */ class f0 implements Supplier {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f58003a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Zone f58004b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Name f58005c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f58006d;

    public /* synthetic */ f0(Zone zone, Name name, int i2, int i3) {
        this.f58003a = i3;
        this.f58004b = zone;
        this.f58005c = name;
        this.f58006d = i2;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        switch (this.f58003a) {
            case 0:
                return this.f58004b.lambda$findExactMatch$5(this.f58005c, this.f58006d);
            default:
                return this.f58004b.lambda$findRecords$6(this.f58005c, this.f58006d);
        }
    }
}
