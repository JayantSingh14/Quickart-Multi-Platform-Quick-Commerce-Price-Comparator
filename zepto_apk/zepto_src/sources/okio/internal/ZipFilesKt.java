package okio.internal;

import android.support.v4.media.b;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;
import okio.Buffer;
import okio.Path;
import okio.RealBufferedSource;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class ZipFilesKt {
    public static final LinkedHashMap a(ArrayList arrayList) {
        String str = Path.f56972b;
        Path pathA = Path.Companion.a("/", false);
        LinkedHashMap linkedHashMapI = MapsKt.i(new Pair(pathA, new ZipEntry(pathA, true, null, 0L, 0L, 0L, 0, 0L, 0, 0, null, null, null, 65532)));
        for (ZipEntry zipEntry : CollectionsKt.Y(new Comparator() { // from class: okio.internal.ZipFilesKt$buildIndex$$inlined$sortedBy$1
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return ComparisonsKt.a(((ZipEntry) obj).f57047a, ((ZipEntry) obj2).f57047a);
            }
        }, arrayList)) {
            if (((ZipEntry) linkedHashMapI.put(zipEntry.f57047a, zipEntry)) == null) {
                while (true) {
                    Path path = zipEntry.f57047a;
                    Path pathC = path.c();
                    if (pathC != null) {
                        ZipEntry zipEntry2 = (ZipEntry) linkedHashMapI.get(pathC);
                        if (zipEntry2 != null) {
                            zipEntry2.q.add(path);
                            break;
                        }
                        ZipEntry zipEntry3 = new ZipEntry(pathC, true, null, 0L, 0L, 0L, 0, 0L, 0, 0, null, null, null, 65532);
                        linkedHashMapI.put(pathC, zipEntry3);
                        zipEntry3.q.add(path);
                        zipEntry = zipEntry3;
                    }
                }
            }
        }
        return linkedHashMapI;
    }

    public static final String b(int i2) {
        StringBuilder sb = new StringBuilder("0x");
        String string = Integer.toString(i2, CharsKt.checkRadix(16));
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        sb.append(string);
        return sb.toString();
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x01c9, code lost:
    
        return r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x01ca, code lost:
    
        throw r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x01d3, code lost:
    
        throw new java.io.IOException("unsupported zip: spanned");
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0060, code lost:
    
        if (r14 != (r11.T() & 65535)) goto L104;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0062, code lost:
    
        if (r0 != 0) goto L104;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0064, code lost:
    
        if (r10 != 0) goto L104;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0066, code lost:
    
        r19 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x006a, code lost:
    
        r11.k0(4);
        r18 = r11.T() & 65535;
        r13 = new okio.internal.EocdRecord(r14, r11.D() & 4294967295L, r18);
        r11.V(r18);
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x008b, code lost:
    
        r11.close();
        r5 = r5 - 20;
        r9 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0095, code lost:
    
        if (r5 <= r19) goto L73;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0097, code lost:
    
        r5 = okio.Okio.d(r4.x(r5));
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x00a6, code lost:
    
        if (r5.D() != 117853008) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x00a8, code lost:
    
        r6 = r5.D();
        r10 = r5.N();
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x00b5, code lost:
    
        if (r5.D() != 1) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x00b7, code lost:
    
        if (r6 != 0) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x00b9, code lost:
    
        r6 = okio.Okio.d(r4.x(r10));
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x00c1, code lost:
    
        r8 = r6.D();
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x00c8, code lost:
    
        if (r8 != 101075792) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x00ca, code lost:
    
        r6.k0(12);
        r8 = r6.D();
        r10 = r6.D();
        r22 = r6.N();
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00e1, code lost:
    
        if (r22 != r6.N()) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x00e3, code lost:
    
        if (r8 != 0) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00e5, code lost:
    
        if (r10 != 0) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00e7, code lost:
    
        r6.k0(8);
        r21 = new okio.internal.EocdRecord(r22, r6.N(), r18);
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00f7, code lost:
    
        r0 = kotlin.Unit.f53572a;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00fc, code lost:
    
        r0 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00fe, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0102, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0103, code lost:
    
        r7 = r0;
        r13 = r21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x010c, code lost:
    
        throw new java.io.IOException("unsupported zip: spanned");
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x010d, code lost:
    
        r7 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0135, code lost:
    
        throw new java.io.IOException("bad zip: expected " + b(101075792) + " but was " + b(r8));
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0136, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x013c, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x013d, code lost:
    
        kotlin.ExceptionsKt.a(r7, r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0140, code lost:
    
        r0 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0144, code lost:
    
        throw r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0145, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x014d, code lost:
    
        throw new java.io.IOException("unsupported zip: spanned");
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x014e, code lost:
    
        r0 = kotlin.Unit.f53572a;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0153, code lost:
    
        r0 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0155, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x015b, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x015c, code lost:
    
        kotlin.ExceptionsKt.a(r0, r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x015f, code lost:
    
        r0 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0160, code lost:
    
        if (r0 == null) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x0163, code lost:
    
        throw r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x0168, code lost:
    
        r5 = new java.util.ArrayList();
        r6 = okio.Okio.d(r4.x(r13.f57037b));
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x0177, code lost:
    
        r7 = r13.f57036a;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x017d, code lost:
    
        r0 = e(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x0187, code lost:
    
        if (r0.f57054h < r13.f57037b) goto L79;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x0193, code lost:
    
        if (((java.lang.Boolean) r29.invoke(r0)).booleanValue() != false) goto L81;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x0195, code lost:
    
        r5.add(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x0199, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x019c, code lost:
    
        r19 = r19 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x01a8, code lost:
    
        throw new java.io.IOException("bad zip: local file header offset >= central directory offset");
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x01a9, code lost:
    
        r0 = kotlin.Unit.f53572a;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x01af, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x01b0, code lost:
    
        r9 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x01b6, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x01b7, code lost:
    
        kotlin.ExceptionsKt.a(r0, r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x01ba, code lost:
    
        r9 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x01bb, code lost:
    
        if (r9 == null) goto L98;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x01bd, code lost:
    
        r3 = new okio.ZipFileSystem(r27, r28, a(r5));
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x01c6, code lost:
    
        r4.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0043, code lost:
    
        r0 = r11.T() & 65535;
        r10 = r11.T() & 65535;
        r14 = r11.T() & 65535;
     */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0143  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0144 A[Catch: all -> 0x0145, TryCatch #2 {all -> 0x0145, blocks: (B:19:0x009f, B:21:0x00a8, B:24:0x00b9, B:53:0x0144, B:49:0x013d, B:56:0x0148, B:57:0x014d, B:58:0x014e, B:46:0x0138), top: B:127:0x009f, outer: #1, inners: #12 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final okio.ZipFileSystem c(okio.Path r27, okio.FileSystem r28, kotlin.jvm.functions.Function1 r29) {
        /*
            Method dump skipped, instructions count: 529
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.internal.ZipFilesKt.c(okio.Path, okio.FileSystem, kotlin.jvm.functions.Function1):okio.ZipFileSystem");
    }

    public static final ZipEntry e(final RealBufferedSource realBufferedSource) throws IOException {
        Intrinsics.checkNotNullParameter(realBufferedSource, "<this>");
        int iD = realBufferedSource.D();
        if (iD != 33639248) {
            throw new IOException("bad zip: expected " + b(33639248) + " but was " + b(iD));
        }
        realBufferedSource.k0(4L);
        short sT = realBufferedSource.T();
        int i2 = sT & 65535;
        if ((sT & 1) != 0) {
            throw new IOException("unsupported zip: general purpose bit flag=" + b(i2));
        }
        int iT = realBufferedSource.T() & 65535;
        int iT2 = realBufferedSource.T() & 65535;
        int iT3 = realBufferedSource.T() & 65535;
        long jD = realBufferedSource.D() & 4294967295L;
        final Ref.LongRef longRef = new Ref.LongRef();
        longRef.f53800a = realBufferedSource.D() & 4294967295L;
        final Ref.LongRef longRef2 = new Ref.LongRef();
        longRef2.f53800a = realBufferedSource.D() & 4294967295L;
        int iT4 = realBufferedSource.T() & 65535;
        int iT5 = realBufferedSource.T() & 65535;
        int iT6 = 65535 & realBufferedSource.T();
        realBufferedSource.k0(8L);
        final Ref.LongRef longRef3 = new Ref.LongRef();
        longRef3.f53800a = realBufferedSource.D() & 4294967295L;
        String strV = realBufferedSource.V(iT4);
        if (StringsKt.o(strV, (char) 0)) {
            throw new IOException("bad zip: filename contains 0x00");
        }
        final long j2 = longRef2.f53800a == 4294967295L ? 8 : 0L;
        if (longRef.f53800a == 4294967295L) {
            j2 += 8;
        }
        if (longRef3.f53800a == 4294967295L) {
            j2 += 8;
        }
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        final Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
        final Ref.ObjectRef objectRef3 = new Ref.ObjectRef();
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        f(realBufferedSource, iT5, new Function2<Integer, Long, Unit>() { // from class: okio.internal.ZipFilesKt$readCentralDirectoryZipEntry$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) throws IOException {
                int iIntValue = ((Number) obj).intValue();
                long jLongValue = ((Number) obj2).longValue();
                final RealBufferedSource realBufferedSource2 = realBufferedSource;
                if (iIntValue == 1) {
                    Ref.BooleanRef booleanRef2 = booleanRef;
                    if (booleanRef2.f53798a) {
                        throw new IOException("bad zip: zip64 extra repeated");
                    }
                    booleanRef2.f53798a = true;
                    if (jLongValue < j2) {
                        throw new IOException("bad zip: zip64 extra too short");
                    }
                    Ref.LongRef longRef4 = longRef2;
                    long jN = longRef4.f53800a;
                    if (jN == 4294967295L) {
                        jN = realBufferedSource2.N();
                    }
                    longRef4.f53800a = jN;
                    Ref.LongRef longRef5 = longRef;
                    longRef5.f53800a = longRef5.f53800a == 4294967295L ? realBufferedSource2.N() : 0L;
                    Ref.LongRef longRef6 = longRef3;
                    longRef6.f53800a = longRef6.f53800a == 4294967295L ? realBufferedSource2.N() : 0L;
                } else if (iIntValue == 10) {
                    if (jLongValue < 4) {
                        throw new IOException("bad zip: NTFS extra too short");
                    }
                    realBufferedSource2.k0(4L);
                    final Ref.ObjectRef objectRef4 = objectRef3;
                    final Ref.ObjectRef objectRef5 = objectRef;
                    final Ref.ObjectRef objectRef6 = objectRef2;
                    ZipFilesKt.f(realBufferedSource2, (int) (jLongValue - 4), new Function2<Integer, Long, Unit>() { // from class: okio.internal.ZipFilesKt$readCentralDirectoryZipEntry$1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj3, Object obj4) throws IOException {
                            int iIntValue2 = ((Number) obj3).intValue();
                            long jLongValue2 = ((Number) obj4).longValue();
                            if (iIntValue2 == 1) {
                                Ref.ObjectRef objectRef7 = objectRef5;
                                if (objectRef7.f53801a != null) {
                                    throw new IOException("bad zip: NTFS extra attribute tag 0x0001 repeated");
                                }
                                if (jLongValue2 != 24) {
                                    throw new IOException("bad zip: NTFS extra attribute tag 0x0001 size != 24");
                                }
                                RealBufferedSource realBufferedSource3 = realBufferedSource2;
                                objectRef7.f53801a = Long.valueOf(realBufferedSource3.N());
                                objectRef6.f53801a = Long.valueOf(realBufferedSource3.N());
                                objectRef4.f53801a = Long.valueOf(realBufferedSource3.N());
                            }
                            return Unit.f53572a;
                        }
                    });
                }
                return Unit.f53572a;
            }
        });
        if (j2 > 0 && !booleanRef.f53798a) {
            throw new IOException("bad zip: zip64 extra required but absent");
        }
        String strV2 = realBufferedSource.V(iT6);
        String str = Path.f56972b;
        return new ZipEntry(Path.Companion.a("/", false).e(strV), StringsKt.r(strV, "/", false), strV2, jD, longRef.f53800a, longRef2.f53800a, iT, longRef3.f53800a, iT3, iT2, (Long) objectRef.f53801a, (Long) objectRef2.f53801a, (Long) objectRef3.f53801a, 57344);
    }

    public static final void f(RealBufferedSource realBufferedSource, int i2, Function2 function2) throws IOException {
        long j2 = i2;
        while (j2 != 0) {
            if (j2 < 4) {
                throw new IOException("bad zip: truncated header in extra field");
            }
            int iT = realBufferedSource.T() & 65535;
            long jT = realBufferedSource.T() & 65535;
            long j3 = j2 - 4;
            if (j3 < jT) {
                throw new IOException("bad zip: truncated value in extra field");
            }
            realBufferedSource.j0(jT);
            Buffer buffer = realBufferedSource.f56985b;
            long j4 = buffer.f56914b;
            function2.invoke(Integer.valueOf(iT), Long.valueOf(jT));
            long j5 = (buffer.f56914b + jT) - j4;
            if (j5 < 0) {
                throw new IOException(b.f(iT, "unsupported zip: too many bytes processed for "));
            }
            if (j5 > 0) {
                buffer.j1(j5);
            }
            j2 = j3 - jT;
        }
    }

    public static final ZipEntry g(final RealBufferedSource realBufferedSource, ZipEntry zipEntry) throws IOException {
        int iD = realBufferedSource.D();
        if (iD != 67324752) {
            throw new IOException("bad zip: expected " + b(67324752) + " but was " + b(iD));
        }
        realBufferedSource.k0(2L);
        short sT = realBufferedSource.T();
        int i2 = sT & 65535;
        if ((sT & 1) != 0) {
            throw new IOException("unsupported zip: general purpose bit flag=" + b(i2));
        }
        realBufferedSource.k0(18L);
        int iT = realBufferedSource.T() & 65535;
        realBufferedSource.k0(realBufferedSource.T() & 65535);
        if (zipEntry == null) {
            realBufferedSource.k0(iT);
            return null;
        }
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        final Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
        final Ref.ObjectRef objectRef3 = new Ref.ObjectRef();
        f(realBufferedSource, iT, new Function2<Integer, Long, Unit>() { // from class: okio.internal.ZipFilesKt$readOrSkipLocalHeader$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) throws IOException {
                int iIntValue = ((Number) obj).intValue();
                long jLongValue = ((Number) obj2).longValue();
                if (iIntValue == 21589) {
                    if (jLongValue < 1) {
                        throw new IOException("bad zip: extended timestamp extra too short");
                    }
                    RealBufferedSource realBufferedSource2 = realBufferedSource;
                    byte bE = realBufferedSource2.e();
                    boolean z = (bE & 1) == 1;
                    boolean z2 = (bE & 2) == 2;
                    boolean z3 = (bE & 4) == 4;
                    long j2 = z ? 5L : 1L;
                    if (z2) {
                        j2 += 4;
                    }
                    if (z3) {
                        j2 += 4;
                    }
                    if (jLongValue < j2) {
                        throw new IOException("bad zip: extended timestamp extra too short");
                    }
                    if (z) {
                        objectRef.f53801a = Integer.valueOf(realBufferedSource2.D());
                    }
                    if (z2) {
                        objectRef2.f53801a = Integer.valueOf(realBufferedSource2.D());
                    }
                    if (z3) {
                        objectRef3.f53801a = Integer.valueOf(realBufferedSource2.D());
                    }
                }
                return Unit.f53572a;
            }
        });
        return new ZipEntry(zipEntry.f57047a, zipEntry.f57048b, zipEntry.f57049c, zipEntry.f57050d, zipEntry.f57051e, zipEntry.f57052f, zipEntry.f57053g, zipEntry.f57054h, zipEntry.f57055i, zipEntry.f57056j, zipEntry.f57057k, zipEntry.f57058l, zipEntry.f57059m, (Integer) objectRef.f53801a, (Integer) objectRef2.f53801a, (Integer) objectRef3.f53801a);
    }
}
