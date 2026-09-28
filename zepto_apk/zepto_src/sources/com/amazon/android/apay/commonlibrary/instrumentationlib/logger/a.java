package com.amazon.android.apay.commonlibrary.instrumentationlib.logger;

import in.juspay.hypersdk.core.SdkTracker;
import org.json.JSONException;

/* loaded from: classes3.dex */
public final /* synthetic */ class a implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f14908a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f14909b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f14910c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f14911d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ String f14912e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ Object f14913f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ Object f14914g;

    public /* synthetic */ a(SdkTracker sdkTracker, String str, String str2, String str3, String str4, Throwable th) {
        this.f14908a = 1;
        this.f14913f = sdkTracker;
        this.f14909b = str;
        this.f14910c = str2;
        this.f14911d = str3;
        this.f14912e = str4;
        this.f14914g = th;
    }

    @Override // java.lang.Runnable
    public final void run() throws JSONException {
        switch (this.f14908a) {
            case 0:
                KuberMetricEventsLogger.a(this.f14909b, this.f14910c, (KuberMetricEventsLogger) this.f14914g, this.f14911d, this.f14912e, (String) this.f14913f);
                break;
            case 1:
                ((SdkTracker) this.f14913f).lambda$trackException$13(this.f14909b, this.f14910c, this.f14911d, this.f14912e, (Throwable) this.f14914g);
                break;
            default:
                SdkTracker.lambda$trackAndLogBootException$5(this.f14909b, this.f14910c, (Throwable) this.f14914g, this.f14911d, this.f14912e, (String) this.f14913f);
                break;
        }
    }

    public /* synthetic */ a(String str, String str2, String str3, String str4, String str5, int i2, Object obj) {
        this.f14908a = i2;
        this.f14909b = str;
        this.f14910c = str2;
        this.f14914g = obj;
        this.f14911d = str3;
        this.f14912e = str4;
        this.f14913f = str5;
    }
}
