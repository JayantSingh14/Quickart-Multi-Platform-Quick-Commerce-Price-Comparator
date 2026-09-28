package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/* loaded from: classes3.dex */
final class zzaah extends zzuu {
    static final zzuv zza = new zzaaf();
    private final DateFormat zzb = new SimpleDateFormat("hh:mm:ss a");

    private zzaah() {
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzuu
    public final /* bridge */ /* synthetic */ void write(zzaas zzaasVar, Object obj) throws IOException {
        String str;
        Time time = (Time) obj;
        if (time == null) {
            zzaasVar.zzg();
            return;
        }
        synchronized (this) {
            str = this.zzb.format((Date) time);
        }
        zzaasVar.zzl(str);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzuu
    /* renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final Time read(zzaaq zzaaqVar) throws IOException {
        Time time;
        if (zzaaqVar.zzr() == 9) {
            zzaaqVar.zzm();
            return null;
        }
        String strZzh = zzaaqVar.zzh();
        synchronized (this) {
            TimeZone timeZone = this.zzb.getTimeZone();
            try {
                try {
                    time = new Time(this.zzb.parse(strZzh).getTime());
                } catch (ParseException e2) {
                    throw new zzuk("Failed parsing '" + strZzh + "' as SQL Time; at path " + zzaaqVar.zzf(), e2);
                }
            } finally {
                this.zzb.setTimeZone(timeZone);
            }
        }
        return time;
    }

    public /* synthetic */ zzaah(zzaag zzaagVar) {
    }
}
