package org.npci.upi.security.pinactivitycomponent;

import android.content.Context;
import com.amazon.apay.hardened.external.model.APayConstants;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public class u {

    /* renamed from: b, reason: collision with root package name */
    private static final String f57598b = "org.npci.upi.security.pinactivitycomponent.u";

    /* renamed from: a, reason: collision with root package name */
    JSONArray f57599a;

    /* renamed from: c, reason: collision with root package name */
    private Context f57600c;

    /* renamed from: d, reason: collision with root package name */
    private n f57601d;

    /* renamed from: e, reason: collision with root package name */
    private List<String> f57602e;

    public u(Context context) {
        this.f57599a = null;
        this.f57600c = context;
        this.f57601d = new n(context);
        this.f57599a = new JSONArray();
        byte[] bArrA = k.a(CLConstants.OTP_RULES_FILE, context);
        if (bArrA != null) {
            try {
                this.f57599a = new JSONArray(new String(bArrA));
            } catch (Exception e2) {
                q.a(f57598b, e2);
            }
        }
    }

    public static String a(String str) throws NoSuchAlgorithmException {
        String lowerCase = str.toLowerCase();
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(MessageDigestAlgorithms.SHA_256);
            messageDigest.update(lowerCase.getBytes(), 0, lowerCase.length());
            String string = new BigInteger(1, messageDigest.digest()).toString(16);
            while (string.length() < 32) {
                string = "0" + string;
            }
            return string;
        } catch (Exception e2) {
            q.a(f57598b, e2);
            return null;
        }
    }

    private boolean b(String str) {
        if (this.f57602e == null) {
            this.f57602e = Arrays.asList(this.f57601d.b(CLConstants.MGS_ID_PREFERENCES, "").split(","));
        }
        return this.f57602e.contains(str);
    }

    private String c(t tVar) {
        return a(tVar.a());
    }

    private String a(ArrayList<String> arrayList) {
        if (arrayList.size() <= 0) {
            return null;
        }
        String string = "" + arrayList.get(0);
        for (int i2 = 1; i2 < arrayList.size(); i2++) {
            StringBuilder sbX = android.support.v4.media.b.x(string, ",");
            sbX.append(arrayList.get(i2));
            string = sbX.toString();
        }
        return string;
    }

    private boolean b(t tVar) {
        return (b(tVar.c()) || b(c(tVar))) ? false : true;
    }

    private void c(String str) {
        if (str == null) {
            return;
        }
        ArrayList<String> arrayList = new ArrayList<>(Arrays.asList(this.f57601d.b(CLConstants.MGS_ID_PREFERENCES, "").split(",")));
        if (arrayList.contains(str)) {
            return;
        }
        if (arrayList.size() >= 10) {
            arrayList.remove(0);
        }
        arrayList.add(str);
        this.f57601d.a(CLConstants.MGS_ID_PREFERENCES, a(arrayList));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0070 A[PHI: r11
      0x0070: PHI (r11v5 android.database.Cursor) = (r11v3 android.database.Cursor), (r11v4 android.database.Cursor), (r11v7 android.database.Cursor) binds: [B:24:0x0082, B:29:0x008b, B:37:0x0070] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:43:? A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public org.npci.upi.security.pinactivitycomponent.t a(int r10, long r11) throws java.lang.Throwable {
        /*
            r9 = this;
            java.lang.String r0 = ""
            java.lang.String r1 = "content://sms/inbox"
            android.net.Uri r3 = android.net.Uri.parse(r1)
            java.lang.String r1 = "body"
            java.lang.String r2 = "date"
            java.lang.String r8 = "_id"
            java.lang.String r4 = "address"
            java.lang.String[] r4 = new java.lang.String[]{r8, r4, r1, r2}
            java.lang.String r5 = "date > ?"
            java.lang.String r7 = "date DESC"
            r1 = 0
            android.content.Context r2 = r9.f57600c     // Catch: java.lang.Throwable -> L74 java.lang.Exception -> L77 java.lang.SecurityException -> L7b
            android.content.ContentResolver r2 = r2.getContentResolver()     // Catch: java.lang.Throwable -> L74 java.lang.Exception -> L77 java.lang.SecurityException -> L7b
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L74 java.lang.Exception -> L77 java.lang.SecurityException -> L7b
            r6.<init>(r0)     // Catch: java.lang.Throwable -> L74 java.lang.Exception -> L77 java.lang.SecurityException -> L7b
            r6.append(r11)     // Catch: java.lang.Throwable -> L74 java.lang.Exception -> L77 java.lang.SecurityException -> L7b
            java.lang.String r11 = r6.toString()     // Catch: java.lang.Throwable -> L74 java.lang.Exception -> L77 java.lang.SecurityException -> L7b
            java.lang.String[] r6 = new java.lang.String[]{r11}     // Catch: java.lang.Throwable -> L74 java.lang.Exception -> L77 java.lang.SecurityException -> L7b
            android.database.Cursor r11 = r2.query(r3, r4, r5, r6, r7)     // Catch: java.lang.Throwable -> L74 java.lang.Exception -> L77 java.lang.SecurityException -> L7b
        L33:
            boolean r12 = r11.moveToNext()     // Catch: java.lang.Throwable -> L69 java.lang.Exception -> L6d java.lang.SecurityException -> L8b
            if (r12 == 0) goto L70
            r12 = 1
            java.lang.String r12 = r11.getString(r12)     // Catch: java.lang.Throwable -> L69 java.lang.Exception -> L6d java.lang.SecurityException -> L8b
            r0 = 2
            java.lang.String r0 = r11.getString(r0)     // Catch: java.lang.Throwable -> L69 java.lang.Exception -> L6d java.lang.SecurityException -> L8b
            org.npci.upi.security.pinactivitycomponent.t r12 = r9.a(r10, r12, r0)     // Catch: java.lang.Throwable -> L69 java.lang.Exception -> L6d java.lang.SecurityException -> L8b
            if (r12 == 0) goto L33
            int r0 = r11.getColumnIndex(r8)     // Catch: java.lang.Throwable -> L69 java.lang.Exception -> L6d java.lang.SecurityException -> L8b
            long r2 = r11.getLong(r0)     // Catch: java.lang.Throwable -> L69 java.lang.Exception -> L6d java.lang.SecurityException -> L8b
            java.lang.Long r0 = java.lang.Long.valueOf(r2)     // Catch: java.lang.Throwable -> L69 java.lang.Exception -> L6d java.lang.SecurityException -> L8b
            java.lang.String r0 = java.lang.String.valueOf(r0)     // Catch: java.lang.Throwable -> L69 java.lang.Exception -> L6d java.lang.SecurityException -> L8b
            r12.c(r0)     // Catch: java.lang.Throwable -> L69 java.lang.Exception -> L6d java.lang.SecurityException -> L8b
            boolean r0 = r9.b(r12)     // Catch: java.lang.Throwable -> L69 java.lang.Exception -> L6d java.lang.SecurityException -> L8b
            if (r0 == 0) goto L33
            r9.a(r12)     // Catch: java.lang.Throwable -> L69 java.lang.Exception -> L6d java.lang.SecurityException -> L8b
            r11.close()
            return r12
        L69:
            r0 = move-exception
            r10 = r0
            r1 = r11
            goto L85
        L6d:
            r0 = move-exception
            r10 = r0
            goto L7d
        L70:
            r11.close()
            goto L8e
        L74:
            r0 = move-exception
            r10 = r0
            goto L85
        L77:
            r0 = move-exception
            r10 = r0
            r11 = r1
            goto L7d
        L7b:
            r11 = r1
            goto L8b
        L7d:
            java.lang.String r12 = org.npci.upi.security.pinactivitycomponent.u.f57598b     // Catch: java.lang.Throwable -> L69
            org.npci.upi.security.pinactivitycomponent.q.a(r12, r10)     // Catch: java.lang.Throwable -> L69
            if (r11 == 0) goto L8e
            goto L70
        L85:
            if (r1 == 0) goto L8a
            r1.close()
        L8a:
            throw r10
        L8b:
            if (r11 == 0) goto L8e
            goto L70
        L8e:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: org.npci.upi.security.pinactivitycomponent.u.a(int, long):org.npci.upi.security.pinactivitycomponent.t");
    }

    public t a(int i2, String str, String str2) {
        for (int i3 = 0; i3 < this.f57599a.length(); i3++) {
            try {
                if (str2.contains("UIDAI")) {
                    i2 = 6;
                }
                t tVarA = a(i2, str2, str, this.f57599a.getJSONObject(i3));
                if (tVarA != null) {
                    return tVarA;
                }
            } catch (Exception e2) {
                q.a(f57598b, e2);
                return null;
            }
        }
        return null;
    }

    private t a(int i2, String str, String str2, JSONObject jSONObject) {
        String str3;
        g gVar;
        String str4;
        if (!a(str2, jSONObject.getJSONArray("sender")) || !a(str, jSONObject.getString(APayConstants.Error.MESSAGE))) {
            return null;
        }
        if (i2 != 0) {
            str3 = "\\d{" + i2 + "}";
        } else {
            str3 = (String) jSONObject.get(CLConstants.OTP);
        }
        Matcher matcher = Pattern.compile(str3).matcher(str);
        t tVar = new t();
        tVar.a(str);
        if (matcher.find() && matcher.groupCount() >= 0) {
            tVar.b(matcher.group(0));
            if (str.contains("Aadhaar") || str.contains(CLConstants.CREDTYPE_AADHAAR)) {
                gVar = new g(this.f57600c);
                str4 = CLConstants.SHARED_PREFERENCE_AADHAAR_OTP;
            } else {
                gVar = new g(this.f57600c);
                str4 = CLConstants.SHARED_PREFERENCE_BANK_OTP;
            }
            gVar.b(str4, tVar.b());
            return tVar;
        }
        return null;
    }

    public void a(t tVar) {
        c(tVar.c() != null ? tVar.c() : c(tVar));
    }

    private boolean a(String str, String str2) {
        return Pattern.compile(str2, 2).matcher(str).find();
    }

    private boolean a(String str, JSONArray jSONArray) {
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            if (Pattern.compile(jSONArray.getString(i2), 2).matcher(str).find()) {
                return true;
            }
        }
        return false;
    }
}
