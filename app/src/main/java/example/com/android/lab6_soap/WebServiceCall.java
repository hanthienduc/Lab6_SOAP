package example.com.android.lab6_soap;

import android.util.Log;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

/**
 * Created by Han on 30/12/2016.
 */

public class WebServiceCall {
    private static final String TAG = WebServiceCall.class.getSimpleName();

    public static String callWSThreadSoapPrimitive(String strURL, String strSoapAction, SoapObject request) {

        try {
            StringBuffer result;
            SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
            envelope.dotNet = true;
            envelope.setOutputSoapObject(request);
            HttpTransportSE ht = new HttpTransportSE(strURL);
            ht.debug = true;
            ht.call(strSoapAction, envelope);
            SoapPrimitive response = (SoapPrimitive) envelope.getResponse();

            result = new StringBuffer(response.toString());
            Log.i(TAG, "result: " + result.toString());
            return result.toString();

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }
}
