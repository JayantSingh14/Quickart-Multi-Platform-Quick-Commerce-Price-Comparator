package ch.qos.logback.classic.jmx;

import android.support.v4.media.b;
import ch.qos.logback.classic.joran.action.JMXConfiguratorAction;
import ch.qos.logback.core.Context;
import ch.qos.logback.core.status.ErrorStatus;
import ch.qos.logback.core.status.StatusManager;
import ch.qos.logback.core.status.StatusUtil;
import javax.management.MBeanServer;
import javax.management.MalformedObjectNameException;
import javax.management.ObjectName;

/* loaded from: classes3.dex */
public class MBeanUtil {
    public static boolean a(MBeanServer mBeanServer, ObjectName objectName) {
        return mBeanServer.isRegistered(objectName);
    }

    public static ObjectName b(Context context, JMXConfiguratorAction jMXConfiguratorAction, String str) {
        String strD = b.D("Failed to convert [", str, "] to ObjectName");
        StatusUtil statusUtil = new StatusUtil(context);
        try {
            return new ObjectName(str);
        } catch (NullPointerException e2) {
            ErrorStatus errorStatus = new ErrorStatus(strD, jMXConfiguratorAction, e2);
            StatusManager statusManager = statusUtil.f13754a;
            if (statusManager == null) {
                return null;
            }
            statusManager.a(errorStatus);
            return null;
        } catch (MalformedObjectNameException e3) {
            ErrorStatus errorStatus2 = new ErrorStatus(strD, jMXConfiguratorAction, e3);
            StatusManager statusManager2 = statusUtil.f13754a;
            if (statusManager2 == null) {
                return null;
            }
            statusManager2.a(errorStatus2);
            return null;
        }
    }
}
