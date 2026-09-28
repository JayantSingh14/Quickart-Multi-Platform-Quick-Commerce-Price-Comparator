package org.xbill.DNS.dnssec;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import lombok.Generated;
import org.xbill.DNS.DSRecord;
import org.xbill.DNS.RRset;
import org.xbill.DNS.Record;

/* loaded from: classes5.dex */
class AlgorithmRequirements {
    private static final int MAX_ALGORITHMS = 255;
    private final short[] needs = new short[255];
    private int num;
    private final ValUtils valUtils;

    public AlgorithmRequirements(ValUtils valUtils) {
        this.valUtils = valUtils;
    }

    @Generated
    public int getNum() {
        return this.num;
    }

    public List<Integer> initDs(RRset rRset, int i2) {
        ArrayList arrayList = new ArrayList();
        this.num = 0;
        Iterator<Record> it = rRset.rrs(false).iterator();
        while (it.hasNext()) {
            DSRecord dSRecord = (DSRecord) it.next();
            if (dSRecord.getDigestID() == i2) {
                int algorithm = dSRecord.getAlgorithm();
                if (this.valUtils.isAlgorithmSupported(algorithm)) {
                    short[] sArr = this.needs;
                    if (sArr[algorithm] == 0) {
                        sArr[algorithm] = 1;
                        arrayList.add(Integer.valueOf(algorithm));
                        this.num++;
                    }
                }
            }
        }
        return arrayList;
    }

    public void initList(List<Integer> list) {
        this.num = 0;
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            this.needs[it.next().intValue()] = 1;
            this.num++;
        }
    }

    public int missing() {
        int i2 = -1;
        int i3 = 0;
        while (true) {
            short[] sArr = this.needs;
            if (i3 >= sArr.length) {
                if (i2 != -1) {
                    return i2;
                }
                return 0;
            }
            short s = sArr[i3];
            if (s == 2) {
                return 0;
            }
            if (s == 1 && i2 == -1) {
                i2 = i3;
            }
            i3++;
        }
    }

    public void setBogus(int i2) {
        short[] sArr = this.needs;
        if (sArr[i2] != 0) {
            sArr[i2] = 2;
        }
    }

    public boolean setSecure(int i2) {
        short[] sArr = this.needs;
        if (sArr[i2] != 0) {
            sArr[i2] = 0;
            int i3 = this.num - 1;
            this.num = i3;
            if (i3 == 0) {
                return true;
            }
        }
        return false;
    }
}
