package com.isa.rentandbillscalculator

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity()
{
    private var houseRentEditText: EditText? = null
    private var electricityBillEditText: EditText? = null
    private var heatingBillEditText: EditText? = null
    private var waterBillEditText: EditText? = null
    private var internetBillEditText: EditText? = null
    private var numberOfResidentsEditText: EditText? = null

    private var rentAmongResidentsEditText: EditText? = null
    private var totalBillsEditText: EditText? = null
    private var billsAmongResidentsEditText: EditText? = null

    private var calculateTotal: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        houseRentEditText = findViewById<View>(R.id.edit_text_house_rent) as EditText
        electricityBillEditText = findViewById<View>(R.id.edit_text_electricity_bill) as EditText
        heatingBillEditText = findViewById<View>(R.id.edit_text_heating_bill) as EditText
        waterBillEditText = findViewById<View>(R.id.edit_text_water_bill) as EditText
        internetBillEditText = findViewById<View>(R.id.edit_text_internet_bill) as EditText
        numberOfResidentsEditText = findViewById<View>(R.id.edit_text_residents) as EditText

        rentAmongResidentsEditText = findViewById<View>(R.id.edit_text_rent_among_residents) as EditText
        totalBillsEditText = findViewById<View>(R.id.edit_text_bills_total) as EditText
        billsAmongResidentsEditText = findViewById<View>(R.id.edit_text_bills_divided) as EditText

        calculateTotal = findViewById<View>(R.id.button_calculate_total) as Button

        houseRentEditText!!.setText("0")
        electricityBillEditText!!.setText("0")
        heatingBillEditText!!.setText("0")
        waterBillEditText!!.setText("0")
        internetBillEditText!!.setText("0")
        numberOfResidentsEditText!!.setText("0")

        rentAmongResidentsEditText!!.setText("0")
        totalBillsEditText!!.setText("0")
        billsAmongResidentsEditText!!.setText("0")

        calculateTotal!!.setOnClickListener {
            try {
                val houseRent = houseRentEditText!!.text.toString().toDouble()
                val electricityBill = electricityBillEditText!!.text.toString().toDouble()
                val heatingBill = heatingBillEditText!!.text.toString().toDouble()
                val waterBill = waterBillEditText!!.text.toString().toDouble()
                val internetBill = internetBillEditText!!.text.toString().toDouble()
                val numberOfResidents = numberOfResidentsEditText!!.text.toString().toDouble()

                val rentAmongResidents = houseRent / numberOfResidents
                val billsTotal = electricityBill + heatingBill + waterBill + internetBill
                val billsAmongResidents = billsTotal / numberOfResidents

                rentAmongResidentsEditText!!.setText(rentAmongResidents.toString())
                totalBillsEditText!!.setText(billsTotal.toString())
                billsAmongResidentsEditText!!.setText(billsAmongResidents.toString())
            } catch (e: Exception) {
                Toast.makeText(
                    this@MainActivity,
                    "Invalid Input",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}