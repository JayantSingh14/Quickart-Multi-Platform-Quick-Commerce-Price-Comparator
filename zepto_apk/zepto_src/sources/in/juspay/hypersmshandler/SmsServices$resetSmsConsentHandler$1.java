package in.juspay.hypersmshandler;

import kotlin.Metadata;

@Metadata
/* loaded from: classes4.dex */
public final class SmsServices$resetSmsConsentHandler$1 extends SmsConsentHandler {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ SmsServices f48757f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SmsServices$resetSmsConsentHandler$1(SmsServices smsServices, SmsComponents smsComponents) {
        super(smsComponents);
        this.f48757f = smsServices;
    }

    @Override // in.juspay.hypersmshandler.SmsConsentHandler
    public final void a() {
        SmsServices smsServices = this.f48757f;
        SmsConsentHandler smsConsentHandler = smsServices.f48755b;
        if (smsConsentHandler != null) {
            smsConsentHandler.c();
        }
        SmsServices$resetSmsConsentHandler$1 smsServices$resetSmsConsentHandler$1 = new SmsServices$resetSmsConsentHandler$1(smsServices, smsServices.f48754a);
        smsServices.f48755b = smsServices$resetSmsConsentHandler$1;
        smsServices$resetSmsConsentHandler$1.f48738d = null;
    }
}
