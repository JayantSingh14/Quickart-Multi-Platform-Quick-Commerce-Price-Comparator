package com.google.firebase.sessions;

import android.support.v4.media.b;
import android.util.Base64;
import kotlin.Metadata;
import kotlin.text.StringsKt;

@Metadata
/* loaded from: classes4.dex */
public final class SessionDataStoreConfigs {

    /* renamed from: a, reason: collision with root package name */
    public static final String f45027a;

    /* renamed from: b, reason: collision with root package name */
    public static final String f45028b;

    static {
        String strEncodeToString = Base64.encodeToString(StringsKt.q(ProcessDetailsProvider.b()), 10);
        f45027a = b.D("firebase_session_", strEncodeToString, "_data");
        f45028b = b.D("firebase_session_", strEncodeToString, "_settings");
    }
}
