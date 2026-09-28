package com.google.android.gms.internal.ads;

import android.annotation.SuppressLint;
import android.media.MediaCodecInfo;
import android.os.Build;
import android.util.Pair;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

@SuppressLint({"InlinedApi"})
/* loaded from: classes4.dex */
public final class zzvc {

    /* renamed from: a, reason: collision with root package name */
    public static final HashMap f35693a = new HashMap();

    public static synchronized List a(String str, boolean z, boolean z2) {
        try {
            zzut zzutVar = new zzut(str, z, z2);
            HashMap map = f35693a;
            List list = (List) map.get(zzutVar);
            if (list != null) {
                return list;
            }
            ArrayList arrayListD = d(zzutVar, new zzux(z, z2, str.equals("video/mv-hevc")));
            if (z) {
                arrayListD.isEmpty();
            }
            if ("audio/raw".equals(str)) {
                if (Build.VERSION.SDK_INT < 26 && Build.DEVICE.equals("R9") && arrayListD.size() == 1 && ((zzuj) arrayListD.get(0)).f35645a.equals("OMX.MTK.AUDIO.DECODER.RAW")) {
                    arrayListD.add(zzuj.a("OMX.google.raw.decoder", "audio/raw", "audio/raw", null, false, false));
                }
                Collections.sort(arrayListD, new zzuz(zzuy.f35677a));
            }
            if (Build.VERSION.SDK_INT < 32 && arrayListD.size() > 1 && "OMX.qti.audio.decoder.flac".equals(((zzuj) arrayListD.get(0)).f35645a)) {
                arrayListD.add((zzuj) arrayListD.remove(0));
            }
            zzgtd zzgtdVarR = zzgtd.r(arrayListD);
            map.put(zzutVar, zzgtdVarR);
            return zzgtdVarR;
        } catch (Throwable th) {
            throw th;
        }
    }

    public static List b(zzus zzusVar, zzv zzvVar, boolean z, boolean z2) {
        Iterable iterableA;
        String str = zzvVar.f35691m;
        ((zzur) zzusVar).getClass();
        List listA = a(str, z, z2);
        String strC = c(zzvVar);
        if (strC == null) {
            zzgvs zzgvsVar = zzgtd.f33183b;
            iterableA = zzguy.f33232e;
        } else {
            iterableA = a(strC, z, z2);
        }
        zzgvs zzgvsVar2 = zzgtd.f33183b;
        zzgta zzgtaVar = new zzgta();
        zzgtaVar.d(listA);
        zzgtaVar.d(iterableA);
        return zzgtaVar.f();
    }

    public static String c(zzv zzvVar) {
        Pair pairB;
        String str = zzvVar.f35691m;
        if ("audio/eac3-joc".equals(str)) {
            return "audio/eac3";
        }
        if ("video/dolby-vision".equals(str) && (pairB = zzdo.b(zzvVar)) != null) {
            int iIntValue = ((Integer) pairB.first).intValue();
            if (iIntValue == 16 || iIntValue == 256) {
                return "video/hevc";
            }
            if (iIntValue == 512) {
                return "video/avc";
            }
            if (iIntValue == 1024) {
                return "video/av01";
            }
        }
        if ("video/mv-hevc".equals(str)) {
            return "video/hevc";
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:106:0x01b9  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0110 A[PHI: r18
      0x0110: PHI (r18v3 java.lang.String) = (r18v2 java.lang.String), (r18v5 java.lang.String) binds: [B:67:0x010e, B:95:0x0175] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0137 A[Catch: Exception -> 0x013c, TryCatch #0 {Exception -> 0x013c, blocks: (B:63:0x0107, B:71:0x0116, B:78:0x012f, B:80:0x0137, B:87:0x014b, B:89:0x0154, B:90:0x0158, B:92:0x0168, B:94:0x0170, B:83:0x0140), top: B:112:0x0107 }] */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0140 A[Catch: Exception -> 0x013c, TryCatch #0 {Exception -> 0x013c, blocks: (B:63:0x0107, B:71:0x0116, B:78:0x012f, B:80:0x0137, B:87:0x014b, B:89:0x0154, B:90:0x0158, B:92:0x0168, B:94:0x0170, B:83:0x0140), top: B:112:0x0107 }] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0154 A[Catch: Exception -> 0x013c, TryCatch #0 {Exception -> 0x013c, blocks: (B:63:0x0107, B:71:0x0116, B:78:0x012f, B:80:0x0137, B:87:0x014b, B:89:0x0154, B:90:0x0158, B:92:0x0168, B:94:0x0170, B:83:0x0140), top: B:112:0x0107 }] */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0158 A[Catch: Exception -> 0x013c, TryCatch #0 {Exception -> 0x013c, blocks: (B:63:0x0107, B:71:0x0116, B:78:0x012f, B:80:0x0137, B:87:0x014b, B:89:0x0154, B:90:0x0158, B:92:0x0168, B:94:0x0170, B:83:0x0140), top: B:112:0x0107 }] */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0178  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.util.ArrayList d(com.google.android.gms.internal.ads.zzut r21, com.google.android.gms.internal.ads.zzux r22) throws java.lang.Exception {
        /*
            Method dump skipped, instructions count: 464
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzvc.d(com.google.android.gms.internal.ads.zzut, com.google.android.gms.internal.ads.zzux):java.util.ArrayList");
    }

    public static boolean e(MediaCodecInfo mediaCodecInfo, String str) {
        if (Build.VERSION.SDK_INT >= 29) {
            return mediaCodecInfo.isSoftwareOnly();
        }
        if (zzas.a(str)) {
            return true;
        }
        String strA = zzgpj.a(mediaCodecInfo.getName());
        if (strA.startsWith("arc.")) {
            return false;
        }
        if (strA.startsWith("omx.google.") || strA.startsWith("omx.ffmpeg.")) {
            return true;
        }
        if ((strA.startsWith("omx.sec.") && strA.contains(".sw.")) || strA.equals("omx.qcom.video.decoder.hevcswvdec") || strA.startsWith("c2.android.") || strA.startsWith("c2.google.")) {
            return true;
        }
        return (strA.startsWith("omx.") || strA.startsWith("c2.")) ? false : true;
    }
}
