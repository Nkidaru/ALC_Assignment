package com.example .alc_assignment

import android.os.Build
import android.os.Bundle
import android.util.Log

import android.view.View
import android.view.Window
import android.view.WindowManager
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_project_submission.*
import kotlinx.android.synthetic.main.activity_project_submission.toolbar
import kotlinx.android.synthetic.main.dialog_alert.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProjectSubmissionActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_project_submission)
        setSupportActionBar(toolbar)

        val window: Window = this.window
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.statusBarColor = ContextCompat.getColor(this, R.color.colorPrimaryDark)
        }



        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
submit.setOnClickListener {
    openDialog()
}
    }



private fun openDialog() {
    val dialogBuilder = AlertDialog.Builder(this)
    val dialogView: View = View.inflate(this, R.layout.dialog_alert, null)
    dialogBuilder.setView(dialogView)

    val dialog = dialogBuilder.create()
    hideViews(null)
    dialog.show()


    dialogView.btn.setOnClickListener {

        ProjectSubmit (null)
        dialog.dismiss()
        Toast.makeText(this, "You agreed", Toast.LENGTH_SHORT).show()
    }
    dialogView.image.setOnClickListener {
        Toast.makeText(this, "You Canceled", Toast.LENGTH_SHORT).show()
        dialog.dismiss()

    }


}
fun ProjectSubmit(view: View ?) {

            val firstName = fname.text.toString()
            val lastName = lname.text.toString()
            val emailAdd = e_address.text.toString()
            val githubProjectLink = link.text.toString()


            if (firstName.isNotEmpty() && lastName.isNotEmpty() && emailAdd.isNotEmpty() && githubProjectLink.isNotEmpty()) {
                ProjectSubmissionFormUrlApi.create().postProject(
                    firstName = firstName,
                    lastName = lastName,
                    email = emailAdd,
                    link = githubProjectLink
                ).enqueue(object : Callback<Unit> {

                    override fun onResponse(
                        call: Call<Unit>,
                        response: Response<Unit>
                    ) {
                        if (response.isSuccessful) {
                            Log.i("ProjectSubmissionCode", "onResponse: ${response.code()}")
                            Log.e("ProjectSubmission", "Success ${response.isSuccessful}")
                            hideViews(null)
                            createSuccessDialog().show()


                        } else {
                            hideViews(null)
                            createErrorDialog().show()
                        }
                    }

                    override fun onFailure(call: Call<Unit>, t: Throwable) {
                        //Do something on failure
                        Log.e("ProjectSubmission", "Error $t")
                        createErrorDialog().show()
                        hideViews(null)
                    }

                })
            } else {


                Toast.makeText(this, "All fields must be filled", Toast.LENGTH_LONG).show()

            }


        }




    private fun createSuccessDialog(): AlertDialog {
        return AlertDialog.Builder(this@ProjectSubmissionActivity)
            .setView(R.layout.success_alertdialog)
            .create()
    }

    private fun createErrorDialog(): AlertDialog {
        return AlertDialog.Builder(this@ProjectSubmissionActivity)
            .setView(R.layout.error_alertdialog)
            .create()
    }

    //Hide TextFields when an alertdialog is running
    fun hideViews(view:View?){
       fname.visibility=if (fname?.visibility == View.VISIBLE)
       {
           View.INVISIBLE
       } else{
           View.VISIBLE
       }
        lname.visibility=if (lname?.visibility==View.VISIBLE)
        {
            View.INVISIBLE
        } else{
            View.VISIBLE
        }
        e_address.visibility=if (e_address?.visibility==View.VISIBLE)
        {
            View.INVISIBLE
        } else{
            View.VISIBLE
        }
        link.visibility=if (link?.visibility==View.VISIBLE)
        {
            View.INVISIBLE
        } else{
            View.VISIBLE
        }
        submit.visibility=if (submit?.visibility==View.VISIBLE)
        {
            View.INVISIBLE
        } else{
            View.VISIBLE
        }

        }



    

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }



}