package com.google.ads.interactivemedia.v3.internal;

import com.amazonaws.mobileconnectors.remoteconfiguration.Attributes;
import java.io.IOException;
import java.util.Locale;
import java.util.StringTokenizer;

/* loaded from: classes3.dex */
final class zzza extends zzuu {
    @Override // com.google.ads.interactivemedia.v3.internal.zzuu
    public final /* bridge */ /* synthetic */ Object read(zzaaq zzaaqVar) throws IOException {
        if (zzaaqVar.zzr() == 9) {
            zzaaqVar.zzm();
            return null;
        }
        StringTokenizer stringTokenizer = new StringTokenizer(zzaaqVar.zzh(), Attributes.PREDEFINED_ATTRIBUTE_PREFIX);
        String strNextToken = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
        String strNextToken2 = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
        String strNextToken3 = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
        return (strNextToken2 == null && strNextToken3 == null) ? new Locale(strNextToken) : strNextToken3 == null ? new Locale(strNextToken, strNextToken2) : new Locale(strNextToken, strNextToken2, strNextToken3);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzuu
    public final /* bridge */ /* synthetic */ void write(zzaas zzaasVar, Object obj) throws IOException {
        Locale locale = (Locale) obj;
        zzaasVar.zzl(locale == null ? null : locale.toString());
    }
}
