package com.facebook.react.devsupport;

/* loaded from: classes3.dex */
public final /* synthetic */ class b implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f18922a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ DevSupportManagerBase f18923b;

    public /* synthetic */ b(DevSupportManagerBase devSupportManagerBase, int i2) {
        this.f18922a = i2;
        this.f18923b = devSupportManagerBase;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f18922a) {
            case 0:
                DevSupportManagerBase devSupportManagerBase = this.f18923b;
                devSupportManagerBase.q.f18795b.edit().putBoolean("inspector_debug", !r1.f18795b.getBoolean("inspector_debug", false)).apply();
                devSupportManagerBase.f18823f.b();
                break;
            default:
                this.f18923b.H();
                break;
        }
    }
}
