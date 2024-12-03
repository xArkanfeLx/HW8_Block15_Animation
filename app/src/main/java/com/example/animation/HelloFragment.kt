package com.example.animation

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast

class HelloFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_hello, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val imgIV: ImageView = view.findViewById(R.id.imgIV)
        val startBTN: Button = view.findViewById(R.id.startBTN)

        val context:Context = view.context
        imgIV.startAnimation(GlobalFun().getAnimation(context,R.anim.show))
        startBTN.startAnimation(GlobalFun().getAnimation(context,R.anim.move_left_right))

        startBTN.setOnClickListener{
            fragmentManager?.beginTransaction()?.replace(R.id.main,SignUpFragment())?.commit()
        }
    }
}