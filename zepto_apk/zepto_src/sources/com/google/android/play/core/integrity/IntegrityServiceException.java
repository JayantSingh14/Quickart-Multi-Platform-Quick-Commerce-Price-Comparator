package com.google.android.play.core.integrity;

import com.google.android.gms.common.api.ApiException;

/* loaded from: classes4.dex */
public class IntegrityServiceException extends ApiException {

    /* renamed from: a, reason: collision with root package name */
    public final Exception f41762a;

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public IntegrityServiceException(int r6, java.lang.Exception r7) {
        /*
            r5 = this;
            com.google.android.gms.common.api.Status r0 = new com.google.android.gms.common.api.Status
            java.util.Locale r1 = java.util.Locale.ROOT
            java.util.HashMap r1 = com.google.android.play.core.integrity.model.a.f41840a
            java.lang.Integer r2 = java.lang.Integer.valueOf(r6)
            boolean r3 = r1.containsKey(r2)
            if (r3 == 0) goto L2e
            java.util.HashMap r3 = com.google.android.play.core.integrity.model.a.f41841b
            boolean r4 = r3.containsKey(r2)
            if (r4 != 0) goto L19
            goto L2e
        L19:
            java.lang.Object r1 = r1.get(r2)
            java.lang.String r1 = (java.lang.String) r1
            java.lang.Object r2 = r3.get(r2)
            java.lang.String r2 = (java.lang.String) r2
            java.lang.String r3 = " (https://developer.android.com/google/play/integrity/reference/com/google/android/play/core/integrity/model/IntegrityErrorCode.html#"
            java.lang.String r4 = ")"
            java.lang.String r1 = androidx.fragment.app.e.D(r1, r3, r2, r4)
            goto L30
        L2e:
            java.lang.String r1 = ""
        L30:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "Integrity API error ("
            r2.<init>(r3)
            r2.append(r6)
            java.lang.String r3 = "): "
            r2.append(r3)
            r2.append(r1)
            java.lang.String r1 = "."
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            r0.<init>(r6, r1)
            r5.<init>(r0)
            if (r6 == 0) goto L56
            r5.f41762a = r7
            return
        L56:
            java.lang.IllegalArgumentException r6 = new java.lang.IllegalArgumentException
            java.lang.String r7 = "ErrorCode should not be 0."
            r6.<init>(r7)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.play.core.integrity.IntegrityServiceException.<init>(int, java.lang.Exception):void");
    }

    @Override // java.lang.Throwable
    public final synchronized Throwable getCause() {
        return this.f41762a;
    }
}
