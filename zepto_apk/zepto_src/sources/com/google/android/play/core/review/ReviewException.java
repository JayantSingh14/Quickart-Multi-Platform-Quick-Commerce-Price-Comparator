package com.google.android.play.core.review;

import androidx.fragment.app.e;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import java.util.HashMap;
import java.util.Locale;

/* loaded from: classes4.dex */
public class ReviewException extends ApiException {
    /* JADX WARN: Illegal instructions before constructor call */
    public ReviewException(int i2) {
        Locale locale = Locale.getDefault();
        Integer numValueOf = Integer.valueOf(i2);
        HashMap map = com.google.android.play.core.review.model.zza.f41883a;
        Integer numValueOf2 = Integer.valueOf(i2);
        super(new Status(i2, String.format(locale, "Review Error(%d): %s", numValueOf, !map.containsKey(numValueOf2) ? "" : e.D((String) map.get(numValueOf2), " (https://developer.android.com/reference/com/google/android/play/core/review/model/ReviewErrorCode.html#", (String) com.google.android.play.core.review.model.zza.f41884b.get(numValueOf2), ")"))));
    }
}
