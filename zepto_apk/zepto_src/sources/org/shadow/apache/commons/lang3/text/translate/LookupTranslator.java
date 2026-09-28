package org.shadow.apache.commons.lang3.text.translate;

import com.google.android.gms.common.api.Api;
import java.util.HashMap;
import java.util.HashSet;

/* loaded from: classes5.dex */
public class LookupTranslator extends CharSequenceTranslator {

    /* renamed from: a, reason: collision with root package name */
    public final HashMap f57795a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    public final HashSet f57796b = new HashSet();

    public LookupTranslator(CharSequence[]... charSequenceArr) {
        int i2 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
        int i3 = 0;
        for (CharSequence[] charSequenceArr2 : charSequenceArr) {
            this.f57795a.put(charSequenceArr2[0].toString(), charSequenceArr2[1].toString());
            this.f57796b.add(Character.valueOf(charSequenceArr2[0].charAt(0)));
            int length = charSequenceArr2[0].length();
            i2 = length < i2 ? length : i2;
            if (length > i3) {
                i3 = length;
            }
        }
    }
}
