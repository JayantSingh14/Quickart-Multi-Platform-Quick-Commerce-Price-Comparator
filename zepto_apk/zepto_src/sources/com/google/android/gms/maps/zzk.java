package com.google.android.gms.maps;

import android.os.RemoteException;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.ThemedReactContext;
import com.google.android.gms.maps.model.IndoorBuilding;
import com.google.android.gms.maps.model.IndoorLevel;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import com.rnmaps.maps.MapManager;
import java.util.ArrayList;
import java.util.Iterator;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

/* loaded from: classes4.dex */
final class zzk extends com.google.android.gms.maps.internal.zzaa {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.rnmaps.maps.MapView f38634a;

    public zzk(com.rnmaps.maps.MapView mapView) {
        this.f38634a = mapView;
    }

    @Override // com.google.android.gms.maps.internal.zzab
    public final void R5(com.google.android.gms.internal.maps.zzu zzuVar) {
        IndoorBuilding indoorBuilding = new IndoorBuilding(zzuVar);
        com.rnmaps.maps.MapView mapView = this.f38634a;
        int iA = indoorBuilding.a();
        if (iA < 0 || iA >= indoorBuilding.b().size()) {
            return;
        }
        IndoorLevel indoorLevel = (IndoorLevel) indoorBuilding.b().get(iA);
        WritableMap writableMapCreateMap = Arguments.createMap();
        WritableMap writableMapCreateMap2 = Arguments.createMap();
        writableMapCreateMap2.putInt("activeLevelIndex", iA);
        writableMapCreateMap2.putString(CLConstants.FIELD_PAY_INFO_NAME, indoorLevel.b());
        writableMapCreateMap2.putString("shortName", indoorLevel.c());
        writableMapCreateMap.putMap("IndoorLevel", writableMapCreateMap2);
        mapView.D0.pushEvent(mapView.H0, mapView, "onIndoorLevelActivated", writableMapCreateMap);
    }

    @Override // com.google.android.gms.maps.internal.zzab
    public final void zzb() {
        com.rnmaps.maps.MapView mapView = this.f38634a;
        IndoorBuilding indoorBuildingE = mapView.f46620b.e();
        ThemedReactContext themedReactContext = mapView.H0;
        MapManager mapManager = mapView.D0;
        int i2 = 0;
        if (indoorBuildingE == null) {
            WritableMap writableMapCreateMap = Arguments.createMap();
            WritableArray writableArrayCreateArray = Arguments.createArray();
            WritableMap writableMapCreateMap2 = Arguments.createMap();
            writableMapCreateMap2.putArray("levels", writableArrayCreateArray);
            writableMapCreateMap2.putInt("activeLevelIndex", 0);
            writableMapCreateMap2.putBoolean("underground", false);
            writableMapCreateMap.putMap("IndoorBuilding", writableMapCreateMap2);
            mapManager.pushEvent(themedReactContext, mapView, "onIndoorBuildingFocused", writableMapCreateMap);
            return;
        }
        ArrayList arrayListB = indoorBuildingE.b();
        WritableArray writableArrayCreateArray2 = Arguments.createArray();
        Iterator it = arrayListB.iterator();
        while (it.hasNext()) {
            IndoorLevel indoorLevel = (IndoorLevel) it.next();
            WritableMap writableMapCreateMap3 = Arguments.createMap();
            writableMapCreateMap3.putInt("index", i2);
            writableMapCreateMap3.putString(CLConstants.FIELD_PAY_INFO_NAME, indoorLevel.b());
            writableMapCreateMap3.putString("shortName", indoorLevel.c());
            writableArrayCreateArray2.pushMap(writableMapCreateMap3);
            i2++;
        }
        WritableMap writableMapCreateMap4 = Arguments.createMap();
        WritableMap writableMapCreateMap5 = Arguments.createMap();
        writableMapCreateMap5.putArray("levels", writableArrayCreateArray2);
        writableMapCreateMap5.putInt("activeLevelIndex", indoorBuildingE.a());
        indoorBuildingE.getClass();
        try {
            writableMapCreateMap5.putBoolean("underground", indoorBuildingE.f38473a.zzi());
            writableMapCreateMap4.putMap("IndoorBuilding", writableMapCreateMap5);
            mapManager.pushEvent(themedReactContext, mapView, "onIndoorBuildingFocused", writableMapCreateMap4);
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }
}
