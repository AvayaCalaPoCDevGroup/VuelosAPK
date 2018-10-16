package com.example.garcia76.vuelos

import android.app.AlertDialog
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.github.kittinunf.fuel.core.FuelManager
import com.github.kittinunf.fuel.core.Method
import com.google.gson.Gson
import kotlinx.android.synthetic.main.flight_list_row.view.*
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*
import android.support.v4.content.ContextCompat.startActivity
import android.content.Intent



class AdapterGralFlight(
        private val flightList: List<FlightData>,
        private val listener: (FlightData) -> Unit
): RecyclerView.Adapter<AdapterGralFlight.FlightHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = FlightHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.flight_list_row, parent, false))

    override fun onBindViewHolder(holder: FlightHolder, position: Int) = holder.bind(flightList[position], listener)

    override fun getItemCount() = flightList.size

    class FlightHolder(articleView: View) : RecyclerView.ViewHolder(articleView) {

        fun bind(flight: FlightData, listener: (FlightData) -> Unit) = with(itemView) {
            title.text = "Vuelo: " + flight.flightNumber
            body.text = "Salida: " + flight.departureTime + "\nLlegada: " + flight.arrivalTime
            body2.text = flight.departureAirportFsCode + "-" + flight.arrivalAirportFsCode
            setOnClickListener {
                val calendar = Calendar.getInstance()
                val mdformat = SimpleDateFormat("Y/MM/d")
                val strDate = mdformat.format(calendar.time)
                //Definimos las variables de URL que tendra nuestra peticion con sus respectivas llaves
                //Key
                var paramKey1 = "appId"
                //Parametro-Variable
                var paramValue1 = "1e37e37f"
                //Key

                var paramKey2 = "appKey"
                //Parametro Variable
                var paramValue2 = "f567d8a6cedad03d7b105dc2c1f2c0af"

                var paramKey3 = "utc"
                //Parametro Variable
                var paramValue3 = "false"

                var paramKey4 = "airport"
                //Parametro Variable
                var paramValue4 = flight.arrivalAirportFsCode

                var paramKey5 = "codeType"
                //Parametro Variable
                var paramValue5 = "IATA"

                var paramKey6 = "extendedOptions"
                //Parametro Variable
                var paramValue6 = "useHttpErrors"

                //Invocamos FUEL Manager y lo asignamos a una variable para tener un mejor acceso a el
                val manager: FuelManager by lazy { FuelManager() }
                //Usamos el metodo request de FUUEL Manager, junto a la lusta de parametros
                manager.request(Method.GET, "https://api.flightstats.com/flex/flightstatus/rest/v2/json/flight/status/${flight.carrierFsCode}/${flight.flightNumber}/arr/$strDate?", listOf(paramKey1 to paramValue1, paramKey2 to paramValue2, paramKey3 to paramValue3, paramKey4 to paramValue4, paramKey5 to paramValue5,  paramKey6 to paramValue6)).responseString { req, res, result ->
                    Log.d("Response", req.path.toString())
                    val (data, error) = result
                    //Si no tenemos ningun error, procedemos a hacer la llamada, ya que el servidor respondio con un 200 y tendremos el Token de LLamada
                    when (error) {
                        null -> {
                            //Imprimimos el Response en el LogCat solo para asegurar que se hizo bien la peticion
                            Log.d("RESPONSES", data)
                            // creamos una variable llamada gson para la Funcion GSON() para que sea mas accesible
                            var gson = Gson()
                            //Asignamos a la variable Login el metodo gson?.fromJson(data, Login.Response::class.java) y le pasamos el response JSON para su conversion a un objeto que Android puede manejar
                            var Login = gson?.fromJson(data, FlightStatus::class.java)
                            var AirlinesData1 = Login.appendix.airlines[0]
                            var AirportData = Login.appendix.airports[1]

                            var aero1name =  AirlinesData1.name
                            var EstadosVuelo = Login.flightStatuses[0]
                            var fechallegada = EstadosVuelo.arrivalDate
                            var fechasalida = EstadosVuelo.departureDate

                            val builder = AlertDialog.Builder(this@with.context)
                            builder.setTitle("¿Enviar Información de Vuelo?")

                            // Display a message on alert dialog
                            builder.setMessage("Aerolinea: Aeromexico \n" +
                            "Aeropuerto: " + AirportData.name+ "\n"+
                            "Salida:" + fechasalida.dateLocal+ "\n"+
                            "LLegada: " + fechallegada.dateLocal+ "\n"+
                            "Tiempo de Vuelo Estimado:" + EstadosVuelo.flightDurations.scheduledAirMinutes + "Mins" )

                            builder.setPositiveButton("Si") { dialog, which ->


                            }


                            // Display a negative button on alert dialog
                            builder.setNegativeButton("No") { dialog, which ->
                            }


                            // Finally, make the alert dialog using builder
                            val dialog: AlertDialog = builder.create()

                            // Display the alert dialog on app interface
                            dialog.show()
                        }
                    }


                }
            }
        }
    }
}
