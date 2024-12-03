package com.example.animation

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView


class SignUpFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sign_up, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val titleTV:TextView = view.findViewById(R.id.titleTV)
        val loginET:EditText = view.findViewById(R.id.loginET)
        val passwordET:EditText = view.findViewById(R.id.passwordET)
        val registrBTN:Button = view.findViewById(R.id.registrBTN)

        val context: Context = view.context
        titleTV.startAnimation(GlobalFun().getAnimation(context,R.anim.move_up_down))
        val anim2 = GlobalFun().getAnimation(context,R.anim.move_down_up)
        loginET.startAnimation(anim2)
        val anim3 = GlobalFun().getAnimation(context,R.anim.move_down_up)
        anim3.startOffset = 200
        passwordET.startAnimation(anim3)
        val anim4 = GlobalFun().getAnimation(context,R.anim.move_down_up)
        anim4.startOffset = 400
        registrBTN.startAnimation(anim4)

        registrBTN.setOnClickListener{
            if(loginET.text.isNotEmpty() && passwordET.text.isNotEmpty()){
                startActivity(Intent(activity,StartActivity::class.java))
            } else {
                loginET.text.clear()
                passwordET.text.clear()
            }
        }
    }
}