package in.juspay.hypersmshandler;

import android.app.Activity;
import android.content.BroadcastReceiver;
import in.juspay.hypersmshandler.SmsRetriever;

/* loaded from: classes4.dex */
public final /* synthetic */ class c implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f48762a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f48763b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ BroadcastReceiver f48764c;

    public /* synthetic */ c(Object obj, BroadcastReceiver broadcastReceiver, int i2) {
        this.f48762a = i2;
        this.f48763b = obj;
        this.f48764c = broadcastReceiver;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f48762a) {
            case 0:
                SmsRetriever.AnonymousClass1.a((Activity) this.f48763b, (SmsRetriever) this.f48764c);
                break;
            default:
                SmsReceiver.a((SmsReceiver) this.f48763b, (SmsConsentHandler) this.f48764c);
                break;
        }
    }
}
