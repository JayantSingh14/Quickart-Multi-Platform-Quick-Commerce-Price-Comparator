package com.google.thirdparty.publicsuffix;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;

@Beta
@GwtCompatible
/* loaded from: classes4.dex */
public enum PublicSuffixType {
    /* JADX INFO: Fake field, exist only in values array */
    PRIVATE(':', ','),
    /* JADX INFO: Fake field, exist only in values array */
    REGISTRY('!', '?');


    /* renamed from: a, reason: collision with root package name */
    public final char f45630a;

    /* renamed from: b, reason: collision with root package name */
    public final char f45631b;

    PublicSuffixType(char c2, char c3) {
        this.f45630a = c2;
        this.f45631b = c3;
    }
}
