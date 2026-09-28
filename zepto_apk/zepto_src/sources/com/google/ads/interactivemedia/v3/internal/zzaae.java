package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

/* loaded from: classes3.dex */
final class zzaae extends zzuu {
    static final zzuv zza = new zzaac();
    private final DateFormat zzb = new SimpleDateFormat("MMM d, yyyy");

    private zzaae() {
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzuu
    public final /* bridge */ /* synthetic */ void write(zzaas zzaasVar, Object obj) throws IOException {
        String str;
        Date date = (Date) obj;
        if (date == null) {
            zzaasVar.zzg();
            return;
        }
        synchronized (this) {
            str = this.zzb.format((java.util.Date) date);
        }
        zzaasVar.zzl(str);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzuu
    /* renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final Date read(zzaaq zzaaqVar) throws IOException {
        Date date;
        if (zzaaqVar.zzr() == 9) {
            zzaaqVar.zzm();
            return null;
        }
        String strZzh = zzaaqVar.zzh();
        synchronized (this) {
            TimeZone timeZone = this.zzb.getTimeZone();
            try {
                try {
                    date = new Date(this.zzb.parse(strZzh).getTime());
                } catch (ParseException e2) {
                    throw new zzuk("Failed parsing '" + strZzh + "' as SQL Date; at path " + zzaaqVar.zzf(), e2);
                }
            } finally {
                this.zzb.setTimeZone(timeZone);
            }
        }
        return date;
    }

    public /* synthetic */ zzaae(zzaad zzaadVar) {
    }
}
