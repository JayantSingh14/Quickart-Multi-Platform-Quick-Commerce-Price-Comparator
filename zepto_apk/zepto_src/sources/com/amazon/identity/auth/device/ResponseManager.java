package com.amazon.identity.auth.device;

import android.net.Uri;
import java.util.LinkedHashMap;

/* loaded from: classes3.dex */
public final class ResponseManager {

    /* renamed from: b, reason: collision with root package name */
    public static ResponseManager f15085b;

    /* renamed from: a, reason: collision with root package name */
    public final LinkedHashMap f15086a = new LinkedHashMap();

    public static synchronized ResponseManager a() {
        try {
            if (f15085b == null) {
                f15085b = new ResponseManager();
            }
        } catch (Throwable th) {
            throw th;
        }
        return f15085b;
    }

    public final synchronized void b(Uri uri, String str) {
        while (this.f15086a.size() >= 10) {
            try {
                this.f15086a.remove((String) this.f15086a.keySet().iterator().next());
            } catch (Throwable th) {
                throw th;
            }
        }
        this.f15086a.put(str, uri);
    }
}
