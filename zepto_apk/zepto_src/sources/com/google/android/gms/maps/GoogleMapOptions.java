package com.google.android.gms.maps;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;

@SafeParcelable.Class(creator = "GoogleMapOptionsCreator")
@SafeParcelable.Reserved({1})
/* loaded from: classes4.dex */
public final class GoogleMapOptions extends AbstractSafeParcelable implements ReflectedParcelable {

    @NonNull
    public static final Parcelable.Creator<GoogleMapOptions> CREATOR = new zzac();
    public static final Integer t = Integer.valueOf(Color.argb(255, 236, 233, 225));

    /* renamed from: a, reason: collision with root package name */
    public Boolean f38397a;

    /* renamed from: b, reason: collision with root package name */
    public Boolean f38398b;

    /* renamed from: d, reason: collision with root package name */
    public CameraPosition f38400d;

    /* renamed from: e, reason: collision with root package name */
    public Boolean f38401e;

    /* renamed from: f, reason: collision with root package name */
    public Boolean f38402f;

    /* renamed from: g, reason: collision with root package name */
    public Boolean f38403g;

    /* renamed from: h, reason: collision with root package name */
    public Boolean f38404h;

    /* renamed from: i, reason: collision with root package name */
    public Boolean f38405i;

    /* renamed from: j, reason: collision with root package name */
    public Boolean f38406j;

    /* renamed from: k, reason: collision with root package name */
    public Boolean f38407k;

    /* renamed from: l, reason: collision with root package name */
    public Boolean f38408l;

    /* renamed from: m, reason: collision with root package name */
    public Boolean f38409m;
    public Boolean q;

    /* renamed from: c, reason: collision with root package name */
    public int f38399c = -1;
    public Float n = null;
    public Float o = null;
    public LatLngBounds p = null;
    public Integer r = null;
    public String s = null;

