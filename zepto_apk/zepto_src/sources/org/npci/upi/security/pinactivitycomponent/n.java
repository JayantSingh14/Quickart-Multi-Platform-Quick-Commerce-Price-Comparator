package org.npci.upi.security.pinactivitycomponent;

import android.content.Context;
import android.content.SharedPreferences;

/* loaded from: classes5.dex */
public class n {

    /* renamed from: a, reason: collision with root package name */
    private final SharedPreferences f57553a;

    public n(Context context) {
        this.f57553a = context.getSharedPreferences(CLConstants.MESSAGE_SHARED_PREFERENCE_NAME, 0);
    }

    public void a(String str, String str2) {
        SharedPreferences.Editor editorEdit = this.f57553a.edit();
        editorEdit.putString(str, str2);
        editorEdit.commit();
    }

    public String b(String str, String str2) {
        return this.f57553a.getString(str, str2);
    }
}
