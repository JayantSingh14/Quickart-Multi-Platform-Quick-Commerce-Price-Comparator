package com.google.android.gms.internal.ads;

import com.google.ads.interactivemedia.v3.api.CompanionAdSlot;
import in.juspay.hypersdk.analytics.LogConstants;
import java.nio.ByteOrder;
import java.nio.charset.StandardCharsets;

/* loaded from: classes4.dex */
final class zzagq implements zzagj {

    /* renamed from: a, reason: collision with root package name */
    public final zzgtd f23053a;

    /* renamed from: b, reason: collision with root package name */
    public final int f23054b;

    public zzagq(int i2, zzgtd zzgtdVar) {
        this.f23054b = i2;
        this.f23053a = zzgtdVar;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static zzagq a(int i2, zzer zzerVar) {
        String str;
        zzagj zzagrVar;
        String str2;
        zzgta zzgtaVar = new zzgta();
        int i3 = zzerVar.f30146c;
        int iA = -2;
        while (zzerVar.B() > 8) {
            int iC = zzerVar.c();
            int iC2 = zzerVar.f30145b + zzerVar.c();
            zzerVar.C(iC2);
            if (iC != 1414744396) {
                switch (iC) {
                    case 1718776947:
                        if (iA == 2) {
                            zzerVar.G(4);
                            int iC3 = zzerVar.c();
                            int iC4 = zzerVar.c();
                            zzerVar.G(4);
                            int iC5 = zzerVar.c();
                            switch (iC5) {
                                case 808802372:
                                case 877677894:
                                case 1145656883:
                                case 1145656920:
                                case 1482049860:
                                case 1684633208:
                                case 2021026148:
                                    str2 = "video/mp4v-es";
                                    break;
                                case 826496577:
                                case 828601953:
                                case 875967048:
                                    str2 = "video/avc";
                                    break;
                                case 842289229:
                                    str2 = "video/mp42";
                                    break;
                                case 859066445:
                                    str2 = "video/mp43";
                                    break;
                                case 1196444237:
                                case 1735420525:
                                    str2 = "video/mjpeg";
                                    break;
                                default:
                                    str2 = null;
                                    break;
                            }
                            if (str2 != null) {
                                zzt zztVar = new zzt();
                                zztVar.s = iC3;
                                zztVar.t = iC4;
                                zztVar.e(str2);
                                zzagrVar = new zzagr(new zzv(zztVar));
                                break;
                            } else {
                                b.d(new StringBuilder(String.valueOf(iC5).length() + 44), "Ignoring track with unsupported compression ", iC5, "StreamFormatChunk");
                                zzagrVar = null;
                                break;
                            }
                        } else {
                            if (iA == 1) {
                                int iM = zzerVar.M();
                                String str3 = iM != 1 ? iM != 85 ? iM != 255 ? iM != 8192 ? iM != 8193 ? null : "audio/vnd.dts" : "audio/ac3" : "audio/mp4a-latm" : "audio/mpeg" : "audio/raw";
                                if (str3 != null) {
                                    int iM2 = zzerVar.M();
                                    int iC6 = zzerVar.c();
                                    zzerVar.G(6);
                                    int iY = zzfj.y(zzerVar.M(), ByteOrder.LITTLE_ENDIAN);
                                    int iM3 = zzerVar.B() > 0 ? zzerVar.M() : 0;
                                    zzt zztVar2 = new zzt();
                                    zztVar2.e(str3);
                                    zztVar2.D = iM2;
                                    zztVar2.E = iC6;
                                    if (str3.equals("audio/raw") && iY != 0) {
                                        zztVar2.F = iY;
                                    }
                                    if (str3.equals("audio/mp4a-latm") && iM3 > 0) {
                                        byte[] bArr = new byte[iM3];
                                        zzerVar.H(0, bArr, iM3);
                                        zztVar2.o = zzgtd.n(bArr);
                                    }
                                    zzagrVar = new zzagr(new zzv(zztVar2));
                                    break;
                                } else {
                                    b.d(new StringBuilder(String.valueOf(iM).length() + 43), "Ignoring track with unsupported format tag ", iM, "StreamFormatChunk");
                                }
                            } else {
                                String str4 = zzfj.f31254a;
                                switch (iA) {
                                    case CompanionAdSlot.FLUID_SIZE /* -2 */:
                                        str = "none";
                                        break;
                                    case -1:
                                        str = com.google.ads.interactivemedia.v3.impl.data.zzck.UNKNOWN_CONTENT_TYPE;
                                        break;
                                    case 0:
                                        str = LogConstants.DEFAULT_CHANNEL;
                                        break;
                                    case 1:
                                        str = "audio";
                                        break;
                                    case 2:
                                        str = "video";
                                        break;
                                    case 3:
                                        str = "text";
                                        break;
                                    case 4:
                                        str = "image";
                                        break;
                                    case 5:
                                        str = "metadata";
                                        break;
                                    default:
                                        str = "camera motion";
                                        break;
                                }
                                zzee.c("StreamFormatChunk", "Ignoring strf box for unsupported track type: ".concat(str));
                            }
                            zzagrVar = null;
                        }
                    case 1751742049:
                        int iC7 = zzerVar.c();
                        zzerVar.G(8);
                        int iC8 = zzerVar.c();
                        int iC9 = zzerVar.c();
                        zzerVar.G(4);
                        zzerVar.c();
                        zzerVar.G(12);
                        zzagrVar = new zzagn(iC7, iC8, iC9);
                        break;
                    case 1752331379:
                        int iC10 = zzerVar.c();
                        zzerVar.G(12);
                        zzerVar.c();
                        int iC11 = zzerVar.c();
                        int iC12 = zzerVar.c();
                        zzerVar.G(4);
                        int iC13 = zzerVar.c();
                        int iC14 = zzerVar.c();
                        zzerVar.G(4);
                        zzagrVar = new zzago(iC10, iC11, iC12, iC13, iC14, zzerVar.c());
                        break;
                    case 1852994675:
                        zzagrVar = new zzags(zzerVar.k(zzerVar.B(), StandardCharsets.UTF_8));
                        break;
                    default:
                        zzagrVar = null;
                        break;
                }
            } else {
                zzagrVar = a(zzerVar.c(), zzerVar);
            }
            if (zzagrVar != null) {
                if (zzagrVar.zza() == 1752331379) {
                    iA = ((zzago) zzagrVar).a();
                }
                zzgtaVar.c(zzagrVar);
            }
            zzerVar.E(iC2);
            zzerVar.C(i3);
        }
        return new zzagq(i2, zzgtaVar.f());
    }

    public final zzagj b(Class cls) {
        zzgtd zzgtdVar = this.f23053a;
        int i2 = ((zzguy) zzgtdVar).f33234d;
        int i3 = 0;
        while (i3 < i2) {
            zzagj zzagjVar = (zzagj) ((zzguy) zzgtdVar).get(i3);
            i3++;
            if (zzagjVar.getClass() == cls) {
                return zzagjVar;
            }
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzagj
    public final int zza() {
        return this.f23054b;
    }
}
