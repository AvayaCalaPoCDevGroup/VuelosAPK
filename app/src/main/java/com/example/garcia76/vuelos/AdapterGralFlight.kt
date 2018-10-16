package com.example.garcia76.vuelos

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.flight_list_row.view.*

class AdapterGralFlight(
        private val flightList: List<FlightData>,
        private val listener: (FlightData) -> Unit
): RecyclerView.Adapter<AdapterGralFlight.FlightHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = FlightHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.flight_list_row, parent, false))

    override fun onBindViewHolder(holder: FlightHolder, position: Int) = holder.bind(flightList[position], listener)

    override fun getItemCount() = flightList.size

    class FlightHolder(articleView: View): RecyclerView.ViewHolder(articleView) {

        fun bind(flight: FlightData, listener: (FlightData) -> Unit) = with(itemView){
            title.text = "Vuelo: "+ flight.flightNumber
            body.text = "Salida: " + flight.departureTime + "\nLlegada: " + flight.arrivalTime
            body2.text = flight.departureAirportFsCode +"-" +  flight.arrivalAirportFsCode
            setOnClickListener { listener(flight) }
        }
    }
}