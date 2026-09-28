package org.slf4j.event;

import com.amazon.android.apay.commonlibrary.interfaces.external.MerchantConstants;

/* loaded from: classes5.dex */
public enum Level {
    /* JADX INFO: Fake field, exist only in values array */
    ERROR(MerchantConstants.ERROR),
    /* JADX INFO: Fake field, exist only in values array */
    WARN("WARN"),
    /* JADX INFO: Fake field, exist only in values array */
    INFO("INFO"),
    /* JADX INFO: Fake field, exist only in values array */
    DEBUG("DEBUG"),
    /* JADX INFO: Fake field, exist only in values array */
    TRACE("TRACE");


    /* renamed from: a, reason: collision with root package name */
    public final String f57882a;

    Level(String str) {
        this.f57882a = str;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return this.f57882a;
    }
}
