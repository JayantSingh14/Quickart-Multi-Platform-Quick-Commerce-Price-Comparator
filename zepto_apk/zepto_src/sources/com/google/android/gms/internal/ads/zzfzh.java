package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import java.io.IOException;

/* loaded from: classes4.dex */
final class zzfzh {

    /* renamed from: c, reason: collision with root package name */
    public static zzfzh f32091c;

    /* renamed from: a, reason: collision with root package name */
    public final String f32092a;

    /* renamed from: b, reason: collision with root package name */
    public final SharedPreferences f32093b;

    public zzfzh(Context context) {
        this.f32092a = context.getPackageName();
        this.f32093b = context.getSharedPreferences("paid_storage_sp", 0);
    }

    public final void a(Object obj, String str) throws IOException {
        boolean zCommit;
        boolean z = obj instanceof String;
        String str2 = this.f32092a;
        SharedPreferences sharedPreferences = this.f32093b;
        if (z) {
            zCommit = sharedPreferences.edit().putString(str, (String) obj).commit();
        } else if (obj instanceof Long) {
            zCommit = sharedPreferences.edit().putLong(str, ((Long) obj).longValue()).commit();
        } else if (obj instanceof Boolean) {
            zCommit = sharedPreferences.edit().putBoolean(str, ((Boolean) obj).booleanValue()).commit();
        } else {
            if (!(obj instanceof Integer)) {
                String strValueOf = String.valueOf(obj.getClass());
                Log.e("GpidLifecycleSPHandler", android.support.v4.media.a.n(new StringBuilder(strValueOf.length() + 33 + String.valueOf(str2).length()), "Unexpected object class ", strValueOf, " for app ", str2));
                throw new IOException(android.support.v4.media.a.n(new StringBuilder(str.length() + 25 + String.valueOf(str2).length()), "Failed to store ", str, " for app ", str2));
            }
            zCommit = sharedPreferences.edit().putInt(str, ((Integer) obj).intValue()).commit();
        }
        if (zCommit) {
            return;
        }
        throw new IOException(android.support.v4.media.a.n(new StringBuilder(str.length() + 25 + String.valueOf(str2).length()), "Failed to store ", str, " for app ", str2));
    }

    public final void b(String str) throws IOException {
        if (this.f32093b.edit().remove(str).commit()) {
            return;
        }
        int length = str.length();
        String str2 = this.f32092a;
        throw new IOException(android.support.v4.media.a.n(new StringBuilder(length + 26 + String.valueOf(str2).length()), "Failed to remove ", str, " for app ", str2));
    }
}
