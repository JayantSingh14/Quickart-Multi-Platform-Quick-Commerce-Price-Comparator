package com.google.android.gms.fido.u2f.api.messagebased;

@Deprecated
/* loaded from: classes4.dex */
public enum ResponseType {
    /* JADX INFO: Fake field, exist only in values array */
    REGISTER("u2f_register_response"),
    /* JADX INFO: Fake field, exist only in values array */
    SIGN("u2f_sign_response");


    /* renamed from: a, reason: collision with root package name */
    public final String f22528a;

    ResponseType(String str) {
        this.f22528a = str;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return this.f22528a;
    }
}
