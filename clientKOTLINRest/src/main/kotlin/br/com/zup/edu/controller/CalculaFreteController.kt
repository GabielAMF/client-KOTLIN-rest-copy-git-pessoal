package br.com.zup.edu.controller

import br.com.zup.edu.CalculaFreteRequest
import br.com.zup.edu.FreteServiceGrpc
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.QueryValue
import jakarta.inject.Inject

@Controller
class CalculaFreteController (@Inject val gRpcClient : FreteServiceGrpc.FreteServiceBlockingStub) {


    @Get("/api/fretes")
    fun calcula(@QueryValue cep : String) : FreteResponse {
        println("Entrou no get")
        val request = CalculaFreteRequest.newBuilder().setCep(cep).build()

        val response = gRpcClient.calculaFrete(request)
        return FreteResponse(cep = response.cep,valor = response.valor)
    }
    data class FreteResponse(val cep: String,val valor:Double){}


}