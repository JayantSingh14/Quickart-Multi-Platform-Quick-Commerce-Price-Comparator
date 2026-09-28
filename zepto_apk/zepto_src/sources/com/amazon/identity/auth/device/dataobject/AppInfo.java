package com.amazon.identity.auth.device.dataobject;

import android.content.ContentValues;
import android.content.Context;
import android.text.TextUtils;
import f.c;
import f.d;
import java.util.Arrays;
import java.util.Iterator;
import k.b;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class AppInfo extends AbstractDataObject {

    /* renamed from: k, reason: collision with root package name */
    public static final String[] f15204k = {"rowid", "AppFamilyId", "PackageName", "AllowedScopes", "GrantedPermissions", "ClientId", "AppVariantId", "AuthzHost", "ExchangeHost", "Payload"};

    /* renamed from: b, reason: collision with root package name */
    public String f15205b;

    /* renamed from: c, reason: collision with root package name */
    public String f15206c;

    /* renamed from: d, reason: collision with root package name */
    public String f15207d;

    /* renamed from: e, reason: collision with root package name */
    public String f15208e;

    /* renamed from: f, reason: collision with root package name */
    public String f15209f;

    /* renamed from: g, reason: collision with root package name */
    public String f15210g;

    /* renamed from: h, reason: collision with root package name */
    public String[] f15211h;

    /* renamed from: i, reason: collision with root package name */
    public String[] f15212i;

    /* renamed from: j, reason: collision with root package name */
    public JSONObject f15213j;

    public AppInfo(String str, String str2, String str3, String[] strArr, String[] strArr2, String str4, String str5, String str6, JSONObject jSONObject) {
        this.f15205b = str;
        this.f15206c = str2;
        this.f15207d = str3;
        this.f15211h = strArr;
        this.f15212i = strArr2;
        this.f15208e = str4;
        this.f15213j = jSONObject;
        this.f15209f = str5;
        this.f15210g = str6;
    }

    @Override // com.amazon.identity.auth.device.dataobject.AbstractDataObject
    public final c c(Context context) {
        d dVar;
        synchronized (d.class) {
            try {
                if (d.f48356b == null) {
                    d.f48356b = new d(b.a(context));
                }
                dVar = d.f48356b;
            } catch (Throwable th) {
                throw th;
            }
        }
        return dVar;
    }

    public final Object clone() {
        long j2 = this.f15203a;
        AppInfo appInfo = new AppInfo(this.f15205b, this.f15206c, this.f15207d, this.f15211h, this.f15212i, this.f15208e, this.f15209f, this.f15210g, this.f15213j);
        appInfo.f15203a = j2;
        return appInfo;
    }

    @Override // com.amazon.identity.auth.device.dataobject.AbstractDataObject
    public final ContentValues d(Context context) {
        String string;
        String string2;
        ContentValues contentValues = new ContentValues();
        String[] strArr = f15204k;
        contentValues.put(strArr[1], this.f15205b);
        contentValues.put(strArr[2], this.f15207d);
        String str = strArr[3];
        String[] strArr2 = this.f15211h;
        int i2 = 0;
        if (strArr2 == null || strArr2.length <= 0) {
            string = null;
        } else {
            int i3 = 0;
            string = "";
            while (i3 < strArr2.length) {
                StringBuilder sbW = android.support.v4.media.b.w(string);
                sbW.append(strArr2[i3].trim());
                sbW.append(i3 == strArr2.length - 1 ? "" : ",");
                string = sbW.toString();
                i3++;
            }
        }
        contentValues.put(str, string);
        String str2 = strArr[4];
        String[] strArr3 = this.f15212i;
        if (strArr3 == null || strArr3.length <= 0) {
            string2 = null;
        } else {
            string2 = "";
            while (i2 < strArr3.length) {
                StringBuilder sbW2 = android.support.v4.media.b.w(string2);
                sbW2.append(strArr3[i2].trim());
                sbW2.append(i2 == strArr3.length - 1 ? "" : ",");
                string2 = sbW2.toString();
                i2++;
            }
        }
        contentValues.put(str2, string2);
        contentValues.put(strArr[5], this.f15208e);
        contentValues.put(strArr[6], this.f15206c);
        contentValues.put(strArr[7], this.f15209f);
        contentValues.put(strArr[8], this.f15210g);
        String str3 = strArr[9];
        JSONObject jSONObject = this.f15213j;
        contentValues.put(str3, jSONObject != null ? jSONObject.toString() : null);
        return contentValues;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof AppInfo) {
            AppInfo appInfo = (AppInfo) obj;
            if (TextUtils.equals(this.f15205b, appInfo.f15205b) && TextUtils.equals(this.f15206c, appInfo.f15206c) && TextUtils.equals(this.f15207d, appInfo.f15207d) && Arrays.equals(this.f15211h, appInfo.f15211h) && Arrays.equals(this.f15212i, appInfo.f15212i) && TextUtils.equals(this.f15208e, appInfo.f15208e) && TextUtils.equals(this.f15209f, appInfo.f15209f) && TextUtils.equals(this.f15210g, appInfo.f15210g)) {
                JSONObject jSONObject = appInfo.f15213j;
                JSONObject jSONObject2 = this.f15213j;
                if (jSONObject2 == null) {
                    if (jSONObject == null) {
                        return true;
                    }
                } else if (jSONObject != null) {
                    Iterator<String> itKeys = jSONObject2.keys();
                    while (itKeys.hasNext()) {
                        String next = itKeys.next();
                        try {
                            if (!this.f15213j.getString(next).equals(jSONObject.getString(next))) {
                            }
                        } catch (ClassCastException | JSONException unused) {
                        }
                    }
                    return true;
                }
            }
        }
        return false;
    }

    @Override // com.amazon.identity.auth.device.dataobject.AbstractDataObject
    public final String toString() {
        try {
            return this.f15213j.toString(4);
        } catch (Exception unused) {
            StringBuilder sb = new StringBuilder("{ rowid=");
            sb.append(this.f15203a);
            sb.append(", appFamilyId=");
            sb.append(this.f15205b);
            sb.append(", appVariantId=");
            sb.append(this.f15206c);
            sb.append(", packageName=");
            sb.append(this.f15207d);
            sb.append(", allowedScopes=");
            sb.append(Arrays.toString(this.f15211h));
            sb.append(", grantedPermissions=");
            sb.append(Arrays.toString(this.f15212i));
            sb.append(", clientId=");
            sb.append(this.f15208e);
            sb.append(", AuthzHost=");
            sb.append(this.f15209f);
            sb.append(", ExchangeHost=");
            return android.support.v4.media.b.r(sb, this.f15210g, " }");
        }
    }

    public AppInfo() {
    }
}
