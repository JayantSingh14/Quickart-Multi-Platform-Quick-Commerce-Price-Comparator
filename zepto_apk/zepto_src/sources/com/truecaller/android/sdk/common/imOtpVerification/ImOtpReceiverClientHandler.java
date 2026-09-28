package com.truecaller.android.sdk.common.imOtpVerification;

import android.content.Context;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes4.dex */
public final class ImOtpReceiverClientHandler {

    /* renamed from: a, reason: collision with root package name */
    public final WeakReference f47233a;

    /* renamed from: b, reason: collision with root package name */
    public TruecallerImOtpReceiver f47234b;

    /* renamed from: c, reason: collision with root package name */
    public ImOtpReceiverClientHandler$startCountDownTimer$1 f47235c;

    public ImOtpReceiverClientHandler(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.f47233a = new WeakReference(context);
    }

    public final void a() {
        TruecallerImOtpReceiver truecallerImOtpReceiver = this.f47234b;
        if (truecallerImOtpReceiver != null) {
            try {
                Context context = (Context) this.f47233a.get();
                if (context != null) {
                    context.unregisterReceiver(truecallerImOtpReceiver);
                    Unit unit = Unit.f53572a;
                }
            } catch (Exception unused) {
                Unit unit2 = Unit.f53572a;
            }
        }
        this.f47234b = null;
    }
}
