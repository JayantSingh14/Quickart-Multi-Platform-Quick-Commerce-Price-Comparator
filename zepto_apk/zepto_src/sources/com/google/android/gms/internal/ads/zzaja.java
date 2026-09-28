package com.google.android.gms.internal.ads;

import android.util.SparseArray;
import java.io.EOFException;
import java.io.InterruptedIOException;
import java.math.RoundingMode;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import org.xbill.DNS.Type;
import org.xbill.DNS.WKSRecord;

/* loaded from: classes4.dex */
public final class zzaja implements zzaeo {
    public static final byte[] k0 = {49, 10, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 32, 45, 45, 62, 32, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 10};
    public static final byte[] l0;
    public static final byte[] m0;
    public static final byte[] n0;
    public static final UUID o0;
    public static final Map p0;
    public long A;
    public final SparseArray B;
    public boolean C;
    public long D;
    public int E;
    public long F;
    public long G;
    public int H;
    public boolean I;
    public long J;
    public long K;
    public long L;
    public boolean M;
    public int N;
    public long O;
    public long P;
    public int Q;
    public int R;
    public int[] S;
    public int T;
    public int U;
    public int V;
    public int W;
    public boolean X;
    public long Y;
    public int Z;

    /* renamed from: a, reason: collision with root package name */
    public final zzajc f23241a;
    public int a0;

    /* renamed from: b, reason: collision with root package name */
    public final SparseArray f23242b;
    public int b0;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f23243c;
    public boolean c0;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f23244d;
    public boolean d0;

    /* renamed from: e, reason: collision with root package name */
    public final zzalw f23245e;
    public boolean e0;

    /* renamed from: f, reason: collision with root package name */
    public final zzer f23246f;
    public int f0;

    /* renamed from: g, reason: collision with root package name */
    public final zzer f23247g;
    public byte g0;

    /* renamed from: h, reason: collision with root package name */
    public final zzer f23248h;
    public boolean h0;

    /* renamed from: i, reason: collision with root package name */
    public final zzer f23249i;
    public zzaer i0;

    /* renamed from: j, reason: collision with root package name */
    public final zzer f23250j;
    public final zzait j0;

    /* renamed from: k, reason: collision with root package name */
    public final zzer f23251k;

    /* renamed from: l, reason: collision with root package name */
    public final zzer f23252l;

    /* renamed from: m, reason: collision with root package name */
    public final zzer f23253m;
    public final zzer n;
    public final zzer o;
    public ByteBuffer p;
    public long q;
    public long r;
    public long s;
    public long t;
    public long u;
    public boolean v;
    public boolean w;
    public zzaiz x;
    public boolean y;
    public int z;

    static {
        String str = zzfj.f31254a;
        l0 = "Format: Start, End, ReadOrder, Layer, Style, Name, MarginL, MarginR, MarginV, Effect, Text".getBytes(StandardCharsets.UTF_8);
        m0 = new byte[]{68, 105, 97, 108, 111, 103, 117, 101, 58, 32, 48, 58, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 58, 48, 48, 58, 48, 48, 58, 48, 48, 44};
        n0 = new byte[]{87, 69, 66, 86, 84, 84, 10, 10, 48, 48, 58, 48, 48, 58, 48, 48, 46, 48, 48, 48, 32, 45, 45, 62, 32, 48, 48, 58, 48, 48, 58, 48, 48, 46, 48, 48, 48, 10};
        o0 = new UUID(72057594037932032L, -9223371306706625679L);
        HashMap map = new HashMap();
        android.support.v4.media.b.z(0, map, "htc_video_rotA-000", 90, "htc_video_rotA-090");
        android.support.v4.media.b.z(180, map, "htc_video_rotA-180", 270, "htc_video_rotA-270");
        p0 = Collections.unmodifiableMap(map);
    }

    @Deprecated
    public zzaja() {
        this(new zzait(), 2, zzalw.f23510a);
    }

