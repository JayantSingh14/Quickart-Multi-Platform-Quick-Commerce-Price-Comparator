package com.google.firebase.crashlytics.internal.common;

import com.google.firebase.crashlytics.internal.settings.SettingsController;
import java.io.IOException;

/* loaded from: classes.dex */
public final /* synthetic */ class c implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f43844a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f43845b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f43846c;

    public /* synthetic */ c(int i2, Object obj, Object obj2) {
        this.f43844a = i2;
        this.f43845b = obj;
        this.f43846c = obj2;
    }

    @Override // java.lang.Runnable
    public final void run() throws IOException {
        Object obj = this.f43846c;
        Object obj2 = this.f43845b;
        switch (this.f43844a) {
            case 0:
                b bVar = CrashlyticsController.s;
                ((CrashlyticsController) obj2).c((String) obj, Boolean.FALSE);
                break;
            default:
                ((CrashlyticsCore) obj2).c((SettingsController) obj);
                break;
        }
    }
}
