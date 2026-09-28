package org.npci.upi.security.pinactivitycomponent;

import android.content.Context;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private static final String f57516a = "e";

    /* renamed from: b, reason: collision with root package name */
    private Bundle f57517b;

    /* renamed from: c, reason: collision with root package name */
    private JSONObject f57518c;

    /* renamed from: d, reason: collision with root package name */
    private JSONObject f57519d;

    /* renamed from: e, reason: collision with root package name */
    private JSONArray f57520e;

    /* renamed from: f, reason: collision with root package name */
    private JSONObject f57521f;

    /* renamed from: g, reason: collision with root package name */
    private JSONArray f57522g;

    /* renamed from: h, reason: collision with root package name */
    private String f57523h;

    /* renamed from: i, reason: collision with root package name */
    private JSONArray f57524i;

    /* renamed from: j, reason: collision with root package name */
    private JSONArray f57525j;

    /* renamed from: k, reason: collision with root package name */
    private Boolean f57526k;

    /* renamed from: m, reason: collision with root package name */
    private l f57528m;
    private b n;
    private int o;
    private boolean p;
    private boolean q;
    private boolean r;
    private boolean s;
    private String t;
    private String u;

    /* renamed from: l, reason: collision with root package name */
    private Boolean f57527l = null;
    private HashMap<String, String> v = new HashMap<>();
    private JSONObject w = new JSONObject();

    /* JADX WARN: Removed duplicated region for block: B:19:0x0086 A[Catch: Exception -> 0x005a, TryCatch #1 {Exception -> 0x005a, blocks: (B:5:0x004a, B:7:0x0052, B:10:0x005d, B:12:0x0065, B:13:0x006b, B:17:0x007d, B:19:0x0086, B:21:0x0094, B:28:0x00b0, B:30:0x00b4, B:32:0x00b8, B:33:0x00ba, B:35:0x00c2, B:36:0x00ca, B:38:0x00d2, B:39:0x00da, B:41:0x00e2, B:42:0x00ea, B:44:0x00f2, B:46:0x0101, B:49:0x0115, B:51:0x0121, B:52:0x0125, B:54:0x012e, B:56:0x013a, B:60:0x014a, B:58:0x0142, B:61:0x014c, B:63:0x0154, B:64:0x015b, B:66:0x0163, B:67:0x016a, B:75:0x01c6, B:74:0x01c1, B:76:0x01c9, B:78:0x01d1, B:82:0x01e9, B:22:0x0097, B:24:0x009f, B:27:0x00ae, B:14:0x006e, B:16:0x0076, B:69:0x0172, B:71:0x0188, B:79:0x01d3), top: B:88:0x004a, inners: #0, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0097 A[Catch: Exception -> 0x005a, TryCatch #1 {Exception -> 0x005a, blocks: (B:5:0x004a, B:7:0x0052, B:10:0x005d, B:12:0x0065, B:13:0x006b, B:17:0x007d, B:19:0x0086, B:21:0x0094, B:28:0x00b0, B:30:0x00b4, B:32:0x00b8, B:33:0x00ba, B:35:0x00c2, B:36:0x00ca, B:38:0x00d2, B:39:0x00da, B:41:0x00e2, B:42:0x00ea, B:44:0x00f2, B:46:0x0101, B:49:0x0115, B:51:0x0121, B:52:0x0125, B:54:0x012e, B:56:0x013a, B:60:0x014a, B:58:0x0142, B:61:0x014c, B:63:0x0154, B:64:0x015b, B:66:0x0163, B:67:0x016a, B:75:0x01c6, B:74:0x01c1, B:76:0x01c9, B:78:0x01d1, B:82:0x01e9, B:22:0x0097, B:24:0x009f, B:27:0x00ae, B:14:0x006e, B:16:0x0076, B:69:0x0172, B:71:0x0188, B:79:0x01d3), top: B:88:0x004a, inners: #0, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00c2 A[Catch: Exception -> 0x005a, TryCatch #1 {Exception -> 0x005a, blocks: (B:5:0x004a, B:7:0x0052, B:10:0x005d, B:12:0x0065, B:13:0x006b, B:17:0x007d, B:19:0x0086, B:21:0x0094, B:28:0x00b0, B:30:0x00b4, B:32:0x00b8, B:33:0x00ba, B:35:0x00c2, B:36:0x00ca, B:38:0x00d2, B:39:0x00da, B:41:0x00e2, B:42:0x00ea, B:44:0x00f2, B:46:0x0101, B:49:0x0115, B:51:0x0121, B:52:0x0125, B:54:0x012e, B:56:0x013a, B:60:0x014a, B:58:0x0142, B:61:0x014c, B:63:0x0154, B:64:0x015b, B:66:0x0163, B:67:0x016a, B:75:0x01c6, B:74:0x01c1, B:76:0x01c9, B:78:0x01d1, B:82:0x01e9, B:22:0x0097, B:24:0x009f, B:27:0x00ae, B:14:0x006e, B:16:0x0076, B:69:0x0172, B:71:0x0188, B:79:0x01d3), top: B:88:0x004a, inners: #0, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00d2 A[Catch: Exception -> 0x005a, TryCatch #1 {Exception -> 0x005a, blocks: (B:5:0x004a, B:7:0x0052, B:10:0x005d, B:12:0x0065, B:13:0x006b, B:17:0x007d, B:19:0x0086, B:21:0x0094, B:28:0x00b0, B:30:0x00b4, B:32:0x00b8, B:33:0x00ba, B:35:0x00c2, B:36:0x00ca, B:38:0x00d2, B:39:0x00da, B:41:0x00e2, B:42:0x00ea, B:44:0x00f2, B:46:0x0101, B:49:0x0115, B:51:0x0121, B:52:0x0125, B:54:0x012e, B:56:0x013a, B:60:0x014a, B:58:0x0142, B:61:0x014c, B:63:0x0154, B:64:0x015b, B:66:0x0163, B:67:0x016a, B:75:0x01c6, B:74:0x01c1, B:76:0x01c9, B:78:0x01d1, B:82:0x01e9, B:22:0x0097, B:24:0x009f, B:27:0x00ae, B:14:0x006e, B:16:0x0076, B:69:0x0172, B:71:0x0188, B:79:0x01d3), top: B:88:0x004a, inners: #0, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00e2 A[Catch: Exception -> 0x005a, TryCatch #1 {Exception -> 0x005a, blocks: (B:5:0x004a, B:7:0x0052, B:10:0x005d, B:12:0x0065, B:13:0x006b, B:17:0x007d, B:19:0x0086, B:21:0x0094, B:28:0x00b0, B:30:0x00b4, B:32:0x00b8, B:33:0x00ba, B:35:0x00c2, B:36:0x00ca, B:38:0x00d2, B:39:0x00da, B:41:0x00e2, B:42:0x00ea, B:44:0x00f2, B:46:0x0101, B:49:0x0115, B:51:0x0121, B:52:0x0125, B:54:0x012e, B:56:0x013a, B:60:0x014a, B:58:0x0142, B:61:0x014c, B:63:0x0154, B:64:0x015b, B:66:0x0163, B:67:0x016a, B:75:0x01c6, B:74:0x01c1, B:76:0x01c9, B:78:0x01d1, B:82:0x01e9, B:22:0x0097, B:24:0x009f, B:27:0x00ae, B:14:0x006e, B:16:0x0076, B:69:0x0172, B:71:0x0188, B:79:0x01d3), top: B:88:0x004a, inners: #0, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00f2 A[Catch: Exception -> 0x005a, TryCatch #1 {Exception -> 0x005a, blocks: (B:5:0x004a, B:7:0x0052, B:10:0x005d, B:12:0x0065, B:13:0x006b, B:17:0x007d, B:19:0x0086, B:21:0x0094, B:28:0x00b0, B:30:0x00b4, B:32:0x00b8, B:33:0x00ba, B:35:0x00c2, B:36:0x00ca, B:38:0x00d2, B:39:0x00da, B:41:0x00e2, B:42:0x00ea, B:44:0x00f2, B:46:0x0101, B:49:0x0115, B:51:0x0121, B:52:0x0125, B:54:0x012e, B:56:0x013a, B:60:0x014a, B:58:0x0142, B:61:0x014c, B:63:0x0154, B:64:0x015b, B:66:0x0163, B:67:0x016a, B:75:0x01c6, B:74:0x01c1, B:76:0x01c9, B:78:0x01d1, B:82:0x01e9, B:22:0x0097, B:24:0x009f, B:27:0x00ae, B:14:0x006e, B:16:0x0076, B:69:0x0172, B:71:0x0188, B:79:0x01d3), top: B:88:0x004a, inners: #0, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0154 A[Catch: Exception -> 0x005a, TryCatch #1 {Exception -> 0x005a, blocks: (B:5:0x004a, B:7:0x0052, B:10:0x005d, B:12:0x0065, B:13:0x006b, B:17:0x007d, B:19:0x0086, B:21:0x0094, B:28:0x00b0, B:30:0x00b4, B:32:0x00b8, B:33:0x00ba, B:35:0x00c2, B:36:0x00ca, B:38:0x00d2, B:39:0x00da, B:41:0x00e2, B:42:0x00ea, B:44:0x00f2, B:46:0x0101, B:49:0x0115, B:51:0x0121, B:52:0x0125, B:54:0x012e, B:56:0x013a, B:60:0x014a, B:58:0x0142, B:61:0x014c, B:63:0x0154, B:64:0x015b, B:66:0x0163, B:67:0x016a, B:75:0x01c6, B:74:0x01c1, B:76:0x01c9, B:78:0x01d1, B:82:0x01e9, B:22:0x0097, B:24:0x009f, B:27:0x00ae, B:14:0x006e, B:16:0x0076, B:69:0x0172, B:71:0x0188, B:79:0x01d3), top: B:88:0x004a, inners: #0, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0163 A[Catch: Exception -> 0x005a, TryCatch #1 {Exception -> 0x005a, blocks: (B:5:0x004a, B:7:0x0052, B:10:0x005d, B:12:0x0065, B:13:0x006b, B:17:0x007d, B:19:0x0086, B:21:0x0094, B:28:0x00b0, B:30:0x00b4, B:32:0x00b8, B:33:0x00ba, B:35:0x00c2, B:36:0x00ca, B:38:0x00d2, B:39:0x00da, B:41:0x00e2, B:42:0x00ea, B:44:0x00f2, B:46:0x0101, B:49:0x0115, B:51:0x0121, B:52:0x0125, B:54:0x012e, B:56:0x013a, B:60:0x014a, B:58:0x0142, B:61:0x014c, B:63:0x0154, B:64:0x015b, B:66:0x0163, B:67:0x016a, B:75:0x01c6, B:74:0x01c1, B:76:0x01c9, B:78:0x01d1, B:82:0x01e9, B:22:0x0097, B:24:0x009f, B:27:0x00ae, B:14:0x006e, B:16:0x0076, B:69:0x0172, B:71:0x0188, B:79:0x01d3), top: B:88:0x004a, inners: #0, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x01d1 A[Catch: Exception -> 0x005a, TRY_LEAVE, TryCatch #1 {Exception -> 0x005a, blocks: (B:5:0x004a, B:7:0x0052, B:10:0x005d, B:12:0x0065, B:13:0x006b, B:17:0x007d, B:19:0x0086, B:21:0x0094, B:28:0x00b0, B:30:0x00b4, B:32:0x00b8, B:33:0x00ba, B:35:0x00c2, B:36:0x00ca, B:38:0x00d2, B:39:0x00da, B:41:0x00e2, B:42:0x00ea, B:44:0x00f2, B:46:0x0101, B:49:0x0115, B:51:0x0121, B:52:0x0125, B:54:0x012e, B:56:0x013a, B:60:0x014a, B:58:0x0142, B:61:0x014c, B:63:0x0154, B:64:0x015b, B:66:0x0163, B:67:0x016a, B:75:0x01c6, B:74:0x01c1, B:76:0x01c9, B:78:0x01d1, B:82:0x01e9, B:22:0x0097, B:24:0x009f, B:27:0x00ae, B:14:0x006e, B:16:0x0076, B:69:0x0172, B:71:0x0188, B:79:0x01d3), top: B:88:0x004a, inners: #0, #2 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public e(android.os.Bundle r13) throws org.json.JSONException, java.lang.NumberFormatException {
        /*
            Method dump skipped, instructions count: 501
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.npci.upi.security.pinactivitycomponent.e.<init>(android.os.Bundle):void");
    }

    private void t() throws JSONException {
        ArrayList arrayList = new ArrayList();
        JSONObject jSONObject = null;
        JSONObject jSONObject2 = null;
        JSONObject jSONObject3 = null;
        JSONObject jSONObject4 = null;
        JSONObject jSONObject5 = null;
        JSONObject jSONObject6 = null;
        JSONObject jSONObject7 = null;
        for (int i2 = 0; i2 < this.f57520e.length(); i2++) {
            try {
                String strOptString = ((JSONObject) this.f57520e.get(i2)).optString(CLConstants.FIELD_SUBTYPE, "");
                if (strOptString.equals(CLConstants.CREDTYPE_ATM)) {
                    jSONObject = this.f57520e.getJSONObject(i2);
                }
                if (strOptString.equals(CLConstants.CREDTYPE_ATMPIN)) {
                    jSONObject4 = this.f57520e.getJSONObject(i2);
                }
                if (strOptString.matches(CLConstants.CREDTYPE_OTP_SUBTYPES)) {
                    jSONObject2 = this.f57520e.getJSONObject(i2);
                }
                if (strOptString.equals(CLConstants.CREDTYPE_MPIN)) {
                    jSONObject3 = this.f57520e.getJSONObject(i2);
                }
                if (strOptString.equals(CLConstants.CREDTYPE_NMPIN)) {
                    jSONObject6 = this.f57520e.getJSONObject(i2);
                }
                if (strOptString.equals(CLConstants.CREDTYPE_AADHAAR)) {
                    jSONObject5 = this.f57520e.getJSONObject(i2);
                    if (!this.f57518c.has(CLConstants.CONFIGURATION_RESEND_AADHAAR_OTP_FEATURE)) {
                        this.p = false;
                    }
                }
                if (strOptString.equals(CLConstants.CREDTYPE_SIGNATURE)) {
                    jSONObject7 = this.f57520e.getJSONObject(i2);
                }
            } catch (Exception e2) {
                q.a(f57516a, e2);
            }
        }
        if (this.f57520e.length() == 3 && jSONObject != null && jSONObject2 != null && jSONObject3 != null) {
            arrayList.add(jSONObject2);
            arrayList.add(jSONObject);
            arrayList.add(jSONObject3);
        }
        if (this.f57520e.length() == 3 && jSONObject4 != null && jSONObject2 != null && jSONObject3 != null) {
            arrayList.add(jSONObject2);
            arrayList.add(jSONObject4);
            arrayList.add(jSONObject3);
        }
        if (this.f57520e.length() == 3 && jSONObject5 != null && jSONObject2 != null && jSONObject3 != null) {
            arrayList.add(jSONObject5);
            arrayList.add(jSONObject2);
            arrayList.add(jSONObject3);
        }
        if (this.f57520e.length() == 2 && jSONObject2 != null && jSONObject3 != null) {
            arrayList.add(jSONObject2);
            arrayList.add(jSONObject3);
        }
        if (this.f57520e.length() == 2 && jSONObject3 != null && jSONObject6 != null) {
            arrayList.add(jSONObject3);
            arrayList.add(jSONObject6);
        }
        if (this.f57520e.length() == 2 && jSONObject3 != null && jSONObject7 != null) {
            arrayList.add(jSONObject3);
            arrayList.add(jSONObject7);
        }
        if (arrayList.size() > 0) {
            this.f57520e = new JSONArray((Collection) arrayList);
        }
    }

    public void a(Context context) {
        l lVar = new l();
        this.f57528m = lVar;
        try {
            this.n = new b(context, lVar);
            this.f57528m.a(this.f57517b, context);
        } catch (Exception e2) {
            if (e2 instanceof c) {
                c cVar = (c) e2;
                ((GetCredential) context).showError(cVar.a(), cVar.b());
                throw e2;
            }
            GetCredential getCredential = (GetCredential) context;
            if (!(e2 instanceof in.org.npci.commonlibrary.c)) {
                getCredential.showError(CLConstants.ERROR_GENERIC, "Unknown error occurred");
                throw e2;
            }
            StringBuilder sb = new StringBuilder();
            in.org.npci.commonlibrary.c cVar2 = (in.org.npci.commonlibrary.c) e2;
            sb.append(cVar2.a());
            sb.append("");
            getCredential.showError(sb.toString(), cVar2.b());
            throw e2;
        }
    }

    public String b() {
        return this.f57523h;
    }

    public JSONObject c() {
        return this.f57518c;
    }

    public JSONObject d() {
        return this.f57521f;
    }

    public JSONArray e() {
        return this.f57522g;
    }

    public Boolean f() {
        return this.f57526k;
    }

    public b g() {
        return this.n;
    }

    public HashMap<String, String> h() {
        return this.v;
    }

    public JSONObject i() {
        return this.w;
    }

    public boolean j() {
        return this.r;
    }

    public boolean k() {
        return this.q;
    }

    public boolean l() {
        return this.p;
    }

    public int m() {
        return this.o;
    }

    public JSONArray n() {
        return this.f57524i;
    }

    public JSONArray o() {
        return this.f57525j;
    }

    public JSONArray p() {
        return this.f57520e;
    }

    public String q() {
        return this.t;
    }

    public String r() {
        return this.u;
    }

    public boolean s() {
        return this.s;
    }

    public void a(String str, String str2) {
        this.v.put(str, str2);
    }

    public void b(String str, String str2) throws JSONException {
        this.w.put(str, str2);
    }

    public void a(JSONArray jSONArray) {
        this.f57524i = jSONArray;
    }

    public void b(JSONArray jSONArray) {
        this.f57520e = jSONArray;
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x0077  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean a() throws org.json.JSONException {
        /*
            r4 = this;
            java.lang.Boolean r0 = r4.f57527l
            if (r0 == 0) goto L9
            boolean r0 = r0.booleanValue()
            return r0
        L9:
            org.json.JSONArray r0 = r4.f57520e
            if (r0 == 0) goto L77
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r1 = 0
        L13:
            org.json.JSONArray r2 = r4.f57520e
            int r2 = r2.length()
            if (r1 >= r2) goto L36
            org.json.JSONArray r2 = r4.f57520e     // Catch: java.lang.Exception -> L2d
            org.json.JSONObject r2 = r2.getJSONObject(r1)     // Catch: java.lang.Exception -> L2d
            java.lang.String r3 = "subtype"
            java.lang.String r2 = r2.getString(r3)     // Catch: java.lang.Exception -> L2d
            if (r2 == 0) goto L33
            r0.add(r2)     // Catch: java.lang.Exception -> L2d
            goto L33
        L2d:
            r2 = move-exception
            java.lang.String r3 = org.npci.upi.security.pinactivitycomponent.e.f57516a
            org.npci.upi.security.pinactivitycomponent.q.a(r3, r2)
        L33:
            int r1 = r1 + 1
            goto L13
        L36:
            java.lang.String r1 = "OTP"
            boolean r1 = r0.contains(r1)
            if (r1 != 0) goto L6e
            java.lang.String r1 = "SMS"
            boolean r1 = r0.contains(r1)
            if (r1 != 0) goto L6e
            java.lang.String r1 = "EMAIL"
            boolean r1 = r0.contains(r1)
            if (r1 != 0) goto L6e
            java.lang.String r1 = "HOTP"
            boolean r1 = r0.contains(r1)
            if (r1 != 0) goto L6e
            java.lang.String r1 = "AADHAAR"
            boolean r1 = r0.contains(r1)
            if (r1 != 0) goto L6e
            java.lang.String r1 = "TOTP"
            boolean r1 = r0.contains(r1)
            if (r1 == 0) goto L77
            java.lang.String r1 = "MPIN"
            boolean r0 = r0.contains(r1)
            if (r0 == 0) goto L77
        L6e:
            java.lang.Boolean r0 = java.lang.Boolean.TRUE
        L70:
            r4.f57527l = r0
            boolean r0 = r0.booleanValue()
            return r0
        L77:
            java.lang.Boolean r0 = java.lang.Boolean.FALSE
            goto L70
        */
        throw new UnsupportedOperationException("Method not decompiled: org.npci.upi.security.pinactivitycomponent.e.a():boolean");
    }
}
