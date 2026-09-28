package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toolbar;
import androidx.core.view.ViewCompat;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.common.util.concurrent.ListenableFuture;
import in.juspay.hypersdk.core.PaymentConstants;
import java.io.ByteArrayInputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.annotation.ParametersAreNonnullByDefault;
import org.xbill.DNS.WKSRecord;

@ParametersAreNonnullByDefault
/* loaded from: classes4.dex */
public class zzcjc extends WebViewClient implements zzckp {
    public static final /* synthetic */ int I = 0;
    public zzcze A;
    public boolean B;
    public boolean C;
    public int D;
    public boolean E;
    public final zzeif G;
    public View.OnAttachStateChangeListener H;

    /* renamed from: a, reason: collision with root package name */
    public final zzcjn f26369a;

    /* renamed from: b, reason: collision with root package name */
    public final zzbfj f26370b;

    /* renamed from: e, reason: collision with root package name */
    public com.google.android.gms.ads.internal.client.zza f26373e;

    /* renamed from: f, reason: collision with root package name */
    public com.google.android.gms.ads.internal.overlay.zzr f26374f;

    /* renamed from: g, reason: collision with root package name */
    public zzckn f26375g;

    /* renamed from: h, reason: collision with root package name */
    public zzcko f26376h;

    /* renamed from: i, reason: collision with root package name */
    public zzbmd f26377i;

    /* renamed from: j, reason: collision with root package name */
    public zzbmf f26378j;

    /* renamed from: k, reason: collision with root package name */
    public zzdir f26379k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f26380l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f26381m;
    public boolean q;
    public boolean r;
    public boolean s;
    public boolean t;
    public com.google.android.gms.ads.internal.overlay.zzad u;
    public zzbwc v;
    public com.google.android.gms.ads.internal.zzb w;
    public zzcbk y;
    public zzdxe z;

    /* renamed from: c, reason: collision with root package name */
    public final HashMap f26371c = new HashMap();

