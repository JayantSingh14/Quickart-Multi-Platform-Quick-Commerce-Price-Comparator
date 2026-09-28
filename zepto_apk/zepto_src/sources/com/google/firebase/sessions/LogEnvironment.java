package com.google.firebase.sessions;

import com.google.firebase.encoders.json.NumberedEnum;
import kotlin.Metadata;

@Metadata
/* loaded from: classes.dex */
public enum LogEnvironment implements NumberedEnum {
    /* JADX INFO: Fake field, exist only in values array */
    LOG_ENVIRONMENT_UNKNOWN(0),
    /* JADX INFO: Fake field, exist only in values array */
    LOG_ENVIRONMENT_AUTOPUSH(1),
    /* JADX INFO: Fake field, exist only in values array */
    LOG_ENVIRONMENT_STAGING(2),
    LOG_ENVIRONMENT_PROD(3);


    /* renamed from: a, reason: collision with root package name */
    public final int f45022a;

    LogEnvironment(int i2) {
        this.f45022a = i2;
    }

    @Override // com.google.firebase.encoders.json.NumberedEnum
    public final int f() {
        return this.f45022a;
    }
}
