package com.google.android.ump;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes4.dex */
public class FormError {

    /* renamed from: a, reason: collision with root package name */
    public final String f42225a;

    @Retention(RetentionPolicy.SOURCE)
    public @interface ErrorCode {
    }

    public FormError(String str) {
        this.f42225a = str;
    }
}
