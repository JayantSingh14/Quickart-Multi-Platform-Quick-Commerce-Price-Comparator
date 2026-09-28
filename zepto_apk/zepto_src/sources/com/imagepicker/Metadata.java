package com.imagepicker;

import android.util.Log;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* loaded from: classes4.dex */
abstract class Metadata {

    /* renamed from: a, reason: collision with root package name */
    public String f45935a;

    /* renamed from: b, reason: collision with root package name */
    public int f45936b;

    /* renamed from: c, reason: collision with root package name */
    public int f45937c;

    public static String a(String str, String str2) throws ParseException {
        try {
            Locale locale = Locale.US;
            Date date = new SimpleDateFormat(str2, locale).parse(str);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ", locale);
            if (date != null) {
                return simpleDateFormat.format(date);
            }
            return null;
        } catch (Exception e2) {
            Log.e("RNIP", "Could not parse image datetime to UTC: " + e2.getMessage());
            return null;
        }
    }
}
