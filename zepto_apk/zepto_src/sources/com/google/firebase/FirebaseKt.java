package com.google.firebase;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes4.dex */
public final class FirebaseKt {
    public static final FirebaseApp a() {
        Intrinsics.checkNotNullParameter(Firebase.f43486a, "<this>");
        FirebaseApp firebaseAppD = FirebaseApp.d();
        Intrinsics.checkNotNullExpressionValue(firebaseAppD, "getInstance()");
        return firebaseAppD;
    }
}
