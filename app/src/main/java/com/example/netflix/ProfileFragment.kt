package com.example.netflix

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class ProfileFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_profile, container, false)
        val mSharedPreferences = requireContext().getSharedPreferences(PREF_FILE, AppCompatActivity.MODE_PRIVATE)
        var email:String?=mSharedPreferences.getString(EMAIL,"no email")
        val emailTv: TextView = view.findViewById(R.id.profile_email)

        emailTv.text=email
        return view
    }


}