package com.google.android.gms.internal.plus;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.fragment.app.e;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.server.converter.StringToIntConverter;
import com.google.android.gms.common.server.response.FastJsonResponse;
import com.google.android.gms.common.server.response.FastSafeParcelableJsonResponse;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.plus.model.people.Person;
import com.swmansion.reanimated.layoutReanimation.Snapshot;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

@VisibleForTesting
@SafeParcelable.Class(creator = "PersonEntityCreator")
/* loaded from: classes4.dex */
public final class zzr extends FastSafeParcelableJsonResponse implements Person {
    public static final HashMap A;
    public static final Parcelable.Creator<zzr> CREATOR = new zzs();

    /* renamed from: a, reason: collision with root package name */
    public final HashSet f38195a;

    /* renamed from: b, reason: collision with root package name */
    public final int f38196b;

    /* renamed from: c, reason: collision with root package name */
    public String f38197c;

    /* renamed from: d, reason: collision with root package name */
    public zza f38198d;

    /* renamed from: e, reason: collision with root package name */
    public String f38199e;

    /* renamed from: f, reason: collision with root package name */
    public String f38200f;

    /* renamed from: g, reason: collision with root package name */
    public int f38201g;

    /* renamed from: h, reason: collision with root package name */
    public zzb f38202h;

    /* renamed from: i, reason: collision with root package name */
    public String f38203i;

    /* renamed from: j, reason: collision with root package name */
    public String f38204j;

    /* renamed from: k, reason: collision with root package name */
    public int f38205k;

    /* renamed from: l, reason: collision with root package name */
    public String f38206l;

    /* renamed from: m, reason: collision with root package name */
    public zzc f38207m;
    public boolean n;
    public String o;
    public zzd p;
    public String q;
    public int r;
    public ArrayList s;
    public ArrayList t;
    public int u;
    public int v;
    public String w;
    public String x;
    public ArrayList y;
    public boolean z;

    @VisibleForTesting
    @SafeParcelable.Class(creator = "PersonEntity_AgeRangeEntityCreator")
    public static final class zza extends FastSafeParcelableJsonResponse implements Person.AgeRange {
        public static final Parcelable.Creator<zza> CREATOR = new zzt();

        /* renamed from: e, reason: collision with root package name */
        public static final HashMap f38208e;

        /* renamed from: a, reason: collision with root package name */
        public final HashSet f38209a;

        /* renamed from: b, reason: collision with root package name */
        public final int f38210b;

        /* renamed from: c, reason: collision with root package name */
        public int f38211c;

        /* renamed from: d, reason: collision with root package name */
        public int f38212d;

        static {
            HashMap map = new HashMap();
            f38208e = map;
            map.put("max", FastJsonResponse.Field.forInteger("max", 2));
            map.put("min", FastJsonResponse.Field.forInteger("min", 3));
        }

        public zza() {
            this.f38210b = 1;
            this.f38209a = new HashSet();
        }

        @Override // com.google.android.gms.common.server.response.FastSafeParcelableJsonResponse
        public final boolean equals(Object obj) {
            if (!(obj instanceof zza)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            zza zzaVar = (zza) obj;
            for (FastJsonResponse.Field field : f38208e.values()) {
                if (isFieldSet(field)) {
                    if (!zzaVar.isFieldSet(field) || !getFieldValue(field).equals(zzaVar.getFieldValue(field))) {
                        return false;
                    }
                } else if (zzaVar.isFieldSet(field)) {
                    return false;
                }
            }
            return true;
        }

        @Override // com.google.android.gms.common.data.Freezable
        public final /* bridge */ /* synthetic */ Person.AgeRange freeze() {
            return this;
        }

        @Override // com.google.android.gms.common.server.response.FastJsonResponse
        public final /* synthetic */ Map getFieldMappings() {
            return f38208e;
        }

        @Override // com.google.android.gms.common.server.response.FastJsonResponse
        public final Object getFieldValue(FastJsonResponse.Field field) {
            int safeParcelableFieldId = field.getSafeParcelableFieldId();
            if (safeParcelableFieldId == 2) {
                return Integer.valueOf(this.f38211c);
            }
            if (safeParcelableFieldId == 3) {
                return Integer.valueOf(this.f38212d);
            }
            throw new IllegalStateException(e.m(38, field.getSafeParcelableFieldId(), "Unknown safe parcelable id="));
        }

        @Override // com.google.android.gms.common.server.response.FastSafeParcelableJsonResponse
        public final int hashCode() {
            int iHashCode = 0;
            for (FastJsonResponse.Field field : f38208e.values()) {
                if (isFieldSet(field)) {
                    iHashCode = getFieldValue(field).hashCode() + field.getSafeParcelableFieldId() + iHashCode;
                }
            }
            return iHashCode;
        }

        @Override // com.google.android.gms.common.data.Freezable
        public final boolean isDataValid() {
            return true;
        }

        @Override // com.google.android.gms.common.server.response.FastJsonResponse
        public final boolean isFieldSet(FastJsonResponse.Field field) {
            return this.f38209a.contains(Integer.valueOf(field.getSafeParcelableFieldId()));
        }

        @Override // com.google.android.gms.common.server.response.FastJsonResponse
        public final void setIntegerInternal(FastJsonResponse.Field field, String str, int i2) {
            int safeParcelableFieldId = field.getSafeParcelableFieldId();
            if (safeParcelableFieldId == 2) {
                this.f38211c = i2;
            } else {
                if (safeParcelableFieldId != 3) {
                    StringBuilder sb = new StringBuilder(52);
                    sb.append("Field with id=");
                    sb.append(safeParcelableFieldId);
                    sb.append(" is not known to be an int.");
                    throw new IllegalArgumentException(sb.toString());
                }
                this.f38212d = i2;
            }
            this.f38209a.add(Integer.valueOf(safeParcelableFieldId));
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i2) {
            int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
            HashSet hashSet = this.f38209a;
            if (hashSet.contains(1)) {
                SafeParcelWriter.writeInt(parcel, 1, this.f38210b);
            }
            if (hashSet.contains(2)) {
                SafeParcelWriter.writeInt(parcel, 2, this.f38211c);
            }
            if (hashSet.contains(3)) {
                SafeParcelWriter.writeInt(parcel, 3, this.f38212d);
            }
            SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
        }

        public zza(HashSet hashSet, int i2, int i3, int i4) {
            this.f38209a = hashSet;
            this.f38210b = i2;
            this.f38211c = i3;
            this.f38212d = i4;
        }
    }

    @VisibleForTesting
    @SafeParcelable.Class(creator = "PersonEntity_CoverEntityCreator")
    public static final class zzb extends FastSafeParcelableJsonResponse implements Person.Cover {
        public static final Parcelable.Creator<zzb> CREATOR = new zzu();

        /* renamed from: f, reason: collision with root package name */
        public static final HashMap f38213f;

        /* renamed from: a, reason: collision with root package name */
        public final HashSet f38214a;

        /* renamed from: b, reason: collision with root package name */
        public final int f38215b;

        /* renamed from: c, reason: collision with root package name */
        public zza f38216c;

        /* renamed from: d, reason: collision with root package name */
        public C0029zzb f38217d;

        /* renamed from: e, reason: collision with root package name */
        public int f38218e;

        @VisibleForTesting
        @SafeParcelable.Class(creator = "PersonEntity_CoverEntity_CoverInfoEntityCreator")
        public static final class zza extends FastSafeParcelableJsonResponse implements Person.Cover.CoverInfo {
            public static final Parcelable.Creator<zza> CREATOR = new zzv();

            /* renamed from: e, reason: collision with root package name */
            public static final HashMap f38219e;

            /* renamed from: a, reason: collision with root package name */
            public final HashSet f38220a;

            /* renamed from: b, reason: collision with root package name */
            public final int f38221b;

            /* renamed from: c, reason: collision with root package name */
            public int f38222c;

            /* renamed from: d, reason: collision with root package name */
            public int f38223d;

            static {
                HashMap map = new HashMap();
                f38219e = map;
                map.put("leftImageOffset", FastJsonResponse.Field.forInteger("leftImageOffset", 2));
                map.put("topImageOffset", FastJsonResponse.Field.forInteger("topImageOffset", 3));
            }

            public zza() {
                this.f38221b = 1;
                this.f38220a = new HashSet();
            }

            @Override // com.google.android.gms.common.server.response.FastSafeParcelableJsonResponse
            public final boolean equals(Object obj) {
                if (!(obj instanceof zza)) {
                    return false;
                }
                if (this == obj) {
                    return true;
                }
                zza zzaVar = (zza) obj;
                for (FastJsonResponse.Field field : f38219e.values()) {
                    if (isFieldSet(field)) {
                        if (!zzaVar.isFieldSet(field) || !getFieldValue(field).equals(zzaVar.getFieldValue(field))) {
                            return false;
                        }
                    } else if (zzaVar.isFieldSet(field)) {
                        return false;
                    }
                }
                return true;
            }

