package com.facebook.react.devsupport;

/* loaded from: classes3.dex */
public final /* synthetic */ class a implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f18919a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ DevSupportManagerBase f18920b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ boolean f18921c;

    public /* synthetic */ a(DevSupportManagerBase devSupportManagerBase, boolean z, int i2) {
        this.f18919a = i2;
        this.f18920b = devSupportManagerBase;
        this.f18921c = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f18919a) {
            case 0:
                this.f18920b.q.f18795b.edit().putBoolean("fps_debug", this.f18921c).apply();
                break;
            case 1:
                DevSupportManagerBase devSupportManagerBase = this.f18920b;
                devSupportManagerBase.q.f18795b.edit().putBoolean("hot_module_replacement", this.f18921c).apply();
                devSupportManagerBase.w();
                break;
            default:
                DevSupportManagerBase devSupportManagerBase2 = this.f18920b;
                devSupportManagerBase2.q.c(this.f18921c);
                devSupportManagerBase2.w();
                break;
        }
    }
}
