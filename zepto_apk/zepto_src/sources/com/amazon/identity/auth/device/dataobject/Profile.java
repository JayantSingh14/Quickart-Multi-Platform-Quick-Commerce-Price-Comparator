package com.amazon.identity.auth.device.dataobject;

import android.content.ContentValues;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.amazon.identity.auth.device.AuthError;
import f.a;
import f.b;
import f.c;
import f.k;
import f.l;
import f.m;
import j$.util.DesugarTimeZone;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class Profile extends AbstractDataObject {

    /* renamed from: e, reason: collision with root package name */
    public static final String[] f15222e = {"Id", "ExpirationTime", "AppId", "Data"};

    /* renamed from: b, reason: collision with root package name */
    public String f15223b;

    /* renamed from: c, reason: collision with root package name */
    public String f15224c;

    /* renamed from: d, reason: collision with root package name */
    public Date f15225d;

    @Override // com.amazon.identity.auth.device.dataobject.AbstractDataObject
    public final c c(Context context) {
        return m.k(context);
    }

    @Override // com.amazon.identity.auth.device.dataobject.AbstractDataObject
    public final ContentValues d(Context context) throws l {
        b bVar;
        ContentValues contentValues = new ContentValues();
        String[] strArr = f15222e;
        contentValues.put(strArr[2], this.f15223b);
        if (this.f15225d != null) {
            String str = strArr[1];
            int i2 = k.f48364b;
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss'Z'", Locale.US);
            simpleDateFormat.setTimeZone(DesugarTimeZone.getTimeZone("UTC"));
            contentValues.put(str, simpleDateFormat.format(this.f15225d));
        } else {
            contentValues.put(strArr[1], (String) null);
        }
        String str2 = strArr[3];
        String strB = this.f15224c;
        int i3 = a.f48351d;
        if (context != null) {
            try {
                synchronized (b.class) {
                    try {
                        if (b.f48353b == null) {
                            b.f48353b = new b(context);
                        }
                        bVar = b.f48353b;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                strB = bVar.b(strB);
            } catch (Exception e2) {
                throw new l(e2);
            }
        }
        contentValues.put(str2, strB);
        return contentValues;
    }

    public final boolean equals(Object obj) {
        if (obj != null && (obj instanceof Profile)) {
            try {
                Profile profile = (Profile) obj;
                if (TextUtils.equals(this.f15223b, profile.f15223b) && AbstractDataObject.b(this.f15225d, profile.f15225d)) {
                    if (g(profile)) {
                        return true;
                    }
                }
            } catch (NullPointerException e2) {
                e2.toString();
            }
        }
        return false;
    }

    public final Bundle f() throws AuthError {
        Bundle bundle = new Bundle();
        if (this.f15224c != null) {
            try {
                JSONObject jSONObject = new JSONObject(this.f15224c);
                try {
                    Iterator<String> itKeys = jSONObject.keys();
                    while (itKeys.hasNext()) {
                        String next = itKeys.next();
                        bundle.putString(next, jSONObject.getString(next));
                    }
                } catch (JSONException e2) {
                    e2.getMessage();
                }
            } catch (JSONException e3) {
                throw new AuthError("JSONException while parsing profile information in database", e3, AuthError.ERROR_TYPE.ERROR_JSON);
            }
        }
        return bundle;
    }

    public final boolean g(Profile profile) {
        try {
            JSONObject jSONObject = new JSONObject(this.f15224c);
            JSONObject jSONObject2 = new JSONObject(profile.f15224c);
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                if (!jSONObject.getString(next).equals(jSONObject2.getString(next))) {
                    return false;
                }
            }
            return true;
        } catch (Exception unused) {
            return TextUtils.equals(this.f15224c, profile.f15224c);
        }
    }

    @Override // com.amazon.identity.auth.device.dataobject.AbstractDataObject
    public final String toString() {
        StringBuilder sb = new StringBuilder("{ rowid=");
        sb.append(this.f15203a);
        sb.append(", appId=");
        sb.append(this.f15223b);
        sb.append(", expirationTime=");
        int i2 = k.f48364b;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss'Z'", Locale.US);
        simpleDateFormat.setTimeZone(DesugarTimeZone.getTimeZone("UTC"));
        sb.append(simpleDateFormat.format(this.f15225d));
        sb.append(", data=");
        return android.support.v4.media.b.r(sb, this.f15224c, " }");
    }
}
