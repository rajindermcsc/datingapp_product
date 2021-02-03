package com.websoftquality.gofriend.views.main;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.websoftquality.gofriend.R;
import com.websoftquality.gofriend.configs.AppController;
import com.websoftquality.gofriend.configs.SessionManager;
import com.websoftquality.gofriend.utils.Apierror_handle;
import com.websoftquality.gofriend.utils.Loading;
import com.websoftquality.gofriend.utils.MessageToast;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

public class StripeCardPaymentActivity extends AppCompatActivity implements View.OnClickListener, TextWatcher {

    EditText edt_card,edt_expiry,edt_cvv,edt_name;
    JSONObject jsonObject;
    Loading loading;
    String apiurl;
    Apierror_handle apierror_handle;
    TextView tv_continue;
    Intent intent;
    String amount,item;
    @Inject
    SessionManager sessionManager;
    MessageToast messageToast;
    Handler handler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stripe_card_payment);
        handler=new Handler();
        loading=new Loading(this);
        apierror_handle=new Apierror_handle(this);
        messageToast=new MessageToast(this);
        AppController.getAppComponent().inject(this);
        intent=getIntent();
        amount=intent.getStringExtra("amount");
        item=intent.getStringExtra("item");
        tv_continue=findViewById(R.id.tv_continue);
        edt_card=findViewById(R.id.edt_card);
        edt_expiry=findViewById(R.id.edt_expiry);
        edt_cvv=findViewById(R.id.edt_cvv);
        tv_continue.setOnClickListener(this);
        edt_expiry.addTextChangedListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.tv_continue){
            validations();
        }
    }

    private void validations() {
        if (edt_card.getText().toString().length()<16 ){
            Toast.makeText(this, "Card Number is invalid", Toast.LENGTH_SHORT).show();
        }
        else if (edt_card.getText().toString().trim().isEmpty()){

            Toast.makeText(this, "Please Enter Card Number", Toast.LENGTH_SHORT).show();
        }else if (edt_expiry.getText().toString().trim().isEmpty()){

            Toast.makeText(this, "Please Enter Expiry Date", Toast.LENGTH_SHORT).show();
        }else if (edt_expiry.getText().toString().length()<5){

            Toast.makeText(this, "Expiry Date is invalid", Toast.LENGTH_SHORT).show();
        } else if (edt_cvv.getText().toString().trim().isEmpty()){

            Toast.makeText(this, "Please Enter CVV", Toast.LENGTH_SHORT).show();
        }else if (edt_expiry.getText().toString().length()<3){

            Toast.makeText(this, "CVV is invalid", Toast.LENGTH_SHORT).show();
        }
        else {
            messageToast.showDialog("Payment Successfully");
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent intent=new Intent(StripeCardPaymentActivity.this,HomeActivity.class);
                    startActivity(intent);
                    finish();
                }
            },2900);
//            savecardDetails(getResources().getString(R.string.base_url).concat("setpayment"));
        }
    }

    private void savecardDetails(String apiurl) {
        loading.showDialog();
        Log.e("TAG", "savecardDetails: "+sessionManager.getToken());
        String tag_string_req = "req_login";
        Log.e("TAG", "attendance_webservice: "+apiurl);
        StringRequest strReq = new StringRequest(Request.Method.POST, apiurl, new Response.Listener<String>() {
            @Override
            public void onResponse(String response)
            {
                try{
                    loading.hideDialog();
                    final JSONObject jsonObject = new JSONObject(response);
                    Log.e("TAG", "onResponse: "+jsonObject);
                    if (jsonObject.getString("status_code").equals("1"))
                    {
//                        Intent intent=new Intent(StripeCardPaymentActivity.this,ProfileActivity.class);
//                        startActivity(intent);
                    }
                    else
                    {
                        loading.hideDialog();

                    }
                }
                catch(Exception e)
                {
                    Log.e("TAG", "onResponse: "+e.getMessage());
                    loading.hideDialog();
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener()
        {
            @Override
            public void onErrorResponse(VolleyError error)
            {
                Log.e("TAG", "onResponse: "+error.getMessage());
                loading.hideDialog();

                try
                {
                    apierror_handle.get_error(error);
                }catch (Exception e)
                {
                    Log.e("TAG", "onErrorResponse: " + e.getMessage());
                }
            }
        })
        {
            @Override
            protected Map<String, String> getParams()
            {
                Map<String, String> params = new HashMap<String, String>();
                params.put("plan_id", item);
                params.put("cvv", edt_cvv.getText().toString());
                params.put("expiry_date", edt_expiry.getText().toString());
                params.put("card_num", edt_card.getText().toString());
                params.put("token", sessionManager.getToken());
                return params;
            }
        };
        strReq.setRetryPolicy(new DefaultRetryPolicy(10000, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        AppController.getInstance().addToRequestQueue(strReq, tag_string_req);
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {

    }
}