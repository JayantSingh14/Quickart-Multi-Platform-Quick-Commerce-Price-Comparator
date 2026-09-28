package com.reactcommunity.rndatetimepicker;

import android.os.Bundle;
import java.util.Calendar;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

/* loaded from: classes4.dex */
public class RNDate {

    /* renamed from: a, reason: collision with root package name */
    public final Calendar f46150a;

    public RNDate(Bundle bundle) {
        Calendar calendar = Calendar.getInstance();
        this.f46150a = calendar;
        if (bundle != null && bundle.containsKey(CLConstants.FIELD_PAY_INFO_VALUE)) {
            calendar.setTimeInMillis(bundle.getLong(CLConstants.FIELD_PAY_INFO_VALUE));
        }
        calendar.setTimeZone(Common.c(bundle));
    }
}