            @Override // com.google.android.gms.common.data.Freezable
            public final /* bridge */ /* synthetic */ Person.Cover.CoverInfo freeze() {
                return this;
            }

            @Override // com.google.android.gms.common.server.response.FastJsonResponse
            public final /* synthetic */ Map getFieldMappings() {
                return f38219e;
            }

            @Override // com.google.android.gms.common.server.response.FastJsonResponse
            public final Object getFieldValue(FastJsonResponse.Field field) {
                int safeParcelableFieldId = field.getSafeParcelableFieldId();
                if (safeParcelableFieldId == 2) {
                    return Integer.valueOf(this.f38222c);
                }
                if (safeParcelableFieldId == 3) {
                    return Integer.valueOf(this.f38223d);
                }
                throw new IllegalStateException(e.m(38, field.getSafeParcelableFieldId(), "Unknown safe parcelable id="));
            }

            @Override // com.google.android.gms.common.server.response.FastSafeParcelableJsonResponse
            public final int hashCode() {
                int iHashCode = 0;
                for (FastJsonResponse.Field field : f38219e.values()) {
                    if (isFieldSet(field)) {
                        iHashCode = getFieldValue(field).hashCode() + field.getSafeParcelableFieldId() + iHashCode;
                    }
                }
                return iHashCode;
            }

            @Override // com.google.android.gms.common.data.Freezable
            public final boolean isDataValid() {
                return true;
            }

            @Override // com.google.android.gms.common.server.response.FastJsonResponse
            public final boolean isFieldSet(FastJsonResponse.Field field) {
                return this.f38220a.contains(Integer.valueOf(field.getSafeParcelableFieldId()));
            }

            @Override // com.google.android.gms.common.server.response.FastJsonResponse
            public final void setIntegerInternal(FastJsonResponse.Field field, String str, int i2) {
                int safeParcelableFieldId = field.getSafeParcelableFieldId();
                if (safeParcelableFieldId == 2) {
                    this.f38222c = i2;
                } else {
                    if (safeParcelableFieldId != 3) {
                        StringBuilder sb = new StringBuilder(52);
                        sb.append("Field with id=");
                        sb.append(safeParcelableFieldId);
                        sb.append(" is not known to be an int.");
                        throw new IllegalArgumentException(sb.toString());
                    }
                    this.f38223d = i2;
                }
                this.f38220a.add(Integer.valueOf(safeParcelableFieldId));
            }

            @Override // android.os.Parcelable
            public final void writeToParcel(Parcel parcel, int i2) {
                int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
                HashSet hashSet = this.f38220a;
                if (hashSet.contains(1)) {
                    SafeParcelWriter.writeInt(parcel, 1, this.f38221b);
                }
                if (hashSet.contains(2)) {
                    SafeParcelWriter.writeInt(parcel, 2, this.f38222c);
                }
                if (hashSet.contains(3)) {
                    SafeParcelWriter.writeInt(parcel, 3, this.f38223d);
                }
                SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
            }

            public zza(HashSet hashSet, int i2, int i3, int i4) {
                this.f38220a = hashSet;
                this.f38221b = i2;
                this.f38222c = i3;
                this.f38223d = i4;
            }
        }

        @VisibleForTesting
        @SafeParcelable.Class(creator = "PersonEntity_CoverEntity_CoverPhotoEntityCreator")
        /* renamed from: com.google.android.gms.internal.plus.zzr$zzb$zzb, reason: collision with other inner class name */
        public static final class C0029zzb extends FastSafeParcelableJsonResponse implements Person.Cover.CoverPhoto {
            public static final Parcelable.Creator<C0029zzb> CREATOR = new zzw();

            /* renamed from: f, reason: collision with root package name */
            public static final HashMap f38224f;

            /* renamed from: a, reason: collision with root package name */
            public final HashSet f38225a;

            /* renamed from: b, reason: collision with root package name */
            public final int f38226b;

            /* renamed from: c, reason: collision with root package name */
            public int f38227c;

            /* renamed from: d, reason: collision with root package name */
            public String f38228d;

            /* renamed from: e, reason: collision with root package name */
            public int f38229e;

            static {
                HashMap map = new HashMap();
                f38224f = map;
                map.put(Snapshot.HEIGHT, FastJsonResponse.Field.forInteger(Snapshot.HEIGHT, 2));
                map.put("url", FastJsonResponse.Field.forString("url", 3));
                map.put(Snapshot.WIDTH, FastJsonResponse.Field.forInteger(Snapshot.WIDTH, 4));
            }

            public C0029zzb() {
                this.f38226b = 1;
                this.f38225a = new HashSet();
            }

            @Override // com.google.android.gms.common.server.response.FastSafeParcelableJsonResponse
            public final boolean equals(Object obj) {
                if (!(obj instanceof C0029zzb)) {
                    return false;
                }
                if (this == obj) {
                    return true;
                }
                C0029zzb c0029zzb = (C0029zzb) obj;
                for (FastJsonResponse.Field field : f38224f.values()) {
                    if (isFieldSet(field)) {
                        if (!c0029zzb.isFieldSet(field) || !getFieldValue(field).equals(c0029zzb.getFieldValue(field))) {
                            return false;
                        }
                    } else if (c0029zzb.isFieldSet(field)) {
                        return false;
                    }
                }
                return true;
            }

            @Override // com.google.android.gms.common.data.Freezable
            public final /* bridge */ /* synthetic */ Person.Cover.CoverPhoto freeze() {
                return this;
            }

            @Override // com.google.android.gms.common.server.response.FastJsonResponse
            public final /* synthetic */ Map getFieldMappings() {
                return f38224f;
            }

            @Override // com.google.android.gms.common.server.response.FastJsonResponse
            public final Object getFieldValue(FastJsonResponse.Field field) {
                int safeParcelableFieldId = field.getSafeParcelableFieldId();
                if (safeParcelableFieldId == 2) {
                    return Integer.valueOf(this.f38227c);
                }
                if (safeParcelableFieldId == 3) {
                    return this.f38228d;
                }
                if (safeParcelableFieldId == 4) {
                    return Integer.valueOf(this.f38229e);
                }
                throw new IllegalStateException(e.m(38, field.getSafeParcelableFieldId(), "Unknown safe parcelable id="));
            }

            @Override // com.google.android.gms.common.server.response.FastSafeParcelableJsonResponse
            public final int hashCode() {
                int iHashCode = 0;
                for (FastJsonResponse.Field field : f38224f.values()) {
                    if (isFieldSet(field)) {
                        iHashCode = getFieldValue(field).hashCode() + field.getSafeParcelableFieldId() + iHashCode;
                    }
                }
                return iHashCode;
            }

            @Override // com.google.android.gms.common.data.Freezable
            public final boolean isDataValid() {
                return true;
            }

            @Override // com.google.android.gms.common.server.response.FastJsonResponse
            public final boolean isFieldSet(FastJsonResponse.Field field) {
                return this.f38225a.contains(Integer.valueOf(field.getSafeParcelableFieldId()));
            }

            @Override // com.google.android.gms.common.server.response.FastJsonResponse
            public final void setIntegerInternal(FastJsonResponse.Field field, String str, int i2) {
                int safeParcelableFieldId = field.getSafeParcelableFieldId();
                if (safeParcelableFieldId == 2) {
                    this.f38227c = i2;
                } else {
                    if (safeParcelableFieldId != 4) {
                        StringBuilder sb = new StringBuilder(52);
                        sb.append("Field with id=");
                        sb.append(safeParcelableFieldId);
                        sb.append(" is not known to be an int.");
                        throw new IllegalArgumentException(sb.toString());
                    }
                    this.f38229e = i2;
                }
                this.f38225a.add(Integer.valueOf(safeParcelableFieldId));
            }

            @Override // com.google.android.gms.common.server.response.FastJsonResponse
            public final void setStringInternal(FastJsonResponse.Field field, String str, String str2) {
                int safeParcelableFieldId = field.getSafeParcelableFieldId();
                if (safeParcelableFieldId == 3) {
                    this.f38228d = str2;
                    this.f38225a.add(Integer.valueOf(safeParcelableFieldId));
                } else {
                    StringBuilder sb = new StringBuilder(54);
                    sb.append("Field with id=");
                    sb.append(safeParcelableFieldId);
                    sb.append(" is not known to be a String.");
                    throw new IllegalArgumentException(sb.toString());
                }
            }

