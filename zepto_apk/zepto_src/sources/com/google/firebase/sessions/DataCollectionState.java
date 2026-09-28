package com.google.firebase.sessions;

import com.google.firebase.encoders.json.NumberedEnum;
import kotlin.Metadata;

@Metadata
/* loaded from: classes4.dex */
public enum DataCollectionState implements NumberedEnum {
    /* JADX INFO: Fake field, exist only in values array */
    COLLECTION_UNKNOWN(0),
    COLLECTION_SDK_NOT_INSTALLED(1),
    COLLECTION_ENABLED(2),
    COLLECTION_DISABLED(3),
    /* JADX INFO: Fake field, exist only in values array */
    COLLECTION_DISABLED_REMOTE(4),
    /* JADX INFO: Fake field, exist only in values array */
    COLLECTION_SAMPLED(5);


    /* renamed from: a, reason: collision with root package name */
    public final int f44983a;

    DataCollectionState(int i2) {
        this.f44983a = i2;
    }

    @Override // com.google.firebase.encoders.json.NumberedEnum
    public final int f() {
        return this.f44983a;
    }
}
