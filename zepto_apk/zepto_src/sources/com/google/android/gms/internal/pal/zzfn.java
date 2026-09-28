package com.google.android.gms.internal.pal;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Looper;
import android.util.Base64;
import android.view.MotionEvent;
import android.view.View;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.util.Iterator;

/* loaded from: classes4.dex */
public final class zzfn extends zzfq {

    /* renamed from: a, reason: collision with root package name */
    public final zzcu f37735a;

    /* renamed from: b, reason: collision with root package name */
    public final zzcs f37736b;

    /* renamed from: c, reason: collision with root package name */
    public final zzcv f37737c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f37738d = false;

    public zzfn(Context context) {
        zzct.n(context, false);
        zzcu zzcuVar = new zzcu(context, 0);
        this.f37735a = zzcuVar;
        this.f37737c = new zzcv(zzcuVar);
        zzct.n(context, true);
        this.f37736b = new zzcs(context);
    }

    public final ObjectWrapper z0(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, boolean z) {
        Uri uriA;
        try {
            Uri uri = (Uri) ObjectWrapper.z0(iObjectWrapper);
            Context context = (Context) ObjectWrapper.z0(iObjectWrapper2);
            zzcv zzcvVar = this.f37737c;
            if (z) {
                uriA = zzcv.a(uri, zzcvVar.f37599d.a(context));
            } else {
                zzcvVar.getClass();
                try {
                    uriA = zzcv.a(uri, zzcvVar.f37599d.e(context, uri.getQueryParameter("ai"), 3, null, null, null));
                } catch (UnsupportedOperationException unused) {
                    throw new zzcw("Provided Uri is not in a valid state");
                }
            }
            return new ObjectWrapper(uriA);
        } catch (zzcw unused2) {
            return null;
        }
    }

    @Override // com.google.android.gms.internal.pal.zzfr
    public final String zze(IObjectWrapper iObjectWrapper, String str) {
        return this.f37735a.e((Context) ObjectWrapper.z0(iObjectWrapper), str, 3, null, null, null);
    }

    @Override // com.google.android.gms.internal.pal.zzfr
    public final String zzg(IObjectWrapper iObjectWrapper, byte[] bArr) {
        byte[] bArrF;
        Context context = (Context) ObjectWrapper.z0(iObjectWrapper);
        zzcu zzcuVar = this.f37735a;
        zzcuVar.getClass();
        char[] cArr = zzdx.f37659a;
        if (Looper.myLooper() == Looper.getMainLooper()) {
            throw new IllegalStateException("The caller must not be called from the UI thread.");
        }
        String strE = zzcuVar.e(context, null, 1, null, null, bArr);
        zzcs zzcsVar = this.f37736b;
        if (zzcsVar == null || !this.f37738d) {
            return strE;
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            throw new IllegalStateException("The caller must not be called from the UI thread.");
        }
        String strE2 = zzcsVar.e(context, null, 1, null, null, bArr);
        boolean z = zzbn.f37547a;
        zzai zzaiVarP = zzaj.p();
        try {
            byte[] bytes = strE.length() < 3 ? strE.getBytes("ISO-8859-1") : zzbj.a(strE, true);
            zzaby zzabyVarQ = zzaby.q(0, bytes, bytes.length);
            if (zzaiVarP.f37406c) {
                zzaiVarP.k();
                zzaiVarP.f37406c = false;
            }
            zzaj.q((zzaj) zzaiVarP.f37405b, zzabyVarQ);
            byte[] bytes2 = strE2.length() < 3 ? strE2.getBytes("ISO-8859-1") : zzbj.a(strE2, true);
            zzaby zzabyVarQ2 = zzaby.q(0, bytes2, bytes2.length);
            if (zzaiVarP.f37406c) {
                zzaiVarP.k();
                zzaiVarP.f37406c = false;
            }
            zzaj.r((zzaj) zzaiVarP.f37405b, zzabyVarQ2);
            bArrF = ((zzaj) zzaiVarP.h()).F();
        } catch (UnsupportedEncodingException | GeneralSecurityException unused) {
            bArrF = null;
        }
        String strEncodeToString = bArrF != null ? Base64.encodeToString(bArrF, 11) : Integer.toString(7);
        this.f37738d = false;
        return strEncodeToString;
    }