    /* renamed from: d, reason: collision with root package name */
    public final Object f26372d = new Object();
    public int n = 0;
    public String o = "";
    public String p = "";
    public zzbvx x = null;
    public final HashSet F = new HashSet(Arrays.asList(((String) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.s6)).split(",")));

    public zzcjc(zzcjn zzcjnVar, zzbfj zzbfjVar, boolean z, zzbwc zzbwcVar, zzeif zzeifVar) {
        this.f26370b = zzbfjVar;
        this.f26369a = zzcjnVar;
        this.q = z;
        this.v = zzbwcVar;
        this.G = zzeifVar;
    }

    public static WebResourceResponse P() {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.f1)).booleanValue()) {
            return new WebResourceResponse("", "", new ByteArrayInputStream(new byte[0]));
        }
        return null;
    }

    public static final boolean Y(zzcjn zzcjnVar) {
        return ((zzcju) zzcjnVar.f26410a).v() != null && ((zzcju) zzcjnVar.f26410a).v().b();
    }

    public static final boolean i0(boolean z, zzcjn zzcjnVar) {
        return (!z || ((zzcju) zzcjnVar.f26410a).zzN().b() || ((zzcju) zzcjnVar.f26410a).zzO().equals("interstitial_mb")) ? false : true;
    }

    public final void F(final View view, final zzcbk zzcbkVar, final int i2) {
        if (!zzcbkVar.zzc() || i2 <= 0) {
            return;
        }
        zzcbkVar.c(view);
        if (zzcbkVar.zzc()) {
            com.google.android.gms.ads.internal.util.zzs.f21608l.postDelayed(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcja
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    this.f26363a.F(view, zzcbkVar, i2 - 1);
                }
            }, 100L);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x010b, code lost:
    
        r1 = r7.getContentType();
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0113, code lost:
    
        r5 = "";
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0117, code lost:
    
        if (android.text.TextUtils.isEmpty(r1) == false) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0119, code lost:
    
        r11 = "";
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x011b, code lost:
    
        r11 = r1.split(";")[0].trim();
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0126, code lost:
    
        r1 = r7.getContentType();
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x012e, code lost:
    
        if (android.text.TextUtils.isEmpty(r1) == false) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0130, code lost:
    
        r12 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0132, code lost:
    
        r1 = r1.split(";");
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0137, code lost:
    
        if (r1.length != 1) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x013a, code lost:
    
        r2 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x013c, code lost:
    
        if (r2 >= r1.length) goto L101;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x014a, code lost:
    
        if (r1[r2].trim().startsWith("charset") == false) goto L103;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x014c, code lost:
    
        r3 = r1[r2].trim().split("=");
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0159, code lost:
    
        if (r3.length <= 1) goto L104;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x015b, code lost:
    
        r5 = r3[1].trim();
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0162, code lost:
    
        r2 = r2 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0164, code lost:
    
        r0 = r7.getHeaderFields();
        r15 = new java.util.HashMap(r0.size());
        r0 = r0.entrySet().iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x017d, code lost:
    
        if (r0.hasNext() == false) goto L92;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x017f, code lost:
    
        r1 = r0.next();
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0189, code lost:
    
        if (r1.getKey() == null) goto L97;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x018f, code lost:
    
        if (r1.getValue() == null) goto L98;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x019b, code lost:
    
        if (r1.getValue().isEmpty() != false) goto L99;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x019d, code lost:
    
        r15.put(r1.getKey(), r1.getValue().get(0));
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x01b3, code lost:
    
        r0 = com.google.android.gms.ads.internal.zzt.C.f21682f;
        r13 = r7.getResponseCode();
        r14 = r7.getResponseMessage();
        r16 = r7.getInputStream();
        r0.getClass();
        r10 = new android.webkit.WebResourceResponse(r11, r12, r13, r14, r15, r16);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.webkit.WebResourceResponse R(java.lang.String r18, java.util.Map r19) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 490
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcjc.R(java.lang.String, java.util.Map):android.webkit.WebResourceResponse");
    }

    @Override // com.google.android.gms.internal.ads.zzdir
    public final void S() {
        zzdir zzdirVar = this.f26379k;
        if (zzdirVar != null) {
            zzdirVar.S();
        }
    }

    public final void T(Map map, List list, String str) {
        if (com.google.android.gms.ads.internal.util.zze.m()) {
            com.google.android.gms.ads.internal.util.zze.k("Received GMSG: ".concat(str));
            for (String str2 : map.keySet()) {
                String str3 = (String) map.get(str2);
                StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 4 + String.valueOf(str3).length());
                sb.append("  ");
                sb.append(str2);
                sb.append(": ");
                sb.append(str3);
                com.google.android.gms.ads.internal.util.zze.k(sb.toString());
            }
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((zzbnn) it.next()).a(this.f26369a, map);
        }
    }

    public final void a(AdOverlayInfoParcel adOverlayInfoParcel) {
        com.google.android.gms.ads.internal.overlay.zzc zzcVar;
        zzbvx zzbvxVar = this.x;
        if (zzbvxVar != null) {
            synchronized (zzbvxVar.f25626k) {
                z = zzbvxVar.r != null;
            }
        }
        com.google.android.gms.ads.internal.overlay.zzn zznVar = com.google.android.gms.ads.internal.zzt.C.f21678b;
        com.google.android.gms.ads.internal.overlay.zzn.a(this.f26369a.getContext(), adOverlayInfoParcel, !z, this.z);
        zzcbk zzcbkVar = this.y;
        if (zzcbkVar != null) {
            String str = adOverlayInfoParcel.f21325l;
            if (str == null && (zzcVar = adOverlayInfoParcel.f21314a) != null) {
                str = zzcVar.f21337b;
            }
            zzcbkVar.b(str);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdir
    public final void a0() {
        zzdir zzdirVar = this.f26379k;
        if (zzdirVar != null) {
            zzdirVar.a0();
        }
    }

    public final void b(String str, zzbnn zzbnnVar) {
        synchronized (this.f26372d) {
            try {
                HashMap map = this.f26371c;
                List copyOnWriteArrayList = (List) map.get(str);
                if (copyOnWriteArrayList == null) {
                    copyOnWriteArrayList = new CopyOnWriteArrayList();
                    map.put(str, copyOnWriteArrayList);
                }
                copyOnWriteArrayList.add(zzbnnVar);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void c(String str) {
        synchronized (this.f26372d) {
            try {
                List list = (List) this.f26371c.get(str);
                if (list == null) {
                    return;
                }
                list.clear();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void f() {
        zzcbk zzcbkVar = this.y;
        if (zzcbkVar != null) {
            zzcbkVar.zzf();
            this.y = null;
        }
        View.OnAttachStateChangeListener onAttachStateChangeListener = this.H;
        if (onAttachStateChangeListener != null) {
            this.f26369a.removeOnAttachStateChangeListener(onAttachStateChangeListener);
        }
        synchronized (this.f26372d) {
            try {
                this.f26371c.clear();
                this.f26373e = null;
                this.f26374f = null;
                this.f26375g = null;
                this.f26376h = null;
                this.f26377i = null;
                this.f26378j = null;
                this.f26380l = false;
                this.q = false;
                this.r = false;
                this.s = false;
                this.u = null;
                this.w = null;
                this.v = null;
                zzbvx zzbvxVar = this.x;
                if (zzbvxVar != null) {
                    zzbvxVar.f(true);
                    this.x = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:122:0x02f5 A[Catch: NoClassDefFoundError -> 0x0028, Exception -> 0x002b, TryCatch #18 {Exception -> 0x002b, NoClassDefFoundError -> 0x0028, blocks: (B:3:0x000c, B:5:0x001d, B:10:0x002e, B:12:0x003e, B:14:0x0045, B:16:0x0053, B:18:0x006f, B:20:0x008b, B:22:0x00a2, B:23:0x00a5, B:26:0x00ac, B:29:0x00c6, B:32:0x00d2, B:34:0x00e2, B:36:0x00f7, B:96:0x0238, B:54:0x0188, B:122:0x02f5, B:125:0x0307, B:127:0x030d, B:129:0x031b, B:85:0x01dc, B:97:0x026a, B:98:0x029d, B:53:0x015a, B:35:0x00ed, B:99:0x029e, B:101:0x02a8, B:103:0x02ae, B:105:0x02b1, B:106:0x02b2, B:107:0x02cf, B:109:0x02d2, B:110:0x02d3, B:112:0x02e1, B:116:0x02ed, B:119:0x02f0), top: B:143:0x000c }] */
    /* JADX WARN: Removed duplicated region for block: B:127:0x030d A[Catch: NoClassDefFoundError -> 0x0028, Exception -> 0x002b, TryCatch #18 {Exception -> 0x002b, NoClassDefFoundError -> 0x0028, blocks: (B:3:0x000c, B:5:0x001d, B:10:0x002e, B:12:0x003e, B:14:0x0045, B:16:0x0053, B:18:0x006f, B:20:0x008b, B:22:0x00a2, B:23:0x00a5, B:26:0x00ac, B:29:0x00c6, B:32:0x00d2, B:34:0x00e2, B:36:0x00f7, B:96:0x0238, B:54:0x0188, B:122:0x02f5, B:125:0x0307, B:127:0x030d, B:129:0x031b, B:85:0x01dc, B:97:0x026a, B:98:0x029d, B:53:0x015a, B:35:0x00ed, B:99:0x029e, B:101:0x02a8, B:103:0x02ae, B:105:0x02b1, B:106:0x02b2, B:107:0x02cf, B:109:0x02d2, B:110:0x02d3, B:112:0x02e1, B:116:0x02ed, B:119:0x02f0), top: B:143:0x000c }] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00c6 A[Catch: NoClassDefFoundError -> 0x0028, Exception -> 0x002b, TRY_ENTER, TryCatch #18 {Exception -> 0x002b, NoClassDefFoundError -> 0x0028, blocks: (B:3:0x000c, B:5:0x001d, B:10:0x002e, B:12:0x003e, B:14:0x0045, B:16:0x0053, B:18:0x006f, B:20:0x008b, B:22:0x00a2, B:23:0x00a5, B:26:0x00ac, B:29:0x00c6, B:32:0x00d2, B:34:0x00e2, B:36:0x00f7, B:96:0x0238, B:54:0x0188, B:122:0x02f5, B:125:0x0307, B:127:0x030d, B:129:0x031b, B:85:0x01dc, B:97:0x026a, B:98:0x029d, B:53:0x015a, B:35:0x00ed, B:99:0x029e, B:101:0x02a8, B:103:0x02ae, B:105:0x02b1, B:106:0x02b2, B:107:0x02cf, B:109:0x02d2, B:110:0x02d3, B:112:0x02e1, B:116:0x02ed, B:119:0x02f0), top: B:143:0x000c }] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x01c2 A[Catch: all -> 0x01ca, TryCatch #4 {all -> 0x01ca, blocks: (B:92:0x0217, B:94:0x0229, B:95:0x0230, B:79:0x01b0, B:81:0x01c2, B:84:0x01cd), top: B:134:0x00f7 }] */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0229 A[Catch: all -> 0x01ca, TryCatch #4 {all -> 0x01ca, blocks: (B:92:0x0217, B:94:0x0229, B:95:0x0230, B:79:0x01b0, B:81:0x01c2, B:84:0x01cd), top: B:134:0x00f7 }] */
    /* JADX WARN: Removed duplicated region for block: B:99:0x029e A[Catch: NoClassDefFoundError -> 0x0028, Exception -> 0x002b, TryCatch #18 {Exception -> 0x002b, NoClassDefFoundError -> 0x0028, blocks: (B:3:0x000c, B:5:0x001d, B:10:0x002e, B:12:0x003e, B:14:0x0045, B:16:0x0053, B:18:0x006f, B:20:0x008b, B:22:0x00a2, B:23:0x00a5, B:26:0x00ac, B:29:0x00c6, B:32:0x00d2, B:34:0x00e2, B:36:0x00f7, B:96:0x0238, B:54:0x0188, B:122:0x02f5, B:125:0x0307, B:127:0x030d, B:129:0x031b, B:85:0x01dc, B:97:0x026a, B:98:0x029d, B:53:0x015a, B:35:0x00ed, B:99:0x029e, B:101:0x02a8, B:103:0x02ae, B:105:0x02b1, B:106:0x02b2, B:107:0x02cf, B:109:0x02d2, B:110:0x02d3, B:112:0x02e1, B:116:0x02ed, B:119:0x02f0), top: B:143:0x000c }] */
    /* JADX WARN: Type inference failed for: r13v12 */
    /* JADX WARN: Type inference failed for: r13v3, types: [boolean] */
    /* JADX WARN: Type inference failed for: r13v4 */
    /* JADX WARN: Type inference failed for: r13v9 */
    /* JADX WARN: Type inference failed for: r16v5, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r6v25 */
    /* JADX WARN: Type inference failed for: r6v26 */
    /* JADX WARN: Type inference failed for: r6v27 */
    /* JADX WARN: Type inference failed for: r6v28 */
    /* JADX WARN: Type inference failed for: r6v29, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r6v7, types: [android.os.ParcelFileDescriptor$AutoCloseInputStream, java.io.InputStream] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.webkit.WebResourceResponse g(java.lang.String r21, java.util.Map r22) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 815
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcjc.g(java.lang.String, java.util.Map):android.webkit.WebResourceResponse");
    }

    @Override // com.google.android.gms.ads.internal.client.zza
    public final void h() {
        com.google.android.gms.ads.internal.client.zza zzaVar = this.f26373e;
        if (zzaVar != null) {
            zzaVar.h();
        }
    }

    public final void j(Uri uri) {
        com.google.android.gms.ads.internal.util.zze.k("Received GMSG: ".concat(String.valueOf(uri)));
        HashMap map = this.f26371c;
        String path = uri.getPath();
        List list = (List) map.get(path);
        if (path == null || list == null) {
            com.google.android.gms.ads.internal.util.zze.k("No GMSG handler found for GMSG: ".concat(String.valueOf(uri)));
            if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.r7)).booleanValue() || com.google.android.gms.ads.internal.zzt.C.f21684h.a() == null) {
                return;
            }
            final String strSubstring = (path == null || path.length() < 2) ? "null" : path.substring(1);
            ((zzcdn) zzcdo.f25982a).execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzciz
                @Override // java.lang.Runnable
                public final void run() throws Throwable {
                    int i2 = zzcjc.I;
                    zzbgp zzbgpVarA = com.google.android.gms.ads.internal.zzt.C.f21684h.a();
                    HashSet hashSet = zzbgpVarA.f25035g;
                    String str = strSubstring;
                    if (hashSet.contains(str)) {
                        return;
                    }
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    linkedHashMap.put(PaymentConstants.SDK_VERSION, zzbgpVarA.f25034f);
                    linkedHashMap.put("ue", str);
                    zzbgpVarA.b(zzbgpVarA.a(zzbgpVarA.f25030b, linkedHashMap), null);
                }
            });
            return;
        }
        String encodedQuery = uri.getEncodedQuery();
        zzbgb zzbgbVar = zzbgk.r6;
        com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.f21150e;
        if (((Boolean) zzbdVar.f21153c.a(zzbgbVar)).booleanValue() && this.F.contains(path) && encodedQuery != null) {
            if (encodedQuery.length() >= ((Integer) zzbdVar.f21153c.a(zzbgk.t6)).intValue()) {
                com.google.android.gms.ads.internal.util.zze.k("Parsing gmsg query params on BG thread: ".concat(path));
                ListenableFuture listenableFutureF = com.google.android.gms.ads.internal.zzt.C.f21679c.F(uri);
                zzcit zzcitVar = new zzcit(this, list, path, uri);
                ((zzgxf) listenableFutureF).q(new zzgyk(listenableFutureF, zzcitVar), zzcdo.f25987f);
                return;
            }
        }
        com.google.android.gms.ads.internal.util.zzs zzsVar = com.google.android.gms.ads.internal.zzt.C.f21679c;
        T(com.google.android.gms.ads.internal.util.zzs.o(uri), list, path);
    }

    public final void l0(zzcra zzcraVar, zzehu zzehuVar, zzfpi zzfpiVar) {
        c("/click");
        if (zzehuVar != null && zzfpiVar != null) {
            b("/click", new zzfiu(this.f26379k, zzcraVar, zzfpiVar, zzehuVar));
            return;
        }
        zzdir zzdirVar = this.f26379k;
        zzbnn zzbnnVar = zzbnm.f25337a;
        b("/click", new zzbnh(zzdirVar, zzcraVar));
    }

    public final void m(boolean z) {
        synchronized (this.f26372d) {
            this.t = z;
        }
    }

    public final void m0(zzcra zzcraVar, zzehu zzehuVar, zzdxe zzdxeVar) {
        c("/open");
        b("/open", new zzboa(this.w, this.x, zzehuVar, zzdxeVar, zzcraVar, null));
    }

    @Override // android.webkit.WebViewClient
    public final void onLoadResource(WebView webView, String str) {
        com.google.android.gms.ads.internal.util.zze.k("Loading resource: ".concat(String.valueOf(str)));
        Uri uri = Uri.parse(str);
        if ("gmsg".equalsIgnoreCase(uri.getScheme()) && "mobileads.google.com".equalsIgnoreCase(uri.getHost())) {
            j(uri);
        }
    }

    @Override // android.webkit.WebViewClient
    public final void onPageFinished(WebView webView, String str) {
        Toolbar toolbar;
        synchronized (this.f26372d) {
            try {
                zzcjn zzcjnVar = this.f26369a;
                if (zzcjnVar.n()) {
                    com.google.android.gms.ads.internal.util.zze.k("Blank page loaded, 1...");
                    zzcjnVar.E0();
                    return;
                }
                this.B = true;
                zzcko zzckoVar = this.f26376h;
                if (zzckoVar != null) {
                    zzckoVar.zza();
                    this.f26376h = null;
                }
                v0();
                zzcjn zzcjnVar2 = this.f26369a;
                if (((zzcju) zzcjnVar2.f26410a).z() != null) {
                    if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.ad)).booleanValue() || (toolbar = ((zzcju) zzcjnVar2.f26410a).z().v) == null) {
                        return;
                    }
                    toolbar.setSubtitle(str);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedError(WebView webView, int i2, String str, String str2) {
        this.f26381m = true;
        this.n = i2;
        this.o = str;
        this.p = str2;
    }

    public final boolean s0() {
        boolean z;
        synchronized (this.f26372d) {
            z = this.q;
        }
        return z;
    }

    @Override // android.webkit.WebViewClient
    public final WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        return g(str, Collections.EMPTY_MAP);
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideKeyEvent(WebView webView, KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        if (keyCode == 79 || keyCode == 222) {
            return true;
        }
        switch (keyCode) {
            case 85:
            case 86:
            case 87:
            case 88:
            case WKSRecord.Service.SU_MIT_TG /* 89 */:
            case 90:
            case WKSRecord.Service.MIT_DOV /* 91 */:
                return true;
            default:
                switch (keyCode) {
                    case 126:
                    case WKSRecord.Service.LOCUS_CON /* 127 */:
                    case 128:
                    case WKSRecord.Service.PWDGEN /* 129 */:
                    case WKSRecord.Service.CISCO_FNA /* 130 */:
                        return true;
                    default:
                        return false;
                }
        }
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        com.google.android.gms.ads.internal.util.zze.k("AdWebView shouldOverrideUrlLoading: ".concat(String.valueOf(str)));
        Uri uriB = Uri.parse(str);
        if ("gmsg".equalsIgnoreCase(uriB.getScheme()) && "mobileads.google.com".equalsIgnoreCase(uriB.getHost())) {
            j(uriB);
            return true;
        }
        boolean z = this.f26380l;
        zzcjn zzcjnVar = this.f26369a;
        if (z && webView == ((WebView) zzcjnVar.f26410a)) {
            String scheme = uriB.getScheme();
            if ("http".equalsIgnoreCase(scheme) || "https".equalsIgnoreCase(scheme)) {
                com.google.android.gms.ads.internal.client.zza zzaVar = this.f26373e;
                if (zzaVar != null) {
                    zzaVar.h();
                    zzcbk zzcbkVar = this.y;
                    if (zzcbkVar != null) {
                        zzcbkVar.b(str);
                    }
                    this.f26373e = null;
                }
                zzdir zzdirVar = this.f26379k;
                if (zzdirVar != null) {
                    zzdirVar.S();
                    this.f26379k = null;
                }
                return super.shouldOverrideUrlLoading(webView, str);
            }
        }
        Object obj = zzcjnVar.f26410a;
        zzcir zzcirVar = zzcjnVar.f26410a;
        if (((WebView) obj).willNotDraw()) {
            com.google.android.gms.ads.internal.util.client.zzo.f("AdWebView unable to handle URL: ".concat(String.valueOf(str)));
            return true;
        }
        try {
            zzayq zzayqVarD = ((zzcju) zzcirVar).d();
            zzfio zzfioVarC = ((zzcju) zzcirVar).C();
            if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.ed)).booleanValue() || zzfioVarC == null) {
                if (zzayqVarD != null && zzayqVarD.a(uriB)) {
                    uriB = zzayqVarD.b(uriB, zzcjnVar.getContext(), zzcjnVar, ((zzcju) zzcirVar).zzj());
                }
            } else if (zzayqVarD != null && zzayqVarD.a(uriB)) {
                uriB = zzfioVarC.a(uriB, zzcjnVar.getContext(), zzcjnVar, ((zzcju) zzcirVar).zzj());
            }
        } catch (zzayr unused) {
            com.google.android.gms.ads.internal.util.client.zzo.f("Unable to append parameter to URL: ".concat(String.valueOf(str)));
        }
        com.google.android.gms.ads.internal.zzb zzbVar = this.w;
        if (zzbVar == null || zzbVar.a()) {
            w0(new com.google.android.gms.ads.internal.overlay.zzc("android.intent.action.VIEW", uriB.toString(), null, null, null, null, null, null), true, false, ((zzcju) zzcirVar).zzn());
        } else {
            zzbVar.b(str);
        }
        return true;
    }

    public final void t(int i2, int i3) {
        zzbwc zzbwcVar = this.v;
        if (zzbwcVar != null) {
            zzbwcVar.f(i2, i3);
        }
        zzbvx zzbvxVar = this.x;
        if (zzbvxVar != null) {
            synchronized (zzbvxVar.f25626k) {
                zzbvxVar.f25620e = i2;
                zzbvxVar.f25621f = i3;
            }
        }
    }

    public final boolean t0() {
        boolean z;
        synchronized (this.f26372d) {
            z = this.r;
        }
        return z;
    }

    public final void u0() {
        zzcbk zzcbkVar = this.y;
        if (zzcbkVar != null) {
            zzcjn zzcjnVar = this.f26369a;
            WebView webView = (WebView) zzcjnVar.f26410a;
            WeakHashMap weakHashMap = ViewCompat.f3080a;
            if (webView.isAttachedToWindow()) {
                F(webView, zzcbkVar, 10);
                return;
            }
            View.OnAttachStateChangeListener onAttachStateChangeListener = this.H;
            if (onAttachStateChangeListener != null) {
                zzcjnVar.removeOnAttachStateChangeListener(onAttachStateChangeListener);
            }
            zzcis zzcisVar = new zzcis(this, zzcbkVar);
            this.H = zzcisVar;
            zzcjnVar.addOnAttachStateChangeListener(zzcisVar);
        }
    }

    public final void v0() {
        zzckn zzcknVar = this.f26375g;
        zzcjn zzcjnVar = this.f26369a;
        if (zzcknVar != null && ((this.B && this.D <= 0) || this.C || this.f26381m)) {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.l2)).booleanValue() && ((zzcju) zzcjnVar.f26410a).zzq() != null) {
                zzcir zzcirVar = zzcjnVar.f26410a;
                zzbgr.a(((zzcju) zzcirVar).zzq().f25045b, ((zzcju) zzcirVar).zzi(), "awfllc");
            }
            zzckn zzcknVar2 = this.f26375g;
            boolean z = false;
            if (!this.C && !this.f26381m) {
                z = true;
            }
            zzcknVar2.a(this.o, this.n, this.p, z);
            this.f26375g = null;
        }
        zzcjnVar.u();
    }

    public final void w0(com.google.android.gms.ads.internal.overlay.zzc zzcVar, boolean z, boolean z2, String str) {
        boolean z3;
        zzcjn zzcjnVar = this.f26369a;
        boolean zR = zzcjnVar.r();
        boolean z4 = false;
        boolean z5 = i0(zR, zzcjnVar) || z2;
        if (z5 || !z) {
            z3 = zR;
            z4 = true;
        } else {
            z3 = zR;
        }
        a(new AdOverlayInfoParcel(zzcVar, z5 ? null : this.f26373e, z3 ? null : this.f26374f, this.u, ((zzcju) zzcjnVar.f26410a).zzs(), zzcjnVar, z4 ? null : this.f26379k, str));
    }

    public final void y(com.google.android.gms.ads.internal.client.zza zzaVar, zzbmd zzbmdVar, com.google.android.gms.ads.internal.overlay.zzr zzrVar, zzbmf zzbmfVar, com.google.android.gms.ads.internal.overlay.zzad zzadVar, boolean z, zzbnq zzbnqVar, com.google.android.gms.ads.internal.zzb zzbVar, zzbwe zzbweVar, zzcbk zzcbkVar, final zzehu zzehuVar, final zzfpi zzfpiVar, zzdxe zzdxeVar, zzboi zzboiVar, zzdir zzdirVar, zzboh zzbohVar, zzbob zzbobVar, zzbno zzbnoVar, zzcra zzcraVar, zzdyh zzdyhVar, zzczj zzczjVar, zzcze zzczeVar) {
        zzcjn zzcjnVar = this.f26369a;
        com.google.android.gms.ads.internal.zzb zzbVar2 = zzbVar == null ? new com.google.android.gms.ads.internal.zzb(zzcjnVar.getContext(), zzcbkVar) : zzbVar;
        this.x = new zzbvx(zzcjnVar, zzbweVar);
        this.y = zzcbkVar;
        zzbgb zzbgbVar = zzbgk.o1;
        com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.f21150e;
        if (((Boolean) zzbdVar.f21153c.a(zzbgbVar)).booleanValue()) {
            b("/adMetadata", new zzbmc(zzbmdVar));
        }
        if (zzbmfVar != null) {
            b("/appEvent", new zzbme(zzbmfVar));
        }
        b("/backButton", zzbnm.f25346j);
        b("/refresh", zzbnm.f25347k);
        b("/canOpenApp", zzbnc.f25325a);
        b("/canOpenURLs", zzbnl.f25336a);
        b("/canOpenIntents", zzbnd.f25326a);
        b("/close", zzbnm.f25340d);
        b("/customClose", zzbnm.f25341e);
        b("/instrument", zzbnm.n);
        b("/delayPageLoaded", zzbnm.p);
        b("/delayPageClosed", zzbnm.q);
        b("/getLocationInfo", zzbnm.r);
        b("/log", zzbnm.f25343g);
        b("/mraid", new zzbnu(zzbVar2, this.x, zzbweVar));
        zzbwc zzbwcVar = this.v;
        if (zzbwcVar != null) {
            b("/mraidLoaded", zzbwcVar);
        }
        com.google.android.gms.ads.internal.zzb zzbVar3 = zzbVar2;
        b("/open", new zzboa(zzbVar3, this.x, zzehuVar, zzdxeVar, zzcraVar, zzczjVar));
        b("/precache", new zzcgy());
        b("/touch", zzbnj.f25333a);
        b("/video", zzbnm.f25348l);
        b("/videoMeta", zzbnm.f25349m);
        if (zzehuVar == null || zzfpiVar == null) {
            b("/click", new zzbnh(zzdirVar, zzcraVar));
            b("/httpTrack", zzbni.f25332a);
        } else {
            b("/click", new zzfiu(zzdirVar, zzcraVar, zzfpiVar, zzehuVar));
            b("/httpTrack", new zzbnn() { // from class: com.google.android.gms.internal.ads.zzfit
                @Override // com.google.android.gms.internal.ads.zzbnn
                public final void a(Object obj, Map map) {
                    zzcii zzciiVar = (zzcii) obj;
                    String str = (String) map.get("u");
                    if (str == null) {
                        int i2 = com.google.android.gms.ads.internal.util.zze.f21576b;
                        com.google.android.gms.ads.internal.util.client.zzo.f("URL missing from httpTrack GMSG.");
                        return;
                    }
                    zzfhr zzfhrVarV = zzciiVar.v();
                    if (zzfhrVarV != null && !zzfhrVarV.i0) {
                        zzfpiVar.b(str, zzfhrVarV.x0, null, null);
                        return;
                    }
                    zzfhu zzfhuVarE = ((zzcjy) zzciiVar).e();
                    if (zzfhuVarE == null) {
                        com.google.android.gms.ads.internal.zzt.C.f21684h.d("BufferingGmsgHandlers.getBufferingHttpTrackGmsgHandler", new IllegalArgumentException("Common configuration cannot be null"));
                    } else {
                        zzehw zzehwVar = new zzehw(com.google.android.gms.ads.internal.zzt.C.f21687k.currentTimeMillis(), zzfhuVarE.f31167b, str, 2);
                        zzehu zzehuVar2 = zzehuVar;
                        zzehuVar2.getClass();
                        zzehuVar2.a(new zzehr(zzehuVar2, zzehwVar));
                    }
                }
            });
        }
        boolean zA = com.google.android.gms.ads.internal.zzt.C.y.a(zzcjnVar.getContext());
        zzcir zzcirVar = zzcjnVar.f26410a;
        if (zA) {
            HashMap map = new HashMap();
            if (((zzcju) zzcirVar).v() != null) {
                map = ((zzcju) zzcirVar).v().w0;
            }
            b("/logScionEvent", new zzbnt(zzcjnVar.getContext(), map));
        }
        if (zzbnqVar != null) {
            b("/setInterstitialProperties", new zzbnp(zzbnqVar));
        }
        zzbgi zzbgiVar = zzbdVar.f21153c;
        if (zzboiVar != null && ((Boolean) zzbgiVar.a(zzbgk.aa)).booleanValue()) {
            b("/inspectorNetworkExtras", zzboiVar);
        }
        if (((Boolean) zzbgiVar.a(zzbgk.ta)).booleanValue() && zzbohVar != null) {
            b("/shareSheet", zzbohVar);
        }
        if (((Boolean) zzbgiVar.a(zzbgk.B8)).booleanValue() && zzdyhVar != null) {
            b("/onDeviceStorageEvent", new zzbnv(zzdyhVar));
        }
        if (((Boolean) zzbgiVar.a(zzbgk.ya)).booleanValue() && zzbobVar != null) {
            b("/inspectorOutOfContextTest", zzbobVar);
        }
        if (((Boolean) zzbgiVar.a(zzbgk.Da)).booleanValue() && zzbnoVar != null) {
            b("/inspectorStorage", zzbnoVar);
        }
        if (((Boolean) zzbgiVar.a(zzbgk.Fc)).booleanValue()) {
            b("/bindPlayStoreOverlay", zzbnm.u);
            b("/presentPlayStoreOverlay", zzbnm.v);
            b("/expandPlayStoreOverlay", zzbnm.w);
            b("/collapsePlayStoreOverlay", zzbnm.x);
            b("/closePlayStoreOverlay", zzbnm.y);
        }
        if (((Boolean) zzbgiVar.a(zzbgk.T3)).booleanValue()) {
            b("/setPAIDPersonalizationEnabled", zzbnm.A);
            b("/resetPAID", zzbnm.z);
        }
        if (((Boolean) zzbgiVar.a(zzbgk.Zc)).booleanValue() && ((zzcju) zzcirVar).v() != null && ((zzcju) zzcirVar).v().r0) {
            b("/writeToLocalStorage", zzbnm.B);
            b("/clearLocalStorageKeys", zzbnm.C);
        }
        this.f26373e = zzaVar;
        this.f26374f = zzrVar;
        this.f26377i = zzbmdVar;
        this.f26378j = zzbmfVar;
        this.u = zzadVar;
        this.w = zzbVar3;
        this.f26379k = zzdirVar;
        this.z = zzdxeVar;
        this.A = zzczeVar;
        this.f26380l = z;
    }
}