            @Override // android.os.Parcelable
            public final void writeToParcel(Parcel parcel, int i2) {
                int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
                HashSet hashSet = this.f38225a;
                if (hashSet.contains(1)) {
                    SafeParcelWriter.writeInt(parcel, 1, this.f38226b);
                }
                if (hashSet.contains(2)) {
                    SafeParcelWriter.writeInt(parcel, 2, this.f38227c);
                }
                if (hashSet.contains(3)) {
                    SafeParcelWriter.writeString(parcel, 3, this.f38228d, true);
                }
                if (hashSet.contains(4)) {
                    SafeParcelWriter.writeInt(parcel, 4, this.f38229e);
                }
                SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
            }

            public C0029zzb(HashSet hashSet, int i2, int i3, String str, int i4) {
                this.f38225a = hashSet;
                this.f38226b = i2;
                this.f38227c = i3;
                this.f38228d = str;
                this.f38229e = i4;
            }
        }

        static {
            HashMap map = new HashMap();
            f38213f = map;
            map.put("coverInfo", FastJsonResponse.Field.forConcreteType("coverInfo", 2, zza.class));
            map.put("coverPhoto", FastJsonResponse.Field.forConcreteType("coverPhoto", 3, C0029zzb.class));
            map.put("layout", FastJsonResponse.Field.withConverter("layout", 4, new StringToIntConverter().add("banner", 0), false));
        }

        public zzb() {
            this.f38215b = 1;
            this.f38214a = new HashSet();
        }

        @Override // com.google.android.gms.common.server.response.FastJsonResponse
        public final void addConcreteTypeInternal(FastJsonResponse.Field field, String str, FastJsonResponse fastJsonResponse) {
            int safeParcelableFieldId = field.getSafeParcelableFieldId();
            if (safeParcelableFieldId == 2) {
                this.f38216c = (zza) fastJsonResponse;
            } else {
                if (safeParcelableFieldId != 3) {
                    String canonicalName = fastJsonResponse.getClass().getCanonicalName();
                    StringBuilder sb = new StringBuilder(e.g(62, canonicalName));
                    sb.append("Field with id=");
                    sb.append(safeParcelableFieldId);
                    sb.append(" is not a known custom type.  Found ");
                    sb.append(canonicalName);
                    sb.append(CLConstants.DOT_SALT_DELIMETER);
                    throw new IllegalArgumentException(sb.toString());
                }
                this.f38217d = (C0029zzb) fastJsonResponse;
            }
            this.f38214a.add(Integer.valueOf(safeParcelableFieldId));
        }

        @Override // com.google.android.gms.common.server.response.FastSafeParcelableJsonResponse
        public final boolean equals(Object obj) {
            if (!(obj instanceof zzb)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            zzb zzbVar = (zzb) obj;
            for (FastJsonResponse.Field field : f38213f.values()) {
                if (isFieldSet(field)) {
                    if (!zzbVar.isFieldSet(field) || !getFieldValue(field).equals(zzbVar.getFieldValue(field))) {
                        return false;
                    }
                } else if (zzbVar.isFieldSet(field)) {
                    return false;
                }
            }
            return true;
        }

        @Override // com.google.android.gms.common.data.Freezable
        public final /* bridge */ /* synthetic */ Person.Cover freeze() {
            return this;
        }

        @Override // com.google.android.gms.common.server.response.FastJsonResponse
        public final /* synthetic */ Map getFieldMappings() {
            return f38213f;
        }

        @Override // com.google.android.gms.common.server.response.FastJsonResponse
        public final Object getFieldValue(FastJsonResponse.Field field) {
            int safeParcelableFieldId = field.getSafeParcelableFieldId();
            if (safeParcelableFieldId == 2) {
                return this.f38216c;
            }
            if (safeParcelableFieldId == 3) {
                return this.f38217d;
            }
            if (safeParcelableFieldId == 4) {
                return Integer.valueOf(this.f38218e);
            }
            throw new IllegalStateException(e.m(38, field.getSafeParcelableFieldId(), "Unknown safe parcelable id="));
        }

        @Override // com.google.android.gms.common.server.response.FastSafeParcelableJsonResponse
        public final int hashCode() {
            int iHashCode = 0;
            for (FastJsonResponse.Field field : f38213f.values()) {
                if (isFieldSet(field)) {
                    iHashCode = getFieldValue(field).hashCode() + field.getSafeParcelableFieldId() + iHashCode;
                }
            }
            return iHashCode;
        }

        @Override // com.google.android.gms.common.data.Freezable
        public final boolean isDataValid() {
            return true;
        }

        @Override // com.google.android.gms.common.server.response.FastJsonResponse
        public final boolean isFieldSet(FastJsonResponse.Field field) {
            return this.f38214a.contains(Integer.valueOf(field.getSafeParcelableFieldId()));
        }

        @Override // com.google.android.gms.common.server.response.FastJsonResponse
        public final void setIntegerInternal(FastJsonResponse.Field field, String str, int i2) {
            int safeParcelableFieldId = field.getSafeParcelableFieldId();
            if (safeParcelableFieldId == 4) {
                this.f38218e = i2;
                this.f38214a.add(Integer.valueOf(safeParcelableFieldId));
            } else {
                StringBuilder sb = new StringBuilder(52);
                sb.append("Field with id=");
                sb.append(safeParcelableFieldId);
                sb.append(" is not known to be an int.");
                throw new IllegalArgumentException(sb.toString());
            }
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i2) {
            int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
            HashSet hashSet = this.f38214a;
            if (hashSet.contains(1)) {
                SafeParcelWriter.writeInt(parcel, 1, this.f38215b);
            }
            if (hashSet.contains(2)) {
                SafeParcelWriter.writeParcelable(parcel, 2, this.f38216c, i2, true);
            }
            if (hashSet.contains(3)) {
                SafeParcelWriter.writeParcelable(parcel, 3, this.f38217d, i2, true);
            }
            if (hashSet.contains(4)) {
                SafeParcelWriter.writeInt(parcel, 4, this.f38218e);
            }
            SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
        }

        public zzb(HashSet hashSet, int i2, zza zzaVar, C0029zzb c0029zzb, int i3) {
            this.f38214a = hashSet;
            this.f38215b = i2;
            this.f38216c = zzaVar;
            this.f38217d = c0029zzb;
            this.f38218e = i3;
        }
    }

    @VisibleForTesting
    @SafeParcelable.Class(creator = "PersonEntity_ImageEntityCreator")
    public static final class zzc extends FastSafeParcelableJsonResponse implements Person.Image {
        public static final Parcelable.Creator<zzc> CREATOR = new zzx();

        /* renamed from: d, reason: collision with root package name */
        public static final HashMap f38230d;

        /* renamed from: a, reason: collision with root package name */
        public final HashSet f38231a;

        /* renamed from: b, reason: collision with root package name */
        public final int f38232b;

        /* renamed from: c, reason: collision with root package name */
        public String f38233c;

        static {
            HashMap map = new HashMap();
            f38230d = map;
            map.put("url", FastJsonResponse.Field.forString("url", 2));
        }

        public zzc() {
            this.f38232b = 1;
            this.f38231a = new HashSet();
        }

