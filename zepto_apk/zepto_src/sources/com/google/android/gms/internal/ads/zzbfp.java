package com.google.android.gms.internal.ads;

import android.os.Build;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes4.dex */
public final class zzbfp {

    /* renamed from: com.google.android.gms.internal.ads.zzbfp$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f24902a;

        static {
            int[] iArr = new int[zziaq.values().length];
            f24902a = iArr;
            try {
                iArr[3] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f24902a[4] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f24902a[2] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f24902a[5] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f24902a[6] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f24902a[0] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f24902a[1] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public final class zza extends zziar<zza, zzb> implements zzf {
        private static final zza zzB;
        private static volatile zzick<zza> zzC = null;
        public static final int zza = 7;
        public static final int zzb = 8;
        public static final int zzc = 9;
        public static final int zzd = 10;
        public static final int zze = 11;
        public static final int zzf = 12;
        public static final int zzg = 13;
        public static final int zzh = 14;
        public static final int zzi = 15;
        public static final int zzj = 16;
        public static final int zzk = 17;
        private zzibd<zzat> zzA;
        private int zzl;
        private int zzm;
        private int zzn = 1000;
        private zzg zzo;
        private zzi zzp;
        private zzibd<zzd> zzu;
        private zzk zzv;
        private zzah zzw;
        private zzac zzx;
        private zzx zzy;
        private zzz zzz;

        /* renamed from: com.google.android.gms.internal.ads.zzbfp$zza$zza, reason: collision with other inner class name */
        public enum EnumC0023zza implements zziav {
            AD_INITIATER_UNSPECIFIED(0),
            BANNER(1),
            DFP_BANNER(2),
            INTERSTITIAL(3),
            DFP_INTERSTITIAL(4),
            NATIVE_EXPRESS(5),
            AD_LOADER(6),
            REWARD_BASED_VIDEO_AD(7),
            BANNER_SEARCH_ADS(8),
            GOOGLE_MOBILE_ADS_SDK_ADAPTER(9),
            APP_OPEN(10),
            REWARDED_INTERSTITIAL(11);


            /* renamed from: a, reason: collision with root package name */
            public final int f24915a;

            /* renamed from: com.google.android.gms.internal.ads.zzbfp$zza$zza$1, reason: invalid class name */
            public class AnonymousClass1 implements zziaw<EnumC0023zza> {
            }

            /* renamed from: com.google.android.gms.internal.ads.zzbfp$zza$zza$zza, reason: collision with other inner class name */
            final class C0024zza implements zziax {

                /* renamed from: a, reason: collision with root package name */
                public static final zziax f24916a = new C0024zza();

                @Override // com.google.android.gms.internal.ads.zziax
                public final boolean zza(int i2) {
                    EnumC0023zza enumC0023zza;
                    switch (i2) {
                        case 0:
                            enumC0023zza = EnumC0023zza.AD_INITIATER_UNSPECIFIED;
                            break;
                        case 1:
                            enumC0023zza = EnumC0023zza.BANNER;
                            break;
                        case 2:
                            enumC0023zza = EnumC0023zza.DFP_BANNER;
                            break;
                        case 3:
                            enumC0023zza = EnumC0023zza.INTERSTITIAL;
                            break;
                        case 4:
                            enumC0023zza = EnumC0023zza.DFP_INTERSTITIAL;
                            break;
                        case 5:
                            enumC0023zza = EnumC0023zza.NATIVE_EXPRESS;
                            break;
                        case 6:
                            enumC0023zza = EnumC0023zza.AD_LOADER;
                            break;
                        case 7:
                            enumC0023zza = EnumC0023zza.REWARD_BASED_VIDEO_AD;
                            break;
                        case 8:
                            enumC0023zza = EnumC0023zza.BANNER_SEARCH_ADS;
                            break;
                        case 9:
                            enumC0023zza = EnumC0023zza.GOOGLE_MOBILE_ADS_SDK_ADAPTER;
                            break;
                        case 10:
                            enumC0023zza = EnumC0023zza.APP_OPEN;
                            break;
                        case 11:
                            enumC0023zza = EnumC0023zza.REWARDED_INTERSTITIAL;
                            break;
                        default:
                            enumC0023zza = null;
                            break;
                    }
                    return enumC0023zza != null;
                }
            }

            EnumC0023zza(int i2) {
                this.f24915a = i2;
            }

            @Override // java.lang.Enum
            public final String toString() {
                return Integer.toString(this.f24915a);
            }

            @Override // com.google.android.gms.internal.ads.zziav
            public final int zza() {
                return this.f24915a;
            }
        }

        public final class zzb extends zzial<zza, zzb> implements zzf {
        }

        static {
            zza zzaVar = new zza();
            zzB = zzaVar;
            zziar.x(zza.class, zzaVar);
        }

        public zza() {
            zzicn zzicnVar = zzicn.f34726e;
            this.zzu = zzicnVar;
            this.zzA = zzicnVar;
        }

        public static zza C() {
            return zzB;
        }

        public final void D(EnumC0023zza enumC0023zza) {
            this.zzm = enumC0023zza.f24915a;
            this.zzl |= 1;
        }

        public final void E(zzi zziVar) {
            this.zzp = zziVar;
            this.zzl |= 8;
        }

        public final zzi G() {
            zzi zziVar = this.zzp;
            return zziVar == null ? zzi.C() : zziVar;
        }

