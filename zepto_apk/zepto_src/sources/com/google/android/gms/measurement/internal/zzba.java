package com.google.android.gms.measurement.internal;

import android.support.v4.media.b;
import java.util.Calendar;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public final class zzba extends zzje {

    /* renamed from: c, reason: collision with root package name */
    public long f38748c;

    /* renamed from: d, reason: collision with root package name */
    public String f38749d;

    @Override // com.google.android.gms.measurement.internal.zzje
    public final boolean h() {
        Calendar calendar = Calendar.getInstance();
        this.f38748c = TimeUnit.MINUTES.convert(calendar.get(16) + calendar.get(15), TimeUnit.MILLISECONDS);
        Locale locale = Locale.getDefault();
        String language = locale.getLanguage();
        Locale locale2 = Locale.ENGLISH;
        String lowerCase = language.toLowerCase(locale2);
        String lowerCase2 = locale.getCountry().toLowerCase(locale2);
        this.f38749d = b.s(new StringBuilder(String.valueOf(lowerCase).length() + 1 + String.valueOf(lowerCase2).length()), lowerCase, "-", lowerCase2);
        return false;
    }

    public final long k() {
        i();
        return this.f38748c;
    }

    public final String l() {
        i();
        return this.f38749d;
    }
}
