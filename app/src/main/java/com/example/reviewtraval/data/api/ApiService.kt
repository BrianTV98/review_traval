package com.example.reviewtraval.data.api

import com.example.reviewtraval.utils.base_url

class ApiService {
    companion object {
        fun getService(): AppReponsitory {
            return RetrofitClient.getClient(base_url)!!.create(AppReponsitory::class.java)
        }
    }
}