        @Override // com.google.android.gms.common.server.response.FastSafeParcelableJsonResponse
        public final boolean equals(Object obj) {
            if (!(obj instanceof zzc)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            zzc zzcVar = (zzc) obj;
            for (FastJsonResponse.Field field : f38230d.values()) {
                if (isFieldSet(field)) {
                    if (!zzcVar.isFieldSet(field) || !getFieldValue(field).equals(zzcVar.getFieldValue(field))) {
                        return false;
                    }
                } else if (zzcVar.isFieldSet(field)) {
                    return false;
                }
            }
            return true;
        }

        @Override // com.google.android.gms.common.data.Freezable
        public final /* bridge */ /* synthetic */ Person.Image freeze() {
            return this;
        }

        @Override // com.google.android.gms.common.server.response.FastJsonResponse
        public final /* synthetic */ Map getFieldMappings() {
            return f38230d;
        }

        @Override // com.google.android.gms.common.server.response.FastJsonResponse
        public final Object getFieldValue(FastJsonResponse.Field field) {
            if (field.getSafeParcelableFieldId() == 2) {
                return this.f38233c;
            }
            throw new IllegalStateException(e.m(38, field.getSafeParcelableFieldId(), "Unknown safe parcelable id="));
        }

        @Override // com.google.android.gms.common.server.response.FastSafeParcelableJsonResponse
        public final int hashCode() {
            int iHashCode = 0;
            for (FastJsonResponse.Field field : f38230d.values()) {
                if (isFieldSet(field)) {
                    iHashCode = getFieldValue(field).hashCode() + field.getSafeParcelableFieldId() + iHashCode;
                }
            }
            return iHashCode;
        }

        @Override // com.google.android.gms.common.data.Freezable
        public final boolean isDataValid() {
            return true;
        }

        @Override // com.google.android.gms.common.server.response.FastJsonResponse
        public final boolean isFieldSet(FastJsonResponse.Field field) {
            return this.f38231a.contains(Integer.valueOf(field.getSafeParcelableFieldId()));
        }

        @Override // com.google.android.gms.common.server.response.FastJsonResponse
        public final void setStringInternal(FastJsonResponse.Field field, String str, String str2) {
            int safeParcelableFieldId = field.getSafeParcelableFieldId();
            if (safeParcelableFieldId == 2) {
                this.f38233c = str2;
                this.f38231a.add(Integer.valueOf(safeParcelableFieldId));
            } else {
                StringBuilder sb = new StringBuilder(54);
                sb.append("Field with id=");
                sb.append(safeParcelableFieldId);
                sb.append(" is not known to be a String.");
                throw new IllegalArgumentException(sb.toString());
            }
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i2) {
            int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
            HashSet hashSet = this.f38231a;
            if (hashSet.contains(1)) {
                SafeParcelWriter.writeInt(parcel, 1, this.f38232b);
            }
            if (hashSet.contains(2)) {
                SafeParcelWriter.writeString(parcel, 2, this.f38233c, true);
            }
            SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
        }

        public zzc(String str) {
            HashSet hashSet = new HashSet();
            this.f38231a = hashSet;
            this.f38232b = 1;
            this.f38233c = str;
            hashSet.add(2);
        }

        public zzc(HashSet hashSet, int i2, String str) {
            this.f38231a = hashSet;
            this.f38232b = i2;
            this.f38233c = str;
        }
    }

    @VisibleForTesting
    @SafeParcelable.Class(creator = "PersonEntity_NameEntityCreator")
    public static final class zzd extends FastSafeParcelableJsonResponse implements Person.Name {
        public static final Parcelable.Creator<zzd> CREATOR = new zzy();

        /* renamed from: i, reason: collision with root package name */
        public static final HashMap f38234i;

        /* renamed from: a, reason: collision with root package name */
        public final HashSet f38235a;

        /* renamed from: b, reason: collision with root package name */
        public final int f38236b;

        /* renamed from: c, reason: collision with root package name */
        public String f38237c;

        /* renamed from: d, reason: collision with root package name */
        public String f38238d;

        /* renamed from: e, reason: collision with root package name */
        public String f38239e;

        /* renamed from: f, reason: collision with root package name */
        public String f38240f;

        /* renamed from: g, reason: collision with root package name */
        public String f38241g;

        /* renamed from: h, reason: collision with root package name */
        public String f38242h;

        static {
            HashMap map = new HashMap();
            f38234i = map;
            map.put("familyName", FastJsonResponse.Field.forString("familyName", 2));
            map.put("formatted", FastJsonResponse.Field.forString("formatted", 3));
            map.put("givenName", FastJsonResponse.Field.forString("givenName", 4));
            map.put("honorificPrefix", FastJsonResponse.Field.forString("honorificPrefix", 5));
            map.put("honorificSuffix", FastJsonResponse.Field.forString("honorificSuffix", 6));
            map.put("middleName", FastJsonResponse.Field.forString("middleName", 7));
        }

        public zzd() {
            this.f38236b = 1;
            this.f38235a = new HashSet();
        }

        @Override // com.google.android.gms.common.server.response.FastSafeParcelableJsonResponse
        public final boolean equals(Object obj) {
            if (!(obj instanceof zzd)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            zzd zzdVar = (zzd) obj;
            for (FastJsonResponse.Field field : f38234i.values()) {
                if (isFieldSet(field)) {
                    if (!zzdVar.isFieldSet(field) || !getFieldValue(field).equals(zzdVar.getFieldValue(field))) {
                        return false;
                    }
                } else if (zzdVar.isFieldSet(field)) {
                    return false;
                }
            }
            return true;
        }

        @Override // com.google.android.gms.common.data.Freezable
        public final /* bridge */ /* synthetic */ Person.Name freeze() {
            return this;
        }

        @Override // com.google.android.gms.common.server.response.FastJsonResponse
        public final /* synthetic */ Map getFieldMappings() {
            return f38234i;
        }

        @Override // com.google.android.gms.common.server.response.FastJsonResponse
        public final Object getFieldValue(FastJsonResponse.Field field) {
            switch (field.getSafeParcelableFieldId()) {
                case 2:
                    return this.f38237c;
                case 3:
                    return this.f38238d;
                case 4:
                    return this.f38239e;
                case 5:
                    return this.f38240f;
                case 6:
                    return this.f38241g;
                case 7:
                    return this.f38242h;
                default:
                    throw new IllegalStateException(e.m(38, field.getSafeParcelableFieldId(), "Unknown safe parcelable id="));
            }
        }

        @Override // com.google.android.gms.common.server.response.FastSafeParcelableJsonResponse
        public final int hashCode() {
            int iHashCode = 0;
            for (FastJsonResponse.Field field : f38234i.values()) {
                if (isFieldSet(field)) {
                    iHashCode = getFieldValue(field).hashCode() + field.getSafeParcelableFieldId() + iHashCode;
                }
            }
            return iHashCode;
        }

        @Override // com.google.android.gms.common.data.Freezable
        public final boolean isDataValid() {
            return true;
        }

        @Override // com.google.android.gms.common.server.response.FastJsonResponse
        public final boolean isFieldSet(FastJsonResponse.Field field) {
            return this.f38235a.contains(Integer.valueOf(field.getSafeParcelableFieldId()));
        }

        @Override // com.google.android.gms.common.server.response.FastJsonResponse
        public final void setStringInternal(FastJsonResponse.Field field, String str, String str2) {
            int safeParcelableFieldId = field.getSafeParcelableFieldId();
            switch (safeParcelableFieldId) {
                case 2:
                    this.f38237c = str2;
                    break;
                case 3:
                    this.f38238d = str2;
                    break;
                case 4:
                    this.f38239e = str2;
                    break;
                case 5:
                    this.f38240f = str2;
                    break;
                case 6:
                    this.f38241g = str2;
                    break;
                case 7:
                    this.f38242h = str2;
                    break;
                default:
                    StringBuilder sb = new StringBuilder(54);
                    sb.append("Field with id=");
                    sb.append(safeParcelableFieldId);
                    sb.append(" is not known to be a String.");
                    throw new IllegalArgumentException(sb.toString());
            }
            this.f38235a.add(Integer.valueOf(safeParcelableFieldId));
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i2) {
            int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
            HashSet hashSet = this.f38235a;
            if (hashSet.contains(1)) {
                SafeParcelWriter.writeInt(parcel, 1, this.f38236b);
            }
            if (hashSet.contains(2)) {
                SafeParcelWriter.writeString(parcel, 2, this.f38237c, true);
            }
            if (hashSet.contains(3)) {
                SafeParcelWriter.writeString(parcel, 3, this.f38238d, true);
            }
            if (hashSet.contains(4)) {
                SafeParcelWriter.writeString(parcel, 4, this.f38239e, true);
            }
            if (hashSet.contains(5)) {
                SafeParcelWriter.writeString(parcel, 5, this.f38240f, true);
            }
            if (hashSet.contains(6)) {
                SafeParcelWriter.writeString(parcel, 6, this.f38241g, true);
            }
            if (hashSet.contains(7)) {
                SafeParcelWriter.writeString(parcel, 7, this.f38242h, true);
            }
            SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
        }

        public zzd(HashSet hashSet, int i2, String str, String str2, String str3, String str4, String str5, String str6) {
            this.f38235a = hashSet;
            this.f38236b = i2;
            this.f38237c = str;
            this.f38238d = str2;
            this.f38239e = str3;
            this.f38240f = str4;
            this.f38241g = str5;
            this.f38242h = str6;
        }
    }

    @VisibleForTesting
    @SafeParcelable.Class(creator = "PersonEntity_OrganizationsEntityCreator")
    public static final class zze extends FastSafeParcelableJsonResponse implements Person.Organizations {
        public static final Parcelable.Creator<zze> CREATOR = new zzz();

        /* renamed from: l, reason: collision with root package name */
        public static final HashMap f38243l;

        /* renamed from: a, reason: collision with root package name */
        public final HashSet f38244a;

        /* renamed from: b, reason: collision with root package name */
        public final int f38245b;

        /* renamed from: c, reason: collision with root package name */
        public String f38246c;

        /* renamed from: d, reason: collision with root package name */
        public String f38247d;

