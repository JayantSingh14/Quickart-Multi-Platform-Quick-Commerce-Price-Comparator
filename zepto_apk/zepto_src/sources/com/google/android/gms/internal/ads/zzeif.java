package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.PendingIntent;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.app.NotificationManagerCompat;
import com.google.android.gms.ads.impl.R;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;

/* loaded from: classes4.dex */
public final class zzeif extends zzbwq {

    /* renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ int f29392i = 0;

    /* renamed from: b, reason: collision with root package name */
    public final HashMap f29393b = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    public final Context f29394c;

    /* renamed from: d, reason: collision with root package name */
    public final zzdxe f29395d;

    /* renamed from: e, reason: collision with root package name */
    public final com.google.android.gms.ads.internal.util.client.zzu f29396e;

    /* renamed from: f, reason: collision with root package name */
    public final zzehu f29397f;

    /* renamed from: g, reason: collision with root package name */
    public String f29398g;

    /* renamed from: h, reason: collision with root package name */
    public String f29399h;

    public zzeif(Context context, zzehu zzehuVar, com.google.android.gms.ads.internal.util.client.zzu zzuVar, zzdxe zzdxeVar) {
        this.f29394c = context;
        this.f29395d = zzdxeVar;
        this.f29396e = zzuVar;
        this.f29397f = zzehuVar;
    }

    public static void Yb(Context context, zzdxe zzdxeVar, zzehu zzehuVar, String str, String str2, Map map) {
        String strA;
        com.google.android.gms.ads.internal.zzt zztVar = com.google.android.gms.ads.internal.zzt.C;
        String str3 = true != zztVar.f21684h.i(context) ? "offline" : "online";
        if (zzdxeVar != null) {
            zzdxd zzdxdVarA = zzdxeVar.a();
            zzdxdVarA.b("gqi", str);
            zzdxdVarA.b("action", str2);
            zzdxdVarA.b("device_connectivity", str3);
            zzdxdVarA.b("event_timestamp", String.valueOf(zztVar.f21687k.currentTimeMillis()));
            for (Map.Entry entry : map.entrySet()) {
                zzdxdVarA.b((String) entry.getKey(), (String) entry.getValue());
            }
            strA = zzdxdVarA.f28728b.f28729a.f28753f.a(zzdxdVarA.f28727a);
        } else {
            strA = "";
        }
        zzehw zzehwVar = new zzehw(com.google.android.gms.ads.internal.zzt.C.f21687k.currentTimeMillis(), str, strA, 2);
        zzehuVar.getClass();
        zzehuVar.a(new zzehr(zzehuVar, zzehwVar));
    }

    public static final PendingIntent Zb(Context context, String str, String str2, String str3) {
        Intent intent = new Intent();
        intent.setAction(str);
        intent.putExtra("offline_notification_action", str);
        intent.putExtra("gws_query_id", str2);
        intent.putExtra("uri", str3);
        if (Build.VERSION.SDK_INT < 29 || !str.equals("offline_notification_clicked")) {
            intent.setClassName(context, "com.google.android.gms.ads.AdService");
            return PendingIntent.getService(context, 0, zzgne.a(intent, 1140850688), 1140850688);
        }
        intent.setClassName(context, "com.google.android.gms.ads.NotificationHandlerActivity");
        return PendingIntent.getActivity(context, 0, zzgne.a(intent, 201326592), 201326592);
    }

