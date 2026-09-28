package com.google.firebase.sessions;

import com.google.firebase.encoders.json.NumberedEnum;
import kotlin.Metadata;

@Metadata
/* loaded from: classes4.dex */
public enum EventType implements NumberedEnum {
    /* JADX INFO: Fake field, exist only in values array */
    EVENT_TYPE_UNKNOWN(0),
    SESSION_START(1);


    /* renamed from: a, reason: collision with root package name */
    public final int f44991a;

    EventType(int i2) {
        this.f44991a = i2;
    }

    @Override // com.google.firebase.encoders.json.NumberedEnum
    public final int f() {
        return this.f44991a;
    }
}