        /* renamed from: e, reason: collision with root package name */
        public String f38248e;

        /* renamed from: f, reason: collision with root package name */
        public String f38249f;

        /* renamed from: g, reason: collision with root package name */
        public String f38250g;

        /* renamed from: h, reason: collision with root package name */
        public boolean f38251h;

        /* renamed from: i, reason: collision with root package name */
        public String f38252i;

        /* renamed from: j, reason: collision with root package name */
        public String f38253j;

        /* renamed from: k, reason: collision with root package name */
        public int f38254k;

        static {
            HashMap map = new HashMap();
            f38243l = map;
            map.put("department", FastJsonResponse.Field.forString("department", 2));
            map.put("description", FastJsonResponse.Field.forString("description", 3));
            map.put("endDate", FastJsonResponse.Field.forString("endDate", 4));
            map.put("location", FastJsonResponse.Field.forString("location", 5));
            map.put(CLConstants.FIELD_PAY_INFO_NAME, FastJsonResponse.Field.forString(CLConstants.FIELD_PAY_INFO_NAME, 6));
            map.put("primary", FastJsonResponse.Field.forBoolean("primary", 7));
            map.put("startDate", FastJsonResponse.Field.forString("startDate", 8));
            map.put("title", FastJsonResponse.Field.forString("title", 9));
            map.put("type", FastJsonResponse.Field.withConverter("type", 10, new StringToIntConverter().add("work", 0).add("school", 1), false));
        }

        public zze() {
            this.f38245b = 1;
            this.f38244a = new HashSet();
        }

        @Override // com.google.android.gms.common.server.response.FastSafeParcelableJsonResponse
        public final boolean equals(Object obj) {
            if (!(obj instanceof zze)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            zze zzeVar = (zze) obj;
            for (FastJsonResponse.Field field : f38243l.values()) {
                if (isFieldSet(field)) {
                    if (!zzeVar.isFieldSet(field) || !getFieldValue(field).equals(zzeVar.getFieldValue(field))) {
                        return false;
                    }
                } else if (zzeVar.isFieldSet(field)) {
                    return false;
                }
            }
            return true;
        }

        @Override // com.google.android.gms.common.data.Freezable
        public final /* bridge */ /* synthetic */ Person.Organizations freeze() {
            return this;
        }

        @Override // com.google.android.gms.common.server.response.FastJsonResponse
        public final /* synthetic */ Map getFieldMappings() {
            return f38243l;
        }

        @Override // com.google.android.gms.common.server.response.FastJsonResponse
        public final Object getFieldValue(FastJsonResponse.Field field) {
            switch (field.getSafeParcelableFieldId()) {
                case 2:
                    return this.f38246c;
                case 3:
                    return this.f38247d;
                case 4:
                    return this.f38248e;
                case 5:
                    return this.f38249f;
                case 6:
                    return this.f38250g;
                case 7:
                    return Boolean.valueOf(this.f38251h);
                case 8:
                    return this.f38252i;
                case 9:
                    return this.f38253j;
                case 10:
                    return Integer.valueOf(this.f38254k);
                default:
                    throw new IllegalStateException(e.m(38, field.getSafeParcelableFieldId(), "Unknown safe parcelable id="));
            }
        }

        @Override // com.google.android.gms.common.server.response.FastSafeParcelableJsonResponse
        public final int hashCode() {
            int iHashCode = 0;
            for (FastJsonResponse.Field field : f38243l.values()) {
                if (isFieldSet(field)) {
                    iHashCode = getFieldValue(field).hashCode() + field.getSafeParcelableFieldId() + iHashCode;
                }
            }
            return iHashCode;
        }

        @Override // com.google.android.gms.common.data.Freezable
        public final boolean isDataValid() {
            return true;
        }

        @Override // com.google.android.gms.common.server.response.FastJsonResponse
        public final boolean isFieldSet(FastJsonResponse.Field field) {
            return this.f38244a.contains(Integer.valueOf(field.getSafeParcelableFieldId()));
        }

        @Override // com.google.android.gms.common.server.response.FastJsonResponse
        public final void setBooleanInternal(FastJsonResponse.Field field, String str, boolean z) {
            int safeParcelableFieldId = field.getSafeParcelableFieldId();
            if (safeParcelableFieldId == 7) {
                this.f38251h = z;
                this.f38244a.add(Integer.valueOf(safeParcelableFieldId));
            } else {
                StringBuilder sb = new StringBuilder(55);
                sb.append("Field with id=");
                sb.append(safeParcelableFieldId);
                sb.append(" is not known to be a boolean.");
                throw new IllegalArgumentException(sb.toString());
            }
        }

        @Override // com.google.android.gms.common.server.response.FastJsonResponse
        public final void setIntegerInternal(FastJsonResponse.Field field, String str, int i2) {
            int safeParcelableFieldId = field.getSafeParcelableFieldId();
            if (safeParcelableFieldId == 10) {
                this.f38254k = i2;
                this.f38244a.add(Integer.valueOf(safeParcelableFieldId));
            } else {
                StringBuilder sb = new StringBuilder(52);
                sb.append("Field with id=");
                sb.append(safeParcelableFieldId);
                sb.append(" is not known to be an int.");
                throw new IllegalArgumentException(sb.toString());
            }
        }

        @Override // com.google.android.gms.common.server.response.FastJsonResponse
        public final void setStringInternal(FastJsonResponse.Field field, String str, String str2) {
            int safeParcelableFieldId = field.getSafeParcelableFieldId();
            switch (safeParcelableFieldId) {
                case 2:
                    this.f38246c = str2;
                    break;
                case 3:
                    this.f38247d = str2;
                    break;
                case 4:
                    this.f38248e = str2;
                    break;
                case 5:
                    this.f38249f = str2;
                    break;
                case 6:
                    this.f38250g = str2;
                    break;
                case 7:
                default:
                    StringBuilder sb = new StringBuilder(54);
                    sb.append("Field with id=");
                    sb.append(safeParcelableFieldId);
                    sb.append(" is not known to be a String.");
                    throw new IllegalArgumentException(sb.toString());
                case 8:
                    this.f38252i = str2;
                    break;
                case 9:
                    this.f38253j = str2;
                    break;
            }
            this.f38244a.add(Integer.valueOf(safeParcelableFieldId));
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i2) {
            int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
            HashSet hashSet = this.f38244a;
            if (hashSet.contains(1)) {
                SafeParcelWriter.writeInt(parcel, 1, this.f38245b);
            }
            if (hashSet.contains(2)) {
                SafeParcelWriter.writeString(parcel, 2, this.f38246c, true);
            }
            if (hashSet.contains(3)) {
                SafeParcelWriter.writeString(parcel, 3, this.f38247d, true);
            }
            if (hashSet.contains(4)) {
                SafeParcelWriter.writeString(parcel, 4, this.f38248e, true);
            }
            if (hashSet.contains(5)) {
                SafeParcelWriter.writeString(parcel, 5, this.f38249f, true);
            }
            if (hashSet.contains(6)) {
                SafeParcelWriter.writeString(parcel, 6, this.f38250g, true);
            }
            if (hashSet.contains(7)) {
                SafeParcelWriter.writeBoolean(parcel, 7, this.f38251h);
            }
            if (hashSet.contains(8)) {
                SafeParcelWriter.writeString(parcel, 8, this.f38252i, true);
            }
            if (hashSet.contains(9)) {
                SafeParcelWriter.writeString(parcel, 9, this.f38253j, true);
            }
            if (hashSet.contains(10)) {
                SafeParcelWriter.writeInt(parcel, 10, this.f38254k);
            }
            SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
        }

        public zze(HashSet hashSet, int i2, String str, String str2, String str3, String str4, String str5, boolean z, String str6, String str7, int i3) {
            this.f38244a = hashSet;
            this.f38245b = i2;
            this.f38246c = str;
            this.f38247d = str2;
            this.f38248e = str3;
            this.f38249f = str4;
            this.f38250g = str5;
            this.f38251h = z;
            this.f38252i = str6;
            this.f38253j = str7;
            this.f38254k = i3;
        }
    }

    @VisibleForTesting
    @SafeParcelable.Class(creator = "PersonEntity_PlacesLivedEntityCreator")
    public static final class zzf extends FastSafeParcelableJsonResponse implements Person.PlacesLived {
        public static final Parcelable.Creator<zzf> CREATOR = new zzaa();

        /* renamed from: e, reason: collision with root package name */
        public static final HashMap f38255e;

        /* renamed from: a, reason: collision with root package name */
        public final HashSet f38256a;

        /* renamed from: b, reason: collision with root package name */
        public final int f38257b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f38258c;

