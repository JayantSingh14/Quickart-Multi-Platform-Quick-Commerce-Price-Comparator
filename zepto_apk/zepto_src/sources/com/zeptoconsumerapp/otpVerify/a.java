package com.zeptoconsumerapp.otpVerify;

import com.zeptoconsumerapp.otpVerify.constants.OtpListenerType;
import kotlin.jvm.functions.Function1;

/* loaded from: classes4.dex */
public final /* synthetic */ class a implements Function1 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f47707a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ OtpVerifyModule f47708b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ OtpListenerType f47709c;

    public /* synthetic */ a(OtpVerifyModule otpVerifyModule, OtpListenerType otpListenerType, int i2) {
        this.f47707a = i2;
        this.f47708b = otpVerifyModule;
        this.f47709c = otpListenerType;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        String str = (String) obj;
        switch (this.f47707a) {
            case 0:
                return OtpVerifyModule.createOtpListener$lambda$0(this.f47708b, this.f47709c, str);
            default:
                return OtpVerifyModule.createOtpListener$lambda$1(this.f47708b, this.f47709c, str);
        }
    }
}
