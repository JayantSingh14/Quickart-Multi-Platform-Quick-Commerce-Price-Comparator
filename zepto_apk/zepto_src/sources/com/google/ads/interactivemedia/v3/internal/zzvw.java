package com.google.ads.interactivemedia.v3.internal;

import android.support.v4.media.b;
import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentNavigableMap;

/* loaded from: classes3.dex */
public final class zzvw {
    private final Map zza;
    private final List zzb;

    public zzvw(Map map, boolean z, List list) {
        this.zza = map;
        this.zzb = list;
    }

    public static String zzb(Class cls) {
        int modifiers = cls.getModifiers();
        if (Modifier.isInterface(modifiers)) {
            return "Interfaces can't be instantiated! Register an InstanceCreator or a TypeAdapter for this type. Interface name: ".concat(cls.getName());
        }
        if (Modifier.isAbstract(modifiers)) {
            return b.D("Abstract classes can't be instantiated! Adjust the R8 configuration or register an InstanceCreator or a TypeAdapter for this type. Class name: ", cls.getName(), "\nSee https://github.com/google/gson/blob/main/Troubleshooting.md#r8-abstract-class");
        }
        return null;
    }

    public final String toString() {
        return this.zza.toString();
    }

    public final zzwl zza(zzaao zzaaoVar) throws NoSuchMethodException, SecurityException {
        zzwl zzvvVar;
        String strZzf;
        Map map = this.zza;
        Type typeZzd = zzaaoVar.zzd();
        Class clsZzc = zzaaoVar.zzc();
        zztz zztzVar = (zztz) map.get(typeZzd);
        if (zztzVar != null) {
            return new zzvn(this, zztzVar, typeZzd);
        }
        zztz zztzVar2 = (zztz) this.zza.get(clsZzc);
        if (zztzVar2 != null) {
            return new zzvo(this, zztzVar2, typeZzd);
        }
        zzwl zzvhVar = null;
        zzwl zzvrVar = EnumSet.class.isAssignableFrom(clsZzc) ? new zzvr(typeZzd) : clsZzc == EnumMap.class ? new zzvs(typeZzd) : null;
        if (zzvrVar != null) {
            return zzvrVar;
        }
        int iZze = zzwq.zze(this.zzb, clsZzc);
        if (Modifier.isAbstract(clsZzc.getModifiers())) {
            zzvvVar = null;
        } else {
            try {
                Constructor declaredConstructor = clsZzc.getDeclaredConstructor(null);
                zzvvVar = (iZze == 1 || (zzwp.zzb.zza(declaredConstructor, null) && (iZze != 4 || Modifier.isPublic(declaredConstructor.getModifiers())))) ? (iZze != 1 || (strZzf = zzaab.zzf(declaredConstructor)) == null) ? new zzvv(declaredConstructor) : new zzvu(strZzf) : new zzvt(b.D("Unable to invoke no-args constructor of ", String.valueOf(clsZzc), "; constructor is not accessible and ReflectionAccessFilter does not permit making it accessible. Register an InstanceCreator or a TypeAdapter for this type, change the visibility of the constructor or adjust the access filter."));
            } catch (NoSuchMethodException unused) {
            }
        }
        if (zzvvVar != null) {
            return zzvvVar;
        }
        if (Collection.class.isAssignableFrom(clsZzc)) {
            zzvhVar = SortedSet.class.isAssignableFrom(clsZzc) ? new zzvd() : Set.class.isAssignableFrom(clsZzc) ? new zzve() : Queue.class.isAssignableFrom(clsZzc) ? new zzvf() : new zzvg();
        } else if (Map.class.isAssignableFrom(clsZzc)) {
            zzvhVar = ConcurrentNavigableMap.class.isAssignableFrom(clsZzc) ? new zzvh() : ConcurrentMap.class.isAssignableFrom(clsZzc) ? new zzvi() : SortedMap.class.isAssignableFrom(clsZzc) ? new zzvj() : (!(typeZzd instanceof ParameterizedType) || String.class.isAssignableFrom(zzaao.zzb(((ParameterizedType) typeZzd).getActualTypeArguments()[0]).zzc())) ? new zzvl() : new zzvk();
        }
        if (zzvhVar != null) {
            return zzvhVar;
        }
        String strZzb = zzb(clsZzc);
        return strZzb != null ? new zzvp(this, strZzb) : iZze == 1 ? new zzvm(this, clsZzc) : new zzvq(this, b.D("Unable to create instance of ", String.valueOf(clsZzc), "; ReflectionAccessFilter does not permit using reflection or Unsafe. Register an InstanceCreator or a TypeAdapter for this type or adjust the access filter to allow using reflection."));
    }
}
