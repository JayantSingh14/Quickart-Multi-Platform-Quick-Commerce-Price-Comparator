package com.google.ads.interactivemedia.v3.internal;

import android.view.View;
import androidx.annotation.Nullable;
import com.google.ads.interactivemedia.omid.library.adsession.FriendlyObstructionPurpose;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

/* loaded from: classes3.dex */
public final class zzcd {
    private static final Pattern zza = Pattern.compile("^[a-zA-Z0-9 ]+$");
    private final List zzb = new ArrayList();

    public final List zza() {
        return this.zzb;
    }

    public final void zzb(View view, FriendlyObstructionPurpose friendlyObstructionPurpose, @Nullable String str) {
        zzcc zzccVar;
        if (view == null) {
            throw new IllegalArgumentException("FriendlyObstruction is null");
        }
        if (str != null) {
            if (str.length() > 50) {
                throw new IllegalArgumentException("FriendlyObstruction has detailed reason over 50 characters in length");
            }
            if (!zza.matcher(str).matches()) {
                throw new IllegalArgumentException("FriendlyObstruction has detailed reason that contains characters not in [a-z][A-Z][0-9] or space");
            }
        }
        Iterator it = this.zzb.iterator();
        while (true) {
            if (!it.hasNext()) {
                zzccVar = null;
                break;
            } else {
                zzccVar = (zzcc) it.next();
                if (zzccVar.zzb().get() == view) {
                    break;
                }
            }
        }
        if (zzccVar == null) {
            this.zzb.add(new zzcc(view, friendlyObstructionPurpose, str));
        }
    }

    public final void zzc() {
        this.zzb.clear();
    }
}
