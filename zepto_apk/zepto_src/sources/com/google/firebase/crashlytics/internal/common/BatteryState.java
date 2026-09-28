package com.google.firebase.crashlytics.internal.common;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.google.firebase.crashlytics.internal.Logger;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

/* loaded from: classes4.dex */
class BatteryState {

    /* renamed from: a, reason: collision with root package name */
    public final Float f43730a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f43731b;

    public BatteryState(Float f2, boolean z) {
        this.f43731b = z;
        this.f43730a = f2;
    }

    public static BatteryState a(Context context) {
        boolean z = false;
        Float fValueOf = null;
        try {
            Intent intentRegisterReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            if (intentRegisterReceiver != null) {
                int intExtra = intentRegisterReceiver.getIntExtra(CLConstants.OTP_STATUS, -1);
                if (intExtra != -1 && (intExtra == 2 || intExtra == 5)) {
                    z = true;
                }
                int intExtra2 = intentRegisterReceiver.getIntExtra("level", -1);
                int intExtra3 = intentRegisterReceiver.getIntExtra("scale", -1);
                if (intExtra2 != -1 && intExtra3 != -1) {
                    fValueOf = Float.valueOf(intExtra2 / intExtra3);
                }
            }
        } catch (IllegalStateException e2) {
            Logger.f43705a.c("An error occurred getting battery state.", e2);
        }
        return new BatteryState(fValueOf, z);
    }

    public final Float b() {
        return this.f43730a;
    }

    public final int c() {
        Float f2;
        if (!this.f43731b || (f2 = this.f43730a) == null) {
            return 1;
        }
        return ((double) f2.floatValue()) < 0.99d ? 2 : 3;
    }
}
