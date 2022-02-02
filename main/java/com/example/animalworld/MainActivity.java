package com.example.animalworld;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity
{
    ProgressBar loadingPB;
    NestedScrollView nestedSV;
    //ArrayList<PaginationResponse>
    ArrayList<PaginationResponse> rowBeanList;
    ArrayList<PetResponse> petResponses;
    PetsAdapter petsAdapter;
    RecyclerView recyclerView;
    LinearLayoutManager linearLayoutManager;
    LinearLayout short_LTOMOld, short_MTOMOld;
    LinearLayout filter;
    String name, age;
    SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       /* StaticResponseForTesting[] myListData = new StaticResponseForTesting[]
                {
                        new StaticResponseForTesting("Cow","Age : 1 Month"),
                        new StaticResponseForTesting("Dog","Age : 2 Month")

                };
          PetsAdapter adapter = new PetsAdapter(myListData);
          recyclerView.setAdapter(adapter);

*/
        short_LTOMOld = findViewById(R.id.LTO);
        short_MTOMOld = findViewById(R.id.Ly_MTO);
        filter = findViewById(R.id.Ly_filter);
        searchView = findViewById(R.id.search);
        nestedSV = findViewById(R.id.idNested);
        recyclerView = (RecyclerView) findViewById(R.id.rv);
        linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setHasFixedSize(true);
        //  recyclerView.setAdapter(petsAdapter);
        // URL_List();
        URL_Animal();
        //  ordlistsearchapi();
        search(searchView);
        short_LTOMOld.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //ApiCalling
                System.out.println("Less Than One Month Old");
            }
        });
        short_MTOMOld.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //ApiCalling
                System.out.println("More Than One Month Old");
            }
        });

    }
    private void search(SearchView searchanimal)
    {
        searchanimal.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if (newText == null || newText.length() == 0) {
                    // rl_.setVisibility(View.INVISIBLE);
                } else {
                    // rl_.setVisibility(View.VISIBLE);
                    if (petsAdapter != null) petsAdapter.getFilter().filter(newText);

                }
                return true;
            }
        });
    }

    private void URL_Animal()
    {
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<PetResponse> animalResponseCall = apiService.URL_LIST_Animal();
        animalResponseCall.enqueue(new Callback<PetResponse>() {
            @Override
            public void onResponse( Call<PetResponse> call,  Response<PetResponse> response) {
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        name =response.body().getName();
                        age =response.body().getBornAt();
                        ArrayList<PetResponse> petResponses = new ArrayList<>();
                          //rowBeanList.get().getName();
                        PetsAdapter petsAdapter = new PetsAdapter(petResponses,MainActivity.this);
                        recyclerView.setLayoutManager(linearLayoutManager);
                        recyclerView.setAdapter(petsAdapter);
                        //Toast.makeText(MainActivity.this, "" + +, Toast.LENGTH_SHORT).show();
                    } else {
                        recyclerView.setVisibility(View.GONE);
                        Toast.makeText(MainActivity.this, "null data" , Toast.LENGTH_SHORT).show();
                    }
                }

            }
            @Override
            public void onFailure(Call<PetResponse> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Please turn on your internet connection", Toast.LENGTH_SHORT).show();
            }
        });
    }

/*
    private void URL_List()
    {
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<PaginationResponse> ShopOrderListResponseCall = apiService.URL_List_page("1","10");
        ShopOrderListResponseCall.enqueue(new Callback<PaginationResponse>() {
            @Override
            public void onResponse( Call<PaginationResponse> call,  Response<PaginationResponse> response) {
                if (response.isSuccessful()) {
                    if (response.body() != null) {


                        ArrayList<PaginationResponse>paginationResponses = new ArrayList<>();
                        //rowBeanList.get().getName();
                        PetsAdapter petsAdapter = new PetsAdapter(paginationResponses, MainActivity.this);
                        recyclerView.setAdapter(petsAdapter);
                        //Toast.makeText(MainActivity.this, "" + +, Toast.LENGTH_SHORT).show();

                    }
                    else {
                            recyclerView.setVisibility(View.GONE);
                            Toast.makeText(MainActivity.this, "null data" , Toast.LENGTH_SHORT).show();

                        }
                    }

                }

            @Override
            public void onFailure(Call<PaginationResponse> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Please turn on your internet connection", Toast.LENGTH_SHORT).show();
            }
        });
*/
 //   }
/*

    private void ordlistsearchapi() {
        dialog.show();
        dialog.setMessage("Please Wait...");
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        SharedPreferences sharedPreferences = getSharedPreferences(AppConfig.LOGIN_PREF, Context.MODE_PRIVATE);
        String loginStatus = sharedPreferences.getString(AppConfig.PREF_UNIQUE_ID, "");
        Call<ShopOrderListTwoResponse> ShopOrderListResponseCall = apiService.URL_SHOP_ORDER_LIST_TWO(loginStatus, tv_date.getText().toString(), type);
        ShopOrderListResponseCall.enqueue(new Callback<ShopOrderListTwoResponse>() {
            @Override
            public void onResponse(@NonNull Call<ShopOrderListTwoResponse> call, @NonNull Response<ShopOrderListTwoResponse> response) {
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        if (!response.body().isError()) {
                            dialog.dismiss();
                            recyclerOrderList.setVisibility(View.VISIBLE);
                            List<ShopOrderListTwoResponse.RowBean> rowBeanList = response.body().getRow();
                            OrderListAdapter orderListAdapter = new OrderListAdapter(OrderListActivity.this, rowBeanList);
                            recyclerOrderList.setAdapter(orderListAdapter);
                            Toast.makeText(OrderListActivity.this, "" + response.body().getMessage(), Toast.LENGTH_SHORT).show();

                        } else {
                            recyclerOrderList.setVisibility(View.GONE);
                            dialog.dismiss();
                            Toast.makeText(OrderListActivity.this, "" + response.body().getMessage(), Toast.LENGTH_SHORT).show();

                        }
                    }

                } else if (response.code() == 400) {
                    // tvEmptyOrder.setVisibility(View.VISIBLE);
                    recyclerOrderList.setVisibility(View.GONE);
                    dialog.dismiss();
                    try {
                        JSONObject jObjError = null;
                        try {
                            if (response.errorBody() != null) {
                                jObjError = new JSONObject(response.errorBody().string());
                            }

                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        if (jObjError != null) {
                            Toast.makeText(OrderListActivity.this, jObjError.getString("message"), Toast.LENGTH_LONG).show();
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }

            }


            @Override
            public void onFailure(@NonNull Call<ShopOrderListTwoResponse> call, @NonNull Throwable t) {
                Toast.makeText(OrderListActivity.this, "Please turn on your internet connection", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });


    }
*/



}







