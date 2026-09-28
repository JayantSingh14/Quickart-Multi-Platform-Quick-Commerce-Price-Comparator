package com.google.android.gms.internal.measurement;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.HashMap;
import org.xbill.DNS.Type;

/* loaded from: classes.dex */
public abstract class zzcq extends zzbm implements zzcr {
    public zzcq() {
        super("com.google.android.gms.measurement.api.internal.IAppMeasurementDynamiteService");
    }

    public static zzcr asInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.measurement.api.internal.IAppMeasurementDynamiteService");
        return iInterfaceQueryLocalInterface instanceof zzcr ? (zzcr) iInterfaceQueryLocalInterface : new zzcp(iBinder);
    }

    @Override // com.google.android.gms.internal.measurement.zzbm
    public final boolean g(int i2, Parcel parcel, Parcel parcel2) {
        zzcu zzcsVar = null;
        zzcx zzcvVar = null;
        zzcu zzcsVar2 = null;
        zzcu zzcsVar3 = null;
        zzcu zzcsVar4 = null;
        zzcu zzcsVar5 = null;
        zzda zzcyVar = null;
        zzda zzcyVar2 = null;
        zzda zzcyVar3 = null;
        zzcu zzcsVar6 = null;
        zzcu zzcsVar7 = null;
        zzcu zzcsVar8 = null;
        zzcu zzcsVar9 = null;
        zzcu zzcsVar10 = null;
        zzcu zzcsVar11 = null;
        zzdc zzdbVar = null;
        zzcu zzcsVar12 = null;
        zzcu zzcsVar13 = null;
        zzcu zzcsVar14 = null;
        zzcu zzcsVar15 = null;
        zzcu zzcsVar16 = null;
        switch (i2) {
            case 1:
                IObjectWrapper iObjectWrapperG = IObjectWrapper.Stub.g(parcel.readStrongBinder());
                zzdd zzddVar = (zzdd) zzbn.b(parcel, zzdd.CREATOR);
                long j2 = parcel.readLong();
                zzbn.f(parcel);
                initialize(iObjectWrapperG, zzddVar, j2);
                break;
            case 2:
                String string = parcel.readString();
                String string2 = parcel.readString();
                Bundle bundle = (Bundle) zzbn.b(parcel, Bundle.CREATOR);
                boolean zA = zzbn.a(parcel);
                boolean zA2 = zzbn.a(parcel);
                long j3 = parcel.readLong();
                zzbn.f(parcel);
                logEvent(string, string2, bundle, zA, zA2, j3);
                break;
            case 3:
                String string3 = parcel.readString();
                String string4 = parcel.readString();
                Bundle bundle2 = (Bundle) zzbn.b(parcel, Bundle.CREATOR);
                IBinder strongBinder = parcel.readStrongBinder();
                if (strongBinder != null) {
                    IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    zzcsVar = iInterfaceQueryLocalInterface instanceof zzcu ? (zzcu) iInterfaceQueryLocalInterface : new zzcs(strongBinder);
                }
                long j4 = parcel.readLong();
                zzbn.f(parcel);
                logEventAndBundle(string3, string4, bundle2, zzcsVar, j4);
                break;
            case 4:
                String string5 = parcel.readString();
                String string6 = parcel.readString();
                IObjectWrapper iObjectWrapperG2 = IObjectWrapper.Stub.g(parcel.readStrongBinder());
                boolean zA3 = zzbn.a(parcel);
                long j5 = parcel.readLong();
                zzbn.f(parcel);
                setUserProperty(string5, string6, iObjectWrapperG2, zA3, j5);
                break;
            case 5:
                String string7 = parcel.readString();
                String string8 = parcel.readString();
                boolean zA4 = zzbn.a(parcel);
                IBinder strongBinder2 = parcel.readStrongBinder();
                if (strongBinder2 != null) {
                    IInterface iInterfaceQueryLocalInterface2 = strongBinder2.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    zzcsVar16 = iInterfaceQueryLocalInterface2 instanceof zzcu ? (zzcu) iInterfaceQueryLocalInterface2 : new zzcs(strongBinder2);
                }
                zzbn.f(parcel);
                getUserProperties(string7, string8, zA4, zzcsVar16);
                break;
            case 6:
                String string9 = parcel.readString();
                IBinder strongBinder3 = parcel.readStrongBinder();
                if (strongBinder3 != null) {
                    IInterface iInterfaceQueryLocalInterface3 = strongBinder3.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    zzcsVar15 = iInterfaceQueryLocalInterface3 instanceof zzcu ? (zzcu) iInterfaceQueryLocalInterface3 : new zzcs(strongBinder3);
                }
                zzbn.f(parcel);
                getMaxUserProperties(string9, zzcsVar15);
                break;
            case 7:
                String string10 = parcel.readString();
                long j6 = parcel.readLong();
                zzbn.f(parcel);
                setUserId(string10, j6);
                break;
            case 8:
                Bundle bundle3 = (Bundle) zzbn.b(parcel, Bundle.CREATOR);
                long j7 = parcel.readLong();
                zzbn.f(parcel);
                setConditionalUserProperty(bundle3, j7);
                break;
            case 9:
                String string11 = parcel.readString();
                String string12 = parcel.readString();
                Bundle bundle4 = (Bundle) zzbn.b(parcel, Bundle.CREATOR);
                zzbn.f(parcel);
                clearConditionalUserProperty(string11, string12, bundle4);
                break;
            case 10:
                String string13 = parcel.readString();
                String string14 = parcel.readString();
                IBinder strongBinder4 = parcel.readStrongBinder();
                if (strongBinder4 != null) {
                    IInterface iInterfaceQueryLocalInterface4 = strongBinder4.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    zzcsVar14 = iInterfaceQueryLocalInterface4 instanceof zzcu ? (zzcu) iInterfaceQueryLocalInterface4 : new zzcs(strongBinder4);
                }
                zzbn.f(parcel);
                getConditionalUserProperties(string13, string14, zzcsVar14);
                break;
            case 11:
                boolean zA5 = zzbn.a(parcel);
                long j8 = parcel.readLong();
                zzbn.f(parcel);
                setMeasurementEnabled(zA5, j8);
                break;
            case 12:
                long j9 = parcel.readLong();
                zzbn.f(parcel);
                resetAnalyticsData(j9);
                break;
            case 13:
                long j10 = parcel.readLong();
                zzbn.f(parcel);
                setMinimumSessionDuration(j10);
                break;
            case 14:
                long j11 = parcel.readLong();
                zzbn.f(parcel);
                setSessionTimeoutDuration(j11);
                break;
            case 15:
                IObjectWrapper iObjectWrapperG3 = IObjectWrapper.Stub.g(parcel.readStrongBinder());
                String string15 = parcel.readString();
                String string16 = parcel.readString();
                long j12 = parcel.readLong();
                zzbn.f(parcel);
                setCurrentScreen(iObjectWrapperG3, string15, string16, j12);
                break;
            case 16:
                IBinder strongBinder5 = parcel.readStrongBinder();
                if (strongBinder5 != null) {
                    IInterface iInterfaceQueryLocalInterface5 = strongBinder5.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    zzcsVar13 = iInterfaceQueryLocalInterface5 instanceof zzcu ? (zzcu) iInterfaceQueryLocalInterface5 : new zzcs(strongBinder5);
                }
                zzbn.f(parcel);
                getCurrentScreenName(zzcsVar13);
                break;
            case 17:
                IBinder strongBinder6 = parcel.readStrongBinder();
                if (strongBinder6 != null) {
                    IInterface iInterfaceQueryLocalInterface6 = strongBinder6.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    zzcsVar12 = iInterfaceQueryLocalInterface6 instanceof zzcu ? (zzcu) iInterfaceQueryLocalInterface6 : new zzcs(strongBinder6);
                }
                zzbn.f(parcel);
                getCurrentScreenClass(zzcsVar12);
                break;
            case 18:
                IBinder strongBinder7 = parcel.readStrongBinder();
                if (strongBinder7 != null) {
                    IInterface iInterfaceQueryLocalInterface7 = strongBinder7.queryLocalInterface("com.google.android.gms.measurement.api.internal.IStringProvider");
                    zzdbVar = iInterfaceQueryLocalInterface7 instanceof zzdc ? (zzdc) iInterfaceQueryLocalInterface7 : new zzdb(strongBinder7);
                }
                zzbn.f(parcel);
                setInstanceIdProvider(zzdbVar);
                break;
            case 19:
                IBinder strongBinder8 = parcel.readStrongBinder();
                if (strongBinder8 != null) {
                    IInterface iInterfaceQueryLocalInterface8 = strongBinder8.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    zzcsVar11 = iInterfaceQueryLocalInterface8 instanceof zzcu ? (zzcu) iInterfaceQueryLocalInterface8 : new zzcs(strongBinder8);
                }
                zzbn.f(parcel);
                getCachedAppInstanceId(zzcsVar11);
                break;
            case 20:
                IBinder strongBinder9 = parcel.readStrongBinder();
                if (strongBinder9 != null) {
                    IInterface iInterfaceQueryLocalInterface9 = strongBinder9.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    zzcsVar10 = iInterfaceQueryLocalInterface9 instanceof zzcu ? (zzcu) iInterfaceQueryLocalInterface9 : new zzcs(strongBinder9);
                }
                zzbn.f(parcel);
                getAppInstanceId(zzcsVar10);
                break;
            case 21:
                IBinder strongBinder10 = parcel.readStrongBinder();
                if (strongBinder10 != null) {
                    IInterface iInterfaceQueryLocalInterface10 = strongBinder10.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    zzcsVar9 = iInterfaceQueryLocalInterface10 instanceof zzcu ? (zzcu) iInterfaceQueryLocalInterface10 : new zzcs(strongBinder10);
                }
                zzbn.f(parcel);
                getGmpAppId(zzcsVar9);
                break;
            case 22:
                IBinder strongBinder11 = parcel.readStrongBinder();
                if (strongBinder11 != null) {
                    IInterface iInterfaceQueryLocalInterface11 = strongBinder11.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    zzcsVar8 = iInterfaceQueryLocalInterface11 instanceof zzcu ? (zzcu) iInterfaceQueryLocalInterface11 : new zzcs(strongBinder11);
                }
                zzbn.f(parcel);
                generateEventId(zzcsVar8);
                break;
            case 23:
                String string17 = parcel.readString();
                long j13 = parcel.readLong();
                zzbn.f(parcel);
                beginAdUnitExposure(string17, j13);
                break;
            case 24:
                String string18 = parcel.readString();
                long j14 = parcel.readLong();
                zzbn.f(parcel);
                endAdUnitExposure(string18, j14);
                break;
            case 25:
                IObjectWrapper iObjectWrapperG4 = IObjectWrapper.Stub.g(parcel.readStrongBinder());
                long j15 = parcel.readLong();
                zzbn.f(parcel);
                onActivityStarted(iObjectWrapperG4, j15);
                break;
            case 26:
                IObjectWrapper iObjectWrapperG5 = IObjectWrapper.Stub.g(parcel.readStrongBinder());
                long j16 = parcel.readLong();
                zzbn.f(parcel);
                onActivityStopped(iObjectWrapperG5, j16);
                break;
            case 27:
                IObjectWrapper iObjectWrapperG6 = IObjectWrapper.Stub.g(parcel.readStrongBinder());
                Bundle bundle5 = (Bundle) zzbn.b(parcel, Bundle.CREATOR);
                long j17 = parcel.readLong();
                zzbn.f(parcel);
                onActivityCreated(iObjectWrapperG6, bundle5, j17);
                break;
            case 28:
                IObjectWrapper iObjectWrapperG7 = IObjectWrapper.Stub.g(parcel.readStrongBinder());
                long j18 = parcel.readLong();
                zzbn.f(parcel);
                onActivityDestroyed(iObjectWrapperG7, j18);
                break;
            case 29:
                IObjectWrapper iObjectWrapperG8 = IObjectWrapper.Stub.g(parcel.readStrongBinder());
                long j19 = parcel.readLong();
                zzbn.f(parcel);
                onActivityPaused(iObjectWrapperG8, j19);
                break;
            case 30:
                IObjectWrapper iObjectWrapperG9 = IObjectWrapper.Stub.g(parcel.readStrongBinder());
                long j20 = parcel.readLong();
                zzbn.f(parcel);
                onActivityResumed(iObjectWrapperG9, j20);
                break;
            case 31:
                IObjectWrapper iObjectWrapperG10 = IObjectWrapper.Stub.g(parcel.readStrongBinder());
                IBinder strongBinder12 = parcel.readStrongBinder();
                if (strongBinder12 != null) {
                    IInterface iInterfaceQueryLocalInterface12 = strongBinder12.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    zzcsVar7 = iInterfaceQueryLocalInterface12 instanceof zzcu ? (zzcu) iInterfaceQueryLocalInterface12 : new zzcs(strongBinder12);
                }
                long j21 = parcel.readLong();
                zzbn.f(parcel);
                onActivitySaveInstanceState(iObjectWrapperG10, zzcsVar7, j21);
                break;
            case 32:
                Bundle bundle6 = (Bundle) zzbn.b(parcel, Bundle.CREATOR);
                IBinder strongBinder13 = parcel.readStrongBinder();
                if (strongBinder13 != null) {
                    IInterface iInterfaceQueryLocalInterface13 = strongBinder13.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    zzcsVar6 = iInterfaceQueryLocalInterface13 instanceof zzcu ? (zzcu) iInterfaceQueryLocalInterface13 : new zzcs(strongBinder13);
                }
                long j22 = parcel.readLong();
                zzbn.f(parcel);
                performAction(bundle6, zzcsVar6, j22);
                break;
            case 33:
                int i3 = parcel.readInt();
                String string19 = parcel.readString();
                IObjectWrapper iObjectWrapperG11 = IObjectWrapper.Stub.g(parcel.readStrongBinder());
                IObjectWrapper iObjectWrapperG12 = IObjectWrapper.Stub.g(parcel.readStrongBinder());
                IObjectWrapper iObjectWrapperG13 = IObjectWrapper.Stub.g(parcel.readStrongBinder());
                zzbn.f(parcel);
                logHealthData(i3, string19, iObjectWrapperG11, iObjectWrapperG12, iObjectWrapperG13);
                break;
            case 34:
                IBinder strongBinder14 = parcel.readStrongBinder();
                if (strongBinder14 != null) {
                    IInterface iInterfaceQueryLocalInterface14 = strongBinder14.queryLocalInterface("com.google.android.gms.measurement.api.internal.IEventHandlerProxy");
                    zzcyVar3 = iInterfaceQueryLocalInterface14 instanceof zzda ? (zzda) iInterfaceQueryLocalInterface14 : new zzcy(strongBinder14);
                }
                zzbn.f(parcel);
                setEventInterceptor(zzcyVar3);
                break;
            case 35:
                IBinder strongBinder15 = parcel.readStrongBinder();
                if (strongBinder15 != null) {
                    IInterface iInterfaceQueryLocalInterface15 = strongBinder15.queryLocalInterface("com.google.android.gms.measurement.api.internal.IEventHandlerProxy");
                    zzcyVar2 = iInterfaceQueryLocalInterface15 instanceof zzda ? (zzda) iInterfaceQueryLocalInterface15 : new zzcy(strongBinder15);
                }
                zzbn.f(parcel);
                registerOnMeasurementEventListener(zzcyVar2);
                break;
            case 36:
                IBinder strongBinder16 = parcel.readStrongBinder();
                if (strongBinder16 != null) {
                    IInterface iInterfaceQueryLocalInterface16 = strongBinder16.queryLocalInterface("com.google.android.gms.measurement.api.internal.IEventHandlerProxy");
                    zzcyVar = iInterfaceQueryLocalInterface16 instanceof zzda ? (zzda) iInterfaceQueryLocalInterface16 : new zzcy(strongBinder16);
                }
                zzbn.f(parcel);
                unregisterOnMeasurementEventListener(zzcyVar);
                break;
            case 37:
                HashMap mapE = zzbn.e(parcel);
                zzbn.f(parcel);
                initForTests(mapE);
                break;
            case Type.A6 /* 38 */:
                IBinder strongBinder17 = parcel.readStrongBinder();
                if (strongBinder17 != null) {
                    IInterface iInterfaceQueryLocalInterface17 = strongBinder17.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    zzcsVar5 = iInterfaceQueryLocalInterface17 instanceof zzcu ? (zzcu) iInterfaceQueryLocalInterface17 : new zzcs(strongBinder17);
                }
                int i4 = parcel.readInt();
                zzbn.f(parcel);
                getTestFlag(zzcsVar5, i4);
                break;
            case 39:
                boolean zA6 = zzbn.a(parcel);
                zzbn.f(parcel);
                setDataCollectionEnabled(zA6);
                break;
            case 40:
                IBinder strongBinder18 = parcel.readStrongBinder();
                if (strongBinder18 != null) {
                    IInterface iInterfaceQueryLocalInterface18 = strongBinder18.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    zzcsVar4 = iInterfaceQueryLocalInterface18 instanceof zzcu ? (zzcu) iInterfaceQueryLocalInterface18 : new zzcs(strongBinder18);
                }
                zzbn.f(parcel);
                isDataCollectionEnabled(zzcsVar4);
                break;
            case 41:
            case 47:
            case 49:
            default:
                return false;
            case 42:
                Bundle bundle7 = (Bundle) zzbn.b(parcel, Bundle.CREATOR);
                zzbn.f(parcel);
                setDefaultEventParameters(bundle7);
                break;
            case 43:
                long j23 = parcel.readLong();
                zzbn.f(parcel);
                clearMeasurementEnabled(j23);
                break;
            case 44:
                Bundle bundle8 = (Bundle) zzbn.b(parcel, Bundle.CREATOR);
                long j24 = parcel.readLong();
                zzbn.f(parcel);
                setConsent(bundle8, j24);
                break;
            case 45:
                Bundle bundle9 = (Bundle) zzbn.b(parcel, Bundle.CREATOR);
                long j25 = parcel.readLong();
                zzbn.f(parcel);
                setConsentThirdParty(bundle9, j25);
                break;
            case 46:
                IBinder strongBinder19 = parcel.readStrongBinder();
                if (strongBinder19 != null) {
                    IInterface iInterfaceQueryLocalInterface19 = strongBinder19.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    zzcsVar3 = iInterfaceQueryLocalInterface19 instanceof zzcu ? (zzcu) iInterfaceQueryLocalInterface19 : new zzcs(strongBinder19);
                }
                zzbn.f(parcel);
                getSessionId(zzcsVar3);
                break;
            case Type.DNSKEY /* 48 */:
                Intent intent = (Intent) zzbn.b(parcel, Intent.CREATOR);
                zzbn.f(parcel);
                setSgtmDebugInfo(intent);
                break;
            case 50:
                zzdf zzdfVar = (zzdf) zzbn.b(parcel, zzdf.CREATOR);
                String string20 = parcel.readString();
                String string21 = parcel.readString();
                long j26 = parcel.readLong();
                zzbn.f(parcel);
                setCurrentScreenByScionActivityInfo(zzdfVar, string20, string21, j26);
                break;
            case 51:
                zzdf zzdfVar2 = (zzdf) zzbn.b(parcel, zzdf.CREATOR);
                long j27 = parcel.readLong();
                zzbn.f(parcel);
                onActivityStartedByScionActivityInfo(zzdfVar2, j27);
                break;
            case Type.TLSA /* 52 */:
                zzdf zzdfVar3 = (zzdf) zzbn.b(parcel, zzdf.CREATOR);
                long j28 = parcel.readLong();
                zzbn.f(parcel);
                onActivityStoppedByScionActivityInfo(zzdfVar3, j28);
                break;
            case 53:
                zzdf zzdfVar4 = (zzdf) zzbn.b(parcel, zzdf.CREATOR);
                Bundle bundle10 = (Bundle) zzbn.b(parcel, Bundle.CREATOR);
                long j29 = parcel.readLong();
                zzbn.f(parcel);
                onActivityCreatedByScionActivityInfo(zzdfVar4, bundle10, j29);
                break;
            case 54:
                zzdf zzdfVar5 = (zzdf) zzbn.b(parcel, zzdf.CREATOR);
                long j30 = parcel.readLong();
                zzbn.f(parcel);
                onActivityDestroyedByScionActivityInfo(zzdfVar5, j30);
                break;
            case 55:
                zzdf zzdfVar6 = (zzdf) zzbn.b(parcel, zzdf.CREATOR);
                long j31 = parcel.readLong();
                zzbn.f(parcel);
                onActivityPausedByScionActivityInfo(zzdfVar6, j31);
                break;
            case Type.NINFO /* 56 */:
                zzdf zzdfVar7 = (zzdf) zzbn.b(parcel, zzdf.CREATOR);
                long j32 = parcel.readLong();
                zzbn.f(parcel);
                onActivityResumedByScionActivityInfo(zzdfVar7, j32);
                break;
            case Type.RKEY /* 57 */:
                zzdf zzdfVar8 = (zzdf) zzbn.b(parcel, zzdf.CREATOR);
                IBinder strongBinder20 = parcel.readStrongBinder();
                if (strongBinder20 != null) {
                    IInterface iInterfaceQueryLocalInterface20 = strongBinder20.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    zzcsVar2 = iInterfaceQueryLocalInterface20 instanceof zzcu ? (zzcu) iInterfaceQueryLocalInterface20 : new zzcs(strongBinder20);
                }
                long j33 = parcel.readLong();
                zzbn.f(parcel);
                onActivitySaveInstanceStateByScionActivityInfo(zzdfVar8, zzcsVar2, j33);
                break;
            case Type.TALINK /* 58 */:
                IBinder strongBinder21 = parcel.readStrongBinder();
                if (strongBinder21 != null) {
                    IInterface iInterfaceQueryLocalInterface21 = strongBinder21.queryLocalInterface("com.google.android.gms.measurement.api.internal.IDynamiteUploadBatchesCallback");
                    zzcvVar = iInterfaceQueryLocalInterface21 instanceof zzcx ? (zzcx) iInterfaceQueryLocalInterface21 : new zzcv(strongBinder21);
                }
                zzbn.f(parcel);
                retrieveAndUploadBatches(zzcvVar);
                break;
        }
        parcel2.writeNoException();
        return true;
    }
}
