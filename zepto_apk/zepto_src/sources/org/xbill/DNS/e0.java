package org.xbill.DNS;

import java.util.function.Consumer;

/* loaded from: classes5.dex */
public final /* synthetic */ class e0 implements Consumer {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f57998a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Update f57999b;

    public /* synthetic */ e0(Update update, int i2) {
        this.f57998a = i2;
        this.f57999b = update;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        switch (this.f57998a) {
            case 0:
                this.f57999b.add((Record) obj);
                break;
            default:
                this.f57999b.delete((Record) obj);
                break;
        }
    }
}
