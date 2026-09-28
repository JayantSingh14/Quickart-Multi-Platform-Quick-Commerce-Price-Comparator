package com.google.android.gms.measurement.internal;

import androidx.annotation.WorkerThread;
import com.google.android.gms.common.internal.Preconditions;
import java.net.URL;
import java.util.Map;
import java.util.Objects;

@WorkerThread
/* loaded from: classes.dex */
final class zzgx implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final URL f38976a;

    /* renamed from: b, reason: collision with root package name */
    public final byte[] f38977b;

    /* renamed from: c, reason: collision with root package name */
    public final zzgv f38978c;

    /* renamed from: d, reason: collision with root package name */
    public final String f38979d;

    /* renamed from: e, reason: collision with root package name */
    public final Map f38980e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ zzgy f38981f;

    public zzgx(zzgy zzgyVar, String str, URL url, byte[] bArr, Map map, zzgv zzgvVar) {
        Objects.requireNonNull(zzgyVar);
        this.f38981f = zzgyVar;
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(url);
        Preconditions.checkNotNull(zzgvVar);
        this.f38976a = url;
        this.f38977b = bArr;
        this.f38978c = zzgvVar;
        this.f38979d = str;
        this.f38980e = map;
    }

    /* JADX WARN: Not initialized variable reg: 13, insn: 0x00fe: MOVE (r11 I:??[OBJECT, ARRAY]) = (r13 I:??[OBJECT, ARRAY]) (LINE:255), block:B:51:0x00fc */
    /* JADX WARN: Not initialized variable reg: 13, insn: 0x0101: MOVE (r12 I:??[OBJECT, ARRAY]) = (r13 I:??[OBJECT, ARRAY]) (LINE:258), block:B:52:0x0100 */
    /* JADX WARN: Removed duplicated region for block: B:73:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x016e  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0127 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0159 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void run() throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 388
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzgx.run():void");
    }
}
