package com.google.firebase.crashlytics.internal.common;

import com.google.firebase.crashlytics.internal.settings.SettingsController;
import java.io.IOException;

/* loaded from: classes4.dex */
public final /* synthetic */ class d implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f43847a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ CrashlyticsCore f43848b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f43849c;

    public /* synthetic */ d(CrashlyticsCore crashlyticsCore, Object obj, int i2) {
        this.f43847a = i2;
        this.f43848b = crashlyticsCore;
        this.f43849c = obj;
    }

    @Override // java.lang.Runnable
    public final void run() throws IOException {
        switch (this.f43847a) {
            case 0:
                this.f43848b.f43784h.f43755d.h((String) this.f43849c);
                break;
            default:
                this.f43848b.c((SettingsController) this.f43849c);
                break;
        }
    }
}