        /* renamed from: d, reason: collision with root package name */
        public String f38259d;

        static {
            HashMap map = new HashMap();
            f38255e = map;
            map.put("primary", FastJsonResponse.Field.forBoolean("primary", 2));
            map.put(CLConstants.FIELD_PAY_INFO_VALUE, FastJsonResponse.Field.forString(CLConstants.FIELD_PAY_INFO_VALUE, 3));
        }

        public zzf() {
            this.f38257b = 1;
            this.f38256a = new HashSet();
        }

        @Override // com.google.android.gms.common.server.response.FastSafeParcelableJsonResponse
        public final boolean equals(Object obj) {
            if (!(obj instanceof zzf)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            zzf zzfVar = (zzf) obj;
            for (FastJsonResponse.Field field : f38255e.values()) {
                if (isFieldSet(field)) {
                    if (!zzfVar.isFieldSet(field) || !getFieldValue(field).equals(zzfVar.getFieldValue(field))) {
                        return false;
                    }
                } else if (zzfVar.isFieldSet(field)) {
                    return false;
                }
            }
            return true;
        }

        @Override // com.google.android.gms.common.data.Freezable
        public final /* bridge */ /* synthetic */ Person.PlacesLived freeze() {
            return this;
        }

        @Override // com.google.android.gms.common.server.response.FastJsonResponse
        public final /* synthetic */ Map getFieldMappings() {
            return f38255e;
        }

        @Override // com.google.android.gms.common.server.response.FastJsonResponse
        public final Object getFieldValue(FastJsonResponse.Field field) {
            int safeParcelableFieldId = field.getSafeParcelableFieldId();
            if (safeParcelableFieldId == 2) {
                return Boolean.valueOf(this.f38258c);
            }
            if (safeParcelableFieldId == 3) {
                return this.f38259d;
            }
            throw new IllegalStateException(e.m(38, field.getSafeParcelableFieldId(), "Unknown safe parcelable id="));
        }

        @Override // com.google.android.gms.common.server.response.FastSafeParcelableJsonResponse
        public final int hashCode() {
            int iHashCode = 0;
            for (FastJsonResponse.Field field : f38255e.values()) {
                if (isFieldSet(field)) {
                    iHashCode = getFieldValue(field).hashCode() + field.getSafeParcelableFieldId() + iHashCode;
                }
            }
            return iHashCode;
        }

        @Override // com.google.android.gms.common.data.Freezable
        public final boolean isDataValid() {
            return true;
        }

        @Override // com.google.android.gms.common.server.response.FastJsonResponse
        public final boolean isFieldSet(FastJsonResponse.Field field) {
            return this.f38256a.contains(Integer.valueOf(field.getSafeParcelableFieldId()));
        }

        @Override // com.google.android.gms.common.server.response.FastJsonResponse
        public final void setBooleanInternal(FastJsonResponse.Field field, String str, boolean z) {
            int safeParcelableFieldId = field.getSafeParcelableFieldId();
            if (safeParcelableFieldId == 2) {
                this.f38258c = z;
                this.f38256a.add(Integer.valueOf(safeParcelableFieldId));
            } else {
                StringBuilder sb = new StringBuilder(55);
                sb.append("Field with id=");
                sb.append(safeParcelableFieldId);
                sb.append(" is not known to be a boolean.");
                throw new IllegalArgumentException(sb.toString());
            }
        }

        @Override // com.google.android.gms.common.server.response.FastJsonResponse
        public final void setStringInternal(FastJsonResponse.Field field, String str, String str2) {
            int safeParcelableFieldId = field.getSafeParcelableFieldId();
            if (safeParcelableFieldId == 3) {
                this.f38259d = str2;
                this.f38256a.add(Integer.valueOf(safeParcelableFieldId));
            } else {
                StringBuilder sb = new StringBuilder(54);
                sb.append("Field with id=");
                sb.append(safeParcelableFieldId);
                sb.append(" is not known to be a String.");
                throw new IllegalArgumentException(sb.toString());
            }
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i2) {
            int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
            HashSet hashSet = this.f38256a;
            if (hashSet.contains(1)) {
                SafeParcelWriter.writeInt(parcel, 1, this.f38257b);
            }
            if (hashSet.contains(2)) {
                SafeParcelWriter.writeBoolean(parcel, 2, this.f38258c);
            }
            if (hashSet.contains(3)) {
                SafeParcelWriter.writeString(parcel, 3, this.f38259d, true);
            }
            SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
        }

        public zzf(HashSet hashSet, int i2, boolean z, String str) {
            this.f38256a = hashSet;
            this.f38257b = i2;
            this.f38258c = z;
            this.f38259d = str;
        }
    }

    @VisibleForTesting
    @SafeParcelable.Class(creator = "PersonEntity_UrlsEntityCreator")
    public static final class zzg extends FastSafeParcelableJsonResponse implements Person.Urls {
        public static final Parcelable.Creator<zzg> CREATOR = new zzab();

        /* renamed from: f, reason: collision with root package name */
        public static final HashMap f38260f;

        /* renamed from: a, reason: collision with root package name */
        public final HashSet f38261a;

        /* renamed from: b, reason: collision with root package name */
        public final int f38262b;

        /* renamed from: c, reason: collision with root package name */
        public String f38263c;

        /* renamed from: d, reason: collision with root package name */
        public int f38264d;

        /* renamed from: e, reason: collision with root package name */
        public String f38265e;

        static {
            HashMap map = new HashMap();
            f38260f = map;
            map.put("label", FastJsonResponse.Field.forString("label", 5));
            map.put("type", FastJsonResponse.Field.withConverter("type", 6, new StringToIntConverter().add("home", 0).add("work", 1).add("blog", 2).add(Scopes.PROFILE, 3).add("other", 4).add("otherProfile", 5).add("contributor", 6).add("website", 7), false));
            map.put(CLConstants.FIELD_PAY_INFO_VALUE, FastJsonResponse.Field.forString(CLConstants.FIELD_PAY_INFO_VALUE, 4));
        }

        public zzg() {
            this.f38262b = 1;
            this.f38261a = new HashSet();
        }

        @Override // com.google.android.gms.common.server.response.FastSafeParcelableJsonResponse
        public final boolean equals(Object obj) {
            if (!(obj instanceof zzg)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            zzg zzgVar = (zzg) obj;
            for (FastJsonResponse.Field field : f38260f.values()) {
                if (isFieldSet(field)) {
                    if (!zzgVar.isFieldSet(field) || !getFieldValue(field).equals(zzgVar.getFieldValue(field))) {
                        return false;
                    }
                } else if (zzgVar.isFieldSet(field)) {
                    return false;
                }
            }
            return true;
        }

        @Override // com.google.android.gms.common.data.Freezable
        public final /* bridge */ /* synthetic */ Person.Urls freeze() {
            return this;
        }

        @Override // com.google.android.gms.common.server.response.FastJsonResponse
        public final /* synthetic */ Map getFieldMappings() {
            return f38260f;
        }

        @Override // com.google.android.gms.common.server.response.FastJsonResponse
        public final Object getFieldValue(FastJsonResponse.Field field) {
            int safeParcelableFieldId = field.getSafeParcelableFieldId();
            if (safeParcelableFieldId == 4) {
                return this.f38265e;
            }
            if (safeParcelableFieldId == 5) {
                return this.f38263c;
            }
            if (safeParcelableFieldId == 6) {
                return Integer.valueOf(this.f38264d);
            }
            throw new IllegalStateException(e.m(38, field.getSafeParcelableFieldId(), "Unknown safe parcelable id="));
        }

        @Override // com.google.android.gms.common.server.response.FastSafeParcelableJsonResponse
        public final int hashCode() {
            int iHashCode = 0;
            for (FastJsonResponse.Field field : f38260f.values()) {
                if (isFieldSet(field)) {
                    iHashCode = getFieldValue(field).hashCode() + field.getSafeParcelableFieldId() + iHashCode;
                }
            }
            return iHashCode;
        }

        @Override // com.google.android.gms.common.data.Freezable
        public final boolean isDataValid() {
            return true;
        }

        @Override // com.google.android.gms.common.server.response.FastJsonResponse
        public final boolean isFieldSet(FastJsonResponse.Field field) {
            return this.f38261a.contains(Integer.valueOf(field.getSafeParcelableFieldId()));
        }

        @Override // com.google.android.gms.common.server.response.FastJsonResponse
        public final void setIntegerInternal(FastJsonResponse.Field field, String str, int i2) {
            int safeParcelableFieldId = field.getSafeParcelableFieldId();
            if (safeParcelableFieldId == 6) {
                this.f38264d = i2;
                this.f38261a.add(Integer.valueOf(safeParcelableFieldId));
            } else {
                StringBuilder sb = new StringBuilder(52);
                sb.append("Field with id=");
                sb.append(safeParcelableFieldId);
                sb.append(" is not known to be an int.");
                throw new IllegalArgumentException(sb.toString());
            }
        }

        @Override // com.google.android.gms.common.server.response.FastJsonResponse
        public final void setStringInternal(FastJsonResponse.Field field, String str, String str2) {
            int safeParcelableFieldId = field.getSafeParcelableFieldId();
            if (safeParcelableFieldId == 4) {
                this.f38265e = str2;
            } else {
                if (safeParcelableFieldId != 5) {
                    StringBuilder sb = new StringBuilder(54);
                    sb.append("Field with id=");
                    sb.append(safeParcelableFieldId);
                    sb.append(" is not known to be a String.");
                    throw new IllegalArgumentException(sb.toString());
                }
                this.f38263c = str2;
            }
            this.f38261a.add(Integer.valueOf(safeParcelableFieldId));
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i2) {
            int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
            HashSet hashSet = this.f38261a;
            if (hashSet.contains(1)) {
                SafeParcelWriter.writeInt(parcel, 1, this.f38262b);
            }
            if (hashSet.contains(3)) {
                SafeParcelWriter.writeInt(parcel, 3, 4);
            }
            if (hashSet.contains(4)) {
                SafeParcelWriter.writeString(parcel, 4, this.f38265e, true);
            }
            if (hashSet.contains(5)) {
                SafeParcelWriter.writeString(parcel, 5, this.f38263c, true);
            }
            if (hashSet.contains(6)) {
                SafeParcelWriter.writeInt(parcel, 6, this.f38264d);
            }
            SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
        }

        public zzg(HashSet hashSet, int i2, String str, int i3, String str2) {
            this.f38261a = hashSet;
            this.f38262b = i2;
            this.f38263c = str;
            this.f38264d = i3;
            this.f38265e = str2;
        }
    }

