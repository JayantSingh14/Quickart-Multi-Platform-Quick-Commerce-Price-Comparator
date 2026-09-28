package com.amazon.identity.auth.device.dataobject;

import android.content.ContentValues;
import android.content.Context;
import android.text.TextUtils;
import f.a;
import f.b;
import f.c;
import f.e;
import f.k;
import f.l;
import j$.util.DesugarTimeZone;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* loaded from: classes3.dex */
public abstract class AuthorizationToken extends AbstractDataObject {

    /* renamed from: i, reason: collision with root package name */
    public static final String[] f15214i = {"Id", "AppId", "Token", "CreationTime", "ExpirationTime", "MiscData", "type", "directedId"};

    /* renamed from: b, reason: collision with root package name */
    public String f15215b;

    /* renamed from: c, reason: collision with root package name */
    public String f15216c;

    /* renamed from: d, reason: collision with root package name */
    public Date f15217d;

    /* renamed from: e, reason: collision with root package name */
    public Date f15218e;

    /* renamed from: f, reason: collision with root package name */
    public byte[] f15219f;

    /* renamed from: g, reason: collision with root package name */
    public int f15220g;

    /* renamed from: h, reason: collision with root package name */
    public String f15221h;

    public AuthorizationToken(String str, String str2, Date date, Date date2, int i2) {
        this.f15215b = str;
        this.f15216c = str2;
        this.f15217d = k.b(date);
        this.f15218e = k.b(date2);
        this.f15219f = null;
        this.f15220g = i2;
        this.f15221h = null;
    }

    @Override // com.amazon.identity.auth.device.dataobject.AbstractDataObject
    public final c c(Context context) {
        return e.k(context);
    }

    @Override // com.amazon.identity.auth.device.dataobject.AbstractDataObject
    public final ContentValues d(Context context) throws l {
        b bVar;
        ContentValues contentValues = new ContentValues();
        int i2 = k.f48364b;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss'Z'", Locale.US);
        simpleDateFormat.setTimeZone(DesugarTimeZone.getTimeZone("UTC"));
        String[] strArr = f15214i;
        contentValues.put(strArr[1], this.f15215b);
        String str = strArr[2];
        String strB = this.f15216c;
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
        contentValues.put(str, strB);
        contentValues.put(strArr[3], simpleDateFormat.format(this.f15217d));
        contentValues.put(strArr[4], simpleDateFormat.format(this.f15218e));
        contentValues.put(strArr[5], this.f15219f);
        String str2 = strArr[6];
        int i4 = this.f15220g;
        if (i4 == 0) {
            throw null;
        }
        contentValues.put(str2, Integer.valueOf(i4 - 1));
        contentValues.put(strArr[7], this.f15221h);
        return contentValues;
    }

    public final boolean equals(Object obj) {
        if (obj != null && (obj instanceof AuthorizationToken)) {
            try {
                AuthorizationToken authorizationToken = (AuthorizationToken) obj;
                if (TextUtils.equals(this.f15215b, authorizationToken.f15215b) && TextUtils.equals(this.f15216c, authorizationToken.f15216c) && AbstractDataObject.b(this.f15217d, authorizationToken.f15217d) && AbstractDataObject.b(this.f15218e, authorizationToken.f15218e) && TextUtils.equals(e.a.a(this.f15220g), e.a.a(authorizationToken.f15220g))) {
                    if (TextUtils.equals(this.f15221h, authorizationToken.f15221h)) {
                        return true;
                    }
                }
            } catch (NullPointerException e2) {
                e2.toString();
            }
        }
        return false;
    }

    @Override // com.amazon.identity.auth.device.dataobject.AbstractDataObject
    public final String toString() {
        return this.f15216c;
    }

    public AuthorizationToken() {
    }
}