    @Override // com.google.android.gms.internal.pal.zzfr
    public final String zzk(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) {
        return this.f37735a.e((Context) ObjectWrapper.z0(iObjectWrapper), null, 2, (View) ObjectWrapper.z0(iObjectWrapper2), (Activity) ObjectWrapper.z0(iObjectWrapper3), null);
    }

    @Override // com.google.android.gms.internal.pal.zzfr
    public final void zzl(IObjectWrapper iObjectWrapper) {
        Long l2;
        MotionEvent motionEvent = (MotionEvent) ObjectWrapper.z0(iObjectWrapper);
        zzcu zzcuVar = this.f37737c.f37599d;
        synchronized (zzcuVar) {
            try {
                if (zzcuVar.q) {
                    zzcuVar.f37589g = 0L;
                    zzcuVar.f37585c = 0L;
                    zzcuVar.f37586d = 0L;
                    zzcuVar.f37587e = 0L;
                    zzcuVar.f37588f = 0L;
                    zzcuVar.f37590h = 0L;
                    zzcuVar.f37591i = 0L;
                    if (zzcuVar.f37584b.size() > 0) {
                        Iterator it = zzcuVar.f37584b.iterator();
                        while (it.hasNext()) {
                            ((MotionEvent) it.next()).recycle();
                        }
                        zzcuVar.f37584b.clear();
                    } else {
                        MotionEvent motionEvent2 = zzcuVar.f37583a;
                        if (motionEvent2 != null) {
                            motionEvent2.recycle();
                        }
                    }
                    zzcuVar.f37583a = null;
                    zzcuVar.q = false;
                }
                int action = motionEvent.getAction();
                if (action == 0) {
                    zzcuVar.f37592j = 0.0d;
                    zzcuVar.f37593k = motionEvent.getRawX();
                    zzcuVar.f37594l = motionEvent.getRawY();
                } else if (action == 1 || action == 2) {
                    double rawX = motionEvent.getRawX();
                    double rawY = motionEvent.getRawY();
                    double d2 = rawX - zzcuVar.f37593k;
                    double d3 = rawY - zzcuVar.f37594l;
                    zzcuVar.f37592j += Math.sqrt((d3 * d3) + (d2 * d2));
                    zzcuVar.f37593k = rawX;
                    zzcuVar.f37594l = rawY;
                }
                int action2 = motionEvent.getAction();
                if (action2 != 0) {
                    try {
                        if (action2 == 1) {
                            MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
                            zzcuVar.f37583a = motionEventObtain;
                            zzcuVar.f37584b.add(motionEventObtain);
                            if (zzcuVar.f37584b.size() > 6) {
                                ((MotionEvent) zzcuVar.f37584b.remove()).recycle();
                            }
                            zzcuVar.f37587e++;
                            zzcuVar.f37589g = zzcuVar.f(new Throwable().getStackTrace());
                        } else if (action2 == 2) {
                            zzcuVar.f37586d += motionEvent.getHistorySize() + 1;
                            zzdw zzdwVarG = zzcuVar.g(motionEvent);
                            Long l3 = zzdwVarG.f37651d;
                            if (l3 != null && zzdwVarG.f37654g != null) {
                                zzcuVar.f37590h = l3.longValue() + zzdwVarG.f37654g.longValue() + zzcuVar.f37590h;
                            }
                            if (zzcuVar.s != null && (l2 = zzdwVarG.f37652e) != null && zzdwVarG.f37655h != null) {
                                zzcuVar.f37591i = l2.longValue() + zzdwVarG.f37655h.longValue() + zzcuVar.f37591i;
                            }
                        } else if (action2 == 3) {
                            zzcuVar.f37588f++;
                        }
                    } catch (zzdm unused) {
                    }
                } else {
                    zzcuVar.f37595m = motionEvent.getX();
                    zzcuVar.n = motionEvent.getY();
                    zzcuVar.o = motionEvent.getRawX();
                    zzcuVar.p = motionEvent.getRawY();
                    zzcuVar.f37585c++;
                }
                zzcuVar.r = true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
