package com.miu.student.walmart

import java.io.Serializable

data class Product(var  Title:String,var price:Double,var color:String,var image:Int,var itemid:String,var desc:String):
    Serializable