package com.facebook.react.devsupport;

import com.facebook.react.devsupport.DevSupportManagerBase;

/* loaded from: classes3.dex */
public final /* synthetic */ class h implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f18935a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ DevSupportManagerBase.AnonymousClass8 f18936b;

    public /* synthetic */ h(DevSupportManagerBase.AnonymousClass8 anonymousClass8, int i2) {
        this.f18935a = i2;
        this.f18936b = anonymousClass8;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f18935a) {
            case 0:
                DevSupportManagerBase.this.A();
                break;
            default:
                DevSupportManagerBase.this.w();
                break;
        }
    }
}
