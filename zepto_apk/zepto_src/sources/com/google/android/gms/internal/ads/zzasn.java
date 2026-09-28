package com.google.android.gms.internal.ads;

import coil3.network.internal.UtilsKt;
import java.io.UnsupportedEncodingException;
import java.util.Map;

/* loaded from: classes4.dex */
public class zzasn extends zzark {

    /* renamed from: m, reason: collision with root package name */
    public final Object f24281m;
    public final zzarp n;

    public zzasn(int i2, String str, zzarp zzarpVar, zzaro zzaroVar) {
        super(i2, str, zzaroVar);
        this.f24281m = new Object();
        this.n = zzarpVar;
    }

    @Override // com.google.android.gms.internal.ads.zzark
    public final zzarq i(zzarg zzargVar) {
        String str;
        String str2;
        byte[] bArr = zzargVar.f24206b;
        try {
            Map map = zzargVar.f24207c;
            String str3 = "ISO-8859-1";
            if (map != null && (str2 = (String) map.get(UtilsKt.CONTENT_TYPE)) != null) {
                String[] strArrSplit = str2.split(";", 0);
                int i2 = 1;
                while (true) {
                    if (i2 >= strArrSplit.length) {
                        break;
                    }
                    String[] strArrSplit2 = strArrSplit[i2].trim().split("=", 0);
                    if (strArrSplit2.length == 2 && strArrSplit2[0].equals("charset")) {
                        str3 = strArrSplit2[1];
                        break;
                    }
                    i2++;
                }
            }
            str = new String(bArr, str3);
        } catch (UnsupportedEncodingException unused) {
            str = new String(bArr);
        }
        return new zzarq(str, zzash.a(zzargVar));
    }

    @Override // com.google.android.gms.internal.ads.zzark
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public void l(String str) {
        zzarp zzarpVar;
        synchronized (this.f24281m) {
            zzarpVar = this.n;
        }
        zzarpVar.a(str);
    }
}