        @Override // com.google.android.gms.internal.ads.zziar
        public final Object y(zziaq zziaqVar, zziar zziarVar) {
            zzick zziamVar;
            int iOrdinal = zziaqVar.ordinal();
            if (iOrdinal == 0) {
                return (byte) 1;
            }
            if (iOrdinal == 2) {
                return new zzico(zzB, "\u0004\u000b\u0000\u0001\u0007\u0011\u000b\u0000\u0002\u0000\u0007᠌\u0000\b᠌\u0001\tဉ\u0002\nဉ\u0003\u000b\u001b\fဉ\u0004\rဉ\u0005\u000eဉ\u0006\u000fဉ\u0007\u0010ဉ\b\u0011\u001b", new Object[]{"zzl", "zzm", EnumC0023zza.C0024zza.f24916a, "zzn", zzq.zza.f24976a, "zzo", "zzp", "zzu", zzd.class, "zzv", "zzw", "zzx", "zzy", "zzz", "zzA", zzat.class});
            }
            if (iOrdinal == 3) {
                return new zza();
            }
            if (iOrdinal == 4) {
                return new zzb(zzB);
            }
            if (iOrdinal == 5) {
                return zzB;
            }
            if (iOrdinal != 6) {
                throw null;
            }
            zzick<zza> zzickVar = zzC;
            if (zzickVar != null) {
                return zzickVar;
            }
            synchronized (zza.class) {
                try {
                    zziamVar = zzC;
                    if (zziamVar == null) {
                        zziamVar = new zziam(zzB);
                        zzC = zziamVar;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return zziamVar;
        }
    }

    public interface zzaa extends zzicd {
    }

    public final class zzab extends zziar<zzab, zza> implements zzae {
        public static final int zza = 1;
        public static final int zzb = 2;
        private static final zzab zzf;
        private static volatile zzick<zzab> zzg;
        private int zzc;
        private int zzd;
        private int zze;

        public final class zza extends zzial<zzab, zza> implements zzae {
        }

        public enum zzb implements zziav {
            CELLULAR_NETWORK_TYPE_UNSPECIFIED(0),
            TWO_G(1),
            THREE_G(2),
            LTE(4);


            /* renamed from: a, reason: collision with root package name */
            public final int f24922a;

            /* renamed from: com.google.android.gms.internal.ads.zzbfp$zzab$zzb$1, reason: invalid class name */
            public class AnonymousClass1 implements zziaw<zzb> {
            }

            final class zza implements zziax {

                /* renamed from: a, reason: collision with root package name */
                public static final zziax f24923a = new zza();

                @Override // com.google.android.gms.internal.ads.zziax
                public final boolean zza(int i2) {
                    return (i2 != 0 ? i2 != 1 ? i2 != 2 ? i2 != 4 ? null : zzb.LTE : zzb.THREE_G : zzb.TWO_G : zzb.CELLULAR_NETWORK_TYPE_UNSPECIFIED) != null;
                }
            }

            zzb(int i2) {
                this.f24922a = i2;
            }

            @Override // java.lang.Enum
            public final String toString() {
                return Integer.toString(this.f24922a);
            }

            @Override // com.google.android.gms.internal.ads.zziav
            public final int zza() {
                return this.f24922a;
            }
        }

        public enum zzc implements zziav {
            NETWORKTYPE_UNSPECIFIED(0),
            CELL(1),
            WIFI(2);


            /* renamed from: a, reason: collision with root package name */
            public final int f24928a;

            /* renamed from: com.google.android.gms.internal.ads.zzbfp$zzab$zzc$1, reason: invalid class name */
            public class AnonymousClass1 implements zziaw<zzc> {
            }

            final class zza implements zziax {

                /* renamed from: a, reason: collision with root package name */
                public static final zziax f24929a = new zza();

                @Override // com.google.android.gms.internal.ads.zziax
                public final boolean zza(int i2) {
                    return (i2 != 0 ? i2 != 1 ? i2 != 2 ? null : zzc.WIFI : zzc.CELL : zzc.NETWORKTYPE_UNSPECIFIED) != null;
                }
            }

            zzc(int i2) {
                this.f24928a = i2;
            }

            @Override // java.lang.Enum
            public final String toString() {
                return Integer.toString(this.f24928a);
            }

            @Override // com.google.android.gms.internal.ads.zziav
            public final int zza() {
                return this.f24928a;
            }
        }

        static {
            zzab zzabVar = new zzab();
            zzf = zzabVar;
            zziar.x(zzab.class, zzabVar);
        }

        public static zza C() {
            return (zza) zzf.u();
        }

        public final void D(zzc zzcVar) {
            this.zzd = zzcVar.f24928a;
            this.zzc |= 1;
        }

        public final void E(zzb zzbVar) {
            this.zze = zzbVar.f24922a;
            this.zzc |= 2;
        }

        @Override // com.google.android.gms.internal.ads.zziar
        public final Object y(zziaq zziaqVar, zziar zziarVar) {
            zzick zziamVar;
            int iOrdinal = zziaqVar.ordinal();
            if (iOrdinal == 0) {
                return (byte) 1;
            }
            if (iOrdinal == 2) {
                return new zzico(zzf, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001᠌\u0000\u0002᠌\u0001", new Object[]{"zzc", "zzd", zzc.zza.f24929a, "zze", zzb.zza.f24923a});
            }
            if (iOrdinal == 3) {
                return new zzab();
            }
            if (iOrdinal == 4) {
                return new zza(zzf);
            }
            if (iOrdinal == 5) {
                return zzf;
            }
            if (iOrdinal != 6) {
                throw null;
            }
            zzick<zzab> zzickVar = zzg;
            if (zzickVar != null) {
                return zzickVar;
            }
            synchronized (zzab.class) {
                try {
                    zziamVar = zzg;
                    if (zziamVar == null) {
                        zziamVar = new zziam(zzf);
                        zzg = zziamVar;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return zziamVar;
        }
    }

    public final class zzac extends zziar<zzac, zza> implements zzad {
        public static final int zza = 1;
        public static final int zzb = 2;
        private static final zzac zzf;
        private static volatile zzick<zzac> zzg;
        private int zzc;
        private int zzd;
        private zzap zze;

        public final class zza extends zzial<zzac, zza> implements zzad {
        }

        static {
            zzac zzacVar = new zzac();
            zzf = zzacVar;
            zziar.x(zzac.class, zzacVar);
        }

        @Override // com.google.android.gms.internal.ads.zziar
        public final Object y(zziaq zziaqVar, zziar zziarVar) {
            zzick zziamVar;
            int iOrdinal = zziaqVar.ordinal();
            if (iOrdinal == 0) {
                return (byte) 1;
            }
            if (iOrdinal == 2) {
                return new zzico(zzf, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001᠌\u0000\u0002ဉ\u0001", new Object[]{"zzc", "zzd", zzq.zza.f24976a, "zze"});
            }
            if (iOrdinal == 3) {
                return new zzac();
            }
            if (iOrdinal == 4) {
                return new zza(zzf);
            }
            if (iOrdinal == 5) {
                return zzf;
            }
            if (iOrdinal != 6) {
                throw null;
            }
            zzick<zzac> zzickVar = zzg;
            if (zzickVar != null) {
                return zzickVar;
            }
            synchronized (zzac.class) {
                try {
                    zziamVar = zzg;
                    if (zziamVar == null) {
                        zziamVar = new zziam(zzf);
                        zzg = zziamVar;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return zziamVar;
        }
    }

    public interface zzad extends zzicd {
    }

    public interface zzae extends zzicd {
    }

    public final class zzaf extends zziar<zzaf, zzc> implements zzag {
        public static final int zza = 1;
        public static final int zzb = 2;
        public static final int zzc = 3;
        public static final int zzd = 4;
        public static final int zze = 5;
        public static final int zzf = 6;
        public static final int zzg = 7;
        public static final int zzh = 8;
        private static final zzaf zzv;
        private static volatile zzick<zzaf> zzw;
        private int zzi;
        private int zzk;
        private int zzl;
        private long zzm;
        private long zzp;
        private int zzu;
        private zzibd<zza> zzj = zzicn.f34726e;
        private String zzn = "";
        private String zzo = "";

        public final class zza extends zziar<zza, C0025zza> implements zzb {
            private static final zza zzG;
            private static volatile zzick<zza> zzH = null;
            public static final int zza = 1;
            public static final int zzb = 2;
            public static final int zzc = 3;
            public static final int zzd = 4;
            public static final int zze = 5;
            public static final int zzf = 6;
            public static final int zzg = 7;
            public static final int zzh = 8;
            public static final int zzi = 9;
            public static final int zzj = 10;
            public static final int zzk = 11;
            public static final int zzl = 12;
            public static final int zzm = 13;
            private static final zziba<zzd.zza> zzx = new AnonymousClass1();
            private int zzA;
            private int zzB;
            private int zzC;
            private int zzD;
            private int zzE;
            private long zzF;
            private int zzn;
            private long zzo;
            private int zzp;
            private long zzu;
            private long zzv;
            private zziaz zzw = zzias.f34649e;
            private zzab zzy;
            private int zzz;

            /* renamed from: com.google.android.gms.internal.ads.zzbfp$zzaf$zza$1, reason: invalid class name */
            public class AnonymousClass1 implements zziba<zzd.zza> {
            }

            /* renamed from: com.google.android.gms.internal.ads.zzbfp$zzaf$zza$zza, reason: collision with other inner class name */
            public final class C0025zza extends zzial<zza, C0025zza> implements zzb {
            }

            static {
                zza zzaVar = new zza();
                zzG = zzaVar;
                zziar.x(zza.class, zzaVar);
            }

            public static zza S(byte[] bArr) {
                zza zzaVar = zzG;
                int length = bArr.length;
                zziab zziabVar = zziab.f34620b;
                int i2 = zzhyy.f34536a;
                zziar zziarVarA = zziar.A(zzaVar, bArr, length, zziab.f34621c);
                zziar.B(zziarVarA);
                return (zza) zziarVarA;
            }

            public static C0025zza T() {
                return (C0025zza) zzG.u();
            }

            public final void C(long j2) {
                this.zzn |= 1;
                this.zzo = j2;
            }

            public final void D(zzq zzqVar) {
                this.zzp = zzqVar.f24975a;
                this.zzn |= 2;
            }

            public final void E(long j2) {
                this.zzn |= 4;
                this.zzu = j2;
            }

            public final void F(long j2) {
                this.zzn |= 8;
                this.zzv = j2;
            }

            public final void G(ArrayList arrayList) {
                zziaz zziazVar = this.zzw;
                if (!zziazVar.zza()) {
                    int size = zziazVar.size();
                    this.zzw = zziazVar.zzh(size + size);
                }
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    this.zzw.zzi(((zzd.zza) it.next()).f24963a);
                }
            }

            public final void H(zzab zzabVar) {
                this.zzy = zzabVar;
                this.zzn |= 16;
            }

            public final void I(zzq zzqVar) {
                this.zzz = zzqVar.f24975a;
                this.zzn |= 32;
            }

            public final void J(zzq zzqVar) {
                this.zzA = zzqVar.f24975a;
                this.zzn |= 64;
            }

            public final void K(zzq zzqVar) {
                this.zzB = zzqVar.f24975a;
                this.zzn |= 128;
            }

            public final void L(int i2) {
                this.zzn |= 256;
                this.zzC = i2;
            }

            public final void M(zzq zzqVar) {
                this.zzD = zzqVar.f24975a;
                this.zzn |= 512;
            }

            public final void N(zzd zzdVar) {
                this.zzE = zzdVar.f24937a;
                this.zzn |= 1024;
            }

            public final void O(long j2) {
                this.zzn |= 2048;
                this.zzF = j2;
            }

            public final long Q() {
                return this.zzo;
            }

            public final zzq R() {
                int i2 = this.zzp;
                zzq zzqVar = zzq.ENUM_FALSE;
                zzq zzqVar2 = i2 != 0 ? i2 != 1 ? i2 != 1000 ? null : zzq.ENUM_UNKNOWN : zzq.ENUM_TRUE : zzqVar;
                return zzqVar2 == null ? zzqVar : zzqVar2;
            }

            @Override // com.google.android.gms.internal.ads.zziar
            public final Object y(zziaq zziaqVar, zziar zziarVar) {
                zzick zziamVar;
                int iOrdinal = zziaqVar.ordinal();
                if (iOrdinal == 0) {
                    return (byte) 1;
                }
                if (iOrdinal == 2) {
                    zziax zziaxVar = zzq.zza.f24976a;
                    return new zzico(zzG, "\u0004\r\u0000\u0001\u0001\r\r\u0000\u0001\u0000\u0001ဂ\u0000\u0002᠌\u0001\u0003ဂ\u0002\u0004ဂ\u0003\u0005ࠞ\u0006ဉ\u0004\u0007᠌\u0005\b᠌\u0006\t᠌\u0007\nင\b\u000b᠌\t\f᠌\n\rဂ\u000b", new Object[]{"zzn", "zzo", "zzp", zziaxVar, "zzu", "zzv", "zzw", zzd.zza.C0028zza.f24964a, "zzy", "zzz", zziaxVar, "zzA", zziaxVar, "zzB", zziaxVar, "zzC", "zzD", zziaxVar, "zzE", zzd.zza.f24938a, "zzF"});
                }
                if (iOrdinal == 3) {
                    return new zza();
                }
                if (iOrdinal == 4) {
                    return new C0025zza(zzG);
                }
                if (iOrdinal == 5) {
                    return zzG;
                }
                if (iOrdinal != 6) {
                    throw null;
                }
                zzick<zza> zzickVar = zzH;
                if (zzickVar != null) {
                    return zzickVar;
                }
                synchronized (zza.class) {
                    try {
                        zziamVar = zzH;
                        if (zziamVar == null) {
                            zziamVar = new zziam(zzG);
                            zzH = zziamVar;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                return zziamVar;
            }
        }

        public interface zzb extends zzicd {
        }

        public final class zzc extends zzial<zzaf, zzc> implements zzag {
        }

        public enum zzd implements zziav {
            UNSPECIFIED(0),
            CONNECTING(1),
            CONNECTED(2),
            DISCONNECTING(3),
            DISCONNECTED(4),
            SUSPENDED(5);


            /* renamed from: a, reason: collision with root package name */
            public final int f24937a;

            /* renamed from: com.google.android.gms.internal.ads.zzbfp$zzaf$zzd$1, reason: invalid class name */
            public class AnonymousClass1 implements zziaw<zzd> {
            }

            final class zza implements zziax {

                /* renamed from: a, reason: collision with root package name */
                public static final zziax f24938a = new zza();

                @Override // com.google.android.gms.internal.ads.zziax
                public final boolean zza(int i2) {
                    return (i2 != 0 ? i2 != 1 ? i2 != 2 ? i2 != 3 ? i2 != 4 ? i2 != 5 ? null : zzd.SUSPENDED : zzd.DISCONNECTED : zzd.DISCONNECTING : zzd.CONNECTED : zzd.CONNECTING : zzd.UNSPECIFIED) != null;
                }
            }

            zzd(int i2) {
                this.f24937a = i2;
            }

            @Override // java.lang.Enum
            public final String toString() {
                return Integer.toString(this.f24937a);
            }

            @Override // com.google.android.gms.internal.ads.zziav
            public final int zza() {
                return this.f24937a;
            }
        }

        static {
            zzaf zzafVar = new zzaf();
            zzv = zzafVar;
            zziar.x(zzaf.class, zzafVar);
        }

        public static zzc C() {
            return (zzc) zzv.u();
        }

        public final void D(ArrayList arrayList) {
            zzibd<zza> zzibdVar = this.zzj;
            if (!zzibdVar.zza()) {
                int size = zzibdVar.size();
                this.zzj = zzibdVar.zzh(size + size);
            }
            zzhyu.j(arrayList, this.zzj);
        }

        public final void E(int i2) {
            this.zzi |= 1;
            this.zzk = i2;
        }

        public final void F(int i2) {
            this.zzi |= 2;
            this.zzl = i2;
        }

        public final void G(long j2) {
            this.zzi |= 4;
            this.zzm = j2;
        }

        public final void H(String str) {
            str.getClass();
            this.zzi |= 8;
            this.zzn = str;
        }

        public final void I() {
            String str = Build.MODEL;
            str.getClass();
            this.zzi |= 16;
            this.zzo = str;
        }

        public final void J(long j2) {
            this.zzi |= 32;
            this.zzp = j2;
        }

        public final void K(int i2) {
            this.zzi |= 64;
            this.zzu = i2;
        }

        @Override // com.google.android.gms.internal.ads.zziar
        public final Object y(zziaq zziaqVar, zziar zziarVar) {
            zzick zziamVar;
            int iOrdinal = zziaqVar.ordinal();
            if (iOrdinal == 0) {
                return (byte) 1;
            }
            if (iOrdinal == 2) {
                return new zzico(zzv, "\u0004\b\u0000\u0001\u0001\b\b\u0000\u0001\u0000\u0001\u001b\u0002င\u0000\u0003င\u0001\u0004ဂ\u0002\u0005ဈ\u0003\u0006ဈ\u0004\u0007ဂ\u0005\bင\u0006", new Object[]{"zzi", "zzj", zza.class, "zzk", "zzl", "zzm", "zzn", "zzo", "zzp", "zzu"});
            }
            if (iOrdinal == 3) {
                return new zzaf();
            }
            if (iOrdinal == 4) {
                return new zzc(zzv);
            }
            if (iOrdinal == 5) {
                return zzv;
            }
            if (iOrdinal != 6) {
                throw null;
            }
            zzick<zzaf> zzickVar = zzw;
            if (zzickVar != null) {
                return zzickVar;
            }
            synchronized (zzaf.class) {
                try {
                    zziamVar = zzw;
                    if (zziamVar == null) {
                        zziamVar = new zziam(zzv);
                        zzw = zziamVar;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return zziamVar;
        }
    }

    public interface zzag extends zzicd {
    }

    public final class zzah extends zziar<zzah, zza> implements zzak {
        private static final zzah zzB;
        private static volatile zzick<zzah> zzC = null;
        public static final int zza = 1;
        public static final int zzb = 2;
        public static final int zzc = 3;
        public static final int zzd = 4;
        public static final int zze = 5;
        public static final int zzf = 6;
        public static final int zzg = 7;
        public static final int zzh = 8;
        public static final int zzi = 9;
        public static final int zzj = 10;
        public static final int zzk = 11;
        private zzai zzA;
        private int zzl;
        private int zzm = 1000;
        private int zzn = 1000;
        private int zzo;
        private int zzp;
        private int zzu;
        private int zzv;
        private int zzw;
        private int zzx;
        private int zzy;
        private int zzz;

        public final class zza extends zzial<zzah, zza> implements zzak {
        }

        static {
            zzah zzahVar = new zzah();
            zzB = zzahVar;
            zziar.x(zzah.class, zzahVar);
        }

        @Override // com.google.android.gms.internal.ads.zziar
        public final Object y(zziaq zziaqVar, zziar zziarVar) {
            zzick zziamVar;
            int iOrdinal = zziaqVar.ordinal();
            if (iOrdinal == 0) {
                return (byte) 1;
            }
            if (iOrdinal == 2) {
                zziax zziaxVar = zzq.zza.f24976a;
                return new zzico(zzB, "\u0004\u000b\u0000\u0001\u0001\u000b\u000b\u0000\u0000\u0000\u0001᠌\u0000\u0002᠌\u0001\u0003င\u0002\u0004င\u0003\u0005င\u0004\u0006င\u0005\u0007င\u0006\bင\u0007\tင\b\nင\t\u000bဉ\n", new Object[]{"zzl", "zzm", zziaxVar, "zzn", zziaxVar, "zzo", "zzp", "zzu", "zzv", "zzw", "zzx", "zzy", "zzz", "zzA"});
            }
            if (iOrdinal == 3) {
                return new zzah();
            }
            if (iOrdinal == 4) {
                return new zza(zzB);
            }
            if (iOrdinal == 5) {
                return zzB;
            }
            if (iOrdinal != 6) {
                throw null;
            }
            zzick<zzah> zzickVar = zzC;
            if (zzickVar != null) {
                return zzickVar;
            }
            synchronized (zzah.class) {
                try {
                    zziamVar = zzC;
                    if (zziamVar == null) {
                        zziamVar = new zziam(zzB);
                        zzC = zziamVar;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return zziamVar;
        }
    }

    public final class zzai extends zziar<zzai, zza> implements zzaj {
        public static final int zza = 1;
        public static final int zzb = 2;
        private static final zzai zzf;
        private static volatile zzick<zzai> zzg;
        private int zzc;
        private int zzd;
        private int zze;

        public final class zza extends zzial<zzai, zza> implements zzaj {
        }

        static {
            zzai zzaiVar = new zzai();
            zzf = zzaiVar;
            zziar.x(zzai.class, zzaiVar);
        }

        @Override // com.google.android.gms.internal.ads.zziar
        public final Object y(zziaq zziaqVar, zziar zziarVar) {
            zzick zziamVar;
            int iOrdinal = zziaqVar.ordinal();
            if (iOrdinal == 0) {
                return (byte) 1;
            }
            if (iOrdinal == 2) {
                return new zzico(zzf, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001င\u0000\u0002င\u0001", new Object[]{"zzc", "zzd", "zze"});
            }
            if (iOrdinal == 3) {
                return new zzai();
            }
            if (iOrdinal == 4) {
                return new zza(zzf);
            }
            if (iOrdinal == 5) {
                return zzf;
            }
            if (iOrdinal != 6) {
                throw null;
            }
            zzick<zzai> zzickVar = zzg;
            if (zzickVar != null) {
                return zzickVar;
            }
            synchronized (zzai.class) {
                try {
                    zziamVar = zzg;
                    if (zziamVar == null) {
                        zziamVar = new zziam(zzf);
                        zzg = zziamVar;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return zziamVar;
        }
    }

    public interface zzaj extends zzicd {
    }

    public interface zzak extends zzicd {
    }

    public final class zzal extends zziar<zzal, zza> implements zzam {
        public static final int zza = 1;
        public static final int zzb = 2;
        private static final zzal zzf;
        private static volatile zzick<zzal> zzg;
        private int zzc;
        private int zzd;
        private int zze;

        public final class zza extends zzial<zzal, zza> implements zzam {
        }

        static {
            zzal zzalVar = new zzal();
            zzf = zzalVar;
            zziar.x(zzal.class, zzalVar);
        }

        @Override // com.google.android.gms.internal.ads.zziar
        public final Object y(zziaq zziaqVar, zziar zziarVar) {
            zzick zziamVar;
            int iOrdinal = zziaqVar.ordinal();
            if (iOrdinal == 0) {
                return (byte) 1;
            }
            if (iOrdinal == 2) {
                return new zzico(zzf, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001င\u0000\u0002င\u0001", new Object[]{"zzc", "zzd", "zze"});
            }
            if (iOrdinal == 3) {
                return new zzal();
            }
            if (iOrdinal == 4) {
                return new zza(zzf);
            }
            if (iOrdinal == 5) {
                return zzf;
            }
            if (iOrdinal != 6) {
                throw null;
            }
            zzick<zzal> zzickVar = zzg;
            if (zzickVar != null) {
                return zzickVar;
            }
            synchronized (zzal.class) {
                try {
                    zziamVar = zzg;
                    if (zziamVar == null) {
                        zziamVar = new zziam(zzf);
                        zzg = zziamVar;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return zziamVar;
        }
    }

    public interface zzam extends zzicd {
    }

    public final class zzan extends zziar<zzan, zza> implements zzao {
        public static final int zza = 1;
        public static final int zzb = 2;
        public static final int zzc = 3;
        private static final zzan zzh;
        private static volatile zzick<zzan> zzi;
        private int zzd;
        private String zze = "";
        private int zzf;
        private zzap zzg;

        public final class zza extends zzial<zzan, zza> implements zzao {
        }

        static {
            zzan zzanVar = new zzan();
            zzh = zzanVar;
            zziar.x(zzan.class, zzanVar);
        }

        @Override // com.google.android.gms.internal.ads.zziar
        public final Object y(zziaq zziaqVar, zziar zziarVar) {
            zzick zziamVar;
            int iOrdinal = zziaqVar.ordinal();
            if (iOrdinal == 0) {
                return (byte) 1;
            }
            if (iOrdinal == 2) {
                return new zzico(zzh, "\u0004\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဈ\u0000\u0002᠌\u0001\u0003ဉ\u0002", new Object[]{"zzd", "zze", "zzf", zzq.zza.f24976a, "zzg"});
            }
            if (iOrdinal == 3) {
                return new zzan();
            }
            if (iOrdinal == 4) {
                return new zza(zzh);
            }
            if (iOrdinal == 5) {
                return zzh;
            }
            if (iOrdinal != 6) {
                throw null;
            }
            zzick<zzan> zzickVar = zzi;
            if (zzickVar != null) {
                return zzickVar;
            }
            synchronized (zzan.class) {
                try {
                    zziamVar = zzi;
                    if (zziamVar == null) {
                        zziamVar = new zziam(zzh);
                        zzi = zziamVar;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return zziamVar;
        }
    }

    public interface zzao extends zzicd {
    }

    public final class zzap extends zziar<zzap, zza> implements zzaq {
        public static final int zza = 1;
        public static final int zzb = 2;
        private static final zzap zzf;
        private static volatile zzick<zzap> zzg;
        private int zzc;
        private int zzd;
        private int zze;

        public final class zza extends zzial<zzap, zza> implements zzaq {
        }

        static {
            zzap zzapVar = new zzap();
            zzf = zzapVar;
            zziar.x(zzap.class, zzapVar);
        }

        @Override // com.google.android.gms.internal.ads.zziar
        public final Object y(zziaq zziaqVar, zziar zziarVar) {
            zzick zziamVar;
            int iOrdinal = zziaqVar.ordinal();
            if (iOrdinal == 0) {
                return (byte) 1;
            }
            if (iOrdinal == 2) {
                return new zzico(zzf, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001င\u0000\u0002င\u0001", new Object[]{"zzc", "zzd", "zze"});
            }
            if (iOrdinal == 3) {
                return new zzap();
            }
            if (iOrdinal == 4) {
                return new zza(zzf);
            }
            if (iOrdinal == 5) {
                return zzf;
            }
            if (iOrdinal != 6) {
                throw null;
            }
            zzick<zzap> zzickVar = zzg;
            if (zzickVar != null) {
                return zzickVar;
            }
            synchronized (zzap.class) {
                try {
                    zziamVar = zzg;
                    if (zziamVar == null) {
                        zziamVar = new zziam(zzf);
                        zzg = zziamVar;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return zziamVar;
        }
    }

    public interface zzaq extends zzicd {
    }

    public final class zzar extends zziar<zzar, zza> implements zzas {
        public static final int zza = 1;
        public static final int zzb = 2;
        public static final int zzc = 3;
        private static final zzar zzh;
        private static volatile zzick<zzar> zzi;
        private int zzd;
        private int zze;
        private int zzf;
        private int zzg;

        public final class zza extends zzial<zzar, zza> implements zzas {
        }

        static {
            zzar zzarVar = new zzar();
            zzh = zzarVar;
            zziar.x(zzar.class, zzarVar);
        }

        public static zza E() {
            return (zza) zzh.u();
        }

        public final void C(int i2) {
            this.zzd |= 4;
            this.zzg = i2;
        }

        public final void F(int i2) {
            this.zzd |= 1;
            this.zze = i2;
        }

        public final void G(int i2) {
            this.zzd |= 2;
            this.zzf = i2;
        }

        @Override // com.google.android.gms.internal.ads.zziar
        public final Object y(zziaq zziaqVar, zziar zziarVar) {
            zzick zziamVar;
            int iOrdinal = zziaqVar.ordinal();
            if (iOrdinal == 0) {
                return (byte) 1;
            }
            if (iOrdinal == 2) {
                return new zzico(zzh, "\u0004\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001င\u0000\u0002င\u0001\u0003င\u0002", new Object[]{"zzd", "zze", "zzf", "zzg"});
            }
            if (iOrdinal == 3) {
                return new zzar();
            }
            if (iOrdinal == 4) {
                return new zza(zzh);
            }
            if (iOrdinal == 5) {
                return zzh;
            }
            if (iOrdinal != 6) {
                throw null;
            }
            zzick<zzar> zzickVar = zzi;
            if (zzickVar != null) {
                return zzickVar;
            }
            synchronized (zzar.class) {
                try {
                    zziamVar = zzi;
                    if (zziamVar == null) {
                        zziamVar = new zziam(zzh);
                        zzi = zziamVar;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return zziamVar;
        }
    }

    public interface zzas extends zzicd {
    }

    public final class zzat extends zziar<zzat, zza> implements zzbi {
        private static final zzat zzL;
        private static volatile zzick<zzat> zzM = null;
        public static final int zza = 5;
        public static final int zzb = 6;
        public static final int zzc = 7;
        public static final int zzd = 8;
        public static final int zze = 9;
        public static final int zzf = 10;
        public static final int zzg = 11;
        public static final int zzh = 12;
        public static final int zzi = 13;
        public static final int zzj = 14;
        public static final int zzk = 15;
        public static final int zzl = 16;
        public static final int zzm = 17;
        public static final int zzn = 18;
        public static final int zzo = 19;
        public static final int zzp = 20;
        private zzbc zzA;
        private zzay zzB;
        private int zzC;
        private int zzD;
        private zzap zzE;
        private int zzF;
        private int zzG;
        private int zzH;
        private int zzI;
        private int zzJ;
        private long zzK;
        private int zzu;
        private zzba zzv;
        private zzbe zzw;
        private zzbg zzx;
        private zzbj zzy;
        private zzau zzz;

        public final class zza extends zzial<zzat, zza> implements zzbi {
        }

        static {
            zzat zzatVar = new zzat();
            zzL = zzatVar;
            zziar.x(zzat.class, zzatVar);
        }

        @Override // com.google.android.gms.internal.ads.zziar
        public final Object y(zziaq zziaqVar, zziar zziarVar) {
            zzick zziamVar;
            int iOrdinal = zziaqVar.ordinal();
            if (iOrdinal == 0) {
                return (byte) 1;
            }
            if (iOrdinal == 2) {
                return new zzico(zzL, "\u0004\u0010\u0000\u0001\u0005\u0014\u0010\u0000\u0000\u0000\u0005ဉ\u0000\u0006ဉ\u0001\u0007ဉ\u0002\bဉ\u0003\tဉ\u0004\nဉ\u0005\u000bဉ\u0006\fင\u0007\rင\b\u000eဉ\t\u000fင\n\u0010င\u000b\u0011င\f\u0012င\r\u0013င\u000e\u0014ဃ\u000f", new Object[]{"zzu", "zzv", "zzw", "zzx", "zzy", "zzz", "zzA", "zzB", "zzC", "zzD", "zzE", "zzF", "zzG", "zzH", "zzI", "zzJ", "zzK"});
            }
            if (iOrdinal == 3) {
                return new zzat();
            }
            if (iOrdinal == 4) {
                return new zza(zzL);
            }
            if (iOrdinal == 5) {
                return zzL;
            }
            if (iOrdinal != 6) {
                throw null;
            }
            zzick<zzat> zzickVar = zzM;
            if (zzickVar != null) {
                return zzickVar;
            }
            synchronized (zzat.class) {
                try {
                    zziamVar = zzM;
                    if (zziamVar == null) {
                        zziamVar = new zziam(zzL);
                        zzM = zziamVar;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return zziamVar;
        }
    }

    public final class zzau extends zziar<zzau, zza> implements zzav {
        public static final int zza = 1;
        public static final int zzb = 2;
        public static final int zzc = 3;
        private static final zzau zzh;
        private static volatile zzick<zzau> zzi;
        private int zzd;
        private int zze = 1000;
        private zzaw zzf;
        private zzap zzg;

        public final class zza extends zzial<zzau, zza> implements zzav {
        }

        static {
            zzau zzauVar = new zzau();
            zzh = zzauVar;
            zziar.x(zzau.class, zzauVar);
        }

        @Override // com.google.android.gms.internal.ads.zziar
        public final Object y(zziaq zziaqVar, zziar zziarVar) {
            zzick zziamVar;
            int iOrdinal = zziaqVar.ordinal();
            if (iOrdinal == 0) {
                return (byte) 1;
            }
            if (iOrdinal == 2) {
                return new zzico(zzh, "\u0004\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001᠌\u0000\u0002ဉ\u0001\u0003ဉ\u0002", new Object[]{"zzd", "zze", zzq.zza.f24976a, "zzf", "zzg"});
            }
            if (iOrdinal == 3) {
                return new zzau();
            }
            if (iOrdinal == 4) {
                return new zza(zzh);
            }
            if (iOrdinal == 5) {
                return zzh;
            }
            if (iOrdinal != 6) {
                throw null;
            }
            zzick<zzau> zzickVar = zzi;
            if (zzickVar != null) {
                return zzickVar;
            }
            synchronized (zzau.class) {
                try {
                    zziamVar = zzi;
                    if (zziamVar == null) {
                        zziamVar = new zziam(zzh);
                        zzi = zziamVar;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return zziamVar;
        }
    }

    public interface zzav extends zzicd {
    }

    public final class zzaw extends zziar<zzaw, zza> implements zzax {
        public static final int zza = 1;
        private static final zzaw zzd;
        private static volatile zzick<zzaw> zze;
        private int zzb;
        private int zzc;

        public final class zza extends zzial<zzaw, zza> implements zzax {
        }

        public enum zzb implements zziav {
            VIDEO_ERROR_CODE_UNSPECIFIED(0),
            OPENGL_RENDERING_FAILED(1),
            CACHE_LOAD_FAILED(2),
            ANDROID_TARGET_API_TOO_LOW(3);


            /* renamed from: a, reason: collision with root package name */
            public final int f24944a;

            /* renamed from: com.google.android.gms.internal.ads.zzbfp$zzaw$zzb$1, reason: invalid class name */
            public class AnonymousClass1 implements zziaw<zzb> {
            }

            final class zza implements zziax {

                /* renamed from: a, reason: collision with root package name */
                public static final zziax f24945a = new zza();

                @Override // com.google.android.gms.internal.ads.zziax
                public final boolean zza(int i2) {
                    return (i2 != 0 ? i2 != 1 ? i2 != 2 ? i2 != 3 ? null : zzb.ANDROID_TARGET_API_TOO_LOW : zzb.CACHE_LOAD_FAILED : zzb.OPENGL_RENDERING_FAILED : zzb.VIDEO_ERROR_CODE_UNSPECIFIED) != null;
                }
            }

            zzb(int i2) {
                this.f24944a = i2;
            }

            @Override // java.lang.Enum
            public final String toString() {
                return Integer.toString(this.f24944a);
            }

            @Override // com.google.android.gms.internal.ads.zziav
            public final int zza() {
                return this.f24944a;
            }
        }

        static {
            zzaw zzawVar = new zzaw();
            zzd = zzawVar;
            zziar.x(zzaw.class, zzawVar);
        }

        @Override // com.google.android.gms.internal.ads.zziar
        public final Object y(zziaq zziaqVar, zziar zziarVar) {
            zzick zziamVar;
            int iOrdinal = zziaqVar.ordinal();
            if (iOrdinal == 0) {
                return (byte) 1;
            }
            if (iOrdinal == 2) {
                return new zzico(zzd, "\u0004\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001᠌\u0000", new Object[]{"zzb", "zzc", zzb.zza.f24945a});
            }
            if (iOrdinal == 3) {
                return new zzaw();
            }
            if (iOrdinal == 4) {
                return new zza(zzd);
            }
            if (iOrdinal == 5) {
                return zzd;
            }
            if (iOrdinal != 6) {
                throw null;
            }
            zzick<zzaw> zzickVar = zze;
            if (zzickVar != null) {
                return zzickVar;
            }
            synchronized (zzaw.class) {
                try {
                    zziamVar = zze;
                    if (zziamVar == null) {
                        zziamVar = new zziam(zzd);
                        zze = zziamVar;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return zziamVar;
        }
    }

    public interface zzax extends zzicd {
    }

    public final class zzay extends zziar<zzay, zza> implements zzaz {
        public static final int zza = 1;
        public static final int zzb = 2;
        public static final int zzc = 3;
        public static final int zzd = 4;
        private static final zzay zzj;
        private static volatile zzick<zzay> zzk;
        private int zze;
        private zzar zzf;
        private int zzg = 1000;
        private zzaw zzh;
        private zzap zzi;

        public final class zza extends zzial<zzay, zza> implements zzaz {
        }

        static {
            zzay zzayVar = new zzay();
            zzj = zzayVar;
            zziar.x(zzay.class, zzayVar);
        }

        @Override // com.google.android.gms.internal.ads.zziar
        public final Object y(zziaq zziaqVar, zziar zziarVar) {
            zzick zziamVar;
            int iOrdinal = zziaqVar.ordinal();
            if (iOrdinal == 0) {
                return (byte) 1;
            }
            if (iOrdinal == 2) {
                return new zzico(zzj, "\u0004\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဉ\u0000\u0002᠌\u0001\u0003ဉ\u0002\u0004ဉ\u0003", new Object[]{"zze", "zzf", "zzg", zzq.zza.f24976a, "zzh", "zzi"});
            }
            if (iOrdinal == 3) {
                return new zzay();
            }
            if (iOrdinal == 4) {
                return new zza(zzj);
            }
            if (iOrdinal == 5) {
                return zzj;
            }
            if (iOrdinal != 6) {
                throw null;
            }
            zzick<zzay> zzickVar = zzk;
            if (zzickVar != null) {
                return zzickVar;
            }
            synchronized (zzay.class) {
                try {
                    zziamVar = zzk;
                    if (zziamVar == null) {
                        zziamVar = new zziam(zzj);
                        zzk = zziamVar;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return zziamVar;
        }
    }

    public interface zzaz extends zzicd {
    }

    public final class zzb extends zziar<zzb, zzc> implements zzc {
        public static final int zza = 1;
        private static final zzb zzc;
        private static volatile zzick<zzb> zzd;
        private zzibd<zza> zzb = zzicn.f34726e;

        public final class zza extends zziar<zza, C0026zza> implements InterfaceC0027zzb {
            public static final int zza = 1;
            public static final int zzb = 2;
            public static final int zzc = 3;
            private static final zza zzh;
            private static volatile zzick<zza> zzi;
            private int zzd;
            private int zze;
            private zze zzf;
            private zzg zzg;

            /* renamed from: com.google.android.gms.internal.ads.zzbfp$zzb$zza$zza, reason: collision with other inner class name */
            public final class C0026zza extends zzial<zza, C0026zza> implements InterfaceC0027zzb {
            }

            static {
                zza zzaVar = new zza();
                zzh = zzaVar;
                zziar.x(zza.class, zzaVar);
            }

            public static C0026zza E() {
                return (C0026zza) zzh.u();
            }

            public final void C(zzg zzgVar) {
                this.zzg = zzgVar;
                this.zzd |= 4;
            }

            public final void F() {
                this.zze = 1;
                this.zzd = 1 | this.zzd;
            }

            public final void G(zze zzeVar) {
                zzeVar.getClass();
                this.zzf = zzeVar;
                this.zzd |= 2;
            }

            @Override // com.google.android.gms.internal.ads.zziar
            public final Object y(zziaq zziaqVar, zziar zziarVar) {
                zzick zziamVar;
                int iOrdinal = zziaqVar.ordinal();
                if (iOrdinal == 0) {
                    return (byte) 1;
                }
                if (iOrdinal == 2) {
                    return new zzico(zzh, "\u0004\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001᠌\u0000\u0002ဉ\u0001\u0003ဉ\u0002", new Object[]{"zzd", "zze", zzd.zza.f24950a, "zzf", "zzg"});
                }
                if (iOrdinal == 3) {
                    return new zza();
                }
                if (iOrdinal == 4) {
                    return new C0026zza(zzh);
                }
                if (iOrdinal == 5) {
                    return zzh;
                }
                if (iOrdinal != 6) {
                    throw null;
                }
                zzick<zza> zzickVar = zzi;
                if (zzickVar != null) {
                    return zzickVar;
                }
                synchronized (zza.class) {
                    try {
                        zziamVar = zzi;
                        if (zziamVar == null) {
                            zziamVar = new zziam(zzh);
                            zzi = zziamVar;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                return zziamVar;
            }
        }

        /* renamed from: com.google.android.gms.internal.ads.zzbfp$zzb$zzb, reason: collision with other inner class name */
        public interface InterfaceC0027zzb extends zzicd {
        }

        public final class zzc extends zzial<zzb, zzc> implements zzc {
        }

        public enum zzd implements zziav {
            UNSPECIFIED(0),
            IN_MEMORY(1);


            /* renamed from: a, reason: collision with root package name */
            public final int f24949a;

            /* renamed from: com.google.android.gms.internal.ads.zzbfp$zzb$zzd$1, reason: invalid class name */
            public class AnonymousClass1 implements zziaw<zzd> {
            }

            final class zza implements zziax {

                /* renamed from: a, reason: collision with root package name */
                public static final zziax f24950a = new zza();

                @Override // com.google.android.gms.internal.ads.zziax
                public final boolean zza(int i2) {
                    return (i2 != 0 ? i2 != 1 ? null : zzd.IN_MEMORY : zzd.UNSPECIFIED) != null;
                }
            }

            zzd(int i2) {
                this.f24949a = i2;
            }

            @Override // java.lang.Enum
            public final String toString() {
                return Integer.toString(this.f24949a);
            }

            @Override // com.google.android.gms.internal.ads.zziav
            public final int zza() {
                return this.f24949a;
            }
        }

        public final class zze extends zziar<zze, zza> implements zzf {
            public static final int zza = 1;
            public static final int zzb = 2;
            private static final zze zzf;
            private static volatile zzick<zze> zzg;
            private int zzc;
            private boolean zzd;
            private int zze;

            public final class zza extends zzial<zze, zza> implements zzf {
            }

            static {
                zze zzeVar = new zze();
                zzf = zzeVar;
                zziar.x(zze.class, zzeVar);
            }

            public static zza C() {
                return (zza) zzf.u();
            }

            public static zze D() {
                return zzf;
            }

            public final void E(boolean z) {
                this.zzc |= 1;
                this.zzd = z;
            }

            public final void F(int i2) {
                this.zzc |= 2;
                this.zze = i2;
            }

            @Override // com.google.android.gms.internal.ads.zziar
            public final Object y(zziaq zziaqVar, zziar zziarVar) {
                zzick zziamVar;
                int iOrdinal = zziaqVar.ordinal();
                if (iOrdinal == 0) {
                    return (byte) 1;
                }
                if (iOrdinal == 2) {
                    return new zzico(zzf, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဇ\u0000\u0002ဋ\u0001", new Object[]{"zzc", "zzd", "zze"});
                }
                if (iOrdinal == 3) {
                    return new zze();
                }
                if (iOrdinal == 4) {
                    return new zza(zzf);
                }
                if (iOrdinal == 5) {
                    return zzf;
                }
                if (iOrdinal != 6) {
                    throw null;
                }
                zzick<zze> zzickVar = zzg;
                if (zzickVar != null) {
                    return zzickVar;
                }
                synchronized (zze.class) {
                    try {
                        zziamVar = zzg;
                        if (zziamVar == null) {
                            zziamVar = new zziam(zzf);
                            zzg = zziamVar;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                return zziamVar;
            }
        }

        public interface zzf extends zzicd {
        }

        public final class zzg extends zziar<zzg, zza> implements zzh {
            public static final int zza = 1;
            public static final int zzb = 2;
            public static final int zzc = 3;
            private static final zzg zzh;
            private static volatile zzick<zzg> zzi;
            private int zzd;
            private boolean zze;
            private boolean zzf;
            private int zzg;

            public final class zza extends zzial<zzg, zza> implements zzh {
            }

            static {
                zzg zzgVar = new zzg();
                zzh = zzgVar;
                zziar.x(zzg.class, zzgVar);
            }

            public static zza E() {
                return (zza) zzh.u();
            }

            public final void C(int i2) {
                this.zzd |= 4;
                this.zzg = i2;
            }

            public final void F(boolean z) {
                this.zzd |= 1;
                this.zze = z;
            }

            public final void G(boolean z) {
                this.zzd |= 2;
                this.zzf = z;
            }

            @Override // com.google.android.gms.internal.ads.zziar
            public final Object y(zziaq zziaqVar, zziar zziarVar) {
                zzick zziamVar;
                int iOrdinal = zziaqVar.ordinal();
                if (iOrdinal == 0) {
                    return (byte) 1;
                }
                if (iOrdinal == 2) {
                    return new zzico(zzh, "\u0004\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဇ\u0000\u0002ဇ\u0001\u0003ဋ\u0002", new Object[]{"zzd", "zze", "zzf", "zzg"});
                }
                if (iOrdinal == 3) {
                    return new zzg();
                }
                if (iOrdinal == 4) {
                    return new zza(zzh);
                }
                if (iOrdinal == 5) {
                    return zzh;
                }
                if (iOrdinal != 6) {
                    throw null;
                }
                zzick<zzg> zzickVar = zzi;
                if (zzickVar != null) {
                    return zzickVar;
                }
                synchronized (zzg.class) {
                    try {
                        zziamVar = zzi;
                        if (zziamVar == null) {
                            zziamVar = new zziam(zzh);
                            zzi = zziamVar;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                return zziamVar;
            }
        }

        public interface zzh extends zzicd {
        }

        static {
            zzb zzbVar = new zzb();
            zzc = zzbVar;
            zziar.x(zzb.class, zzbVar);
        }

        public static zzc D() {
            return (zzc) zzc.u();
        }

        public final void E(zza zzaVar) {
            zzibd<zza> zzibdVar = this.zzb;
            if (!zzibdVar.zza()) {
                int size = zzibdVar.size();
                this.zzb = zzibdVar.zzh(size + size);
            }
            this.zzb.add(zzaVar);
        }

        @Override // com.google.android.gms.internal.ads.zziar
        public final Object y(zziaq zziaqVar, zziar zziarVar) {
            zzick zziamVar;
            int iOrdinal = zziaqVar.ordinal();
            if (iOrdinal == 0) {
                return (byte) 1;
            }
            if (iOrdinal == 2) {
                return new zzico(zzc, "\u0004\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zzb", zza.class});
            }
            if (iOrdinal == 3) {
                return new zzb();
            }
            if (iOrdinal == 4) {
                return new zzc(zzc);
            }
            if (iOrdinal == 5) {
                return zzc;
            }
            if (iOrdinal != 6) {
                throw null;
            }
            zzick<zzb> zzickVar = zzd;
            if (zzickVar != null) {
                return zzickVar;
            }
            synchronized (zzb.class) {
                try {
                    zziamVar = zzd;
                    if (zziamVar == null) {
                        zziamVar = new zziam(zzc);
                        zzd = zziamVar;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return zziamVar;
        }
    }

    public final class zzba extends zziar<zzba, zza> implements zzbb {
        public static final int zza = 1;
        public static final int zzb = 2;
        public static final int zzc = 3;
        public static final int zzd = 4;
        public static final int zze = 5;
        private static final zzba zzl;
        private static volatile zzick<zzba> zzm;
        private int zzf;
        private int zzg = 1000;
        private zzaw zzh;
        private int zzi;
        private int zzj;
        private int zzk;

        public final class zza extends zzial<zzba, zza> implements zzbb {
        }

        static {
            zzba zzbaVar = new zzba();
            zzl = zzbaVar;
            zziar.x(zzba.class, zzbaVar);
        }

        @Override // com.google.android.gms.internal.ads.zziar
        public final Object y(zziaq zziaqVar, zziar zziarVar) {
            zzick zziamVar;
            int iOrdinal = zziaqVar.ordinal();
            if (iOrdinal == 0) {
                return (byte) 1;
            }
            if (iOrdinal == 2) {
                return new zzico(zzl, "\u0004\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001᠌\u0000\u0002ဉ\u0001\u0003င\u0002\u0004င\u0003\u0005င\u0004", new Object[]{"zzf", "zzg", zzq.zza.f24976a, "zzh", "zzi", "zzj", "zzk"});
            }
            if (iOrdinal == 3) {
                return new zzba();
            }
            if (iOrdinal == 4) {
                return new zza(zzl);
            }
            if (iOrdinal == 5) {
                return zzl;
            }
            if (iOrdinal != 6) {
                throw null;
            }
            zzick<zzba> zzickVar = zzm;
            if (zzickVar != null) {
                return zzickVar;
            }
            synchronized (zzba.class) {
                try {
                    zziamVar = zzm;
                    if (zziamVar == null) {
                        zziamVar = new zziam(zzl);
                        zzm = zziamVar;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return zziamVar;
        }
    }

    public interface zzbb extends zzicd {
    }

    public final class zzbc extends zziar<zzbc, zza> implements zzbd {
        public static final int zza = 1;
        public static final int zzb = 2;
        public static final int zzc = 3;
        private static final zzbc zzh;
        private static volatile zzick<zzbc> zzi;
        private int zzd;
        private int zze = 1000;
        private zzaw zzf;
        private zzap zzg;

        public final class zza extends zzial<zzbc, zza> implements zzbd {
        }

        static {
            zzbc zzbcVar = new zzbc();
            zzh = zzbcVar;
            zziar.x(zzbc.class, zzbcVar);
        }

        @Override // com.google.android.gms.internal.ads.zziar
        public final Object y(zziaq zziaqVar, zziar zziarVar) {
            zzick zziamVar;
            int iOrdinal = zziaqVar.ordinal();
            if (iOrdinal == 0) {
                return (byte) 1;
            }
            if (iOrdinal == 2) {
                return new zzico(zzh, "\u0004\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001᠌\u0000\u0002ဉ\u0001\u0003ဉ\u0002", new Object[]{"zzd", "zze", zzq.zza.f24976a, "zzf", "zzg"});
            }
            if (iOrdinal == 3) {
                return new zzbc();
            }
            if (iOrdinal == 4) {
                return new zza(zzh);
            }
            if (iOrdinal == 5) {
                return zzh;
            }
            if (iOrdinal != 6) {
                throw null;
            }
            zzick<zzbc> zzickVar = zzi;
            if (zzickVar != null) {
                return zzickVar;
            }
            synchronized (zzbc.class) {
                try {
                    zziamVar = zzi;
                    if (zziamVar == null) {
                        zziamVar = new zziam(zzh);
                        zzi = zziamVar;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return zziamVar;
        }
    }

    public interface zzbd extends zzicd {
    }

    public final class zzbe extends zziar<zzbe, zza> implements zzbf {
        public static final int zza = 1;
        public static final int zzb = 2;
        public static final int zzc = 3;
        public static final int zzd = 4;
        public static final int zze = 5;
        public static final int zzf = 6;
        private static final zzbe zzn;
        private static volatile zzick<zzbe> zzo;
        private int zzg;
        private int zzh = 1000;
        private zzaw zzi;
        private int zzj;
        private int zzk;
        private int zzl;
        private long zzm;

        public final class zza extends zzial<zzbe, zza> implements zzbf {
        }

        static {
            zzbe zzbeVar = new zzbe();
            zzn = zzbeVar;
            zziar.x(zzbe.class, zzbeVar);
        }

        @Override // com.google.android.gms.internal.ads.zziar
        public final Object y(zziaq zziaqVar, zziar zziarVar) {
            zzick zziamVar;
            int iOrdinal = zziaqVar.ordinal();
            if (iOrdinal == 0) {
                return (byte) 1;
            }
            if (iOrdinal == 2) {
                return new zzico(zzn, "\u0004\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001᠌\u0000\u0002ဉ\u0001\u0003င\u0002\u0004င\u0003\u0005င\u0004\u0006ဃ\u0005", new Object[]{"zzg", "zzh", zzq.zza.f24976a, "zzi", "zzj", "zzk", "zzl", "zzm"});
            }
            if (iOrdinal == 3) {
                return new zzbe();
            }
            if (iOrdinal == 4) {
                return new zza(zzn);
            }
            if (iOrdinal == 5) {
                return zzn;
            }
            if (iOrdinal != 6) {
                throw null;
            }
            zzick<zzbe> zzickVar = zzo;
            if (zzickVar != null) {
                return zzickVar;
            }
            synchronized (zzbe.class) {
                try {
                    zziamVar = zzo;
                    if (zziamVar == null) {
                        zziamVar = new zziam(zzn);
                        zzo = zziamVar;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return zziamVar;
        }
    }

    public interface zzbf extends zzicd {
    }

    public final class zzbg extends zziar<zzbg, zza> implements zzbh {
        public static final int zza = 1;
        public static final int zzb = 2;
        public static final int zzc = 3;
        private static final zzbg zzh;
        private static volatile zzick<zzbg> zzi;
        private int zzd;
        private int zze = 1000;
        private zzaw zzf;
        private zzap zzg;

        public final class zza extends zzial<zzbg, zza> implements zzbh {
        }

        static {
            zzbg zzbgVar = new zzbg();
            zzh = zzbgVar;
            zziar.x(zzbg.class, zzbgVar);
        }

        @Override // com.google.android.gms.internal.ads.zziar
        public final Object y(zziaq zziaqVar, zziar zziarVar) {
            zzick zziamVar;
            int iOrdinal = zziaqVar.ordinal();
            if (iOrdinal == 0) {
                return (byte) 1;
            }
            if (iOrdinal == 2) {
                return new zzico(zzh, "\u0004\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001᠌\u0000\u0002ဉ\u0001\u0003ဉ\u0002", new Object[]{"zzd", "zze", zzq.zza.f24976a, "zzf", "zzg"});
            }
            if (iOrdinal == 3) {
                return new zzbg();
            }
            if (iOrdinal == 4) {
                return new zza(zzh);
            }
            if (iOrdinal == 5) {
                return zzh;
            }
            if (iOrdinal != 6) {
                throw null;
            }
            zzick<zzbg> zzickVar = zzi;
            if (zzickVar != null) {
                return zzickVar;
            }
            synchronized (zzbg.class) {
                try {
                    zziamVar = zzi;
                    if (zziamVar == null) {
                        zziamVar = new zziam(zzh);
                        zzi = zziamVar;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return zziamVar;
        }
    }

    public interface zzbh extends zzicd {
    }

    public interface zzbi extends zzicd {
    }

    public final class zzbj extends zziar<zzbj, zza> implements zzbk {
        public static final int zza = 1;
        public static final int zzb = 2;
        private static final zzbj zzf;
        private static volatile zzick<zzbj> zzg;
        private int zzc;
        private int zzd = 1000;
        private zzaw zze;

        public final class zza extends zzial<zzbj, zza> implements zzbk {
        }

        static {
            zzbj zzbjVar = new zzbj();
            zzf = zzbjVar;
            zziar.x(zzbj.class, zzbjVar);
        }

        @Override // com.google.android.gms.internal.ads.zziar
        public final Object y(zziaq zziaqVar, zziar zziarVar) {
            zzick zziamVar;
            int iOrdinal = zziaqVar.ordinal();
            if (iOrdinal == 0) {
                return (byte) 1;
            }
            if (iOrdinal == 2) {
                return new zzico(zzf, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001᠌\u0000\u0002ဉ\u0001", new Object[]{"zzc", "zzd", zzq.zza.f24976a, "zze"});
            }
            if (iOrdinal == 3) {
                return new zzbj();
            }
            if (iOrdinal == 4) {
                return new zza(zzf);
            }
            if (iOrdinal == 5) {
                return zzf;
            }
            if (iOrdinal != 6) {
                throw null;
            }
            zzick<zzbj> zzickVar = zzg;
            if (zzickVar != null) {
                return zzickVar;
            }
            synchronized (zzbj.class) {
                try {
                    zziamVar = zzg;
                    if (zziamVar == null) {
                        zziamVar = new zziam(zzf);
                        zzg = zziamVar;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return zziamVar;
        }
    }

    public interface zzbk extends zzicd {
    }

    public final class zzbl extends zziar<zzbl, zza> implements zzbm {
        public static final int zza = 1;
        public static final int zzb = 2;
        private static final zzbl zzf;
        private static volatile zzick<zzbl> zzg;
        private int zzc;
        private boolean zzd;
        private int zze;

        public final class zza extends zzial<zzbl, zza> implements zzbm {
        }

        static {
            zzbl zzblVar = new zzbl();
            zzf = zzblVar;
            zziar.x(zzbl.class, zzblVar);
        }

        public static zza D() {
            return (zza) zzf.u();
        }

        public final boolean C() {
            return this.zzd;
        }

        public final void E(boolean z) {
            this.zzc |= 1;
            this.zzd = z;
        }

        public final void F(int i2) {
            this.zzc |= 2;
            this.zze = i2;
        }

        @Override // com.google.android.gms.internal.ads.zziar
        public final Object y(zziaq zziaqVar, zziar zziarVar) {
            zzick zziamVar;
            int iOrdinal = zziaqVar.ordinal();
            if (iOrdinal == 0) {
                return (byte) 1;
            }
            if (iOrdinal == 2) {
                return new zzico(zzf, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဇ\u0000\u0002င\u0001", new Object[]{"zzc", "zzd", "zze"});
            }
            if (iOrdinal == 3) {
                return new zzbl();
            }
            if (iOrdinal == 4) {
                return new zza(zzf);
            }
            if (iOrdinal == 5) {
                return zzf;
            }
            if (iOrdinal != 6) {
                throw null;
            }
            zzick<zzbl> zzickVar = zzg;
            if (zzickVar != null) {
                return zzickVar;
            }
            synchronized (zzbl.class) {
                try {
                    zziamVar = zzg;
                    if (zziamVar == null) {
                        zziamVar = new zziam(zzf);
                        zzg = zziamVar;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return zziamVar;
        }
    }

    public interface zzbm extends zzicd {
    }

    public interface zzc extends zzicd {
    }

    public final class zzd extends zziar<zzd, zzb> implements zze {
        public static final int zza = 1;
        public static final int zzb = 2;
        private static final zzd zzf;
        private static volatile zzick<zzd> zzg;
        private int zzc;
        private int zzd;
        private zzal zze;

        public enum zza implements zziav {
            AD_FORMAT_TYPE_UNSPECIFIED(0),
            BANNER(1),
            INTERSTITIAL(2),
            NATIVE_EXPRESS(3),
            NATIVE_CONTENT(4),
            NATIVE_APP_INSTALL(5),
            NATIVE_CUSTOM_TEMPLATE(6),
            DFP_BANNER(7),
            DFP_INTERSTITIAL(8),
            REWARD_BASED_VIDEO_AD(9),
            BANNER_SEARCH_ADS(10);


            /* renamed from: a, reason: collision with root package name */
            public final int f24963a;

            /* renamed from: com.google.android.gms.internal.ads.zzbfp$zzd$zza$1, reason: invalid class name */
            public class AnonymousClass1 implements zziaw<zza> {
            }

            /* renamed from: com.google.android.gms.internal.ads.zzbfp$zzd$zza$zza, reason: collision with other inner class name */
            final class C0028zza implements zziax {

                /* renamed from: a, reason: collision with root package name */
                public static final zziax f24964a = new C0028zza();

                @Override // com.google.android.gms.internal.ads.zziax
                public final boolean zza(int i2) {
                    zza zzaVar;
                    switch (i2) {
                        case 0:
                            zzaVar = zza.AD_FORMAT_TYPE_UNSPECIFIED;
                            break;
                        case 1:
                            zzaVar = zza.BANNER;
                            break;
                        case 2:
                            zzaVar = zza.INTERSTITIAL;
                            break;
                        case 3:
                            zzaVar = zza.NATIVE_EXPRESS;
                            break;
                        case 4:
                            zzaVar = zza.NATIVE_CONTENT;
                            break;
                        case 5:
                            zzaVar = zza.NATIVE_APP_INSTALL;
                            break;
                        case 6:
                            zzaVar = zza.NATIVE_CUSTOM_TEMPLATE;
                            break;
                        case 7:
                            zzaVar = zza.DFP_BANNER;
                            break;
                        case 8:
                            zzaVar = zza.DFP_INTERSTITIAL;
                            break;
                        case 9:
                            zzaVar = zza.REWARD_BASED_VIDEO_AD;
                            break;
                        case 10:
                            zzaVar = zza.BANNER_SEARCH_ADS;
                            break;
                        default:
                            zzaVar = null;
                            break;
                    }
                    return zzaVar != null;
                }
            }

            zza(int i2) {
                this.f24963a = i2;
            }

            @Override // java.lang.Enum
            public final String toString() {
                return Integer.toString(this.f24963a);
            }

            @Override // com.google.android.gms.internal.ads.zziav
            public final int zza() {
                return this.f24963a;
            }
        }

        public final class zzb extends zzial<zzd, zzb> implements zze {
        }

        static {
            zzd zzdVar = new zzd();
            zzf = zzdVar;
            zziar.x(zzd.class, zzdVar);
        }

        @Override // com.google.android.gms.internal.ads.zziar
        public final Object y(zziaq zziaqVar, zziar zziarVar) {
            zzick zziamVar;
            int iOrdinal = zziaqVar.ordinal();
            if (iOrdinal == 0) {
                return (byte) 1;
            }
            if (iOrdinal == 2) {
                return new zzico(zzf, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001᠌\u0000\u0002ဉ\u0001", new Object[]{"zzc", "zzd", zza.C0028zza.f24964a, "zze"});
            }
            if (iOrdinal == 3) {
                return new zzd();
            }
            if (iOrdinal == 4) {
                return new zzb(zzf);
            }
            if (iOrdinal == 5) {
                return zzf;
            }
            if (iOrdinal != 6) {
                throw null;
            }
            zzick<zzd> zzickVar = zzg;
            if (zzickVar != null) {
                return zzickVar;
            }
            synchronized (zzd.class) {
                try {
                    zziamVar = zzg;
                    if (zziamVar == null) {
                        zziamVar = new zziam(zzf);
                        zzg = zziamVar;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return zziamVar;
        }
    }

    public interface zze extends zzicd {
    }

    public interface zzf extends zzicd {
    }

    public final class zzg extends zziar<zzg, zza> implements zzh {
        public static final int zza = 1;
        public static final int zzb = 2;
        public static final int zzc = 3;
        private static final zzg zzh;
        private static volatile zzick<zzg> zzi;
        private int zzd;
        private String zze = "";
        private zzibd<zzd> zzf = zzicn.f34726e;
        private int zzg;

        public final class zza extends zzial<zzg, zza> implements zzh {
        }

        static {
            zzg zzgVar = new zzg();
            zzh = zzgVar;
            zziar.x(zzg.class, zzgVar);
        }

        @Override // com.google.android.gms.internal.ads.zziar
        public final Object y(zziaq zziaqVar, zziar zziarVar) {
            zzick zziamVar;
            int iOrdinal = zziaqVar.ordinal();
            if (iOrdinal == 0) {
                return (byte) 1;
            }
            if (iOrdinal == 2) {
                return new zzico(zzh, "\u0004\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0001\u0000\u0001ဈ\u0000\u0002\u001b\u0003᠌\u0001", new Object[]{"zzd", "zze", "zzf", zzd.class, "zzg", zzq.zza.f24976a});
            }
            if (iOrdinal == 3) {
                return new zzg();
            }
            if (iOrdinal == 4) {
                return new zza(zzh);
            }
            if (iOrdinal == 5) {
                return zzh;
            }
            if (iOrdinal != 6) {
                throw null;
            }
            zzick<zzg> zzickVar = zzi;
            if (zzickVar != null) {
                return zzickVar;
            }
            synchronized (zzg.class) {
                try {
                    zziamVar = zzi;
                    if (zziamVar == null) {
                        zziamVar = new zziam(zzh);
                        zzi = zziamVar;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return zziamVar;
        }
    }

    public interface zzh extends zzicd {
    }

    public final class zzi extends zziar<zzi, zza> implements zzj {
        public static final int zza = 1;
        public static final int zzb = 2;
        public static final int zzc = 3;
        public static final int zzd = 4;
        public static final int zze = 5;
        private static final zzi zzl;
        private static volatile zzick<zzi> zzm;
        private int zzf;
        private String zzg = "";
        private zzibd<zzd> zzh = zzicn.f34726e;
        private int zzi = 1000;
        private int zzj = 1000;
        private int zzk = 1000;

        public final class zza extends zzial<zzi, zza> implements zzj {
        }

        static {
            zzi zziVar = new zzi();
            zzl = zziVar;
            zziar.x(zzi.class, zziVar);
        }

        public static zzi C() {
            return zzl;
        }

        public final void D(String str) {
            str.getClass();
            this.zzf |= 1;
            this.zzg = str;
        }

        @Override // com.google.android.gms.internal.ads.zziar
        public final Object y(zziaq zziaqVar, zziar zziarVar) {
            zzick zziamVar;
            int iOrdinal = zziaqVar.ordinal();
            if (iOrdinal == 0) {
                return (byte) 1;
            }
            if (iOrdinal == 2) {
                zziax zziaxVar = zzq.zza.f24976a;
                return new zzico(zzl, "\u0004\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0001\u0000\u0001ဈ\u0000\u0002\u001b\u0003᠌\u0001\u0004᠌\u0002\u0005᠌\u0003", new Object[]{"zzf", "zzg", "zzh", zzd.class, "zzi", zziaxVar, "zzj", zziaxVar, "zzk", zziaxVar});
            }
            if (iOrdinal == 3) {
                return new zzi();
            }
            if (iOrdinal == 4) {
                return new zza(zzl);
            }
            if (iOrdinal == 5) {
                return zzl;
            }
            if (iOrdinal != 6) {
                throw null;
            }
            zzick<zzi> zzickVar = zzm;
            if (zzickVar != null) {
                return zzickVar;
            }
            synchronized (zzi.class) {
                try {
                    zziamVar = zzm;
                    if (zziamVar == null) {
                        zziamVar = new zziam(zzl);
                        zzm = zziamVar;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return zziamVar;
        }
    }

    public interface zzj extends zzicd {
    }

    public final class zzk extends zziar<zzk, zza> implements zzl {
        public static final int zza = 1;
        public static final int zzb = 2;
        public static final int zzc = 3;
        public static final int zzd = 4;
        public static final int zze = 5;
        public static final int zzf = 6;
        private static final zzk zzn;
        private static volatile zzick<zzk> zzo;
        private int zzg;
        private int zzh;
        private zzap zzi;
        private zzap zzj;
        private zzap zzk;
        private zzibd<zzap> zzl = zzicn.f34726e;
        private int zzm;

        public final class zza extends zzial<zzk, zza> implements zzl {
        }

        static {
            zzk zzkVar = new zzk();
            zzn = zzkVar;
            zziar.x(zzk.class, zzkVar);
        }

        @Override // com.google.android.gms.internal.ads.zziar
        public final Object y(zziaq zziaqVar, zziar zziarVar) {
            zzick zziamVar;
            int iOrdinal = zziaqVar.ordinal();
            if (iOrdinal == 0) {
                return (byte) 1;
            }
            if (iOrdinal == 2) {
                return new zzico(zzn, "\u0004\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0001\u0000\u0001င\u0000\u0002ဉ\u0001\u0003ဉ\u0002\u0004ဉ\u0003\u0005\u001b\u0006င\u0004", new Object[]{"zzg", "zzh", "zzi", "zzj", "zzk", "zzl", zzap.class, "zzm"});
            }
            if (iOrdinal == 3) {
                return new zzk();
            }
            if (iOrdinal == 4) {
                return new zza(zzn);
            }
            if (iOrdinal == 5) {
                return zzn;
            }
            if (iOrdinal != 6) {
                throw null;
            }
            zzick<zzk> zzickVar = zzo;
            if (zzickVar != null) {
                return zzickVar;
            }
            synchronized (zzk.class) {
                try {
                    zziamVar = zzo;
                    if (zziamVar == null) {
                        zziamVar = new zziam(zzn);
                        zzo = zziamVar;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return zziamVar;
        }
    }

    public interface zzl extends zzicd {
    }

    public final class zzm extends zziar<zzm, zza> implements zzn {
        public static final int zza = 1;
        public static final int zzb = 2;
        public static final int zzc = 3;
        public static final int zzd = 4;
        public static final int zze = 5;
        public static final int zzf = 6;
        public static final int zzg = 7;
        public static final int zzh = 8;
        private static final zzm zzv;
        private static volatile zzick<zzm> zzw;
        private int zzi;
        private zzap zzk;
        private int zzl;
        private zzar zzm;
        private int zzn;
        private String zzj = "";
        private int zzo = 1000;
        private int zzp = 1000;
        private int zzu = 1000;

        public final class zza extends zzial<zzm, zza> implements zzn {
        }

        static {
            zzm zzmVar = new zzm();
            zzv = zzmVar;
            zziar.x(zzm.class, zzmVar);
        }

        public static zzm C() {
            return zzv;
        }

        public final void D(String str) {
            this.zzi |= 1;
            this.zzj = str;
        }

        public final void E(zzar zzarVar) {
            this.zzm = zzarVar;
            this.zzi |= 8;
        }

        @Override // com.google.android.gms.internal.ads.zziar
        public final Object y(zziaq zziaqVar, zziar zziarVar) {
            zzick zziamVar;
            int iOrdinal = zziaqVar.ordinal();
            if (iOrdinal == 0) {
                return (byte) 1;
            }
            if (iOrdinal == 2) {
                zziax zziaxVar = zzq.zza.f24976a;
                return new zzico(zzv, "\u0004\b\u0000\u0001\u0001\b\b\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဉ\u0001\u0003င\u0002\u0004ဉ\u0003\u0005င\u0004\u0006᠌\u0005\u0007᠌\u0006\b᠌\u0007", new Object[]{"zzi", "zzj", "zzk", "zzl", "zzm", "zzn", "zzo", zziaxVar, "zzp", zziaxVar, "zzu", zziaxVar});
            }
            if (iOrdinal == 3) {
                return new zzm();
            }
            if (iOrdinal == 4) {
                return new zza(zzv);
            }
            if (iOrdinal == 5) {
                return zzv;
            }
            if (iOrdinal != 6) {
                throw null;
            }
            zzick<zzm> zzickVar = zzw;
            if (zzickVar != null) {
                return zzickVar;
            }
            synchronized (zzm.class) {
                try {
                    zziamVar = zzw;
                    if (zziamVar == null) {
                        zziamVar = new zziam(zzv);
                        zzw = zziamVar;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return zziamVar;
        }
    }

    public interface zzn extends zzicd {
    }

    public final class zzo extends zziar<zzo, zza> implements zzp {
        public static final int zza = 5;
        public static final int zzb = 6;
        public static final int zzc = 7;
        public static final int zzd = 8;
        private static final zzo zzj;
        private static volatile zzick<zzo> zzk;
        private int zze;
        private int zzf;
        private zzar zzg;
        private String zzh = "";
        private String zzi = "";

        public final class zza extends zzial<zzo, zza> implements zzp {
        }

        public enum zzb implements zziav {
            PLATFORM_UNSPECIFIED(0),
            IOS(1),
            ANDROID(2);


            /* renamed from: a, reason: collision with root package name */
            public final int f24969a;

            /* renamed from: com.google.android.gms.internal.ads.zzbfp$zzo$zzb$1, reason: invalid class name */
            public class AnonymousClass1 implements zziaw<zzb> {
            }

            final class zza implements zziax {

                /* renamed from: a, reason: collision with root package name */
                public static final zziax f24970a = new zza();

                @Override // com.google.android.gms.internal.ads.zziax
                public final boolean zza(int i2) {
                    return (i2 != 0 ? i2 != 1 ? i2 != 2 ? null : zzb.ANDROID : zzb.IOS : zzb.PLATFORM_UNSPECIFIED) != null;
                }
            }

            zzb(int i2) {
                this.f24969a = i2;
            }

            @Override // java.lang.Enum
            public final String toString() {
                return Integer.toString(this.f24969a);
            }

            @Override // com.google.android.gms.internal.ads.zziav
            public final int zza() {
                return this.f24969a;
            }
        }

        static {
            zzo zzoVar = new zzo();
            zzj = zzoVar;
            zziar.x(zzo.class, zzoVar);
        }

        @Override // com.google.android.gms.internal.ads.zziar
        public final Object y(zziaq zziaqVar, zziar zziarVar) {
            zzick zziamVar;
            int iOrdinal = zziaqVar.ordinal();
            if (iOrdinal == 0) {
                return (byte) 1;
            }
            if (iOrdinal == 2) {
                return new zzico(zzj, "\u0004\u0004\u0000\u0001\u0005\b\u0004\u0000\u0000\u0000\u0005᠌\u0000\u0006ဉ\u0001\u0007ဈ\u0002\bဈ\u0003", new Object[]{"zze", "zzf", zzb.zza.f24970a, "zzg", "zzh", "zzi"});
            }
            if (iOrdinal == 3) {
                return new zzo();
            }
            if (iOrdinal == 4) {
                return new zza(zzj);
            }
            if (iOrdinal == 5) {
                return zzj;
            }
            if (iOrdinal != 6) {
                throw null;
            }
            zzick<zzo> zzickVar = zzk;
            if (zzickVar != null) {
                return zzickVar;
            }
            synchronized (zzo.class) {
                try {
                    zziamVar = zzk;
                    if (zziamVar == null) {
                        zziamVar = new zziam(zzj);
                        zzk = zziamVar;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return zziamVar;
        }
    }

    public interface zzp extends zzicd {
    }

    public enum zzq implements zziav {
        ENUM_FALSE(0),
        ENUM_TRUE(1),
        ENUM_UNKNOWN(1000);


        /* renamed from: a, reason: collision with root package name */
        public final int f24975a;

        /* renamed from: com.google.android.gms.internal.ads.zzbfp$zzq$1, reason: invalid class name */
        public class AnonymousClass1 implements zziaw<zzq> {
        }

        final class zza implements zziax {

            /* renamed from: a, reason: collision with root package name */
            public static final zziax f24976a = new zza();

            @Override // com.google.android.gms.internal.ads.zziax
            public final boolean zza(int i2) {
                return (i2 != 0 ? i2 != 1 ? i2 != 1000 ? null : zzq.ENUM_UNKNOWN : zzq.ENUM_TRUE : zzq.ENUM_FALSE) != null;
            }
        }

        zzq(int i2) {
            this.f24975a = i2;
        }

        @Override // java.lang.Enum
        public final String toString() {
            return Integer.toString(this.f24975a);
        }

        @Override // com.google.android.gms.internal.ads.zziav
        public final int zza() {
            return this.f24975a;
        }
    }

    public final class zzr extends zziar<zzr, zza> implements zzs {
        private static final zzr zzB;
        private static volatile zzick<zzr> zzC = null;
        public static final int zza = 7;
        public static final int zzb = 8;
        public static final int zzc = 9;
        public static final int zzd = 10;
        public static final int zze = 11;
        public static final int zzf = 12;
        public static final int zzg = 13;
        public static final int zzh = 14;
        public static final int zzi = 15;
        public static final int zzj = 16;
        private int zzk;
        private int zzl;
        private zzar zzn;
        private int zzo;
        private int zzv;
        private int zzw;
        private zziaz zzx;
        private zziaz zzz;
        private static final zziba<zzd.zza> zzy = new AnonymousClass1();
        private static final zziba<zzd.zza> zzA = new AnonymousClass2();
        private String zzm = "";
        private String zzp = "";
        private String zzu = "";

        /* renamed from: com.google.android.gms.internal.ads.zzbfp$zzr$1, reason: invalid class name */
        public class AnonymousClass1 implements zziba<zzd.zza> {
        }

        /* renamed from: com.google.android.gms.internal.ads.zzbfp$zzr$2, reason: invalid class name */
        public class AnonymousClass2 implements zziba<zzd.zza> {
        }

        public final class zza extends zzial<zzr, zza> implements zzs {
        }

        static {
            zzr zzrVar = new zzr();
            zzB = zzrVar;
            zziar.x(zzr.class, zzrVar);
        }

        public zzr() {
            zzias zziasVar = zzias.f34649e;
            this.zzx = zziasVar;
            this.zzz = zziasVar;
        }

        @Override // com.google.android.gms.internal.ads.zziar
        public final Object y(zziaq zziaqVar, zziar zziarVar) {
            zzick zziamVar;
            int iOrdinal = zziaqVar.ordinal();
            if (iOrdinal == 0) {
                return (byte) 1;
            }
            if (iOrdinal == 2) {
                zziax zziaxVar = zzo.zzb.zza.f24970a;
                zziax zziaxVar2 = zzab.zzc.zza.f24929a;
                zziax zziaxVar3 = zza.EnumC0023zza.C0024zza.f24916a;
                zziax zziaxVar4 = zzd.zza.C0028zza.f24964a;
                return new zzico(zzB, "\u0004\n\u0000\u0001\u0007\u0010\n\u0000\u0002\u0000\u0007င\u0000\bဈ\u0001\tဉ\u0002\n᠌\u0003\u000bဈ\u0004\fဈ\u0005\r᠌\u0006\u000e᠌\u0007\u000fࠞ\u0010ࠞ", new Object[]{"zzk", "zzl", "zzm", "zzn", "zzo", zziaxVar, "zzp", "zzu", "zzv", zziaxVar2, "zzw", zziaxVar3, "zzx", zziaxVar4, "zzz", zziaxVar4});
            }
            if (iOrdinal == 3) {
                return new zzr();
            }
            if (iOrdinal == 4) {
                return new zza(zzB);
            }
            if (iOrdinal == 5) {
                return zzB;
            }
            if (iOrdinal != 6) {
                throw null;
            }
            zzick<zzr> zzickVar = zzC;
            if (zzickVar != null) {
                return zzickVar;
            }
            synchronized (zzr.class) {
                try {
                    zziamVar = zzC;
                    if (zziamVar == null) {
                        zziamVar = new zziam(zzB);
                        zzC = zziamVar;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return zziamVar;
        }
    }

    public interface zzs extends zzicd {
    }

    public final class zzt extends zziar<zzt, zza> implements zzu {
        private static final zzt zzF;
        private static volatile zzick<zzt> zzG = null;
        public static final int zza = 9;
        public static final int zzb = 10;
        public static final int zzc = 11;
        public static final int zzd = 12;
        public static final int zze = 13;
        public static final int zzf = 14;
        public static final int zzg = 15;
        public static final int zzh = 16;
        public static final int zzi = 17;
        public static final int zzj = 18;
        public static final int zzk = 19;
        public static final int zzl = 20;
        public static final int zzm = 21;
        private zzab zzA;
        private zza zzB;
        private zzaf zzC;
        private zzbl zzD;
        private zzb zzE;
        private int zzn;
        private int zzo;
        private int zzu;
        private zzar zzw;
        private zzm zzy;
        private zzo zzz;
        private String zzp = "";
        private int zzv = 1000;
        private zzibc zzx = zzibq.f34690e;

        public final class zza extends zzial<zzt, zza> implements zzu {
        }

        static {
            zzt zztVar = new zzt();
            zzF = zztVar;
            zziar.x(zzt.class, zztVar);
        }

        public static zza O() {
            return (zza) zzF.u();
        }

        public final zzm C() {
            zzm zzmVar = this.zzy;
            return zzmVar == null ? zzm.C() : zzmVar;
        }

        public final void D(String str) {
            str.getClass();
            this.zzn |= 2;
            this.zzp = str;
        }

        public final zza E() {
            zza zzaVar = this.zzB;
            return zzaVar == null ? zza.C() : zzaVar;
        }

        public final void F(zzb zzbVar) {
            this.zzE = zzbVar;
            this.zzn |= 2048;
        }

        public final void H(ArrayList arrayList) {
            zzibc zzibcVar = this.zzx;
            if (!zzibcVar.zza()) {
                int size = zzibcVar.size();
                this.zzx = zzibcVar.zzh(size + size);
            }
            zzhyu.j(arrayList, this.zzx);
        }

        public final void I() {
            this.zzx = zzibq.f34690e;
        }

        public final void J(zzm zzmVar) {
            this.zzy = zzmVar;
            this.zzn |= 32;
        }

        public final void K(zza zzaVar) {
            this.zzB = zzaVar;
            this.zzn |= 256;
        }

        public final void L(zzaf zzafVar) {
            this.zzC = zzafVar;
            this.zzn |= 512;
        }

        public final void M(zzbl zzblVar) {
            this.zzD = zzblVar;
            this.zzn |= 1024;
        }

        public final String N() {
            return this.zzp;
        }

        @Override // com.google.android.gms.internal.ads.zziar
        public final Object y(zziaq zziaqVar, zziar zziarVar) {
            zzick zziamVar;
            int iOrdinal = zziaqVar.ordinal();
            if (iOrdinal == 0) {
                return (byte) 1;
            }
            if (iOrdinal == 2) {
                return new zzico(zzF, "\u0004\r\u0000\u0001\t\u0015\r\u0000\u0001\u0000\tင\u0000\nဈ\u0001\u000bဋ\u0002\f᠌\u0003\rဉ\u0004\u000e\u0015\u000fဉ\u0005\u0010ဉ\u0006\u0011ဉ\u0007\u0012ဉ\b\u0013ဉ\t\u0014ဉ\n\u0015ဉ\u000b", new Object[]{"zzn", "zzo", "zzp", "zzu", "zzv", zzq.zza.f24976a, "zzw", "zzx", "zzy", "zzz", "zzA", "zzB", "zzC", "zzD", "zzE"});
            }
            if (iOrdinal == 3) {
                return new zzt();
            }
            if (iOrdinal == 4) {
                return new zza(zzF);
            }
            if (iOrdinal == 5) {
                return zzF;
            }
            if (iOrdinal != 6) {
                throw null;
            }
            zzick<zzt> zzickVar = zzG;
            if (zzickVar != null) {
                return zzickVar;
            }
            synchronized (zzt.class) {
                try {
                    zziamVar = zzG;
                    if (zziamVar == null) {
                        zziamVar = new zziam(zzF);
                        zzG = zziamVar;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return zziamVar;
        }
    }

    public interface zzu extends zzicd {
    }

    public final class zzv extends zziar<zzv, zza> implements zzw {
        public static final int zza = 1;
        public static final int zzb = 2;
        public static final int zzc = 3;
        public static final int zzd = 4;
        private static final zzv zzj;
        private static volatile zzick<zzv> zzk;
        private int zze;
        private int zzg;
        private zzap zzi;
        private String zzf = "";
        private zziaz zzh = zzias.f34649e;

        public final class zza extends zzial<zzv, zza> implements zzw {
        }

        static {
            zzv zzvVar = new zzv();
            zzj = zzvVar;
            zziar.x(zzv.class, zzvVar);
        }

        @Override // com.google.android.gms.internal.ads.zziar
        public final Object y(zziaq zziaqVar, zziar zziarVar) {
            zzick zziamVar;
            int iOrdinal = zziaqVar.ordinal();
            if (iOrdinal == 0) {
                return (byte) 1;
            }
            if (iOrdinal == 2) {
                return new zzico(zzj, "\u0004\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001ဈ\u0000\u0002᠌\u0001\u0003\u0016\u0004ဉ\u0002", new Object[]{"zze", "zzf", "zzg", zzq.zza.f24976a, "zzh", "zzi"});
            }
            if (iOrdinal == 3) {
                return new zzv();
            }
            if (iOrdinal == 4) {
                return new zza(zzj);
            }
            if (iOrdinal == 5) {
                return zzj;
            }
            if (iOrdinal != 6) {
                throw null;
            }
            zzick<zzv> zzickVar = zzk;
            if (zzickVar != null) {
                return zzickVar;
            }
            synchronized (zzv.class) {
                try {
                    zziamVar = zzk;
                    if (zziamVar == null) {
                        zziamVar = new zziam(zzj);
                        zzk = zziamVar;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return zziamVar;
        }
    }

    public interface zzw extends zzicd {
    }

    public final class zzx extends zziar<zzx, zza> implements zzy {
        public static final int zza = 1;
        public static final int zzb = 2;
        private static final zzx zzf;
        private static volatile zzick<zzx> zzg;
        private int zzc;
        private int zzd;
        private zziaz zze = zzias.f34649e;

        public final class zza extends zzial<zzx, zza> implements zzy {
        }

        static {
            zzx zzxVar = new zzx();
            zzf = zzxVar;
            zziar.x(zzx.class, zzxVar);
        }

        @Override // com.google.android.gms.internal.ads.zziar
        public final Object y(zziaq zziaqVar, zziar zziarVar) {
            zzick zziamVar;
            int iOrdinal = zziaqVar.ordinal();
            if (iOrdinal == 0) {
                return (byte) 1;
            }
            if (iOrdinal == 2) {
                return new zzico(zzf, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001᠌\u0000\u0002\u0016", new Object[]{"zzc", "zzd", zzq.zza.f24976a, "zze"});
            }
            if (iOrdinal == 3) {
                return new zzx();
            }
            if (iOrdinal == 4) {
                return new zza(zzf);
            }
            if (iOrdinal == 5) {
                return zzf;
            }
            if (iOrdinal != 6) {
                throw null;
            }
            zzick<zzx> zzickVar = zzg;
            if (zzickVar != null) {
                return zzickVar;
            }
            synchronized (zzx.class) {
                try {
                    zziamVar = zzg;
                    if (zziamVar == null) {
                        zziamVar = new zziam(zzf);
                        zzg = zziamVar;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return zziamVar;
        }
    }

    public interface zzy extends zzicd {
    }

    public final class zzz extends zziar<zzz, zza> implements zzaa {
        public static final int zza = 1;
        public static final int zzb = 2;
        public static final int zzc = 3;
        public static final int zzd = 4;
        private static final zzz zzj;
        private static volatile zzick<zzz> zzk;
        private int zze;
        private zzv zzf;
        private zzibd<zzan> zzg = zzicn.f34726e;
        private int zzh;
        private zzap zzi;

        public final class zza extends zzial<zzz, zza> implements zzaa {
        }

        static {
            zzz zzzVar = new zzz();
            zzj = zzzVar;
            zziar.x(zzz.class, zzzVar);
        }

        @Override // com.google.android.gms.internal.ads.zziar
        public final Object y(zziaq zziaqVar, zziar zziarVar) {
            zzick zziamVar;
            int iOrdinal = zziaqVar.ordinal();
            if (iOrdinal == 0) {
                return (byte) 1;
            }
            if (iOrdinal == 2) {
                return new zzico(zzj, "\u0004\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001ဉ\u0000\u0002\u001b\u0003᠌\u0001\u0004ဉ\u0002", new Object[]{"zze", "zzf", "zzg", zzan.class, "zzh", zzq.zza.f24976a, "zzi"});
            }
            if (iOrdinal == 3) {
                return new zzz();
            }
            if (iOrdinal == 4) {
                return new zza(zzj);
            }
            if (iOrdinal == 5) {
                return zzj;
            }
            if (iOrdinal != 6) {
                throw null;
            }
            zzick<zzz> zzickVar = zzk;
            if (zzickVar != null) {
                return zzickVar;
            }
            synchronized (zzz.class) {
                try {
                    zziamVar = zzk;
                    if (zziamVar == null) {
                        zziamVar = new zziam(zzj);
                        zzk = zziamVar;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return zziamVar;
        }
    }
}
