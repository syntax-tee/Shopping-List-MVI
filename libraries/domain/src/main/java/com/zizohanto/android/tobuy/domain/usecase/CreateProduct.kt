package com.zizohanto.android.tobuy.domain.usecase

import com.zizohanto.android.tobuy.domain.exception.requireParams
import com.zizohanto.android.tobuy.domain.executor.PostExecutionThread
import com.zizohanto.android.tobuy.domain.models.Product
import com.zizohanto.android.tobuy.domain.repository.ProductRepository
import com.zizohanto.android.tobuy.domain.usecase.base.FlowUseCase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CreateProduct @Inject constructor(
    private val repository: ProductRepository,
    private val postExecutionThread: PostExecutionThread
) : FlowUseCase<String, Product>() {

    override val dispatcher: CoroutineDispatcher
        get() = postExecutionThread.io

    override fun execute(params: String?): Flow<Product> {
        requireParams(params)
        return repository.createProduct(params)
    }
}