package com.example.firebase_app.helper

import android.content.ContentValues.TAG
import android.nfc.Tag
import android.provider.ContactsContract.CommonDataKinds.Email
import android.util.Log
import com.google.firebase.Firebase
import com.google.firebase.auth.auth
import kotlinx.coroutines.tasks.await

class AuthHelper {

    companion object {
        val authHelper = AuthHelper()
    }

    var auth = Firebase.auth

    fun signup(email: String, password: String) {

        auth.createUserWithEmailAndPassword(email, password).addOnSuccessListener {
            Log.e("Tag", "singup: Successlly")
        }.addOnFailureListener {
            Log.e("Tag", "singup: Failed")
        }

    }

     fun sigin(email: String, password: String): String? {
        var msg:String?= null
        try {

            auth.signInWithEmailAndPassword(email,password).addOnSuccessListener {
                Log.e("Tag","singin: Successlly")
                msg = "Success"
            }.addOnFailureListener {
                Log.e("Tag","singin: Failed")
                msg = "Failed"
            }
        }catch (e:Exception){
            Log.e("Tag",e.message.toString())
        }
        return msg
    }

    fun signout(){
        auth.signOut()
    }
}