    public static GoogleMapOptions r(Context context, AttributeSet attributeSet) {
        String string;
        LatLngBounds latLngBounds = null;
        if (context == null || attributeSet == null) {
            return null;
        }
        TypedArray typedArrayObtainAttributes = context.getResources().obtainAttributes(attributeSet, R.styleable.MapAttrs);
        GoogleMapOptions googleMapOptions = new GoogleMapOptions();
        if (typedArrayObtainAttributes.hasValue(R.styleable.MapAttrs_mapType)) {
            googleMapOptions.f38399c = typedArrayObtainAttributes.getInt(R.styleable.MapAttrs_mapType, -1);
        }
        if (typedArrayObtainAttributes.hasValue(R.styleable.MapAttrs_zOrderOnTop)) {
            googleMapOptions.f38397a = Boolean.valueOf(typedArrayObtainAttributes.getBoolean(R.styleable.MapAttrs_zOrderOnTop, false));
        }
        if (typedArrayObtainAttributes.hasValue(R.styleable.MapAttrs_useViewLifecycle)) {
            googleMapOptions.f38398b = Boolean.valueOf(typedArrayObtainAttributes.getBoolean(R.styleable.MapAttrs_useViewLifecycle, false));
        }
        if (typedArrayObtainAttributes.hasValue(R.styleable.MapAttrs_uiCompass)) {
            googleMapOptions.f38402f = Boolean.valueOf(typedArrayObtainAttributes.getBoolean(R.styleable.MapAttrs_uiCompass, true));
        }
        if (typedArrayObtainAttributes.hasValue(R.styleable.MapAttrs_uiRotateGestures)) {
            googleMapOptions.f38406j = Boolean.valueOf(typedArrayObtainAttributes.getBoolean(R.styleable.MapAttrs_uiRotateGestures, true));
        }
        if (typedArrayObtainAttributes.hasValue(R.styleable.MapAttrs_uiScrollGesturesDuringRotateOrZoom)) {
            googleMapOptions.q = Boolean.valueOf(typedArrayObtainAttributes.getBoolean(R.styleable.MapAttrs_uiScrollGesturesDuringRotateOrZoom, true));
        }
        if (typedArrayObtainAttributes.hasValue(R.styleable.MapAttrs_uiScrollGestures)) {
            googleMapOptions.f38403g = Boolean.valueOf(typedArrayObtainAttributes.getBoolean(R.styleable.MapAttrs_uiScrollGestures, true));
        }
        if (typedArrayObtainAttributes.hasValue(R.styleable.MapAttrs_uiTiltGestures)) {
            googleMapOptions.f38405i = Boolean.valueOf(typedArrayObtainAttributes.getBoolean(R.styleable.MapAttrs_uiTiltGestures, true));
        }
        if (typedArrayObtainAttributes.hasValue(R.styleable.MapAttrs_uiZoomGestures)) {
            googleMapOptions.f38404h = Boolean.valueOf(typedArrayObtainAttributes.getBoolean(R.styleable.MapAttrs_uiZoomGestures, true));
        }
        if (typedArrayObtainAttributes.hasValue(R.styleable.MapAttrs_uiZoomControls)) {
            googleMapOptions.f38401e = Boolean.valueOf(typedArrayObtainAttributes.getBoolean(R.styleable.MapAttrs_uiZoomControls, true));
        }
        if (typedArrayObtainAttributes.hasValue(R.styleable.MapAttrs_liteMode)) {
            googleMapOptions.s(typedArrayObtainAttributes.getBoolean(R.styleable.MapAttrs_liteMode, false));
        }
        if (typedArrayObtainAttributes.hasValue(R.styleable.MapAttrs_uiMapToolbar)) {
            googleMapOptions.f38408l = Boolean.valueOf(typedArrayObtainAttributes.getBoolean(R.styleable.MapAttrs_uiMapToolbar, true));
        }
        if (typedArrayObtainAttributes.hasValue(R.styleable.MapAttrs_ambientEnabled)) {
            googleMapOptions.f38409m = Boolean.valueOf(typedArrayObtainAttributes.getBoolean(R.styleable.MapAttrs_ambientEnabled, false));
        }
        if (typedArrayObtainAttributes.hasValue(R.styleable.MapAttrs_cameraMinZoomPreference)) {
            googleMapOptions.n = Float.valueOf(typedArrayObtainAttributes.getFloat(R.styleable.MapAttrs_cameraMinZoomPreference, Float.NEGATIVE_INFINITY));
        }
        if (typedArrayObtainAttributes.hasValue(R.styleable.MapAttrs_cameraMinZoomPreference)) {
            googleMapOptions.o = Float.valueOf(typedArrayObtainAttributes.getFloat(R.styleable.MapAttrs_cameraMaxZoomPreference, Float.POSITIVE_INFINITY));
        }
        if (typedArrayObtainAttributes.hasValue(R.styleable.MapAttrs_backgroundColor)) {
            googleMapOptions.r = Integer.valueOf(typedArrayObtainAttributes.getColor(R.styleable.MapAttrs_backgroundColor, t.intValue()));
        }
        if (typedArrayObtainAttributes.hasValue(R.styleable.MapAttrs_mapId) && (string = typedArrayObtainAttributes.getString(R.styleable.MapAttrs_mapId)) != null && !string.isEmpty()) {
            googleMapOptions.s = string;
        }
        TypedArray typedArrayObtainAttributes2 = context.getResources().obtainAttributes(attributeSet, R.styleable.MapAttrs);
        Float fValueOf = typedArrayObtainAttributes2.hasValue(R.styleable.MapAttrs_latLngBoundsSouthWestLatitude) ? Float.valueOf(typedArrayObtainAttributes2.getFloat(R.styleable.MapAttrs_latLngBoundsSouthWestLatitude, 0.0f)) : null;
        Float fValueOf2 = typedArrayObtainAttributes2.hasValue(R.styleable.MapAttrs_latLngBoundsSouthWestLongitude) ? Float.valueOf(typedArrayObtainAttributes2.getFloat(R.styleable.MapAttrs_latLngBoundsSouthWestLongitude, 0.0f)) : null;
        Float fValueOf3 = typedArrayObtainAttributes2.hasValue(R.styleable.MapAttrs_latLngBoundsNorthEastLatitude) ? Float.valueOf(typedArrayObtainAttributes2.getFloat(R.styleable.MapAttrs_latLngBoundsNorthEastLatitude, 0.0f)) : null;
        Float fValueOf4 = typedArrayObtainAttributes2.hasValue(R.styleable.MapAttrs_latLngBoundsNorthEastLongitude) ? Float.valueOf(typedArrayObtainAttributes2.getFloat(R.styleable.MapAttrs_latLngBoundsNorthEastLongitude, 0.0f)) : null;
        typedArrayObtainAttributes2.recycle();
        if (fValueOf != null && fValueOf2 != null && fValueOf3 != null && fValueOf4 != null) {
            latLngBounds = new LatLngBounds(new LatLng(fValueOf.floatValue(), fValueOf2.floatValue()), new LatLng(fValueOf3.floatValue(), fValueOf4.floatValue()));
        }
        googleMapOptions.p = latLngBounds;
        TypedArray typedArrayObtainAttributes3 = context.getResources().obtainAttributes(attributeSet, R.styleable.MapAttrs);
        LatLng latLng = new LatLng(typedArrayObtainAttributes3.hasValue(R.styleable.MapAttrs_cameraTargetLat) ? typedArrayObtainAttributes3.getFloat(R.styleable.MapAttrs_cameraTargetLat, 0.0f) : 0.0f, typedArrayObtainAttributes3.hasValue(R.styleable.MapAttrs_cameraTargetLng) ? typedArrayObtainAttributes3.getFloat(R.styleable.MapAttrs_cameraTargetLng, 0.0f) : 0.0f);
        Parcelable.Creator<CameraPosition> creator = CameraPosition.CREATOR;
        CameraPosition.Builder builder = new CameraPosition.Builder();
        builder.c(latLng);
        if (typedArrayObtainAttributes3.hasValue(R.styleable.MapAttrs_cameraZoom)) {
            builder.f38440b = typedArrayObtainAttributes3.getFloat(R.styleable.MapAttrs_cameraZoom, 0.0f);
        }
        if (typedArrayObtainAttributes3.hasValue(R.styleable.MapAttrs_cameraBearing)) {
            builder.f38442d = typedArrayObtainAttributes3.getFloat(R.styleable.MapAttrs_cameraBearing, 0.0f);
        }
        if (typedArrayObtainAttributes3.hasValue(R.styleable.MapAttrs_cameraTilt)) {
            builder.f38441c = typedArrayObtainAttributes3.getFloat(R.styleable.MapAttrs_cameraTilt, 0.0f);
        }
        typedArrayObtainAttributes3.recycle();
        googleMapOptions.f38400d = builder.b();
        typedArrayObtainAttributes.recycle();
        return googleMapOptions;
    }

