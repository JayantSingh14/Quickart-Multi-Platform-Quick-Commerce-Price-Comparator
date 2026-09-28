package com.google.android.gms.measurement.internal;

import androidx.annotation.WorkerThread;
import com.google.android.gms.common.internal.Preconditions;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@WorkerThread
/* loaded from: classes4.dex */
final class zzlm implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final URL f39331a;

    /* renamed from: b, reason: collision with root package name */
    public final byte[] f39332b;

    /* renamed from: c, reason: collision with root package name */
    public final zzlk f39333c;

    /* renamed from: d, reason: collision with root package name */
    public final String f39334d;

    /* renamed from: e, reason: collision with root package name */
    public final HashMap f39335e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ zzln f39336f;

    public zzlm(zzln zzlnVar, String str, URL url, byte[] bArr, HashMap map, zzlk zzlkVar) {
        Objects.requireNonNull(zzlnVar);
        this.f39336f = zzlnVar;
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(url);
        Preconditions.checkNotNull(zzlkVar);
        this.f39331a = url;
        this.f39332b = bArr;
        this.f39333c = zzlkVar;
        this.f39334d = str;
        this.f39335e = map;
    }

    public final void a(final int i2, final IOException iOException, final byte[] bArr, final Map map) {
        zzhy zzhyVar = this.f39336f.f39180a.f39090g;
        zzib.l(zzhyVar);
        zzhyVar.p(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzll
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.f39326a.f39333c.a(i2, iOException, bArr);
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0143  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0164  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x014f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:97:0x012e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r6v0 */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v13 */
    /* JADX WARN: Type inference failed for: r6v14 */
    /* JADX WARN: Type inference failed for: r6v17, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r6v19 */
    /* JADX WARN: Type inference failed for: r6v2, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r6v20 */
    /* JADX WARN: Type inference failed for: r6v21 */
    /* JADX WARN: Type inference failed for: r6v22 */
    /* JADX WARN: Type inference failed for: r6v4, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r7v12, types: [byte[]] */
    /* JADX WARN: Type inference failed for: r7v9, types: [byte[]] */
    /* JADX WARN: Type inference failed for: r9v0, types: [java.io.OutputStream, java.util.zip.GZIPOutputStream] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void run() throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 363
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzlm.run():void");
    }
}