    public static String ec(int i2, String str) {
        Resources resourcesC = com.google.android.gms.ads.internal.zzt.C.f21684h.c();
        if (resourcesC != null) {
            try {
                return resourcesC.getString(i2);
            } catch (Resources.NotFoundException unused) {
            }
        }
        return str;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x00af  */
    @Override // com.google.android.gms.internal.ads.zzbwr
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void Bb(com.google.android.gms.dynamic.IObjectWrapper r8, com.google.android.gms.ads.internal.offline.buffering.zza r9) {
        /*
            r7 = this;
            java.lang.Object r8 = com.google.android.gms.dynamic.ObjectWrapper.z0(r8)
            android.content.Context r8 = (android.content.Context) r8
            java.lang.String r0 = r9.f21311a
            java.util.HashMap r1 = r7.f29393b
            java.lang.String r2 = r7.f29398g
            java.lang.Object r1 = r1.get(r2)
            com.google.android.gms.internal.ads.zzehm r1 = (com.google.android.gms.internal.ads.zzehm) r1
            if (r1 != 0) goto L17
            java.lang.String r1 = ""
            goto L1b
        L17:
            java.lang.String r1 = r1.a()
        L1b:
            com.google.android.gms.ads.internal.zzt r2 = com.google.android.gms.ads.internal.zzt.C
            com.google.android.gms.ads.internal.util.zzu r2 = r2.f21682f
            r2.b(r8)
            java.lang.String r2 = "offline_notification_clicked"
            java.lang.String r3 = r9.f21312b
            android.app.PendingIntent r2 = Zb(r8, r2, r3, r0)
            java.lang.String r4 = "offline_notification_dismissed"
            android.app.PendingIntent r0 = Zb(r8, r4, r3, r0)
            androidx.core.app.NotificationCompat$Builder r4 = new androidx.core.app.NotificationCompat$Builder
            java.lang.String r5 = "offline_notification_channel"
            r4.<init>(r8, r5)
            boolean r5 = android.text.TextUtils.isEmpty(r1)
            if (r5 != 0) goto L51
            int r5 = com.google.android.gms.ads.impl.R.string.offline_notification_title_with_advertiser
            java.lang.String r6 = "You are back online! Continue learning about %s"
            java.lang.String r5 = ec(r5, r6)
            java.lang.Object[] r1 = new java.lang.Object[]{r1}
            java.lang.String r1 = java.lang.String.format(r5, r1)
            r4.h(r1)
            goto L5c
        L51:
            int r1 = com.google.android.gms.ads.impl.R.string.offline_notification_title
            java.lang.String r5 = "You are back online! Let's pick up where we left off"
            java.lang.String r1 = ec(r1, r5)
            r4.h(r1)
        L5c:
            r1 = 16
            r5 = 1
            r4.i(r1, r5)
            android.app.Notification r1 = r4.y
            r1.deleteIntent = r0
            r4.f2670g = r2
            android.content.pm.ApplicationInfo r0 = r8.getApplicationInfo()
            int r0 = r0.icon
            android.app.Notification r1 = r4.y
            r1.icon = r0
            com.google.android.gms.internal.ads.zzbgb r0 = com.google.android.gms.internal.ads.zzbgk.x9
            com.google.android.gms.ads.internal.client.zzbd r1 = com.google.android.gms.ads.internal.client.zzbd.f21150e
            com.google.android.gms.internal.ads.zzbgi r2 = r1.f21153c
            java.lang.Object r0 = r2.a(r0)
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r0 = r0.intValue()
            r4.f2673j = r0
            com.google.android.gms.internal.ads.zzbgb r0 = com.google.android.gms.internal.ads.zzbgk.z9
            com.google.android.gms.internal.ads.zzbgi r1 = r1.f21153c
            java.lang.Object r0 = r1.a(r0)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            r1 = 0
            if (r0 == 0) goto Laf
            java.lang.String r9 = r9.f21313c
            boolean r0 = r9.isEmpty()
            if (r0 != 0) goto Laf
            java.net.URL r0 = new java.net.URL     // Catch: java.io.IOException -> Laf
            r0.<init>(r9)     // Catch: java.io.IOException -> Laf
            java.net.URLConnection r9 = r0.openConnection()     // Catch: java.io.IOException -> Laf
            java.io.InputStream r9 = r9.getInputStream()     // Catch: java.io.IOException -> Laf
            android.graphics.Bitmap r9 = android.graphics.BitmapFactory.decodeStream(r9)     // Catch: java.io.IOException -> Laf
            goto Lb0
        Laf:
            r9 = r1
        Lb0:
            if (r9 == 0) goto Lc7
            r4.j(r9)     // Catch: android.content.res.Resources.NotFoundException -> Lc7
            androidx.core.app.NotificationCompat$BigPictureStyle r0 = new androidx.core.app.NotificationCompat$BigPictureStyle     // Catch: android.content.res.Resources.NotFoundException -> Lc7
            r0.<init>()     // Catch: android.content.res.Resources.NotFoundException -> Lc7
            androidx.core.graphics.drawable.IconCompat r9 = androidx.core.graphics.drawable.IconCompat.b(r9)     // Catch: android.content.res.Resources.NotFoundException -> Lc7
            r0.f2660b = r9     // Catch: android.content.res.Resources.NotFoundException -> Lc7
            r0.f2661c = r1     // Catch: android.content.res.Resources.NotFoundException -> Lc7
            r0.f2662d = r5     // Catch: android.content.res.Resources.NotFoundException -> Lc7
            r4.o(r0)     // Catch: android.content.res.Resources.NotFoundException -> Lc7
        Lc7:
            java.lang.String r9 = "notification"
            java.lang.Object r8 = r8.getSystemService(r9)
            android.app.NotificationManager r8 = (android.app.NotificationManager) r8
            java.util.HashMap r9 = new java.util.HashMap
            r9.<init>()
            android.app.Notification r0 = r4.b()     // Catch: java.lang.IllegalArgumentException -> Le1
            r1 = 54321(0xd431, float:7.612E-41)
            r8.notify(r3, r1, r0)     // Catch: java.lang.IllegalArgumentException -> Le1
            java.lang.String r8 = "offline_notification_impression"
            goto Led
        Le1:
            r8 = move-exception
            java.lang.String r0 = "notification_not_shown_reason"
            java.lang.String r8 = r8.getMessage()
            r9.put(r0, r8)
            java.lang.String r8 = "offline_notification_failed"
        Led:
            r7.dc(r3, r8, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzeif.Bb(com.google.android.gms.dynamic.IObjectWrapper, com.google.android.gms.ads.internal.offline.buffering.zza):void");
    }

    @Override // com.google.android.gms.internal.ads.zzbwr
    public final void X0(IObjectWrapper iObjectWrapper) throws IllegalAccessException, Resources.NotFoundException, InstantiationException, IllegalArgumentException, InvocationTargetException {
        zzeih zzeihVar = (zzeih) ObjectWrapper.z0(iObjectWrapper);
        final Activity activityA = zzeihVar.a();
        final com.google.android.gms.ads.internal.overlay.zzm zzmVarB = zzeihVar.b();
        this.f29398g = zzeihVar.c();
        this.f29399h = zzeihVar.d();
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.w9)).booleanValue()) {
            ac(activityA, zzmVarB);
            return;
        }
        dc(this.f29398g, "dialog_impression", zzgvd.f33244g);
        com.google.android.gms.ads.internal.util.zzs zzsVar = com.google.android.gms.ads.internal.zzt.C.f21679c;
        AlertDialog.Builder builderK = com.google.android.gms.ads.internal.util.zzs.k(activityA);
        builderK.setTitle(ec(R.string.offline_opt_in_title, "Open ad when you're back online.")).setMessage(ec(R.string.offline_opt_in_message, "We'll send you a notification with a link to the advertiser site.")).setPositiveButton(ec(R.string.offline_opt_in_confirm, "OK"), new DialogInterface.OnClickListener() { // from class: com.google.android.gms.internal.ads.zzeie
            @Override // android.content.DialogInterface.OnClickListener
            public final /* synthetic */ void onClick(DialogInterface dialogInterface, int i2) throws IllegalAccessException, Resources.NotFoundException, InstantiationException, IllegalArgumentException, InvocationTargetException {
                zzeif zzeifVar = this.f29389a;
                zzeifVar.getClass();
                HashMap map = new HashMap();
                map.put("dialog_action", "confirm");
                zzeifVar.dc(zzeifVar.f29398g, "dialog_click", map);
                zzeifVar.ac(activityA, zzmVarB);
            }
        }).setNegativeButton(ec(R.string.offline_opt_in_decline, "No thanks"), new DialogInterface.OnClickListener() { // from class: com.google.android.gms.internal.ads.zzehy
            @Override // android.content.DialogInterface.OnClickListener
            public final /* synthetic */ void onClick(DialogInterface dialogInterface, int i2) {
                zzeif zzeifVar = this.f29376a;
                zzeifVar.f29397f.b(zzeifVar.f29398g);
                HashMap map = new HashMap();
                map.put("dialog_action", "dismiss");
                zzeifVar.dc(zzeifVar.f29398g, "dialog_click", map);
                com.google.android.gms.ads.internal.overlay.zzm zzmVar = zzmVarB;
                if (zzmVar != null) {
                    zzmVar.zzb();
                }
            }
        }).setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.google.android.gms.internal.ads.zzehz
            @Override // android.content.DialogInterface.OnCancelListener
            public final /* synthetic */ void onCancel(DialogInterface dialogInterface) {
                zzeif zzeifVar = this.f29378a;
                zzeifVar.f29397f.b(zzeifVar.f29398g);
                HashMap map = new HashMap();
                map.put("dialog_action", "dismiss");
                zzeifVar.dc(zzeifVar.f29398g, "dialog_click", map);
                com.google.android.gms.ads.internal.overlay.zzm zzmVar = zzmVarB;
                if (zzmVar != null) {
                    zzmVar.zzb();
                }
            }
        });
        builderK.create().show();
    }

    public final void Xb(String str, zzdnm zzdnmVar) {
        zzbjy zzbjyVar;
        String strF = zzdnmVar.f();
        String strA = zzdnmVar.a();
        String string = "";
        if (TextUtils.isEmpty(strF)) {
            strF = strA != null ? strA : "";
        }
        zzbjy zzbjyVarB = zzdnmVar.b();
        if (zzbjyVarB != null) {
            try {
                string = zzbjyVarB.zzc().toString();
            } catch (RemoteException unused) {
            }
        }
        synchronized (zzdnmVar) {
            zzbjyVar = zzdnmVar.s;
        }
        Drawable drawable = null;
        if (zzbjyVar != null) {
            try {
                IObjectWrapper iObjectWrapperZzb = zzbjyVar.zzb();
                if (iObjectWrapperZzb != null) {
                    drawable = (Drawable) ObjectWrapper.z0(iObjectWrapperZzb);
                }
            } catch (RemoteException unused2) {
            }
        }
        this.f29393b.put(str, new zzehj(strF, string, drawable));
    }

    public final void ac(final Activity activity, final com.google.android.gms.ads.internal.overlay.zzm zzmVar) throws IllegalAccessException, Resources.NotFoundException, InstantiationException, IllegalArgumentException, InvocationTargetException {
        com.google.android.gms.ads.internal.util.zzs zzsVar = com.google.android.gms.ads.internal.zzt.C.f21679c;
        if (new NotificationManagerCompat(activity).f2692b.areNotificationsEnabled()) {
            bc();
            cc(activity, zzmVar);
            return;
        }
        int i2 = Build.VERSION.SDK_INT;
        zzgtg zzgtgVar = zzgvd.f33244g;
        if (i2 >= 33) {
            activity.requestPermissions(new String[]{"android.permission.POST_NOTIFICATIONS"}, 12345);
            dc(this.f29398g, "asnpdi", zzgtgVar);
        } else {
            AlertDialog.Builder builderK = com.google.android.gms.ads.internal.util.zzs.k(activity);
            builderK.setTitle(ec(R.string.notifications_permission_title, "Allow app to send you notifications?")).setPositiveButton(ec(R.string.notifications_permission_confirm, "Allow"), new DialogInterface.OnClickListener() { // from class: com.google.android.gms.internal.ads.zzeia
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) throws IllegalAccessException, InstantiationException, IllegalArgumentException, InvocationTargetException {
                    zzeif zzeifVar = this.f29381a;
                    zzeifVar.getClass();
                    HashMap map = new HashMap();
                    map.put("dialog_action", "confirm");
                    zzeifVar.dc(zzeifVar.f29398g, "rtsdc", map);
                    com.google.android.gms.ads.internal.util.zzu zzuVar = com.google.android.gms.ads.internal.zzt.C.f21682f;
                    Activity activity2 = activity;
                    activity2.startActivity(zzuVar.d(activity2));
                    zzeifVar.bc();
                    com.google.android.gms.ads.internal.overlay.zzm zzmVar2 = zzmVar;
                    if (zzmVar2 != null) {
                        zzmVar2.zzb();
                    }
                }
            }).setNegativeButton(ec(R.string.notifications_permission_decline, "Don't allow"), new DialogInterface.OnClickListener() { // from class: com.google.android.gms.internal.ads.zzeib
                @Override // android.content.DialogInterface.OnClickListener
                public final /* synthetic */ void onClick(DialogInterface dialogInterface, int i3) {
                    zzeif zzeifVar = this.f29384a;
                    zzeifVar.f29397f.b(zzeifVar.f29398g);
                    HashMap map = new HashMap();
                    map.put("dialog_action", "dismiss");
                    zzeifVar.dc(zzeifVar.f29398g, "rtsdc", map);
                    com.google.android.gms.ads.internal.overlay.zzm zzmVar2 = zzmVar;
                    if (zzmVar2 != null) {
                        zzmVar2.zzb();
                    }
                }
            }).setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.google.android.gms.internal.ads.zzeic
                @Override // android.content.DialogInterface.OnCancelListener
                public final /* synthetic */ void onCancel(DialogInterface dialogInterface) {
                    zzeif zzeifVar = this.f29386a;
                    zzeifVar.f29397f.b(zzeifVar.f29398g);
                    HashMap map = new HashMap();
                    map.put("dialog_action", "dismiss");
                    zzeifVar.dc(zzeifVar.f29398g, "rtsdc", map);
                    com.google.android.gms.ads.internal.overlay.zzm zzmVar2 = zzmVar;
                    if (zzmVar2 != null) {
                        zzmVar2.zzb();
                    }
                }
            });
            builderK.create().show();
            dc(this.f29398g, "rtsdi", zzgtgVar);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void bc() throws java.lang.IllegalAccessException, java.lang.InstantiationException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        /*
            r7 = this;
            com.google.android.gms.ads.internal.zzt r0 = com.google.android.gms.ads.internal.zzt.C     // Catch: android.os.RemoteException -> L22
            com.google.android.gms.ads.internal.util.zzs r0 = r0.f21679c     // Catch: android.os.RemoteException -> L22
            android.content.Context r0 = r7.f29394c     // Catch: android.os.RemoteException -> L22
            com.google.android.gms.ads.internal.util.zzbo r1 = com.google.android.gms.ads.internal.util.zzs.c(r0)     // Catch: android.os.RemoteException -> L22
            com.google.android.gms.dynamic.ObjectWrapper r2 = new com.google.android.gms.dynamic.ObjectWrapper     // Catch: android.os.RemoteException -> L22
            r2.<init>(r0)     // Catch: android.os.RemoteException -> L22
            com.google.android.gms.ads.internal.offline.buffering.zza r3 = new com.google.android.gms.ads.internal.offline.buffering.zza     // Catch: android.os.RemoteException -> L22
            java.lang.String r4 = r7.f29399h     // Catch: android.os.RemoteException -> L22
            java.lang.String r5 = r7.f29398g     // Catch: android.os.RemoteException -> L22
            java.util.HashMap r6 = r7.f29393b     // Catch: android.os.RemoteException -> L22
            java.lang.Object r6 = r6.get(r5)     // Catch: android.os.RemoteException -> L22
            com.google.android.gms.internal.ads.zzehm r6 = (com.google.android.gms.internal.ads.zzehm) r6     // Catch: android.os.RemoteException -> L22
            if (r6 != 0) goto L24
            java.lang.String r6 = ""
            goto L28
        L22:
            r0 = move-exception
            goto L43
        L24:
            java.lang.String r6 = r6.b()     // Catch: android.os.RemoteException -> L22
        L28:
            r3.<init>(r4, r5, r6)     // Catch: android.os.RemoteException -> L22
            boolean r2 = r1.zzg(r2, r3)     // Catch: android.os.RemoteException -> L22
            if (r2 != 0) goto L41
            com.google.android.gms.dynamic.ObjectWrapper r3 = new com.google.android.gms.dynamic.ObjectWrapper     // Catch: android.os.RemoteException -> L3f
            r3.<init>(r0)     // Catch: android.os.RemoteException -> L3f
            java.lang.String r0 = r7.f29399h     // Catch: android.os.RemoteException -> L3f
            java.lang.String r4 = r7.f29398g     // Catch: android.os.RemoteException -> L3f
            boolean r0 = r1.zze(r3, r0, r4)     // Catch: android.os.RemoteException -> L3f
            goto L4c
        L3f:
            r0 = move-exception
            goto L44
        L41:
            r0 = 1
            goto L4c
        L43:
            r2 = 0
        L44:
            int r1 = com.google.android.gms.ads.internal.util.zze.f21576b
            java.lang.String r1 = "Failed to schedule offline notification poster."
            com.google.android.gms.ads.internal.util.client.zzo.d(r1, r0)
            r0 = r2
        L4c:
            if (r0 != 0) goto L5e
            com.google.android.gms.internal.ads.zzehu r0 = r7.f29397f
            java.lang.String r1 = r7.f29398g
            r0.b(r1)
            java.lang.String r0 = r7.f29398g
            com.google.android.gms.internal.ads.zzgtg r1 = com.google.android.gms.internal.ads.zzgvd.f33244g
            java.lang.String r2 = "offline_notification_worker_not_scheduled"
            r7.dc(r0, r2, r1)
        L5e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzeif.bc():void");
    }

    public final void cc(Activity activity, final com.google.android.gms.ads.internal.overlay.zzm zzmVar) throws Resources.NotFoundException {
        XmlResourceParser layout;
        AlertDialog alertDialogCreate;
        com.google.android.gms.ads.internal.zzt zztVar = com.google.android.gms.ads.internal.zzt.C;
        com.google.android.gms.ads.internal.util.zzs zzsVar = zztVar.f21679c;
        AlertDialog.Builder onCancelListener = com.google.android.gms.ads.internal.util.zzs.k(activity).setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.google.android.gms.internal.ads.zzeid
            @Override // android.content.DialogInterface.OnCancelListener
            public final /* synthetic */ void onCancel(DialogInterface dialogInterface) {
                com.google.android.gms.ads.internal.overlay.zzm zzmVar2 = zzmVar;
                if (zzmVar2 != null) {
                    zzmVar2.zzb();
                }
            }
        });
        int i2 = R.layout.offline_ads_dialog;
        Resources resourcesC = zztVar.f21684h.c();
        if (resourcesC == null) {
            layout = null;
        } else {
            try {
                layout = resourcesC.getLayout(i2);
            } catch (Resources.NotFoundException unused) {
            }
        }
        if (layout == null) {
            onCancelListener.setMessage(ec(R.string.offline_dialog_text, "Thanks for your interest.\nWe will share more once you're back online."));
            alertDialogCreate = onCancelListener.create();
        } else {
            try {
                View viewInflate = activity.getLayoutInflater().inflate(layout, (ViewGroup) null);
                onCancelListener.setView(viewInflate);
                HashMap map = this.f29393b;
                zzehm zzehmVar = (zzehm) map.get(this.f29398g);
                String strA = zzehmVar == null ? "" : zzehmVar.a();
                if (!TextUtils.isEmpty(strA)) {
                    TextView textView = (TextView) viewInflate.findViewById(R.id.offline_dialog_advertiser_name);
                    textView.setVisibility(0);
                    textView.setText(strA);
                }
                zzehm zzehmVar2 = (zzehm) map.get(this.f29398g);
                Drawable drawableC = zzehmVar2 != null ? zzehmVar2.c() : null;
                if (drawableC != null) {
                    ((ImageView) viewInflate.findViewById(R.id.offline_dialog_image)).setImageDrawable(drawableC);
                }
                alertDialogCreate = onCancelListener.create();
                alertDialogCreate.getWindow().setBackgroundDrawable(new ColorDrawable(0));
            } catch (Resources.NotFoundException unused2) {
                onCancelListener.setMessage(ec(R.string.offline_dialog_text, "Thanks for your interest.\nWe will share more once you're back online."));
                alertDialogCreate = onCancelListener.create();
            }
        }
        alertDialogCreate.show();
        Timer timer = new Timer();
        timer.schedule(new zzehx(this, alertDialogCreate, timer, zzmVar), 3000L);
    }

    public final void dc(String str, String str2, Map map) {
        Yb(this.f29394c, this.f29395d, this.f29397f, str, str2, map);
    }

    @Override // com.google.android.gms.internal.ads.zzbwr
    public final void q1(Intent intent) {
        zzehu zzehuVar = this.f29397f;
        String stringExtra = intent.getStringExtra("offline_notification_action");
        if (stringExtra != null) {
            if (stringExtra.equals("offline_notification_clicked") || stringExtra.equals("offline_notification_dismissed")) {
                String stringExtra2 = intent.getStringExtra("gws_query_id");
                String stringExtra3 = intent.getStringExtra("uri");
                zzcda zzcdaVar = com.google.android.gms.ads.internal.zzt.C.f21684h;
                Context context = this.f29394c;
                boolean zI = zzcdaVar.i(context);
                HashMap map = new HashMap();
                if (stringExtra.equals("offline_notification_clicked")) {
                    map.put("offline_notification_action", "offline_notification_clicked");
                    c = true == zI ? (char) 1 : (char) 2;
                    map.put("obvs", String.valueOf(Build.VERSION.SDK_INT));
                    map.put("olaih", String.valueOf(stringExtra3.startsWith("http")));
                    try {
                        Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(stringExtra3);
                        if (launchIntentForPackage == null) {
                            launchIntentForPackage = new Intent("android.intent.action.VIEW");
                            launchIntentForPackage.setData(Uri.parse(stringExtra3));
                        }
                        launchIntentForPackage.addFlags(268435456);
                        context.startActivity(launchIntentForPackage);
                        map.put("olaa", "olas");
                    } catch (ActivityNotFoundException unused) {
                        map.put("olaa", "olaf");
                    }
                } else {
                    map.put("offline_notification_action", "offline_notification_dismissed");
                }
                dc(stringExtra2, "offline_notification_action", map);
                try {
                    SQLiteDatabase writableDatabase = zzehuVar.getWritableDatabase();
                    if (c == 1) {
                        ((zzcdn) zzehuVar.f29367b).execute(new zzeho(writableDatabase, stringExtra2, this.f29396e));
                    } else {
                        writableDatabase.delete("offline_buffered_pings", "gws_query_id = ? AND event_state = ?", new String[]{stringExtra2, Integer.toString(0)});
                    }
                } catch (SQLiteException e2) {
                    String strConcat = "Failed to get writable offline buffering database: ".concat(e2.toString());
                    int i2 = com.google.android.gms.ads.internal.util.zze.f21576b;
                    com.google.android.gms.ads.internal.util.client.zzo.c(strConcat);
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbwr
    public final void q6(String[] strArr, int[] iArr, IObjectWrapper iObjectWrapper) throws IllegalAccessException, Resources.NotFoundException, InstantiationException, IllegalArgumentException, InvocationTargetException {
        for (int i2 = 0; i2 < strArr.length; i2++) {
            if (strArr[i2].equals("android.permission.POST_NOTIFICATIONS")) {
                zzeih zzeihVar = (zzeih) ObjectWrapper.z0(iObjectWrapper);
                Activity activityA = zzeihVar.a();
                com.google.android.gms.ads.internal.overlay.zzm zzmVarB = zzeihVar.b();
                HashMap map = new HashMap();
                if (iArr[i2] == 0) {
                    map.put("dialog_action", "confirm");
                    bc();
                    cc(activityA, zzmVarB);
                } else {
                    map.put("dialog_action", "dismiss");
                    if (zzmVarB != null) {
                        zzmVarB.zzb();
                    }
                }
                dc(this.f29398g, "asnpdc", map);
                return;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbwr
    public final void zzg() {
        final com.google.android.gms.ads.internal.util.client.zzu zzuVar = this.f29396e;
        this.f29397f.a(new zzflu() { // from class: com.google.android.gms.internal.ads.zzehs
            @Override // com.google.android.gms.internal.ads.zzflu
            public final /* synthetic */ Object zza(Object obj) throws Throwable {
                zzehu.c((SQLiteDatabase) obj, zzuVar);
                return null;
            }
        });
    }
}
