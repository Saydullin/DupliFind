package com.saydullin.duplifind.domain.mapper

abstract class Mapper<From, To> {

    abstract fun map(from: From): To

}