    public final void A(String str) {
        this.s = str;
    }

    public final void b(CameraPosition cameraPosition) {
        this.f38400d = cameraPosition;
    }

    public final void s(boolean z) {
        this.f38407k = Boolean.valueOf(z);
    }

    public final String toString() {
        return Objects.toStringHelper(this).add("MapType", Integer.valueOf(this.f38399c)).add("LiteMode", this.f38407k).add("Camera", this.f38400d).add("CompassEnabled", this.f38402f).add("ZoomControlsEnabled", this.f38401e).add("ScrollGesturesEnabled", this.f38403g).add("ZoomGesturesEnabled", this.f38404h).add("TiltGesturesEnabled", this.f38405i).add("RotateGesturesEnabled", this.f38406j).add("ScrollGesturesEnabledDuringRotateOrZoom", this.q).add("MapToolbarEnabled", this.f38408l).add("AmbientEnabled", this.f38409m).add("MinZoomPreference", this.n).add("MaxZoomPreference", this.o).add("BackgroundColor", this.r).add("LatLngBoundsForCameraTarget", this.p).add("ZOrderOnTop", this.f38397a).add("UseViewLifecycleInFragment", this.f38398b).toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeByte(parcel, 2, com.google.android.gms.maps.internal.zza.a(this.f38397a));
        SafeParcelWriter.writeByte(parcel, 3, com.google.android.gms.maps.internal.zza.a(this.f38398b));
        SafeParcelWriter.writeInt(parcel, 4, this.f38399c);
        SafeParcelWriter.writeParcelable(parcel, 5, this.f38400d, i2, false);
        SafeParcelWriter.writeByte(parcel, 6, com.google.android.gms.maps.internal.zza.a(this.f38401e));
        SafeParcelWriter.writeByte(parcel, 7, com.google.android.gms.maps.internal.zza.a(this.f38402f));
        SafeParcelWriter.writeByte(parcel, 8, com.google.android.gms.maps.internal.zza.a(this.f38403g));
        SafeParcelWriter.writeByte(parcel, 9, com.google.android.gms.maps.internal.zza.a(this.f38404h));
        SafeParcelWriter.writeByte(parcel, 10, com.google.android.gms.maps.internal.zza.a(this.f38405i));
        SafeParcelWriter.writeByte(parcel, 11, com.google.android.gms.maps.internal.zza.a(this.f38406j));
        SafeParcelWriter.writeByte(parcel, 12, com.google.android.gms.maps.internal.zza.a(this.f38407k));
        SafeParcelWriter.writeByte(parcel, 14, com.google.android.gms.maps.internal.zza.a(this.f38408l));
        SafeParcelWriter.writeByte(parcel, 15, com.google.android.gms.maps.internal.zza.a(this.f38409m));
        SafeParcelWriter.writeFloatObject(parcel, 16, this.n, false);
        SafeParcelWriter.writeFloatObject(parcel, 17, this.o, false);
        SafeParcelWriter.writeParcelable(parcel, 18, this.p, i2, false);
        SafeParcelWriter.writeByte(parcel, 19, com.google.android.gms.maps.internal.zza.a(this.q));
        SafeParcelWriter.writeIntegerObject(parcel, 20, this.r, false);
        SafeParcelWriter.writeString(parcel, 21, this.s, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