    public static byte[] n(long j2, long j3, String str) {
        zzgqa.a(j2 != -9223372036854775807L);
        Locale locale = Locale.US;
        int i2 = (int) (j2 / 3600000000L);
        Integer numValueOf = Integer.valueOf(i2);
        long j4 = j2 - (i2 * 3600000000L);
        int i3 = (int) (j4 / 60000000);
        Integer numValueOf2 = Integer.valueOf(i3);
        long j5 = j4 - (i3 * 60000000);
        int i4 = (int) (j5 / 1000000);
        String str2 = String.format(locale, str, numValueOf, numValueOf2, Integer.valueOf(i4), Integer.valueOf((int) ((j5 - (i4 * 1000000)) / j3)));
        String str3 = zzfj.f31254a;
        return str2.getBytes(StandardCharsets.UTF_8);
    }

    @Override // com.google.android.gms.internal.ads.zzaeo
    public final void a(long j2, long j3) {
        this.L = -9223372036854775807L;
        this.N = 0;
        zzait zzaitVar = this.j0;
        zzaitVar.f23217e = 0;
        zzaitVar.f23214b.clear();
        zzajc zzajcVar = zzaitVar.f23215c;
        zzajcVar.f23258b = 0;
        zzajcVar.f23259c = 0;
        zzajc zzajcVar2 = this.f23241a;
        zzajcVar2.f23258b = 0;
        zzajcVar2.f23259c = 0;
        l();
        this.C = false;
        this.D = -9223372036854775807L;
        this.E = -1;
        this.F = -1L;
        this.G = -1L;
        if (!this.y) {
            this.B.clear();
        }
        int i2 = 0;
        while (true) {
            SparseArray sparseArray = this.f23242b;
            if (i2 >= sparseArray.size()) {
                return;
            }
            zzagb zzagbVar = ((zzaiz) sparseArray.valueAt(i2)).V;
            if (zzagbVar != null) {
                zzagbVar.f22982b = false;
                zzagbVar.f22983c = 0;
            }
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaeo
    public final void b(zzaer zzaerVar) {
        if (this.f23244d) {
            zzaerVar = new zzalz(zzaerVar, this.f23245e);
        }
        this.i0 = zzaerVar;
    }

    @Override // com.google.android.gms.internal.ads.zzaeo
    public final boolean c(zzaep zzaepVar) throws EOFException, InterruptedIOException {
        zzajb zzajbVar = new zzajb();
        zzaef zzaefVar = (zzaef) zzaepVar;
        long j2 = zzaefVar.f22871c;
        long j3 = 1024;
        if (j2 != -1 && j2 <= 1024) {
            j3 = j2;
        }
        zzer zzerVar = zzajbVar.f23254a;
        zzaef zzaefVar2 = (zzaef) zzaepVar;
        zzaefVar2.t(zzerVar.f30144a, 0, 4, false);
        long jP = zzerVar.P();
        zzajbVar.f23255b = 4;
        while (true) {
            if (jP != 440786851) {
                int i2 = (int) j3;
                int i3 = zzajbVar.f23255b + 1;
                zzajbVar.f23255b = i3;
                if (i3 == i2) {
                    break;
                }
                zzaefVar2.t(zzerVar.f30144a, 0, 1, false);
                jP = ((jP << 8) & (-256)) | (zzerVar.f30144a[0] & 255);
            } else {
                long jA = zzajbVar.a(zzaefVar);
                long j4 = zzajbVar.f23255b;
                if (jA != Long.MIN_VALUE) {
                    long j5 = j4 + jA;
                    if (j2 == -1 || j5 < j2) {
                        while (true) {
                            long j6 = zzajbVar.f23255b;
                            if (j6 < j5) {
                                if (zzajbVar.a(zzaefVar) != Long.MIN_VALUE) {
                                    long jA2 = zzajbVar.a(zzaefVar);
                                    if (jA2 < 0) {
                                        break;
                                    }
                                    if (jA2 != 0) {
                                        int i4 = (int) jA2;
                                        zzaefVar2.f(i4, false);
                                        zzajbVar.f23255b += i4;
                                    }
                                } else {
                                    break;
                                }
                            } else if (j6 == j5) {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:318:0x05ac, code lost:
    
        r29 = true;
        r5 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:342:0x0613, code lost:
    
        r10 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:623:0x0ced, code lost:
    
        if (r29 == false) goto L665;
     */
    /* JADX WARN: Code restructure failed: missing block: B:624:0x0cef, code lost:
    
        r2 = ((com.google.android.gms.internal.ads.zzaef) r52).zzn();
     */
    /* JADX WARN: Code restructure failed: missing block: B:625:0x0cf9, code lost:
    
        if (r51.I == false) goto L628;
     */
    /* JADX WARN: Code restructure failed: missing block: B:626:0x0cfb, code lost:
    
        r51.K = r2;
        r53.f22954a = r51.J;
        r51.I = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:627:0x0d05, code lost:
    
        return 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:629:0x0d0a, code lost:
    
        if (r51.y == false) goto L668;
     */
    /* JADX WARN: Code restructure failed: missing block: B:630:0x0d0c, code lost:
    
        r2 = r51.K;
     */
    /* JADX WARN: Code restructure failed: missing block: B:631:0x0d12, code lost:
    
        if (r2 == (-1)) goto L669;
     */
    /* JADX WARN: Code restructure failed: missing block: B:632:0x0d14, code lost:
    
        r53.f22954a = r2;
        r51.K = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:633:0x0d18, code lost:
    
        return 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:634:0x0d19, code lost:
    
        r6 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:635:0x0d1c, code lost:
    
        r6 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:636:0x0d1d, code lost:
    
        r1 = r51.f23242b;
     */
    /* JADX WARN: Code restructure failed: missing block: B:637:0x0d23, code lost:
    
        if (r6 >= r1.size()) goto L688;
     */
    /* JADX WARN: Code restructure failed: missing block: B:638:0x0d25, code lost:
    
        r1 = (com.google.android.gms.internal.ads.zzaiz) r1.valueAt(r6);
        r1.a0.getClass();
        r2 = r1.V;
     */
    /* JADX WARN: Code restructure failed: missing block: B:639:0x0d32, code lost:
    
        if (r2 == null) goto L690;
     */
    /* JADX WARN: Code restructure failed: missing block: B:640:0x0d34, code lost:
    
        r2.c(r1.a0, r1.f23238k);
     */
    /* JADX WARN: Code restructure failed: missing block: B:641:0x0d3b, code lost:
    
        r6 = r6 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:642:0x0d40, code lost:
    
        return -1;
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:287:0x04f5  */
    /* JADX WARN: Removed duplicated region for block: B:357:0x0660 A[LOOP:1: B:6:0x0012->B:357:0x0660, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:553:0x0b2c  */
    /* JADX WARN: Removed duplicated region for block: B:672:0x0670 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:673:0x0752 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:674:0x0ae2 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:675:0x0c1e A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:676:0x0cd6 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x01ac  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x01b8  */
    @Override // com.google.android.gms.internal.ads.zzaeo
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int d(com.google.android.gms.internal.ads.zzaep r52, com.google.android.gms.internal.ads.zzafo r53) throws com.google.android.gms.internal.ads.zzat, java.io.EOFException, java.io.InterruptedIOException {
        /*
            Method dump skipped, instructions count: 4058
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaja.d(com.google.android.gms.internal.ads.zzaep, com.google.android.gms.internal.ads.zzafo):int");
    }

    public final void e() {
        if (!this.w) {
            return;
        }
        int i2 = 0;
        while (true) {
            SparseArray sparseArray = this.f23242b;
            if (i2 >= sparseArray.size()) {
                zzaer zzaerVar = this.i0;
                zzaerVar.getClass();
                zzaerVar.h();
                this.w = false;
                return;
            }
            if (((zzaiz) sparseArray.valueAt(i2)).W) {
                return;
            } else {
                i2++;
            }
        }
    }

    public final void f(int i2, long j2) throws zzat {
        boolean z;
        if (i2 == 240) {
            if (this.y) {
                return;
            }
            h(i2);
            if (this.G == -1) {
                this.G = j2;
                return;
            }
            return;
        }
        if (i2 == 241) {
            if (this.y) {
                return;
            }
            h(i2);
            if (this.F == -1) {
                this.F = j2;
                return;
            }
            return;
        }
        if (i2 == 20529) {
            if (j2 == 0) {
                return;
            }
            StringBuilder sb = new StringBuilder(String.valueOf(j2).length() + 35);
            sb.append("ContentEncodingOrder ");
            sb.append(j2);
            sb.append(" not supported");
            throw zzat.a(null, sb.toString());
        }
        if (i2 == 20530) {
            if (j2 == 1) {
                return;
            }
            StringBuilder sb2 = new StringBuilder(String.valueOf(j2).length() + 35);
            sb2.append("ContentEncodingScope ");
            sb2.append(j2);
            sb2.append(" not supported");
            throw zzat.a(null, sb2.toString());
        }
        switch (i2) {
            case WKSRecord.Service.CISCO_TNA /* 131 */:
                int i3 = (int) j2;
                if (i3 == 1) {
                    g(i2);
                    this.x.f23232e = 2;
                    return;
                }
                if (i3 == 2) {
                    g(i2);
                    this.x.f23232e = 1;
                    return;
                } else if (i3 == 17) {
                    g(i2);
                    this.x.f23232e = 3;
                    return;
                } else if (i3 != 33) {
                    g(i2);
                    this.x.f23232e = -1;
                    return;
                } else {
                    g(i2);
                    this.x.f23232e = 5;
                    return;
                }
            case WKSRecord.Service.PROFILE /* 136 */:
                z = j2 == 1;
                g(i2);
                this.x.Y = z;
                return;
            case 155:
                this.P = o(j2);
                return;
            case 159:
                g(i2);
                this.x.Q = (int) j2;
                return;
            case 176:
                g(i2);
                this.x.n = (int) j2;
                return;
            case 179:
                if (this.y) {
                    return;
                }
                h(i2);
                this.D = o(j2);
                return;
            case 186:
                g(i2);
                this.x.o = (int) j2;
                return;
            case 215:
                g(i2);
                this.x.f23231d = (int) j2;
                return;
            case 231:
                this.L = o(j2);
                return;
            case 238:
                this.W = (int) j2;
                return;
            case 247:
                if (this.y) {
                    return;
                }
                h(i2);
                this.E = (int) j2;
                return;
            case Type.IXFR /* 251 */:
                this.X = true;
                return;
            case 16871:
                g(i2);
                this.x.f23235h = (int) j2;
                return;
            case 16980:
                if (j2 == 3) {
                    return;
                }
                StringBuilder sb3 = new StringBuilder(String.valueOf(j2).length() + 30);
                sb3.append("ContentCompAlgo ");
                sb3.append(j2);
                sb3.append(" not supported");
                throw zzat.a(null, sb3.toString());
            case 17029:
                if (j2 < 1 || j2 > 2) {
                    StringBuilder sb4 = new StringBuilder(String.valueOf(j2).length() + 33);
                    sb4.append("DocTypeReadVersion ");
                    sb4.append(j2);
                    sb4.append(" not supported");
                    throw zzat.a(null, sb4.toString());
                }
                return;
            case 17143:
                if (j2 == 1) {
                    return;
                }
                StringBuilder sb5 = new StringBuilder(String.valueOf(j2).length() + 30);
                sb5.append("EBMLReadVersion ");
                sb5.append(j2);
                sb5.append(" not supported");
                throw zzat.a(null, sb5.toString());
            case 18401:
                if (j2 == 5) {
                    return;
                }
                StringBuilder sb6 = new StringBuilder(String.valueOf(j2).length() + 29);
                sb6.append("ContentEncAlgo ");
                sb6.append(j2);
                sb6.append(" not supported");
                throw zzat.a(null, sb6.toString());
            case 18408:
                if (j2 == 1) {
                    return;
                }
                StringBuilder sb7 = new StringBuilder(String.valueOf(j2).length() + 36);
                sb7.append("AESSettingsCipherMode ");
                sb7.append(j2);
                sb7.append(" not supported");
                throw zzat.a(null, sb7.toString());
            case 21420:
                this.A = j2 + this.r;
                return;
            case 21432:
                int i4 = (int) j2;
                g(i2);
                if (i4 == 0) {
                    this.x.y = 0;
                    return;
                }
                if (i4 == 1) {
                    this.x.y = 2;
                    return;
                } else if (i4 == 3) {
                    this.x.y = 1;
                    return;
                } else {
                    if (i4 != 15) {
                        return;
                    }
                    this.x.y = 3;
                    return;
                }
            case 21680:
                g(i2);
                this.x.q = (int) j2;
                return;
            case 21682:
                g(i2);
                this.x.s = (int) j2;
                return;
            case 21690:
                g(i2);
                this.x.r = (int) j2;
                return;
            case 21930:
                z = j2 == 1;
                g(i2);
                this.x.X = z;
                return;
            case 21938:
                g(i2);
                zzaiz zzaizVar = this.x;
                zzaizVar.z = true;
                zzaizVar.p = (int) j2;
                return;
            case 21998:
                g(i2);
                this.x.f23234g = (int) j2;
                return;
            case 22186:
                g(i2);
                this.x.T = j2;
                return;
            case 22203:
                g(i2);
                this.x.U = j2;
                return;
            case 25188:
                g(i2);
                this.x.R = (int) j2;
                return;
            case 30114:
                this.Y = j2;
                return;
            case 30321:
                int i5 = (int) j2;
                g(i2);
                if (i5 == 0) {
                    this.x.t = 0;
                    return;
                }
                if (i5 == 1) {
                    this.x.t = 1;
                    return;
                } else if (i5 == 2) {
                    this.x.t = 2;
                    return;
                } else {
                    if (i5 != 3) {
                        return;
                    }
                    this.x.t = 3;
                    return;
                }
            case 2352003:
                g(i2);
                this.x.f23233f = (int) j2;
                return;
            case 2807729:
                this.s = j2;
                return;
            default:
                switch (i2) {
                    case 21945:
                        int i6 = (int) j2;
                        g(i2);
                        if (i6 == 1) {
                            this.x.C = 2;
                            return;
                        } else {
                            if (i6 != 2) {
                                return;
                            }
                            this.x.C = 1;
                            return;
                        }
                    case 21946:
                        g(i2);
                        int iC = zzi.c((int) j2);
                        if (iC != -1) {
                            this.x.B = iC;
                            return;
                        }
                        return;
                    case 21947:
                        g(i2);
                        this.x.z = true;
                        int iB = zzi.b((int) j2);
                        if (iB != -1) {
                            this.x.A = iB;
                            return;
                        }
                        return;
                    case 21948:
                        g(i2);
                        this.x.D = (int) j2;
                        return;
                    case 21949:
                        g(i2);
                        this.x.E = (int) j2;
                        return;
                    default:
                        return;
                }
        }
    }

    public final void g(int i2) throws zzat {
        if (this.x != null) {
            return;
        }
        StringBuilder sb = new StringBuilder(String.valueOf(i2).length() + 32);
        sb.append("Element ");
        sb.append(i2);
        sb.append(" must be in a TrackEntry");
        throw zzat.a(null, sb.toString());
    }

    public final void h(int i2) throws zzat {
        if (this.C) {
            return;
        }
        StringBuilder sb = new StringBuilder(String.valueOf(i2).length() + 26);
        sb.append("Element ");
        sb.append(i2);
        sb.append(" must be in a Cues");
        throw zzat.a(null, sb.toString());
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:35:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00e2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void i(com.google.android.gms.internal.ads.zzaiz r18, long r19, int r21, int r22, int r23) {
        /*
            Method dump skipped, instructions count: 282
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaja.i(com.google.android.gms.internal.ads.zzaiz, long, int, int, int):void");
    }

    public final void j(zzaef zzaefVar, int i2) throws EOFException, InterruptedIOException {
        zzer zzerVar = this.f23248h;
        if (zzerVar.f30146c >= i2) {
            return;
        }
        byte[] bArr = zzerVar.f30144a;
        if (bArr.length < i2) {
            int length = bArr.length;
            zzerVar.A(Math.max(length + length, i2));
        }
        byte[] bArr2 = zzerVar.f30144a;
        int i3 = zzerVar.f30146c;
        zzaefVar.v(bArr2, i3, i2 - i3, false);
        zzerVar.C(i2);
    }

    public final int k(zzaef zzaefVar, zzaiz zzaizVar, int i2, boolean z) throws zzat, EOFException, InterruptedIOException {
        int iF;
        int iF2;
        int i3;
        String str = zzaizVar.f23230c;
        if ("S_TEXT/UTF8".equals(str)) {
            m(zzaefVar, k0, i2);
            int i4 = this.a0;
            l();
            return i4;
        }
        if ("S_TEXT/ASS".equals(str) || "S_TEXT/SSA".equals(str)) {
            m(zzaefVar, m0, i2);
            int i5 = this.a0;
            l();
            return i5;
        }
        if ("S_TEXT/WEBVTT".equals(str)) {
            m(zzaefVar, n0, i2);
            int i6 = this.a0;
            l();
            return i6;
        }
        if (zzaizVar.W) {
            zzaizVar.b0.getClass();
            zzer zzerVar = new zzer(i2);
            if (zzaefVar.t(zzerVar.f30144a, 0, i2, true)) {
                zzaefVar.f22874f = 0;
                if (zzaen.a(zzerVar.J()) == 1 && zzerVar.B() >= 10) {
                    byte[] bArr = new byte[10];
                    zzerVar.H(0, bArr, 10);
                    zzerVar.E(0);
                    int iB = zzaen.b(bArr);
                    if (zzerVar.B() >= iB + 4) {
                        zzerVar.G(iB);
                        if (zzaen.a(zzerVar.b()) == 2) {
                            zzv zzvVar = zzaizVar.b0;
                            zzvVar.getClass();
                            zzt zztVar = new zzt(zzvVar);
                            zztVar.e("audio/vnd.dts.hd");
                            zzaizVar.b0 = new zzv(zztVar);
                        }
                    }
                }
            }
            zzaizVar.a0.c(zzaizVar.b0);
            zzaizVar.W = false;
            e();
        }
        zzaga zzagaVar = zzaizVar.a0;
        boolean z2 = this.c0;
        zzer zzerVar2 = this.f23251k;
        if (!z2) {
            boolean z3 = zzaizVar.f23236i;
            zzer zzerVar3 = this.f23248h;
            if (z3) {
                this.V &= -1073741825;
                if (!this.d0) {
                    zzaefVar.v(zzerVar3.f30144a, 0, 1, false);
                    this.Z++;
                    byte b2 = zzerVar3.f30144a[0];
                    if ((b2 & 128) == 128) {
                        throw zzat.a(null, "Extension bit is set in signal byte");
                    }
                    this.g0 = b2;
                    this.d0 = true;
                }
                byte b3 = this.g0;
                if ((b3 & 1) == 1) {
                    int i7 = b3 & 2;
                    this.V |= 1073741824;
                    if (!this.h0) {
                        zzer zzerVar4 = this.f23253m;
                        zzaefVar.v(zzerVar4.f30144a, 0, 8, false);
                        this.Z += 8;
                        this.h0 = true;
                        zzerVar3.f30144a[0] = (byte) ((i7 != 2 ? 0 : 128) | 8);
                        zzerVar3.E(0);
                        zzagaVar.d(zzerVar3, 1, 1);
                        this.a0++;
                        zzerVar4.E(0);
                        zzagaVar.d(zzerVar4, 8, 1);
                        this.a0 += 8;
                    }
                    if (i7 == 2) {
                        if (!this.e0) {
                            zzaefVar.v(zzerVar3.f30144a, 0, 1, false);
                            this.Z++;
                            zzerVar3.E(0);
                            this.f0 = zzerVar3.K();
                            this.e0 = true;
                        }
                        int i8 = this.f0 * 4;
                        zzerVar3.y(i8);
                        zzaefVar.v(zzerVar3.f30144a, 0, i8, false);
                        this.Z += i8;
                        int i9 = (this.f0 >> 1) + 1;
                        int i10 = (i9 * 6) + 2;
                        ByteBuffer byteBuffer = this.p;
                        if (byteBuffer == null || byteBuffer.capacity() < i10) {
                            this.p = ByteBuffer.allocate(i10);
                        }
                        this.p.position(0);
                        this.p.putShort((short) i9);
                        int i11 = 0;
                        int i12 = 0;
                        while (true) {
                            i3 = this.f0;
                            if (i11 >= i3) {
                                break;
                            }
                            int iH = zzerVar3.h();
                            int i13 = iH - i12;
                            if (i11 % 2 == 0) {
                                this.p.putShort((short) i13);
                            } else {
                                this.p.putInt(i13);
                            }
                            i11++;
                            i12 = iH;
                        }
                        int i14 = (i2 - this.Z) - i12;
                        if ((i3 & 1) == 1) {
                            this.p.putInt(i14);
                        } else {
                            this.p.putShort((short) i14);
                            this.p.putInt(0);
                        }
                        byte[] bArrArray = this.p.array();
                        zzer zzerVar5 = this.n;
                        zzerVar5.z(i10, bArrArray);
                        zzagaVar.d(zzerVar5, i10, 1);
                        this.a0 += i10;
                    }
                }
            } else {
                byte[] bArr2 = zzaizVar.f23237j;
                if (bArr2 != null) {
                    zzerVar2.z(bArr2.length, bArr2);
                }
            }
            if (!"A_OPUS".equals(zzaizVar.f23230c) ? zzaizVar.f23234g > 0 : z) {
                this.V |= 268435456;
                this.o.y(0);
                int i15 = (zzerVar2.f30146c + i2) - this.Z;
                zzerVar3.y(4);
                byte[] bArr3 = zzerVar3.f30144a;
                bArr3[0] = (byte) ((i15 >> 24) & 255);
                bArr3[1] = (byte) ((i15 >> 16) & 255);
                bArr3[2] = (byte) ((i15 >> 8) & 255);
                bArr3[3] = (byte) (i15 & 255);
                zzagaVar.d(zzerVar3, 4, 2);
                this.a0 += 4;
            }
            this.c0 = true;
        }
        int i16 = i2 + zzerVar2.f30146c;
        String str2 = zzaizVar.f23230c;
        if (!"V_MPEG4/ISO/AVC".equals(str2) && !"V_MPEGH/ISO/HEVC".equals(str2)) {
            if (zzaizVar.V != null) {
                zzgqa.f(zzerVar2.f30146c == 0);
                zzaizVar.V.a(zzaefVar);
            }
            while (true) {
                int i17 = this.Z;
                if (i17 >= i16) {
                    break;
                }
                int i18 = i16 - i17;
                int iB2 = zzerVar2.B();
                if (iB2 > 0) {
                    iF2 = Math.min(i18, iB2);
                    zzagaVar.b(iF2, zzerVar2);
                } else {
                    iF2 = zzagaVar.f(zzaefVar, i18, false);
                }
                this.Z += iF2;
                this.a0 += iF2;
            }
        } else {
            zzer zzerVar6 = this.f23247g;
            byte[] bArr4 = zzerVar6.f30144a;
            bArr4[0] = 0;
            bArr4[1] = 0;
            bArr4[2] = 0;
            int i19 = zzaizVar.c0;
            int i20 = 4 - i19;
            while (this.Z < i16) {
                int i21 = this.b0;
                if (i21 == 0) {
                    int iMin = Math.min(i19, zzerVar2.B());
                    zzaefVar.v(bArr4, i20 + iMin, i19 - iMin, false);
                    if (iMin > 0) {
                        zzerVar2.H(i20, bArr4, iMin);
                    }
                    this.Z += i19;
                    zzerVar6.E(0);
                    this.b0 = zzerVar6.h();
                    zzer zzerVar7 = this.f23246f;
                    zzerVar7.E(0);
                    zzagaVar.b(4, zzerVar7);
                    this.a0 += 4;
                } else {
                    int iB3 = zzerVar2.B();
                    if (iB3 > 0) {
                        iF = Math.min(i21, iB3);
                        zzagaVar.b(iF, zzerVar2);
                    } else {
                        iF = zzagaVar.f(zzaefVar, i21, false);
                    }
                    this.Z += iF;
                    this.a0 += iF;
                    this.b0 -= iF;
                }
            }
        }
        if ("A_VORBIS".equals(zzaizVar.f23230c)) {
            zzer zzerVar8 = this.f23249i;
            zzerVar8.E(0);
            zzagaVar.b(4, zzerVar8);
            this.a0 += 4;
        }
        int i22 = this.a0;
        l();
        return i22;
    }

    public final void l() {
        this.Z = 0;
        this.a0 = 0;
        this.b0 = 0;
        this.c0 = false;
        this.d0 = false;
        this.e0 = false;
        this.f0 = 0;
        this.g0 = (byte) 0;
        this.h0 = false;
        this.f23251k.y(0);
    }

    public final void m(zzaef zzaefVar, byte[] bArr, int i2) throws EOFException, InterruptedIOException {
        int length = bArr.length;
        int i3 = length + i2;
        zzer zzerVar = this.f23252l;
        byte[] bArr2 = zzerVar.f30144a;
        if (bArr2.length < i3) {
            byte[] bArrCopyOf = Arrays.copyOf(bArr, i3 + i2);
            zzerVar.z(bArrCopyOf.length, bArrCopyOf);
        } else {
            System.arraycopy(bArr, 0, bArr2, 0, length);
        }
        zzaefVar.v(zzerVar.f30144a, length, i2, false);
        zzerVar.E(0);
        zzerVar.C(i3);
    }

    public final long o(long j2) throws zzat {
        long j3 = this.s;
        if (j3 != -9223372036854775807L) {
            return zzfj.u(j2, j3, 1000L, RoundingMode.DOWN);
        }
        throw zzat.a(null, "Can't scale timecode prior to timecodeScale being set.");
    }

    @Override // com.google.android.gms.internal.ads.zzaeo
    public final void zzf() {
    }

    public zzaja(zzait zzaitVar, int i2, zzalw zzalwVar) {
        this.r = -1L;
        this.s = -9223372036854775807L;
        this.t = -9223372036854775807L;
        this.u = -9223372036854775807L;
        this.D = -9223372036854775807L;
        this.E = -1;
        this.F = -1L;
        this.G = -1L;
        this.H = -1;
        this.J = -1L;
        this.K = -1L;
        this.L = -9223372036854775807L;
        this.j0 = zzaitVar;
        zzaitVar.f23216d = new zzaiv(this);
        this.f23245e = zzalwVar;
        this.B = new SparseArray();
        this.f23243c = true;
        this.f23244d = (i2 & 2) == 0;
        this.f23241a = new zzajc();
        this.f23242b = new SparseArray();
        this.f23248h = new zzer(4);
        this.f23249i = new zzer(ByteBuffer.allocate(4).putInt(-1).array());
        this.f23250j = new zzer(4);
        this.f23246f = new zzer(zzgm.f32888a);
        this.f23247g = new zzer(4);
        this.f23251k = new zzer();
        this.f23252l = new zzer();
        this.f23253m = new zzer(8);
        this.n = new zzer();
        this.o = new zzer();
        this.S = new int[1];
        this.w = true;
    }
}
