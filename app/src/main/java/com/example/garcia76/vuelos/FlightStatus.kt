package com.example.garcia76.vuelos

data class FlightStatus(
        var request: Request = Request(),
        var appendix: Appendix = Appendix(),
        var flightStatuses: List<FlightStatuse> = listOf()
) {
    data class Request(
            var airline: Airline = Airline(),
            var flight: Flight = Flight(),
            var date: Date = Date(),
            var utc: Utc = Utc(),
            var airport: Airport = Airport(),
            var codeType: CodeType = CodeType(),
            var extendedOptions: ExtendedOptions = ExtendedOptions(),
            var url: String = ""
    ) {
        data class Date(
                var year: String = "",
                var month: String = "",
                var day: String = "",
                var interpreted: String = ""
        )

        data class Flight(
                var requested: String = "",
                var interpreted: String = ""
        )

        data class CodeType(
                var requested: String = "",
                var interpreted: String = ""
        )

        data class Airline(
                var requestedCode: String = "",
                var fsCode: String = ""
        )

        data class Airport(
                var requestedCode: String = "",
                var fsCode: String = ""
        )

        data class ExtendedOptions(
                var requested: String = "",
                var interpreted: String = ""
        )

        data class Utc(
                var requested: String = "",
                var interpreted: Boolean = false
        )
    }

    data class FlightStatuse(
            var flightId: Int = 0,
            var carrierFsCode: String = "",
            var flightNumber: String = "",
            var departureAirportFsCode: String = "",
            var arrivalAirportFsCode: String = "",
            var departureDate: DepartureDate = DepartureDate(),
            var arrivalDate: ArrivalDate = ArrivalDate(),
            var status: String = "",
            var schedule: Schedule = Schedule(),
            var operationalTimes: OperationalTimes = OperationalTimes(),
            var codeshares: List<Codeshare> = listOf(),
            var delays: Delays = Delays(),
            var flightDurations: FlightDurations = FlightDurations(),
            var airportResources: AirportResources = AirportResources(),
            var flightEquipment: FlightEquipment = FlightEquipment()
    ) {
        data class FlightDurations(
                var scheduledBlockMinutes: Int = 0,
                var scheduledAirMinutes: Int = 0,
                var scheduledTaxiOutMinutes: Int = 0,
                var taxiOutMinutes: Int = 0,
                var scheduledTaxiInMinutes: Int = 0
        )

        data class AirportResources(
                var departureTerminal: String = "",
                var departureGate: String = "",
                var arrivalTerminal: String = "",
                var arrivalGate: String = "",
                var baggage: String = ""
        )

        data class Codeshare(
                var fsCode: String = "",
                var flightNumber: String = "",
                var relationship: String = ""
        )

        data class Delays(
                var departureGateDelayMinutes: Int = 0,
                var departureRunwayDelayMinutes: Int = 0
        )

        data class DepartureDate(
                var dateLocal: String = "",
                var dateUtc: String = ""
        )

        data class ArrivalDate(
                var dateLocal: String = "",
                var dateUtc: String = ""
        )

        data class Schedule(
                var flightType: String = "",
                var serviceClasses: String = "",
                var restrictions: String = ""
        )

        data class FlightEquipment(
                var scheduledEquipmentIataCode: String = "",
                var actualEquipmentIataCode: String = "",
                var tailNumber: String = ""
        )

        data class OperationalTimes(
                var publishedDeparture: PublishedDeparture = PublishedDeparture(),
                var publishedArrival: PublishedArrival = PublishedArrival(),
                var scheduledGateDeparture: ScheduledGateDeparture = ScheduledGateDeparture(),
                var estimatedGateDeparture: EstimatedGateDeparture = EstimatedGateDeparture(),
                var actualGateDeparture: ActualGateDeparture = ActualGateDeparture(),
                var flightPlanPlannedDeparture: FlightPlanPlannedDeparture = FlightPlanPlannedDeparture(),
                var estimatedRunwayDeparture: EstimatedRunwayDeparture = EstimatedRunwayDeparture(),
                var actualRunwayDeparture: ActualRunwayDeparture = ActualRunwayDeparture(),
                var scheduledGateArrival: ScheduledGateArrival = ScheduledGateArrival(),
                var estimatedGateArrival: EstimatedGateArrival = EstimatedGateArrival(),
                var flightPlanPlannedArrival: FlightPlanPlannedArrival = FlightPlanPlannedArrival()
        ) {
            data class EstimatedGateArrival(
                    var dateLocal: String = "",
                    var dateUtc: String = ""
            )

            data class FlightPlanPlannedArrival(
                    var dateLocal: String = "",
                    var dateUtc: String = ""
            )

            data class FlightPlanPlannedDeparture(
                    var dateLocal: String = "",
                    var dateUtc: String = ""
            )

            data class EstimatedGateDeparture(
                    var dateLocal: String = "",
                    var dateUtc: String = ""
            )

            data class ActualRunwayDeparture(
                    var dateLocal: String = "",
                    var dateUtc: String = ""
            )

            data class EstimatedRunwayDeparture(
                    var dateLocal: String = "",
                    var dateUtc: String = ""
            )

            data class ScheduledGateArrival(
                    var dateLocal: String = "",
                    var dateUtc: String = ""
            )

            data class PublishedDeparture(
                    var dateLocal: String = "",
                    var dateUtc: String = ""
            )

            data class PublishedArrival(
                    var dateLocal: String = "",
                    var dateUtc: String = ""
            )

            data class ScheduledGateDeparture(
                    var dateLocal: String = "",
                    var dateUtc: String = ""
            )

            data class ActualGateDeparture(
                    var dateLocal: String = "",
                    var dateUtc: String = ""
            )
        }
    }

    data class Appendix(
            var airlines: List<Airline> = listOf(),
            var airports: List<Airport> = listOf(),
            var equipments: List<Equipment> = listOf()
    ) {
        data class Airline(
                var fs: String = "",
                var iata: String = "",
                var icao: String = "",
                var name: String = "",
                var phoneNumber: String = "",
                var active: Boolean = false
        )

        data class Airport(
                var fs: String = "",
                var iata: String = "",
                var icao: String = "",
                var name: String = "",
                var city: String = "",
                var cityCode: String = "",
                var countryCode: String = "",
                var countryName: String = "",
                var regionName: String = "",
                var timeZoneRegionName: String = "",
                var localTime: String = "",
                var utcOffsetHours: Int = 0,
                var latitude: Double = 0.0,
                var longitude: Double = 0.0,
                var elevationFeet: Int = 0,
                var classification: Int = 0,
                var active: Boolean = false,
                var delayIndexUrl: String = "",
                var weatherUrl: String = ""
        )

        data class Equipment(
                var iata: String = "",
                var name: String = "",
                var turboProp: Boolean = false,
                var jet: Boolean = false,
                var widebody: Boolean = false,
                var regional: Boolean = false
        )
    }
}