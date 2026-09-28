package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.net.NetworkCapabilities;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

/* loaded from: classes4.dex */
public class zzayo extends zzaym {
    public static long A = 0;
    public static zzayw B = null;
    public static zzbac C = null;
    public static zzazu D = null;
    public static zzaxn E = null;
    public static zzayt F = null;
    public static final Object y = new Object();
    public static boolean z = false;
    public final zzayn v;
    public zzbaa w;
    public final HashMap x;

    public zzayo(Context context, zzayn zzaynVar) {
        super(context);
        this.x = new HashMap();
        this.v = zzaynVar;
    }

    public static zzazt q(Context context, boolean z2) {
        if (zzaym.u == null) {
            synchronized (y) {
                try {
                    if (zzaym.u == null) {
                        zzazt zzaztVarA = zzazt.a(context, z2, F);
                        if (zzaztVarA.n) {
                            try {
                                if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.U3)).booleanValue()) {
                                    zzaztVarA.c("hTLiiIA7LJpRCIVGwbLw56sBtWYdpFA3KN/lVIAoqlyIo4UMQoQK3mH52LWi8hnG", "S64wW/9/kcrI6i+T76YThiZ/p514KjvGlvxi0Ei4eDg=", new Class[0]);
                                }
                            } catch (IllegalStateException unused) {
                            }
                            zzaztVarA.c("Fl0NzymWHJhyDpr9GrhyVi62KX+d2kj13lp1AwiYQHKKCKe1X2FxmeM5KLeNR5D2", "WhU/3eeIEz43+QqYTIKNH8p88w1+Uh4fQMNHsNTU34U=", Context.class);
                            zzbgb zzbgbVar = zzbgk.c4;
                            com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.f21150e;
                            if (((Boolean) zzbdVar.f21153c.a(zzbgbVar)).booleanValue()) {
                                zzaztVarA.c("gyMGe4SoPVIhBgFM+VlZQFWek2IoqCotue6ayBNgVb95WbB68suDu+Zv4jWiM6iG", "etp1batKULd2kwg+5GPfxliTu8RjfdN0zKvZOjQe8mU=", new Class[0]);
                            }
                            zzaztVarA.c("yCCrg1bENISzqqs7fgrfIgqRoB89Hc58RpoZe38mDWknXggRGBdzPAEdsprm/nAh", "ygsxUks9qSJOiPMXEo9qlLCVVsFNNRfyc6WjXaB0M8U=", Context.class);
                            zzaztVarA.c("JC98YOkW1OV00In88Kxh39aoA4/Lc5LugpNahl16Tw21h78xPzCO3AkqsFSMWF+O", "uHu4aeoXgHtmEAr/p8TbphROLjKobmRTgSnNeTPf/24=", Context.class);
                            zzaztVarA.c("0k0HoJtCvAtrnTz0UbiSqrs0BGKzSTMoo+ZxCfyJrLcMn8tbsvf/NG2/ui2bKbWP", "z6GzXqyR8kvBYJKVLhMc9mqmsbq6ZkNeWqgTkONnpqg=", Context.class);
                            zzaztVarA.c("01PVhP+doaGKdC1W6GrY+2IWUVFKtg3RWpQDin/wN/cS8wkuezVXqSDwZNREySxt", "hY1jxg+6DUCngCe0vbxb4cMsyHNENce67SGKWd6hzv8=", Context.class);
                            Class cls = Boolean.TYPE;
                            zzaztVarA.c("8W5EiIZWvw8ca0gdEf2baMelwD0v1LgWFEv6AqIRDGIzRlZJKgzzVYcusXATxgKN", "ZXwHOojdfPkjtU4/T1kRX8Zucxdzz/LL+/XimOcPDrc=", Context.class, cls);
                            zzaztVarA.c("f5uC0Q5BJBhs1YfPGy7Wx7MnBjWVUX5JNaW+Lz6dfUOfz0sIXH0KubqvIhiUByWt", "klWlopX/vpRWeyQx7GUjF52wT93EUJwbeMp05ev02yc=", Context.class);
                            zzaztVarA.c("Ps5Xy95qN5Bq7sgqC6/M4zZXLDS2M1Isx7H/g2/CV37zoy2ILxNb7iAARKvnhAcR", "UDDHIUrqun7cz3t6d4j2iVVfWcHKtBQnSOoDChOFM5Y=", Context.class);
                            zzaztVarA.c("6ZjnfgvB9wgS+Y8hZDivPhgjxRZbCY4q7zFEc6BukViF66w3fH7pDgMpCmaLCsbG", "yV5Ezpu/FJ5eBLvg/Gvr42qBX8KcXLyHBG0rFZzzuBY=", MotionEvent.class, DisplayMetrics.class);
                            zzaztVarA.c("0F2tRPtJ+oackwCEaR1ilzSWBDq3birdEdy954kTVJ/3hlaiiP5kh1SmVilvcwVI", "bSUQaKDGEujzsstvFAmuaLuv9mtefCQQKWZn9uZj/LI=", MotionEvent.class, DisplayMetrics.class);
                            zzaztVarA.c("6Tbgi6IQESKZikJOpZcClcVJxza1rhAf3nfasZu/vDcTd3loITpTNbH23xjyLA5L", "g107GCb4k6+PXON8scRHoxvRnyAK9ZOpFHjKTWKkbXc=", new Class[0]);
                            zzaztVarA.c("VYNLVwJcUVwKHNYqtTAMU2Cbdf8xQvz3Fr3MGMTI+Feinwv11ysZpnAq/2AMk2I1", "XCAdtiyR5t8AMQ7u4CMXLD5NJ9dD+Tw+KRPDn9OS+vQ=", new Class[0]);
                            zzaztVarA.c("MMDDWI2IGLmF5pG/RRqJJZVb/JAirVaBalbjWCkub0DwWmFp7b+bfaTjmPK9uiWU", "m1dpreCDNlkoMOYdr+vmzaz+jSmUZiIrETih78jZTqg=", new Class[0]);
                            zzaztVarA.c("N+SNt584k90MWn4aBLIhSutg85cYgcNyu+q+5WGRUo/oWkmPivq/1xlEIBG+GcFK", "VOVDFi9LxFQe2QWzKEnmStNUha/UwjqmQV12jeIMYds=", new Class[0]);
                            zzaztVarA.c("b8WdxwEW5LYMXGC6g6q07uNIFUV3fs77AEo1YVb/4q/M8KyV69so1cxJ+MsKyWwh", "kazSW9iygMpHEkKh5zVqXBXYRU+noi3Tzu4hpFfxZG4=", new Class[0]);
                            zzaztVarA.c("cOth2BAAthu6X8KDmzC58653OwqftcurhEiV9l+3uxMh7KBnOgbdhGM0zSnSPufi", "2EDSTVCwfkpT+1duJ+umEyNIZ3jEP0NWyK78oeLPLhI=", new Class[0]);
                            zzaztVarA.c("yYlfo3JOLIfvdgBq3U3deu0pC6YiXdEdqGnVULE/KCllAkaO/XSsVQU+sKDN/uG0", "5ZNtOO3srzHnbl5PLlxEIuHlg0l+6HDun864hT7P5ko=", Context.class, cls, String.class);
                            zzaztVarA.c("ffEAQyBH71yR4B2obQT/Qgb3Fo0ajWwFYmmZt2nfIS2fjNh6ir76IWAmhSUkzxpD", "s+erUKEK0AKg0XrZCH85OEIt0v0u2CGPZAaj/S6Q0Yk=", StackTraceElement[].class);
                            zzaztVarA.c("UGogIgDf9q+IGA3QKHqW/91b9ZzRTVJqtfmUoLBkD310fwrDg1hJZvDQk8/WK1MH", "sEqRe1gPhw/PwjhUj/qVAEUjKSVJDrXHsmrE44pcjTE=", View.class, DisplayMetrics.class, cls, cls);
                            zzaztVarA.c("i1MP+hbN0GtKV+UrtunReVDE3xh08srd5laBoZPswSp8P1i6BkpyGoiKZr6P+aBQ", "NQ1lo07HyX6R6o9xhF+JysjB/gJoli3QRzxLpFE7RH8=", Context.class, cls);
                            zzaztVarA.c("YJMz4lZ/SFOXN6kW19UKnvAqcLtndNv4f6er9d24/5MuXcrsMTIC+9Jfbhpe2HMW", "6iuDHA2XEqaGCIdpenyLvoYWzHjKpoW5EjYN40bz5Cs=", View.class, Activity.class, cls);
                            zzaztVarA.c("7i2iPrjrwVOXQymI9kbzBw+Saen0JiBKsL25H084g9vqkkZvrS3PC/gXCAaliMdd", "jjLuguQ1TtUBIYvLkWHGRHLEQB49t1f8VaYjdD5pX6Q=", Long.TYPE);
                            zzaztVarA.c("zPJzhz1QtGvdwoq8b/etTeYWv9LDeLRPadnOSNl7lohby1/0Z3YfZB4nvs0ev2QM", "fVJK5Q/FtQnQT4sQUZztmOn3k4N5bqyd4pz/QTy2bEo=", new Class[0]);
                            try {
                                if (((Boolean) zzbdVar.f21153c.a(zzbgk.X3)).booleanValue()) {
                                    zzaztVarA.c("ExKA4wjDRRYdztAsabUEoV5NOADo4vSkAwQNa4IGw0yLC0NQlDOhDdBTfDT5YHOb", "1Gz3ZRhjJNvXJ0g284S9b/dpVAajMMfg8CE3pBcFNFA=", Context.class);
                                }
                            } catch (IllegalStateException unused2) {
                            }
                            zzaztVarA.c("71OvRH8RKLL5CGPm3dKOf5cGs3Y2jxvT4WismqAQzm1qJBvyLIz7vuBnvO3+wiyt", "6gmo4xnyZNalDG+/4eFYRg3H75rhcg0JPASG/y34gQ8=", Context.class);
                            try {
                                if (Build.VERSION.SDK_INT >= 26) {
                                    if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.Y3)).booleanValue()) {
                                        Class cls2 = Long.TYPE;
                                        zzaztVarA.c("1MiCMWad12oLn5alnMxHwTvbBZm7RpaUcGFZ/LjrpVbPksWcBk53Qc+euKdOo/dG", "/cnUVQvNHFqi3ggOmiA4o/IdQSFHoegJ/H9a2xERT14=", NetworkCapabilities.class, cls2, cls2);
                                    }
                                }
                            } catch (IllegalStateException unused3) {
                            }
                            try {
                                if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.q3)).booleanValue()) {
                                    zzaztVarA.c("sl6J6ogR1CQFBNHXqYqYlsoHhQEQ3GzqykotbgjuxxtAslvwVDD28XhO/FGDcWNY", "etPaLFHhmzrmC9guV7/txSJ19uqkwWx/gSnrE4vBCvs=", List.class);
                                }
                            } catch (IllegalStateException unused4) {
                            }
                            try {
                            } catch (IllegalStateException unused5) {
                            }
                            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.h3)).booleanValue()) {
                                Class cls3 = Long.TYPE;
                                zzaztVarA.c("OKoG374XK3cB1cjYFPuO/Bg6vy6AufzuCyu4QCURxkWhJwL4+NqQjs8XziSHB+CQ", "PjHrXBXcXoGkJe75zH8RZ0khapXmOV4o2gX+YgkGdus=", cls3, cls3, cls3, cls3);
                            } else {
                                try {
                                    if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.g3)).booleanValue()) {
                                        zzaztVarA.c("ykIQv59ak7YBU+e791IU15tGonhZPUUBXST76bDGm7zXSjUSNn9qtHdf61t20THy", "l48tDWlMY/G/BSkitRUvd80RiFbNrk8nR5qlkOsZWs8=", long[].class, Context.class, View.class);
                                    }
                                } catch (IllegalStateException unused6) {
                                }
                            }
                        }
                        zzaym.u = zzaztVarA;
                    }
                } finally {
                }
            }
        }
        return zzaym.u;
    }

    public static zzazv r(zzazt zzaztVar, MotionEvent motionEvent, DisplayMetrics displayMetrics) throws zzazj {
        Method methodD = zzaztVar.d("6ZjnfgvB9wgS+Y8hZDivPhgjxRZbCY4q7zFEc6BukViF66w3fH7pDgMpCmaLCsbG", "yV5Ezpu/FJ5eBLvg/Gvr42qBX8KcXLyHBG0rFZzzuBY=");
        if (methodD == null || motionEvent == null) {
            throw new zzazj();
        }
        try {
            return new zzazv((String) methodD.invoke(null, motionEvent, displayMetrics));
        } catch (IllegalAccessException | InvocationTargetException e2) {
            throw new zzazj(e2);
        }
    }

    public static final void t(List list) throws InterruptedException {
        ExecutorService executorService;
        if (zzaym.u == null || (executorService = zzaym.u.f24559b) == null || list.isEmpty()) {
            return;
        }
        try {
            executorService.invokeAll(list, ((Long) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.c3)).longValue(), TimeUnit.MILLISECONDS);
        } catch (InterruptedException e2) {
            char[] cArr = zzazw.f24590a;
            StringWriter stringWriter = new StringWriter();
            e2.printStackTrace(new PrintWriter(stringWriter));
            android.support.v4.media.a.t("class methods got exception: ", stringWriter.toString(), "zzayo");
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaym
    public final zzavs a(Context context) throws InterruptedException {
        long j2;
        zzbac zzbacVar = C;
        if (zzbacVar != null && zzbacVar.f24625d) {
            zzbacVar.f24623b = System.currentTimeMillis();
        }
        zzbgb zzbgbVar = zzbgk.h3;
        com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.f21150e;
        if (((Boolean) zzbdVar.f21153c.a(zzbgbVar)).booleanValue()) {
            zzazu zzazuVar = D;
            zzazuVar.f24572b = zzazuVar.f24571a;
            zzazuVar.f24571a = SystemClock.uptimeMillis();
        }
        zzavs zzavsVarF0 = zzawp.F0();
        zzayn zzaynVar = this.v;
        String str = zzaynVar.f24508b;
        if (!TextUtils.isEmpty(str)) {
            zzavsVarF0.j();
            ((zzawp) zzavsVarF0.f34638b).I0(str);
        }
        zzazt zzaztVarQ = q(context, zzaynVar.f24507a);
        if (zzaztVarQ.f24559b == null) {
            return zzavsVarF0;
        }
        int iE = zzaztVarQ.e();
        ArrayList arrayList = new ArrayList();
        if (zzaztVarQ.n) {
            zzbah zzbahVar = new zzbah(zzaztVarQ, zzavsVarF0, iE, context, zzaynVar.f24509c, E);
            int i2 = iE;
            arrayList.add(zzbahVar);
            arrayList.add(new zzbak(zzaztVarQ, zzavsVarF0, A, i2));
            arrayList.add(new zzbau(zzaztVarQ, zzavsVarF0, i2));
            arrayList.add(new zzbax(zzaztVarQ, zzavsVarF0, i2, context));
            arrayList.add(new zzbbc(zzaztVarQ, zzavsVarF0, i2));
            arrayList.add(new zzbag(zzaztVarQ, zzavsVarF0, i2, context));
            arrayList.add(new zzbai(zzaztVarQ, zzavsVarF0, i2));
            arrayList.add(new zzbat(zzaztVarQ, zzavsVarF0, i2));
            arrayList.add(new zzbav(zzaztVarQ, zzavsVarF0, i2));
            arrayList.add(new zzbaj(zzaztVarQ, zzavsVarF0, i2));
            arrayList.add(new zzbap(zzaztVarQ, zzavsVarF0, i2));
            arrayList.add(new zzbbd(zzaztVarQ, zzavsVarF0, i2));
            arrayList.add(new zzbaf(zzaztVarQ, zzavsVarF0, i2));
            arrayList.add(new zzbba(zzaztVarQ, zzavsVarF0, i2));
            arrayList.add(new zzbay(zzaztVarQ, zzavsVarF0, i2));
            zzbgb zzbgbVar2 = zzbgk.Y3;
            zzbgi zzbgiVar = zzbdVar.f21153c;
            if (((Boolean) zzbgiVar.a(zzbgbVar2)).booleanValue()) {
                zzbac zzbacVar2 = C;
                long j3 = -1;
                if (zzbacVar2 != null) {
                    long j4 = zzbacVar2.f24625d ? zzbacVar2.f24623b - zzbacVar2.f24622a : -1L;
                    long j5 = zzbacVar2.f24624c;
                    zzbacVar2.f24624c = -1L;
                    j3 = j4;
                    j2 = j5;
                } else {
                    j2 = -1;
                }
                zzbas zzbasVar = new zzbas(zzaztVarQ, zzavsVarF0, i2, B, j3, j2);
                i2 = i2;
                arrayList.add(zzbasVar);
            }
            if (((Boolean) zzbgiVar.a(zzbgk.X3)).booleanValue()) {
                arrayList.add(new zzbaw(zzaztVarQ, zzavsVarF0, i2));
            }
            zzbaq zzbaqVar = new zzbaq(zzaztVarQ, "71OvRH8RKLL5CGPm3dKOf5cGs3Y2jxvT4WismqAQzm1qJBvyLIz7vuBnvO3+wiyt", "6gmo4xnyZNalDG+/4eFYRg3H75rhcg0JPASG/y34gQ8=", zzavsVarF0, i2, 76);
            zzavsVarF0 = zzavsVarF0;
            arrayList.add(zzbaqVar);
            if (((Boolean) zzbgiVar.a(zzbgk.b4)).booleanValue()) {
                arrayList.add(new zzbae(zzaztVarQ, zzavsVarF0, i2));
            }
            if (((Boolean) zzbgiVar.a(zzbgk.c4)).booleanValue()) {
                zzbal zzbalVar = new zzbal(zzaztVarQ, "gyMGe4SoPVIhBgFM+VlZQFWek2IoqCotue6ayBNgVb95WbB68suDu+Zv4jWiM6iG", "etp1batKULd2kwg+5GPfxliTu8RjfdN0zKvZOjQe8mU=", zzavsVarF0, i2, 82);
                zzavsVarF0 = zzavsVarF0;
                arrayList.add(zzbalVar);
            }
        } else {
            zzavsVarF0.o(16384L);
        }
        t(arrayList);
        return zzavsVarF0;
    }

    @Override // com.google.android.gms.internal.ads.zzaym, com.google.android.gms.internal.ads.zzayl
    public final void i(View view) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.f3)).booleanValue()) {
            if (this.w == null) {
                zzazt zzaztVar = zzaym.u;
                this.w = new zzbaa(zzaztVar.f24558a, zzaztVar.o);
            }
            this.w.a(view);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaym
    public final zzavs k(Context context, View view, Activity activity) throws InterruptedException {
        zzbac zzbacVar = C;
        if (zzbacVar != null && zzbacVar.f24625d) {
            zzbacVar.f24623b = System.currentTimeMillis();
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.h3)).booleanValue()) {
            zzazu zzazuVar = D;
            zzazuVar.f24578h = zzazuVar.f24577g;
            zzazuVar.f24577g = SystemClock.uptimeMillis();
        }
        zzavs zzavsVarF0 = zzawp.F0();
        zzayn zzaynVar = this.v;
        String str = zzaynVar.f24508b;
        if (!TextUtils.isEmpty(str)) {
            zzavsVarF0.j();
            ((zzawp) zzavsVarF0.f34638b).I0(str);
        }
        s(q(context, zzaynVar.f24507a), zzavsVarF0, view, activity, true, context);
        return zzavsVarF0;
    }

    @Override // com.google.android.gms.internal.ads.zzaym
    public final zzavs l(Context context, View view, Activity activity) throws IllegalAccessException, InterruptedException, IllegalArgumentException, InvocationTargetException {
        zzbac zzbacVar = C;
        if (zzbacVar != null && zzbacVar.f24625d) {
            zzbacVar.f24623b = System.currentTimeMillis();
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.h3)).booleanValue()) {
            D.a(context, view);
        }
        zzavs zzavsVarF0 = zzawp.F0();
        zzayn zzaynVar = this.v;
        String str = zzaynVar.f24508b;
        zzavsVarF0.j();
        ((zzawp) zzavsVarF0.f34638b).I0(str);
        s(q(context, zzaynVar.f24507a), zzavsVarF0, view, activity, false, context);
        return zzavsVarF0;
    }

    @Override // com.google.android.gms.internal.ads.zzaym
    public final zzazv m(MotionEvent motionEvent) throws zzazj {
        Method methodD = zzaym.u.d("0F2tRPtJ+oackwCEaR1ilzSWBDq3birdEdy954kTVJ/3hlaiiP5kh1SmVilvcwVI", "bSUQaKDGEujzsstvFAmuaLuv9mtefCQQKWZn9uZj/LI=");
        if (methodD == null || motionEvent == null) {
            throw new zzazj();
        }
        try {
            return new zzazv((String) methodD.invoke(null, motionEvent, this.s));
        } catch (IllegalAccessException | InvocationTargetException e2) {
            throw new zzazj(e2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaym
    public final long n(StackTraceElement[] stackTraceElementArr) throws zzazj {
        Method methodD = zzaym.u.d("ffEAQyBH71yR4B2obQT/Qgb3Fo0ajWwFYmmZt2nfIS2fjNh6ir76IWAmhSUkzxpD", "s+erUKEK0AKg0XrZCH85OEIt0v0u2CGPZAaj/S6Q0Yk=");
        if (methodD == null || stackTraceElementArr == null) {
            throw new zzazj();
        }
        try {
            return new zzazk((String) methodD.invoke(null, stackTraceElementArr)).f24537a.longValue();
        } catch (IllegalAccessException | InvocationTargetException e2) {
            throw new zzazj(e2);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v8, types: [java.util.List] */
    public final void s(zzazt zzaztVar, zzavs zzavsVar, View view, Activity activity, boolean z2, Context context) throws InterruptedException {
        Context context2;
        long j2;
        long j3;
        MotionEvent motionEvent;
        ArrayList arrayListAsList;
        if (zzaztVar.n) {
            synchronized (this) {
                try {
                    try {
                        zzazv zzazvVarR = r(zzaztVar, this.f24494a, this.s);
                        Long l2 = zzazvVarR.f24579a;
                        if (l2 != null) {
                            long jLongValue = l2.longValue();
                            zzavsVar.j();
                            ((zzawp) zzavsVar.f34638b).O0(jLongValue);
                        }
                        Long l3 = zzazvVarR.f24580b;
                        if (l3 != null) {
                            long jLongValue2 = l3.longValue();
                            zzavsVar.j();
                            ((zzawp) zzavsVar.f34638b).P0(jLongValue2);
                        }
                        Long l4 = zzazvVarR.f24581c;
                        if (l4 != null) {
                            long jLongValue3 = l4.longValue();
                            zzavsVar.j();
                            ((zzawp) zzavsVar.f34638b).Q0(jLongValue3);
                        }
                        if (this.r) {
                            Long l5 = zzazvVarR.f24582d;
                            if (l5 != null) {
                                long jLongValue4 = l5.longValue();
                                zzavsVar.j();
                                ((zzawp) zzavsVar.f34638b).I(jLongValue4);
                            }
                            Long l6 = zzazvVarR.f24583e;
                            if (l6 != null) {
                                long jLongValue5 = l6.longValue();
                                zzavsVar.j();
                                ((zzawp) zzavsVar.f34638b).J(jLongValue5);
                            }
                        }
                    } catch (zzazj unused) {
                    }
                    zzawl zzawlVarC = zzawm.C();
                    if (this.f24496c > 0) {
                        DisplayMetrics displayMetrics = this.s;
                        char[] cArr = zzazw.f24590a;
                        if ((displayMetrics == null || displayMetrics.density == 0.0f) ? false : true) {
                            long jB = zzazw.b(this.f24503j, displayMetrics);
                            zzawlVarC.j();
                            ((zzawm) zzawlVarC.f34638b).O(jB);
                            long jB2 = zzazw.b(this.o - this.f24506m, this.s);
                            zzawlVarC.j();
                            ((zzawm) zzawlVarC.f34638b).P(jB2);
                            long jB3 = zzazw.b(this.p - this.n, this.s);
                            zzawlVarC.j();
                            ((zzawm) zzawlVarC.f34638b).Q(jB3);
                            long jB4 = zzazw.b(this.f24506m, this.s);
                            zzawlVarC.j();
                            ((zzawm) zzawlVarC.f34638b).T(jB4);
                            long jB5 = zzazw.b(this.n, this.s);
                            zzawlVarC.j();
                            ((zzawm) zzawlVarC.f34638b).U(jB5);
                            if (this.r && (motionEvent = this.f24494a) != null) {
                                long jB6 = zzazw.b(((this.f24506m - this.o) + motionEvent.getRawX()) - this.f24494a.getX(), this.s);
                                if (jB6 != 0) {
                                    zzawlVarC.j();
                                    ((zzawm) zzawlVarC.f34638b).R(jB6);
                                }
                                long jB7 = zzazw.b(((this.n - this.p) + this.f24494a.getRawY()) - this.f24494a.getY(), this.s);
                                if (jB7 != 0) {
                                    zzawlVarC.j();
                                    ((zzawm) zzawlVarC.f34638b).S(jB7);
                                }
                            }
                        }
                    }
                    try {
                        zzazv zzazvVarM = m(this.f24494a);
                        Long l7 = zzazvVarM.f24579a;
                        if (l7 != null) {
                            long jLongValue6 = l7.longValue();
                            zzawlVarC.j();
                            ((zzawm) zzawlVarC.f34638b).D(jLongValue6);
                        }
                        Long l8 = zzazvVarM.f24580b;
                        if (l8 != null) {
                            long jLongValue7 = l8.longValue();
                            zzawlVarC.j();
                            ((zzawm) zzawlVarC.f34638b).E(jLongValue7);
                        }
                        long jLongValue8 = zzazvVarM.f24581c.longValue();
                        zzawlVarC.j();
                        ((zzawm) zzawlVarC.f34638b).K(jLongValue8);
                        if (this.r) {
                            Long l9 = zzazvVarM.f24583e;
                            if (l9 != null) {
                                long jLongValue9 = l9.longValue();
                                zzawlVarC.j();
                                ((zzawm) zzawlVarC.f34638b).F(jLongValue9);
                            }
                            Long l10 = zzazvVarM.f24582d;
                            if (l10 != null) {
                                long jLongValue10 = l10.longValue();
                                zzawlVarC.j();
                                ((zzawm) zzawlVarC.f34638b).I(jLongValue10);
                            }
                            Long l11 = zzazvVarM.f24584f;
                            int i2 = 2;
                            if (l11 != null) {
                                int i3 = l11.longValue() != 0 ? 2 : 1;
                                zzawlVarC.j();
                                ((zzawm) zzawlVarC.f34638b).V(i3);
                            }
                            long j4 = this.f24497d;
                            if (j4 > 0) {
                                DisplayMetrics displayMetrics2 = this.s;
                                char[] cArr2 = zzazw.f24590a;
                                Long lValueOf = displayMetrics2 != null && (displayMetrics2.density > 0.0f ? 1 : (displayMetrics2.density == 0.0f ? 0 : -1)) != 0 ? Long.valueOf(Math.round(this.f24502i / j4)) : null;
                                if (lValueOf != null) {
                                    long jLongValue11 = lValueOf.longValue();
                                    zzawlVarC.j();
                                    ((zzawm) zzawlVarC.f34638b).G(jLongValue11);
                                } else {
                                    zzawlVarC.j();
                                    ((zzawm) zzawlVarC.f34638b).H();
                                }
                                long jRound = Math.round(this.f24501h / this.f24497d);
                                zzawlVarC.j();
                                ((zzawm) zzawlVarC.f34638b).J(jRound);
                            }
                            Long l12 = zzazvVarM.f24587i;
                            if (l12 != null) {
                                long jLongValue12 = l12.longValue();
                                zzawlVarC.j();
                                ((zzawm) zzawlVarC.f34638b).M(jLongValue12);
                            }
                            Long l13 = zzazvVarM.f24588j;
                            if (l13 != null) {
                                long jLongValue13 = l13.longValue();
                                zzawlVarC.j();
                                ((zzawm) zzawlVarC.f34638b).L(jLongValue13);
                            }
                            Long l14 = zzazvVarM.f24589k;
                            if (l14 != null) {
                                if (l14.longValue() == 0) {
                                    i2 = 1;
                                }
                                zzawlVarC.j();
                                ((zzawm) zzawlVarC.f34638b).W(i2);
                            }
                        }
                    } catch (zzazj unused2) {
                    }
                    long j5 = this.f24500g;
                    if (j5 > 0) {
                        zzawlVarC.j();
                        ((zzawm) zzawlVarC.f34638b).N(j5);
                    }
                    zzawm zzawmVar = (zzawm) zzawlVarC.l();
                    zzavsVar.j();
                    ((zzawp) zzavsVar.f34638b).V(zzawmVar);
                    long j6 = this.f24496c;
                    if (j6 > 0) {
                        zzavsVar.j();
                        ((zzawp) zzavsVar.f34638b).M(j6);
                    }
                    long j7 = this.f24497d;
                    if (j7 > 0) {
                        zzavsVar.j();
                        ((zzawp) zzavsVar.f34638b).L(j7);
                    }
                    long j8 = this.f24498e;
                    if (j8 > 0) {
                        zzavsVar.j();
                        ((zzawp) zzavsVar.f34638b).K(j8);
                    }
                    long j9 = this.f24499f;
                    if (j9 > 0) {
                        zzavsVar.j();
                        ((zzawp) zzavsVar.f34638b).N(j9);
                    }
                    try {
                        LinkedList linkedList = this.f24495b;
                        int size = linkedList.size() - 1;
                        if (size > 0) {
                            zzavsVar.j();
                            ((zzawp) zzavsVar.f34638b).X();
                            for (int i4 = 0; i4 < size; i4++) {
                                zzazv zzazvVarR2 = r(zzaym.u, (MotionEvent) linkedList.get(i4), this.s);
                                zzawl zzawlVarC2 = zzawm.C();
                                long jLongValue14 = zzazvVarR2.f24579a.longValue();
                                zzawlVarC2.j();
                                ((zzawm) zzawlVarC2.f34638b).D(jLongValue14);
                                long jLongValue15 = zzazvVarR2.f24580b.longValue();
                                zzawlVarC2.j();
                                ((zzawm) zzawlVarC2.f34638b).E(jLongValue15);
                                zzawm zzawmVar2 = (zzawm) zzawlVarC2.l();
                                zzavsVar.j();
                                ((zzawp) zzavsVar.f34638b).W(zzawmVar2);
                            }
                        }
                    } catch (zzazj unused3) {
                        zzavsVar.j();
                        ((zzawp) zzavsVar.f34638b).X();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            ArrayList arrayList = new ArrayList();
            arrayListAsList = arrayList;
            if (zzaztVar.f24559b != null) {
                int iE = zzaztVar.e();
                zzbgb zzbgbVar = zzbgk.p3;
                com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.f21150e;
                if (((Boolean) zzbdVar.f21153c.a(zzbgbVar)).booleanValue()) {
                    context2 = context;
                    arrayList.add(new zzbah(zzaztVar, zzavsVar, iE, context, this.v.f24509c, E));
                    arrayList.add(new zzbag(zzaztVar, zzavsVar, iE, context2));
                    arrayList.add(new zzbax(zzaztVar, zzavsVar, iE, context2));
                    arrayList.add(new zzbbc(zzaztVar, zzavsVar, iE));
                    zzbac zzbacVar = C;
                    if (zzbacVar != null) {
                        long j10 = zzbacVar.f24625d ? zzbacVar.f24623b - zzbacVar.f24622a : -1L;
                        long j11 = zzbacVar.f24624c;
                        zzbacVar.f24624c = -1L;
                        j3 = j10;
                        j2 = j11;
                    } else {
                        j2 = -1;
                        j3 = -1;
                    }
                    arrayList.add(new zzbas(zzaztVar, zzavsVar, iE, B, j3, j2));
                    arrayList.add(new zzbaw(zzaztVar, zzavsVar, iE));
                } else {
                    context2 = context;
                }
                arrayList.add(new zzbam(zzaztVar, zzavsVar));
                arrayList.add(new zzbau(zzaztVar, zzavsVar, iE));
                arrayList.add(new zzbak(zzaztVar, zzavsVar, A, iE));
                arrayList.add(new zzbaj(zzaztVar, zzavsVar, iE));
                arrayList.add(new zzbat(zzaztVar, zzavsVar, iE));
                arrayList.add(new zzbav(zzaztVar, zzavsVar, iE));
                arrayList.add(new zzbap(zzaztVar, zzavsVar, iE));
                arrayList.add(new zzbai(zzaztVar, zzavsVar, iE));
                arrayList.add(new zzbbd(zzaztVar, zzavsVar, iE));
                arrayList.add(new zzbaf(zzaztVar, zzavsVar, iE));
                arrayList.add(new zzbba(zzaztVar, zzavsVar, iE));
                arrayList.add(new zzbaz(zzaztVar, zzavsVar, iE, new Throwable().getStackTrace()));
                arrayList.add(new zzbbe(zzaztVar, zzavsVar, iE, view));
                arrayList.add(new zzbay(zzaztVar, zzavsVar, iE));
                if (((Boolean) zzbdVar.f21153c.a(zzbgk.d3)).booleanValue()) {
                    arrayList.add(new zzbad(zzaztVar, zzavsVar, iE, view, activity));
                }
                if (((Boolean) zzbdVar.f21153c.a(zzbgk.b4)).booleanValue()) {
                    arrayList.add(new zzbae(zzaztVar, zzavsVar, iE));
                }
                if (z2) {
                    arrayListAsList = arrayList;
                    if (((Boolean) zzbdVar.f21153c.a(zzbgk.f3)).booleanValue()) {
                        arrayList.add(new zzbbb(zzaztVar, zzavsVar, iE, this.w));
                        arrayListAsList = arrayList;
                    }
                } else {
                    try {
                        if (((Boolean) zzbdVar.f21153c.a(zzbgk.g3)).booleanValue()) {
                            arrayList.add(new zzbao(zzaztVar, zzavsVar, iE, this.x, view, context2));
                        }
                    } catch (IllegalStateException unused4) {
                    }
                    try {
                        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.h3)).booleanValue()) {
                            arrayList.add(new zzban(zzaztVar, zzavsVar, iE, D));
                        }
                    } catch (IllegalStateException unused5) {
                    }
                    arrayListAsList = arrayList;
                    if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.q3)).booleanValue()) {
                        arrayList.add(new zzbar(zzaztVar, zzavsVar, iE, this.t));
                        arrayListAsList = arrayList;
                    }
                }
            }
        } else {
            zzavsVar.o(16384L);
            arrayListAsList = Arrays.asList(new zzbam(zzaztVar, zzavsVar));
        }
        t(arrayListAsList);
    }
}
