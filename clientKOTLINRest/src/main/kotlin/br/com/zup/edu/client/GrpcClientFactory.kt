package br.com.zup.edu.client

import br.com.zup.edu.FreteServiceGrpc
import io.grpc.ManagedChannel
import io.micronaut.context.annotation.Factory
import io.micronaut.grpc.annotation.GrpcChannel
import jakarta.inject.Singleton

@Factory
class GrpcClientFactory {
    @Singleton
    fun fretesClientStub(@GrpcChannel("frete") channel : ManagedChannel): FreteServiceGrpc.FreteServiceBlockingStub{
        return FreteServiceGrpc.newBlockingStub(channel)
    }
}