package com.rnfs;

/* loaded from: classes4.dex */
class IORejectionException extends Exception {

    /* renamed from: a, reason: collision with root package name */
    public final String f46426a;

    public IORejectionException(String str, String str2) {
        super(str2);
        this.f46426a = str;
    }

    public final String a() {
        return this.f46426a;
    }
}
