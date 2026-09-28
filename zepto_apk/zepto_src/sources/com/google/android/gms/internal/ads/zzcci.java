package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Point;
import android.net.Uri;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.text.TextUtils;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.View;
import androidx.browser.customtabs.CustomTabsCallback;
import androidx.browser.customtabs.CustomTabsClient;
import androidx.browser.customtabs.CustomTabsSession;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.ArrayList;
import org.json.JSONException;

/* loaded from: classes4.dex */
public abstract class zzcci extends zzbcc implements zzccj {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f25883a = 0;

    public zzcci() {
        super("com.google.android.gms.ads.internal.signals.ISignalGenerator");
    }

    @Override // com.google.android.gms.internal.ads.zzbcc
    public final boolean Wb(int i2, Parcel parcel, Parcel parcel2) throws JSONException {
        ObjectWrapper objectWrapper;
        zzccg zzcceVar = null;
        switch (i2) {
            case 1:
                IObjectWrapper iObjectWrapperG = IObjectWrapper.Stub.g(parcel.readStrongBinder());
                zzccn zzccnVar = (zzccn) zzbcd.b(parcel, zzccn.CREATOR);
                IBinder strongBinder = parcel.readStrongBinder();
                if (strongBinder != null) {
                    IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.signals.ISignalCallback");
                    zzcceVar = iInterfaceQueryLocalInterface instanceof zzccg ? (zzccg) iInterfaceQueryLocalInterface : new zzcce(strongBinder, "com.google.android.gms.ads.internal.signals.ISignalCallback");
                }
                zzbcd.f(parcel);
                ((com.google.android.gms.ads.nonagon.signalgeneration.zzau) this).c6(iObjectWrapperG, zzccnVar, zzcceVar);
                parcel2.writeNoException();
                return true;
            case 2:
                IObjectWrapper iObjectWrapperG2 = android.support.v4.media.a.g(parcel, parcel);
                com.google.android.gms.ads.nonagon.signalgeneration.zzau zzauVar = (com.google.android.gms.ads.nonagon.signalgeneration.zzau) this;
                if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.r8)).booleanValue()) {
                    MotionEvent motionEvent = (MotionEvent) ObjectWrapper.z0(iObjectWrapperG2);
                    zzbxq zzbxqVar = zzauVar.f21802i;
                    View view = zzbxqVar != null ? zzbxqVar.f25669a : null;
                    int[] iArr = new int[2];
                    if (view != null) {
                        view.getLocationOnScreen(iArr);
                    }
                    zzauVar.f21803j = new Point(((int) motionEvent.getRawX()) - iArr[0], ((int) motionEvent.getRawY()) - iArr[1]);
                    if (motionEvent.getAction() == 0) {
                        zzauVar.f21804k = zzauVar.f21803j;
                    }
                    MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
                    Point point = zzauVar.f21803j;
                    motionEventObtain.setLocation(point.x, point.y);
                    zzauVar.f21797d.f24512b.f(motionEventObtain);
                    motionEventObtain.recycle();
                }
                parcel2.writeNoException();
                return true;
            case 3:
                IObjectWrapper.Stub.g(parcel.readStrongBinder());
                IObjectWrapper.Stub.g(parcel.readStrongBinder());
                zzbcd.f(parcel);
                parcel2.writeNoException();
                parcel2.writeStrongBinder(null);
                return true;
            case 4:
                IObjectWrapper.Stub.g(parcel.readStrongBinder());
                zzbcd.f(parcel);
                parcel2.writeNoException();
                parcel2.writeStrongBinder(null);
                return true;
            case 5:
                ArrayList arrayListCreateTypedArrayList = parcel.createTypedArrayList(Uri.CREATOR);
                IObjectWrapper iObjectWrapperG3 = IObjectWrapper.Stub.g(parcel.readStrongBinder());
                zzbxn zzbxnVarXb = zzbxm.Xb(parcel.readStrongBinder());
                zzbcd.f(parcel);
                ((com.google.android.gms.ads.nonagon.signalgeneration.zzau) this).Xb(arrayListCreateTypedArrayList, iObjectWrapperG3, zzbxnVarXb, false);
                parcel2.writeNoException();
                return true;
            case 6:
                ArrayList arrayListCreateTypedArrayList2 = parcel.createTypedArrayList(Uri.CREATOR);
                IObjectWrapper iObjectWrapperG4 = IObjectWrapper.Stub.g(parcel.readStrongBinder());
                zzbxn zzbxnVarXb2 = zzbxm.Xb(parcel.readStrongBinder());
                zzbcd.f(parcel);
                ((com.google.android.gms.ads.nonagon.signalgeneration.zzau) this).Yb(arrayListCreateTypedArrayList2, iObjectWrapperG4, zzbxnVarXb2, false);
                parcel2.writeNoException();
                return true;
            case 7:
                zzbxq zzbxqVar2 = (zzbxq) zzbcd.b(parcel, zzbxq.CREATOR);
                zzbcd.f(parcel);
                com.google.android.gms.ads.nonagon.signalgeneration.zzau zzauVar2 = (com.google.android.gms.ads.nonagon.signalgeneration.zzau) this;
                zzauVar2.f21802i = zzbxqVar2;
                zzauVar2.f21799f.a(1);
                parcel2.writeNoException();
                return true;
            case 8:
                ((com.google.android.gms.ads.nonagon.signalgeneration.zzau) this).ua(android.support.v4.media.a.g(parcel, parcel));
                parcel2.writeNoException();
                return true;
            case 9:
                ArrayList arrayListCreateTypedArrayList3 = parcel.createTypedArrayList(Uri.CREATOR);
                IObjectWrapper iObjectWrapperG5 = IObjectWrapper.Stub.g(parcel.readStrongBinder());
                zzbxn zzbxnVarXb3 = zzbxm.Xb(parcel.readStrongBinder());
                zzbcd.f(parcel);
                ((com.google.android.gms.ads.nonagon.signalgeneration.zzau) this).Xb(arrayListCreateTypedArrayList3, iObjectWrapperG5, zzbxnVarXb3, true);
                parcel2.writeNoException();
                return true;
            case 10:
                ArrayList arrayListCreateTypedArrayList4 = parcel.createTypedArrayList(Uri.CREATOR);
                IObjectWrapper iObjectWrapperG6 = IObjectWrapper.Stub.g(parcel.readStrongBinder());
                zzbxn zzbxnVarXb4 = zzbxm.Xb(parcel.readStrongBinder());
                zzbcd.f(parcel);
                ((com.google.android.gms.ads.nonagon.signalgeneration.zzau) this).Yb(arrayListCreateTypedArrayList4, iObjectWrapperG6, zzbxnVarXb4, true);
                parcel2.writeNoException();
                return true;
            case 11:
                IObjectWrapper iObjectWrapperG7 = IObjectWrapper.Stub.g(parcel.readStrongBinder());
                IObjectWrapper iObjectWrapperG8 = IObjectWrapper.Stub.g(parcel.readStrongBinder());
                String string = parcel.readString();
                IObjectWrapper iObjectWrapperG9 = android.support.v4.media.a.g(parcel, parcel);
                com.google.android.gms.ads.nonagon.signalgeneration.zzau zzauVar3 = (com.google.android.gms.ads.nonagon.signalgeneration.zzau) this;
                if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.Wa)).booleanValue()) {
                    Context context = (Context) ObjectWrapper.z0(iObjectWrapperG7);
                    CustomTabsClient customTabsClient = (CustomTabsClient) ObjectWrapper.z0(iObjectWrapperG8);
                    CustomTabsCallback customTabsCallback = (CustomTabsCallback) ObjectWrapper.z0(iObjectWrapperG9);
                    zzbhp zzbhpVar = zzauVar3.E;
                    zzbhpVar.getClass();
                    if (context == null) {
                        throw new IllegalArgumentException("App Context parameter is null");
                    }
                    if (TextUtils.isEmpty(string)) {
                        throw new IllegalArgumentException("Origin parameter is empty or null");
                    }
                    if (customTabsClient == null) {
                        throw new IllegalArgumentException("CustomTabsClient parameter is null");
                    }
                    zzbhpVar.f25086l = context;
                    zzbhpVar.f25082h = string;
                    zzdxj zzdxjVar = zzbhpVar.f25078d;
                    zzbhm zzbhmVar = new zzbhm(zzbhpVar, customTabsCallback, zzdxjVar);
                    zzbhpVar.f25080f = zzbhmVar;
                    CustomTabsSession customTabsSessionB = customTabsClient.b(zzbhmVar);
                    zzbhpVar.f25081g = customTabsSessionB;
                    if (customTabsSessionB == null) {
                        int i3 = com.google.android.gms.ads.internal.util.zze.f21576b;
                        com.google.android.gms.ads.internal.util.client.zzo.c("CustomTabsClient failed to create new session.");
                    }
                    com.google.android.gms.ads.nonagon.signalgeneration.zzaa.d(zzdxjVar, "pact_action", new Pair("pe", "pact_init"));
                    if (((Boolean) zzbip.f25199e.c()).booleanValue()) {
                        com.google.android.gms.ads.nonagon.signalgeneration.zzo zzoVar = zzauVar3.F;
                        synchronized (zzoVar) {
                            zzoVar.c(true);
                            zzoVar.c(false);
                        }
                    }
                    if (((Boolean) zzbip.f25197c.c()).booleanValue()) {
                        zzauVar3.G.a(null);
                    }
                    objectWrapper = new ObjectWrapper(zzbhpVar.f25081g);
                } else {
                    objectWrapper = new ObjectWrapper(null);
                }
                parcel2.writeNoException();
                zzbcd.e(parcel2, objectWrapper);
                return true;
            default:
                return false;
        }
    }
}
