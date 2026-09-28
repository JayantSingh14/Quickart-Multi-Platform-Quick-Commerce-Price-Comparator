package com.google.android.gms.auth.api.phone;

import com.google.android.gms.common.api.CommonStatusCodes;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes4.dex */
public final class IncomingCallRetrieverStatusCodes extends CommonStatusCodes {

    /* renamed from: a, reason: collision with root package name */
    public static final IncomingCallRetrieverStatusCodes f22137a = new IncomingCallRetrieverStatusCodes();

    public static String a() {
        String statusCodeString = CommonStatusCodes.getStatusCodeString(0);
        Intrinsics.checkNotNullExpressionValue(statusCodeString, "getStatusCodeString(...)");
        return statusCodeString;
    }
}
