package com.google.android.play.core.appupdate;

import android.app.Activity;
import android.content.IntentSender;
import com.google.android.play.core.common.IntentSenderForResultStarter;

/* loaded from: classes4.dex */
final class zzf implements IntentSenderForResultStarter {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Activity f41715a;

    public zzf(Activity activity) {
        this.f41715a = activity;
    }

    public final void a(IntentSender intentSender, int i2) throws IntentSender.SendIntentException {
        this.f41715a.startIntentSenderForResult(intentSender, i2, null, 0, 0, 0, null);
    }
}
