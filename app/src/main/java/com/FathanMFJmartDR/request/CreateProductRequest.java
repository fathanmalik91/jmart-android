package com.FathanMFJmartDR.request;

import androidx.annotation.Nullable;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

import com.FathanMFJmartDR.model.ProductCategory;

/**
 * Class CreateProductRequest - write a description of the class here
 *
 * @author fathan
 * @version (version number or date here)
 */

//Class for creating new product Requests
public class CreateProductRequest extends StringRequest {
    private Map<String, String> params;

    public CreateProductRequest(String accountId, String name, String weight, String conditionUsed, String price,
                                String  discount, String category, String shipmentPlans,
                                Response.Listener<String> listener, Response.ErrorListener errorListener){
        super(Method.POST, "http://10.0.2.2:1998/product/create", listener, errorListener);
        params = new HashMap<>();
        params.put("accountId", accountId);
        params.put("name", name);
        params.put("weight", weight);
        params.put("conditionUsed", conditionUsed);
        params.put("price", price);
        params.put("discount", discount);
        params.put("category", category);
        params.put("shipmentPlans", shipmentPlans);
    }

    public Map<String, String> getParams(){
        return params;
    }
}
