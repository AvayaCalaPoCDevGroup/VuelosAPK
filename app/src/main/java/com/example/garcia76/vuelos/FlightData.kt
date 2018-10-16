package com.example.garcia76.vuelos

data class FlightData(
        var carrierFsCode: String = "",
        var flightNumber: String = "",
        var departureAirportFsCode: String = "",
        var arrivalAirportFsCode: String = "",
        var stops: Int = 0,
        var departureTerminal: String = "",
        var departureTime: String = "",
        var arrivalTime: String = "",
        var flightEquipmentIataCode: String = "",
        var isCodeshare: Boolean = false,
        var isWetlease: Boolean = false,
        var serviceType: String = "",
        var serviceClasses: List<String> = listOf(),
        var trafficRestrictions: List<String> = listOf(),
        var codeshares: List<Any> = listOf(),
        var referenceCode: String = "",
        var operator: Operator = Operator(),
        var arrivalTerminal: String = "",
        var wetleaseOperatorFsCode: String = ""
) {
    data class Operator(
            var carrierFsCode: String = "",
            var flightNumber: String = "",
            var serviceType: String = "",
            var serviceClasses: List<String> = listOf(),
            var trafficRestrictions: List<Any> = listOf()
    )
}