    static {
        HashMap map = new HashMap();
        A = map;
        map.put("aboutMe", FastJsonResponse.Field.forString("aboutMe", 2));
        map.put("ageRange", FastJsonResponse.Field.forConcreteType("ageRange", 3, zza.class));
        map.put("birthday", FastJsonResponse.Field.forString("birthday", 4));
        map.put("braggingRights", FastJsonResponse.Field.forString("braggingRights", 5));
        map.put("circledByCount", FastJsonResponse.Field.forInteger("circledByCount", 6));
        map.put("cover", FastJsonResponse.Field.forConcreteType("cover", 7, zzb.class));
        map.put("currentLocation", FastJsonResponse.Field.forString("currentLocation", 8));
        map.put("displayName", FastJsonResponse.Field.forString("displayName", 9));
        map.put("gender", FastJsonResponse.Field.withConverter("gender", 12, new StringToIntConverter().add("male", 0).add("female", 1).add("other", 2), false));
        map.put(CLConstants.SHARED_PREFERENCE_ITEM_ID, FastJsonResponse.Field.forString(CLConstants.SHARED_PREFERENCE_ITEM_ID, 14));
        map.put("image", FastJsonResponse.Field.forConcreteType("image", 15, zzc.class));
        map.put("isPlusUser", FastJsonResponse.Field.forBoolean("isPlusUser", 16));
        map.put("language", FastJsonResponse.Field.forString("language", 18));
        map.put(CLConstants.FIELD_PAY_INFO_NAME, FastJsonResponse.Field.forConcreteType(CLConstants.FIELD_PAY_INFO_NAME, 19, zzd.class));
        map.put("nickname", FastJsonResponse.Field.forString("nickname", 20));
        map.put("objectType", FastJsonResponse.Field.withConverter("objectType", 21, new StringToIntConverter().add("person", 0).add("page", 1), false));
        map.put("organizations", FastJsonResponse.Field.forConcreteTypeArray("organizations", 22, zze.class));
        map.put("placesLived", FastJsonResponse.Field.forConcreteTypeArray("placesLived", 23, zzf.class));
        map.put("plusOneCount", FastJsonResponse.Field.forInteger("plusOneCount", 24));
        map.put("relationshipStatus", FastJsonResponse.Field.withConverter("relationshipStatus", 25, new StringToIntConverter().add("single", 0).add("in_a_relationship", 1).add("engaged", 2).add("married", 3).add("its_complicated", 4).add("open_relationship", 5).add("widowed", 6).add("in_domestic_partnership", 7).add("in_civil_union", 8), false));
        map.put("tagline", FastJsonResponse.Field.forString("tagline", 26));
        map.put("url", FastJsonResponse.Field.forString("url", 27));
        map.put("urls", FastJsonResponse.Field.forConcreteTypeArray("urls", 28, zzg.class));
        map.put("verified", FastJsonResponse.Field.forBoolean("verified", 29));
    }

