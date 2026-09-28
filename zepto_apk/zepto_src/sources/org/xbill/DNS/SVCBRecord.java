package org.xbill.DNS;

import java.util.List;
import org.xbill.DNS.SVCBBase;

/* loaded from: classes5.dex */
public class SVCBRecord extends SVCBBase {
    public SVCBRecord() {
    }

    public SVCBRecord(Name name, int i2, long j2, int i3, Name name2, List<SVCBBase.ParameterBase> list) {
        super(name, 64, i2, j2, i3, name2, list);
    }
}
