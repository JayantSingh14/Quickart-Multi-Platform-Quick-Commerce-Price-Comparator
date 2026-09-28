package com.google.android.gms.internal.measurement;

import androidx.fragment.app.e;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

/* loaded from: classes4.dex */
public final class zzah implements zzao {

    /* renamed from: a, reason: collision with root package name */
    public final Double f36761a;

    public zzah(Double d2) {
        if (d2 == null) {
            this.f36761a = Double.valueOf(Double.NaN);
        } else {
            this.f36761a = d2;
        }
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzah) {
            return this.f36761a.equals(((zzah) obj).f36761a);
        }
        return false;
    }

    @Override // com.google.android.gms.internal.measurement.zzao
    public final zzao f() {
        return new zzah(this.f36761a);
    }

    public final int hashCode() {
        return this.f36761a.hashCode();
    }

    @Override // com.google.android.gms.internal.measurement.zzao
    public final zzao i(String str, zzg zzgVar, ArrayList arrayList) {
        if ("toString".equals(str)) {
            return new zzas(zzc());
        }
        throw new IllegalArgumentException(e.D(zzc(), CLConstants.DOT_SALT_DELIMETER, str, " is not a function."));
    }

    public final String toString() {
        return zzc();
    }

    @Override // com.google.android.gms.internal.measurement.zzao
    public final String zzc() throws NumberFormatException {
        Double d2 = this.f36761a;
        if (Double.isNaN(d2.doubleValue())) {
            return "NaN";
        }
        if (Double.isInfinite(d2.doubleValue())) {
            return d2.doubleValue() > 0.0d ? "Infinity" : "-Infinity";
        }
        BigDecimal bigDecimalValueOf = BigDecimal.valueOf(d2.doubleValue());
        BigDecimal bigDecimal = bigDecimalValueOf.signum() == 0 ? new BigDecimal(BigInteger.ZERO, 0) : bigDecimalValueOf.stripTrailingZeros();
        DecimalFormat decimalFormat = new DecimalFormat("0E0");
        decimalFormat.setRoundingMode(RoundingMode.HALF_UP);
        decimalFormat.setMinimumFractionDigits((bigDecimal.scale() > 0 ? bigDecimal.precision() : bigDecimal.scale()) - 1);
        String str = decimalFormat.format(bigDecimal);
        int iIndexOf = str.indexOf("E");
        if (iIndexOf <= 0) {
            return str;
        }
        int i2 = Integer.parseInt(str.substring(iIndexOf + 1));
        return ((i2 >= 0 || i2 <= -7) && (i2 < 0 || i2 >= 21)) ? str.replace("E-", "e-").replace("E", "e+") : bigDecimal.toPlainString();
    }

    @Override // com.google.android.gms.internal.measurement.zzao
    public final Double zzd() {
        return this.f36761a;
    }

    @Override // com.google.android.gms.internal.measurement.zzao
    public final Boolean zze() {
        Double d2 = this.f36761a;
        boolean z = false;
        if (!Double.isNaN(d2.doubleValue()) && d2.doubleValue() != 0.0d) {
            z = true;
        }
        return Boolean.valueOf(z);
    }

    @Override // com.google.android.gms.internal.measurement.zzao
    public final Iterator zzf() {
        return null;
    }
}