    public zzr() {
        this.f38196b = 1;
        this.f38195a = new HashSet();
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public final void addConcreteTypeArrayInternal(FastJsonResponse.Field field, String str, ArrayList arrayList) {
        int safeParcelableFieldId = field.getSafeParcelableFieldId();
        if (safeParcelableFieldId == 22) {
            this.s = arrayList;
        } else if (safeParcelableFieldId == 23) {
            this.t = arrayList;
        } else {
            if (safeParcelableFieldId != 28) {
                String canonicalName = arrayList.getClass().getCanonicalName();
                StringBuilder sb = new StringBuilder(e.g(71, canonicalName));
                sb.append("Field with id=");
                sb.append(safeParcelableFieldId);
                sb.append(" is not a known array of custom type.  Found ");
                sb.append(canonicalName);
                sb.append(CLConstants.DOT_SALT_DELIMETER);
                throw new IllegalArgumentException(sb.toString());
            }
            this.y = arrayList;
        }
        this.f38195a.add(Integer.valueOf(safeParcelableFieldId));
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public final void addConcreteTypeInternal(FastJsonResponse.Field field, String str, FastJsonResponse fastJsonResponse) {
        int safeParcelableFieldId = field.getSafeParcelableFieldId();
        if (safeParcelableFieldId == 3) {
            this.f38198d = (zza) fastJsonResponse;
        } else if (safeParcelableFieldId == 7) {
            this.f38202h = (zzb) fastJsonResponse;
        } else if (safeParcelableFieldId == 15) {
            this.f38207m = (zzc) fastJsonResponse;
        } else {
            if (safeParcelableFieldId != 19) {
                String canonicalName = fastJsonResponse.getClass().getCanonicalName();
                StringBuilder sb = new StringBuilder(e.g(62, canonicalName));
                sb.append("Field with id=");
                sb.append(safeParcelableFieldId);
                sb.append(" is not a known custom type.  Found ");
                sb.append(canonicalName);
                sb.append(CLConstants.DOT_SALT_DELIMETER);
                throw new IllegalArgumentException(sb.toString());
            }
            this.p = (zzd) fastJsonResponse;
        }
        this.f38195a.add(Integer.valueOf(safeParcelableFieldId));
    }

    @Override // com.google.android.gms.common.server.response.FastSafeParcelableJsonResponse
    public final boolean equals(Object obj) {
        if (!(obj instanceof zzr)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        zzr zzrVar = (zzr) obj;
        for (FastJsonResponse.Field field : A.values()) {
            if (isFieldSet(field)) {
                if (!zzrVar.isFieldSet(field) || !getFieldValue(field).equals(zzrVar.getFieldValue(field))) {
                    return false;
                }
            } else if (zzrVar.isFieldSet(field)) {
                return false;
            }
        }
        return true;
    }

    @Override // com.google.android.gms.common.data.Freezable
    public final /* bridge */ /* synthetic */ Person freeze() {
        return this;
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public final /* synthetic */ Map getFieldMappings() {
        return A;
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public final Object getFieldValue(FastJsonResponse.Field field) {
        switch (field.getSafeParcelableFieldId()) {
            case 2:
                return this.f38197c;
            case 3:
                return this.f38198d;
            case 4:
                return this.f38199e;
            case 5:
                return this.f38200f;
            case 6:
                return Integer.valueOf(this.f38201g);
            case 7:
                return this.f38202h;
            case 8:
                return this.f38203i;
            case 9:
                return this.f38204j;
            case 10:
            case 11:
            case 13:
            case 17:
            default:
                throw new IllegalStateException(e.m(38, field.getSafeParcelableFieldId(), "Unknown safe parcelable id="));
            case 12:
                return Integer.valueOf(this.f38205k);
            case 14:
                return this.f38206l;
            case 15:
                return this.f38207m;
            case 16:
                return Boolean.valueOf(this.n);
            case 18:
                return this.o;
            case 19:
                return this.p;
            case 20:
                return this.q;
            case 21:
                return Integer.valueOf(this.r);
            case 22:
                return this.s;
            case 23:
                return this.t;
            case 24:
                return Integer.valueOf(this.u);
            case 25:
                return Integer.valueOf(this.v);
            case 26:
                return this.w;
            case 27:
                return this.x;
            case 28:
                return this.y;
            case 29:
                return Boolean.valueOf(this.z);
        }
    }

    @Override // com.google.android.gms.common.server.response.FastSafeParcelableJsonResponse
    public final int hashCode() {
        int iHashCode = 0;
        for (FastJsonResponse.Field field : A.values()) {
            if (isFieldSet(field)) {
                iHashCode = getFieldValue(field).hashCode() + field.getSafeParcelableFieldId() + iHashCode;
            }
        }
        return iHashCode;
    }

    @Override // com.google.android.gms.common.data.Freezable
    public final boolean isDataValid() {
        return true;
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public final boolean isFieldSet(FastJsonResponse.Field field) {
        return this.f38195a.contains(Integer.valueOf(field.getSafeParcelableFieldId()));
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public final void setBooleanInternal(FastJsonResponse.Field field, String str, boolean z) {
        int safeParcelableFieldId = field.getSafeParcelableFieldId();
        if (safeParcelableFieldId == 16) {
            this.n = z;
        } else {
            if (safeParcelableFieldId != 29) {
                StringBuilder sb = new StringBuilder(55);
                sb.append("Field with id=");
                sb.append(safeParcelableFieldId);
                sb.append(" is not known to be a boolean.");
                throw new IllegalArgumentException(sb.toString());
            }
            this.z = z;
        }
        this.f38195a.add(Integer.valueOf(safeParcelableFieldId));
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public final void setIntegerInternal(FastJsonResponse.Field field, String str, int i2) {
        int safeParcelableFieldId = field.getSafeParcelableFieldId();
        if (safeParcelableFieldId == 6) {
            this.f38201g = i2;
        } else if (safeParcelableFieldId == 12) {
            this.f38205k = i2;
        } else if (safeParcelableFieldId == 21) {
            this.r = i2;
        } else if (safeParcelableFieldId == 24) {
            this.u = i2;
        } else {
            if (safeParcelableFieldId != 25) {
                StringBuilder sb = new StringBuilder(52);
                sb.append("Field with id=");
                sb.append(safeParcelableFieldId);
                sb.append(" is not known to be an int.");
                throw new IllegalArgumentException(sb.toString());
            }
            this.v = i2;
        }
        this.f38195a.add(Integer.valueOf(safeParcelableFieldId));
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public final void setStringInternal(FastJsonResponse.Field field, String str, String str2) {
        int safeParcelableFieldId = field.getSafeParcelableFieldId();
        if (safeParcelableFieldId == 2) {
            this.f38197c = str2;
        } else if (safeParcelableFieldId == 14) {
            this.f38206l = str2;
        } else if (safeParcelableFieldId == 18) {
            this.o = str2;
        } else if (safeParcelableFieldId == 20) {
            this.q = str2;
        } else if (safeParcelableFieldId == 4) {
            this.f38199e = str2;
        } else if (safeParcelableFieldId == 5) {
            this.f38200f = str2;
        } else if (safeParcelableFieldId == 8) {
            this.f38203i = str2;
        } else if (safeParcelableFieldId == 9) {
            this.f38204j = str2;
        } else if (safeParcelableFieldId == 26) {
            this.w = str2;
        } else {
            if (safeParcelableFieldId != 27) {
                StringBuilder sb = new StringBuilder(54);
                sb.append("Field with id=");
                sb.append(safeParcelableFieldId);
                sb.append(" is not known to be a String.");
                throw new IllegalArgumentException(sb.toString());
            }
            this.x = str2;
        }
        this.f38195a.add(Integer.valueOf(safeParcelableFieldId));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        HashSet hashSet = this.f38195a;
        if (hashSet.contains(1)) {
            SafeParcelWriter.writeInt(parcel, 1, this.f38196b);
        }
        if (hashSet.contains(2)) {
            SafeParcelWriter.writeString(parcel, 2, this.f38197c, true);
        }
        if (hashSet.contains(3)) {
            SafeParcelWriter.writeParcelable(parcel, 3, this.f38198d, i2, true);
        }
        if (hashSet.contains(4)) {
            SafeParcelWriter.writeString(parcel, 4, this.f38199e, true);
        }
        if (hashSet.contains(5)) {
            SafeParcelWriter.writeString(parcel, 5, this.f38200f, true);
        }
        if (hashSet.contains(6)) {
            SafeParcelWriter.writeInt(parcel, 6, this.f38201g);
        }
        if (hashSet.contains(7)) {
            SafeParcelWriter.writeParcelable(parcel, 7, this.f38202h, i2, true);
        }
        if (hashSet.contains(8)) {
            SafeParcelWriter.writeString(parcel, 8, this.f38203i, true);
        }
        if (hashSet.contains(9)) {
            SafeParcelWriter.writeString(parcel, 9, this.f38204j, true);
        }
        if (hashSet.contains(12)) {
            SafeParcelWriter.writeInt(parcel, 12, this.f38205k);
        }
        if (hashSet.contains(14)) {
            SafeParcelWriter.writeString(parcel, 14, this.f38206l, true);
        }
        if (hashSet.contains(15)) {
            SafeParcelWriter.writeParcelable(parcel, 15, this.f38207m, i2, true);
        }
        if (hashSet.contains(16)) {
            SafeParcelWriter.writeBoolean(parcel, 16, this.n);
        }
        if (hashSet.contains(18)) {
            SafeParcelWriter.writeString(parcel, 18, this.o, true);
        }
        if (hashSet.contains(19)) {
            SafeParcelWriter.writeParcelable(parcel, 19, this.p, i2, true);
        }
        if (hashSet.contains(20)) {
            SafeParcelWriter.writeString(parcel, 20, this.q, true);
        }
        if (hashSet.contains(21)) {
            SafeParcelWriter.writeInt(parcel, 21, this.r);
        }
        if (hashSet.contains(22)) {
            SafeParcelWriter.writeTypedList(parcel, 22, this.s, true);
        }
        if (hashSet.contains(23)) {
            SafeParcelWriter.writeTypedList(parcel, 23, this.t, true);
        }
        if (hashSet.contains(24)) {
            SafeParcelWriter.writeInt(parcel, 24, this.u);
        }
        if (hashSet.contains(25)) {
            SafeParcelWriter.writeInt(parcel, 25, this.v);
        }
        if (hashSet.contains(26)) {
            SafeParcelWriter.writeString(parcel, 26, this.w, true);
        }
        if (hashSet.contains(27)) {
            SafeParcelWriter.writeString(parcel, 27, this.x, true);
        }
        if (hashSet.contains(28)) {
            SafeParcelWriter.writeTypedList(parcel, 28, this.y, true);
        }
        if (hashSet.contains(29)) {
            SafeParcelWriter.writeBoolean(parcel, 29, this.z);
        }
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    public zzr(String str, String str2, zzc zzcVar, int i2, String str3) {
        this.f38196b = 1;
        HashSet hashSet = new HashSet();
        this.f38195a = hashSet;
        this.f38204j = str;
        hashSet.add(9);
        this.f38206l = str2;
        hashSet.add(14);
        this.f38207m = zzcVar;
        hashSet.add(15);
        this.r = i2;
        hashSet.add(21);
        this.x = str3;
        hashSet.add(27);
    }

    public zzr(HashSet hashSet, int i2, String str, zza zzaVar, String str2, String str3, int i3, zzb zzbVar, String str4, String str5, int i4, String str6, zzc zzcVar, boolean z, String str7, zzd zzdVar, String str8, int i5, ArrayList arrayList, ArrayList arrayList2, int i6, int i7, String str9, String str10, ArrayList arrayList3, boolean z2) {
        this.f38195a = hashSet;
        this.f38196b = i2;
        this.f38197c = str;
        this.f38198d = zzaVar;
        this.f38199e = str2;
        this.f38200f = str3;
        this.f38201g = i3;
        this.f38202h = zzbVar;
        this.f38203i = str4;
        this.f38204j = str5;
        this.f38205k = i4;
        this.f38206l = str6;
        this.f38207m = zzcVar;
        this.n = z;
        this.o = str7;
        this.p = zzdVar;
        this.q = str8;
        this.r = i5;
        this.s = arrayList;
        this.t = arrayList2;
        this.u = i6;
        this.v = i7;
        this.w = str9;
        this.x = str10;
        this.y = arrayList3;
        this.z = z2;
    }
}
