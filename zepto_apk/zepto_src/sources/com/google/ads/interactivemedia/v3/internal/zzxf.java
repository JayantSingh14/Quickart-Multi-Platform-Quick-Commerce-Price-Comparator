package com.google.ads.interactivemedia.v3.internal;

import android.support.v4.media.b;
import androidx.fragment.app.e;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.TimeZone;

/* loaded from: classes3.dex */
public final class zzxf extends zzuu {
    public static final zzuv zza = new zzxb();
    private final zzxd zzb;
    private final List zzc;

    public /* synthetic */ zzxf(zzxd zzxdVar, int i2, int i3, zzxe zzxeVar) {
        ArrayList arrayList = new ArrayList();
        this.zzc = arrayList;
        Objects.requireNonNull(zzxdVar);
        this.zzb = zzxdVar;
        Locale locale = Locale.US;
        arrayList.add(DateFormat.getDateTimeInstance(2, 2, locale));
        if (!Locale.getDefault().equals(locale)) {
            arrayList.add(DateFormat.getDateTimeInstance(2, 2));
        }
        if (zzvz.zza()) {
            arrayList.add(new SimpleDateFormat("MMM d, yyyy h:mm:ss a", locale));
        }
    }

    private final Date zza(zzaaq zzaaqVar) throws IOException {
        List list = this.zzc;
        String strZzh = zzaaqVar.zzh();
        synchronized (list) {
            try {
                for (DateFormat dateFormat : this.zzc) {
                    TimeZone timeZone = dateFormat.getTimeZone();
                    try {
                        try {
                            return dateFormat.parse(strZzh);
                        } finally {
                            dateFormat.setTimeZone(timeZone);
                        }
                    } catch (ParseException unused) {
                        dateFormat.setTimeZone(timeZone);
                    }
                }
                try {
                    return zzzu.zza(strZzh, new ParsePosition(0));
                } catch (ParseException e2) {
                    throw new zzuk(e.p("Failed parsing '", strZzh, "' as Date; at path ", zzaaqVar.zzf()), e2);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzuu
    public final /* bridge */ /* synthetic */ Object read(zzaaq zzaaqVar) throws IOException {
        if (zzaaqVar.zzr() == 9) {
            zzaaqVar.zzm();
            return null;
        }
        return this.zzb.zza(zza(zzaaqVar));
    }

    public final String toString() {
        DateFormat dateFormat = (DateFormat) this.zzc.get(0);
        return dateFormat instanceof SimpleDateFormat ? b.D("DefaultDateTypeAdapter(", ((SimpleDateFormat) dateFormat).toPattern(), ")") : b.D("DefaultDateTypeAdapter(", dateFormat.getClass().getSimpleName(), ")");
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzuu
    public final /* bridge */ /* synthetic */ void write(zzaas zzaasVar, Object obj) throws IOException {
        String str;
        Date date = (Date) obj;
        if (date == null) {
            zzaasVar.zzg();
            return;
        }
        DateFormat dateFormat = (DateFormat) this.zzc.get(0);
        synchronized (this.zzc) {
            str = dateFormat.format(date);
        }
        zzaasVar.zzl(str);
    }
}
