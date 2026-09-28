package com.unistyles;

import android.view.Window;
import androidx.core.view.WindowInsetsControllerCompat;
import in.juspay.hypersdk.analytics.LogSessioniserExp;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes4.dex */
public final /* synthetic */ class a implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f47290a = 1;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f47291b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f47292c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f47293d;

    public /* synthetic */ a(LogSessioniserExp logSessioniserExp, ConcurrentHashMap concurrentHashMap, boolean z) {
        this.f47292c = logSessioniserExp;
        this.f47293d = concurrentHashMap;
        this.f47291b = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f47290a) {
            case 0:
                Platform.onSetStatusBarHidden$lambda$11$lambda$10$lambda$9$lambda$8(this.f47291b, (Window) this.f47292c, (WindowInsetsControllerCompat) this.f47293d);
                break;
            default:
                ((LogSessioniserExp) this.f47292c).lambda$pushToPusher$3((ConcurrentHashMap) this.f47293d, this.f47291b);
                break;
        }
    }

    public /* synthetic */ a(boolean z, Window window, WindowInsetsControllerCompat windowInsetsControllerCompat) {
        this.f47291b = z;
        this.f47292c = window;
        this.f47293d = windowInsetsControllerCompat;
    }
}
