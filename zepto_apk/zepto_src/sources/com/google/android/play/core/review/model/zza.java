package com.google.android.play.core.review.model;

import androidx.fragment.app.e;
import java.util.HashMap;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

/* loaded from: classes4.dex */
public final class zza {

    /* renamed from: a, reason: collision with root package name */
    public static final HashMap f41883a;

    /* renamed from: b, reason: collision with root package name */
    public static final HashMap f41884b;

    static {
        HashMap map = new HashMap();
        f41883a = map;
        HashMap map2 = new HashMap();
        f41884b = map2;
        Integer numJ = e.j(-2, -1, "The Play Store app is either not installed or not the official version.", "Call first requestReviewFlow to get the ReviewInfo.", map);
        map.put(-100, "Retry with an exponential backoff. Consider filing a bug if fails consistently.");
        map2.put(-1, "PLAY_STORE_NOT_FOUND");
        map2.put(numJ, CLConstants.ERROR_INVALID_REQUEST);
        map2.put(-100, "INTERNAL_ERROR");
    }
}
