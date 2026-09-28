package com.google.ads.interactivemedia.v3.internal;

import android.view.View;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.WeakHashMap;

/* loaded from: classes3.dex */
public final class zzdb {
    private final HashMap zza = new HashMap();
    private final HashMap zzb = new HashMap();
    private final HashMap zzc = new HashMap();
    private final HashSet zzd = new HashSet();
    private final HashSet zze = new HashSet();
    private final HashSet zzf = new HashSet();
    private final HashMap zzg = new HashMap();
    private final Map zzh = new WeakHashMap();
    private boolean zzi;

    public final View zza(String str) {
        return (View) this.zzc.get(str);
    }

    public final zzda zzb(View view) {
        zzda zzdaVar = (zzda) this.zzb.get(view);
        if (zzdaVar != null) {
            this.zzb.remove(view);
        }
        return zzdaVar;
    }

    public final String zzc(String str) {
        return (String) this.zzg.get(str);
    }

    public final String zzd(View view) {
        if (this.zza.size() == 0) {
            return null;
        }
        String str = (String) this.zza.get(view);
        if (str != null) {
            this.zza.remove(view);
        }
        return str;
    }

    public final HashSet zze() {
        return this.zzf;
    }

    public final HashSet zzf() {
        return this.zze;
    }

    public final void zzg() {
        this.zza.clear();
        this.zzb.clear();
        this.zzc.clear();
        this.zzd.clear();
        this.zze.clear();
        this.zzf.clear();
        this.zzg.clear();
        this.zzi = false;
    }

    public final void zzh() {
        this.zzi = true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void zzi() {
        Boolean bool;
        String str;
        zzbz zzbzVarZza = zzbz.zza();
        if (zzbzVarZza != null) {
            for (com.google.ads.interactivemedia.omid.library.adsession.zze zzeVar : zzbzVarZza.zzb()) {
                View viewZzg = zzeVar.zzg();
                if (zzeVar.zzk()) {
                    String strZzi = zzeVar.zzi();
                    if (viewZzg != null) {
                        if (viewZzg.isAttachedToWindow()) {
                            if (viewZzg.hasWindowFocus()) {
                                this.zzh.remove(viewZzg);
                                bool = Boolean.FALSE;
                            } else if (this.zzh.containsKey(viewZzg)) {
                                bool = (Boolean) this.zzh.get(viewZzg);
                            } else {
                                Map map = this.zzh;
                                Boolean bool2 = Boolean.FALSE;
                                map.put(viewZzg, bool2);
                                bool = bool2;
                            }
                            if (!bool.booleanValue()) {
                                HashSet hashSet = new HashSet();
                                View view = viewZzg;
                                while (true) {
                                    if (view == null) {
                                        this.zzd.addAll(hashSet);
                                        str = null;
                                        break;
                                    }
                                    String strZzb = zzcz.zzb(view);
                                    if (strZzb != null) {
                                        str = strZzb;
                                        break;
                                    } else {
                                        hashSet.add(view);
                                        Object parent = view.getParent();
                                        view = parent instanceof View ? (View) parent : null;
                                    }
                                }
                            } else {
                                str = "noWindowFocus";
                            }
                        } else {
                            str = "notAttached";
                        }
                        if (str == null) {
                            this.zze.add(strZzi);
                            this.zza.put(viewZzg, strZzi);
                            for (zzcc zzccVar : zzeVar.zzj()) {
                                View view2 = (View) zzccVar.zzb().get();
                                if (view2 != null) {
                                    zzda zzdaVar = (zzda) this.zzb.get(view2);
                                    if (zzdaVar != null) {
                                        zzdaVar.zzc(zzeVar.zzi());
                                    } else {
                                        this.zzb.put(view2, new zzda(zzccVar, zzeVar.zzi()));
                                    }
                                }
                            }
                        } else if (str != "noWindowFocus") {
                            this.zzf.add(strZzi);
                            this.zzc.put(strZzi, viewZzg);
                            this.zzg.put(strZzi, str);
                        }
                    } else {
                        this.zzf.add(strZzi);
                        this.zzg.put(strZzi, "noAdView");
                    }
                }
            }
        }
    }

    public final boolean zzj(View view) {
        if (!this.zzh.containsKey(view)) {
            return true;
        }
        this.zzh.put(view, Boolean.TRUE);
        return false;
    }

    public final int zzk(View view) {
        if (this.zzd.contains(view)) {
            return 1;
        }
        return this.zzi ? 2 : 3;
    }
}
