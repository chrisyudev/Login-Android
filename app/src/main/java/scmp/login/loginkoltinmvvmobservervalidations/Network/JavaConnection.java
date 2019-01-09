package scmp.login.loginkoltinmvvmobservervalidations.Network;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Toast;
import com.android.volley.*;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import org.json.JSONException;
import org.json.JSONObject;
import scmp.login.loginkoltinmvvmobservervalidations.View.ResultActivity;

import javax.xml.transform.Result;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import static android.accounts.AccountManager.KEY_PASSWORD;

public class JavaConnection {
    public static void registerUser(final Context context, final String email, final String password, final View loadingView) {
        loadingView.setVisibility(View.VISIBLE);
        RequestQueue queue = Volley.newRequestQueue(context); // this = context
      String  url = "https://reqres.in/api/login?delay=5";
        StringRequest postRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>()
                {
                    @Override
                    public void onResponse(String response) {
                        // response
                        try {
                            String token = new JSONObject(response).getString("token");
                            Log.d("Response",  token);
                            Intent intent = new Intent(context,ResultActivity.class);
                            intent.putExtra("token",token);
                            context.startActivity(intent);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        loadingView.setVisibility(View.GONE);
                    }
                },
                new Response.ErrorListener()
                {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // error
                        error.printStackTrace();
                        Log.d("Error.Response", error.toString());
                        AlertDialog alertDialog = new AlertDialog.Builder(context).create();
                        alertDialog.setTitle("");
                        alertDialog.setMessage(error.toString());
                        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.dismiss();
                                    }
                                });
                        alertDialog.show();

                        loadingView.setVisibility(View.GONE);
                    }
                }
        ) {
            @Override
            protected Map<String, String> getParams()
            {
                Map<String, String>  params = new HashMap<String, String>();
                params.put("email", email);
                params.put("password", password);

                return params;
            }
        };
        postRequest.setRetryPolicy(new DefaultRetryPolicy(
                30000,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));

        queue.add(postRequest);
    }
}
