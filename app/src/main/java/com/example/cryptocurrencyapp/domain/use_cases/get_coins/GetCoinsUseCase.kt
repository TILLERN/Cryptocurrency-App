package com.example.cryptocurrencyapp.domain.use_cases.get_coins

import com.example.cryptocurrencyapp.common.Resource
import com.example.cryptocurrencyapp.data.remote.dto.toCoin
import com.example.cryptocurrencyapp.domain.model.Coin
import com.example.cryptocurrencyapp.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke():Flow<Resource<List<Coin>>> = flow {
        try {
            emit(Resource.Loading())
            val coins = repository.getCoins().map { it.toCoin() }
            emit(Resource.Sucess(coins))

        } catch ( e: HttpException){
            emit(Resource.Error(e.localizedMessage?: "An unexpected error occured!"))

        } catch (e: IOException){
            emit(Resource.Error("Opps! Server couldn't be reached. Please check your internet connection!"))

        }
    }
}