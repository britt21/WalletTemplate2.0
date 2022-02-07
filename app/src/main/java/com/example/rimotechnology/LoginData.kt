package com.example.rimotechnology


import com.google.gson.annotations.SerializedName

data class LoginData(
    @SerializedName("phone")
  val phone : String,
    @SerializedName("password")
  val password : String,
    @SerializedName("device_id")
  val device_id : String,
    @SerializedName("device_name")
  val device_name : String

)