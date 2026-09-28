package com.google.android.gms.internal.ads;

import java.io.EOFException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes4.dex */
public abstract class zzasr implements zzass {

    /* renamed from: b, reason: collision with root package name */
    public static final Logger f24284b = Logger.getLogger(zzasr.class.getName());

    /* renamed from: a, reason: collision with root package name */
    public final ThreadLocal f24285a = new zzasq();

    public abstract zzasv a(String str);

    /* JADX WARN: Multi-variable type inference failed */
    public final zzasv b(zziis zziisVar, zziir zziirVar) throws EOFException {
        int iM1;
        long jZzb;
        zzcgf zzcgfVar = (zzcgf) zziisVar;
        long jZzc = zzcgfVar.zzc();
        ThreadLocal threadLocal = this.f24285a;
        ((ByteBuffer) threadLocal.get()).rewind().limit(8);
        do {
            iM1 = zzcgfVar.M1((ByteBuffer) threadLocal.get());
            if (iM1 == 8) {
                ((ByteBuffer) threadLocal.get()).rewind();
                long jA = zzasu.a((ByteBuffer) threadLocal.get());
                if (jA < 8 && jA > 1) {
                    Level level = Level.SEVERE;
                    StringBuilder sb = new StringBuilder(80);
                    sb.append("Plausibility check failed: size < 8 (size = ");
                    sb.append(jA);
                    sb.append("). Stop parsing!");
                    f24284b.logp(level, "com.coremedia.iso.AbstractBoxParser", "parseBox", sb.toString());
                    return null;
                }
                byte[] bArr = new byte[4];
                ((ByteBuffer) threadLocal.get()).get(bArr);
                try {
                    String str = new String(bArr, "ISO-8859-1");
                    if (jA == 1) {
                        ((ByteBuffer) threadLocal.get()).limit(16);
                        zzcgfVar.M1((ByteBuffer) threadLocal.get());
                        ((ByteBuffer) threadLocal.get()).position(8);
                        jZzb = zzasu.b((ByteBuffer) threadLocal.get()) - 16;
                    } else {
                        jZzb = jA == 0 ? zzcgfVar.zzb() - zzcgfVar.zzc() : jA - 8;
                    }
                    if ("uuid".equals(str)) {
                        ((ByteBuffer) threadLocal.get()).limit(((ByteBuffer) threadLocal.get()).limit() + 16);
                        zzcgfVar.M1((ByteBuffer) threadLocal.get());
                        byte[] bArr2 = new byte[16];
                        for (int iPosition = ((ByteBuffer) threadLocal.get()).position() - 16; iPosition < ((ByteBuffer) threadLocal.get()).position(); iPosition++) {
                            bArr2[iPosition - (((ByteBuffer) threadLocal.get()).position() - 16)] = ((ByteBuffer) threadLocal.get()).get(iPosition);
                        }
                        jZzb -= 16;
                    }
                    long j2 = jZzb;
                    if (zziirVar instanceof zzasv) {
                    }
                    zzasv zzasvVarA = a(str);
                    ((ByteBuffer) threadLocal.get()).rewind();
                    zzasvVarA.a(zzcgfVar, (ByteBuffer) threadLocal.get(), j2, this);
                    return zzasvVarA;
                } catch (UnsupportedEncodingException e2) {
                    throw new RuntimeException(e2);
                }
            }
        } while (iM1 >= 0);
        zzcgfVar.h(jZzc);
        throw new EOFException();
    }
}
