package com.example.firebase_app.helper


import com.google.firebase.Firebase
import com.google.firebase.auth.auth
import com.google.firebase.firestore.firestore

class FireStorehelper {

    companion object{
        val fireStorehelper = FireStorehelper()
    }
    val fireStore = Firebase.firestore
    val collection = "MyTodo"
    val notecollaction = "Notes"
    val currentUser = Firebase.auth.currentUser!!.email.toString()


    fun addtodo(title:String,detail:String){
        fireStore.collection(collection).document(currentUser).collection("notes").add(mapOf("title" to title,"detail" to detail))
    }
}