package com.google.firebase.crashlytics.internal.metadata;

import com.google.firebase.crashlytics.internal.Logger;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
class KeysMap {

    /* renamed from: a, reason: collision with root package name */
    public final HashMap f43897a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    public final int f43898b = 64;

    /* renamed from: c, reason: collision with root package name */
    public final int f43899c;

    public KeysMap(int i2) {
        this.f43899c = i2;
    }

    public static String a(int i2, String str) {
        if (str != null) {
            str = str.trim();
            if (str.length() > i2) {
                return str.substring(0, i2);
            }
        }
        return str;
    }

    public final synchronized boolean b(String str, String str2) {
        if (str == null) {
            throw new IllegalArgumentException("Custom attribute key must not be null.");
        }
        String strA = a(this.f43899c, str);
        if (this.f43897a.size() >= this.f43898b && !this.f43897a.containsKey(strA)) {
            Logger.f43705a.f("Ignored entry \"" + str + "\" when adding custom keys. Maximum allowable: " + this.f43898b, null);
            return false;
        }
        String strA2 = a(this.f43899c, str2);
        String str3 = (String) this.f43897a.get(strA);
        if (str3 == null ? strA2 == null : str3.equals(strA2)) {
            return false;
        }
        HashMap map = this.f43897a;
        if (str2 == null) {
            strA2 = "";
        }
        map.put(strA, strA2);
        return true;
    }

    public final synchronized void c(Map map) {
        try {
            int i2 = 0;
            for (Map.Entry entry : map.entrySet()) {
                String str = (String) entry.getKey();
                if (str == null) {
                    throw new IllegalArgumentException("Custom attribute key must not be null.");
                }
                String strA = a(this.f43899c, str);
                if (this.f43897a.size() < this.f43898b || this.f43897a.containsKey(strA)) {
                    String str2 = (String) entry.getValue();
                    this.f43897a.put(strA, str2 == null ? "" : a(this.f43899c, str2));
                } else {
                    i2++;
                }
            }
            if (i2 > 0) {
                Logger.f43705a.f("Ignored " + i2 + " entries when adding custom keys. Maximum allowable: " + this.f43898b, null);
            }
        } catch (Throwable th) {
            throw th;
        }
    }
}
